module dica_bits_corretos (
    input wire [5:0] senha_reg,
    input wire [5:0] tentativa,
    output reg [5:0] LEDR
);
    integer i;
    reg [2:0] count;

    always @(*) begin
        count = 0;
        for (i = 0; i < 6; i = i + 1) begin
            if (senha_reg[i] == tentativa[i])
                count = count + 1;
        end

        // Exibe uma barra de LEDs proporcional à contagem
        case (count)
            0: LEDR = 6'b000000;
            1: LEDR = 6'b000001;
            2: LEDR = 6'b000011;
            3: LEDR = 6'b000111;
            4: LEDR = 6'b001111;
            5: LEDR = 6'b011111;
            6: LEDR = 6'b111111;
            default: LEDR = 6'b000000;
        endcase
    end
endmodule