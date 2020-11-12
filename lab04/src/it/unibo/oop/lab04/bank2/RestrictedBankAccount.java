package it.unibo.oop.lab04.bank2;

public class RestrictedBankAccount extends AbstractBankAccount{
    
    private static final double TRANSACTION_FEE = 0.1;
    
    public RestrictedBankAccount(int usrID, double balance) {
        super(usrID, balance);
    }

    public void computeManagementFees(int usrID) {
        this.setBalance(this.computeFee());
    }

    protected double computeFee() {
        final double feeAmount = AbstractBankAccount.MANAGEMENT_FEE + (this.getNTransactions() * TRANSACTION_FEE);
        return this.getBalance() - feeAmount;
    }
 
    protected boolean isWithDrawAllowed(final double amount) {
        return this.getBalance() >= amount;
    }
}
