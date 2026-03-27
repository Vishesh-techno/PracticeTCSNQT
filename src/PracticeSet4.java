public class PracticeSet4 {
//    Reverse a String
    public static void reverseString(String s){
        StringBuilder t = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--){
            t.append(s.charAt(i));
        }
        System.out.println(t);
    }

//    The gym plans like 1 month = 2000, 3 months = 5000, 6 months = 8000,
//    9 months = 11000, 12 months = 12000. We had to take input n (months) and print cost.
//    In my question it felt like n should match these values, otherwise print "Error".
    public static void gymFees(int n){
        if(n < 0){
            System.out.println("Error or Invalid Input");
        }else if(n >= 1 && n <= 2){
            System.out.println("Cost: 2000");
        }else if(n >= 3 && n <= 5){
            System.out.println("Cost: 5000");
        }else if(n >= 6 && n <= 8){
            System.out.println("Cost: 8000");
        }else if(n >=  9&& n <= 11){
            System.out.println("Cost: 11000");
        }else if(n == 12){
            System.out.println("Cost: 12000");
        }else{
            System.out.println("Invalid Months");
        }
    }

    public static void main(String[] args) {
        String s = "Geeks";
        reverseString(s);
//        System.out.println(s);
        gymFees(7);
    }
}
