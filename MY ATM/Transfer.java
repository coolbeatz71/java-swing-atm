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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class Transfer extends JFrame implements ActionListener{

        
        public String comboCardNumber="";
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
		public  JButton btnTransfer;
		public  JButton btnBackToMenu; 
		
		public  JTextField textField;
		
		public  String display="";
		

		public static String rsCardNumber="";
        public static String rsUsername="";
	    public static String rsPinNumber="";
	    public static String rsUserId="";
	    public static double rsBalance=0;
	    public static String forComboCardNumber="";
	    public static int forComboUserId=0;

	    Date myTime = new Date();

	    String myDate = myTime.toString();

		String [] tableContent;

		public JComboBox<String> comboBox;



		class ItemState implements ItemListener{
          public void itemStateChanged(ItemEvent e) {

              e.getItem();
            }
        }

        class ItemAction implements ActionListener{
          public void actionPerformed(ActionEvent e2) {
           
             comboBox.getSelectedItem();
          }
        }



	
	public Transfer(){

		String conString = "jdbc:mysql://localhost/atm";
		String username = "root";
		String password = "1234glody";
		
		try{
			Connection con = DriverManager.getConnection(conString, username, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT card_number FROM user_account");
			
			int rowCount = 0;
			if(rs.last()){
				rowCount = rs.getRow();
				rs.beforeFirst();
			}
			
			tableContent = new String[rowCount];
			
			int counter = 0;
			while(rs.next()){
				
				String card_number = rs.getString("card_number");
				
				tableContent[counter] = card_number;
				counter++;
			}
			
		}catch(SQLException err){
			System.out.println(err.getMessage());
			System.exit(0);
		}
		
		for (int i=0; i<= tableContent.length; i++) {

			comboBox = new JComboBox<String>(tableContent);	
		}

		comboBox.addItemListener(new ItemState());
		comboBox.addActionListener(new ItemAction());
        
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

		textField = new JTextField("0");
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
		
		btnTransfer = new JButton("Transfer");
		layout.putConstraint(SpringLayout.SOUTH, textField, -6, SpringLayout.NORTH, btnTransfer);
		layout.putConstraint(SpringLayout.WEST, btnTransfer, 45, SpringLayout.EAST, content);
		layout.putConstraint(SpringLayout.EAST, btnTransfer, -133, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, btnTransfer, 136, SpringLayout.NORTH, contentPane);
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(btnTransfer);
		
		btnBackToMenu = new JButton("Back to Menu");
		layout.putConstraint(SpringLayout.SOUTH, btnTransfer, -6, SpringLayout.NORTH, btnBackToMenu);
		btnBackToMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		layout.putConstraint(SpringLayout.NORTH, btnBackToMenu, 182, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, btnBackToMenu, -37, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, btnBackToMenu, 45, SpringLayout.EAST, content);
		layout.putConstraint(SpringLayout.EAST, btnBackToMenu, -133, SpringLayout.EAST, contentPane);
		contentPane.add(btnBackToMenu);
	
		
		layout.putConstraint(SpringLayout.WEST, comboBox, 46, SpringLayout.EAST, content);
		layout.putConstraint(SpringLayout.SOUTH, comboBox, -12, SpringLayout.NORTH, textField);
		layout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, textField);
		contentPane.add(comboBox);
		
		JLabel lblDestinationCardNumber = new JLabel("Card Number");
		lblDestinationCardNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		layout.putConstraint(SpringLayout.NORTH, lblDestinationCardNumber, 0, SpringLayout.NORTH, content);
		layout.putConstraint(SpringLayout.WEST, lblDestinationCardNumber, 18, SpringLayout.EAST, comboBox);
		contentPane.add(lblDestinationCardNumber);

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
		btnTransfer.addActionListener(this);

	}

	//Setting our Button event

	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();

		//the code for our mini calculator

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


		
		if(source==btnBackToMenu){

			MainFrame panel = new MainFrame();
			panel.setSize(470,300);
			panel.setVisible(true);
			panel.setResizable(false);
			panel.setLocation(400,250);
			dispose();
		}

		if(source==btnTransfer){

			forComboCardNumber = comboBox.getSelectedItem().toString();
			//here put the code for the Transfer

     		String conString = "jdbc:mysql://localhost/atm";
		    String username = "root";
		    String password = "1234glody";
			
			Login log=new Login();

            String myUserId = log.getUserId();
			String myCardNumber=log.getCardNumber();
			String myPinNumber=log.getPinNumber();
			String myUserName=log.getUsername();

			
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
						rsBalance= rs.getDouble(5);
				    }

				        if(rsUserId.equals(myUserId)){

							        try{

							        	Statement stmtNoSelf = con.createStatement();
							        	ResultSet rsNoSelf = stmtNoSelf.executeQuery("SELECT * FROM user_account WHERE card_number='"+comboCardNumber+"'");

							        	while(rsNoSelf.next()){

                                           forComboUserId = rsNoSelf.getInt(1);
                                           forComboCardNumber = rsNoSelf.getString(3);

							        	}

							        	    if (!forComboCardNumber.equals(rsCardNumber)) {

							        	    double theAmount=Double.parseDouble(textField.getText());


										        if(theAmount >= 10){

										 
												    	  	if (rsBalance > theAmount) {

												    	  		try{
							                       
														    	  	PreparedStatement pstmt = con.prepareStatement("INSERT INTO transfer (id_user , transfer_code , transfer_date , amount , received, action) VALUE (?,?,?,?,?,?)");

														    	  	short c = 0;
										                            
										                            pstmt.setString(++c, myUserId); 
														    	  	pstmt.setString(++c, myTransferCode);
														    	  	pstmt.setString(++c, myDate);
														    	  	pstmt.setDouble(++c, theAmount);
														    	  	pstmt.setString(++c, "YES");
														    	  	pstmt.setString(++c, "Transfer");
														    	  	
														    	  	pstmt.executeUpdate();

														    	  	PreparedStatement pstmt2= con.prepareStatement("UPDATE user_account SET balance = balance-'"+theAmount+"' WHERE id_user='"+myUserId+"'");
														    	  	pstmt2.executeUpdate();

														    	  	PreparedStatement pstmt3= con.prepareStatement("UPDATE user_account SET balance = balance+'"+theAmount+"' WHERE card_number='"+forComboCardNumber+"'");
														    	  	pstmt3.executeUpdate();

											                        JOptionPane.showMessageDialog(null,"Your Transfer was saved Successfully","Success",JOptionPane.INFORMATION_MESSAGE);

											                      
														    	  	}
														    	  	catch(SQLException err2){

														    	  	  System.out.println(err2.getMessage());
																      System.exit(0);	
														    	  	}
												    	  		
												    	  	}else{

												    	  		JOptionPane.showMessageDialog(null,"Your balance is below the value of your Transfer!! ","Transfer impossible",JOptionPane.ERROR_MESSAGE);	
												    	  	}

										    	}
										    	else{

										    	  	JOptionPane.showMessageDialog(null,"Please Enter a valid amount (above 9 rwf)","Error",JOptionPane.ERROR_MESSAGE);

										    	}
											
										    }else{

											JOptionPane.showMessageDialog(null, "No transfer for yourself, Please Make a deposit instead", "Error", JOptionPane.ERROR_MESSAGE);	
										    }
							        }
							        catch(SQLException noSelf){

							        	System.out. println(noSelf.getMessage());
							        	System.exit(0);

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

		Transfer log = new Transfer();
		log.setTitle("Transfer to account");
		log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		log.setBounds(100, 100, 516, 300);
		log.setVisible(true);
		log.setResizable(false);

		
	}
}