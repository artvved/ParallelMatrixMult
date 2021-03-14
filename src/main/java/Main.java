public class Main {
    public static void main(String[] args) {
        int[][] m1 = new int[][]{
                {3, -1, 2},
                {4, 2, 0},
                {-5, 6, 1}};


        int[][] m2 = new int[][]{
                {8},
                {7},
                {2}};

        ParallelMatrixMultiplier p=new ParallelMatrixMultiplier(m1,m2);
        int[][] res=p.multiply();

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.println(res[i][j]);
            }
            System.out.println("|");
        }


    }
}