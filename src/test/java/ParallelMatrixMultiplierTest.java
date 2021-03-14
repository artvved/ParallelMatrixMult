import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParallelMatrixMultiplierTest {


    @Test
    void multiply() {
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
        assertArrayEquals(res,new int[][]{{21},{46},{4}});

         m1 = new int[][]{
                 {1,2},
                 {3,4}};


        m2 = new int[][]{
                {5,6},
                {7,8}};

        p=new ParallelMatrixMultiplier(m1,m2);
        res=p.multiply();
        assertArrayEquals(res,new int[][]{
                {19,22},
                {43,50}});

    }
}