import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static int nextAccountNumber = 1000;
    private static final double SAVING_INTEREST_RATE = 0.03;
    private int accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private List<Transaction> transactions;

    public BankAccount(String accountHolderName,String accountType,double initialDeposit){
        this.accountNumber = nextAccountNumber++;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        logTransaction("Initial Deposit", initialDeposit);
    }
    private void logTransaction(String type, double amount){
        transactions.add(new Transaction(type,amount));
    }
    public List<Transaction> getTransactions(){
        return transactions;
    }
    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
        logTransaction("Deposit", amount);
    }

    public boolean withdraw(double amount){
        if (amount <= balance) {
            balance -= amount;
            logTransaction("Withdrawal", amount);
            return true;
        }
        return false;
    }

    public void addMonthlyInterest(){
        if (accountType.equalsIgnoreCase("savings")){
            double interest = balance * SAVING_INTEREST_RATE / 12;
            deposit(interest);
            logTransaction("Monthly Interest", interest);
        }
    }
}
