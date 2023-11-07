package by_Type_DynmaicProgramming.problem;

/*
상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다.
설탕공장에서 만드는 설탕은 봉지에 담겨져 있다.
봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.

상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다.
예를 들어, 18킬로그램 설탕을 배달해야 할 때,
3킬로그램 봉지 6개를 가져가도 되지만,
5킬로그램 3개와 3킬로그램 1개를 배달하면,
더 적은 개수의 봉지를 배달할 수 있다.

상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때,
봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.

입력 : 첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
출력 : 상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.
 */

/*
예제 1
입력 : 18
출력 : 4

예제 2
입력 : 4
출력 : -1

예제 3
입력 : 6
출력 : 2

예제 4
입력 : 9
출력 : 3

예제 5
입력 : 11
출력 : 3

 */

import java.util.Scanner;

public class P_2839 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        int unit_a = 3;
        int unit_b = 5;

        int q = input / unit_b;
        int r = input % unit_b;

        if (r % unit_a != 0) {
            for (q = q-1; q >= 0; q--) {
                int amount = unit_b * q;
                if ((input - amount) % unit_a == 0) {
                    int result = q + (input - amount) / unit_a;
                    System.out.println(result);
                    return;
                }
            }
            System.out.println(-1);
        } else {
            System.out.println(q + r / unit_a);
        }
    }
}
