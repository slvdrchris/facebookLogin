import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.SoftBevelBorder;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Panel;
import javax.swing.JTabbedPane;

public class Facebook_Login {

	private JFrame frame;
	private JTextField txtEmail;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Facebook_Login window = new Facebook_Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Facebook_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Facebook");
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 11));
		frame.getContentPane().setForeground(new Color(0, 128, 255));
		frame.setBounds(100, 100, 764, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		JPanel panelLogIn = new JPanel();
		panelLogIn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelLogIn.setBackground(new Color(255, 255, 255));
		panelLogIn.setBounds(437, 45, 256, 256);
		frame.getContentPane().add(panelLogIn);
		panelLogIn.setLayout(null);
		
		JLabel errorEmail = new JLabel("");
		errorEmail.setForeground(new Color(255, 0, 0));
		errorEmail.setBounds(213, 36, 11, 14);
		panelLogIn.add(errorEmail);
		
		JLabel errorPass = new JLabel("");
		errorPass.setForeground(Color.RED);
		errorPass.setBounds(213, 72, 11, 14);
		panelLogIn.add(errorPass);
		
		JLabel emailBg = new JLabel("Email or phone number");
		emailBg.setForeground(new Color(192, 192, 192));
		emailBg.setBounds(31, 36, 158, 14);
		panelLogIn.add(emailBg);
		
		JLabel passBg = new JLabel("Password");
		passBg.setForeground(new Color(192, 192, 192));
		passBg.setBounds(33, 72, 114, 14);
		panelLogIn.add(passBg);
		
		
		
		JLabel btnForgotPass = new JLabel("Forgot Password?");
		btnForgotPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				forgotPass reset = new forgotPass();
				reset.main(null);
				frame.dispose();
			}
		});
		btnForgotPass.setForeground(new Color(59, 89, 152));
		btnForgotPass.setBounds(83, 140, 106, 14);
		panelLogIn.add(btnForgotPass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 165, 236, 2);
		panelLogIn.add(separator);
		
		JButton btnCreateAcc = new JButton("Create new account");
		btnCreateAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp();
				signUp.main(null);
			}
		});
		btnCreateAcc.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCreateAcc.setForeground(new Color(255, 255, 255));
		btnCreateAcc.setBackground(new Color(0, 255, 0));
		btnCreateAcc.setBounds(53, 187, 149, 34);
		panelLogIn.add(btnCreateAcc);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(new LineBorder(new Color(192, 192, 192)));
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				emailBg.setText(null);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtEmail.getText().isBlank()) {
					emailBg.setText("Email or phone number");
				}
			}
		});
		txtEmail.setBounds(23, 31, 201, 25);
		panelLogIn.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new LineBorder(new Color(192, 192, 192)));
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				passBg.setText(null);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtPassword.getText().isBlank()) {
					passBg.setText("Password");
				}
			}
		});
		txtPassword.setColumns(10);
		txtPassword.setBounds(23, 67, 201, 25);
		panelLogIn.add(txtPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean logInSuccess = false;
				String email = txtEmail.getText();
				String password = txtPassword.getText();
				String storeLoginInfo = email+":"+password;
		        BufferedReader reader = null;
		        
		        if (email.isEmpty() || password.isEmpty()) {
					errorEmail.setText("!");
					errorPass.setText("!");
					txtEmail.setBorder(new LineBorder(new Color(255, 0, 0)));
					txtPassword.setBorder(new LineBorder(new Color(255, 0, 0)));
					JOptionPane.showMessageDialog(null,"Please enter your email or password!","System Notice",JOptionPane.ERROR_MESSAGE);
				}else {
		        try {
		            reader = new BufferedReader(new FileReader("users.txt"));
		            String line = reader.readLine();
		            while (line != null) {
		                if (line.equals(storeLoginInfo)) {
		                	logInSuccess = true;
		                    Enrollment.main(null);
							frame.dispose();
		                	JOptionPane.showMessageDialog(frame, "Login Successfully!");
		                }
		               line = reader.readLine();
		            }
		            if (logInSuccess != true) {
		            	JOptionPane.showMessageDialog(null,"Invalid Login Details!","System Notice",JOptionPane.ERROR_MESSAGE);
		            } 
		           } catch (IOException e1) {
			            e1.printStackTrace();
			        }finally {
			            try {
			                if (reader != null) {
			                    reader.close();
			                }
			            } catch (IOException e1) {
			                e1.printStackTrace();
			            }
			        }
				}
				if (email.contains("salvadorc@students.national-u.edu.ph") && password.contains("1234")) {
					
					JOptionPane.showMessageDialog(null,"Login Success","System Notice",JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
				}
			}
		});
		
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBackground(new Color(59, 89, 152));
		btnLogIn.setBounds(23, 103, 201, 30);
		panelLogIn.add(btnLogIn);
		
		JRadioButton btnShowHide = new JRadioButton("");
		btnShowHide.setBackground(new Color(255, 255, 255));
		btnShowHide.setBounds(224, 67, 26, 25);
		btnShowHide.setIcon(new ImageIcon(Facebook_Login.class.getResource("/images/hide (1).png")));
		btnShowHide.setVisible(true);
		panelLogIn.add(btnShowHide);
		
		btnShowHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnShowHide.isSelected()) {
					txtPassword.setEchoChar((char)0);
					btnShowHide.setIcon(new ImageIcon(Facebook_Login.class.getResource("/images/show.png")));
				}else {
					txtPassword.setEchoChar('•');
					btnShowHide.setIcon(new ImageIcon(Facebook_Login.class.getResource("/images/hide (1).png")));
				}
			}
		});
		
		JLabel lblFacebook = new JLabel("facebook");
		lblFacebook.setForeground(new Color(59, 89, 152));
		lblFacebook.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblFacebook.setBounds(42, 110, 217, 54);
		frame.getContentPane().add(lblFacebook);
		
		JLabel lblText = new JLabel("Connect with friends and the world ");
		lblText.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblText.setBounds(42, 134, 298, 85);
		frame.getContentPane().add(lblText);
		
		JLabel lblNewLabel_1_1 = new JLabel("around you on Facebook.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(42, 162, 298, 85);
		frame.getContentPane().add(lblNewLabel_1_1);
	}
}
