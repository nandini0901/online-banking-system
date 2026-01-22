public interface BankingService {
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    double checkBalance(String accountNumber);
    void showStatement(String accountNumber);
    void viewAllAccounts();
    boolean transfer(String fromAcc, String toAcc, double amount);
}