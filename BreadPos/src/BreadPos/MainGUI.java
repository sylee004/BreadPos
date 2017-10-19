package BreadPos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class MainGUI {

	private JFrame frame;
	private JTextField textField;
	 ImageIcon icon;
	 private JTable table;
	 JTable userTable;
	 JScrollPane listJs;
	 JPanel listPanel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
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
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 975, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 607, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 949, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_5 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_5, 120, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_5, -10, SpringLayout.SOUTH, panel_1);
		panel_1.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_5, -17, SpringLayout.WEST, panel_6);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_6, -171, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_6, -10, SpringLayout.SOUTH, panel_1);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_4 = new JButton("\uCDE8\uC18C");
		btnNewButton_4.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_4.setForeground(new Color(240, 248, 255));
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_4.setBackground(UIManager.getColor("Button.orange"));
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_4.setBackground(new Color(139, 0, 0));
		panel_5.add(btnNewButton_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_6, -10, SpringLayout.EAST, panel_1);
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_5 = new JButton("\uACB0\uC81C");
		btnNewButton_5.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_5.setForeground(new Color(240, 248, 255));
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_5.setBackground(Color.orange);
				PaymentGUI paymentGUI = new PaymentGUI();
				paymentGUI.main(null);
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBackground(new Color(139, 0, 0));
		panel_6.add(btnNewButton_5);
		
		JPanel panel_7 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_5, 23, SpringLayout.SOUTH, panel_7);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_6, 23, SpringLayout.SOUTH, panel_7);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_7, 23, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_7, -72, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_7, -10, SpringLayout.EAST, panel_1);
		panel_1.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);
		
		textField = new JTextField();
		textField.setFont(new Font("±¼¸²", Font.BOLD, 16));
		textField.setForeground(new Color(240, 248, 255));
		sl_panel_7.putConstraint(SpringLayout.SOUTH, textField, 49, SpringLayout.NORTH, panel_7);
		textField.setBackground(new Color(233, 150, 122));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_7.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, textField, 128, SpringLayout.WEST, panel_7);
		textField.setText("\uCD1D \uACB0\uC81C \uAE08\uC561 :");
		panel_7.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		sl_panel_7.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.EAST, textField);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, textField);
		sl_panel_7.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, panel_7);
		panel_7.add(lblNewLabel);
		
		JPanel panel_8 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_8, 21, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_8, -127, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_8, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_7, 6, SpringLayout.SOUTH, panel_8);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_8, 50, SpringLayout.NORTH, panel_1);
		panel_8.setBackground(new Color(211, 211, 211));
		panel_8.setForeground(new Color(0, 0, 0));
		panel_1.add(panel_8);
		SpringLayout sl_panel_8 = new SpringLayout();
		panel_8.setLayout(sl_panel_8);
		
		JPanel panel_9 = new JPanel();
		sl_panel_8.putConstraint(SpringLayout.NORTH, panel_9, 10, SpringLayout.NORTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.WEST, panel_9, 10, SpringLayout.WEST, panel_8);
		sl_panel_8.putConstraint(SpringLayout.SOUTH, panel_9, -10, SpringLayout.SOUTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.EAST, panel_9, 40, SpringLayout.WEST, panel_8);
		panel_8.add(panel_9);
		panel_9.setLayout(new GridLayout(10, 0, 0, 0));
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox_8);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("");
		panel_9.add(chckbxNewCheckBox_9);
		
		JPanel panel_10 = new JPanel();
		sl_panel_8.putConstraint(SpringLayout.NORTH, panel_10, 10, SpringLayout.NORTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.WEST, panel_10, 6, SpringLayout.EAST, panel_9);
		sl_panel_8.putConstraint(SpringLayout.SOUTH, panel_10, -375, SpringLayout.SOUTH, panel_8);
		sl_panel_8.putConstraint(SpringLayout.EAST, panel_10, -10, SpringLayout.EAST, panel_8);
		panel_8.add(panel_10);
		panel_10.setLayout(new GridLayout(1, 3, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("\uC0C1\uD488 \uC774\uB984");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel_2.setBackground(new Color(233, 150, 122));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uC218\uB7C9");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel_3.setBackground(new Color(233, 150, 122));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uAC00\uACA9");
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lblNewLabel_4.setBackground(new Color(233, 150, 122));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(lblNewLabel_4);
		
		JPanel panel_11 = new JPanel();
		sl_panel_8.putConstraint(SpringLayout.NORTH, panel_11, 6, SpringLayout.SOUTH, panel_10);
		sl_panel_8.putConstraint(SpringLayout.WEST, panel_11, 6, SpringLayout.EAST, panel_9);
		sl_panel_8.putConstraint(SpringLayout.SOUTH, panel_11, 365, SpringLayout.SOUTH, panel_10);
		sl_panel_8.putConstraint(SpringLayout.EAST, panel_11, 388, SpringLayout.EAST, panel_9);
		panel_8.add(panel_11);
		panel_11.setLayout(new CardLayout(0, 0));
		
		table = new JTable();
		Vector<String> userColumn = new Vector<>();
		DefaultTableModel model;
		Vector<String> userRow;
		
		userColumn.add("½Ä»§");
		userColumn.add("10");
		userColumn.add("100000");
		
		model = new DefaultTableModel(userColumn, 0);
		userTable = new JTable();
		
		panel_11.add(table, "name_7085723367180");
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JPanel panel_3 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_3, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_3, 86, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_3, 47, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_3, -10, SpringLayout.EAST, panel_2);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 4, 10, 0));
		
		JButton btnNewButton = new JButton("\uACB0\uC81C");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(240, 248, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton.setBackground(Color.orange);
			}
		});
		btnNewButton.setBackground(new Color(139, 69, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panel_3.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uAD00\uB9AC");
		btnNewButton_1.setForeground(new Color(240, 248, 255));
		btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setBackground(Color.orange);
				
				ManagementGUI managementGUI = new ManagementGUI();
				managementGUI.frame.setVisible(true);
				managementGUI.setOnMyClickListener(new MyCllickListener() {
					@Override
					public void onClick() {
						// TODO Auto-generated method stub
						btnNewButton_1.setBackground(Color.red);
					}
				});
				
			}
		});
		btnNewButton_1.setBackground(new Color(139, 69, 19));
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uB9E4\uCD9C");
		btnNewButton_2.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_2.setForeground(new Color(240, 248, 255));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_2.setBackground(Color.orange);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesGUI salesGUI = new salesGUI();
				salesGUI.main(null);
			}
		});
		btnNewButton_2.setBackground(new Color(139, 69, 19));
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uC885\uB8CC");
		btnNewButton_3.setForeground(new Color(240, 248, 255));
		btnNewButton_3.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBackground(new Color(139, 69, 19));
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		icon = new ImageIcon("BreadPos/image/KakaoTalk_20171018_201408552.jpg");
		
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_3);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_4, 0, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_3);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 10, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_4.add(tabbedPane);
		
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("½Ä»§", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("¹Ù°ÔÆ®", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("¼Ò¼¼Áö»§", null, tabbedPane_3, null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("¿ìÀ¯", null, tabbedPane_4, null);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("¸¶Ä«·Õ", null, tabbedPane_5, null);
		
		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("µµ³Ó", null, tabbedPane_6, null);
	}
}