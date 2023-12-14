import java.util.ArrayList;

public class GoldenRatio {
    public static ArrayList<Integer> findNth(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("Input must be a positive integer");
        }

        ArrayList<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(0);
        fibonacciList.add(1);

        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;

        for (int i = 2; i <= num; i++) {
            int fib = (int) Math.round((Math.pow(phi, i) - Math.pow(-phi, -i)) / sqrt5);
            fibonacciList.add(fib);
        }

        return fibonacciList;
    }

    public static void main(String[] args) {
        int n = 10; // Change this to calculate a different number of Fibonacci numbers
        ArrayList<Integer> fibList = findNth(n);
        
        for (int fib : fibList) {
            System.out.print(fib + " ");
        }
        System.out.println();
    }
}
