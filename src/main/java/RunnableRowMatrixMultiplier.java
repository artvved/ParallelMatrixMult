/**
 * class that multiplies row and matrix and fills one row in res matrix with the results of multiplication
 */
public class RunnableRowMatrixMultiplier implements Runnable{
    /**
     * number of row in res matrix to fill
     */
    private  int rowNumber;
    /**
     * row to multiply
     */
    private int[] row;
    /**
     * matrix to multiply
     */
    private int[][] matrix2;
    /**
     * matrix where 1 row will be filled after multiplication
     */
    private int[][] res;

    public RunnableRowMatrixMultiplier(int rowNumber, int[] row, int[][] matrix2, int[][] res) {
        this.rowNumber = rowNumber;
        this.row = row;
        this.matrix2 = matrix2;
        this.res = res;
    }

    /**
     * method that multiplies row and matrix and fills one particular row in res matrix with the results of multiplication
     */
    @Override
    public void run() {
        for (int i = 0; i < matrix2[0].length; i++) {
            int cell=0;
            for (int j = 0; j < row.length; j++) {
                cell+=row[j]*matrix2[j][i];
            }

            res[rowNumber][i]=cell;
        }



    }
}
