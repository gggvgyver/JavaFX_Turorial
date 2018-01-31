package CashMachine.bank;

import CashMachine.ActionResult;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    public Bank() {
        accounts.put(1000, new BasicAccount(new AccountData(1000, "김순광", "test01@test.com", 1000)));
        accounts.put(2000, new BasicAccount(new AccountData(2000, "김별이", "test02@test.com", 2000)));
    }

    public ActionResult<AccountData> getAccountById(int id) {
        Account account = accounts.get(id);

        if(account != null) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail(id + " 와 일치하는 계좌가 없습니다");
        }
    }

    public ActionResult<AccountData> deposit(AccountData accountData, int amount) {
        Account account = accounts.get(accountData.getId());
        account.deposit(amount);

        return ActionResult.success(account.getAccountData());
    }

    public ActionResult<AccountData> withdraw(AccountData accountData, int amount) {
        Account account = accounts.get(accountData.getId());
        boolean ok = account.withdraw(amount);

        if(ok) {
            return ActionResult.success(account.getAccountData());
        } else {
            return ActionResult.fail(amount + " 원 인출 실패 " + "현재 잔고: " + account.getBalance());
        }
    }

}
