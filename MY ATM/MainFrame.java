import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class MainFrame extends JFrame implements ActionListener{
	
	
	public static void main(String[]args){
	MainFrame panel = new MainFrame();
	panel.setSize(470,300);
	panel.setVisible(true);
	panel.setResizable(false);
	panel.setLocation(450,250);
	panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	//putting icons and font to our button using the class ImageIcon and Font 
			
	JButton btnBnkHistory = new JButton("BANK HISTORY",new ImageIcon("images/history.png"));
	JButton btnDep = new JButton("DEPOSIT", new ImageIcon("images/deposit.png"));
	JButton btnWid = new JButton("WITHDRAW", new ImageIcon("images/withdraw.png"));
	JButton btntrans = new JButton("TRANSFER", new ImageIcon("images/transfer.png"));
	JButton btnLogOut = new JButton("EXIT ATM");

	Font f = new Font ("Tahoma",Font.BOLD, 14);

	public MainFrame() {
		super("ATM Main Menu");
	
		JPanel pane = new JPanel();
		pane.setLayout(null);

		//Because we didnt use any layout for displaying our button, we will use setBounds to determine the place and the dimension for these button
		
	 	JLabel lbl = new JLabel(new ImageIcon("images/back.jpg"));//this is for displaying the background image

	 	//in the same time, we'll add the actionlistener to our buttons 
			
		btnBnkHistory.setBounds(15,60,200,35);  
		btnBnkHistory.setFont(f);
		lbl.add(btnBnkHistory);
		btnBnkHistory.addActionListener(this);
		
		
		btntrans.setBounds(15,120,200,35);
		btntrans.setFont(f);
		lbl.add(btntrans);
		btntrans.addActionListener(this);	
		
		
		btnDep.setBounds(250,60,200,35);
		btnDep.setFont(f);
		lbl.add(btnDep);
		btnDep.addActionListener(this);
		

		btnWid.setBounds(250,120,200,35);
		btnWid.setFont(f);
		lbl.add(btnWid);
		btnWid.addActionListener(this);	
		
		
		btnLogOut.setBounds(130,190,200,35);
		btnLogOut.setFont(f);
		lbl.add(btnLogOut);
		btnLogOut.addActionListener(this);
			
	    lbl.setBounds(0,0,30,30);
		pane.add(lbl);
		
		
		setContentPane(lbl);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		lbl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Select Transaction"));

		String conString = "jdbc:mysql://localhost/atm";
		String username = "root";
	    String password = "1234glody";		
 		
	}

	//here the definition of event according to the source by getSource() method

			public void actionPerformed(ActionEvent e){

				Object source = e.getSource();
				
				if(source == btnBnkHistory){			
				
					BankHistory log=new BankHistory();

		            log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					log.setLocation(400,250);
					log.setBounds(100, 100, 939, 549);
					log.setVisible(true);
					dispose();
				}
				if(source == btnDep){
				
					Deposit log=new Deposit();

                    log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	                log.setBounds(100, 100, 516, 300);
					log.setLocation(400,250);
					log.setVisible(true);
					dispose();
				}
				if(source == btnWid){
					Withdraw log=new Withdraw();

					log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		            log.setBounds(100, 100, 516, 300);
					log.setLocation(400,250);
					log.setVisible(true);

					dispose();
				
				}	
			
				if(source == btntrans){
					FrameTransfer log=new FrameTransfer();

			        log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					log.setLocation(400,250);					
					log.setResizable(false);
					log.setVisible(true);
					log.setSize(470,300);
					dispose();		
				}
				
		
				if(source == btnLogOut){
					
					int n=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
					if(n==JOptionPane.YES_OPTION){
							
						
						System.exit(0);
						
						}
				}	
       }
  }