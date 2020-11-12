package it.unibo.oop.lab04.bank2;

public class ClassicBankAccount extends AbstractBankAccount{

    public ClassicBankAccount(int usrID, double balance) {
        super(usrID, balance);
    }

    protected boolean isWithDrawAllowed(double amount) {
        return true;
    }

    protected double computeFee() {
        return this.getBalance() - AbstractBankAccount.MANAGEMENT_FEE;
    }

    public void computeManagementFees(int usrID) {
        if (checkUser(usrID)) {
            this.setBalance(computeFee());
            this.resetNTransaction();
        }
    }

}
