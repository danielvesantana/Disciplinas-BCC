module senha_definicao (
    input wire clk,
    input wire rst_n,
    input wire [5:0] sw_senha,
    input wire start,               // KEY[0]
    output reg [5:0] senha_reg
);

    reg start_prev;

    always @(posedge clk or negedge rst_n) begin
        if (!rst_n) begin
            senha_reg <= 6'b0;
            start_prev <= 0;
        end else begin
            start_prev <= start;
            if (~start_prev & start) begin // detecção de borda de subida
                senha_reg <= sw_senha;
            end
        end
    end
endmodule