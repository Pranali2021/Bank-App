package Com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Com.bank.entities.BankUser;

public class BankEmployeeDBOperation {
	DBconnection ob=new DBconnection();
	Connection conn=ob.connection();
	public boolean login(long eid, String password) throws SQLException
	{
	
		PreparedStatement stmt=conn.prepareStatement("select * from bankemployee where bankEmpId=? and bankEmppassword=?");
		stmt.setLong(1, eid);
		stmt.setString(2, password);
		
		ResultSet result=stmt.executeQuery();
		if(result.next())
		{
			return true;
		}
		else
		{
		    return false;
	    }
		}
	
	public boolean accountClose(long userId) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("delete from bankuser where userID=? ");
		stmt.setLong(1, userId);
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}


	public boolean openAccount(BankUser e) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("insert into bankuser values(?,?,?,?,?,?,?)");
		stmt.setLong(1, e.getUserId());
		stmt.setString(2,e.getUserName());
		stmt.setString(3,e.getUserAddress());
		stmt.setString(4,e.getUserPassword());
		stmt.setDouble(5, e.getBalance());
		stmt.setLong(6,e.getPhone());
		stmt.setString(7, e.getUserEmail());
		
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public ResultSet checkUserinfo(long accId) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("select * from bankuser where acc_id=? ");
		stmt.setLong(1, accId);
		
		
		ResultSet result=stmt.executeQuery();
		if(result.next())
		{
			return result;
		}
		else
		{
			result=null;
			return result;
		}
	}

		
	}
