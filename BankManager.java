import java.util.ArrayList;
import java.util.List;

public class BankManager implements BankingService {
    private List<Account> accounts;

    public BankManager() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    @Override
    public double checkBalance(String accountNumber) {
        Account acc = findAccount(accountNumber);
        return (acc != null) ? acc.getBalance() : -1;
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
        // Add this method inside your BankManager class
    @Override
    public void showStatement(String accountNumber) {
        Account acc = findAccount(accountNumber);
        if (acc != null) {
            acc.showStatement();
        } else {
            System.out.println("Account not found!");
        }
    }
    @Override
    public void viewAllAccounts() {
        System.out.println("\n--- ADMINISTRATIVE REPORT: ALL ACCOUNTS ---");
        double totalBankLiquidity = 0;
        for (Account acc : accounts) {
            System.out.println("ID: " + acc.getAccountNumber() + 
                               " | Holder: " + acc.getAccountHolder() + 
                               " | Balance: ₹" + acc.getBalance());
            totalBankLiquidity += acc.getBalance();
        }
        System.out.println("-------------------------------------------");
        System.out.println("Total Bank Liquidity: ₹" + totalBankLiquidity);
    }
    @Override
    public boolean transfer(String fromAccNum, String toAccNum, double amount) {
        Account sender = findAccount(fromAccNum);
        Account receiver = findAccount(toAccNum);

        if (sender != null && receiver != null) {
            if (sender.withdraw(amount)) { // Try to take money from sender
                receiver.deposit(amount); // Give money to receiver
                sender.addTransaction("Transfer to " + toAccNum + ": ₹" + amount);
                receiver.addTransaction("Transfer from " + fromAccNum + ": ₹" + amount);
                return true;
            } else {
                System.out.println("Transfer failed: Insufficient balance.");
            }
        } else {
            System.out.println("Transfer failed: One or both accounts not found.");
        }
        return false;
    }
}
