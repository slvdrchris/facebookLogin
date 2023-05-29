import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class Enrollment {

	private JFrame frame;
	private JTextField txtID;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtComputation;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enrollment window = new Enrollment();
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
	public Enrollment() {
	
		
		initialize();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setTitle("Enrollment Form");
		frame.setBounds(100, 100, 487, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel idBg = new JLabel("ID number");
		idBg.setForeground(new Color(192, 192, 192));
		idBg.setFont(new Font("Times New Roman", Font.BOLD, 15));
		idBg.setBounds(35, 72, 106, 14);
		frame.getContentPane().add(idBg);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				idBg.setText(null);		
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtID.getText().isEmpty()) {
					idBg.setText("ID number");
				}
			}
		});
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtID.setBounds(23, 64, 259, 33);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		JLabel fNameBg = new JLabel("First name");
		fNameBg.setForeground(new Color(192, 192, 192));
		fNameBg.setFont(new Font("Times New Roman", Font.BOLD, 15));
		fNameBg.setBounds(33, 116, 106, 14);
		frame.getContentPane().add(fNameBg);
		
		txtFirstName = new JTextField();
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
		txtFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(23, 108, 206, 33);
		frame.getContentPane().add(txtFirstName);
		
		JLabel lNameBg = new JLabel("Last name");
		lNameBg.setForeground(new Color(192, 192, 192));
		lNameBg.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lNameBg.setBounds(253, 116, 106, 14);
		frame.getContentPane().add(lNameBg);
		
		txtLastName = new JTextField();
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				lNameBg.setText(null);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				if (txtLastName.getText().isEmpty()) {
					lNameBg.setText("Last name");
				}
			}
		});
		txtLastName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtLastName.setColumns(10);
		txtLastName.setBounds(244, 108, 206, 33);
		frame.getContentPane().add(txtLastName);
		
		JLabel lblTuitionFee = new JLabel("Tuition Fee (Computation):");
		lblTuitionFee.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTuitionFee.setBounds(23, 318, 206, 14);
		frame.getContentPane().add(lblTuitionFee);
		
		txtComputation = new JTextField();
		txtComputation.setHorizontalAlignment(SwingConstants.LEFT);
		txtComputation.setEditable(false);
		txtComputation.setText("0");
		txtComputation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		txtComputation.setColumns(10);
		txtComputation.setBounds(220, 316, 164, 20);
		frame.getContentPane().add(txtComputation);
		
		JComboBox cmbCourse = new JComboBox();
		cmbCourse.setBackground(new Color(59, 89, 152));
		cmbCourse.setForeground(new Color(255, 255, 255));
		cmbCourse.setModel(new DefaultComboBoxModel(new String[] {"- SELECT COURSE -", "TOURISM", "COMPUTER SCIENCE", "ENGINEERING", "NURSING", "ARCHITECTURE"}));
		cmbCourse.setBounds(23, 198, 266, 22);
		frame.getContentPane().add(cmbCourse);
		
		JComboBox cmbStudent = new JComboBox();
		cmbStudent.setForeground(new Color(255, 255, 255));
		cmbStudent.setBackground(new Color(59, 89, 152));
		cmbStudent.setModel(new DefaultComboBoxModel(new String[] {"- SELECT STUDENT TYPE -", "DISCOUNTED (GOLD)", "DISCOUNTED (BLUE)", "DISCOUNTED (WHITE)", "WALK-IN", "CONTINUING"}));
		cmbStudent.setBounds(23, 165, 266, 22);
		frame.getContentPane().add(cmbStudent);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 293, 451, 14);
		frame.getContentPane().add(separator);
		
		JButton btnTotal = new JButton("CONFIRM");
		btnTotal.setBackground(new Color(0, 255, 0));
		btnTotal.setForeground(new Color(255, 255, 255));
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int IDNumber = Integer.parseInt(txtID.getText());
		        String firstName = txtFirstName.getText();
		        String lastName = txtLastName.getText();
		        String studentType = cmbStudent.getSelectedItem().toString();
		        String courseName = cmbCourse.getSelectedItem().toString();

		        double tuition = 0;
		        double misc = 0;
		        if (courseName.equalsIgnoreCase("tourism")) {
		            tuition = 10000;
		            misc = 22500;
		        } else if (courseName.equalsIgnoreCase("computer science")) {
		            tuition = 20000;
		            misc = 11000;
		        } else if (courseName.equalsIgnoreCase("engineering")) {
		            tuition = 30000;
		            misc = 25000;
		        } else if (courseName.equalsIgnoreCase("nursing")) {
		            tuition = 15000;
		            misc = 15000;
		        } else if (courseName.equalsIgnoreCase("architecture")) {
		            tuition = 25000;
		            misc = 23000;
		        } 

		        double disc = 0;
		        if (studentType.equalsIgnoreCase("discounted (gold)")) {
		            disc = 0.5;
		        } else if (studentType.equalsIgnoreCase("discounted (white)")) {
		            disc = 0.1;
		        } else if (studentType.equalsIgnoreCase("discounted (blue)")) {
		            disc = 0.3;
		        } else if (studentType.equalsIgnoreCase("continuing")) {
		            disc = 0.1;
		        }
		        double totalamount = tuition + misc;
		        double tuitionfee = totalamount - (totalamount * disc);
		        txtComputation.setText(String.format("%.2f", tuitionfee));
			}
		});
		btnTotal.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		btnTotal.setBounds(35, 231, 399, 36);
		frame.getContentPane().add(btnTotal);
		panel.setBackground(new Color(59, 89, 152));
		panel.setBounds(0, 0, 471, 53);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSchool = new JLabel("Honorata National School");
		lblSchool.setForeground(new Color(255, 255, 255));
		lblSchool.setBounds(10, 0, 309, 46);
		panel.add(lblSchool);
		lblSchool.setFont(new Font("Times New Roman", Font.BOLD, 23));
		
		JLabel exit = new JLabel("Exit");
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Facebook_Login fb = new Facebook_Login();
				fb.main(null);
				frame.dispose();
			}
		});
		exit.setForeground(new Color(255, 255, 255));
		exit.setBounds(434, 11, 27, 14);
		panel.add(exit);
	}
}
