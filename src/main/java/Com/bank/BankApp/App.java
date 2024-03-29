package Com.bank.BankApp;
import java.sql.ResultSet;
import java.util.Scanner;

import Com.bank.dao.BankEmployeeDBOperation;
import Com.bank.dao.BankUserDBOperations;
import Com.bank.entities.BankUser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("========================================================================");
        System.out.println("                    Welcome to ABC Bank              ");
        System.out.println("========================================================================");
    boolean status=true;
    	do {
    	try
    	{
        Scanner scan=new Scanner( System.in);
        
        System.out.println("\t Press 1 -> Teacher System");
        System.out.println("\t Press 2 ->Bank User");
        int userType=scan.nextInt();
        BankEmployeeDBOperation bo= new BankEmployeeDBOperation();
        if(userType==1)
        {
        	System.out.println("\t Enter Employee Id:");
        	long eId=scan.nextLong();
        	System.out.println("\t Enter Password:");
        	String password=scan.next();
        	boolean validUser=bo.login(eId, password);
        	if(validUser)
        	{
        		System.out.println("Login Successfully!!");
        		System.out.println("\t 1.Open Account\r\n"
    	       			+ "2.Close Account\r\n"
    	       			+ "3.Check User Information\r\n"
    	       			+ "4.Password Change\r\n"
    	       			+ "5.Logout"
    	       			+"6.Recent Transactions\r\n"
    	       			+"7.Logout");
        		int operation=scan.nextInt();
    	       	if(operation==1)
    	       	{
    	       		System.out.println("========================================================");
    	            System.out.println(" Accounting Opening");
    	            System.out.println("========================================================");
    	       		System.out.println(" Enter Account Id for the user:");
    	        	long accId=scan.nextLong();
    	        	System.out.println(" Enter Account holder name:");
    	        	String accName=scan.next();
    	        	System.out.println(" Enter Account holder address:");
    	        	String accAddress=scan.next();
    	        	System.out.println(" Enter Account holder password:");
    	        	String accPassword=scan.next();
    	        	System.out.println(" Enter Initial Balance:");
    	        	double accBalance=scan.nextDouble();
    	        	System.out.println(" Enter Phone number:");
    	        	long accPhone=scan.nextLong();
    	        	System.out.println(" Enter Email address:");
    	        	String accEmail=scan.next();
    	        	
    	        	BankUser u=new BankUser(accId, accName, accAddress, accBalance,accPassword, accPhone,
    	       				accEmail);
    	       		if(bo.openAccount(u))
    	       		{
    	       			System.out.println("Account created!!");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("Problem in account creation!! ");
    	       		}	
    	       	}
    	       	else if(operation==2)
    	       	{
    	       		System.out.println("Enter account id for closing account:");
    	       		long accId=scan.nextLong();
    	       		
    	       		if(bo.accountClose(accId))
    	       		{
    	       			System.out.println("Account closed successfully!! ");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("Problem in account closing!! ");
    	       		}
    	       	}
    	       	else if(operation==3)
    	       	{
    	       		System.out.println("==========================================================================================================");
        			System.out.println("User Infomation ");
        	       	System.out.println("==========================================================================================================");
        	       	System.out.println("Enter the account Id for the User:");
        	       	long accId=scan.nextLong();
        	       	ResultSet result=bo.checkUserinfo(accId);
        	       	if(result!=null)
        	       	{while(result.next())
    	       		{
    	       		System.out.println("User Name:"+result.getString(2));
    	       		System.out.println("Address:"+result.getString(3));
    	       		System.out.println("Phone number:"+result.getLong(4));
    	       		System.out.println("Email:"+result.getString(5));        	     
    	       		System.out.println("Balance:"+result.getDouble(6));
    	       	}
        	       	
    	       	}
    	       	else
    	       	{
    	       		System.out.println("Account Id does not exist!! ");
    	       	}
	       	}
      	}
        	else
        	{
        		System.out.println("Incorrect user Id/ password!!");
        	}
        }
        
        else if(userType==2)
        {
        	BankUserDBOperations ob=new BankUserDBOperations();
        	System.out.println("\t Enter Account Id:");
        	long uId=scan.nextLong();
        	System.out.println("\t Enter Password:");
        	String password=scan.next();
        	if(ob.login(uId, password))
        	{
        		System.out.println("==========================================================================================================");
    			System.out.println("Logged In!!");
    	       	System.out.println("==========================================================================================================");
        	
    	       	System.out.println("\r\n"+
    	       			"1.withdraw\r\n"+
    	       			"2.deposit\r\n"+
    	       			"3.checkbalance\r\n"+
    	       			"4.recentTransactionList\r\n"+
    	       			"4.change Password\r\n"+
    	       			"5.Logout\r\n");
    	       	int operation=scan.nextInt();
    	       	if(operation==1)
    	       	{
    	       		
    	       	}
    	       	else if(operation==2)//Deposit
    	       	{
    	       		System.out.println("Enter the deposit amount:");
    	       		double depositAmount=scan.nextDouble();
    	       		System.out.println("==========================================================================================================");
    	       		ob.deposit(depositAmount, uId);
    	       		System.out.println("==========================================================================================================");
    	       	}
    	       	else if(operation==3)
    	       	{
    	       	System.out.println("==========================================================================================================");
       			 ResultSet rs=ob.balanceCheck(uId);
       			 while(rs.next())
       			 {
       				 System.out.println("Available Balance :"+rs.getDouble(5));
       			 }
       				 System.out.println("==========================================================================================================");

    	       	}
    	       	else if(operation==4)
    	       	{
    	       		System.out.println("Enter receiver bank account Id");
    	       		long rid=scan.nextLong();
    	       		System.out.println("Enter amount:");
    	       		double tamount=scan.nextDouble();
    	       		System.out.println("==========================================================================================================");
       			 ob.fundTransfer(uId, rid, tamount);
       	       	System.out.println("==========================================================================================================");

    	       	}

    	       	else if(operation==5)
    	       	{
    	    		System.out.println("Enter new password:");
    	    		String newPassword=scan.next();
    	       		if(ob.changePassword(uId, newPassword))
    	       		{
    	       			System.out.println("==========================================================================================================");
    	    			System.out.println("Password changed successfully!!");
    	    	       	System.out.println("==========================================================================================================");

    	       		}
    	       		else
    	       		{
    	       			System.out.println("==========================================================================================================");
    	    			System.out.println("Problem in password change!!");
    	    	       	System.out.println("==========================================================================================================");

    	       		}
    	       	}
    	       	else if(operation==6)
    	       	{
    	       		System.out.println("==========================================================================================================");
	       			System.out.println("Transaction Id" + "\t" +"Amount"+ "\t"+"Date"+"\t\t"+"Sender Id"+"\t"+"Receiver Id");
    	       		System.out.println("==========================================================================================================");

    	       		ResultSet rs=ob.transactions(uId);
    	       		while(rs.next())
    	       		{
    	       			System.out.println(rs.getLong(1) + "\t\t" +rs.getDouble(2)+ "\t"+rs.getTimestamp(3)+"\t"+rs.getLong(4)+"\t"+rs.getLong(5));
    	       		}
    	       		System.out.println("==========================================================================================================");

    	       	}

    	    		
             else if(operation==7)
    	       	{
    	       		ob.logout();
    	       		System.out.println("==========================================================================================================");
        			System.out.println("Logged Out!!");
        	       	System.out.println("==========================================================================================================");

    	       	}
    	    	else 
    	       	{
    	    		System.out.println("==========================================================================================================");
        			System.out.println("Wrong Input!!");
        	       	System.out.println("==========================================================================================================");

    	       	}
    	       	
    	       	
    		}
else
    		{
    			System.out.println("==========================================================================================================");
    			System.out.println("User Id or Password Incorrect!!");
    	       	System.out.println("==========================================================================================================");

    		}

       
        }
        else
        {
        	System.out.println("\t Please enter a correct input!");
        }
    }
    	catch(Exception e)
    	{
    		System.out.println("\t Wrong Input");
    		System.out.println("\t Provide number input");
    	}
}
    	while(status);
    		
}
}