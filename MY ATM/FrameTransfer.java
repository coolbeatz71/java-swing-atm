
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

 public class FrameTransfer extends JFrame implements ActionListener{
	
	
	public static void main(String[]args){
	FrameTransfer panel = new FrameTransfer();
	panel.setSize(470,300);
	panel.setVisible(true);
	panel.setResizable(false);
	panel.setLocation(450,250);
	panel.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
		
	
	JButton btnTrans = new JButton("TO ACCOUNT", new ImageIcon("images/transfer.png"));
	JButton btnTransPhone = new JButton("TO PHONE", new ImageIcon("images/transfer_phone.png"));
	JButton btnBackToMenu = new JButton("BACK TO MENU");

	Font f = new Font ("Tahoma",Font.BOLD, 14);
	
	
	
	


	public FrameTransfer() {
		super("Transfer menu");
	
		JPanel pane = new JPanel();
		pane.setLayout(null);
		
	 	JLabel lbl = new JLabel(new ImageIcon("images/back.jpg"));
			
		
		btnTransPhone.setBounds(15,120,200,35);
		btnTransPhone.setFont(f);
		lbl.add(btnTransPhone);
		btnTransPhone.addActionListener(this);	
						

		btnTrans.setBounds(250,120,200,35);
		btnTrans.setFont(f);
		lbl.add(btnTrans);
		btnTrans.addActionListener(this);	
		
		
		btnBackToMenu.setBounds(130,190,200,35);
		btnBackToMenu.setFont(f);
		lbl.add(btnBackToMenu);
		btnBackToMenu.addActionListener(this);
		
		
		
		
	    lbl.setBounds(0,0,30,30);
		pane.add(lbl);
		
		
		setContentPane(lbl);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		lbl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Select Transfer"));

		String conString = "jdbc:mysql://localhost/atm";
		String username = "root";
	    String password = "1234glody";
		
 		
	}

			public void actionPerformed(ActionEvent e){

				Object source = e.getSource();
								
				if(source == btnTrans){
					Transfer log=new Transfer();

					log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		            log.setBounds(100, 100, 516, 300);
					log.setLocation(400,250);
					log.setVisible(true);

					dispose();
				
				}	
			
				if(source == btnTransPhone){
					TransferPhone log=new TransferPhone();

			        log.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					log.setLocation(400,250);					
					log.setResizable(false);
					log.setVisible(true);
					log.setBounds(100, 100, 748, 300);
					dispose();		
				}
				
		
				if(source == btnBackToMenu){
					
					MainFrame log = new MainFrame();

					log.setSize(470,300);
					log.setVisible(true);
					log.setResizable(false);
					log.setLocation(450,250);
					log.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					dispose();
				}	
       }
  }