import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankingApp {
    private static Map<String, User> users = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    private static User currentUser;

    public static void main(String[] args) {
        while(true){
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    private static void register(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if(users.containsKey(username)){
            System.out.println("Username already exists. Please try a different one.");
        }else{
            User newUser = new User(username, password);
            users.put(username, newUser);
            System.out.println("Registration successful.");
        }
    }

    private static void login(){
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        User user = users.get(username);
        if(user != null && user.validatePassword(password)){
            currentUser = user;
            System.out.println("Login successful.");
            userMenu();
        }else{
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void userMenu(){
        while(true){
            System.out.println("\n1. Open Account\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. View Statement\n6. Add Monthly Interest\n7. Logout");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    openAccount();
                    break;
                case 2:
                    processTransaction("deposit");
                    break;
                case 3:
                    processTransaction("withdraw");
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    viewStatement();
                    break;
                case 6:
                    addMonthlyInterest();
                    break;
                case 7:
                    currentUser = null;
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private static void openAccount(){
        System.out.println("Enter account holder name:");
        String name = sc.nextLine();
        System.out.println("Enter account type (savings/checking):");
        String type = sc.nextLine();
        System.out.println("Enter initial deposit:");
        double initialDeposit = sc.nextDouble();

        BankAccount acc = new BankAccount(name,type,initialDeposit);
        currentUser.addAccount(acc);
        System.out.println("Account created successfully.Account Number: " + acc.getAccountNumber());
    }

    private static void processTransaction(String type){
        BankAccount account = selectAccount();
        if (account != null){
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            if (type.equals("deposit")){
                account.deposit(amount);
                System.out.println("Deposit successful!");
            }else if (type.equals("withdraw") && account.withdraw(amount)) {
                System.out.println("Withdrawal successful!");
            }else{
                System.out.println("Insufficient Balance!");
            }
        }
    }

    private static void checkBalance() {
        BankAccount account = selectAccount();
        if (account != null){
            System.out.println("Current balance:$"+account.getBalance());
        }
    }

    private static void viewStatement(){
        BankAccount acc = selectAccount();
        if(acc!= null){
            for(Transaction transaction: acc.getTransactions()){
                System.out.println(transaction);
            }
        }
    }

    private static void addMonthlyInterest(){
        for(BankAccount acc : currentUser.getAccounts()){
            acc.addMonthlyInterest();
        }
        System.out.println("Monthly interest added to all savings accounts.");
    }

    private static BankAccount selectAccount(){
        System.out.print("Enter account number:");
        int accountNumber = sc.nextInt();
        for (BankAccount account:currentUser.getAccounts()) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        System.out.println("Account not found!");
        return null;
    }
}
