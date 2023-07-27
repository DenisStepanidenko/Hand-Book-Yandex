package Problem5;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            arr[i] = x;
        }
        int index1 = 0, index2 = 0;
        long maxNumber = -1;
        // нужно найти два максимальных числа
        // найдём за O(2n)

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxNumber) {
                maxNumber = arr[i];
                index1 = i;
            }
        }
        // нашли максимальное число
        long maxNumber2 = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > maxNumber2 && index1 != i){
                maxNumber2 = arr[i];
            }
        }

        System.out.println(maxNumber2 * maxNumber);

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
