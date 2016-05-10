package bean;

import java.io.Serializable;

public class TableBook implements Serializable{
	String CustName="";
	String CustAdd="";
	String CustContactNo="";
	String CustEmail="";
	String CustVehicleNo="";
	String CustBookingDate="";
	String CustBookingTime="";
	String NoOfGuest="";
	String TableType="";
	String NoOfTables="";
	String BookingDate="";
	String BilledAmmount="";
	
	public String getCustBookingTime() {
		return CustBookingTime;
	}
	public void setCustBookingTime(String custBookingTime) {
		CustBookingTime = custBookingTime;
	}
	public String getBilledAmmount() {
		return BilledAmmount;
	}
	public void setBilledAmmount(String billedAmmount) {
		BilledAmmount = billedAmmount;
	}
	
	public String getCustName() {
		return CustName;
	}
	public void setCustName(String custName) {
		CustName = custName;
	}
	public String getCustAdd() {
		return CustAdd;
	}
	public void setCustAdd(String custAdd) {
		CustAdd = custAdd;
	}
	public String getCustContactNo() {
		return CustContactNo;
	}
	public void setCustContactNo(String custContactNo) {
		CustContactNo = custContactNo;
	}
	public String getCustEmail() {
		return CustEmail;
	}
	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}
	public String getCustVehicleNo() {
		return CustVehicleNo;
	}
	public void setCustVehicleNo(String custVehicleNo) {
		CustVehicleNo = custVehicleNo;
	}
	public String getCustBookingDate() {
		return CustBookingDate;
	}
	public void setCustBookingDate(String custBookingDate) {
		CustBookingDate = custBookingDate;
	}
	public String getNoOfGuest() {
		return NoOfGuest;
	}
	public void setNoOfGuest(String noOfGuest) {
		NoOfGuest = noOfGuest;
	}
	public String getTableType() {
		return TableType;
	}
	public void setTableType(String tableType) {
		TableType = tableType;
	}
	public String getNoOfTables() {
		return NoOfTables;
	}
	public void setNoOfTables(String noOfTables) {
		NoOfTables = noOfTables;
	}
	public String getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}
	
}
