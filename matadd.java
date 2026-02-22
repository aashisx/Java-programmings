public class matadd {
    public static void main(String[] args) {
        int[][] matrix1= {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int sum=0;
        for (int i = 0; i <3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += matrix1[i][j];
            }
        }
            System.out.println("sum of matrix elements: " + sum);

    }
}
