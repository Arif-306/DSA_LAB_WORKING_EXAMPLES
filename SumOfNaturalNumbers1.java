public class MatrixAddition {
     public static void main(String[] args) {
         int[][] matrixA = {
             {1,2,3},
             {4,5,6},
             {7,8,9}
         };
         int[][] matrixB = {
             {9,8,7},
             {6,5,4},
             {3,2,1}
         };
         
         int[][] result = new int[3][3];
         
         result[0][0] = matrixA[0][0] + matrixB[0][0];
        result[0][1] = matrixA[0][1] + matrixB[0][1];
        result[0][2] = matrixA[0][2] + matrixB[0][2];
        
        result[1][0] = matrixA[1][0] + matrixB[1][0];
        result[1][1] = matrixA[1][1] + matrixB[1][1];
        result[1][2] = matrixA[1][2] + matrixB[1][2];
        
        result[2][0] = matrixA[2][0] + matrixB[2][0];
        result[2][1] = matrixA[2][1] + matrixB[2][1];
        result[2][2] = matrixA[2][2] + matrixB[2][2];

        System.out.println("Resultant Matrix After Addition:");
        System.out.println(result[0][0] + " " + result[0][1] + " " + result[0][2]);
        System.out.println(result[1][0] + " " + result[1][1] + " " + result[1][2]);
        System.out.println(result[2][0] + " " + result[2][1] + " " + result[2][2]);
     }
}