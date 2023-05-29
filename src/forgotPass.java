import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class forgotPass {

	private JFrame frame;
	private JTextField txtEmail;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgotPass window = new forgotPass();
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
	public forgotPass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setTitle("Facebook");
		frame.setBounds(100, 100, 764, 425);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, -31, 748, 417);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_search = new JPanel();
		tabbedPane.addTab("New tab", null, panel_search, null);
		panel_search.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(222, 75, 294, 193);
		panel_search.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblText = new JLabel("Find your account");
		lblText.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblText.setForeground(new Color(0, 0, 0));
		lblText.setBounds(10, 11, 194, 14);
		panel_1.add(lblText);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(192, 192, 192));
		separator.setBounds(10, 36, 274, 2);
		panel_1.add(separator);
		
		JLabel lblText1 = new JLabel("<html>Please enter your email or mobile number <br>to search for your account.");
		lblText1.setBounds(10, 49, 274, 35);
		panel_1.add(lblText1);
		
		JLabel emailBg = new JLabel("Email or phone number");
		emailBg.setForeground(new Color(128, 128, 128));
		emailBg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailBg.setBounds(20, 101, 184, 14);
		panel_1.add(emailBg);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		txtEmail.setBounds(10, 92, 274, 35);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(192, 192, 192));
		separator_1.setBounds(10, 146, 274, 2);
		panel_1.add(separator_1);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String email = txtEmail.getText();
				BufferedReader reader = null;
				 
				if(email.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Please enter your email or phone number!","System Notice",JOptionPane.ERROR_MESSAGE);
				}else {
				try {
			            reader = new BufferedReader(new FileReader("users.txt"));
			            String line = reader.readLine();
			            while (line != null) {
			                if (line.equals(email)) {
			                	tabbedPane.setSelectedIndex(1);
			                }
			               line = reader.readLine();
			            }
				 }catch (IOException e1) {
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
			}
		});
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(59, 89, 152));
		btnSearch.setBounds(195, 159, 89, 23);
		panel_1.add(btnSearch);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Facebook_Login fb = new Facebook_Login();
				fb.main(null);
				frame.dispose();
			}
		});
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.setBounds(102, 159, 83, 23);
		panel_1.add(btnCancel);
		
		JPanel panel_reset = new JPanel();
		tabbedPane.addTab("New tab", null, panel_reset, null);
		panel_reset.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(225, 71, 294, 182);
		panel_reset.add(panel_1_1);
		
		JLabel lblText_1 = new JLabel("Reset your password");
		lblText_1.setForeground(Color.BLACK);
		lblText_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblText_1.setBounds(10, 11, 194, 27);
		panel_1_1.add(lblText_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.LIGHT_GRAY);
		separator_2.setBounds(10, 36, 274, 2);
		panel_1_1.add(separator_2);
		
		JLabel lblText1_1 = new JLabel("Please enter your new password.");
		lblText1_1.setBounds(10, 36, 274, 35);
		panel_1_1.add(lblText1_1);
		
		JLabel emailBg_1 = new JLabel("New Password");
		emailBg_1.setForeground(Color.GRAY);
		emailBg_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		emailBg_1.setBounds(20, 85, 184, 14);
		panel_1_1.add(emailBg_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 76, 274, 35);
		panel_1_1.add(textField);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(Color.LIGHT_GRAY);
		separator_1_1.setBounds(10, 135, 274, 2);
		panel_1_1.add(separator_1_1);
		
		JButton btnSearch_1 = new JButton("Continue");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean logInSuccess = false;
				String email = txtEmail.getText();
				BufferedReader reader = null;
				
				try {
		            reader = new BufferedReader(new FileReader("users.txt"));
		            String line = reader.readLine();
		            while (line != null) {
		                if (line.equals(email)) {
		                	logInSuccess = true;
		                    Enrollment.main(null);
							frame.dispose();
		                	JOptionPane.showMessageDialog(frame, "Login Successfully!");
		                }
		               line = reader.readLine();
		            }
		            } catch (IOException e1) {
			            e1.printStackTrace();
			        }
				
			}
		});
		btnSearch_1.setForeground(Color.WHITE);
		btnSearch_1.setBackground(new Color(59, 89, 152));
		btnSearch_1.setBounds(195, 148, 89, 23);
		panel_1_1.add(btnSearch_1);
		
		JButton btnNotYou = new JButton("Not you?");
		btnNotYou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNotYou.setBackground(Color.LIGHT_GRAY);
		btnNotYou.setBounds(102, 148, 83, 23);
		panel_1_1.add(btnNotYou);
	}
}
