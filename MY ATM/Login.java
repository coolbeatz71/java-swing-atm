import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame{


    public static String rsCardNumber="";
    public static String rsUsername="";
	public static String rsPinNumber="";
	public static String rsUserId="";

	//here is the methods to receive argumments and change it to a string  
	static String toString(String[] args)
	{
		String argument="";
		for(String str : args)
		argument += str;
	    return argument;	
		
	}

	/*   the methods setDataBaseInfo will help us to determine if the user didn't visit any other windows without passing by the login window
         we will use this methods in all our others windows! it acts like session in php

	*/
	public void setDataBaseInfo(String[] args){

		String conString = "jdbc:mysql://localhost/atm";
		String username = "root";
		String password = "1234glody";

		String cn=toString(args);
		
		try{

			Connection con = DriverManager.getConnection(conString, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM  user_account  WHERE  card_number='"+cn+"'");
                        
                while(rs.next()){

                    rsUserId=rs.getString(1);
					rsUsername=rs.getString(2);
					rsCardNumber=rs.getString(3);
					rsPinNumber=rs.getString(4);
			    }

			    stmt.close();


		}catch(SQLException err){

			System.out.println(err.getMessage());
			System.exit(0);

		}
	}

	public String getUserId(){

		return rsUserId;
	}

	public String getCardNumber(){

		return rsCardNumber;
	}

	public String getUsername(){

		return rsUsername;
	}

	public String getPinNumber(){

		return rsPinNumber;
	}

	//The main method

	public static void main(String[] args) {

		String txt="";
		String cardNumber = toString(args);

		Login log= new Login();
		log.setDataBaseInfo(args);

		if (cardNumber==txt) {

			//if there is no arguments then redirect the user we he can receive his money by defining both is number and the transfer code

		  PhoneTransferReceiver login = new PhoneTransferReceiver();

		  login.setTitle("Receive Your Money");
		  login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  login.setBounds(100, 100, 656, 224);
		  login.setVisible(true);
		  login.setResizable(false);

		}
		else{

			//if there is an argument then redirect the user where he can signal his password that we will check if his account exist  

			String myCardNumber=log.getCardNumber();
			String myPinNumber=log.getPinNumber();
			String myUserName=log.getUsername();
			

			if(cardNumber.equals(myCardNumber)) {

		    	JOptionPane takePin= new JOptionPane();
		    	JPasswordField pwd = new JPasswordField(10);
                
                while(true){

                   int action = JOptionPane.showConfirmDialog(null, pwd,"Enter The Pin Number",JOptionPane.DEFAULT_OPTION);

                if(action < 0){
                	JOptionPane.showMessageDialog(null,"Bye Bye","Information",JOptionPane.INFORMATION_MESSAGE);
                	System.exit(0);

                }
                   
                else{

                   	String strPinNumber = new String(pwd.getPassword());
                   	if(myPinNumber.equals(strPinNumber)){

                   		    break;		
		                    
		            }
                   }	

                   	

                }

                //if the account exist then greate the user and redirect him to the main frame

		            JOptionPane.showMessageDialog(null,"Welcome "+myUserName,"Welcome",JOptionPane.INFORMATION_MESSAGE);
							
							MainFrame panel = new MainFrame();
							panel.setSize(470,300);
							panel.setVisible(true);
							panel.setResizable(false);
							panel.setLocation(450,250);
							panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
																	    	
		    }else{

		   	System.out.println("Sorry! This account doesn't Exist");

		   }


		}		
	}
}