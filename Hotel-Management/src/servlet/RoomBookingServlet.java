package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.RoomBook;
import bean.Signin;

import common.CommonFunction;
import common.UserDetail;

/**
 * Servlet implementation class RoomBookingServlet
 */
public class RoomBookingServlet extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
		try{
			 Date todaysDate = new java.util.Date();
			 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			 String formattedDate = formatter.format(todaysDate);
             UserDetail udet = new UserDetail();
             RoomBook rb = new RoomBook();
             CommonFunction cf = new CommonFunction();
             rb.setCustID(cf.getGenerateId("CUSTOMERID"));
             rb.setCustName(request.getParameter("txtName"));
             rb.setCustAdd(request.getParameter("txtadd"));
             rb.setCustEmail(request.getParameter("txtemail"));
             rb.setCustState(request.getParameter("txtstate"));
             rb.setCustMobile(request.getParameter("txtmobile"));
             rb.setCustLandline(request.getParameter("txtlandline"));
             rb.setCustInDate(request.getParameter("txtin"));
             rb.setCustOutDate(request.getParameter("txtout"));
             rb.setNoOfPerson(request.getParameter("txtNoOfPerson"));
             rb.setRoomType(request.getParameter("txtRoomType"));
             rb.setNoOfRooms(request.getParameter("txtNoOfRooms"));
             rb.setRoomNo(request.getParameter("txtRoomNo"));
             rb.setBookingDate(formattedDate);
             rb.setBilledAmmount(request.getParameter("txtBilledAmnt"));
             udet.addRoomBooking(rb);
			 response.sendRedirect("./jsp/Room_Booking.jsp");	
             
		}
		catch(Exception e)
		{
			System.err.println("Exception in RoomBookingServlet Servlet:-"+e.getMessage());
		}
		
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
}
