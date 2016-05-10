package HMA;
import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import javax.swing.table.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;



class ImagePanel extends JPanel
{

	 	private Image img;
		public ImagePanel(String img)
		{
    		this(new ImageIcon(img).getImage());
  		}

  	public ImagePanel(Image img)
  	{
    	this.img = img;
    	Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
    	setPreferredSize(size);
    	setMinimumSize(size);
    	setMaximumSize(size);
    	setSize(size);
    	setLayout(null);
  	}

  	public void paintComponent(Graphics g)
  	{
    	g.drawImage(img, 0, 0, null);
  	}

}






public class Home extends JFrame implements MenuListener,ActionListener,MouseListener,ItemListener
{
	JPanel pn1,pn2,pn3,pn4,pn5,pn6,pn7,pn8,pn9,pn10,pn11;
	
	JLabel l1,l2,l3,status,l4,l5;
	JLabel room_a,table_a;
	JLabel head,name,other;
	JLabel addr,city,state,in,out,email,mob,nop,night,roomt,nor,book_room_no;
	JLabel cust_no,cust_name,cust_detail;
	JLabel i_name,i_type,i_manu,i_qty,i_reorder,i_rate,i_supln,i_suplc,i_supla;
	JLabel tp_t,no_t,table_time,dest;
	JLabel bill_h,bill_custn,bill_date,bill_room_type,bill_nod,bill_nop,bill_meal,bill_cab,bill_total;
	JLabel bill_custn_t,bill_date_t,bill_room_type_t,bill_nod_t,bill_nop_t,bill_meal_t,bill_cab_t,bill_total_t;
	JLabel cancel_book_head,cancel_book_custn,cancel_book_custno;
	int flag=0;
	
	JTable table1;
	String month,date_to,date_t,date_feb,year;
	
	
	JButton b1,b2,bill_g,bill_clear;
	JButton i_save,i_cancel;
	JButton roombook_save,roombook_clear;
	JButton bill_print;
	JButton book_cancel;
	
	JCheckBox table,cab;
	JComboBox book_in_month,book_in_date,book_in_year;
	JComboBox book_out_month,book_out_date,book_out_year;
	JComboBox roomt_t;
	
	ComboBoxModel[] models=new ComboBoxModel[3];
	
	
	ImageIcon image;
	
	JMenuBar menuBar,menuBar2;
	
	JMenu book,bill,inventory,admin,d1,d2,d3,d4,d5;
	JMenu new_b,cancel_b,update,logout,room_detail;
	JMenu status_inv,add_new;
	
	JMenuItem room_i,table_i,menuItem;
	
	JScrollPane span,jsp1;
	Scrollbar sb;  
	DefaultTableModel model;

	JTextField name_t,addr_t,city_t,state_t,in_t,out_t,email_t,mob_t,nop_t,night_t,nor_t;
	JTextField custno_t,custname_t;
	JTextField iname_t,imanu_t,iqty_t,ireorder_t,irate_t,isupln_t,isuplc_t,isupla_t;
	JTextField tpt_t,not_t,tabletime_t;
	JTextField cancel_book_custn_t,cancel_book_custno_t;
	JTextField book_room_no_t;


	Vector columnNames = new Vector();
	Vector data = new Vector();
	Vector row=new Vector();
	
	
	
	JComboBox itype_t,dest_t;
	
	
	Home()
	{

		setLayout(null);
		setSize(1025,1000);


		pn1=new JPanel();
		pn2=new JPanel();
		pn3=new JPanel();
        pn4=new JPanel();
        pn5=new JPanel();
		pn6=new JPanel();
		pn7=new JPanel();
		pn8=new JPanel();
		pn9=new JPanel();
		pn10=new JPanel();
		pn11=new JPanel();
	

		menuBar=new JMenuBar();

		book=new JMenu("Booking");
		bill=new JMenu("Billing");
		inventory=new JMenu("Inventory");
		admin=new JMenu("Admin");
		d1=new JMenu("   |   ");
		d2=new JMenu("   |   ");
		d3=new JMenu(" ");
		d4=new JMenu("   |   ");
		d5=new JMenu("   |   ");
		d1.setEnabled(false);
		d2.setEnabled(false);
		d3.setEnabled(false);
		d4.setEnabled(false);
		d5.setEnabled(false);
		
		String month[] ={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		String date_to[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String date_t[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
		String date_feb[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"};
		
		
		models[0] = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"});
		models[1] = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30"});
		models[2] = new DefaultComboBoxModel(new String[]{"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"});
		
		
		String year[]={"2012"};
		
		
		book_in_month = new JComboBox(month);
		book_in_month.addItemListener(this);
	
		book_in_date = new JComboBox(date_to);
		book_in_year = new JComboBox(year);
		
		
		book_out_month = new JComboBox(month);
		book_out_month.addItemListener(this);
		
		book_out_date = new JComboBox(date_to);
		book_out_year = new JComboBox(year);
		
		span=new JScrollPane();
		
		
		roombook_save=new JButton("Save");
		roombook_clear=new JButton("Clear");
		bill_g=new JButton("Genearate Bill");
		bill_clear=new JButton("Clear");
		
		
		
		
		room_detail=new JMenu("Room Details");
		new_b=new JMenu("New Booking");
		cancel_b=new JMenu("Cancel Booking");
		update=new JMenu("Update");
		logout=new JMenu("Logout");


		add_new=new JMenu("New Product");
		status_inv=new JMenu("Status");
	
		
		
		room_i=new JMenuItem("Room");
		room_i.setFont(new Font("Serif", Font.BOLD, 17));
		room_i.addActionListener(this);
				
		table_i=new JMenuItem("Table");
		table_i.setFont(new Font("Serif", Font.BOLD, 17));
		
		
		
		
		
		new_b.add(room_i);
		new_b.add(table_i);
		
		
		

		head=new JLabel("Room Booking");
		name=new JLabel("Name");
		
		table=new JCheckBox("Table",false);
		table.addItemListener(this);
		
		cab=new JCheckBox("Cab",false);
		cab.addItemListener(this);

		
		room_detail.setFont(new Font("Serif", Font.BOLD, 20));
		new_b.setFont(new Font("Serif", Font.BOLD, 20));
		cancel_b.setFont(new Font("Serif", Font.BOLD, 20));
		update.setFont(new Font("Serif", Font.BOLD, 20));
		logout.setFont(new Font("Serif", Font.BOLD, 20));
		status_inv.setFont(new Font("Serif", Font.BOLD, 20));
		add_new.setFont(new Font("Serif", Font.BOLD, 20));
		
		
		book.setFont(new Font("Serif", Font.BOLD, 20));
		bill.setFont(new Font("Serif", Font.BOLD, 20));
		inventory.setFont(new Font("Serif", Font.BOLD, 20));
		admin.setFont(new Font("Serif", Font.BOLD, 20));


		
		l1=new JLabel("Hotel Managament System");
		l1.setFont(new Font("Lucida Handwriting", Font.BOLD, 40));
		l1.setForeground(Color.cyan);





		ImagePanel panel = new ImagePanel(new ImageIcon("C:/Program Files/Xinox Software/JCreator Pro/MyProjects/MyProgram/HMS/hms.png").getImage());
		ImagePanel panel1 = new ImagePanel(new ImageIcon("C:/Program Files/Xinox Software/JCreator Pro/MyProjects/MyProgram/HMS/hmsg3.gif").getImage());




		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0,100,100,400);



		pn1.setBackground(Color.DARK_GRAY);
		pn1.setBounds(0,30,300,70);
		pn1.add(panel);


		pn2.setBackground(Color.DARK_GRAY);
		pn2.setBounds(305,30,725,70);
		pn2.add(l1);



		l2=new JLabel(new ImageIcon("C:/Program Files/Xinox Software/JCreator Pro/MyProjects/MyProgram/HMS/hmsg3.gif"));
		l2.setBounds(400,250,500,300);


		menuItem = new JMenuItem("A text-only menu item");
		

		book.add(menuItem);
		bill.add(menuItem);
		
			
		book.setForeground(new Color(	131, 139, 139 ));
		bill.setForeground(new Color(131, 139, 139));
		inventory.setForeground(new Color(131, 139, 139));
		admin.setForeground(new Color(131, 139, 139));
		
		
		
		
		menuBar.setBackground(new Color(188 ,210 ,238 ));
		menuBar.setBounds(0,120,1020,30);

		menuBar.add(d3);
		menuBar.add(book);
		menuBar.add(d1);
		menuBar.add(bill);
		menuBar.add(d2);
		menuBar.add(inventory);
		menuBar.add(d4);
		menuBar.add(admin);




		add(pn1);
		add(pn2);
		add(l2);

		add(menuBar);
		
		
		new_b.addMenuListener(this);
		logout.addMenuListener(this);
		new_b.addMenuListener(this);
		update.addMenuListener(this);
		room_detail.addMenuListener(this);
		add_new.addMenuListener(this);
		status_inv.addMenuListener(this);
		
		
		
	
		
		new_b.addMouseListener(this);
		cancel_b.addMouseListener(this);
		logout.addMouseListener(this);
		update.addMouseListener(this);
		room_detail.addMouseListener(this);
		status_inv.addMouseListener(this);
		add_new.addMouseListener(this);
	
		
		book.addMouseListener(this);
		bill.addMouseListener(this);
		inventory.addMouseListener(this);
		admin.addMouseListener(this);


		book.addMenuListener(this);
		bill.addMenuListener(this);
		inventory.addMenuListener(this);
		admin.addMenuListener(this);
		cancel_b.addMenuListener(this);
		

		bill_g.addActionListener(this);
	
		
		

		setVisible(true);

}	//home ends






//-------------------------item listener------------------------//


		public void itemStateChanged(ItemEvent ie)
		{
		//	System.out.println("item listener");
			Object o=ie.getItem();
			Object gs=ie.getSource();
						
			pn3.setLayout(null);
            pn3.setBorder(BorderFactory.createTitledBorder("  "));
			pn3.setBounds(0,150,1020,700);
					
	
    	    pn5.setLayout(null);
    	    pn5.setBorder(BorderFactory.createTitledBorder(" "));
			pn5.setBounds(381,00,630,550);
			
			
			
			if(o==table)
			{
				if(table.isSelected())
				{
						flag=1;
						System.out.println("changed");
					
					
						tp_t=new JLabel("Total Persons");
						tp_t.setBounds(30,380,150,20);
						tp_t.setFont(new Font("Serif", Font.BOLD, 18));
						pn5.add(tp_t);
						pn3.add(pn5);
					
					
						tpt_t=new JTextField("");
						tpt_t.setBounds(190,380,80,20);
						pn5.add(tpt_t);
						pn3.add(pn5);
					
					
					
						no_t=new JLabel("Total Tables");
						no_t.setBounds(30,410,150,20);
						no_t.setFont(new Font("Serif", Font.BOLD, 18));
						pn5.add(no_t);
						pn3.add(pn5);
					
					
						not_t=new JTextField("");
						not_t.setBounds(190,410,80,20);
						pn5.add(not_t);
						pn3.add(pn5);
					
					
					
					
						table_time=new JLabel("Time");
						table_time.setBounds(30,440,150,20);
						table_time.setFont(new Font("Serif", Font.BOLD, 18));
						pn5.add(table_time);
						pn3.add(pn5);
						
					
						tabletime_t=new JTextField("");
						tabletime_t.setBounds(190,440,80,20);
						pn5.add(tabletime_t);
						pn3.add(pn5);
					
                
					
						roombook_save.setBounds(130,480,100,20);
						pn5.add(roombook_save);
						pn3.add(pn5);
					
					
						roombook_clear.setBounds(260,480,100,20);
						pn5.add(roombook_clear);
						pn3.add(pn5);
					
					
					
						add(pn3);
					
						pn5.setVisible(true);
						pn3.setVisible(true); 
				
						setVisible(true);
					
				}	
				else
				{
					
						flag=0;
						roombook_save.setBounds(130,480,100,20);
						pn5.add(roombook_save);
						pn3.add(pn5);
				
				
						roombook_clear.setBounds(260,480,100,20);
						pn5.add(roombook_clear);
						pn3.add(pn5);
					
				
				
						tpt_t.setVisible(false);
						tp_t.setVisible(false);
						no_t.setVisible(false);
						not_t.setVisible(false);
						table_time.setVisible(false);
						tabletime_t.setVisible(false);	
					}				
		
		

		}
		
		
		
		if(o==cab)
		{
			if(cab.isSelected())
			{
				
					dest=new JLabel("Destination");
					dest.setBounds(290,380,100,20);	
					dest.setFont(new Font("Serif", Font.BOLD, 18));
					pn5.add(dest);
					pn3.add(pn5);
					
					
					dest_t=new JComboBox();
					dest_t.setBounds(420,380,100,20);		
					pn5.add(dest_t);
					pn3.add(pn5);
					
					
					roombook_save.setBounds(130,480,100,20);
					pn5.add(roombook_save);
					pn3.add(pn5);
					
					
					roombook_clear.setBounds(260,480,100,20);
					pn5.add(roombook_clear);
					pn3.add(pn5);
					
				
					add(pn3);
					
					pn5.setVisible(true);
					pn3.setVisible(true);
				
				
			}
			
			else
			{
				
					roombook_save.setBounds(130,480,100,20);
					pn5.add(roombook_save);
					pn3.add(pn5);
					
					
					roombook_clear.setBounds(260,480,100,20);
					pn5.add(roombook_clear);
					pn3.add(pn5);
					
									
					dest.setVisible(false);
					dest_t.setVisible(false);	
				
			}	
		}
		
		
			
		
		if(gs==book_in_month)
		{
			
			
			int Selection;
    		
    		Selection = book_in_month.getSelectedIndex();
    		
    		if(Selection==0 || Selection==2 || Selection==4 || Selection==6 || Selection==7 || Selection==9 || Selection==11)
    		{
    	
    			book_in_date.setModel(models[0]);
    		}
    		
    		if(Selection==3 || Selection==5 || Selection==8 || Selection==10 )
    		{
    		
    			book_in_date.setModel(models[1]);
    		}
    		
    		if(Selection==1)
    		{
    		
    			book_in_date.setModel(models[2]);
    		}
    		
    
    
			setVisible(true);
		}
		
		
		if(gs==book_out_month)
		{
			
			
			int Selection;
    		
    		Selection = book_out_month.getSelectedIndex();
    		
    		if(Selection==0 || Selection==2 || Selection==4 || Selection==6 || Selection==7 || Selection==9 || Selection==11)
    		{
    	
    			book_out_date.setModel(models[0]);
    		}
    		
    		if(Selection==3 || Selection==5 || Selection==8 || Selection==10 )
    		{
    		
    			book_out_date.setModel(models[1]);
    		}
    		
    		if(Selection==1)
    		{
    		
    			book_out_date.setModel(models[2]);
    		}
    		
    
    
			setVisible(true);
		}


}

//-------------------------end of item listener------------------------//








//-------------------------menu listener------------------------//

	
	public void menuSelected(MenuEvent ae)
	{
			Object b=ae.getSource();

			if(b==book)
			{

				Login lg=new Login();
				lg.setBounds(250,250,350,300);
				lg.setVisible(true);
				pn6.setVisible(false);
				pn7.setVisible(false);




				menuBar.setVisible(false);
				
				l2.setVisible(false);





				menuBar2=new JMenuBar();


				room_detail.setForeground(new Color(131, 139, 139));
				new_b.setForeground(new Color(131, 139, 139));
				cancel_b.setForeground(new Color(131, 139, 139));
				update.setForeground(new Color(131, 139, 139));
				logout.setForeground(new Color(131, 139, 139));


				menuBar2.setBackground(new Color(188 ,210 ,238 ));
				menuBar2.setBounds(0,120,1020,30);

				menuBar2.add(d3);
				menuBar2.add(room_detail);
				menuBar2.add(d1);
				menuBar2.add(new_b);
				menuBar2.add(d2);
				menuBar2.add(cancel_b);
				menuBar2.add(d4);
				menuBar2.add(update);
				menuBar2.add(d5);
				menuBar2.add(logout);

				add(menuBar2);

                 new_b.addMenuListener(this);


				pn3.setLayout(null);
				pn3.setBounds(0,150,1020,700);

                pn4.setLayout(null);
                pn4.setBounds(00, 00, 380, 500);

				status=new JLabel("Status");
				status.setFont(new Font("Serif", Font.BOLD, 20));
				status.setForeground(new Color(	160, 82 ,45 ));
				status.setBounds(100,40,90,30);
				pn4.add(status);
                   
                pn3.add(pn4);

				room_a=new JLabel("------Rooms Available-----");


                room_a.setFont(new Font("Serif", Font.BOLD, 20));
				room_a.setBounds(20,90,260,30);
				pn4.add(room_a);
                 
                pn3.add(pn4);


				table_a=new JLabel("-------Table Available------");

                table_a.setFont(new Font("Serif", Font.BOLD, 20));
				table_a.setBounds(20,180,260,30);
				pn4.add(table_a);

                pn3.add(pn4);


				add(pn3);
				pn3.setVisible(true);
                pn4.setVisible(true);
                
               


				setVisible(true);


			}


			
			
			if(b==bill)
			{
				
				Login lg=new Login();
				lg.setBounds(250,250,350,300);
				lg.setVisible(true);


				menuBar.setVisible(false);
				l2.setVisible(false);
				pn3.setVisible(false);
				pn4.setVisible(false);
				pn5.setVisible(false);


				menuBar2=new JMenuBar();
				menuBar2.setBackground(new Color(188 ,210 ,238 ));
				menuBar2.setBounds(0,120,1020,30);

				logout.setForeground(new Color(131, 139, 139));
							
				menuBar2.add(d3);
				menuBar2.add(logout);
				
				
				
				pn6.setLayout(null);
				pn6.setBounds(0,150,1020,700);

                pn7.setLayout(null);
                pn7.setBounds(00, 00, 380, 500);


				
				cust_detail=new JLabel("Customer Details");
				cust_detail.setFont(new Font("Serif", Font.BOLD, 20));
				cust_detail.setForeground(new Color(	160, 82 ,45 ));
				cust_detail.setBounds(120,40,180,30);
				pn7.add(cust_detail);
                   
                pn6.add(pn7);
				
				cust_name=new JLabel("Customer Name");
				cust_name.setBounds(40,100,140,30);
				cust_name.setFont(new Font("Serif", Font.BOLD, 20));
				pn7.add(cust_name);
				pn6.add(pn7);
				
				
				custname_t=new JTextField("");
				custname_t.setBounds(220,110,160,20);
				//custname_t.setFont(new Font("Serif", Font.BOLD, 20));
				pn7.add(custname_t);
				pn6.add(pn7);
				
				
				cust_no=new JLabel("Customer Number");
				cust_no.setBounds(40,150,170,30);
				cust_no.setFont(new Font("Serif", Font.BOLD, 20));
				pn7.add(cust_no);
				pn6.add(pn7);
				
				
				custno_t=new JTextField("");
				custno_t.setBounds(220,160,160,20);
				//custname_t.setFont(new Font("Serif", Font.BOLD, 20));
				pn7.add(custno_t);
				pn6.add(pn7);
				
			//	bill_g=new JButton("Genearate");
				bill_g.setBounds(100,210,120,20);
				pn7.add(bill_g);
				pn6.add(pn7);
				bill_g.addActionListener(this);
				
				
				bill_clear=new JButton("Clear");
				bill_clear.setBounds(250,210,130,20);
				pn7.add(bill_clear);
				pn6.add(pn7);
				bill_clear.addActionListener(this);
				
				
				add(pn6);
				pn6.setVisible(true);
				pn7.setVisible(true);
				add(menuBar2);
				
				setVisible(true);
				
			
			}

			if(b==logout)
			{


				menuBar2.setVisible(false);


				l1.setVisible(true);
				l2.setVisible(true);
				pn1.setVisible(true);
				pn2.setVisible(true);



				menuBar.add(d3);
				menuBar.add(book);
				menuBar.add(d1);
				menuBar.add(bill);
				menuBar.add(d2);
				menuBar.add(inventory);
				menuBar.add(d4);
				menuBar.add(admin);

				menuBar.setVisible(true);


				pn3.setVisible(false);
				pn4.setVisible(false);
				pn5.setVisible(false);
				pn6.setVisible(false);
				pn7.setVisible(false);
				pn8.setVisible(false);
				pn9.setVisible(false);
				pn10.setVisible(false);
				pn11.setVisible(false);


			}


			if(b==inventory)
			{
				new Login();
				//pn3.setVisible(false);
				pn4.setVisible(false);
				pn5.setVisible(false);
				pn6.setVisible(false);
				pn7.setVisible(false);
				
				
				menuBar.setVisible(false);
				l2.setVisible(false);
				


				menuBar2=new JMenuBar();
				menuBar2.setBackground(new Color(188 ,210 ,238 ));
				menuBar2.setBounds(0,120,1020,30);

				
				
				add_new.setForeground(new Color(131, 139, 139));
				
				
				status_inv.setForeground(new Color(131, 139, 139));
				
				menuBar2.add(d3);
				menuBar2.add(status_inv);
				menuBar2.add(d1);
				menuBar2.add(add_new);
				menuBar2.add(d2);
				menuBar2.add(logout);
				
				add(menuBar2);
				
				
				setVisible(true);
				
			}
			
			
			
			
			if(b==add_new)
			{
				pn9.setVisible(false);
				
				add(pn8);
				pn8.setLayout(null);
                //pn3.setBorder(BorderFactory.createTitledBorder("  "));
                pn8.setBorder(BorderFactory.createEmptyBorder());
				pn8.setBounds(0,150,1020,700);
				
				
				i_name=new JLabel("Name");
                i_name.setFont(new Font("Serif", Font.BOLD, 20));
                i_name.setBounds(170,40,100,30);
                pn8.add(i_name);
                
                iname_t=new JTextField("");
				iname_t.setBounds(340,50,160,20);
				pn8.add(iname_t);
				
			
				i_type=new JLabel("Type");
                i_type.setFont(new Font("Serif", Font.BOLD, 20));
                i_type.setBounds(170,70,100,30);
                pn8.add(i_type);
                
                itype_t=new JComboBox();
				itype_t.setBounds(340,80,150,20);
				pn8.add(itype_t);
				
				
				i_manu=new JLabel("Manufacturer");
                i_manu.setFont(new Font("Serif", Font.BOLD, 20));
                i_manu.setBounds(170,100,150,30);
                pn8.add(i_manu);
                
                imanu_t=new JTextField("");
				imanu_t.setBounds(340,110,160,20);
				pn8.add(imanu_t);
				
				
				i_qty=new JLabel("Quantity");
                i_qty.setFont(new Font("Serif", Font.BOLD, 20));
                i_qty.setBounds(170,130,150,30);
                pn8.add(i_qty);
                
                iqty_t=new JTextField("");
				iqty_t.setBounds(340,140,160,20);
				pn8.add(iqty_t);
                
                
                i_reorder=new JLabel("Re-Order Level");
                i_reorder.setFont(new Font("Serif", Font.BOLD, 20));
                i_reorder.setBounds(170,160,150,30);
                pn8.add(i_reorder);
                
                ireorder_t=new JTextField("");
				ireorder_t.setBounds(340,170,160,20);
				pn8.add(ireorder_t);
				
				
				i_rate=new JLabel("Rate");
                i_rate.setFont(new Font("Serif", Font.BOLD, 20));
                i_rate.setBounds(170,190,150,30);
                pn8.add(i_rate);
                
                irate_t=new JTextField("");
				irate_t.setBounds(340,200,160,20);
				pn8.add(irate_t);
                
                
                
                i_supln=new JLabel("Supplier Name");
                i_supln.setFont(new Font("Serif", Font.BOLD, 20));
                i_supln.setBounds(170,220,150,30);
                pn8.add(i_supln);
                
                isupln_t=new JTextField("");
				isupln_t.setBounds(340,230,160,20);
				pn8.add(isupln_t);
				
				
				i_suplc=new JLabel("Supplier Contact");
                i_suplc.setFont(new Font("Serif", Font.BOLD, 20));
                i_suplc.setBounds(170,250,150,30);
                pn8.add(i_suplc);
                
                isuplc_t=new JTextField("");
				isuplc_t.setBounds(340,260,160,20);
				pn8.add(isuplc_t);
				
				
				
				i_supla=new JLabel("Supplier Name");
                i_supla.setFont(new Font("Serif", Font.BOLD, 20));
                i_supla.setBounds(170,280,150,30);
                pn8.add(i_supla);
                
                isupla_t=new JTextField("");
				isupla_t.setBounds(340,290,160,20);
				pn8.add(isupla_t);
				
				
				i_save=new JButton("Save");
				i_save.setBounds(220,340,90,20);
				pn8.add(i_save);
				
				
				i_cancel=new JButton("Cancel");
				i_cancel.setBounds(340,340,90,20);
				pn8.add(i_cancel);
                
                
                              
                pn8.setVisible(true);
				setVisible(true);
			}
			
			
			
			if(b==status_inv)
			{
				pn8.setVisible(false);
				add(pn9);
				
				
				
				pn9.setLayout(null);
				pn9.setBorder(BorderFactory.createEmptyBorder());
				pn9.setBounds(0,150,900,700);
				
				
					
					System.out.println("in status");
					String str1[]={"Name","Type","Manu","Quantity","Reorder","Rate","S-Name","S-Addr","S-Contact"};
					for(int i=0;i<9;i++)
					{
						
						columnNames.addElement(str1[i]);
					}
					model = new DefaultTableModel(data,columnNames);			
					table1=new JTable(model);
					
					table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table1.setColumnSelectionAllowed(false);
					int v= ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
					int h= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
					table1.setDoubleBuffered(false);
						
					jsp1=new JScrollPane(table1,v,h);
					jsp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					jsp1.setPreferredSize(new Dimension(200,200));
					jsp1.setBounds(20,30,900,400);

		
		
					for( int i=0;i<9;i++)
					{ 
						TableColumn col = table1.getColumnModel().getColumn(i);
						if(i==0)	col.setPreferredWidth(100); 
						if(i==1)	col.setPreferredWidth(100);
						if(i==2)	col.setPreferredWidth(100);
						if(i==3)	col.setPreferredWidth(100);
						if(i==4)	col.setPreferredWidth(100);
						if(i==5)	col.setPreferredWidth(100);
						if(i==6)	col.setPreferredWidth(100);
						if(i==7)	col.setPreferredWidth(100);
						if(i==8)	col.setPreferredWidth(100);
						if(i==9)	col.setPreferredWidth(100);
			
					}	// for  ends
				
					JTableHeader header1 = table1.getTableHeader();
					header1.setBackground(new Color(178,175,188));
					flag++;
					
					pn9.add(jsp1);
									
					pn9.setVisible(true);
				
					setVisible(true);
	}
			

		
		
			if(b==admin)
			{
				new Login();
			}//admin ends
			
			
			
			if(b==cancel_b)
			
			{
				pn5.setVisible(false);
				System.out.println("in cancel");
				pn3.setLayout(null);
                pn3.setBorder(BorderFactory.createTitledBorder("  "));
				pn3.setBounds(0,150,1020,700);
			               
			    pn11.setLayout(null);
                pn11.setBorder(BorderFactory.createTitledBorder(" "));
				pn11.setBounds(381,00,630,550);
							
			
				cancel_book_head=new JLabel("Cancel Booking");
                cancel_book_head.setFont(new Font("Serif", Font.BOLD, 20));
                cancel_book_head.setBackground(new Color(	160, 82 ,45 ));
                cancel_book_head.setForeground(new Color(	160, 82 ,45 ));
				cancel_book_head.setBounds(150,40,160,30);
				
                pn11.add(cancel_book_head);
                pn3.add(pn11);
				
				
				cancel_book_custn=new JLabel(" Customer Name ");
				cancel_book_custn.setFont(new Font("Serif", Font.BOLD, 18));
				cancel_book_custn.setBounds(80,100,160,20);
				
				pn11.add(cancel_book_custn);
				pn3.add(pn11);
				
				
				cancel_book_custn_t=new JTextField("");
				cancel_book_custn_t.setFont(new Font("Serif", Font.BOLD, 18));
				cancel_book_custn_t.setBounds(250,100,200,20);
				
				pn11.add(cancel_book_custn_t);
				pn3.add(pn11);
				
				
				
				
				
				
				cancel_book_custno=new JLabel(" Customer Id ");
				cancel_book_custno.setFont(new Font("Serif", Font.BOLD, 18));
				cancel_book_custno.setBounds(80,140,160,20);
				
				pn11.add(cancel_book_custno);
				pn3.add(pn11);
				
				
				cancel_book_custno_t=new JTextField("");
				cancel_book_custno_t.setFont(new Font("Serif", Font.BOLD, 18));
				cancel_book_custno_t.setBounds(250,140,200,20);
				
				pn11.add(cancel_book_custno_t);
				pn3.add(pn11);
				
				
				
				book_cancel=new JButton("Cancel");
				book_cancel.setBounds(200,190,100,20);
				pn11.add(book_cancel);
				
				pn11.add(book_cancel);
				pn3.add(pn11);
				
				
				
				
				
				pn11.setVisible(true);
				pn3.setVisible(true);
				
				
				setVisible(true);
					
			}//cancel booking ends
	
	
	
	}	//menu selected ends
	
	
	
public void menuDeselected(MenuEvent e)
{

}

public void menuCanceled(MenuEvent e)
{

}



//-------------------------end of menu listener------------------------//




//-------------------------action listener------------------------//
	
	public void actionPerformed(ActionEvent ae)
	{
		
			Object k=ae.getSource();
		
		
			if(k==b1)
			
			{
				System.out.println("button ");	
				setVisible(true);		
			}
				
			if(k==room_i)
			{
				
				
                pn3.setLayout(null);
                pn3.setBorder(BorderFactory.createTitledBorder("  "));
				pn3.setBounds(0,150,1020,700);
			//	pn3.setBounds(0,150,1020,1000);

                pn5.setLayout(null);
                pn5.setBorder(BorderFactory.createTitledBorder(" "));
				pn5.setBounds(381,00,630,550);
			//	pn5.setBounds(381,00,630,800);
				
				//span.setPreferredSize(new Dimension(200,200));
				int v= ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
				int h= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
				
				span.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				
				table.setSelected(false);
				cab.setSelected(false);
				
				

				head=new JLabel("Room Booking");
                head.setFont(new Font("Serif", Font.BOLD, 20));
                head.setBackground(new Color(	160, 82 ,45 ));
                head.setForeground(new Color(	160, 82 ,45 ));
				head.setBounds(150,40,160,30);
				
                pn5.add(head);
                pn3.add(pn5);


				name=new JLabel("Name");
				name.setBounds(20,90,110,20);
				name.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(name);
				pn3.add(pn5);
				
				name_t=new JTextField("");
				name_t.setBounds(140,90,180,20);
				pn5.add(name_t);
				pn3.add(pn5);
				
				addr=new JLabel("Address");
				addr.setBounds(20,115,110,20);
				addr.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(addr);
				pn3.add(pn5);
				
				addr_t=new JTextField("");
				addr_t.setBounds(140,115,180,20);
				pn5.add(addr_t);
				pn3.add(pn5);
				
				state=new JLabel("State");
				state.setBounds(20,140,110,20);
				state.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(state);
				pn3.add(pn5);
				
				state_t=new JTextField("");
				state_t.setBounds(140,140,180,20);
				pn5.add(state_t);
				pn3.add(pn5);
				
				
				email=new JLabel("Email");
				email.setBounds(20,165,110,20);
				email.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(email);
				pn3.add(pn5);
				
				email_t=new JTextField("");
				email_t.setBounds(140,165,180,20);
				pn5.add(email_t);
				pn3.add(pn5);
				
				
				mob=new JLabel("Mobile");
				mob.setBounds(20,190,110,20);
				mob.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(mob);
				pn3.add(pn5);
				
				mob_t=new JTextField("");
				mob_t.setBounds(140,190,180,20);
				pn5.add(mob_t);
				pn3.add(pn5);
				
				
				in=new JLabel("In-Date");
				in.setBounds(20,215,110,20);
				in.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(in);
				pn3.add(pn5);
				
				
				book_in_month.setBounds(140,215,60,20);
				pn5.add(book_in_month);
				pn3.add(pn5);
				//book_in_month.addItemListener(this);
				
				book_in_date.setBounds(210,215,40,20);
				pn5.add(book_in_date);
				pn3.add(pn5);
				//book_in_date.addActionListener(this);
				
				book_in_year.setBounds(260,215,60,20);
				pn5.add(book_in_year);
				pn3.add(pn5);
					
				
				
				
			/*	in_t=new JTextField("");
				in_t.setBounds(140,215,100,20);
				pn5.add(in_t);
				pn3.add(pn5);
			
				
				b1=new JButton(new ImageIcon("C:/Program Files/Xinox Software/JCreator Pro/MyProjects/MyProgram/HMS/JDateChooserColor32.gif"));
				b1.setBounds(250,215,28,20);
				b1.addActionListener(this);
			
						
				pn5.add(b1);
				pn3.add(pn5);
				
			*/
			
			//	book_in_month = new JComboBox();
				
			
				out=new JLabel("Out-Date");
				out.setBounds(330,215,100,20);
				out.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(out);
				pn3.add(pn5);
				
				
				book_out_month.setBounds(440,215,60,20);
				pn5.add(book_out_month);
				pn3.add(pn5);
				
				book_out_date.setBounds(510,215,40,20);
				pn5.add(book_out_date);
				pn3.add(pn5);
				
				book_out_year.setBounds(560,215,60,20);
				pn5.add(book_out_year);
				pn3.add(pn5);
					
				
				
				
				nop=new JLabel("No.of persons");
				nop.setBounds(20,240,110,20);
				nop.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(nop);
				pn3.add(pn5);
				
				nop_t=new JTextField("");
				nop_t.setBounds(140,240,100,20);
				pn5.add(nop_t);
				pn3.add(pn5);
				
				
				
				night=new JLabel("Nights");
				night.setBounds(330,240,100,25);
				night.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(night);
				pn3.add(pn5);
				
				night_t=new JTextField("");
				night_t.setBounds(440,240,100,20);
				pn5.add(night_t);
				pn3.add(pn5);
				
				
				roomt=new JLabel("Room Type");
				roomt.setBounds(20,265,110,20);
				roomt.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(roomt);
				pn3.add(pn5);
				
				roomt_t=new JComboBox();
				roomt_t.setBounds(140,265,100,20);
				pn5.add(roomt_t);
				pn3.add(pn5);
				
				
				nor=new JLabel("No. of rooms");
				nor.setBounds(330,265,130,25);
				nor.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(nor);
				pn3.add(pn5);
				
				nor_t=new JTextField("");
				nor_t.setBounds(440,265,100,20);
				pn5.add(nor_t);
				pn3.add(pn5);
				
				
				
				
				book_room_no=new JLabel("Room No.");
				book_room_no.setBounds(20,290,110,20);
				book_room_no.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(book_room_no);
				pn3.add(pn5);
				
				book_room_no_t=new JTextField();
				book_room_no_t.setBounds(140,290,100,20);
				pn5.add(book_room_no_t);
				pn3.add(pn5);
                
                
                
               	other=new JLabel("Other Services");
                other.setFont(new Font("Serif", Font.BOLD, 20));
                other.setBackground(new Color(	160, 82 ,45 ));
               	other.setForeground(new Color(	160, 82 ,45 ));
				other.setBounds(170,320,160,30);
				
				pn5.add(other);
				pn3.add(pn5);
				
				
			//	table=new JCheckBox("Table");
				table.setBounds(50,350,110,25);
				table.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(table);
				pn3.add(pn5);
			//	table.addItemListener(this);
				
				
				
			//	cab=new JCheckBox("Cab");
				cab.setBounds(170,350,70,25);
				cab.setFont(new Font("Serif", Font.BOLD, 18));
				pn5.add(cab);
				pn3.add(pn5);
				
				
				roombook_save.setBounds(130,390,100,20);		
				
				pn5.add(roombook_save);
				pn3.add(pn5);
                
                
                roombook_clear.setBounds(260,390,100,20);		
				
				pn5.add(roombook_clear);
				pn3.add(pn5);
                
				
				//span=new JScrollPane(pn5,v,h);
			//	span.setBounds(381,00,630,550);
											
			
                
                
				
				pn3.add(pn5);;
                add(pn3);
                
               
                
               
                pn5.setVisible(true);
                pn3.setVisible(true);
			
				
				
				setVisible(true);	
		
		}
		
		
		
		if(k==bill_g)
		{
		
				
						
			
				
				pn6.setLayout(null);
                pn6.setBorder(BorderFactory.createTitledBorder("  "));
				pn6.setBounds(0,150,1020,700);
			
                pn10.setLayout(null);
                pn10.setBorder(BorderFactory.createTitledBorder(" "));
             	pn10.setBounds(381,00,630,550);
				
				
				
				
				bill_h=new JLabel("Bill");
                bill_h.setFont(new Font("Serif", Font.BOLD, 20));
                bill_h.setBackground(new Color(	160, 82 ,45 ));
                bill_h.setForeground(new Color(	160, 82 ,45 ));
				bill_h.setBounds(300,40,160,30);
				
                pn10.add(bill_h);
                pn6.add(pn10);
				
				
				
				bill_custn=new JLabel("Customer Name : ");
				bill_custn.setFont(new Font("Serif", Font.BOLD, 15));
				bill_custn.setBounds(40,70,120,30);
				
				pn10.add(bill_custn);
				pn6.add(pn10);
				
				
				
				bill_custn_t=new JLabel("");
				bill_custn_t.setFont(new Font("Serif", Font.BOLD, 15));
				bill_custn_t.setBounds(170,70,160,30);
				
				pn10.add(bill_custn_t);
				pn6.add(pn10);
				
				
				
				bill_date=new JLabel(" Date:");
				bill_date.setFont(new Font("Serif", Font.BOLD, 15));
				bill_date.setBounds(420,70,70,30);
				
				pn10.add(bill_date);
				pn6.add(pn10);
				
				
				Calendar currentDate = Calendar.getInstance();
 				SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd");
				String dateNow = formatter.format(currentDate.getTime());
				 
				bill_date_t=new JLabel("");
				bill_date_t.setBounds(465,75,130,20);
				bill_date_t.setFont(new Font("Serif", Font.BOLD, 15));
				bill_date_t.setText(dateNow);
				 
				pn10.add(bill_date_t);
				pn6.add(pn10);
				
				
				bill_room_type=new JLabel(" Room Type");
				bill_room_type.setFont(new Font("Serif", Font.BOLD, 18));
				bill_room_type.setBounds(50,120,130,30);
				
				pn10.add(bill_room_type);
				pn6.add(pn10);
				
				
				bill_room_type_t=new JLabel("");
				bill_room_type_t.setFont(new Font("Serif", Font.BOLD, 18));
				bill_room_type_t.setBounds(190,120,130,30);
				
				pn10.add(bill_room_type_t);
				pn6.add(pn10);
				
				
				bill_nod=new JLabel(" No Of Day");
				bill_nod.setFont(new Font("Serif", Font.BOLD, 18));
				bill_nod.setBounds(50,150,130,30);
				
				pn10.add(bill_nod);
				pn6.add(pn10);
				
				
				bill_nod_t=new JLabel("");
				bill_nod_t.setFont(new Font("Serif", Font.BOLD, 18));
				bill_nod_t.setBounds(190,150,60,30);
				
				pn10.add(bill_nod_t);
				pn6.add(pn10);
				
				
				
				
				bill_nop=new JLabel(" No Of People");
				bill_nop.setFont(new Font("Serif", Font.BOLD, 18));
				bill_nop.setBounds(50,180,130,30);
				
				pn10.add(bill_nop);
				pn6.add(pn10);
				
				
				bill_nop_t=new JLabel("");
				bill_nop_t.setFont(new Font("Serif", Font.BOLD, 18));
				bill_nop_t.setBounds(190,180,60,30);
				
				pn10.add(bill_nop_t);
				pn6.add(pn10);
				
				
				
				
				
				
				bill_meal=new JLabel(" Meals ");
				bill_meal.setFont(new Font("Serif", Font.BOLD, 18));
				bill_meal.setBounds(50,210,130,30);
				
				pn10.add(bill_meal);
				pn6.add(pn10);
				
				
				bill_meal_t=new JLabel("");
				bill_meal_t.setFont(new Font("Serif", Font.BOLD, 18));
				bill_meal_t.setBounds(190,210,60,30);
				
				pn10.add(bill_meal_t);
				pn6.add(pn10);
				
				
				
				
				
				bill_cab=new JLabel(" Cab Service");
				bill_cab.setFont(new Font("Serif", Font.BOLD, 18));
				bill_cab.setBounds(50,240,130,30);
				
				pn10.add(bill_cab);
				pn6.add(pn10);
				
				
				bill_cab_t=new JLabel("");
				bill_cab_t.setFont(new Font("Serif", Font.BOLD, 18));
				bill_cab_t.setBounds(190,240,60,30);
				
				pn10.add(bill_cab_t);
				pn6.add(pn10);
				
				
				
				
				
				bill_total=new JLabel(" Total ");
				bill_total.setFont(new Font("Serif", Font.BOLD, 18));
				bill_total.setBounds(50,270,130,30);
				
				pn10.add(bill_total);
				pn6.add(pn10);
				
				
				bill_total_t=new JLabel("");
				bill_total_t.setFont(new Font("Serif", Font.BOLD, 18));
				bill_total_t.setBounds(190,270,60,30);
				
				pn10.add(bill_total_t);
				pn6.add(pn10);
				
				
				
				bill_print=new JButton("Print");
				bill_print.setBounds(200,330,90,20);
				pn10.add(bill_print);
				pn6.add(pn10);
				
							
				pn6.setVisible(true);
				pn10.setVisible(true);
				
				setVisible(true);
		}
		
		
		
		
}//end of action performed
	
	


//-------------------------end of action listener------------------------//
	
	


//-----------------//mouse listener//---------------------//





	public void mouseClicked(MouseEvent me)
	{
		Object o=me.getSource();
		
		if(o==l4)
			System.out.print("image clicked");
	}//end of mouse clicked
	
	
	
	
	public void mouseEntered(MouseEvent me)
	{
		
		Object o=me.getSource();
		
		if(o==book)
			book.setForeground(Color.black);
	
		if(o==bill)
			bill.setForeground(Color.black);
			
		if(o==inventory)
			inventory.setForeground(Color.black);
			
		if(o==admin)
			admin.setForeground(Color.black);
			
		if(o==room_detail)
			room_detail.setForeground(Color.black);	
		
		if(o==new_b)
			new_b.setForeground(Color.black);
	
		if(o==cancel_b)
			cancel_b.setForeground(Color.black);
			
		if(o==update)
			update.setForeground(Color.black);
			
		if(o==logout)
			logout.setForeground(Color.black);
			
		if(o==status_inv)
			status_inv.setForeground(Color.black);
		
		if(o==add_new)
			add_new.setForeground(Color.black);
		
		
		
	}//end of mouse entered	
	
	
	
	
	public void mouseExited(MouseEvent me)
	{
		
		Object o=me.getSource();
		
		if(o==book)
			book.setForeground(new Color(131, 139, 139));
		
		if(o==bill)
			bill.setForeground(new Color(131, 139, 139));
	
		if(o==inventory)
			inventory.setForeground(new Color(131, 139, 139));
		
		if(o==admin)
			admin.setForeground(new Color(131, 139, 139));
			
			
		if(o==room_detail)
			room_detail.setForeground(new Color(131, 139, 139));
		
		if(o==new_b)
			new_b.setForeground(new Color(131, 139, 139));
		
		if(o==cancel_b)
			cancel_b.setForeground(new Color(131, 139, 139));
		
		if(o==update)
			update.setForeground(new Color(131, 139, 139));
			
		if(o==status_inv)
			status_inv.setForeground(new Color(131, 139, 139));
			
		if(o==add_new)
			add_new.setForeground(new Color(131, 139, 139));
	
		if(o==logout)
			logout.setForeground(new Color(131, 139, 139));
		
		
			
	}//end of mouse exited
	
	
	
	
	public void mouseReleased(MouseEvent me)
	{
		
	}//end of mouse released
	
	
	public void mousePressed(MouseEvent me)
	{
		
	}//end of mouse pressed
	
	
//-----------------------------end of mouse listener----------------------//


	public static void main(String args[]) throws Exception
	{
		 Home h=new Home();


		h.setVisible(true);
		h.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


}
