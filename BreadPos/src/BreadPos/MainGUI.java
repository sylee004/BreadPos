
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

import DB.Bread;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
	private ImageIcon icon;
	private JTable table;
	private JTable userTable;
	private JScrollPane listJs;
	private JPanel listPanel;
	private JButton managementBtn;
	private JButton salesBtn;
	private JButton paymentBtn;
	private Management mg;
	private ArrayList<Bread> whiteBread;

	/**
	 * Launch the application.
	 */
	public static void main(int office_num) {
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
		mg = new Management();
		whiteBread = new ArrayList<Bread>();
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

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(220, 220, 220));
		springLayout.putConstraint(SpringLayout.NORTH, mainPanel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, mainPanel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, mainPanel, 607, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, mainPanel, 949, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel leftPanel = new JPanel();
		mainPanel.add(leftPanel);
		SpringLayout sl_leftPanel = new SpringLayout();
		leftPanel.setLayout(sl_leftPanel);

		JPanel ShowPanel = new JPanel();
		sl_leftPanel.putConstraint(SpringLayout.NORTH, ShowPanel, 50, SpringLayout.NORTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, ShowPanel, 21, SpringLayout.WEST, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, ShowPanel, -127, SpringLayout.SOUTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, ShowPanel, -10, SpringLayout.EAST, leftPanel);
		ShowPanel.setBackground(new Color(211, 211, 211));
		ShowPanel.setForeground(new Color(0, 0, 0));
		leftPanel.add(ShowPanel);
		SpringLayout sl_ShowPanel = new SpringLayout();
		ShowPanel.setLayout(sl_ShowPanel);

		JPanel chckbxPanel = new JPanel();
		sl_ShowPanel.putConstraint(SpringLayout.NORTH, chckbxPanel, 51, SpringLayout.NORTH, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.WEST, chckbxPanel, 10, SpringLayout.WEST, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.SOUTH, chckbxPanel, -10, SpringLayout.SOUTH, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.EAST, chckbxPanel, 40, SpringLayout.WEST, ShowPanel);
		ShowPanel.add(chckbxPanel);
		chckbxPanel.setLayout(new GridLayout(10, 0, 0, 0));

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox_3);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("");
		chckbxNewCheckBox_5.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox_5);

		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("");
		chckbxNewCheckBox_4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox_4);

		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("");
		chckbxNewCheckBox_7.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox_7);

		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("");
		chckbxNewCheckBox_8.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox_8);

		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("");
		chckbxNewCheckBox_6.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox_6);

		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("");
		chckbxNewCheckBox_9.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxPanel.add(chckbxNewCheckBox_9);

		JPanel columnsPanel = new JPanel();
		sl_ShowPanel.putConstraint(SpringLayout.NORTH, columnsPanel, 10, SpringLayout.NORTH, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.WEST, columnsPanel, 46, SpringLayout.WEST, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.SOUTH, columnsPanel, -375, SpringLayout.SOUTH, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.EAST, columnsPanel, -10, SpringLayout.EAST, ShowPanel);
		ShowPanel.add(columnsPanel);
		columnsPanel.setLayout(new GridLayout(1, 3, 0, 0));

		JLabel productLabel = new JLabel("\uC0C1\uD488 \uC774\uB984");
		productLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
		productLabel.setBackground(new Color(233, 150, 122));
		productLabel.setHorizontalAlignment(SwingConstants.CENTER);
		columnsPanel.add(productLabel);

		JLabel amountLabel = new JLabel("\uC218\uB7C9");
		amountLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
		amountLabel.setBackground(new Color(233, 150, 122));
		amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		columnsPanel.add(amountLabel);

		JLabel PriceLabel = new JLabel("\uAC00\uACA9");
		PriceLabel.setFont(new Font("±¼¸²", Font.BOLD, 15));
		PriceLabel.setBackground(new Color(233, 150, 122));
		PriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		columnsPanel.add(PriceLabel);

		JPanel tablePanel = new JPanel();
		sl_ShowPanel.putConstraint(SpringLayout.NORTH, tablePanel, 6, SpringLayout.SOUTH, columnsPanel);
		sl_ShowPanel.putConstraint(SpringLayout.WEST, tablePanel, 6, SpringLayout.EAST, chckbxPanel);
		sl_ShowPanel.putConstraint(SpringLayout.SOUTH, tablePanel, 365, SpringLayout.SOUTH, columnsPanel);
		sl_ShowPanel.putConstraint(SpringLayout.EAST, tablePanel, -10, SpringLayout.EAST, ShowPanel);
		ShowPanel.add(tablePanel);
		tablePanel.setLayout(new CardLayout(0, 0));

		table = new JTable();

		tablePanel.add(table, "name_7085723367180");

		JPanel totalMoneyPanel = new JPanel();
		sl_leftPanel.putConstraint(SpringLayout.NORTH, totalMoneyPanel, 6, SpringLayout.SOUTH, ShowPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, totalMoneyPanel, 181, SpringLayout.WEST, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, totalMoneyPanel, -72, SpringLayout.SOUTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, totalMoneyPanel, -10, SpringLayout.EAST, leftPanel);
		leftPanel.add(totalMoneyPanel);
		SpringLayout sl_totalMoneyPanel = new SpringLayout();
		totalMoneyPanel.setLayout(sl_totalMoneyPanel);

		JLabel lblNewLabel_1 = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561 :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 16));
		sl_totalMoneyPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 49, SpringLayout.NORTH, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 128, SpringLayout.WEST, totalMoneyPanel);
		totalMoneyPanel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("New label");
		sl_totalMoneyPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		sl_totalMoneyPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, totalMoneyPanel);
		totalMoneyPanel.add(lblNewLabel);

		JPanel paymentPanel = new JPanel();
		sl_leftPanel.putConstraint(SpringLayout.NORTH, paymentPanel, 20, SpringLayout.SOUTH, totalMoneyPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, paymentPanel, 166, SpringLayout.WEST, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, paymentPanel, -10, SpringLayout.SOUTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, paymentPanel, -10, SpringLayout.EAST, leftPanel);
		leftPanel.add(paymentPanel);
		paymentPanel.setLayout(new GridLayout(1, 2, 20, 0));

		JButton cancelBtn = new JButton("\uCDE8\uC18C");
		paymentPanel.add(cancelBtn);
		cancelBtn.setFont(new Font("±¼¸²", Font.BOLD, 15));
		cancelBtn.setForeground(new Color(240, 248, 255));
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cancelBtn.setBackground(UIManager.getColor("Button.orange"));
			}
		});
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		cancelBtn.setBackground(new Color(139, 0, 0));

		paymentBtn = new JButton("\uACB0\uC81C");
		paymentPanel.add(paymentBtn);
		paymentBtn.setFont(new Font("±¼¸²", Font.BOLD, 15));
		paymentBtn.setForeground(new Color(240, 248, 255));

		paymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentBtn.setBackground(Color.orange);

				PaymentGUI paymentGUI = new PaymentGUI();
				paymentGUI.frame.setVisible(true);
				paymentGUI.setOnMyClickListener(new MyCllickListener() {

					@Override
					public void onClick() {
						paymentBtn.setBackground(new Color(139, 0, 0));

					}
				});
			}
		});
		paymentBtn.setBackground(new Color(139, 0, 0));
		Vector<String> userColumn = new Vector<>();
		DefaultTableModel model;
		Vector<String> userRow;

		userColumn.add("½Ä»§");
		userColumn.add("10");
		userColumn.add("100000");

		model = new DefaultTableModel(userColumn, 0);
		userTable = new JTable();

		JPanel rightPanel = new JPanel();
		mainPanel.add(rightPanel);
		SpringLayout sl_rightPanel = new SpringLayout();
		rightPanel.setLayout(sl_rightPanel);

		JPanel buttonPanel = new JPanel();
		sl_rightPanel.putConstraint(SpringLayout.NORTH, buttonPanel, 10, SpringLayout.NORTH, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.WEST, buttonPanel, 150, SpringLayout.WEST, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.SOUTH, buttonPanel, 47, SpringLayout.NORTH, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.EAST, buttonPanel, -10, SpringLayout.EAST, rightPanel);
		rightPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(1, 3, 20, 0));

		managementBtn = new JButton("\uAD00\uB9AC");
		managementBtn.setForeground(new Color(240, 248, 255));
		managementBtn.setFont(new Font("±¼¸²", Font.BOLD, 15));
		managementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managementBtn.setBackground(Color.orange);

				ManagementGUI managementGUI = new ManagementGUI();
				managementGUI.frame.setVisible(true);
				managementGUI.setOnMyClickListener(new MyCllickListener() {
					@Override
					public void onClick() {
						// TODO Auto-generated method stub
						managementBtn.setBackground(new Color(139, 69, 19));
					}
				});

			}
		});

		managementBtn.setBackground(new Color(139, 69, 19));
		buttonPanel.add(managementBtn);

		salesBtn = new JButton("\uB9E4\uCD9C");
		salesBtn.setFont(new Font("±¼¸²", Font.BOLD, 15));
		salesBtn.setForeground(new Color(240, 248, 255));
		salesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesBtn.setBackground(Color.orange);

				salesGUI salesGUI = new salesGUI();
				salesGUI.frame.setVisible(true);
				salesGUI.setOnMyClickListener(new MyCllickListener() {
					@Override
					public void onClick() {
						// TODO Auto-generated method stub
						salesBtn.setBackground(new Color(139, 69, 19));
					}
				});

			}
		});
		salesBtn.setBackground(new Color(139, 69, 19));
		buttonPanel.add(salesBtn);

		JButton closeBtn = new JButton("\uC885\uB8CC");
		closeBtn.setForeground(new Color(240, 248, 255));
		closeBtn.setFont(new Font("±¼¸²", Font.BOLD, 15));
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		closeBtn.setBackground(new Color(139, 69, 19));
		buttonPanel.add(closeBtn);

		JPanel tabbedPanel = new JPanel();
		icon = new ImageIcon("BreadPos/image/KakaoTalk_20171018_201408552.jpg");

		sl_rightPanel.putConstraint(SpringLayout.NORTH, tabbedPanel, 6, SpringLayout.SOUTH, buttonPanel);
		sl_rightPanel.putConstraint(SpringLayout.WEST, tabbedPanel, 10, SpringLayout.WEST, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.SOUTH, tabbedPanel, 0, SpringLayout.SOUTH, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.EAST, tabbedPanel, 0, SpringLayout.EAST, buttonPanel);
		rightPanel.add(tabbedPanel);
		tabbedPanel.setLayout(new GridLayout(1, 0, 10, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanel.add(tabbedPane);
		
		JPanel whitePanel = new JPanel();
		tabbedPane.addTab("white", new ImageIcon("C:\\Users\\togla\\Desktop\\loginBtn01.png"), whitePanel, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		whitePanel.setLayout(new GridLayout(5, 5, 20, 20));

		whiteBread = mg.breadKind("white");
		
		for (int i = 0; i <= whiteBread.size(); i++) {
			String name = whiteBread.get(i).getName();
			JButton btnNewButton = new JButton(name);
			whitePanel.add(btnNewButton);
		}
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);

		JTabbedPane whiteTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("¹Ð°¡·ç»§", new ImageIcon("C:\\Users\\togla\\Desktop\\loginBtn01.png"), whiteTab, "\uBC00\uAC00\uB8E8\uBE75");

		JTabbedPane boriTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("º¸¸®»§", null, boriTab, null);

		JTabbedPane cornTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("¿Á¼ö¼ö»§", null, cornTab, null);

		JTabbedPane ryeTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("È£¹Ð»§", null, ryeTab, null);

		JTabbedPane mixtureTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("È¥ÇÕ»§", null, mixtureTab, null);

		JTabbedPane otherTab = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("±âÅ¸", null, otherTab, null);
	}
}