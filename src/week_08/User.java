package week_08;

public class User {

    private String name;
    private double accountBalance;
    private String pin;

    public User() {
    }

    public User(String name, double accountBalance, String pin) {
        this.name = name;
        this.accountBalance = accountBalance;
        this.pin = pin;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean deposit(double amount) {
        // mark
        if (amount > 0) {
            this.accountBalance += amount;
            return true;
        }

        return false;

    }

    public boolean withdraw(double amount) {
        if (this.accountBalance >= amount && amount > 0) {
            this.accountBalance -= amount;
            return true;
        }

        return false;
    }

    public String toString() {

        String firstName = this.name.substring(0, 1).toUpperCase() + "****";
        int indexOfSpace = this.name.indexOf(" ");
        String secondName = this.name.substring(indexOfSpace + 1, indexOfSpace + 2) + "****";
        String last = firstName + " " + secondName + " || Account Balance: $" + this.accountBalance;
        return last;
    }

}
