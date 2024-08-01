import java.util.Scanner;

public class printSquareSpiral {
    public static void printSquareSpiral(int[][] mat, int n) {
        int i = 0;
        int j = 0;

        int steps = n - 1;

        while (steps >= 1) {
            for (int k = 0; k < steps; k++) {
                System.out.print(mat[i][j] + " ");
                j++;
            }

            for (int k = 0; k < steps; k++) {
                System.out.print(mat[i][j] + " ");
                i++;
            }

            for (int k = 0; k < steps; k++) {
                System.out.print(mat[i][j] + " ");
                j--;
            }

            for (int k = 0; k < steps; k++) {
                System.out.print(mat[i][j] + " ");
                i--;
            }

            // Prep for next boundary
            i++;
            j++;
            steps = steps - 2;
        }

        if (steps == 0) {
            System.out.print(mat[i][j] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scn.nextInt();
            }
        }

        printSquareSpiral(mat, n);

    }
}
