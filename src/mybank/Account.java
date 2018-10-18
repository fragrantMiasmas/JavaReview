package mybank;

interface Account { //not allowed to create instance of abstract class or interface

 void setAccountDetails(int accNo, double accBalance);
 String displayAccountDetails();
 public double getAccBalance();
 public void setAccBalance(double accBalance);
 public String getAccType();
}
