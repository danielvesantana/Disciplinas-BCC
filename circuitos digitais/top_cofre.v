module top_cofre (
    input wire CLOCK_50,
    input wire [17:0] SW,
    input wire [3:0] KEY,
    output wire [6:0] HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7,
    output reg [17:0] LEDR,
    output reg [7:0] LEDG
);

    // Entradas
    wire [5:0] senha_input = SW[17:12];
    wire [5:0] tentativa    = SW[5:0];

    // Clock e botões
    wire clk = CLOCK_50;
    wire rst_n = KEY[1];           // reset ativo em 0
    wire rst = ~rst_n;
    wire start_btn = ~KEY[0];      // botão START
    wire enter_btn = ~KEY[3];      // botão ENTER

    // Sinais de borda
    reg start_prev, enter_prev;
    wire start_edge, enter_edge;

    always @(posedge clk or negedge rst_n) begin
        if (!rst_n) begin
            start_prev <= 0;
            enter_prev <= 0;
        end else begin
            start_prev <= start_btn;
            enter_prev <= enter_btn;
        end
    end

    assign start_edge = (~start_prev & start_btn);
    assign enter_edge = (~enter_prev & enter_btn);

    // Controle geral
    reg start_enable = 0;
    wire acertou;

    // ===== NOVO BLOCO: lógica de fim de jogo e reset interno =====
    reg fim_de_jogo;

    always @(posedge clk or negedge rst_n) begin
        if (!rst_n)
            fim_de_jogo <= 0;
        else if (acertou || tempo_esgotado)
            fim_de_jogo <= 1;
        else if (start_edge)
            fim_de_jogo <= 0;
    end

    wire reset_interno = fim_de_jogo & start_edge;
    wire rst_geral_n = rst_n && ~reset_interno;  // reset geral ativo em 0
    wire rst_geral   = ~rst_geral_n;
    // ============================================================

    // Início do jogo: ativa o cronômetro
    always @(posedge clk or negedge rst_geral_n) begin
        if (!rst_geral_n)
            start_enable <= 0;
        else if (start_edge)
            start_enable <= 1;
    end

    // Senha registrada
    wire [5:0] senha_reg;

    senha_definicao senha_gravada (
        .clk(clk),
        .rst_n(rst_geral_n),
        .sw_senha(senha_input),
        .start(start_btn),
        .senha_reg(senha_reg)
    );

    // Comparação da senha
    comparador_senha comparador (
        .senha_reg(senha_reg),
        .tentativa(tentativa),
        .clk(clk),
        .rst_n(rst_geral_n),
        .enter(enter_btn),
        .acertou(acertou), .HEX4(HEX4), .HEX6(HEX6), .HEX7(HEX7)
    );

    // Timer regressivo
    wire [3:0] min, seg_d, seg_u, ms_c;
    wire tempo_esgotado;

    timer_regressivo cronometro (
        .clk(clk),
        .rst(rst_geral),
        .start(start_enable),
        .stop(acertou),
        .min(min),
        .seg_d(seg_d),
        .seg_u(seg_u),
        .ms_c(ms_c),
        .tempo_esgotado(tempo_esgotado)
    );

    // Dica 1 (bits corretos)
    wire [5:0] leds_dica1;
    reg [5:0] dica1_valida;

    dica_bits_corretos dica1 (
        .senha_reg(senha_reg),
        .tentativa(tentativa),
        .LEDR(leds_dica1)
    );

    always @(posedge clk or negedge rst_geral_n) begin
        if (!rst_geral_n)
            dica1_valida <= 6'b000000;
        else if (enter_edge)
            dica1_valida <= leds_dica1;
    end
	 
	 // Dica 2 (AND e OR)
	 wire [5:0] and_bin, or_bin;

	 /*dica_2 dicas_logicas (
    .senha_reg(senha_reg),
    .tentativa(tentativa),
    .and_result(and_bin),
    .or_result(or_bin)
	  );
	  */
	  // bin6_to_7seg_barra hex6 (.in(or_bin),  .out(HEX6));
	  // bin6_to_7seg_barra hex7 (.in(and_bin), .out(HEX7));


    // LEDRs
    always @(posedge clk or negedge rst_geral_n) begin
        if (!rst_geral_n)
            LEDG <= 8'd0;
        else
            LEDG[7:0] <= dica1_valida;
    end

    // Controle dos LEDs vermelhos: explosão
    always @(posedge clk or negedge rst_geral_n) begin
        if (!rst_geral_n)
            LEDR <= 18'b000000000000000000;
        else if (tempo_esgotado)
            LEDR <= 18'b111111111111111111;
        else
            LEDR <= 18'b000000000000000000;
    end

    // HEX displays
    decoder7 d1 (.In(ms_c),  .Out(HEX0));
    decoder7 d2 (.In(seg_u), .Out(HEX1));
    decoder7 d3 (.In(seg_d), .Out(HEX2));
    decoder7 d4 (.In(min),   .Out(HEX3));

    assign HEX5 = 7'b1111111; // Desligado

endmodule
