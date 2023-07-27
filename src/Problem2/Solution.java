package Problem2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n1 = input.nextInt();
        int[] aX = new int[n1 + 1];
        Arrays.fill(aX, 0);
        for (int i = 0; i <= n1; i++) {
            int x = input.nextInt();
            aX[n1 - i] = x;
        }
        int n2 = input.nextInt();
        int[] bX = new int[n2 + 1];
        Arrays.fill(bX, 0);
        for (int i = 0; i <= n2; i++) {
            int x = input.nextInt();
            bX[n2 - i] = x;
        }
        //System.out.println(Arrays.toString(aX));
        //System.out.println(Arrays.toString(bX));
        int degree = Math.max(n1, n2);
        int[] answer = new int[degree + 1];
        int i = 0;
        while (i <= degree) {
            if (i > n1) {
                int x = bX[i];
                answer[i] = x;
                i++;
            } else if (i > n2) {
                int x = aX[i];
                answer[i] = x;
                i++;
            } else {
                int x = aX[i] + bX[i];
                answer[i] = x;
                i++;
            }
        }
        System.out.println(degree);
        for (int j = answer.length - 1; j >= 0; j--) {
            System.out.print(answer[j] + " ");
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
