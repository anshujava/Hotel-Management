package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.TableBook;
import common.CommonFunction;
import common.UserDetail;

/**
 * Servlet implementation class TableBookingServlet
 */
public class TableBookingServlet extends HttpServlet {
    
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
			 String custID="";
			 Date todaysDate = new java.util.Date();
			 SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			 String formattedDate = formatter.format(todaysDate);
             UserDetail udet = new UserDetail();
             TableBook tb = new TableBook();
             CommonFunction cf = new CommonFunction();
             if(request.getParameter("txtCustType").equals("new")){
            	custID=cf.getGenerateId("CUSTOMERID");
             }else{
            	 custID=request.getParameter("txtName");
             }
             tb.setCustName(custID);
             tb.setCustAdd(request.getParameter("txtAdd"));
             tb.setCustContactNo(request.getParameter("txtPhoneNo"));
             tb.setCustEmail(request.getParameter("txtEmail"));
             tb.setCustVehicleNo(request.getParameter("txtVehicleNo"));
             tb.setBookingDate(formattedDate);
             tb.setCustBookingDate(request.getParameter("txtDate"));
             tb.setCustBookingTime(request.getParameter("txtTime"));
             tb.setNoOfGuest(request.getParameter("txtNoOfGuest"));
             tb.setTableType(request.getParameter("txtTableType"));
             tb.setNoOfTables(request.getParameter("txtNoOfTables"));
             
			 response.sendRedirect("./jsp/Table_Booking.jsp");	
             
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
