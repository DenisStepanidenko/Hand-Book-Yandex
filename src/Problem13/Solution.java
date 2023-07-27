package Problem13;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        long m = input.nextLong();
        long n = input.nextLong();

        n += 2;
        m += 1;

        // период для модуля m = 10 равен 60

        n = n % 60;
        m = m % 60;

        long previous = 0, next = 1, currentN = 0;
        for (int i = 0; i < n - 1; i++) {
            currentN = (previous + next) % 10;
            previous = next;
            next = currentN;
        }
        // теперь в currentN последняя цифра числа F_(n+2)
        long currentM = 0;
        previous = 0;
        next = 1;
        if(m == 1){
            currentM = 1;
        }
        else {
            for (int i = 0; i < m - 1; i++) {
                currentM = (previous + next) % 10;
                previous = next;
                next = currentM;
            }
        }
        // теперь в currentM последняя цифра числа F_(m+1)
        // нужно найти последнюю цифру числа F_(n+2) - F_(m+1)

        if(currentN < currentM){
            System.out.println(10 + currentN - currentM);
        }
        else{
            System.out.println(currentN - currentM);
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
