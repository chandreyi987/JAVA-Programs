import java.util.*;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ", Balance: " + balance);
        } else {
            System.out.println("Insufficient balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                account.deposit(500);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                account.withdraw(700);
            }
        });

        t1.start();
        t2.start();
    }
}
