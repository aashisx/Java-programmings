import java.util.Scanner;
import java.util.Arrays;


public class Accesselement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter length of an array:");
        int length = scanner.nextInt();

        int[] arr = new int[length];
        System.out.println("Enter " + length + " elements of the array:");
        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println("Your array is: " + Arrays.toString(arr));

        System.out.println("Enter the index of the element you want to access from 0 to " + (length - 1));
        int index = scanner.nextInt();
        try {
            if (index < 0 || index >= length) {
                throw new ArrayIndexOutOfBoundsException("Incorrect Index");
            }
            System.out.println("Element at index " + index + " is: " + arr[index]);
        }
         catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();

    }
}
