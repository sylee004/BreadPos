
package BreadPos;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import DB.Bread;

public class MainGUI {

	private JFrame frame;
	private ImageIcon icon;
	private BufferedImage bimg;
	private JTable userTable;
	private JScrollPane listJs;
	private JPanel listPanel;
	private JButton managementBtn;
	private JButton salesBtn;
	private JButton paymentBtn;
	private Management mg;
	private Bread breadSelectBtn;
	private Tab tab;
	private static Vector vector;

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
	 * @wbp.parser.constructor
	 */

	public MainGUI() {
		tab = new Tab();
		mg = new Management();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 975, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel mainPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					bimg = ImageIO.read(new File("./image/mainBack.jpg"));
					Dimension d = getSize();// ÀüÃ¼È­¸é
					g.drawImage(bimg, 0, 0, d.width, d.height, null);
					setOpaque(false);
					setBackground(new Color(0, 0, 0, 0));
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		springLayout.putConstraint(SpringLayout.NORTH, mainPanel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, mainPanel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, mainPanel, 617, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, mainPanel, 959, SpringLayout.WEST, frame.getContentPane());
		//mainPanel.setOpaque(false);
		mainPanel.setBackground(new Color(220, 220, 220));
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel leftPanel = new JPanel();
		leftPanel.setOpaque(false);
		mainPanel.add(leftPanel);
		SpringLayout sl_leftPanel = new SpringLayout();
		leftPanel.setLayout(sl_leftPanel);

		JPanel ShowPanel = new JPanel();
		ShowPanel.setOpaque(false);
		sl_leftPanel.putConstraint(SpringLayout.NORTH, ShowPanel, 50, SpringLayout.NORTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, ShowPanel, 21, SpringLayout.WEST, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, ShowPanel, -127, SpringLayout.SOUTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, ShowPanel, -10, SpringLayout.EAST, leftPanel);
		ShowPanel.setBackground(new Color(211, 211, 211));
		ShowPanel.setForeground(new Color(0, 0, 0));
		leftPanel.add(ShowPanel);
		SpringLayout sl_ShowPanel = new SpringLayout();
		ShowPanel.setLayout(sl_ShowPanel);

		JPanel columnsPanel = new JPanel();
		sl_ShowPanel.putConstraint(SpringLayout.WEST, columnsPanel, 10, SpringLayout.WEST, ShowPanel);
		columnsPanel.setOpaque(false);
		sl_ShowPanel.putConstraint(SpringLayout.NORTH, columnsPanel, 10, SpringLayout.NORTH, ShowPanel);
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

		JPanel totalMoneyPanel = new JPanel();
		totalMoneyPanel.setOpaque(false);
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
		paymentPanel.setOpaque(false);
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
		rightPanel.setOpaque(false);
		mainPanel.add(rightPanel);
		SpringLayout sl_rightPanel = new SpringLayout();
		rightPanel.setLayout(sl_rightPanel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
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
		closeBtn.setBackground(new Color(139, 69, 19));
		buttonPanel.add(closeBtn);

		JPanel tabbedPanel = new JPanel();
		sl_rightPanel.putConstraint(SpringLayout.SOUTH, tabbedPanel, -21, SpringLayout.SOUTH, rightPanel);
		tabbedPanel.setOpaque(false);
		icon = new ImageIcon("BreadPos/image/KakaoTalk_20171018_201408552.jpg");

		sl_rightPanel.putConstraint(SpringLayout.NORTH, tabbedPanel, 6, SpringLayout.SOUTH, buttonPanel);
		sl_rightPanel.putConstraint(SpringLayout.WEST, tabbedPanel, 10, SpringLayout.WEST, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.EAST, tabbedPanel, 0, SpringLayout.EAST, buttonPanel);
		rightPanel.add(tabbedPanel);
		tabbedPanel.setLayout(new GridLayout(1, 0, 10, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPanel.add(tabbedPane);
		
		JPanel whitePanel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					bimg = ImageIO.read(new File("./image/background.png"));
					Dimension d = getSize();// ÀüÃ¼È­¸é
					g.drawImage(bimg, 0, 0, d.width, d.height, null);
					setOpaque(false);
					setBackground(new Color(0, 0, 0, 0));
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		whitePanel.setOpaque(false);
		tabbedPane.addTab("white", new ImageIcon("C:\\Users\\togla\\Desktop\\loginBtn01.png"), whitePanel, "¹Ð°¡·ç");
		whitePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(whitePanel, "white");
		
		JPanel boriPanel = new JPanel();
		tabbedPane.addTab("bori", null, boriPanel, "º¸¸®");
		boriPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(boriPanel, "bori");
		
		JPanel cornPanel = new JPanel();
		tabbedPane.addTab("corn", null, cornPanel, "¿Á¼ö¼ö");
		cornPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(cornPanel, "corn");
		
		JPanel ryePanel = new JPanel();
		tabbedPane.addTab("rye", null, ryePanel, "È£¹Ð");
		ryePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(ryePanel, "rye");
		
		JPanel mixturePanel = new JPanel();
		tabbedPane.addTab("mixture", null, mixturePanel, "È¥ÇÕ");
		mixturePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(mixturePanel, "mix");
		
		JPanel othherPanel = new JPanel();
		tabbedPane.addTab("other", null, othherPanel, "±âÅ¸");
		othherPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(othherPanel, "other");
	}

	public static void sendMessage(Bread list) {
		vector.add(list);
		System.out.println(list.getName());
	
	}
}