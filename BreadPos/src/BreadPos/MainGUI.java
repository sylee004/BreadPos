
package BreadPos;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import javax.swing.ListModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import DB.Bread;
import DB.Product;

import javax.swing.border.EmptyBorder;
import javax.swing.JInternalFrame;

public class MainGUI {

	public static JFrame frame;
	private ImageIcon icon;
	private BufferedImage bimg;
	private JTable userTable;
	private JScrollPane listJs;
	private JPanel listPanel;
	private JButton managementBtn;
	private JButton salesBtn;
	private JButton paymentBtn;
	private static Management mg;
	private Bread breadSelectBtn;
	private Tab tab;
	private static JLabel lblNewLabel;
	private static JPanel productPanel;
	private static JPanel amountPanel;
	private static JPanel pricePanel;
	private static List listM;
	private static ArrayList<Product> breadList;
	private static int office_num;
	private JTable choiceTable;
	private JTable productTable;
	private JTable amountTable;
	private JTable priceTable;
	private static int input;

	/**
	 * Launch the application.
	 */
	public static void main(int office_num) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI(office_num);
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

	public MainGUI(int office_num) {
		this.office_num = office_num;
		tab = new Tab();
		mg = new Management();
		listM = new List();
		breadList = mg.selectProduct();
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
 
		JPanel mainPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					bimg = ImageIO.read(new File("./image/»§¹è°æÈ­¸é¼öÁ¤.png"));
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
		// mainPanel.setOpaque(false);
		mainPanel.setBackground(new Color(220, 220, 220));
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel leftPanel = new JPanel();
		leftPanel.setOpaque(false);
		mainPanel.add(leftPanel);
		SpringLayout sl_leftPanel = new SpringLayout();
		leftPanel.setLayout(sl_leftPanel);

		JPanel ShowPanel = new JPanel();
		sl_leftPanel.putConstraint(SpringLayout.NORTH, ShowPanel, 50, SpringLayout.NORTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, ShowPanel, 10, SpringLayout.WEST, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, ShowPanel, -21, SpringLayout.EAST, leftPanel);
		ShowPanel.setOpaque(false);
		ShowPanel.setBackground(Color.WHITE);
		ShowPanel.setForeground(new Color(0, 0, 0));
		leftPanel.add(ShowPanel);
		SpringLayout sl_ShowPanel = new SpringLayout();
		ShowPanel.setLayout(sl_ShowPanel);

		JPanel columnsPanel = new JPanel();
		columnsPanel.setBackground(new Color(255, 255, 255, 150));
		columnsPanel.setOpaque(false);
		sl_ShowPanel.putConstraint(SpringLayout.WEST, columnsPanel, 10, SpringLayout.WEST, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.NORTH, columnsPanel, 10, SpringLayout.NORTH, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.SOUTH, columnsPanel, -375, SpringLayout.SOUTH, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.EAST, columnsPanel, -10, SpringLayout.EAST, ShowPanel);
		ShowPanel.add(columnsPanel);
		SpringLayout sl_columnsPanel = new SpringLayout();
		columnsPanel.setLayout(sl_columnsPanel);

		JLabel productLabel = new JLabel("\uC0C1\uD488 \uC774\uB984");
		sl_columnsPanel.putConstraint(SpringLayout.NORTH, productLabel, 0, SpringLayout.NORTH, columnsPanel);
		sl_columnsPanel.putConstraint(SpringLayout.WEST, productLabel, 0, SpringLayout.WEST, columnsPanel);
		sl_columnsPanel.putConstraint(SpringLayout.SOUTH, productLabel, 55, SpringLayout.NORTH, columnsPanel);
		productLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 30));
		productLabel.setBackground(Color.WHITE);
		productLabel.setHorizontalAlignment(SwingConstants.CENTER);
		columnsPanel.add(productLabel);

		JLabel amountLabel = new JLabel("\uC218\uB7C9");
		sl_columnsPanel.putConstraint(SpringLayout.WEST, amountLabel, 248, SpringLayout.WEST, columnsPanel);
		sl_columnsPanel.putConstraint(SpringLayout.EAST, productLabel, 0, SpringLayout.WEST, amountLabel);
		sl_columnsPanel.putConstraint(SpringLayout.NORTH, amountLabel, 0, SpringLayout.NORTH, columnsPanel);
		sl_columnsPanel.putConstraint(SpringLayout.SOUTH, amountLabel, 55, SpringLayout.NORTH, columnsPanel);
		sl_columnsPanel.putConstraint(SpringLayout.EAST, amountLabel, 312, SpringLayout.WEST, columnsPanel);
		amountLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 30));
		amountLabel.setBackground(Color.WHITE);
		amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		columnsPanel.add(amountLabel);

		JLabel PriceLabel = new JLabel("\uAC00\uACA9");
		sl_columnsPanel.putConstraint(SpringLayout.NORTH, PriceLabel, 0, SpringLayout.NORTH, columnsPanel);
		sl_columnsPanel.putConstraint(SpringLayout.WEST, PriceLabel, 313, SpringLayout.WEST, columnsPanel);
		sl_columnsPanel.putConstraint(SpringLayout.SOUTH, PriceLabel, 55, SpringLayout.NORTH, columnsPanel);
		sl_columnsPanel.putConstraint(SpringLayout.EAST, PriceLabel, 427, SpringLayout.WEST, columnsPanel);
		PriceLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 30));
		PriceLabel.setBackground(Color.WHITE);
		PriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		columnsPanel.add(PriceLabel);

		JPanel totalMoneyPanel = new JPanel();
		sl_leftPanel.putConstraint(SpringLayout.NORTH, totalMoneyPanel, 496, SpringLayout.NORTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, totalMoneyPanel, 0, SpringLayout.EAST, ShowPanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, ShowPanel, -6, SpringLayout.NORTH, totalMoneyPanel);

		JPanel ListPanel = new JPanel();
		ListPanel.setBackground(new Color(255, 255, 255, 150));
		ListPanel.setOpaque(false);
		sl_ShowPanel.putConstraint(SpringLayout.NORTH, ListPanel, 0, SpringLayout.SOUTH, columnsPanel);
		sl_ShowPanel.putConstraint(SpringLayout.WEST, ListPanel, 10, SpringLayout.WEST, ShowPanel);
		sl_ShowPanel.putConstraint(SpringLayout.SOUTH, ListPanel, 365, SpringLayout.SOUTH, columnsPanel);
		sl_ShowPanel.putConstraint(SpringLayout.EAST, ListPanel, 0, SpringLayout.EAST, columnsPanel);
		ShowPanel.add(ListPanel);
		SpringLayout sl_ListPanel = new SpringLayout();
		ListPanel.setLayout(sl_ListPanel);

		// for (int i = 0; i < breadList.size(); i++) {
		// JCheckBox checkBox = new JCheckBox("¼±ÅÃ");
		// checkBox.setBackground(new Color(255, 255, 255, 150));
		// checkBox.setOpaque(false);
		// choicePanel.add(checkBox);
		// }

		productPanel = new JPanel();
		sl_ListPanel.putConstraint(SpringLayout.NORTH, productPanel, 0, SpringLayout.NORTH, ListPanel);
		sl_ListPanel.putConstraint(SpringLayout.WEST, productPanel, 0, SpringLayout.WEST, ListPanel);
		sl_ListPanel.putConstraint(SpringLayout.SOUTH, productPanel, 0, SpringLayout.SOUTH, ListPanel);
		productPanel.setBackground(new Color(255, 255, 255, 150));
		productPanel.setOpaque(false);
		FlowLayout flowLayout = (FlowLayout) productPanel.getLayout();
		flowLayout.setHgap(70);
		flowLayout.setVgap(10);
		ListPanel.add(productPanel);

		amountPanel = new JPanel();
		sl_ListPanel.putConstraint(SpringLayout.WEST, amountPanel, 248, SpringLayout.WEST, ListPanel);
		sl_ListPanel.putConstraint(SpringLayout.EAST, productPanel, 0, SpringLayout.WEST, amountPanel);
		amountPanel.setBackground(new Color(255, 255, 255, 150));
		amountPanel.setOpaque(false);
		FlowLayout flowLayout_1 = (FlowLayout) amountPanel.getLayout();
		flowLayout_1.setHgap(30);
		flowLayout_1.setVgap(10);
		sl_ListPanel.putConstraint(SpringLayout.NORTH, amountPanel, 0, SpringLayout.NORTH, ListPanel);
		sl_ListPanel.putConstraint(SpringLayout.SOUTH, amountPanel, 0, SpringLayout.SOUTH, ListPanel);
		sl_ListPanel.putConstraint(SpringLayout.EAST, amountPanel, 312, SpringLayout.WEST, ListPanel);
		ListPanel.add(amountPanel);

		pricePanel = new JPanel();
		pricePanel.setBackground(new Color(255, 255, 255, 150));
		pricePanel.setOpaque(false);
		FlowLayout flowLayout_2 = (FlowLayout) pricePanel.getLayout();
		flowLayout_2.setVgap(10);
		flowLayout_2.setHgap(40);
		sl_ListPanel.putConstraint(SpringLayout.NORTH, pricePanel, 0, SpringLayout.NORTH, ListPanel);
		sl_ListPanel.putConstraint(SpringLayout.WEST, pricePanel, 0, SpringLayout.EAST, amountPanel);
		sl_ListPanel.putConstraint(SpringLayout.SOUTH, pricePanel, 0, SpringLayout.SOUTH, ListPanel);
		sl_ListPanel.putConstraint(SpringLayout.EAST, pricePanel, 0, SpringLayout.EAST, ListPanel);
		ListPanel.add(pricePanel);
		totalMoneyPanel.setOpaque(false);
		sl_leftPanel.putConstraint(SpringLayout.WEST, totalMoneyPanel, 181, SpringLayout.WEST, leftPanel);
		leftPanel.add(totalMoneyPanel);
		SpringLayout sl_totalMoneyPanel = new SpringLayout();
		totalMoneyPanel.setLayout(sl_totalMoneyPanel);

//		listM.choice(choicePanel, productPanel, amountPanel, pricePanel, breadList);
		
//		priceTable = new JTable();
//		priceTable.setBackground(Color.WHITE);
//		priceTable.setBorder(new EmptyBorder(0, 0, 0, 0));
//		priceTable.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.PLAIN, 25));
//		pricePanel.add(priceTable);
//		
//		amountTable = new JTable();
//		amountTable.setBackground(Color.WHITE);
//		amountTable.setBorder(new EmptyBorder(0, 0, 0, 0));
//		amountTable.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.PLAIN, 25));
//		amountPanel.add(amountTable);
//		
//		DefaultTableModel model = new DefaultTableModel();
//		
//		Vector column = new Vector<>();
//		column.add("");
//		
//		Vector row = new Vector<>();
//		Vector data = new Vector<>();
//		
//		for (int i = 0; i < breadList.size(); i++) {
//			row.add(breadList.get(i).getPname());
//			data.add(row);
//		}
//		
//		model.setDataVector(data, column);
//		
//		productTable = new JTable(model);
//		productTable.setBackground(Color.WHITE);
//		productTable.setBorder(new EmptyBorder(0, 0, 0, 0));
//		productTable.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.PLAIN, 25));
//		productPanel.add(productTable);
//		
//		choiceTable = new JTable();
//		choiceTable.setBackground(Color.WHITE);
//		choiceTable.setOpaque(false);
//		choiceTable.setBorder(new EmptyBorder(0, 0, 0, 0));
//		choiceTable.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.PLAIN, 25));
//		choicePanel.add(choiceTable);!!

		// tab.tabbed(productPanel, "white");
		//
		// int num = breadList.size();
		// for (int i = 0; i < num; i++) {
		// if(num % 2 == 0) {
		// tab.tabbed(productPanel, "white");
		// } else {
		// tab.tabbed(productPanel, "rye");
		// }
		// }

		JLabel lblNewLabel_1 = new JLabel("\uCD1D \uACB0\uC81C \uAE08\uC561 :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		sl_totalMoneyPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, 49, SpringLayout.NORTH, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 0, SpringLayout.NORTH, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 128, SpringLayout.WEST, totalMoneyPanel);
		totalMoneyPanel.add(lblNewLabel_1);

		lblNewLabel = new JLabel();
		sl_totalMoneyPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -40, SpringLayout.EAST, totalMoneyPanel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		sl_totalMoneyPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		sl_totalMoneyPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 0, SpringLayout.SOUTH, totalMoneyPanel);
		totalMoneyPanel.add(lblNewLabel);
		
		listM.choice(productPanel, amountPanel, pricePanel, breadList);

		JPanel paymentPanel = new JPanel();
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, totalMoneyPanel, -20, SpringLayout.NORTH, paymentPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, paymentPanel, 0, SpringLayout.EAST, ShowPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, paymentPanel, 0, SpringLayout.WEST, totalMoneyPanel);
		sl_leftPanel.putConstraint(SpringLayout.NORTH, paymentPanel, 565, SpringLayout.NORTH, leftPanel);

		JLabel lblNewLabel_2 = new JLabel("\uC6D0");
		sl_totalMoneyPanel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, totalMoneyPanel);
		lblNewLabel_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		sl_totalMoneyPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, totalMoneyPanel);
		sl_totalMoneyPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, totalMoneyPanel);
		totalMoneyPanel.add(lblNewLabel_2);
		paymentPanel.setOpaque(false);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, paymentPanel, -10, SpringLayout.SOUTH, leftPanel);
		leftPanel.add(paymentPanel);
		paymentPanel.setLayout(new GridLayout(1, 2, 20, 0));

		JButton cancelBtn = new JButton(new ImageIcon("./image/ButtonFolder/Ãë¼Ò.png"));
		paymentPanel.add(cancelBtn);
		cancelBtn.setOpaque(false);
		cancelBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
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
				mg.deleteProduct();
				main(office_num);
				new MainGUI(office_num);
			}
		});
		cancelBtn.setBackground(new Color(139, 0, 0));

		paymentBtn = new JButton(new ImageIcon("./image/ButtonFolder/°áÁ¦°áÁ¦.png"));
		paymentBtn.setOpaque(false);
		paymentBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		paymentPanel.add(paymentBtn);
		paymentBtn.setFont(new Font("±¼¸²", Font.BOLD, 15));
		paymentBtn.setForeground(new Color(240, 248, 255));

		paymentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paymentBtn.setBackground(Color.orange);
				PaymentGUI paymentGUI = new PaymentGUI(breadList);
				PaymentGUI.main(null);
				
				

//				paymentGUI.frame.setVisible(true);
//				paymentGUI.setOnMyClickListener(new MyCllickListener() {
//
//					@Override
//					public void onClick() {
//						paymentBtn.setBackground(new Color(139, 0, 0));
//
//					}
//				});
			}
		});
		paymentBtn.setBackground(new Color(139, 0, 0));

		JPanel logopanel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					bimg = ImageIO.read(new File("./image/logo.png"));
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
		sl_leftPanel.putConstraint(SpringLayout.NORTH, logopanel, 29, SpringLayout.SOUTH, ShowPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, logopanel, 10, SpringLayout.WEST, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, logopanel, -34, SpringLayout.SOUTH, leftPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, logopanel, -21, SpringLayout.WEST, totalMoneyPanel);
		leftPanel.add(logopanel);
		logopanel.setLayout(new SpringLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255, 150));
		sl_leftPanel.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, ShowPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, ShowPanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, ShowPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, ShowPanel);
		leftPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		sl_leftPanel.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, ShowPanel);
		sl_leftPanel.putConstraint(SpringLayout.WEST, panel_1, 21, SpringLayout.EAST, logopanel);
		sl_leftPanel.putConstraint(SpringLayout.SOUTH, panel_1, -20, SpringLayout.NORTH, paymentPanel);
		sl_leftPanel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, ShowPanel);
		panel_1.setBackground(new Color(255, 255, 255, 150));
		leftPanel.add(panel_1);

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

		managementBtn = new JButton(new ImageIcon("./image/ButtonFolder/°ü¸®ÁøÂ¥.png"));
		managementBtn.setOpaque(false);
		managementBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		managementBtn.setForeground(new Color(240, 248, 255));
		managementBtn.setFont(new Font("±¼¸²", Font.BOLD, 15));
		managementBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managementBtn.setBackground(Color.orange);
				ManagementGUI managementGUI = new ManagementGUI();
				managementGUI.sendOfficeNum(office_num);
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

		salesBtn = new JButton(new ImageIcon("./image/ButtonFolder/¸ÅÃâÁøÂ¥.png"));
		salesBtn.setOpaque(false);
		salesBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
		salesBtn.setFont(new Font("±¼¸²", Font.BOLD, 15));
		salesBtn.setForeground(new Color(240, 248, 255));
		salesBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesBtn.setBackground(Color.orange);
				GraphGUI graphGUI = new GraphGUI("");
				graphGUI.main(null);
				/*salesGUI salesGUI = new salesGUI();
				salesGUI.frame.setVisible(true);
				salesGUI.setOnMyClickListener(new MyCllickListener() {
					@Override
					public void onClick() {
						// TODO Auto-generated method stub
						salesBtn.setBackground(new Color(139, 69, 19));
					}
				});*/

			}
		});
		salesBtn.setBackground(new Color(139, 69, 19));
		buttonPanel.add(salesBtn);

		JButton closeBtn = new JButton(new ImageIcon("./image/ButtonFolder/°ü¸®Á¾·á.png"));
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		closeBtn.setOpaque(false);
		closeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
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
		tabbedPanel.setOpaque(false);
		tabbedPanel.setBackground(Color.WHITE);
		sl_rightPanel.putConstraint(SpringLayout.SOUTH, tabbedPanel, -21, SpringLayout.SOUTH, rightPanel);
		tabbedPanel.setOpaque(false);
		tabbedPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		icon = new ImageIcon("BreadPos/image/KakaoTalk_20171018_201408552.jpg");

		sl_rightPanel.putConstraint(SpringLayout.NORTH, tabbedPanel, 6, SpringLayout.SOUTH, buttonPanel);
		sl_rightPanel.putConstraint(SpringLayout.WEST, tabbedPanel, 10, SpringLayout.WEST, rightPanel);
		sl_rightPanel.putConstraint(SpringLayout.EAST, tabbedPanel, 0, SpringLayout.EAST, buttonPanel);
		rightPanel.add(tabbedPanel);
		tabbedPanel.setLayout(new GridLayout(1, 0, 10, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 24));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setOpaque(false);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
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

		whitePanel.setOpaque(false); // º¯È­ ÀÏ¾î³ª´Â°÷

		tabbedPane.addTab("¹Ð°¡·ç»§", null, whitePanel, "¹Ð°¡·ç");
		whitePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(whitePanel, "white");

		JPanel boriPanel = new JPanel() {
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
		boriPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		boriPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("º¸¸®»§", null, boriPanel, "º¸¸®");
		boriPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(boriPanel, "bori");

		JPanel cornPanel = new JPanel() {
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
		cornPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		cornPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("¿Á¼ö¼ö»§", null, cornPanel, "¿Á¼ö¼ö");
		cornPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(cornPanel, "corn");

		JPanel ryePanel = new JPanel() {
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
		ryePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		ryePanel.setBackground(Color.WHITE);
		tabbedPane.addTab("È£¹Ð»§", null, ryePanel, "È£¹Ð");
		ryePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(ryePanel, "rye");

		JPanel mixturePanel = new JPanel() {
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
		mixturePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		mixturePanel.setBackground(Color.WHITE);
		tabbedPane.addTab("È¥ÇÕ»§", null, mixturePanel, "È¥ÇÕ");
		mixturePanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(mixturePanel, "mix");

		JPanel otherPanel = new JPanel() {
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
		otherPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		otherPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("±âÅ¸", null, otherPanel, "±âÅ¸");
		otherPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 15, 15));
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		tab.tabbed(otherPanel, "other");
	}

	public static void sendMessage(Bread list) {
		Product pro = new Product(list.getName(), 1, list.getPrice());
		mg.addProduct(pro);

		//listM.choice(choicePanel, productPanel, amountPanel, pricePanel, breadList);

		// System.out.println(list.getName());
		// System.out.println(vector.size());
		main(office_num);
		frame.dispose();
		new MainGUI(office_num);
	}

	public static void sendlist(int total) {
		System.out.println(total);
		lblNewLabel.setText("" + total);
	}
}