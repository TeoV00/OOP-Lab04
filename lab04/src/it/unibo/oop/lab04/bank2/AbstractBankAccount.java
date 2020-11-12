package it.unibo.oop.lab04.bank2;

import it.unibo.oop.lab04.bank.BankAccount;

public abstract class AbstractBankAccount implements BankAccount {

    public static final double ATM_TRANSACTION_FEE = 1;
    public static final double MANAGEMENT_FEE = 5;
    private double balance;
    private int nTransactions;
    private final int usrID;

    public AbstractBankAccount(int usrID, double balance) {
        this.balance = balance;
        this.usrID = usrID;
    }

    public void deposit(int usrID, double amount) {
        this.transOperation(usrID, amount);
    }

    public void depositFromATM(int usrID, double amount) {
        this.deposit(usrID, amount - ATM_TRANSACTION_FEE);
    }

    private void transOperation(final int usrID, final double amount) {
        if(checkUser(usrID)) {
            this.balance += amount;
            this.nTransactions += 1;
        }
    }
    
    protected boolean checkUser(final int id) {
        return this.usrID == id;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public void setBalance(final double amount) {
        this.balance = amount;
    }

    public int getNTransactions() {
        return this.nTransactions;
    }
    
    public void resetNTransaction() {
        this.nTransactions = 0;
    }

    public void withdraw(int usrID, double amount) {
        if(this.checkUser(usrID) && isWithDrawAllowed(amount)) {
            transOperation(usrID, -amount);
        }
    }

    public void withdrawFromATM(int usrID, double amount) {
        withdrawFromATM(usrID, amount - ATM_TRANSACTION_FEE);
    }
    
    /*
     * returns true if it's possible to draw from the bank account the amount passed as parameter.
     * */
    protected abstract boolean isWithDrawAllowed(double amount);
    
    /*returns the current amount of the management fees (does not modify the state 
     * of AbstractBankAccount*/
    protected abstract double computeFee();
}
