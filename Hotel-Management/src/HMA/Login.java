package HMA;
import javax.swing.*;
import java.awt.*;

public class Login extends JFrame
{
	JLabel user,pass;
	JTextField user_text;
	JPasswordField pass_text;
	JButton login,cancel;
	Container co=getContentPane();
	
	public Login()
	{
		co.setLayout(null);
		setSize(350,300);	
		
		user=new JLabel("Username");
		user.setBounds(50,30,100,30);
		co.add(user);
		
		pass=new JLabel("Password");
		pass.setBounds(50,60,100,30);
		co.add(pass);
		
		user_text=new JTextField("");
		user_text.setBounds(170,40,120,20);
		
		co.add(user_text);
		
		pass_text=new JPasswordField("");
		pass_text.setBounds(170,70,120,20);
		co.add(pass_text);
		
		login=new JButton("LoginServlet");
		login.setBounds(90,120,80,20);
		co.add(login);
		
		cancel=new JButton("Cancel");
		cancel.setBounds(180,120,80,20);
		co.add(cancel);
		
	
		
		setVisible(true);
	}	
	
	public static void main(String args[])
	{
		Login lg=new Login();
		lg.setSize(350,300);
		lg.setBounds(250,250,350,300);
		lg.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	}
}
