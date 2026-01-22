import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private String pin;
    private double balance;
    private List<String> transactionHistory; // New field

    public Account(String accountNumber, String accountHolder, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account opened with balance: ₹" + balance);
    }

    public boolean validatePin(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void addTransaction(String message) {
        transactionHistory.add(message);
    }

    public void showStatement() {
        System.out.println("\n--- Transaction History for " + accountHolder + " ---");
        for (String record : transactionHistory) {
            System.out.println(record);
        }
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public String getAccountHolder() { return accountHolder; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposited: ₹" + amount + " | Balance: ₹" + balance);
            FileHandler.saveBalance(this.balance); // AUTO-SAVE
            System.out.println("Success! Deposited: ₹" + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdrawn: ₹" + amount + " | Balance: ₹" + balance);
            FileHandler.saveBalance(this.balance);
            System.out.println("Success! Withdrawn: ₹" + amount);
            return true;
        }
        System.out.println("Insufficient funds!");
        return false;
    }
}