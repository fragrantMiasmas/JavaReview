package mybank;

public class SavingsAccount implements Account{
	
	//final ints are constants
	private final int ir = 5; //interest rate
	private int accNo;
	private double accBalance;
	private String accType = "savings";

	public String displayAccountDetails(){
		return(accNo + "\t" + accBalance + "\t" + ir);
	}
	public void setAccountDetails(int accNo, double accBalance){
		this.accNo = accNo;
		this.accBalance = accBalance;
	}
	
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public int getAccNo() {
		return accNo;
	}

	public String getAccType() {
		return accType;
	}
	
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public double getAccBalance() {
		return accBalance;
	}
	
}
