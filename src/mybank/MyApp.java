package mybank;

import java.util.*; //class, interfaces, enums, doesn't include child packages

public class MyApp {
	
	Map<Integer,Customer> custmap; //avoid creating new variables in a class, do so in the methods
	Scanner sc = new Scanner(System.in); //get user input
	
	
	public void addCustomers(int addAmount){
		
		custmap = new HashMap<Integer,Customer>();
		//checking account
		for(int i = 0; i<addAmount;i++){
						
			System.out.println("Please select account type");
			
			String accountType = sc.next();
			Account custAccount = null;
			
			switch(accountType){
			case "savings":
				custAccount = new SavingsAccount();
				break;
			case "checking":
				custAccount = new CheckingAccount();
				break;
			default:
				throw new NotCorrectAccountType();
			}
			
			//customer info
			System.out.println("Please scan values for customer #" + i);
			int custId = sc.nextInt();
			String custName = sc.next();
			String custAddress = sc.next();
			String custPhone = sc.next();
			
			//account info
			System.out.println("Please scan values for the " + accountType + " account");
			int accNo = sc.nextInt();
			double accBalance = sc.nextDouble();			
			custAccount.setAccountDetails(accNo, accBalance);
			
			Customer next = new Customer();
			//cust.add(next);
			custmap.put(custId, next);
			next.setCustomerDetails(custId,custName,custAddress,custPhone, custAccount);
		}
		

	}
	private Customer searchEmployee(int cid){ //for finding existing cust
		if(custmap.containsKey(cid)){
			return custmap.get(cid);
		}
		else
			return null;
	}
	public void displayAllCustomers(){ //pass in acctype
		for(Integer customerKey: custmap.keySet()){
			Customer curr = custmap.get(customerKey);
			if(curr.getCustAccount().getAccType() == "savings")
				System.out.println("Savings Account------");
			else
				System.out.println("Checking Account------");
			
			
			String details = curr.displayCustomerDetails();
			System.out.println(details);
			System.out.println("------");
		}
		
	}
	
	public void callCashWithdrawService(Customer customer, int amountTowithdraw){
		
		TransactionServices s = new TransactionServices();		
		if(customer.getCustAccount().getAccType() == "checking"){
			
			System.out.println("Are you sure you want to withdraw? We charge a $3 processing fee.\n"
					+ "Press Y to confirm. Press any other key to cancel.");
			char confirmation = sc.next().charAt(0);
			if(!s.isConfirm(confirmation)){
				System.out.println("Operation Canceled");
				System.exit(0);
			}
		}

		Customer customerW = s.cashwithdrawService(customer, amountTowithdraw);
		String str = customerW.displayCustomerDetails();
		System.out.println("Post Withdrawal Information: \n" + str);
	}
	
	public void callTransferService(Customer transferer, Customer receiver, int amountToTransfer){
		TransactionServices s = new TransactionServices();
		s.cashTransferService(transferer, receiver, amountToTransfer);
		
		//original customer info
		String str = transferer.displayCustomerDetails();
		
		System.out.println("Post Transfer Information: \n" + str);
	}
	
	public static void main(String[] args){
				
		MyApp objApp = new MyApp();
		objApp.addCustomers(2); //fill list, pass in list size
		objApp.displayAllCustomers();
		
		Scanner sc = new Scanner(System.in);
		
		while(true){
			
			System.out.println("Welcome to my bank \n ----------------------------");
			System.out.println("1. Show customer details");
			System.out.println("2. Delete customer");
			System.out.println("3. Insert new customer");
			System.out.println("4. Withdraw funds");
			System.out.println("5. Transfer funds");
			System.out.println("6. Exit \n -------------------------------");
			
			System.out.println("\n Enter your choice");
		
			try{
				int choice = sc.nextInt();
				int cid;
				
				switch(choice){
				case 1: objApp.displayAllCustomers(); //adds one customer
					break;
				case 2:
					System.out.println("\n To delete employee, please enter the employee id: ");
					cid = sc.nextInt();
					objApp.custmap.remove(cid);//delete customer
					//throw doesn't exits exception
					break;
				case 3:
					System.out.println("\n Create new account");
					objApp.addCustomers(1);
					break;
				case 4: 
					System.out.println("\n To withdraw funds, enter a customer id: ");
					cid = sc.nextInt();
					System.out.println("\n Enter the amount");
					int withDrawAmount = sc.nextInt();
					objApp.callCashWithdrawService(objApp.custmap.get(cid), withDrawAmount);
					break;
				case 5: 
					System.out.println("\n To transfer funds, enter your id: ");
					cid = sc.nextInt();
					System.out.println("\n Who is receiving funds? ");
					int rid = sc.nextInt();
					System.out.println("\n Enter amount to transfer ");
					withDrawAmount = sc.nextInt();
					objApp.callTransferService(objApp.custmap.get(cid), objApp.custmap.get(rid), withDrawAmount); //need to pass in customer object
					break;
				case 6:
					System.out.println("Are you sure you want to exit the application? y/n");
					String yesNo = sc.next();
					if(yesNo.equals("y")){
							System.out.println("Exiting application");
							System.exit(0);
					}
		
					break;
				default:
					System.out.println("Please select an option from the menu");
				}
			} //end try block
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}
