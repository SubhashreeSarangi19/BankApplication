import java.util.ArrayList;
import java.util.List;

public class User{
    private String username;
    private String password;
    private List<BankAccount> accounts;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public String getUsername(){
        return username;
    }

    public boolean validatePassword(String password){
        return this.password.equals(password);
    }

    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    public List<BankAccount> getAccounts(){
        return accounts;
    }
}
