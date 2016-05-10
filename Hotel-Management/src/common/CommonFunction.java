package common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CommonFunction {
	Connection con = null;
	CallableStatement call = null;
	ResultSet rs = null;
	Statement stmt = null;
	public String getGenerateId(String fName) throws SQLException
	{	
		String identityname = fName;
		DBCon lc = new DBCon();
		try {
			con = lc.getLocalDBConnection();
			stmt = con.createStatement();
			String strPrefix="";
			int Id=0;
		    System.out.println("Select IdentityName,IdentityValue from  ParameterTable where Upper(IdentityName)='" + fName.toUpperCase().trim() +"'");
			rs = stmt.executeQuery("Select IdentityName,IdentityValue from  ParameterTable where Upper(IdentityName)='" + fName.toUpperCase().trim() +"'");

			if (rs.next())
				fName = rs.getString("IdentityValue");
			strPrefix = fName.substring(0,2);			
			Id = Integer.parseInt(fName.substring(2,10));
			Id++;
			String temp = Integer.toString(Id);
			for(int i=8;i>temp.length();i--)
			{
				strPrefix+="0";
			}
			fName = strPrefix+Id;
			stmt = con.createStatement();
		        System.out.println("Update ParameterTable set IdentityValue = '"+ fName +"'where Upper(IdentityName)='" + identityname.toUpperCase().trim() +"'");
			stmt.executeUpdate("Update ParameterTable set IdentityValue = '"+ fName +"'where Upper(IdentityName)='" + identityname.toUpperCase().trim() +"'");
		          } catch(Exception exc) {
			// TODO Auto-generated catch block
			   System.err.print(exc.getMessage());    
		}
		
		finally{
			if(rs!=null){
	  			try{
	  				rs.close();
	  				rs=null;
	  			}
	  			catch(Exception e1)
	  			{}
	  		}	
	  		
	  		if(stmt!=null){
	  			try{
	  				stmt.close();
	  				stmt=null;
	  			}
	  			catch(Exception e2)
	  			{}
			}
				 		
	  		if(con!=null){
	  			try{
	  				con.close();
	  				con=null;
	  			}
	  			catch(Exception e3)
	  			{}
	  		}
		 }				
			return fName;	
	}
}
