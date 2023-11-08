package DynamicProgramming.P_2839;


import java.util.Scanner;

public class P_2839_1 {
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
