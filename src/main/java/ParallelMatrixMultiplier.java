public class ParallelMatrixMultiplier {
    /**
     * first matrix to multiply
     */
    private int[][] matrix1;
    /**
     * second matrix to multiply
     */
    private int[][] matrix2;
    /**
     * result matrix of multiplication
     */
    private volatile int[][] res;

    /**
     *
     * @param matrix1 first matrix to multiply
     * @param matrix2 second matrix to multiply
     * @throws IllegalArgumentException if matrices cannot be multiplied
     */
    public ParallelMatrixMultiplier(int[][] matrix1, int[][] matrix2) throws IllegalArgumentException {
        if (matrix1[0].length != matrix2.length)
            throw new IllegalArgumentException();
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        res = new int[matrix1.length][matrix2[0].length];
    }

    /**
     * Creates new Thread for each row in result matrix to count and fills result matrix
     * @return result of parallel multiplication
     */
    public int[][] multiply() {
        Thread[] threads = new Thread[matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            RunnableRowMatrixMultiplier runnableRowMatrixMultiplier = new RunnableRowMatrixMultiplier(i, matrix1[i], matrix2, res);
            Thread thread = new Thread(runnableRowMatrixMultiplier);
            threads[i] = thread;
            thread.start();


        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return res;

    }

}
