import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PracticeSet1 {
    static Scanner sc = new Scanner(System.in);

    //    Find first non-repeating element in a given Array of integers
    public static int firstNonRepeating(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i : arr) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.print("Enter the size of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the " + n + " value of Array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("The Array is: " + Arrays.toString(arr));
        System.out.println("The first Non-Repeating Character in the Array is: " + firstNonRepeating(arr));
    }
}
