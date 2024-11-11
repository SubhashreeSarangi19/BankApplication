import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private static int nextTransactionId = 10000;
    private int transactionId;
    private String date;
    private String type;
    private double amount;

    public Transaction(String type, double amount){
        this.transactionId = nextTransactionId++;
        this.type = type;
        this.amount = amount;
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    @Override
    public String toString(){
        return "Transaction ID: " + transactionId + ", Date: " + date + ", Type: " + type + ", Amount: $" + amount;
    }
}
