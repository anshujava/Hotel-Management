package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.UserDetail;

import bean.Signin;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       System.out.println("in servlet");
	   String msg = "";
	   String UserId="";
	   Signin Objlogin= new Signin();
	   UserDetail Objuser= new UserDetail();
	   HttpSession sUser = request.getSession(true);
		try{
			 	
             String pw=request.getParameter("txtpassword");	
	         System.err.println("new servlet pwd->"+pw);
			 Objlogin.setUserName(request.getParameter("txtuserName"));
			 Objlogin.setPassword(request.getParameter("txtuserName"));
			 msg = Objuser.CheckLogin(Objlogin);
			 UserId=Objuser.LoginUserID(Objlogin);
			 System.err.println("Messg in else"+msg);
			 
			
			if(msg!="")
				{	
				HttpSession sMsg = request.getSession(true);
	            //System.err.println(sUserDept.getId());
	            
				sMsg.setAttribute("msg",msg);
				sUser.setAttribute("UserId", UserId);
				String L_url1=response.encodeRedirectURL("./jsp/SignIn.jsp?");
				response.sendRedirect(L_url1);	
       			
			}
			else
			{
	             sUser.setAttribute("UserId", UserId);
			     String L_url1=response.encodeRedirectURL("./jsp/mainPage.jsp");
				 response.sendRedirect(L_url1);	
			}	
		}
		catch(Exception e)
		{
			System.err.println("Exception in LoginServlet:-"+e.getMessage());
		}
		
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
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
    // </editor-fold>
}
