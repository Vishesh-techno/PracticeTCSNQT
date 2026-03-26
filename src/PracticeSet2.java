import java.util.ArrayList;

public class PracticeSet2 {
    //    Prime factors of a number
    public static ArrayList<Integer> primeFactors(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                list.add(i);
                num = num / i;
            }
        }
        return list;
    }

    //    Check for Prime Number
    public static boolean isPrime(int num) {
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    //    Find largest prime factor of a number
    public static int largestPrimeFactors(int num) {
        int large = 1;
        for (int i = 2; i <= num; i++) {
            while (num % i == 0) {
                large = Math.max(large, i);
                num = num / i;
            }
        }
        return large;
    }

    public static void main(String[] args) {
        System.out.println(primeFactors(5122));
        System.out.println(isPrime(81));
        System.out.println(largestPrimeFactors(5122));
    }
}
