package BreadPos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import DB.Product;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class PaymentGUI {

	public JFrame frame;
	private BufferedImage icon;
	private MyCllickListener myCllickListener;
	private static Management management;
	public DiscountGUI discountGUI;
	private static JLabel lblNewLabel_4;
	private static JLabel lblNewLabel_5;
	private static JLabel lblNewLabel_7;
	public static ArrayList<Integer> moneylist;
	public static int[] money;
	private static ArrayList<Product> productList;
	private List listM;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentGUI window = new PaymentGUI(productList);
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
	public PaymentGUI(ArrayList<Product> productList) {
		this.productList = productList;
		management = new Management();
		moneylist = new ArrayList<>();
		listM = new List();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);

		frame.setBounds(100, 100, 438, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel_5 = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/background.png"));
					Dimension d = getSize();// ÀüÃ¼È­¸é
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					setBackground(new Color(0, 0, 0, 0));
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel_5.setOpaque(false);
		panel_5.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, panel_5, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_5, 0, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(panel_5);
		SpringLayout sl_panel_5 = new SpringLayout();
		panel_5.setLayout(sl_panel_5);

		JPanel panel_9 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel_9, 10, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel_9, 10, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel_9, 48, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel_9, -10, SpringLayout.EAST, panel_5);
		springLayout.putConstraint(SpringLayout.NORTH, panel_9, 10, SpringLayout.NORTH, panel_5);
		springLayout.putConstraint(SpringLayout.WEST, panel_9, 10, SpringLayout.WEST, panel_5);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_9, 48, SpringLayout.SOUTH, panel_5);
		springLayout.putConstraint(SpringLayout.EAST, panel_9, -10, SpringLayout.EAST, panel_5);
		panel_5.add(panel_9);
		panel_9.setOpaque(false);
		panel_9.setBackground(Color.WHITE);
		SpringLayout sl_panel_9 = new SpringLayout();
		panel_9.setLayout(sl_panel_9);

		JLabel lblNewLabel_8 = new JLabel("\uC0C1\uD488 \uC774\uB984");
		sl_panel_9.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 0, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.WEST, lblNewLabel_8, 0, SpringLayout.WEST, panel_9);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, lblNewLabel_8, 38, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, lblNewLabel_8, 200, SpringLayout.WEST, panel_9);
		panel_9.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));

		JLabel lblNewLabel_9 = new JLabel("\uC218\uB7C9");
		sl_panel_9.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 0, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.WEST, lblNewLabel_9, 0, SpringLayout.EAST, lblNewLabel_8);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, 38, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, lblNewLabel_9, 300, SpringLayout.WEST, panel_9);
		panel_9.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_10 = new JLabel("\uAC00\uACA9");
		sl_panel_9.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 0, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.WEST, lblNewLabel_10, 0, SpringLayout.EAST, lblNewLabel_9);
		sl_panel_9.putConstraint(SpringLayout.SOUTH, lblNewLabel_10, 38, SpringLayout.NORTH, panel_9);
		sl_panel_9.putConstraint(SpringLayout.EAST, lblNewLabel_10, 402, SpringLayout.WEST, panel_9);
		panel_9.add(lblNewLabel_10);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));

		JPanel panel = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.SOUTH, panel_9);
		panel.setOpaque(false);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel, 270, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, panel_5);

		panel_5.add(panel);
		panel.setBackground(Color.WHITE);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JPanel panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_6.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_6, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_6, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_6, 200, SpringLayout.WEST, panel);
		panel.add(panel_6);
		SpringLayout sl_panel_6 = new SpringLayout();
		panel_6.setLayout(sl_panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_7, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_7, 200, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_7, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_7, 300, SpringLayout.WEST, panel);
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(8, 0, 0, 0));

		JPanel panel_8 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_8, 100, SpringLayout.EAST, panel_6);
		sl_panel.putConstraint(SpringLayout.EAST, panel_8, 0, SpringLayout.EAST, panel);
		panel_8.setOpaque(false);
		panel_8.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_8, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_8, 0, SpringLayout.SOUTH, panel);
		panel.add(panel_8);
		panel_8.setLayout(new GridLayout(8, 0, 0, 0));
		
		listM.choice(panel_6, panel_7, panel_8, productList);
		
		JPanel panel_10 = new JPanel();
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel_10, 0, SpringLayout.NORTH, panel_9);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel_10, 0, SpringLayout.WEST, panel_9);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel_10, 0, SpringLayout.SOUTH, panel);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel_10, 0, SpringLayout.EAST, panel_9);
		panel_10.setBackground(new Color(255, 255, 255, 150));
		panel_5.add(panel_10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel_1, 280, SpringLayout.NORTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel_5);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, panel_5);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel_1, 170, SpringLayout.WEST, panel_5);

		panel_5.add(panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_1);
		panel_1.setOpaque(false);

		// panel.add(table);

		panel_1.setLayout(new GridLayout(4, 0, 0, 10));

		JButton btnNewButton_1 = new JButton(new ImageIcon("./image/ButtonFolder/°áÁ¦ÇÒÀÎ.png"));
		btnNewButton_1.setBackground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DiscountGUI discountGUI = new DiscountGUI();
				discountGUI.main(null);
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton(new ImageIcon("./image/ButtonFolder/°áÁ¦Çö±Ý.png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBackground(new Color(128, 0, 0));
		btnNewButton_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton(new ImageIcon("./image/ButtonFolder/°áÁ¦Ä«µå.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBackground(new Color(128, 0, 0));
		btnNewButton_3.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFocusPainted(false);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton = new JButton(new ImageIcon("./image/ButtonFolder/°áÁ¦±âÇÁÆ¼ÄÜ.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		panel_1.add(btnNewButton);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		sl_panel_5.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel_1);
		sl_panel_5.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.EAST, panel_1);
		sl_panel_5.putConstraint(SpringLayout.SOUTH, panel_2, 0, SpringLayout.SOUTH, panel_1);
		sl_panel_5.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel_5);
		panel_5.add(panel_2);
		panel_2.setOpaque(false);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBackground(Color.WHITE);
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_3, -54, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_3, -10, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_3, 224, SpringLayout.WEST, panel_2);

		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 10, 0));

		JButton btnNewButton_5 = new JButton(new ImageIcon("./image/ButtonFolder/°áÁ¦ÀÌÀü.png"));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setOpaque(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setFocusPainted(false);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// myCllickListener.onClick();
				frame.dispose();
			}
		});

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton(new ImageIcon("./image/ButtonFolder/°áÁ¦°áÁ¦.png"));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				management.deleteProduct();
				MainGUI mainGUI = new MainGUI(1);
				mainGUI.main(1);
				zPopCardCompleteGUI cardCompleteGUI = new zPopCardCompleteGUI();
				cardCompleteGUI.main(null);
				frame.dispose();
				
				
			}
		});
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setFocusPainted(false);
		panel_3.add(btnNewButton_4);

		JPanel panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_4.setBackground(Color.WHITE);
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_4, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_4, -24, SpringLayout.NORTH, panel_3);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_4, -10, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_4);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("\uB0B4\uC5ED");
		lblNewLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(139, 69, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\uAE08\uC561");
		lblNewLabel_2.setOpaque(false);
		lblNewLabel_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_2.setBackground(new Color(139, 69, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("\uACB0\uC81C \uAE08\uC561");
		lblNewLabel_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		int total = 0;

		for (int i = 0; i < productList.size(); i++) {
			total += productList.get(i).getPrice();
		}

		lblNewLabel_4 = new JLabel(); // °áÁ¦ ±Ý¾×
		lblNewLabel_4.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_4);
		moneylist.add(total);
		lblNewLabel_4.setText("" + moneylist.get(0));

		JLabel lblNewLabel_6 = new JLabel("\uD560\uC778\uAE08\uC561");
		lblNewLabel_6.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setBackground(new Color(222, 184, 135));
		lblNewLabel_7.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);

		panel_4.add(lblNewLabel_7);

		JLabel lblNewLabel_3 = new JLabel("\uCD5C\uC885 \uAE08\uC561");
		lblNewLabel_3.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_3);

		lblNewLabel_5 = new JLabel();

		lblNewLabel_5.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255, 150));
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_11, 0, SpringLayout.NORTH, panel_4);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_11, 0, SpringLayout.WEST, panel_4);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_11, 0, SpringLayout.SOUTH, panel_4);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_11, 0, SpringLayout.EAST, panel_4);
		panel_2.add(panel_11);

		Vector userColumn = new Vector<>();
		Vector userRow = new Vector<>();
		Vector data = new Vector<>();

		userColumn.add("»óÇ°ÀÌ¸§");
		userColumn.add("¼ö·®");
		userColumn.add("°¡°Ý");

		data.add("¼Òº¸·Î»§");
		userRow.add("1");
		userRow.add("1200");

		data.add(userRow);
	}

	public void setOnMyClickListener(MyCllickListener myCllickListener) {
		this.myCllickListener = myCllickListener;

	}

	public static void chaingeMsg(int input) {
		Management management = new Management();

		lblNewLabel_7.setText("" + input);
		// TODO Auto-generated method stub
		if (input == 1) {

			money = management.name(moneylist, 10);
			lblNewLabel_4.setText("" + money[0]);
			lblNewLabel_7.setText("" + money[1]);
			lblNewLabel_5.setText("" + money[2]);
		} else if (input == 2) {
			money = management.name(moneylist, 7);
			lblNewLabel_4.setText("" + money[0]);
			lblNewLabel_7.setText("" + money[1]);
			lblNewLabel_5.setText("" + money[2]);
		} else {
			money = management.name(moneylist, 5);
			lblNewLabel_4.setText("" + money[0]);
			lblNewLabel_7.setText("" + money[1]);
			lblNewLabel_5.setText("" + money[2]);
		}

	}

	public static void memberMsg(int input) {
		if (input == 1) {

			money = management.name(moneylist, 10);
			lblNewLabel_4.setText("" + money[0]);
			lblNewLabel_7.setText("" + money[1]);
			lblNewLabel_5.setText("" + money[2]);
		} else if (input == 2) {
			money = management.name(moneylist, 5);
			lblNewLabel_4.setText("" + money[0]);
			lblNewLabel_7.setText("" + money[1]);
			lblNewLabel_5.setText("" + money[2]);
		}

	}

	public static void finalMoney(int input) {
		// TODO Auto-generated method stub

	}
}
