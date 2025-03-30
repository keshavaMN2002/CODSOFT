package firstprogram.com;

import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false; // Insufficient funds or invalid amount
    }
}

class ATM {
    private BankAccount1 account;

    public ATM(BankAccount1 account) {
        this.account = account;
    }

    public boolean withdraw(double amount) {
        return account.withdraw(amount);
    }

    public void deposit(double amount) {
        account.deposit(amount);
    }

    public double checkBalance() {
        return account.getBalance();
    }
}

public class ATMConsole {
    private ATM2 atm;
    private Scanner scanner;

    public ATMConsole(ATM2 atm) {
        this.atm = atm;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    handleWithdraw();
                    break;
                case 2:
                    handleDeposit();
                    break;
                case 3:
                    System.out.printf("Current balance: $%.2f%n", atm.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }

    private void handleWithdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        if (atm.withdraw(amount)) {
            System.out.printf("Withdrawal successful. New balance: $%.2f%n", atm.checkBalance());
        } else {
            System.out.printf("Insufficient funds. Current balance: $%.2f%n", atm.checkBalance());
        }
    }

    private void handleDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        atm.deposit(amount);
        System.out.printf("Deposit successful. New balance: $%.2f%n", atm.checkBalance());
    }

    public static void main(String[] args) {
        BankAccount1 account = new BankAccount1(1000); // Initial balance of $1000
        ATM2 atm = new ATM2(account);
        ATMConsole console = new ATMConsole(atm);
        console.start();
    }
}
