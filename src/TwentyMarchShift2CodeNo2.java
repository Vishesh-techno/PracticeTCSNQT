import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwentyMarchShift2CodeNo2 {
//    You are building a Transaction Monitoring System for a financial
//    platform.The system processes N transactions.Each transaction
//    contains the following 4parameters:
//    Sender(string)
//    Receiver(string)
//    Timestamp(integer, in seconds)
//    Amount(integer)
//
//    Rules:
//    1.Duplicate Transaction Check
//    If any transaction has the same sender AND receiver as a previous transaction,
//    print: Error: Duplicate Transaction. Terminate the program.
//
//    2. Fraud Detection
//    If the difference between the timestamps of any two consecutive transactions is greater than 60 seconds,
//    print: Fraud Detected and terminate the program.

//    3.Valid Case
//    If all transactions are valid, print: All Transactions Valid

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Set<String> set = new HashSet<>();
        int prevTime = -1;
        for(int i=0; i<N; i++){
            String sender = sc.next();
            String reciever = sc.next();
            int timestamp = sc.nextInt();
            int amount = sc.nextInt();

            String SR = sender + "-" + reciever;

            if(set.contains(SR)){
                System.out.println("Duplicate Transaction");
                return;
            }else{
                set.add(SR);
            }

            if(prevTime != -1 && timestamp - prevTime > 60){
                System.out.println("Fraud Detected");
                return;
            }
            prevTime = timestamp;
        }
        System.out.println("All Transactions valid!!");
    }
}
