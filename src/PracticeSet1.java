import java.util.*;

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

    //    Rotate an Array by d - Counterclockwise or Left
    public static void rotateArray(int[] arr, int d) {
        d = d % arr.length;
        rotate(arr, 0, d - 1);
        rotate(arr, d, arr.length - 1);
        rotate(arr, 0, arr.length - 1);
    }

    public static void rotate(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    //    Array after k Rotations
    public static void rotateArrayRight(int[] arr, int d) {
        d = d % arr.length;
        rotate(arr, 0, arr.length - 1);
        rotate(arr, 0, d - 1);
        rotate(arr, d, arr.length - 1);
    }

    //    Equilibrium Index
    public static int equilibriumIndex(int[] arr) {
        int leftSum = 0, rightSum = 0;
        for (int i : arr) {
            leftSum += i;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            leftSum -= arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            rightSum += arr[i];
        }
        return -1;
    }

    //    Check if an array is subset of another array
    public static boolean isSubset(int[] arr, int[] nums) {
        Arrays.sort(arr);
        Arrays.sort(nums);

        int i = 0, j = 0, m = arr.length, n = nums.length;
        while (i < m && j < n) {
            if (arr[i] < nums[j]) {
                i++;
            } else if (arr[i] == nums[j]) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return j == n;
    }

    public static boolean isSubsetOptimal(int[] arr, int[] arr1) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (int i : arr1) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.print("Enter the size of Array: ");
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        System.out.print("Enter the " + n + " value of Array: ");
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.println("The Array is: " + Arrays.toString(arr));
//        System.out.println("The first Non-Repeating Character in the Array is: " + firstNonRepeating(arr));
//        rotateArray(arr, 2);
//        System.out.print("The Rotated Array is: " + Arrays.toString(arr));
        int[] arr = {1, 2, 0, 3};
        System.out.println(equilibriumIndex(arr));
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        rotateArrayRight(arr1, 2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(isSubset(arr1, arr));
        System.out.println(isSubsetOptimal(arr, arr1));
    }
}
