package DynamicProgramming.P_1463;

import java.util.Scanner;

public class P_1463_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] dp = new int[N + 1];
        int result = calculateMincnt(N, dp);
        System.out.println(result);
    }

    public static int calculateMincnt(int num, int[] dp) {
        dp[1] = 0;
        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        return dp[num];
    }
}
