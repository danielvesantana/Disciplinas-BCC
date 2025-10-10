module timer_regressivo (
    input clk,
    input rst,
    input start,
    input stop,
    output reg [3:0] min,
    output reg [3:0] seg_d,
    output reg [3:0] seg_u,
    output reg [3:0] ms_c,
    output reg tempo_esgotado  // << saída que indica quando tempo chegou a 0
);

    wire tick_1ms;
    reg counting;

    reg start_reg, stop_reg;
    wire start_edge, stop_edge;

    // Divisor de clock 1ms
    clk_1ms clk_div (
        .clk(clk),
        .rst(rst),
        .tick_1ms(tick_1ms)
    );

    // Detecção de borda (rising edge)
    always @(posedge clk) begin
        start_reg <= start;
        stop_reg <= stop;
    end

    assign start_edge = (start_reg == 0 && start == 1);
    assign stop_edge  = (stop_reg == 0 && stop == 1);

    // Contador interno para gerar 100ms
    reg [6:0] ms_counter;

    always @(posedge clk or posedge rst) begin
        if (rst) begin
            min      <= 4'd2;
            seg_d    <= 4'd5;
            seg_u    <= 4'd9;
            ms_c     <= 4'd9;
            ms_counter <= 0;
            counting <= 0;
            tempo_esgotado <= 0;
        end else begin
            if (start_edge) begin
                counting <= 1;
                tempo_esgotado <= 0;  // << zera o sinal ao iniciar
            end else if (stop_edge) begin
                counting <= 0;
            end

            if (tick_1ms && counting) begin
                if (min == 0 && seg_d == 0 && seg_u == 0 && ms_c == 0 && ms_counter == 0) begin
                    counting <= 0;
                    tempo_esgotado <= 1;  // << ativa quando chega a 0
                end else begin
                    if (ms_counter == 99) begin
                        ms_counter <= 0;

                        if (ms_c == 0) begin
                            ms_c <= 9;
                            if (seg_u == 0) begin
                                seg_u <= 9;
                                if (seg_d == 0) begin
                                    seg_d <= 5;
                                    if (min != 0)
                                        min <= min - 1;
                                end else begin
                                    seg_d <= seg_d - 1;
                                end
                            end else begin
                                seg_u <= seg_u - 1;
                            end
                        end else begin
                            ms_c <= ms_c - 1;
                        end

                    end else begin
                        ms_counter <= ms_counter + 1;
                    end
                end
            end
        end
    end
endmodule
