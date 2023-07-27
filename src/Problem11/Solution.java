package Problem11;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();
    // 2504730781961
    public static void main(String[] args) {
        //System.out.println(Long.MAX_VALUE - 483162952612010163284885);
        long n = input.nextLong();
        long m = input.nextLong();
        if (n <= 1) {
            System.out.println(n % m);
        }
        else {
            // найдём цикл, с которым повторяются остатки по модулю m
            long period = 0;
            long previous = 0, next = 1, current = 0;
            while (true) {
                current = (previous + next) % m;
                previous = next;
                next = current;
                period++;
                if (previous == 0 && current == 1) {
                    break;
                }
            }

            //System.out.println(period + " " + " period");
            long number = n % period;
            //System.out.println(number);
            previous = 0;
            next = 1;
            current = 0;
            if(number <= 1){
                System.out.println(number % m);
            }
            else {
                for (int i = 0; i < number - 1; i++) {
                    current = (previous + next) % m;
                    previous = next;
                    next = current;
                }
                System.out.println(current);
            }
        }
    }

    static class Reader extends PrintWriter {

        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
