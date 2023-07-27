package Problem12;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    static Reader input = new Reader();

    public static void main(String[] args) {
        //System.out.println(10%10);
        long n = input.nextLong();
        n += 2;
        //System.out.println(n);
        // период для модуля m = 10 равен 60
        long number = n % 60;
        long previous = 0 , next = 1 , current = 0;
        if(number == 0 || number == 1){
            current = number;
        }
        else {
            for (int i = 0; i < number - 1; i++) {
                current = (previous + next) % 10;
                previous = next;
                next = current;
            }
        }
        if(current == 0){
            System.out.println(9);
        }
        else{
            System.out.println(current - 1);
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
