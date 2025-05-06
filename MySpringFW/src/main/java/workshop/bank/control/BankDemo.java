package workshop.bank.control;

import workshop.bank.entity.*;
import workshop.bank.exception.*;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // 계좌 생성
        Account acc1 = bank.createSavingsAccount("홍길동", 0.02);
        Account acc2 = bank.createCheckingAccount("김철수", 500.0);

        // 입금
        bank.deposit(acc1.getAccountNumber(), 1000);
        bank.deposit(acc2.getAccountNumber(), 2000);

        // 출금 테스트
        try {
            if (!bank.withdraw(acc1.getAccountNumber(), 300)) {
                throw new InsufficientBalanceException("잔액 부족");
            }

            if (!bank.withdraw(acc2.getAccountNumber(), 600)) {
                throw new WithdrawalLimitExceededException("출금 한도 초과");
            }

        } catch (InsufficientBalanceException e) {
            System.out.println("출금 실패: " + e.getMessage());
        }

        // 이자 적용
        if (acc1 instanceof SavingsAccount) {
            ((SavingsAccount) acc1).applyInterest();
        }

        // 이체 테스트
        try {
            if (!bank.transfer(acc1.getAccountNumber(), acc2.getAccountNumber(), 500)) {
                throw new InsufficientBalanceException("이체 실패: 잔액 부족 또는 계좌 없음");
            }
        } catch (InsufficientBalanceException e) {
            System.out.println("이체 실패: " + e.getMessage());
        }

        // 전체 계좌 출력
        bank.printAllAccounts();
    }
}
