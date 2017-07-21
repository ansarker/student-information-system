package sis.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Information extends javax.swing.JFrame {

	ArrayList<Student> info = new ArrayList<>();

	private JFrame frame;
	private JTextField name;
	private JTextField id;
	private JTextField credit;
	private JTextField cgpa;
	private JTextField textSearch;
	private JTextField textSearch1;
	private JTextField UpdateName;
	private JTextField UpdateID;
	private JTextField UpdateMajor;
	private JTextField UpdateSemester;
	private JTextField UpdateCredit;
	private JTextField UpdateCGPA;
	private JLabel lblMessage;
	private JLabel Notification;
	private JLabel Notification1;
	private JLabel lblNewLabel;
	private JPanel Dashboard;
	private JPanel add_student_panel;
	private JPanel edit_student_panel;
	private JPanel view_info_panel;
	private JSeparator separator;
	private JButton btnLoad;
	private JButton btnEdit;
	private JButton btnUpdate;
	String fileName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Information window = new Information();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Information() {
		initialize();
		Dashboard.setVisible(true);
		add_student_panel.setVisible(false);
		edit_student_panel.setVisible(false);
		view_info_panel.setVisible(false);

		btnLoad.setEnabled(false);
		btnEdit.setEnabled(false);
		btnUpdate.setEnabled(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setResizable(false);
		frame.setTitle("Student Information System");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(160, 0, 480, 448);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 480, 448);
		panel_2.add(layeredPane);
		layeredPane.setLayout(null);

		Dashboard = new JPanel();
		Dashboard.setBackground(new Color(117, 5, 5));
		Dashboard.setBounds(0, 0, 480, 448);
		layeredPane.add(Dashboard);
		Dashboard.setLayout(null);

		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(Color.WHITE);
		lblDashboard.setFont(new Font("Cantarell", Font.BOLD, 18));
		lblDashboard.setBackground(Color.WHITE);
		lblDashboard.setBounds(35, 12, 190, 30);
		Dashboard.add(lblDashboard);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(12, 43, 456, 9);
		Dashboard.add(separator_1);

		JLabel lblNewLabel_6 = new JLabel("Welcome To");
		lblNewLabel_6.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel_6.setBounds(148, 54, 180, 50);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		Dashboard.add(lblNewLabel_6);

		JLabel lblStudentInformationSystem = new JLabel("Student Information System");
		lblStudentInformationSystem.setForeground(Color.WHITE);
		lblStudentInformationSystem.setFont(new Font("Dialog", Font.BOLD, 24));
		lblStudentInformationSystem.setBounds(45, 100, 410, 50);
		Dashboard.add(lblStudentInformationSystem);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(
		new ImageIcon("src/sis/icons/harvard-square.png"));
		lblNewLabel_7.setBounds(35, 146, 410, 192);
		Dashboard.add(lblNewLabel_7);

		// view_info_panel start
		edit_student_panel = new JPanel();
		edit_student_panel.setBounds(0, 0, 480, 448);
		edit_student_panel.setBackground(new Color(255, 255, 255));
		layeredPane.add(edit_student_panel);
		edit_student_panel.setLayout(null);
		edit_student_panel.setVisible(true);

		lblNewLabel = new JLabel("Update Information");
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cantarell", Font.BOLD, 18));

		lblNewLabel.setBounds(35, 12, 190, 30);
		edit_student_panel.add(lblNewLabel);
		separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(12, 43, 456, 9);
		edit_student_panel.add(separator);

		textSearch1 = new JTextField();
		textSearch1.setBounds(100, 50, 125, 30);
		edit_student_panel.add(textSearch1);
		textSearch1.setColumns(10);

		JButton search_btn1 = new JButton("Search");

		search_btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName;
				fileName = textSearch1.getText() + ".txt";
				File updateFile = new File("src/sis/records/" + fileName);

				if (updateFile.exists()) {
					Notification1.setText("Record has been found.");
					btnLoad.setEnabled(true);
				} else if (textSearch1.getText().isEmpty()) {
					Notification1.setText("Text field can't be empty.");
				} else {
					Notification1.setText("Record not found.");
				}
			}
		});
		search_btn1.setBounds(230, 50, 110, 30);
		edit_student_panel.add(search_btn1);

		Notification1 = new JLabel("");
		Notification1.setBackground(Color.WHITE);
		Notification1.setForeground(Color.RED);
		Notification1.setBounds(100, 85, 240, 30);
		edit_student_panel.add(Notification1);

		JLabel lblStudentName_2 = new JLabel("Student Name : ");
		lblStudentName_2.setBounds(40, 175, 125, 30);
		edit_student_panel.add(lblStudentName_2);

		JLabel lblStudentId_1 = new JLabel("Student ID :");
		lblStudentId_1.setBounds(40, 205, 125, 30);
		edit_student_panel.add(lblStudentId_1);

		JLabel lblNewLabel_3 = new JLabel("Major : ");
		lblNewLabel_3.setBounds(40, 235, 125, 30);
		edit_student_panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Semester : ");
		lblNewLabel_4.setBounds(40, 265, 125, 30);
		edit_student_panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Credit : ");
		lblNewLabel_5.setBounds(40, 295, 125, 30);
		edit_student_panel.add(lblNewLabel_5);

		JLabel lblCgpa_1 = new JLabel("CGPA : ");
		lblCgpa_1.setBounds(40, 325, 125, 30);
		edit_student_panel.add(lblCgpa_1);

		UpdateName = new JTextField();
		UpdateName.setForeground(new Color(0, 128, 0));
		UpdateName.setBounds(170, 175, 130, 30);
		edit_student_panel.add(UpdateName);
		UpdateName.setColumns(10);

		UpdateID = new JTextField();
		UpdateID.setForeground(new Color(0, 128, 0));
		UpdateID.setBounds(170, 205, 130, 30);
		edit_student_panel.add(UpdateID);
		UpdateID.setColumns(10);

		UpdateMajor = new JTextField();
		UpdateMajor.setForeground(new Color(0, 128, 0));
		UpdateMajor.setBounds(170, 235, 130, 30);
		edit_student_panel.add(UpdateMajor);
		UpdateMajor.setColumns(10);

		UpdateSemester = new JTextField();
		UpdateSemester.setForeground(new Color(0, 128, 0));
		UpdateSemester.setColumns(10);
		UpdateSemester.setBounds(170, 265, 130, 30);
		edit_student_panel.add(UpdateSemester);

		UpdateCredit = new JTextField();
		UpdateCredit.setForeground(new Color(0, 128, 0));
		UpdateCredit.setColumns(10);
		UpdateCredit.setBounds(170, 295, 130, 30);
		edit_student_panel.add(UpdateCredit);

		UpdateCGPA = new JTextField();
		UpdateCGPA.setForeground(new Color(0, 128, 0));
		UpdateCGPA.setColumns(10);
		UpdateCGPA.setBounds(170, 325, 130, 30);
		edit_student_panel.add(UpdateCGPA);

		btnLoad = new JButton("Load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileName;
				fileName = textSearch1.getText() + ".txt";
				int confirm = JOptionPane.showConfirmDialog(null, "Load Information." + "!", "Information", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					Notification1.setText("");
					ObjectInputStream is;
					try {
						is = new ObjectInputStream(new FileInputStream(new File("src/sis/records/" + fileName)));
						Student s = (Student) is.readObject();
						UpdateName.setText(s.getName());
						UpdateName.setEnabled(false);
						UpdateID.setText(s.getID());
						UpdateID.setEnabled(false);
						UpdateMajor.setText(s.getMajor());
						UpdateMajor.setEnabled(false);
						UpdateSemester.setText(s.getSemester());
						UpdateSemester.setEnabled(false);
						UpdateCredit.setText(s.getCredit());
						UpdateCredit.setEnabled(false);
						UpdateCGPA.setText(s.getCGPA());
						UpdateCGPA.setEnabled(false);
						// System.out.println(s.getName() + " " + s.getID() + "
						// " + s.getMajor() + " " + s.getSemester() + " " +
						// s.getCredit() + " " + s.getCGPA());
						is.close();
						btnEdit.setEnabled(true);
					} catch (IOException e1) {

					} catch (ClassNotFoundException e1) {

					}
				}
			}
		});
		btnLoad.setForeground(Color.BLUE);
		btnLoad.setBounds(265, 120, 100, 30);
		edit_student_panel.add(btnLoad);
		btnEdit = new JButton("Edit");
		btnEdit.setForeground(new Color(0, 0, 128));

		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "Edit Information." + "!", "Information",	JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					UpdateName.setEnabled(true);
					UpdateID.setEnabled(false);
					UpdateMajor.setEnabled(true);
					UpdateSemester.setEnabled(true);
					UpdateCredit.setEnabled(true);
					UpdateCGPA.setEnabled(true);
					btnUpdate.setEnabled(true);
				} else {
					JOptionPane.showMessageDialog(null, "Edit Cancel." + "!");
				}
			}
		});

		btnEdit.setBounds(170, 120, 90, 30);
		edit_student_panel.add(btnEdit);
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fileUpdate;
				fileUpdate = textSearch1.getText() + ".txt";
				if (UpdateName.getText().isEmpty() || UpdateID.getText().isEmpty() || UpdateMajor.getText().isEmpty()
						|| UpdateSemester.getText().isEmpty() || UpdateCredit.getText().isEmpty()
						|| UpdateCGPA.getText().isEmpty()) {
					lblMessage.setText("Error : Text Fields Can't be Left Empty.!");

				} else {
					Student student = new Student();
					student.setName(UpdateName.getText());
					student.setID(UpdateID.getText());
					student.setMajor(UpdateMajor.getText());
					student.setSemester(UpdateSemester.getText());
					student.setCredit(UpdateCredit.getText());
					student.setCGPA(UpdateCGPA.getText());
					int p = JOptionPane.showConfirmDialog(null, "Do you really want to Update student data " + "!",	"Information", JOptionPane.YES_NO_OPTION);
					if (p == JOptionPane.YES_OPTION) {
						File file = new File("src/sis/records/" + fileUpdate);
						try {
							FileOutputStream fo = new FileOutputStream(file);
							ObjectOutputStream out = new ObjectOutputStream(fo);
							out.writeObject(student);
							out.close();
							fo.close();
						} catch (FileNotFoundException e1) {
						} catch (IOException e1) {
						}
						JOptionPane.showMessageDialog(null, "Record Updated Successfully.");
						textSearch1.setText("");
						Notification1.setText("");
						btnLoad.setEnabled(false);
						btnEdit.setEnabled(false);
						btnUpdate.setEnabled(false);
						UpdateName.setText("");
						UpdateName.setEnabled(false);
						UpdateID.setText("");
						// UpdateID.setEnabled(false);
						UpdateMajor.setText("");
						UpdateMajor.setEnabled(false);
						UpdateSemester.setText("");
						UpdateSemester.setEnabled(false);
						UpdateCredit.setText("");
						UpdateCredit.setEnabled(false);
						UpdateCGPA.setText("");
						UpdateCGPA.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null, "Record not Updated.");
					}
				}
			}
		});
		btnUpdate.setForeground(new Color(0, 128, 0));
		btnUpdate.setBounds(75, 120, 90, 30);
		edit_student_panel.add(btnUpdate);
		// edit_student_panel end
		// view_info_panel start
		view_info_panel = new JPanel();
		view_info_panel.setBackground(new Color(255, 255, 255));
		view_info_panel.setBounds(0, 0, 480, 448);
		layeredPane.add(view_info_panel);
		view_info_panel.setLayout(null);
		lblNewLabel = new JLabel("View Information");
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cantarell", Font.BOLD, 18));
		lblNewLabel.setBounds(35, 12, 150, 30);
		view_info_panel.add(lblNewLabel);
		separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(12, 43, 456, 9);
		view_info_panel.add(separator);
		textSearch = new JTextField();
		textSearch.setBounds(100, 50, 125, 30);
		view_info_panel.add(textSearch);
		textSearch.setColumns(10);
		JButton search_btn = new JButton("Search");
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String searchFile;
				searchFile = textSearch.getText() + ".txt";
				File file = new File("src/sis/records/" + searchFile);
				if (file.exists()) {
					Notification.setText("Record has been found.");
				} else if (textSearch.getText().isEmpty()) {
					Notification.setText("Text field can't be empty.");
				} else {
					Notification.setText("Record not found.");
				}
			}
		});
		search_btn.setBounds(230, 50, 110, 30);
		view_info_panel.add(search_btn);
		Notification = new JLabel("");
		Notification.setForeground(Color.RED);
		Notification.setBackground(Color.WHITE);
		Notification.setBounds(100, 85, 240, 30);
		view_info_panel.add(Notification);
		
		JLabel lblStudentName_1 = new JLabel("Student Name : ");
		lblStudentName_1.setBounds(40, 175, 125, 30);
		view_info_panel.add(lblStudentName_1);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID :");
		lblNewLabel_1.setBounds(40, 205, 125, 30);
		view_info_panel.add(lblNewLabel_1);
		
		JLabel lblMajor_1 = new JLabel("Major :");
		lblMajor_1.setBounds(40, 235, 125, 30);
		view_info_panel.add(lblMajor_1);
		
		JLabel lblSemester_1 = new JLabel("Semester :");
		lblSemester_1.setBounds(40, 265, 125, 30);
		view_info_panel.add(lblSemester_1);
		
		JLabel lblCredit_1 = new JLabel("Credit :");
		lblCredit_1.setBounds(40, 295, 125, 30);
		view_info_panel.add(lblCredit_1);
		
		JLabel lblNewLabel_2 = new JLabel("CGPA : ");
		lblNewLabel_2.setBounds(40, 325, 125, 30);
		view_info_panel.add(lblNewLabel_2);
		
		JLabel NameLabel = new JLabel("");
		NameLabel.setForeground(new Color(0, 100, 0));
		NameLabel.setBounds(170, 175, 125, 30);
		view_info_panel.add(NameLabel);
		
		JLabel IDLabel = new JLabel("");
		IDLabel.setForeground(new Color(0, 100, 0));
		IDLabel.setBounds(170, 205, 125, 30);
		view_info_panel.add(IDLabel);
		
		JLabel MajorLabel = new JLabel("");
		MajorLabel.setForeground(new Color(0, 100, 0));
		MajorLabel.setBounds(170, 235, 125, 30);
		view_info_panel.add(MajorLabel);
		
		JLabel SemesterLabel = new JLabel("");
		SemesterLabel.setForeground(new Color(0, 100, 0));
		SemesterLabel.setBounds(170, 265, 125, 30);
		view_info_panel.add(SemesterLabel);
		
		JLabel CreditLabel = new JLabel("");
		CreditLabel.setForeground(new Color(0, 100, 0));
		CreditLabel.setBounds(170, 295, 125, 30);
		view_info_panel.add(CreditLabel);
		
		JLabel CGPALabel = new JLabel("");
		CGPALabel.setForeground(new Color(0, 100, 0));
		CGPALabel.setBounds(170, 325, 125, 30);
		view_info_panel.add(CGPALabel);
		
		JButton ViewBtn = new JButton("View");
		ViewBtn.setForeground(new Color(29, 9, 226));
		
		ViewBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileName = textSearch.getText() + ".txt";
				File file = new File("src/sis/records/" + fileName);
				ObjectInputStream is;
				try {
					is = new ObjectInputStream(new FileInputStream(file));
					Student s = (Student) is.readObject();
					NameLabel.setText(s.getName());
					IDLabel.setText(s.getID());
					MajorLabel.setText(s.getMajor());
					SemesterLabel.setText(s.getSemester());
					CreditLabel.setText(s.getCredit());
					CGPALabel.setText(s.getCGPA());
					// System.out.println(s.getName() + " " + s.getID() + " " +
					// s.getMajor() + " " + s.getSemester() + " " +
					// s.getCredit() + " " + s.getCGPA());
					is.close();
				} catch (IOException e) {
				} catch (ClassNotFoundException e) {
				}
				textSearch.setText("");
				Notification.setText("");
			}
		});

		ViewBtn.setBounds(170, 120, 100, 30);

		view_info_panel.add(ViewBtn);
		add_student_panel = new JPanel();
		add_student_panel.setBounds(0, 0, 480, 448);
		add_student_panel.setBackground(new Color(255, 255, 255));
		layeredPane.add(add_student_panel);
		add_student_panel.setLayout(null);
		add_student_panel.setVisible(true);
		
		lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Cantarell", Font.BOLD, 18));
		lblNewLabel.setBounds(35, 12, 150, 30);
		add_student_panel.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(12, 43, 456, 9);
		add_student_panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "New Student ", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(35, 60, 410, 365);

		add_student_panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setBounds(40, 60, 125, 30);
		panel_1.add(lblStudentName);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setBounds(40, 90, 125, 30);
		panel_1.add(lblStudentId);
		
		JLabel lblMajor = new JLabel("Major");
		lblMajor.setBounds(40, 120, 125, 30);
		panel_1.add(lblMajor);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(40, 150, 125, 30);
		panel_1.add(lblSemester);
		
		JLabel lblCredit = new JLabel("Credit");
		lblCredit.setBounds(40, 180, 125, 30);
		panel_1.add(lblCredit);
		
		JLabel lblCgpa = new JLabel("CGPA");
		lblCgpa.setBounds(40, 210, 125, 30);
		panel_1.add(lblCgpa);
		
		name = new JTextField();
		name.setBounds(185, 60, 160, 30);
		panel_1.add(name);
		name.setColumns(10);
		
		id = new JTextField();
		id.setBounds(185, 90, 160, 30);
		panel_1.add(id);
		id.setColumns(10);
		
		JComboBox<String> major = new JComboBox<String>();
		major.setBounds(185, 120, 160, 25);
		panel_1.add(major);
		major.setModel(new DefaultComboBoxModel<String>(new String[] { "Choose", "BBA", "CSC", "EEE", "ETE", "ENV" }));
		
		JComboBox<String> semester = new JComboBox<String>();
		semester.setBounds(185, 150, 160, 25);
		panel_1.add(semester);
		semester.setModel(new DefaultComboBoxModel<String>(new String[] { "Choose", "Autumn", "Spring", "Summer" }));

		credit = new JTextField();
		credit.setBounds(185, 180, 160, 30);
		panel_1.add(credit);
		credit.setColumns(10);
		cgpa = new JTextField();
		cgpa.setBounds(185, 210, 160, 30);
		panel_1.add(cgpa);
		cgpa.setColumns(10);
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().isEmpty() || id.getText().isEmpty() || major.getSelectedItem().equals("Choose") 
						|| semester.getSelectedItem().equals("Choose") || credit.getText().isEmpty()
						|| cgpa.getText().isEmpty()) {
					lblMessage.setText("Error : Text Fields Can't be Left Empty.!");
				} else {
					String Major = (String) major.getSelectedItem();
					String Semester = (String) semester.getSelectedItem();
					Student student = new Student();
					
					student.setName(name.getText());
					student.setID(id.getText());
					student.setMajor(Major);
					student.setSemester(Semester);
					student.setCredit(credit.getText());
					student.setCGPA(cgpa.getText());
					
					int p = JOptionPane.showConfirmDialog(null, "You are going to record a student data " + "!", "Information", JOptionPane.YES_NO_OPTION);
					if (p == JOptionPane.YES_OPTION) {
						fileName = id.getText() + ".txt";
						File file = new File("src/sis/records/" + fileName);
						if (file.exists()) {
							JOptionPane.showMessageDialog(null, "User with this ID alreasy exists.\nTry New One.");
						} else {
							try {
								FileOutputStream fo = new FileOutputStream(file);
								ObjectOutputStream out = new ObjectOutputStream(fo);
								out.writeObject(student);
								out.close();
								fo.close();
							} catch (FileNotFoundException e1) {
							} catch (IOException e1) {
							}
							JOptionPane.showMessageDialog(null, "Record saved successfully.");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Record not saved.");
					}
				}
			}
		});
		btnSave.setBounds(270, 285, 75, 30);
		panel_1.add(btnSave);
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				name.setText(null);
				id.setText(null);
				major.setSelectedIndex(0);
				semester.setSelectedIndex(0);
				credit.setText(null);
				cgpa.setText(null);
				lblMessage.setText("Message");
			}
		});
		btnReset.setBounds(185, 285, 75, 30);
		panel_1.add(btnReset);
		lblMessage = new JLabel("Message");
		lblMessage.setForeground(Color.RED);
		lblMessage.setBounds(40, 29, 305, 30);
		panel_1.add(lblMessage);
		JPanel main_panel = new JPanel();
		main_panel.setBackground(Color.WHITE);
		main_panel.setBounds(0, 0, 640, 460);
		frame.getContentPane().add(main_panel);
		main_panel.setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		panel.setBounds(0, 0, 160, 448);
		main_panel.add(panel);
		panel.setLayout(null);
		JButton add_btn = new JButton("Add Student");
		add_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.setVisible(false);
				add_student_panel.setVisible(true);
				edit_student_panel.setVisible(false);
				view_info_panel.setVisible(false);
			}
		});
		add_btn.setHorizontalAlignment(SwingConstants.LEFT);
		add_btn.setBounds(12, 160, 136, 35);
		panel.add(add_btn);
		JButton edit_btn = new JButton("Update Info");
		edit_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.setVisible(false);
				edit_student_panel.setVisible(true);
				add_student_panel.setVisible(false);
				view_info_panel.setVisible(false);
			}
		});
		edit_btn.setHorizontalAlignment(SwingConstants.LEFT);
		edit_btn.setBounds(12, 207, 136, 35);
		panel.add(edit_btn);
		JButton view_btn = new JButton("View Info");
		view_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard.setVisible(false);
				add_student_panel.setVisible(false);
				edit_student_panel.setVisible(false);
				view_info_panel.setVisible(true);
			}
		});
		view_btn.setHorizontalAlignment(SwingConstants.LEFT);
		view_btn.setBounds(12, 255, 136, 35);
		panel.add(view_btn);
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setForeground(new Color(255, 0, 0));
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Do You Really Want to Sign Out." + "?",
						"Information", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "Sign Out Success.");
					frame.dispose();
					Main si = new Main();
					si.show();
				} else {
					JOptionPane.showMessageDialog(null, "Sign Out Cancel.");
				}
			}
		});
		btnSignOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnSignOut.setBounds(12, 302, 136, 35);
		panel.add(btnSignOut);
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("src/sis/icons/monitor.png"));
		label.setBounds(16, 12, 128, 128);
		panel.add(label);
	}

	public void show() {
		frame.setVisible(true);
	}
}