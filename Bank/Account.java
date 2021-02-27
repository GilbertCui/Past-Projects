import java.text.NumberFormat;

public class Account
{
    private String name;
    private int number;
    private double balance;
    private int password;
    private boolean lock;
    private boolean enoughCash;
    
    public Account(String name, int number, double balance, int password, boolean lock)
    {
        this.name = name;
        this.number = number;
        this.balance = balance;
        this.password = password;
        this.lock = lock;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getNumber()
    {
        return number;
    }
    
    public int getPassword()
    {
        return password;
    }
    
    public boolean getStatus()
    {
        return lock;
    }
    
    public void setName(String userName)
    {
        name = userName;
    }
    
    public void setBalance(double userBalance)
    {
        balance = userBalance;
    }
    
    public void setStatus(boolean userLock)
    {
        lock = userLock;
    }
    
    public void setPassword(int userPassword)
    {
        password = userPassword;
    }
    
    public void replaceNumber(int userNewNumber)
    {
        number = userNewNumber;
    }
    
    public void deposit(double userDeposit)
    {
        balance = balance + userDeposit;
    }
    
    public boolean withdraw(double userWithdraw)
    {
        enoughCash = true;
        balance = balance - userWithdraw;
        if (balance < 0)
        {
            balance = balance + userWithdraw;
            enoughCash = false;
        }
        return enoughCash;
    }
    
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        String description = null;
        if (name.length() >= 8 && lock == false)
            description = name + "\t" + number + "\t" + password + "\t" + "active" + "\t\t" + fmt.format(balance);
        else if (name.length() >= 8 && lock == true)
            description = name + "\t" + number + "\t" + password + "\t" + "locked" + "\t\t" + fmt.format(balance);
        else if (lock == false) 
            description = name + "\t\t" + number + "\t" + password + "\t" + "active" + "\t\t" + fmt.format(balance);
        else
            description = name + "\t\t" + number + "\t" + password + "\t" + "locked" + "\t\t" + fmt.format(balance);
        return description;
    }
}