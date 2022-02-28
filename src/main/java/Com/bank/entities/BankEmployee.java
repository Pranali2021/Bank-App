package Com.bank.entities;

public class BankEmployee {
	int employeeID;//camel case
	String employeeName;
	String password;
	
	public BankEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public BankEmployee(int employeeID, String employeeName, String password) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.password = password;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
