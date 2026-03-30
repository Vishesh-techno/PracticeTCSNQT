import java.util.Arrays;
import java.util.Scanner;

public class PracticeSet5 {
    public static boolean isPerfectPlusNumber(int n) {
        int temp = n;
        int sum = 0, product = 1;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum + product == n;
    }

    public static boolean isArmstrongNumber(int n) {
        int temp = n;
        int order = 0;
        while (temp != 0) {
            temp /= 10;
            order++;
        }
        int t = n;
        int armSum = 0;
        while (t != 0) {
            int digit = t % 10;
            int mul = 1;
            for (int i = 0; i < order; i++) {
                mul *= digit;
            }
            armSum = armSum + mul;
            t /= 10;
        }
        return armSum == n;
    }

    //    Find first & last occurrence of an element in array
    public static int[] firstAndLastOccurence(int[] arr, int target) {
        int[] ans = new int[2];
        ans[0] = search(arr, target, true);
        ans[1] = search(arr, target, false);
        return ans;
    }

    public static int search(int[] arr, int target, boolean isLeft) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = mid;
                if (isLeft) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public static int decToBin(int n){
        int ans = 0;
        int place = 1;
        while(n > 0){
            int rem = n % 2;
            ans = ans + (rem * place);
            place = place * 10;
            n = n / 2;
        }
        return ans;
    }

    public static int binToDec(int n){
//        int ans = 0;
//        while(n > 0){
//            int digit = n % 10;
//            ans = ans * 2 + digit;
//            n /= 10;
//        }
//        return ans;
        int ans = 0;
        int power = 0;

        while(n > 0){
            int lastDigit = n % 10;
            ans += (int) (lastDigit * Math.pow(2, power));
            power++;
            n /= 10;
        }

        return ans;
    }

    public static int fib(int n){
        int ans = 0;
        int a = 0, b = 1;
        for(int i=2; i<=n; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static int hcf(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b){
        return (a*b)/hcf(a, b);
    }

    public static double coordinateDistance(int x1, int y1, int x2, int y2){
        int dx = x2 - x1;
        int dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isPerfectPlusNumber(n));
        System.out.println(isArmstrongNumber(n));
        int[] arr = {1,2,2,2,3,4};
        int target = 2;
        System.out.println(Arrays.toString(firstAndLastOccurence(arr, target)));
        System.out.println(decToBin(13));
        System.out.println(binToDec(1101));
        System.out.println(fib(11));
        System.out.println(coordinateDistance(4,5,6,8));
    }
}