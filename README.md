# 🏦 Secure Online Banking System (Java)

A comprehensive, console-based banking application developed in Java. This project demonstrates professional software engineering practices, focusing on **Object-Oriented Programming (OOP)**, **Role-Based Access Control (RBAC)**, and **Data Persistence**.



---

## 🚀 Key Features

* **Authentication & Security:** Secure login system requiring an Account Number and a 4-digit PIN.
* **Role-Based Access:** * **User Mode:** Perform deposits, withdrawals, transfers, and check balances.
    * **Admin Mode:** Access via special credentials to view all accounts and total bank liquidity.
* **Inter-Account Transfers:** Atomic logic to transfer funds securely between two different accounts.
* **Transaction History:** Automated "Mini-Statement" generation for tracking every credit and debit in real-time.
* **Persistence:** Integration with `File I/O` to save and load account balances from a local database file (`bank_data.txt`).
* **Robust Input Validation:** Advanced exception handling using `try-catch` blocks to prevent system crashes from invalid user inputs.

---

## 🏗️ Technical Architecture (OOP Principles)

This project was built to showcase core engineering standards:

1.  **Abstraction:** Utilizes the `BankingService` interface to decouple business logic from implementation.
2.  **Encapsulation:** Protects sensitive data (Balance, PIN) using private fields and public getter/setter methods.
3.  **Inheritance & Implementation:** The `BankManager` class implements the `BankingService` contract.
4.  **Polymorphism:** Demonstrates method overriding and the use of interface references to manage account objects.



---

## 📂 Project Structure

* `Main.java`: The entry point and user interface logic.
* `Account.java`: The core data model for a bank account.
* `BankingService.java`: The interface defining the banking operations.
* `BankManager.java`: Logic for managing multiple accounts and inter-account transfers.
* `FileHandler.java`: Manages data persistence and file operations.

---

## ⚙️ Installation & Usage

1.  **Clone the Repository:**
    ```bash
    git clone [https://github.com/your-username/online-banking-system.git](https://github.com/your-username/online-banking-system.git)
    ```
2.  **Compile the Source Code:**
    ```bash
    javac *.java
    ```
3.  **Run the Application:**
    ```bash
    java Main
    ```

---

### 🔑 Test Credentials

| Role | Account Number | PIN |
| :--- | :--- | :--- |
| **Standard User** | `1001` | `1234` |
| **Admin User** | `admin` | `9999` |

---

## 📄 Future Enhancements
* Integration with a SQL Database (MySQL/PostgreSQL).
* Encryption for PIN storage using SHA-256 hashing.
* Graphical User Interface (GUI) using Java Swing or JavaFX.