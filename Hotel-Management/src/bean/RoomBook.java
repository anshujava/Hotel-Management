package bean;

import java.io.Serializable;

public class RoomBook implements Serializable{
	String custName="";
	String custID="";
	String custAdd="";
	String custEmail="";
	String custState="";
	String custMobile="";
	String custLandline="";
	String custInDate="";
	String custOutDate="";
	String NoOfPerson="";
	String RoomType="";
	String NoOfRooms="";
	String RoomNo="";
	String BookingDate="";
	String BilledAmmount="";
	
	public String getBilledAmmount() {
		return BilledAmmount;
	}
	public void setBilledAmmount(String billedAmmount) {
		BilledAmmount = billedAmmount;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustID() {
		return custID;
	}
	public void setCustID(String custID) {
		this.custID = custID;
	}
	public String getCustAdd() {
		return custAdd;
	}
	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustState() {
		return custState;
	}
	public void setCustState(String custState) {
		this.custState = custState;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustLandline() {
		return custLandline;
	}
	public void setCustLandline(String custLandline) {
		this.custLandline = custLandline;
	}
	public String getCustInDate() {
		return custInDate;
	}
	public void setCustInDate(String custInDate) {
		this.custInDate = custInDate;
	}
	public String getCustOutDate() {
		return custOutDate;
	}
	public void setCustOutDate(String custOutDate) {
		this.custOutDate = custOutDate;
	}
	public String getNoOfPerson() {
		return NoOfPerson;
	}
	public void setNoOfPerson(String noOfPerson) {
		NoOfPerson = noOfPerson;
	}
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	public String getNoOfRooms() {
		return NoOfRooms;
	}
	public void setNoOfRooms(String noOfRooms) {
		NoOfRooms = noOfRooms;
	}
	public String getRoomNo() {
		return RoomNo;
	}
	public void setRoomNo(String roomNo) {
		RoomNo = roomNo;
	}
	public String getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}
	
}
