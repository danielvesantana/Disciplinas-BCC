module decoder7 (
    input [3:0] In,
    output reg [6:0] Out
);

    always @(*) begin
        case (In)
            4'h0: Out = 7'b1000000;
            4'h1: Out = 7'b1111001;
            4'h2: Out = 7'b0100100;
            4'h3: Out = 7'b0110000;
            4'h4: Out = 7'b0011001;
            4'h5: Out = 7'b0010010;
            4'h6: Out = 7'b0000010;
            4'h7: Out = 7'b1111000;
            4'h8: Out = 7'b0000000;
            4'h9: Out = 7'b0010000;
            default: Out = 7'b1111111;
        endcase
    end

endmodule