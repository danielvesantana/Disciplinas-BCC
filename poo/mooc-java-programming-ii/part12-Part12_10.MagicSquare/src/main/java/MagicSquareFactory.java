public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        if (size % 2 == 0) {
            throw new IllegalArgumentException("O método Siamês só funciona para ordens ímpares.");
        }

        MagicSquare square = new MagicSquare(size);

        int row = 0;
        int col = size / 2;

        for (int num = 1; num <= size * size; num++) {

            square.placeValue(row, col, num);

            int nextRow = (row - 1 + size) % size;
            int nextCol = (col + 1) % size;

            if (square.readValue(nextRow, nextCol) != 0) {
                row = (row + 1) % size;
            } else {
                row = nextRow;
                col = nextCol;
            }
        }

        return square;
    }
}
