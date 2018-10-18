package mybank;
//java.lang package is automatically imported, which makes class file larger 
//.class files carry OS dependencies

public class Customer { //customer is the child of an object class(object class is a cosmic superclass)
	
	//note: when in doubt, use private variables, this will reduce the size of object in main class
	private int custId;
	private String custName;
	private String custAddress;
	private String custPhone;
	private Account custAccount;
	

	public Account getCustAccount() {
		return custAccount;
	}
	
	public void setCustomerDetails(int custId, String custName, String custAddress, 
			String custPhone, Account custAccount){
		
		this.custId = custId;
		this.custName = custName;
		this.custAddress = custAddress;
		this.custPhone = custPhone;
		this.custAccount = custAccount;
	}
	public String displayCustomerDetails(){
		//System.out.println(custId + " " + custName +" "+custAddress + " "+custPhone+ " "+ custAccountNo+" "+ custBalance);
		return(custId + " " + custName +" "+custAddress + " "+custPhone + "\t\n " + custAccount.displayAccountDetails());
	}
	
}
