package pharmaApp1;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PharmaApp1GUI implements ActionListener{
	
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel loginSuccess;
	private static JLabel loginInvalid;
	
	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		frame.setTitle("Client - PharmaApp1Controller - Login");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		frame.add(panel);
		
		userLabel = new JLabel("UserName");
		userLabel.setBounds(20, 10, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField();
		userText.setBounds(100, 10, 165, 25);
		panel.add(userText);
			
		passwordLabel = new JLabel("Password"); 
		passwordLabel.setBounds(20, 50, 80, 25); 
		panel.add(passwordLabel);
		  
		passwordText = new JPasswordField(); 
		passwordText.setBounds(100, 50, 165, 25); 
		panel.add(passwordText);
		  
		button = new JButton("LOGIN"); 
		button.setBounds(10, 80, 80, 25);
		button.addActionListener(new PharmaApp1GUI());
		panel.add(button);
		
		loginSuccess = new JLabel();		 
		loginSuccess.setBounds(10, 110, 300, 25);
		panel.add(loginSuccess);
		
		loginInvalid = new JLabel();
		loginInvalid.setBounds(10, 110, 300, 25);
		panel.add(loginInvalid);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String user = userText.getText();
		String password = passwordText.getText();
		
		if(user.equals("JOSE2021") && (password.equals("MALAKI"))){
			
			loginSuccess.setText ("WELL DONE, PASSWORD SUCCESSFUL");
		}else {
			
			loginInvalid.setText ("SORRY, INVALID USERNAME OR PASSWORD");
		}
	}

}
