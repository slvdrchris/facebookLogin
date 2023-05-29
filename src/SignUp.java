import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

public class SignUp {

	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JPasswordField txtReEnterPass;
	private JTextField txtEmail;
	private JPasswordField txtNewPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 764, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setBackground(new Color (255,255,255,0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0,100));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(10, 33, 744, 381);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel PanelSignUp = new JPanel();
		PanelSignUp.setBorder(new LineBorder(new Color(192, 192, 192)));
		PanelSignUp.setLayout(null);
		PanelSignUp.setBackground(Color.WHITE);
		PanelSignUp.setBounds(222, 30, 278, 332);
		panel.add(PanelSignUp);
		
		JRadioButton btnShowHide_1 = new JRadioButton("");
		btnShowHide_1.setIcon(new ImageIcon("C:\\Users\\chris\\Downloads\\hide (1).png"));
		btnShowHide_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnShowHide_1.isSelected()) {
					txtNewPass.setEchoChar((char)0);
					btnShowHide_1.setIcon(new ImageIcon("C:\\Users\\chris\\Downloads\\show.png"));
				}else {
					txtNewPass.setEchoChar('•');
					btnShowHide_1.setIcon(new ImageIcon("C:\\Users\\chris\\Downloads\\hide (1).png"));
				}
			}
		});
		btnShowHide_1.setBackground(Color.WHITE);
		btnShowHide_1.setBounds(247, 176, 21, 20);
		PanelSignUp.add(btnShowHide_1);
		
		JRadioButton btnShowHide = new JRadioButton("");
		btnShowHide.setIcon(new ImageIcon("C:\\Users\\chris\\Downloads\\hide (1).png"));
		btnShowHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnShowHide.isSelected()) {
					txtReEnterPass.setEchoChar((char)0);
					btnShowHide.setIcon(new ImageIcon("C:\\Users\\chris\\Downloads\\show.png"));
				}else {
					txtReEnterPass.setEchoChar('•');
					btnShowHide.setIcon(new ImageIcon("C:\\Users\\chris\\Downloads\\hide (1).png"));
				}
			}
		});
		btnShowHide.setBackground(new Color(255, 255, 255));
		btnShowHide.setBounds(247, 216, 21, 20);
		PanelSignUp.add(btnShowHide);
		
		JLabel ReEnterPassBg = new JLabel("Re-enter your password");
		ReEnterPassBg.setForeground(Color.LIGHT_GRAY);
		ReEnterPassBg.setBounds(41, 216, 142, 14);
		PanelSignUp.add(ReEnterPassBg);
		
		JLabel NewPassBg = new JLabel("New password");
		NewPassBg.setForeground(Color.LIGHT_GRAY);
		NewPassBg.setBounds(41, 176, 117, 14);
		PanelSignUp.add(NewPassBg);
		
		JLabel lNameBg = new JLabel("Last name");
		lNameBg.setForeground(Color.LIGHT_GRAY);
		lNameBg.setBounds(157, 89, 71, 14);
		PanelSignUp.add(lNameBg);
		
		JLabel EmailCpBg = new JLabel("Mobile number or email");
		EmailCpBg.setForeground(Color.LIGHT_GRAY);
		EmailCpBg.setBounds(43, 135, 140, 14);
		PanelSignUp.add(EmailCpBg);
		
		JLabel fNameBg = new JLabel("First name");
		fNameBg.setForeground(Color.LIGHT_GRAY);
		fNameBg.setBounds(37, 89, 71, 14);
		PanelSignUp.add(fNameBg);
		
		JLabel errorPass2 = new JLabel("");
		errorPass2.setForeground(Color.RED);
		errorPass2.setBounds(230, 216, 11, 14);
		PanelSignUp.add(errorPass2);
		
		JLabel errorPass1 = new JLabel("");
		errorPass1.setForeground(Color.RED);
		errorPass1.setBounds(230, 176, 11, 14);
		PanelSignUp.add(errorPass1);
		
		JLabel errorEmail = new JLabel("");
		errorEmail.setForeground(Color.RED);
		errorEmail.setBounds(232, 135, 11, 14);
		PanelSignUp.add(errorEmail);
		
		JLabel errorLast = new JLabel("");
		errorLast.setForeground(Color.RED);
		errorLast.setBounds(232, 89, 11, 14);
		PanelSignUp.add(errorLast);
		
		JLabel errorFirst = new JLabel("");
		errorFirst.setForeground(Color.RED);
		errorFirst.setBounds(118, 89, 11, 14);
		PanelSignUp.add(errorFirst);
		
		txtFirstName = new JTextField();
		txtFirstName.setBorder(new LineBorder(new Color(192, 192, 192)));
		txtFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				fNameBg.setText(null);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtFirstName.getText().isEmpty()) {
					fNameBg.setText("First name");
				}
			}
		});
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(30, 83, 100, 26);
		PanelSignUp.add(txtFirstName);
		
		JLabel lblNewLabel_3 = new JLabel("Sign Up");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 11, 80, 26);
		PanelSignUp.add(lblNewLabel_3);
		
		txtLastName = new JTextField();
		txtLastName.setBorder(new LineBorder(new Color(192, 192, 192)));
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lNameBg.setText(null);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtLastName.getText().isEmpty()) {
					lNameBg.setText("Last name");
				}
			}
		});
		txtLastName.setColumns(10);
		txtLastName.setBounds(149, 83, 94, 26);
		PanelSignUp.add(txtLastName);
		
		txtReEnterPass = new JPasswordField();
		txtReEnterPass.setBorder(new LineBorder(new Color(192, 192, 192)));
		txtReEnterPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ReEnterPassBg.setText(null);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtReEnterPass.getText().isEmpty()) {
					ReEnterPassBg.setText("Re-enter your password");
				}
			}
		});
		txtReEnterPass.setColumns(10);
		txtReEnterPass.setBounds(30, 210, 215, 26);
		PanelSignUp.add(txtReEnterPass);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(new LineBorder(new Color(192, 192, 192)));
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				EmailCpBg.setText(null);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtEmail.getText().isEmpty()) {
					EmailCpBg.setText("Mobile number or email");
				}
			}
		});
		txtEmail.setColumns(10);
		txtEmail.setBounds(30, 129, 215, 26);
		PanelSignUp.add(txtEmail);
		
		txtNewPass = new JPasswordField();
		txtNewPass.setBorder(new LineBorder(new Color(192, 192, 192)));
		txtNewPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				NewPassBg.setText(null);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtNewPass.getText().isEmpty()) {
					NewPassBg.setText("New password");
				}
			}
		});
		txtNewPass.setColumns(10);
		txtNewPass.setBounds(30, 170, 215, 26);
		PanelSignUp.add(txtNewPass);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(192, 192, 192));
		separator_1.setBounds(10, 61, 255, 14);
		PanelSignUp.add(separator_1);
		
		JLabel lblNewLabel_10 = new JLabel("It’s quick and easy.");
		lblNewLabel_10.setForeground(Color.GRAY);
		lblNewLabel_10.setBounds(10, 36, 138, 14);
		PanelSignUp.add(lblNewLabel_10);
		
		JLabel exit = new JLabel("X");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		exit.setFont(new Font("Bahnschrift", Font.BOLD, 15));
		exit.setBounds(256, 11, 22, 19);
		PanelSignUp.add(exit);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = txtFirstName.getText(), lastName = txtLastName.getText(), email = txtEmail.getText(), newPass = txtNewPass.getText(), reEnterPass = txtReEnterPass.getText();
				if(firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || newPass.isEmpty() || reEnterPass.isEmpty())  {
					errorFirst.setText("!");
					errorLast.setText("!");
					errorEmail.setText("!");
					errorPass1.setText("!");
					errorPass2.setText("!");
					PanelSignUp.setBorder(new LineBorder(new Color(255, 0, 0)));
					txtFirstName.setBorder(new LineBorder(new Color(255, 0, 0)));
					txtLastName.setBorder(new LineBorder(new Color(255, 0, 0)));
					txtEmail.setBorder(new LineBorder(new Color(255, 0, 0)));
					txtNewPass.setBorder(new LineBorder(new Color(255, 0, 0)));
					txtReEnterPass.setBorder(new LineBorder(new Color(255, 0, 0)));
					JOptionPane.showMessageDialog(null,"Please fill in the blank first before signing up","System Notice",JOptionPane.ERROR_MESSAGE);
				}else if (reEnterPass.equals(newPass) == false) {
					errorPass2.setText("!");
					PanelSignUp.setBorder(new LineBorder(new Color(255, 0, 0)));
					txtReEnterPass.setBorder(new LineBorder(new Color(255, 0, 0)));
					JOptionPane.showMessageDialog(null,"The password you've entered does not match your new password.","System Notice",JOptionPane.ERROR_MESSAGE);
				}else {
					 String signUpData = email + ":" + newPass;
				        try (FileWriter writer = new FileWriter("users.txt", true)) {
				            writer.write("\n" + signUpData);
				            JOptionPane.showMessageDialog(null,"Sign up successfully","System Notice",JOptionPane.DEFAULT_OPTION);
				            Facebook_Login facebook = new Facebook_Login();
				            facebook.main(null);
				        } catch (IOException e1) {
				            e1.printStackTrace();
				        }
				}
			}
		});
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(Color.GREEN);
		btnSignUp.setBounds(78, 268, 118, 36);
		PanelSignUp.add(btnSignUp);
	}
}
