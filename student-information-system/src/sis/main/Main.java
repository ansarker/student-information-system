package sis.main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Main {

	private JFrame frame;
	private JTextField login_id;
	private JPasswordField login_pass;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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

	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Student Information System");
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel main_panel = new JPanel();
		main_panel.setBackground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(main_panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(main_panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE));
		main_panel.setLayout(null);
		JPanel container = new JPanel();
		container.setBackground(new Color(139, 0, 0));
		container.setBounds(324, 145, 290, 185);
		main_panel.add(container);
		container.setLayout(null);
		JLabel lblNewLabel = new JLabel("User ID : ");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(28, 12, 110, 25);
		container.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Password : ");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBounds(28, 49, 110, 25);
		container.add(lblNewLabel_1);
		login_id = new JTextField();
		login_id.setBounds(133, 12, 125, 25);
		container.add(login_id);
		login_id.setColumns(10);
		login_pass = new JPasswordField();
		login_pass.setBounds(133, 52, 125, 25);
		container.add(login_pass);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (login_id.getText().equals("admin") && login_pass.getText().equals("12345")) {
					JOptionPane.showMessageDialog(null, "Login Successfull.", "Message", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					Main info = new Main();
					info.show();
				} else {
					JOptionPane.showMessageDialog(null, "Login Failed.\nUser ID or Password don't match", "Message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLogin.setForeground(UIManager.getColor("Button.foreground"));
		btnLogin.setBounds(28, 129, 230, 35);
		container.add(btnLogin);
		JLabel lblNewLabel_2 = new JLabel("Student Information System");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_2.setBounds(32, 12, 330, 50);
		main_panel.add(lblNewLabel_2);
		JLabel lblPreparedBy = new JLabel("Prepared By : Anis Sarker");
		lblPreparedBy.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPreparedBy.setBounds(32, 47, 330, 50);
		main_panel.add(lblPreparedBy);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("/root/workspace/Student-Info-System/src/Student_Info_System/icons/monitor.png"));
		label.setBounds(90, 150, 128, 128);
		main_panel.add(label);
		frame.getContentPane().setLayout(groupLayout);
	}
	
	public void show() {
		frame.setVisible(true);
	}
}