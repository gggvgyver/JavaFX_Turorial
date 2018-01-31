package CashMachine.bank;

public class BasicAccount extends Account {
    public BasicAccount(AccountData accountData) {
        super(accountData);
    }

    @Override
    protected boolean canWithdraw(int amount) {
        return true;
    }

}
