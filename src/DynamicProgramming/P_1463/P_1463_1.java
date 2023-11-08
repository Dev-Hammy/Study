package DynamicProgramming.P_1463;
import java.util.Scanner;

public class P_1463_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Calc_unit calc_main = new Calc_unit(N);
        calc_main.log_validation();
        System.out.println(Calc_unit.mincnt);
    }

    public static class Calc_unit {
        private int input;
        private int cnt;
        private final int[] units = {3, 2};
        private static int mincnt = (int) Double.POSITIVE_INFINITY;

        public Calc_unit(int input) {
            this.input = input;
        }

        public void SaveResult() {
            //System.out.println("Save " + Calc_unit.mincnt + " " + this.cnt);
            if (this.cnt < Calc_unit.mincnt) {
                Calc_unit.mincnt = this.cnt;
            }
        }

        public void log_validation() {
            for (int unit : this.units) {
                double val = Math.log(this.input) / Math.log(unit);
                double floorval = Math.floor(val);
                double ceilval = Math.ceil(val);

                if (val == floorval || val == ceilval) {
                    long roundval = Math.round(val);
                    int res = (int) roundval;
                    this.cnt = this.cnt + res;
                    this.input = 1;
                    SaveResult();
                    return;
                }
                //System.out.println("log " + Calc_unit.mincnt + " " + this.cnt);
            }
            mod_validation();
        }

        public void mod_validation() {
            for (int unit : this.units) {

                if (this.input % unit > 0) {
                    this.input = this.input - 1;
                    this.cnt = this.cnt + 1;
                    log_validation();
                    //System.out.println("sub one " + Calc_unit.mincnt + " " + this.cnt);
                } else {
                    this.input = this.input / unit;
                }

                if (this.input == 1) {
                    SaveResult();
                }
                //System.out.println("mod " + Calc_unit.mincnt + " " + this.cnt);

            }
        }
    }
}
