package common;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import bean.*;
import common.DBCon;
public class UserDetail {
	DBCon dbcon = new DBCon();
	Connection con = dbcon.getLocalDBConnection();
	ResultSet rs = null;
	Statement stmt = null;

	public String CheckLogin(Signin Objlogin) throws SQLException {

		String msg = "";

		try {
			
			stmt = con.createStatement();
			String strSql = "select loginname,password from userdetail where LOGINNAME='"
					+ Objlogin.getUserName()
					+ "'and password='"
					+ Objlogin.getPassword() + "'";
			rs = stmt.executeQuery(strSql);
			int count = 0;

			while (rs.next()) {

				count++;
			}

			if (count > 0) {
				msg = "";
			} else {
				msg = "Wrong LoginName/Password";
			}

		} catch (Exception e) {
			System.err.print("CheckLogin Exception : " + e);
			System.err.println("CheckLogin Exception : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e1) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
					con = null;
				} catch (Exception e3) {
				}
			}
		}

		return msg;
	}

	public String LoginUserID(Signin Objlogin) throws SQLException {
		String UserID = "";
		try {

			DBCon lc = new DBCon();
			con = lc.getLocalDBConnection();
			stmt = con.createStatement();
			String strSql = "select userid from userdetail where loginname='"
					+ Objlogin.getUserName() + "'and password='"
					+ Objlogin.getPassword() + "'";
			rs = stmt.executeQuery(strSql);
			while (rs.next()) {
				UserID = rs.getString("userid");
			}
		}

		catch (Exception e) {
			System.err.print("LoginUserID Exception : " + e);
			System.err.println("LoginUserID Exception : " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e1) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
					con = null;
				} catch (Exception e3) {
				}
			}
		}

		return UserID;
	}
	public void addRoomBooking(RoomBook objDetail)throws SQLException {

		try {

			PreparedStatement pre = con.prepareStatement("insert into bookrooms (customerid,customername,customeraddress,customeremail,customerstate," +
					"customermobile,customerlandline,indate,outdate,noofperson,roomtype,noofrooms,roomno,bookingdate,billedammount) " +
					"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pre.setString(1,objDetail.getCustID());
			pre.setString(2,objDetail.getCustName());
			pre.setString(3,objDetail.getCustAdd());
			pre.setString(4,objDetail.getCustEmail());
			pre.setString(5,objDetail.getCustState());
			pre.setString(6,objDetail.getCustMobile());
			pre.setString(7,objDetail.getCustLandline());
			pre.setString(8,objDetail.getCustInDate());
			pre.setString(9,objDetail.getCustOutDate());
			pre.setString(10,objDetail.getNoOfPerson());
			pre.setString(11,objDetail.getRoomType());
			pre.setString(12,objDetail.getNoOfRooms());
			pre.setString(13,objDetail.getRoomNo());
			pre.setString(14,objDetail.getBookingDate());
			pre.setString(15,objDetail.getBilledAmmount());
			pre.executeUpdate();
			System.out.println("Room Booked Successfully!");
			pre.close();
			
		    Statement stmt2 = null;
	        stmt2=con.createStatement();
			String queryUpdate="Update roomdetails set ROOMSTATUS = 'BOOKED' where ROOMNO ='"+objDetail.getRoomNo()+"'";
	        System.err.println("Update Rooms details table execute--"+queryUpdate);
	        stmt2.execute(queryUpdate);
	        System.out.println("Rooms Details completed");
	        stmt2.close();

		} catch (Exception e) {
			System.err.println("addRoomBooking Exception  " + e);
			System.err.println("addRoomBooking Exception  " + e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e1) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
					con = null;
				} catch (Exception e3) {
				}
			}
		}
	}
public ArrayList RoomDetails(String RoomType) throws SQLException {
		
		ArrayList arrList1 = new ArrayList();

		try {
			stmt = con.createStatement();
			String strSql = "select roomno,roomtype,ROOMSTATUS,price from roomdetails where roomtype = '"+RoomType+"'";
			rs = stmt.executeQuery(strSql);

			while (rs.next()) {
				String temp1[] = new String[10];
				temp1[0] = rs.getString("roomno");
				temp1[1] = rs.getString("roomtype");
				temp1[2] = rs.getString("roomstatus");
				temp1[3] = rs.getString("price");
				arrList1.add(temp1);
			}

		} catch (Exception e) {
			System.err.print("RoomDetails Exception : " + e);
			System.err.println("RoomDetails Exception : "
					+ e.getMessage());
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception e1) {
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception e2) {
				}
			}
			if (con != null) {
				try {
					con.close();
					con = null;
				} catch (Exception e3) {
				}
			}
		}

		return arrList1;
	}
public ArrayList RoomType() throws SQLException {
	
	ArrayList arrList1 = new ArrayList();

	try {
		stmt = con.createStatement();
		String strSql = "select distinct roomtype from roomdetails ";
		rs = stmt.executeQuery(strSql);

		while (rs.next()) {
			String temp1[] = new String[2];
			temp1[0] = rs.getString("roomtype");
			
			arrList1.add(temp1);
		}

	} catch (Exception e) {
		System.err.print("RoomType Exception : " + e);
		System.err.println("RoomType Exception : "
				+ e.getMessage());
	} finally {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (Exception e1) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception e2) {
			}
		}
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (Exception e3) {
			}
		}
	}

	return arrList1;
}
public ArrayList getRoomNO(String type) throws SQLException {
	
	ArrayList arrList1 = new ArrayList();

	try {
		stmt = con.createStatement();
		String strSql = "select roomno,price from roomdetails where roomtype = '"+type+"'and roomstatus ='AVAILABLE'";
		System.out.println(""+strSql);
		rs = stmt.executeQuery(strSql);
		while (rs.next()) {
			String temp1[] = new String[2];
			temp1[0] = rs.getString("roomno");
			temp1[1] = rs.getString("price");
			System.out.println(temp1[1]);
			arrList1.add(temp1);
		}

	} catch (Exception e) {
		System.err.print("getRoomNO Exception : " + e);
		System.err.println("getRoomNO Exception : "
				+ e.getMessage());
	} finally {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (Exception e1) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception e2) {
			}
		}
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (Exception e3) {
			}
		}
	}

	return arrList1;
}
public ArrayList getCustomer() throws SQLException {
	
	ArrayList arrList1 = new ArrayList();

	try {
		stmt = con.createStatement();
		String strSql = "select customername,customerid from bookrooms";
		rs = stmt.executeQuery(strSql);

		while (rs.next()) {
			String temp1[] = new String[10];
			temp1[0] = rs.getString("customername");
			temp1[1] = rs.getString("customerid");
			arrList1.add(temp1);
		}

	} catch (Exception e) {
		System.err.print("getCustomer Exception : " + e);
		System.err.println("getCustomer Exception : "
				+ e.getMessage());
	} finally {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (Exception e1) {
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
				stmt = null;
			} catch (Exception e2) {
			}
		}
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (Exception e3) {
			}
		}
	}

	return arrList1;
}
}
