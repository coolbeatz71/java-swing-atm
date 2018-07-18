import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankHistory extends JFrame implements ActionListener{

	//here is our variables for checking if the user was logged or not

    public static String rsCardNumber="";
    public static String rsUsername="";
    public static String rsPinNumber="";
    public static String rsUserId="";
    public static double rsBalance=0;
    public static String balance="";

    //database connection variables
    String conString = "jdbc:mysql://localhost/atm";
    String username = "root";
    String password = "1234glody";


	//definition our four JTables and their titles

	JTable tblDeposit;
	JTable tblWithdraw;
	JTable tblTransfer;
	JTable tblPhoneTransfer;

    //here is the creation of our components
	JPanel panelDeposit;
	JPanel panelWithdraw;
	JPanel panelTransfer;
	JPanel panelPhoneTransfer;
	JPanel contentPane;
	JButton btnBackToMenu;
	
	JLabel lblBalance;
	JLabel lblDeposit;
	JLabel lblWithdraw;
	JLabel lblTransfer;
	JLabel lblTransferPhone;
	JTextField textField;
		   
    //the constructor
	public BankHistory(){

			    //our session
				Login loggin=new Login();

			    String myUserId = loggin.getUserId();
				String myCardNumber=loggin.getCardNumber();
				String myPinNumber=loggin.getPinNumber();
				String myUserName=loggin.getUsername();

				setTitle("BANK HISTORY");
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				setBounds(100, 100, 939, 549);

				//defining the main content and his layout (SpringLayout) 
				contentPane = new JPanel();
				setContentPane(contentPane);
				SpringLayout layout = new SpringLayout();
				contentPane.setLayout(layout);

				//defining constraints for all ours components, and adding Font to JLabel and EtchedBorder to every JPanel 
				
				btnBackToMenu = new JButton("BACK TO MENU");
				layout.putConstraint(SpringLayout.EAST, btnBackToMenu, -53, SpringLayout.EAST, contentPane);
				btnBackToMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
				layout.putConstraint(SpringLayout.NORTH, btnBackToMenu, -53, SpringLayout.SOUTH, contentPane);
				layout.putConstraint(SpringLayout.SOUTH, btnBackToMenu, -10, SpringLayout.SOUTH, contentPane);
				contentPane.add(btnBackToMenu);
				btnBackToMenu.addActionListener(this);
				
				lblBalance = new JLabel("CURRENT BALANCE (RWF) :");
				layout.putConstraint(SpringLayout.SOUTH, lblBalance, -10, SpringLayout.SOUTH, contentPane);
				lblBalance.setFont(new Font("Tahoma", Font.BOLD, 12));
				contentPane.add(lblBalance);
				
				textField = new JTextField();
				textField.setFont(new Font ("Tahoma", Font.BOLD, 13));
				layout.putConstraint(SpringLayout.WEST, btnBackToMenu, 80, SpringLayout.EAST, textField);
				layout.putConstraint(SpringLayout.WEST, textField, 18, SpringLayout.EAST, lblBalance);
				layout.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, btnBackToMenu);
				layout.putConstraint(SpringLayout.EAST, textField, -555, SpringLayout.EAST, contentPane);
				textField.setEditable(false);
				contentPane.add(textField);
				textField.setColumns(10);
				
				panelDeposit = new JPanel();
				panelDeposit.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				layout.putConstraint(SpringLayout.WEST, panelDeposit, 10, SpringLayout.WEST, contentPane);
				layout.putConstraint(SpringLayout.WEST, lblBalance, 0, SpringLayout.WEST, panelDeposit);
				layout.putConstraint(SpringLayout.NORTH, panelDeposit, 27, SpringLayout.NORTH, contentPane);
				layout.putConstraint(SpringLayout.SOUTH, panelDeposit, 212, SpringLayout.NORTH, contentPane);
				contentPane.add(panelDeposit);
				
				
				panelWithdraw = new JPanel();
				layout.putConstraint(SpringLayout.WEST, panelWithdraw, 494, SpringLayout.WEST, contentPane);
				layout.putConstraint(SpringLayout.EAST, panelWithdraw, -10, SpringLayout.EAST, contentPane);
				panelWithdraw.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				layout.putConstraint(SpringLayout.EAST, panelDeposit, -75, SpringLayout.WEST, panelWithdraw);
				layout.putConstraint(SpringLayout.NORTH, panelWithdraw, 0, SpringLayout.NORTH, panelDeposit);
				layout.putConstraint(SpringLayout.SOUTH, panelWithdraw, 0, SpringLayout.SOUTH, panelDeposit);
				contentPane.add(panelWithdraw);
				
				lblDeposit = new JLabel("DEPOSIT HISTORY");
				layout.putConstraint(SpringLayout.WEST, lblDeposit, 154, SpringLayout.WEST, contentPane);
				layout.putConstraint(SpringLayout.SOUTH, lblDeposit, -2, SpringLayout.NORTH, panelDeposit);
				lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 12));
				contentPane.add(lblDeposit);
				
				lblWithdraw = new JLabel("WITHDRAW HISTORY");
				layout.putConstraint(SpringLayout.SOUTH, lblWithdraw, -6, SpringLayout.NORTH, panelWithdraw);
				layout.putConstraint(SpringLayout.EAST, lblWithdraw, -137, SpringLayout.EAST, contentPane);
				lblWithdraw.setFont(new Font("Tahoma", Font.BOLD, 12));
				contentPane.add(lblWithdraw);
				
				panelTransfer = new JPanel();
				panelTransfer.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				layout.putConstraint(SpringLayout.WEST, panelTransfer, 10, SpringLayout.WEST, contentPane);
				layout.putConstraint(SpringLayout.EAST, panelTransfer, -480, SpringLayout.EAST, contentPane);
				layout.putConstraint(SpringLayout.NORTH, panelTransfer, 32, SpringLayout.SOUTH, panelDeposit);
				layout.putConstraint(SpringLayout.SOUTH, panelTransfer, -18, SpringLayout.NORTH, btnBackToMenu);
				contentPane.add(panelTransfer);
				
				panelPhoneTransfer = new JPanel();
				layout.putConstraint(SpringLayout.WEST, panelPhoneTransfer, 466, SpringLayout.WEST, contentPane);
				panelPhoneTransfer.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				layout.putConstraint(SpringLayout.NORTH, panelPhoneTransfer, 32, SpringLayout.SOUTH, panelWithdraw);
				layout.putConstraint(SpringLayout.SOUTH, panelPhoneTransfer, 0, SpringLayout.SOUTH, panelTransfer);
				layout.putConstraint(SpringLayout.EAST, panelPhoneTransfer, -10, SpringLayout.EAST, contentPane);
				contentPane.add(panelPhoneTransfer);
				
				lblTransfer = new JLabel("ACCOUNT TRANSFER HISTORY");
				layout.putConstraint(SpringLayout.SOUTH, lblTransfer, -6, SpringLayout.NORTH, panelTransfer);
				layout.putConstraint(SpringLayout.EAST, lblTransfer, 0, SpringLayout.EAST, lblDeposit);
				lblTransfer.setFont(new Font("Tahoma", Font.BOLD, 12));
				contentPane.add(lblTransfer);
				
				lblTransferPhone = new JLabel("TRANSFER PHONE HISTORY");
				layout.putConstraint(SpringLayout.SOUTH, lblTransferPhone, -6, SpringLayout.NORTH, panelPhoneTransfer);
				layout.putConstraint(SpringLayout.EAST, lblTransferPhone, -151, SpringLayout.EAST, contentPane);
				lblTransferPhone.setFont(new Font("Tahoma", Font.BOLD, 12));
				contentPane.add(lblTransferPhone);
		                
				if(myUserId !="") {

		    try{

						Connection con = DriverManager.getConnection(conString, username, password);
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT * FROM  user_account  WHERE  id_user='"+myUserId+"'");
	                        
	                while(rs.next()){

	                    rsUserId=rs.getString(1);
						rsUsername=rs.getString(2);
						rsCardNumber=rs.getString(3);
						rsPinNumber=rs.getString(4);
						rsBalance = rs.getDouble(5);
				    }
                    //Display the history only if the user was logged in!!
				    if(rsUserId.equals(myUserId)){
				    	

				    	//Display the balance of the user
				    	balance = balance.valueOf(rsBalance);
				    	textField.setText(balance+"  RWF");

				    	//Variables for all history query
				    	String transaction="";
				    	String date="";
				    	String code="";
				    	String alreadyReceived="";
				    	double amount=0;
				    	String phoneNumber="";

				    	//displaying the tblDeposit History
                        DefaultTableModel model;
						model = new DefaultTableModel(); 
						tblDeposit = new  JTable(model);
						model.addColumn("TRANSACTION");
                        model.addColumn("DATE OF TRANSACTION");
                        model.addColumn("AMOUNT");
				    	Statement stmt1 = con.createStatement();
				    	ResultSet rs1 = stmt1.executeQuery("SELECT * FROM deposit WHERE id_user='"+myUserId+"' ORDER BY date_deposit");

				    	while(rs1.next()){
				    		transaction = rs1.getString(5);
				    		       date = rs1.getString(3);
				    		     amount = rs1.getDouble(2);

				    		model.addRow(new Object[]{transaction,date, amount});
				    	}
						panelDeposit.setLayout(new BorderLayout());
						panelDeposit.add(tblDeposit.getTableHeader(), BorderLayout.NORTH);
						panelDeposit.add(new JScrollPane(tblDeposit), BorderLayout.CENTER);

						stmt1.close();

						//display the tblWithdraw History
						DefaultTableModel model2;
						model2 = new DefaultTableModel();
						tblWithdraw = new  JTable(model2);
						model2.addColumn("TRANSACTION");
                        model2.addColumn("DATE OF TRANSACTION");
                        model2.addColumn("AMOUNT");
				    	Statement stmt2 = con.createStatement();
				    	ResultSet rs2 = stmt2.executeQuery("SELECT * FROM withdraw WHERE id_user='"+myUserId+"' ORDER BY date_withdraw");

				    	while(rs2.next()){
				    		transaction = rs2.getString(5);
				    		       date = rs2.getString(3);
				    		     amount = rs2.getDouble(2);

				    		model2.addRow(new Object[]{transaction,date, amount});
				    	}
						panelWithdraw.setLayout(new BorderLayout());
						panelWithdraw.add(tblWithdraw.getTableHeader(), BorderLayout.NORTH);
						panelWithdraw.add(new JScrollPane(tblWithdraw), BorderLayout.CENTER);
                        
                        stmt2.close();

                        //display the tblTransfer History
						DefaultTableModel model3;
						model3 = new DefaultTableModel();
						tblTransfer = new  JTable(model3);
                        model3.addColumn("DATE OF TRANSACTION");
                        model3.addColumn("AMOUNT");
                        model3.addColumn("CODE TRANSFER");
				    	Statement stmt3 = con.createStatement();
				    	ResultSet rs3 = stmt3.executeQuery("SELECT * FROM transfer WHERE id_user='"+myUserId+"' ORDER BY transfer_date");

				    	while(rs3.next()){
				    		       date = rs3.getString(4);
				    		     amount = rs3.getDouble(5);
				    		       code = rs3.getString(3);

				    		model3.addRow(new Object[]{date, amount, code});
				    	}
						panelTransfer.setLayout(new BorderLayout());
						panelTransfer.add(tblTransfer.getTableHeader(), BorderLayout.NORTH);
						panelTransfer.add(new JScrollPane(tblTransfer), BorderLayout.CENTER);
                        
                        stmt3.close();

                        //display the tblPhoneTransfer History
						DefaultTableModel model4;
						model4 = new DefaultTableModel();
						tblPhoneTransfer = new  JTable(model4);
                        model4.addColumn("DATE OF TRANSACTION");
                        model4.addColumn("AMOUNT");
                        model4.addColumn("PHONE NUMBER");
                        model4.addColumn("CODE TRANSFER");
                        model4.addColumn("RECEIVED");
				    	Statement stmt4 = con.createStatement();
				    	ResultSet rs4 = stmt4.executeQuery("SELECT * FROM transfer_phone WHERE id_user='"+myUserId+"' ORDER BY date_transfer");

				    	while(rs4.next()){
				    		       date = rs4.getString(3);
				    		     amount = rs4.getDouble(4);
                            phoneNumber = rs4.getString(5);
				    		       code = rs4.getString(2);
				        alreadyReceived = rs4.getString(6);

				    		model4.addRow(new Object[]{date, amount, phoneNumber, code, alreadyReceived});
				    	}
						panelPhoneTransfer.setLayout(new BorderLayout());
						panelPhoneTransfer.add(tblPhoneTransfer.getTableHeader(), BorderLayout.NORTH);
						panelPhoneTransfer.add(new JScrollPane(tblPhoneTransfer), BorderLayout.CENTER);
				                        
                        stmt4.close();

                        //here the code for changing the width of some column, the index start from zero
                        tblDeposit.getColumnModel().getColumn(1).setPreferredWidth(180);
                        tblWithdraw.getColumnModel().getColumn(1).setPreferredWidth(180);
                        tblTransfer.getColumnModel().getColumn(2).setPreferredWidth(240);
                        tblPhoneTransfer.getColumnModel().getColumn(3).setPreferredWidth(240);				        
                           				    	                       
					}else{

					    JOptionPane.showMessageDialog(null,"Login First please!!!","Error",JOptionPane.ERROR_MESSAGE);
					   // System.exit(0);	

					}

				    stmt.close();


			}catch(SQLException err){

						System.out.println(err.getMessage());
						System.exit(0);

			}
				
	    }else{

				JOptionPane.showMessageDialog(null,"Login First please!!!","Error",JOptionPane.ERROR_MESSAGE);
			//	System.exit(0);

	    } 
		

	}
    //event for the back to menu JButton
 	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();

		if(source==btnBackToMenu){

			MainFrame panel = new MainFrame();
			panel.setSize(470,300);
			panel.setVisible(true);
			panel.setResizable(false);
			panel.setLocation(400,250);
			dispose();
		}
	}
    
	public static void main(String[] args) {

		BankHistory log = new BankHistory();

		log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    log.setBounds(100, 100, 939, 549);
	    log.setResizable(false);
	    log.setVisible(true);
	}

}