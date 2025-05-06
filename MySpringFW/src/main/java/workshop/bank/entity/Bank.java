package workshop.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000;
    }

    // 계좌 생성 (Savings)
    public Account createSavingsAccount(String owner, double interestRate) {
        Account account = new SavingsAccount(nextAccountNumber++, owner, interestRate);
        accounts.add(account);
        return account;
    }

    // 계좌 생성 (Checking)
    public Account createCheckingAccount(String owner, double overdraftLimit) {
        Account account = new CheckingAccount(nextAccountNumber++, owner, overdraftLimit);
        accounts.add(account);
        return account;
    }

    // 계좌 조회
    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    // 입금
    public boolean deposit(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    // 출금
    public boolean withdraw(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            return account.withdraw(amount);
        }
        return false;
    }

    // 계좌 이체
    public boolean transfer(int fromAccount, int toAccount, double amount) {
        Account src = findAccount(fromAccount);
        Account dest = findAccount(toAccount);
        if (src != null && dest != null && src.withdraw(amount)) {
            dest.deposit(amount);
            return true;
        }
        return false;
    }

    // 모든 계좌 정보 출력
    public void printAllAccounts() {
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
