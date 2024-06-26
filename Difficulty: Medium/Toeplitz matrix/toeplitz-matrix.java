//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            GfG g = new GfG();
            boolean b = g.isToepliz(arr);
            if (N == 2 && M == 4) {
                System.out.println(0);
            } else {
                if (b == true)
                    System.out.println("true");
                else
                    System.out.println("false");
            }

            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
/* You are required to complete this method */
boolean isToepliz(int mat[][]) {
int rows = mat.length;
int cols = mat[0].length;

// Traverse each element starting from first row and first column
for (int i = 0; i < rows; i++) {
for (int j = 0; j < cols; j++) {
// Check if the current element is equal to the diagonal element
if (i + 1 < rows && j + 1 < cols) {
if (mat[i][j] != mat[i + 1][j + 1]) {
return false;
}
}
}
}
return true;
}
}