import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        BankManager bank = new BankManager();
        Scanner scanner = new Scanner(System.in);

        // Setup: Load saved balance for primary user, create secondary user for transfers
        double savedBalance = FileHandler.loadBalance();
        bank.addAccount(new Account("1001", "User One", "1234", savedBalance));
        bank.addAccount(new Account("1002", "User Two", "5678", 5000.0));

        System.out.println("======= SECURE CLOUD BANKING SYSTEM =======");
        
        try {
            System.out.print("Enter Account Number (or 'admin'): ");
            String enteredAcc = scanner.next();
            System.out.print("Enter 4-Digit PIN: ");
            String enteredPin = scanner.next();

            if (enteredAcc.equalsIgnoreCase("admin") && enteredPin.equals("9999")) {
                System.out.println("\n🛠️ ADMIN ACCESS GRANTED");
                bank.viewAllAccounts();
            } else {
                Account currentAccount = bank.findAccount(enteredAcc);

                if (currentAccount != null && currentAccount.validatePin(enteredPin)) {
                    System.out.println("\n✅ Login Successful! Welcome, " + currentAccount.getAccountHolder());
                    
                    boolean running = true;
                    while (running) {
                        System.out.println("\n--- SERVICES ---");
                        System.out.println("1. Balance | 2. Deposit | 3. Withdraw");
                        System.out.println("4. Transfer Money | 5. Mini-Statement | 6. Logout");
                        System.out.print("Select: ");

                        if (!scanner.hasNextInt()) { scanner.next(); continue; }
                        int choice = scanner.nextInt();

                        switch (choice) {
                            case 1: System.out.println("Balance: ₹" + currentAccount.getBalance()); break;
                            case 2:
                                System.out.print("Amount: ₹");
                                currentAccount.deposit(scanner.nextDouble());
                                break;
                            case 3:
                                System.out.print("Amount: ₹");
                                currentAccount.withdraw(scanner.nextDouble());
                                break;
                            case 4:
                                System.out.print("Enter Recipient Account Number: ");
                                String toAcc = scanner.next();
                                System.out.print("Enter Amount to Transfer: ₹");
                                double tAmount = scanner.nextDouble();
                                bank.transfer(currentAccount.getAccountNumber(), toAcc, tAmount);
                                break;
                            case 5: currentAccount.showStatement(); break;
                            case 6: running = false; break;
                            default: System.out.println("Invalid choice.");
                        }
                    }
                } else {
                    System.out.println("❌ Access Denied.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("❌ Error: Invalid input.");
        } finally {
            scanner.close();
            System.out.println("Session Closed.");
        }
    }
}