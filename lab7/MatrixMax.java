public class MatrixMax {

    static class RowProcessor extends Thread {
        private int[] row;
        private int maxInRow;

        public RowProcessor(int[] row) {
            this.row = row;
        }

        @Override
        public void run() {
            maxInRow = row[0];
            for (int value : row) {
                if (value > maxInRow) {
                    maxInRow = value;
                }
            }
            System.out.println(Thread.currentThread().getName() +
                    " - максимальный элемент строки: " + maxInRow);
        }

        public int getMaxInRow() {
            return maxInRow;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {5, 12, 7, 1},
                {9, 4, 22, 3},
                {8, 15, 6, 11},
                {2, 17, 10, 14}
        };

        int rows = matrix.length;
        RowProcessor[] threads = new RowProcessor[rows];

        for (int i = 0; i < rows; i++) {
            threads[i] = new RowProcessor(matrix[i]);
            threads[i].setName("Поток " + (i + 1));
            threads[i].start();
        }


        for (int i = 0; i < rows; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int globalMax = threads[0].getMaxInRow();
        for (int i = 1; i < rows; i++) {
            if (threads[i].getMaxInRow() > globalMax) {
                globalMax = threads[i].getMaxInRow();
            }
        }

        System.out.println("\nОбщий максимальный элемент матрицы: " + globalMax);
    }
}
