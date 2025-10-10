module comparador_senha (
    input wire [5:0] senha_reg,
    input wire [5:0] tentativa,
	 output reg [6:0] HEX4,
	 output reg [6:0] HEX6,
	 output reg [6:0] HEX7,
    input wire clk,
    input wire rst_n,
    input wire enter,               // KEY[3]
    output reg acertou
);

    reg enter_prev;

    always @(posedge clk or negedge rst_n) begin
        if (!rst_n) begin
            acertou <= 0;
            enter_prev <= 0;
        end else begin
            enter_prev <= enter;
            if (~enter_prev & enter) begin // detecção de borda
					HEX4 = ~{
						1'b0, // segmento centro (desligado)
						tentativa[5], // segmento 1 (topo dir)
						tentativa[4], // segmento 2 (baixo dir)
						tentativa[3], // segmento 3 (baixo)
						tentativa[2], // segmento 4 (baixo esq)
						tentativa[1], // segmento 5 (topo esq)
						tentativa[0]  // segmento 6 (topo)
						};
						HEX6 = ~(senha_reg | tentativa);
						HEX7 = ~(senha_reg & tentativa);
                if (tentativa == senha_reg)
                    acertou <= 1;
            end
        end
    end
endmodule