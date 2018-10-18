package mybank;

public class CheckingAccount implements Account{
	private final int ir = 2;
	private final int creditLimit = 500;
	private int accNo;
	private double accBalance;
	private String accType = "checking";
	
	public String getAccType() {
		return accType;
	}


	public String displayAccountDetails(){
		return(accNo + "\t" + accBalance + "\t" + ir + "\t" + creditLimit);
	}


	@Override
	public void setAccountDetails(int accNo, double accBalance) {
		this.accNo = accNo;
		this.accBalance = accBalance;
		
	}
	
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public int getAccNo() {
		return accNo;
	}
	
	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public double getAccBalance() {
		return accBalance;
	}
}
