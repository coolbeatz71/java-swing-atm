import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.Date;
import java.util.UUID;

public class TransferPhone extends JFrame implements ActionListener{

        public String myTransferCode = UUID.randomUUID().toString();
        public JPanel contentPane;
	    public  JButton btn0;
		public  JButton btn1;
		public  JButton btn2;
		public  JButton btn3;
		public  JButton btn4;
		public  JButton btn5;
		public  JButton btn6;
		public  JButton btn7;
		public  JButton btn8;
		public  JButton btn9;
		public  JButton btnClear;
		public  JButton btnVirgule;
		public  JButton btnTransferPhone;
		public  JButton btnBackToMenu;

		//button for the phone number

		public  JButton btn0Phone;
		public  JButton btn1Phone;
		public  JButton btn2Phone;
		public  JButton btn3Phone;
		public  JButton btn4Phone;
		public  JButton btn5Phone;
		public  JButton btn6Phone;
		public  JButton btn7Phone;
		public  JButton btn8Phone;
		public  JButton btn9Phone;
		public  JButton btnClearPhone; 
		
		public  JTextField textField;
		
		public  String display;
		public String displayPhone;
		public String concatenateWithZip;

		public JTextField phoneNumber;
		public JTextField codeZip;

		public static String rsCardNumber="";
        public static String rsUsername="";
	    public static String rsPinNumber="";
	    public static String rsUserId="";
	    public static double rsBalance=0;


		Date myTime = new Date();
	    String myDate = myTime.toString();
	
	public TransferPhone(){

		btn0 = new JButton("0");
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btnClear = new JButton("C");
		btnVirgule = new JButton(".");
		textField = new JTextField();

		btn0Phone = new JButton("0");
		btn1Phone = new JButton("1");
		btn2Phone = new JButton("2");
		btn3Phone = new JButton("3");
		btn4Phone = new JButton("4");
		btn5Phone = new JButton("5");
		btn6Phone = new JButton("6");
		btn7Phone = new JButton("7");
		btn8Phone = new JButton("8");
		btn9Phone = new JButton("9");
		btnClearPhone = new JButton("C");


		contentPane = new JPanel();
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();

		contentPane.setLayout(layout);
		
		JPanel content = new JPanel();

		content.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		layout.putConstraint(SpringLayout.NORTH, content, 70, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, content, 36, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, content, -37, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, content, 179, SpringLayout.WEST, contentPane);
		contentPane.add(content);
		
		JLabel title = new JLabel("Enter the Amount");
		layout.putConstraint(SpringLayout.WEST, title, 44, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, title, -15, SpringLayout.NORTH, content);
		layout.putConstraint(SpringLayout.EAST, title, 100, SpringLayout.EAST, contentPane);
		title.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		contentPane.add(title);

		content.setLayout(new GridLayout(4,3));

		content.add(btn7);
		content.add(btn8);
		content.add(btn9);
		content.add(btn4);
		content.add(btn5);
		content.add(btn6);
		content.add(btn1);
		content.add(btn2);
		content.add(btn3);
		content.add(btn0);
		content.add(btnClear);
		content.add(btnVirgule);


		JPanel panelNumber = new JPanel();
		layout.putConstraint(SpringLayout.NORTH, panelNumber, 0, SpringLayout.NORTH, content);
		layout.putConstraint(SpringLayout.WEST, panelNumber, -213, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, panelNumber, 0, SpringLayout.SOUTH, content);
		layout.putConstraint(SpringLayout.EAST, panelNumber, -60, SpringLayout.EAST, contentPane);
		panelNumber.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelNumber);


		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.TRAILING);
		textField.setEditable(false);
		layout.putConstraint(SpringLayout.NORTH, textField, 102, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, textField, 45, SpringLayout.EAST, content);
		layout.putConstraint(SpringLayout.EAST, textField, -133, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblRwf = new JLabel("RWF");
		layout.putConstraint(SpringLayout.NORTH, lblRwf, 4, SpringLayout.NORTH, textField);
		layout.putConstraint(SpringLayout.WEST, lblRwf, 21, SpringLayout.EAST, textField);
		lblRwf.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblRwf);
		
		btnTransferPhone = new JButton("TransferPhone");
		layout.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, btnTransferPhone);
		layout.putConstraint(SpringLayout.WEST, btnTransferPhone, 45, SpringLayout.EAST, content);
		layout.putConstraint(SpringLayout.EAST, btnTransferPhone, -40, SpringLayout.WEST, panelNumber);
		layout.putConstraint(SpringLayout.NORTH, btnTransferPhone, 146, SpringLayout.NORTH, contentPane);
		btnTransferPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnTransferPhone);
		
		btnBackToMenu = new JButton("Back to Menu");
		layout.putConstraint(SpringLayout.SOUTH, btnTransferPhone, -6, SpringLayout.NORTH, btnBackToMenu);
		btnBackToMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		layout.putConstraint(SpringLayout.NORTH, btnBackToMenu, 200, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, btnBackToMenu, -20, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, btnBackToMenu, 45, SpringLayout.EAST, content);
		layout.putConstraint(SpringLayout.EAST, btnBackToMenu, -40, SpringLayout.WEST, panelNumber);
		contentPane.add(btnBackToMenu);

		JLabel lblDestinationPhoneNumber = new JLabel("Phone");
		layout.putConstraint(SpringLayout.WEST, lblRwf, 0, SpringLayout.WEST, lblDestinationPhoneNumber);
		layout.putConstraint(SpringLayout.WEST, lblDestinationPhoneNumber, 206, SpringLayout.EAST, content);
		lblDestinationPhoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		layout.putConstraint(SpringLayout.NORTH, lblDestinationPhoneNumber, 0, SpringLayout.NORTH, content);
		contentPane.add(lblDestinationPhoneNumber);
		
		phoneNumber = new JTextField();
		phoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		phoneNumber.setEditable(false);
		layout.putConstraint(SpringLayout.SOUTH, phoneNumber, -171, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.NORTH, textField, 12, SpringLayout.SOUTH, phoneNumber);
		layout.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, phoneNumber);
		layout.putConstraint(SpringLayout.WEST, phoneNumber, 261, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.EAST, phoneNumber, -20, SpringLayout.WEST, lblDestinationPhoneNumber);
		contentPane.add(phoneNumber);
		phoneNumber.setColumns(10);
		
		codeZip = new JTextField();
		layout.putConstraint(SpringLayout.SOUTH, codeZip, -12, SpringLayout.NORTH, textField);
		codeZip.setEditable(false);
		codeZip.setText("+250");
		layout.putConstraint(SpringLayout.WEST, codeZip, 44, SpringLayout.EAST, content);
		layout.putConstraint(SpringLayout.EAST, codeZip, -6, SpringLayout.WEST, phoneNumber);
		contentPane.add(codeZip);
		codeZip.setColumns(10);

		
		JLabel lblPhone = new JLabel("Type the phone number");
		layout.putConstraint(SpringLayout.NORTH, lblPhone, 0, SpringLayout.NORTH, title);
		layout.putConstraint(SpringLayout.EAST, lblPhone, -50, SpringLayout.EAST, contentPane);
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPhone);
		panelNumber.setLayout(new GridLayout(4,3));

		panelNumber.add(btn7Phone);
		panelNumber.add(btn8Phone);
		panelNumber.add(btn9Phone);
		panelNumber.add(btn4Phone);
		panelNumber.add(btn5Phone);
		panelNumber.add(btn6Phone);
		panelNumber.add(btn1Phone);
		panelNumber.add(btn2Phone);
		panelNumber.add(btn3Phone);
		panelNumber.add(btn0Phone);
		panelNumber.add(btnClearPhone);

		btn0.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btnClear.addActionListener(this);
		btnVirgule.addActionListener(this);
		btnBackToMenu.addActionListener(this);
		btnTransferPhone.addActionListener(this);

		btn0Phone.addActionListener(this);
		btn1Phone.addActionListener(this);
		btn2Phone.addActionListener(this);
		btn3Phone.addActionListener(this);
		btn4Phone.addActionListener(this);
		btn5Phone.addActionListener(this);
		btn6Phone.addActionListener(this);
		btn7Phone.addActionListener(this);
		btn8Phone.addActionListener(this);
		btn9Phone.addActionListener(this);
		btnClearPhone.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();

		//action for calculator

		if(source==btn0){

	        display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "0");
		    else textField.setText("0");

		}
		if (source==btn1) {

			display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "1");
		    else textField.setText("1");
		}
		if (source==btn2) {

			display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "2");
		    else textField.setText("2");
			
		}
		if (source==btn3) {

			display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "3");
		    else textField.setText("3");
		}
		if (source==btn4) {

			display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "4");
		    else textField.setText("4");
		}
		if (source==btn5) {

			display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "5");
		    else textField.setText("5");
		}
		if (source==btn6) {

			display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "6");
		    else textField.setText("6");
		}
		if (source==btn7) {

			display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "7");
		    else textField.setText("7");
		}
		if (source==btn8) {

			display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "8");
		    else textField.setText("8");
		}
		if (source==btn9) {

			display = textField.getText();
			if(!textField.getText().equals("0"))
			textField.setText(display + "9");
		    else textField.setText("9");
		}
		if (source==btnClear) {

			String s = textField.getText().toString();
            s = s.substring(0, s.length() - 1);
            textField.setText(s);
            if(textField.getText().equals(""))
            textField.setText("0"); 	
		}
		if (source==btnVirgule) {

			display = textField.getText();
			textField.setText(display + ".");			
		}

         //action for typing number

		if(source==btn0Phone){

        displayPhone = phoneNumber.getText();
		if(!phoneNumber.getText().equals("0"))
		phoneNumber.setText(displayPhone + "0");
	    else phoneNumber.setText("0");

		}
		if (source==btn1Phone) {

			displayPhone = phoneNumber.getText();
			if(!phoneNumber.getText().equals("0"))
			phoneNumber.setText(displayPhone + "1");
		    else phoneNumber.setText("1");
		}
		if (source==btn2Phone) {

			displayPhone = phoneNumber.getText();
			if(!phoneNumber.getText().equals("0"))
			phoneNumber.setText(displayPhone + "2");
		    else phoneNumber.setText("2");
			
		}
		if (source==btn3Phone) {

			displayPhone = phoneNumber.getText();
			if(!phoneNumber.getText().equals("0"))
			phoneNumber.setText(displayPhone + "3");
		    else phoneNumber.setText("3");
		}
		if (source==btn4Phone) {

			displayPhone = phoneNumber.getText();
			if(!phoneNumber.getText().equals("0"))
			phoneNumber.setText(displayPhone + "4");
		    else phoneNumber.setText("4");
		}
		if (source==btn5Phone) {

			displayPhone = phoneNumber.getText();
			if(!phoneNumber.getText().equals("0"))
			phoneNumber.setText(displayPhone + "5");
		    else phoneNumber.setText("5");
		}
		if (source==btn6Phone) {

			displayPhone = phoneNumber.getText();
			if(!phoneNumber.getText().equals("0"))
			phoneNumber.setText(displayPhone + "6");
		    else phoneNumber.setText("6");
		}
		if (source==btn7Phone) {

			displayPhone = phoneNumber.getText();
			if(!phoneNumber.getText().equals("0"))
			phoneNumber.setText(displayPhone + "7");
		    else phoneNumber.setText("7");
		}
		if (source==btn8Phone) {

			displayPhone = phoneNumber.getText();
			if(!phoneNumber.getText().equals("0"))
			phoneNumber.setText(displayPhone + "8");
		    else phoneNumber.setText("8");
		}
		if (source==btn9Phone) {

			displayPhone = phoneNumber.getText();
			if(!phoneNumber.getText().equals("0"))
			phoneNumber.setText(displayPhone + "9");
		    else phoneNumber.setText("9");
		}
		if (source==btnClearPhone) {

			String s = phoneNumber.getText().toString();
            s = s.substring(0, s.length() - 1);
            phoneNumber.setText(s);
            if(phoneNumber.getText().equals(""))
            phoneNumber.setText("0"); 	
		}
		
		if(source==btnBackToMenu){

			MainFrame panel = new MainFrame();
			panel.setSize(470,300);
			panel.setVisible(true);
			panel.setResizable(false);
			panel.setLocation(400,250);
			dispose();
		}

		if (source==btnTransferPhone) {

			concatenateWithZip = codeZip.getText()+phoneNumber.getText();


			//here put the code for the Transfer

			String conString = "jdbc:mysql://localhost/atm";
		    String username = "root";
		    String password = "1234glody";
			
			Login log=new Login();

            String myUserId = log.getUserId();
			String myCardNumber=log.getCardNumber();
			String myPinNumber=log.getPinNumber();
			String myUserName=log.getUsername();

			double amount=Double.parseDouble(textField.getText());

			if (myUserId !="") {

				try{

						Connection con = DriverManager.getConnection(conString, username, password);
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT * FROM  user_account  WHERE  id_user='"+myUserId+"'");
	                        
	                while(rs.next()){

	                    rsUserId=rs.getString(1);
						rsUsername=rs.getString(2);
						rsCardNumber=rs.getString(3);
						rsPinNumber=rs.getString(4);
						rsBalance=rs.getDouble(5);
				    }

				    if(rsUserId.equals(myUserId)){

				    	if(amount >=10 && concatenateWithZip.length()==13){

				    	    if (rsBalance > amount) {

				    	    	try{

					                       
						    	  	PreparedStatement pstmt = con.prepareStatement("INSERT INTO transfer_phone (code_transfer , date_transfer , amount , phone_number, received , id_user , action) VALUE (?,?,?,?,?,?,?)");

						    	  	short c = 0;
                                    pstmt.setString(++c, myTransferCode);
                                    pstmt.setString(++c, myDate);
						    	  	pstmt.setDouble(++c, amount);
						    	  	pstmt.setString(++c, concatenateWithZip);
						    	  	pstmt.setString(++c, "NO");
						    	  	pstmt.setString(++c, rsUserId);
						    	  	pstmt.setString(++c, "transfer to phone");
						    	  	
						    	  	pstmt.executeUpdate();

						    	  	PreparedStatement pstmt2= con.prepareStatement("UPDATE user_account SET balance = balance-'"+amount+"' WHERE id_user='"+myUserId+"'");

						    	  	pstmt2.executeUpdate();

			                        JOptionPane.showMessageDialog(null,"Transfer saved Successfully! the code is '"+myTransferCode+"'","Success",JOptionPane.INFORMATION_MESSAGE);

			                        display="";
						    	  	}
						    	catch(SQLException err2){

						    	  	  System.out.println(err2.getMessage());
								      System.exit(0);	
						    	}
				    	    

				    	    }
				    	    else{

				    	    	JOptionPane.showMessageDialog(null, "please! your balance is below the value of your transfer!","error", JOptionPane.ERROR_MESSAGE);
				    	    } 

						
				    	}
				    	else{

				    	  	JOptionPane.showMessageDialog(null,"Please! enter a valid amount (above 9 rwf) or a valid phone mumber (10 diggit)","Error",JOptionPane.ERROR_MESSAGE);

				    	}
					
					}
					else{

					    JOptionPane.showMessageDialog(null,"Login First please!!!","Error",JOptionPane.ERROR_MESSAGE);	

					}

				    stmt.close();


					}catch(SQLException err){

						System.out.println(err.getMessage());
						System.exit(0);

				}
				
			}else{

				JOptionPane.showMessageDialog(null,"Login First please!!!","Error",JOptionPane.ERROR_MESSAGE);


			}
			
		}

          
	}	

	public static void main(String[] args) {

		TransferPhone log = new TransferPhone();
		log.setTitle("Mobile Transfer");
		log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		log.setBounds(100, 100, 748, 300);
		log.setVisible(true);
		log.setResizable(false);

	}
}