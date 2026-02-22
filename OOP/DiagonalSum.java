import java.util.Scanner;

public class DiagonalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[3][3];

        System.out.println("Enter elements of a 3x3 matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int diagonalSum = 0;
        for (int i = 0; i < 3; i++) {
            diagonalSum += matrix[i][i];  
        }

       
        System.out.println("Sum of main diagonal elements: " + diagonalSum);

        scanner.close();
    }
}

