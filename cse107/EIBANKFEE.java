import java.io.*;
import java.util.*;

/*
 * input amount and number of transaction
 * output the minimum fee
 * 
 */

class EIBANKFEE {

    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        int test = ni();
        int checks = 0;
        double fee = 0.0;
        while (test-- > 0) {
            double amount = nd();
            int nCheck = ni();

            checks += nCheck;
            fee += countFee(amount, nCheck);
        }
        if (checks == 0) {
            System.out.println("0.00");
        } else {
            System.out.println(String.format("%.3f", fee / checks));
        }
    }

    public static double countFee(double amount, int nCheck) {
        double fee = 0.0;
        if (amount < 500.0) {
            fee += 12.0 + 0.20 * nCheck;
        }
        if (amount >= 500 && amount < 2000) {
            fee += 7.50 + 0.20 * nCheck;
        }
        if (amount >= 2000 && amount < 5000) {
            fee += 5.00 + 0.10 * nCheck;
        }
        if (amount >= 5000) {
            fee = 0.0;
        }
        return fee;
    }

    static InputStream is = System.in;
    static byte[] inbuf = new byte[1 << 24];
    static int lenbuf = 0, ptrbuf = 0;

    static int readByte() {
        if (lenbuf == -1)
            throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0)
                return -1;
        }
        return inbuf[ptrbuf++];
    }

    static boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }

    static int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b))
            ;
        return b;
    }

    static double nd() {
        return Double.parseDouble(ns());
    }

    static char nc() {
        return (char) skip();
    }

    static String ns() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    static char[] ns(int n) {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while (p < n && !(isSpaceChar(b))) {
            buf[p++] = (char) b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }

    static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    static long nl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
            ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

}
