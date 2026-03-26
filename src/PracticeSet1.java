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

    //  Array Reverse
    public static void reverseArray(int[] arr) {
        rotate(arr, 0, arr.length - 1);
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

    //    Mean and Median of an Array
    public static int mean(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum / arr.length;
    }

    public static int median(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int res = 0;
        if (n % 2 == 0) {
            res = (arr[n / 2] + arr[(n / 2) - 1]) / 2;
        } else {
            res = arr[n / 2];
        }
        return res;
    }

    //    Find the smallest and second smallest elements in an array
    public static ArrayList<Integer> smallestAndSecondSmallest(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int small = Integer.MAX_VALUE;
        int secSmall = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < small) {
                secSmall = small;
                small = nums[i];
            } else if (nums[i] > small && nums[i] < secSmall) {
                secSmall = nums[i];
            }
        }
        list.add(small);
        list.add(secSmall);
        return list;
    }

    //    Counting frequencies of array elements
    public static Map<Integer, Integer> countFreq(int[] arr) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(entry.getKey());     // element
//            list.add(entry.getValue());   // frequency
//            res.add(list);
//        }
//        return res;
        return map;
    }

    //    Remove duplicates from Sorted Array
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int i = 0;

        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }

        return i + 1; // new length
    }

    //    Find duplicates in O(n) time and O(n) extra space
    public static ArrayList<Integer> findDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
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
        reverseArray(arr1);
        System.out.println(Arrays.toString(arr1));
        int[] arr2 = {2, 3, 4, 8};

        int meanValue = mean(arr2);
        int medianValue = median(arr2);

        System.out.println(meanValue + " " + medianValue);

        int[] arr3 = {12, 25, 8, 55, 10, 33, 17, 11};
        ArrayList<Integer> result = smallestAndSecondSmallest(arr3);

        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] arr4 = {10, 20, 10, 5, 20};
        System.out.println(countFreq(arr4));

        int[] arr5 = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int newLength = removeDuplicates(arr5);

        for (int i = 0; i < newLength; i++) {
            System.out.print(arr5[i] + " ");
        }

        System.out.println();

        int[] arr6 = {1, 6, 5, 2, 3, 3, 2};
        List<Integer> duplicates = findDuplicates(arr6);

        for (int element : duplicates) {
            System.out.print(element + " ");
        }
    }
}
