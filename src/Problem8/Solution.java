package Problem8;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    // -3 -2 -1 0 0 100


    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        // нужно хранить четыре самых максимальных и 4 самых минимальных
        long max1 = Long.MIN_VALUE, max2 = Long.MIN_VALUE, max3 = Long.MIN_VALUE, max4 = Long.MIN_VALUE;
        long min1 = Long.MAX_VALUE, min2 = Long.MAX_VALUE, min3 = Long.MAX_VALUE, min4 = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long x = input.nextLong();
            if (x > max1) {
                max4 = max3;
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max4 = max3;
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max4 = max3;
                max3 = x;
            } else if (x > max4) {
                max4 = x;
            }


            if (x < min1) {
                min4 = min3;
                min3 = min2;
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min4 = min3;
                min3 = min2;
                min2 = x;
            } else if (x < min3) {
                min4 = min3;
                min3 = x;
            } else if (x < min4) {
                min4 = x;
            }

        }

        System.out.println(Math.max(Math.max(max1 * max2 * max3 * max4, min1 * min2 * min3 * min4), min1 * min2 * max1 * max2));
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
