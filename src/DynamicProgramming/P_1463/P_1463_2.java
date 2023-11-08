package DynamicProgramming.P_1463;

import java.util.Scanner;

public class P_1463_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] dp = new int[N + 1];
        int result = calculateMincnt(N, dp);
        System.out.println(result);
    }

    public static int calculateMincnt(int num, int[] dp) {
        if (num == 1) {
            return 0;
        }

        if (dp[num] > 0) {
            return dp[num];
        }

        int minCnt = calculateMincnt(num - 1, dp) + 1;

        if (num % 2 == 0) {
            int cntDivBy2 = calculateMincnt(num / 2, dp) + 1;
            minCnt = Math.min(minCnt, cntDivBy2);
        }

        if (num % 3 == 0) {
            int cntDivBy3 = calculateMincnt(num / 3, dp) + 1;
            minCnt = Math.min(minCnt, cntDivBy3);
        }

        dp[num] = minCnt;
        return minCnt;
    }
}
