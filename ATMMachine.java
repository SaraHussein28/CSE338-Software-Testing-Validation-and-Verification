//import required classes and packages   
import java.util.Scanner;

//create ATMExample class to implement the ATM functionality  
public class ATMMachine {
        int balance = 1000;

        public int getBalance() {
        return balance;
        }

        public boolean withdraw(int amount){
            if(balance >= amount)
            {
                balance = balance - amount;
                return true;
            }
            return false;
        }


        public boolean deposit(int amount){
            balance = balance + amount;
            return true;
        }

        public int displayBalance(){
            return getBalance();
        }


}  