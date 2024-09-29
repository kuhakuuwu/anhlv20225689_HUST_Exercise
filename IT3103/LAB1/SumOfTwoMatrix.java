import java.util.Scanner;

public class SumOfTwoMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of rows of the matrix: ");
        int row = input.nextInt();
        System.out.println("Enter number of columns of the matrix: ");
        int col = input.nextInt();

        double[][] matrix1 = new double[row][col];
        double[][] matrix2 = new double[row][col];
        double[][] sumMatrix = new double[row][col];

        int i,j;
        System.out.println("Input elements of matrix1: ");
        for (i = 0; i < row; i++){
            for (j = 0; j < col; j++){
                System.out.print("Matrix1 [" + i + "][" + j + "]: ");
                matrix1[i][j] = input.nextDouble();
            }
        }

        System.out.println("Input elements of matrix2: ");
        for (i = 0; i < row; i++){
            for (j = 0; j < col; j++){
                System.out.print("Matrix2 [" + i + "][" + j + "]: ");
                matrix2[i][j] = input.nextDouble();
            }
        }
        
        for (i = 0; i < row; i++){
            for (j = 0; j < col; j++){
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        
        System.out.println("Matrix 1: ");
        printMatrix(matrix1, row, col);
        System.out.println("Matrix 2: ");
        printMatrix(matrix2, row, col);
        System.out.println("Sum of two matrix: ");
        printMatrix(sumMatrix, row, col);

        input.close();
    }

    public static void printMatrix(double[][] matrix, int row, int col){
        int i, j;
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.printf("%.2f  ", matrix[i][j]);
            }
            System.out.print("\n");
        }
    }
}