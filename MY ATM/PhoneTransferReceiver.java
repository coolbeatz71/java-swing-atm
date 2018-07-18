import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneTransferReceiver extends JFrame implements ActionListener{

	//defining our components

	public JTextField txtPhoneNumber;
	public JTextField txtTransferCode;
	public JLabel lblAdvertise;
	public JLabel lblphoneNumber;
	public JLabel  lblTransferCode;
	public JButton btnReceive;
	public JPanel panelCalculator;
	public JPanel contentPane;

	public String displayPhone="";

	//our calculator Button and our variables for getting database results

	public double value= 0;
    public String receive = "";
    public String name ="";
	public int senderId = 0;

	JButton btn0Phone = new JButton("0");
	JButton btn1Phone = new JButton("1");
	JButton btn2Phone = new JButton("2");
	JButton btn3Phone = new JButton("3");
	JButton btn4Phone = new JButton("4");
	JButton btn5Phone = new JButton("5");
	JButton btn6Phone = new JButton("6");
	JButton btn7Phone = new JButton("7");
	JButton btn8Phone = new JButton("8");
	JButton btn9Phone = new JButton("9");
	JButton btnClearPhone = new JButton("C");
	JButton btnPlus = new JButton("+"); 
	

	PhoneTransferReceiver(){

		setBounds(100, 100, 656, 224);
		contentPane = new JPanel();
		setContentPane(contentPane);
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);

		//here is putting the constraints for our components by springlayout
		
		txtPhoneNumber = new JTextField("0");
		layout.putConstraint(SpringLayout.NORTH, txtPhoneNumber, 57, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, txtPhoneNumber, 218, SpringLayout.WEST, contentPane);
		contentPane.add(txtPhoneNumber);
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		txtPhoneNumber.setEditable(false);
		
		txtTransferCode = new JTextField();
		layout.putConstraint(SpringLayout.WEST, txtTransferCode, 218, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, txtTransferCode, -31, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.EAST, txtTransferCode, -50, SpringLayout.EAST, contentPane);
		txtTransferCode.setColumns(10);
		contentPane.add(txtTransferCode);
		
		btnReceive = new JButton("GET MONEY");
		btnReceive.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		layout.putConstraint(SpringLayout.EAST, txtPhoneNumber, -27, SpringLayout.WEST, btnReceive);
		layout.putConstraint(SpringLayout.NORTH, btnReceive, 57, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, btnReceive, -41, SpringLayout.NORTH, txtTransferCode);
		layout.putConstraint(SpringLayout.WEST, btnReceive, -210, SpringLayout.EAST, contentPane);
		layout.putConstraint(SpringLayout.EAST, btnReceive, -53, SpringLayout.EAST, contentPane);
		contentPane.add(btnReceive);
		
		lblphoneNumber = new JLabel("Enter your phone number");
		layout.putConstraint(SpringLayout.WEST, lblphoneNumber, 0, SpringLayout.WEST, txtPhoneNumber);
		layout.putConstraint(SpringLayout.SOUTH, lblphoneNumber, -6, SpringLayout.NORTH, txtPhoneNumber);
		lblphoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblphoneNumber);
		
		lblTransferCode = new JLabel("Enter the transfer code");
		layout.putConstraint(SpringLayout.SOUTH, txtPhoneNumber, -18, SpringLayout.NORTH, lblTransferCode);
		layout.putConstraint(SpringLayout.WEST, lblTransferCode, 218, SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.SOUTH, lblTransferCode, -71, SpringLayout.SOUTH, contentPane);
		layout.putConstraint(SpringLayout.NORTH, txtTransferCode, 6, SpringLayout.SOUTH, lblTransferCode);
		lblTransferCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblTransferCode);
		
		panelCalculator = new JPanel();
		layout.putConstraint(SpringLayout.NORTH, panelCalculator, -8, SpringLayout.NORTH, lblphoneNumber);
		layout.putConstraint(SpringLayout.SOUTH, panelCalculator, 0, SpringLayout.SOUTH, txtTransferCode);
		layout.putConstraint(SpringLayout.EAST, panelCalculator, -45, SpringLayout.WEST, txtPhoneNumber);
		panelCalculator.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panelCalculator);
		panelCalculator.setLayout(new GridLayout(4,3));
		
		lblAdvertise = new JLabel("For typing phone number use this panel but for the transfer code use the keyboard!!");
		lblAdvertise.setFont(new Font("Tahoma", Font.PLAIN, 10));
		layout.putConstraint(SpringLayout.WEST, panelCalculator, 0, SpringLayout.WEST, lblAdvertise);
		layout.putConstraint(SpringLayout.NORTH, lblAdvertise, 0, SpringLayout.NORTH, contentPane);
		layout.putConstraint(SpringLayout.WEST, lblAdvertise, 22, SpringLayout.WEST, contentPane);
		contentPane.add(lblAdvertise);

		JLabel lblAdvertise2 = new JLabel("For the Transfer code !! Respect also hyphens. ex : b90bb574-8aed-4d9e-a767-e3e409e0063c");
		lblAdvertise2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		layout.putConstraint(SpringLayout.NORTH, lblAdvertise2, 6, SpringLayout.SOUTH, txtTransferCode);
		layout.putConstraint(SpringLayout.WEST, lblAdvertise2, 0, SpringLayout.WEST, txtPhoneNumber);
		contentPane.add(lblAdvertise2);

		//Add button in our panelCalculqtor

		panelCalculator.add(btn7Phone);
		panelCalculator.add(btn8Phone);
		panelCalculator.add(btn9Phone);
		panelCalculator.add(btn4Phone);
		panelCalculator.add(btn5Phone);
		panelCalculator.add(btn6Phone);
		panelCalculator.add(btn1Phone);
		panelCalculator.add(btn2Phone);
		panelCalculator.add(btn3Phone);
		panelCalculator.add(btn0Phone);
		panelCalculator.add(btnClearPhone);
		panelCalculator.add(btnPlus);

		//adding actionlistener in our button

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
		btnPlus.addActionListener(this);
		btnReceive.addActionListener(this);		   

	}

	//Adding now Events for our Button

	public void actionPerformed(ActionEvent e){
		   Object source=e.getSource();

		   if(source==btn0Phone){

        displayPhone = txtPhoneNumber.getText();
        if(!txtPhoneNumber.getText().equals("0"))
        txtPhoneNumber.setText(displayPhone + "0");
        else txtPhoneNumber.setText("0");

        }
        if (source==btn1Phone) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "1");
            else txtPhoneNumber.setText("1");
        }
        if (source==btn2Phone) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "2");
            else txtPhoneNumber.setText("2");
            
        }
        if (source==btn3Phone) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "3");
            else txtPhoneNumber.setText("3");
        }
        if (source==btn4Phone) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "4");
            else txtPhoneNumber.setText("4");
        }
        if (source==btn5Phone) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "5");
            else txtPhoneNumber.setText("5");
        }
        if (source==btn6Phone) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "6");
            else txtPhoneNumber.setText("6");
        }
        if (source==btn7Phone) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "7");
            else txtPhoneNumber.setText("7");
        }
        if (source==btn8Phone) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "8");
            else txtPhoneNumber.setText("8");
        }
        if (source==btn9Phone) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "9");
            else txtPhoneNumber.setText("9");
        }
        if (source==btnClearPhone) {

            String s = txtPhoneNumber.getText().toString();
            s = s.substring(0, s.length() - 1);
            txtPhoneNumber.setText(s);
            if(txtPhoneNumber.getText().equals(""))
            txtPhoneNumber.setText("0");   
        }
        if (source==btnPlus) {

            displayPhone = txtPhoneNumber.getText();
            if(!txtPhoneNumber.getText().equals("0"))
            txtPhoneNumber.setText(displayPhone + "+");
            else txtPhoneNumber.setText("+");
        }
        if(source==btnReceive){

        	String conString = "jdbc:mysql://localhost/atm";
		    String username = "root";
		    String password = "1234glody";

		    String code = txtTransferCode.getText(); 
		  	String phone = txtPhoneNumber.getText();
            
            if(phone.length()==13){
                    
        			try{

        				//establishing connnection only if the format of phone is respected

            	        Connection con = DriverManager.getConnection(conString, username, password);
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery("SELECT * FROM  transfer_phone WHERE  code_transfer='"+code+"' AND phone_number LIKE '%"+phone+"%'");

                        //counting the number of result

                        int count = 0;

						while (rs.next()) {
						    
						    // Get data from the current row and use it
						    ++count;
						    value= rs.getDouble(4);
						    receive = rs.getString(6);
						    senderId = rs.getInt(7);
						}
						if(count == 0) {

							//if there is no results based on our database query criteria
						    
						       JOptionPane.showMessageDialog(null, "Oops!! Impossible to acheive the transaction! check your transfer code or your phone number","error", JOptionPane.ERROR_MESSAGE);
						    }

						else{

							//here we check if the transaction is already received or not 

                                Statement stmt2 = con.createStatement();
                                ResultSet rs2 =stmt2.executeQuery("SELECT * FROM  transfer_phone WHERE  code_transfer='"+code+"' AND phone_number LIKE '%"+phone+"%' AND received='NO'");
                                
                                int c = 0;
                                while (rs2.next()) {
						    
								    // Get data from the current row and use it
								    ++c;
								    value= rs2.getDouble(4);
								    receive = rs2.getString(6);
								    senderId = rs2.getInt(7);
						        }
						        if(c==0){

						        	//if this transaction was already received 
 
						        	JOptionPane.showMessageDialog(null, "Oops!! This transaction is already received!!","error", JOptionPane.ERROR_MESSAGE);

						        }
                                
                                else{

                                	//if the transaction was not received yet, we must check the name of the sender by the foreign key and then update the table  

                                	Statement stmt3 = con.createStatement();
						            ResultSet rs3 = stmt3.executeQuery("SELECT * FROM user_account WHERE id_user='"+senderId+"'");                             
   
								        while(rs3.next()){
		                                    
		                                    name=rs3.getString(2);
								             
								        }

							        PreparedStatement  pstmt= con.prepareStatement("UPDATE transfer_phone SET received='YES' WHERE code_transfer='"+code+"'");

							        pstmt.executeUpdate();

							        JOptionPane.showMessageDialog(null, "You have got a sum of  '"+value+"' RWF  from  '"+name+"'","Success", JOptionPane.INFORMATION_MESSAGE);
                                }
        						   
						}  												

                    }catch(SQLException edata){

		            	System.out.println(edata.getMessage());
		            	System.exit(0);

		            }


            }
            else{

            	JOptionPane.showMessageDialog(null, "Please! the phone number must start by +250! ex: +250785231270","error", JOptionPane.ERROR_MESSAGE);

            }

            
        }

	} 

	public static void main(String[] args) {
		
		PhoneTransferReceiver login = new PhoneTransferReceiver();

		login.setTitle("Receive Your Money");
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setBounds(100, 100, 656, 224);
		login.setVisible(true);
		login.setResizable(false);

	}
       	
}