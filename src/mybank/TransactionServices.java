package mybank;

public class TransactionServices {
	
	public Customer cashwithdrawService(Customer cust, int amountTowithdraw){ //change the object
		
		if(isEnough(cust,amountTowithdraw) && isWithinConstraints(amountTowithdraw) ){
			
			Account custAccount = cust.getCustAccount();
			if(custAccount.getAccType() == "checking"){ //if it's a checking account, add processing fee
				custAccount.setAccBalance(custAccount.getAccBalance() - amountTowithdraw - 3);
				return cust;
			}
			else {
				custAccount.setAccBalance(custAccount.getAccBalance() - amountTowithdraw);
				return cust;
			}		
			
		}
		else
			return null;
	}

	public void cashTransferService(Customer transferer, Customer receiver, int amountToTransfer){
		if(isEnough(transferer, amountToTransfer)){
			Account t = transferer.getCustAccount();
			t.setAccBalance(t.getAccBalance() - amountToTransfer);
			
			Account r = receiver.getCustAccount();
			r.setAccBalance(r.getAccBalance() + amountToTransfer);
		}
		else
			System.out.println("Not enough funds!");
	}
	private boolean isEnough(Customer cust, int amountTowithdraw){ //is  a helper function
		Account custAccount = cust.getCustAccount();
		double currentBalance = custAccount.getAccBalance();
		
		if(currentBalance>= amountTowithdraw)
			return true;
		else 
			return false;
	}
	
	public boolean isConfirm(char c){
		if(c == 'y')
			return true;
		else
			return false;
			
	}
	
	public boolean isWithinConstraints(int amountTowithdraw){
		//max $800 withdrawal, amount must be a multiple of 20
		if(amountTowithdraw<=800 && amountTowithdraw%20==0)
			return true;
		else
			System.out.println("You are either withdrawing too much or the amount is not a multiple of 20");
			return false;
	}
	
}
