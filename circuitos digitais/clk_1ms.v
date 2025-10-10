module clk_1ms (
    input clk,          // clock de 50MHz
    input rst,
    output reg tick_1ms
);
    reg [15:0] count;

    always @(posedge clk or posedge rst) begin
        if (rst) begin
            count <= 0;
            tick_1ms <= 0;
        end else if (count == 49999) begin
            count <= 0;
            tick_1ms <= 1;
        end else begin
            count <= count + 1;
            tick_1ms <= 0;
        end
    end
endmodule
