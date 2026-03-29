import java.util.Scanner;

public class CodingQuestion {
    public static long fact(long n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static double areaOfCircle(int r) {
        return ((double) 22 / 7) * r * r;
    }

    public static int hcf(int a, int b) {
        int min = Math.min(a, b);
        int gcd = 1;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int max(int a, int b, int c) {
        if (a > b && a > c) {
            return a;
        } else if (b > a && b > c) {
            return b;
        } else {
            return c;
        }
    }

    public static int min(int a, int b, int c, int d) {
        if (a < b && a < c && a < d) {
            return a;
        } else if (b < a && b < c && b < d) {
            return b;
        } else if (c < a && c < b && c < d) {
            return c;
        } else {
            return d;
        }
    }

    public static int getDays(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
//        System.out.println(fact(n));
        System.out.println(areaOfCircle((int) n));
        System.out.println(hcf(12, 18));
        int x = sc.nextInt();
        System.out.println(isPrime(x));
        int range = sc.nextInt();
        int ans = 0;
        for (int i = 2; i <= range; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                ans += i;
            }
        }
        System.out.println();
        System.out.println(ans);
        System.out.println(max(5, 15, 6));
        System.out.println(min(5, 4, 3, 15));
        System.out.println(getDays(2, 2024));
    }
}
