package CashMachine;

import CashMachine.bank.AccountData;
import CashMachine.bank.Bank;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CashMachine {

    private final Bank bank;
    private AccountData accountData = null;

    public CashMachine(Bank bank) {
        this.bank = bank;
    }

    private Consumer<AccountData> update = data -> {
        accountData = data;
    };

    public void login(int id) {
        tryCall( () -> bank.getAccountById(id), update);
    }

    public void deposit(int amount) {
        if(accountData != null) {
            tryCall( () -> bank.deposit(accountData, amount), update);
        }
    }

    public void withdraw(int amount) {
        if(accountData != null) {
            tryCall( () -> bank.withdraw(accountData, amount), update);
        }
    }

    public void exit() {
        if(accountData != null) {
            accountData = null;
        }
    }

    @Override
    public String toString() {
        return accountData !=null ? accountData.toString() : "데이타 없음";
    }

    private <T> void tryCall(Supplier<ActionResult<T>> action, Consumer<T> postAction) {
        try {
            ActionResult<T> result = action.get();
            if(result.isSuccess()) {
                T data  = result.getData();
                postAction.accept(data);
            } else {
                String errorMessage = result.getErrorMessage();
                throw new RuntimeException(errorMessage);
            }
        } catch (Exception e) {
            System.out.println("에러: " + e.getMessage());
        }
    }
}
