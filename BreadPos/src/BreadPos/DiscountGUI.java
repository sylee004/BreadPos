package BreadPos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import DB.MemberInfoDAO;

import java.awt.GridLayout;
import java.awt.CardLayout;

public class DiscountGUI {

	private JFrame frame;
	private BufferedImage icon;
	private int num = 0;
	private String getInfo;
	public Management manage;
	public int discountPer;
	public int input;
	public String msg;
	private JTextField inputMemberNumber;
	private static JLabel showdiscount;
	private static JPanel basicpannel;
	private static JPanel memberpanel;
	private static JPanel phonepanel;
	private int choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiscountGUI window = new DiscountGUI();
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
	public DiscountGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("image/background.png"));
					Dimension d = getSize();// ÀüÃ¼È­¸é
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel.setOpaque(false);
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 305, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 432, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton phone = new JButton(new ImageIcon("./image/Åë½Å»çÇÒÀÎ.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, phone, 19, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, phone, -241, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, phone, -46, SpringLayout.EAST, panel);
		phone.setBorderPainted(false);
		phone.setFocusPainted(false);
		phone.setOpaque(false);

		phone.setBackground(new Color(128, 0, 0));
		phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ¾×¼Ç
				memberpanel.setVisible(false);
				phonepanel.setVisible(true);
				basicpannel.setVisible(false);
				num = 1;

			}
		});
		panel.add(phone);

		JButton memebrship = new JButton(new ImageIcon("./image/ButtonFolder/¸â¹öÇÒÀÎ.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, memebrship, 19, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, memebrship, -241, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, memebrship, -246, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, phone, 39, SpringLayout.EAST, memebrship);
		sl_panel.putConstraint(SpringLayout.WEST, memebrship, 38, SpringLayout.WEST, panel);
		memebrship.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		memebrship.setForeground(new Color(255, 255, 255));
		memebrship.setBackground(new Color(255, 255, 255, 100));
		memebrship.setBorderPainted(false);
		memebrship.setFocusPainted(false);
		memebrship.setOpaque(false);
		memebrship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ¾×¼Ç
				phonepanel.setVisible(false);
				memberpanel.setVisible(true);
				basicpannel.setVisible(false);
				num = 2;
			}
		});
		panel.add(memebrship);

	
		JButton dispose = new JButton(new ImageIcon("./image/ButtonFolder/ÇÒÀÎÁ¾·á.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, dispose, 250, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, dispose, 163, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, dispose, -10, SpringLayout.SOUTH, panel);
		dispose.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		dispose.setOpaque(false);
		dispose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// Á¾·á
				frame.dispose();
			}
		});
		dispose.setBackground(new Color(128, 0, 0));
		dispose.setForeground(Color.WHITE);
		panel.add(dispose);

		JButton discount = new JButton("\uD560\uC778 \uC801\uC6A9");
		sl_panel.putConstraint(SpringLayout.NORTH, discount, 186, SpringLayout.SOUTH, phone);
		sl_panel.putConstraint(SpringLayout.SOUTH, discount, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, discount, -46, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, dispose, -6, SpringLayout.WEST, discount);
		discount.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		discount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ÇÒÀÎ·ü Àû¿ë ¼ö½ÄÇÊ¿ä
				if (choice == 1) {
					PaymentGUI.chaingeMsg(input);
				}else if (choice == 2) {
					PaymentGUI.memberMsg(input);
					
				}
				

				frame.dispose();
			}
		});
		discount.setForeground(new Color(255, 255, 255));
		discount.setBackground(new Color(128, 0, 0));

		panel.add(discount);

		JPanel changePannel = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, changePannel, 6, SpringLayout.SOUTH, phone);
		sl_panel.putConstraint(SpringLayout.WEST, changePannel, 38, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, changePannel, 232, SpringLayout.NORTH, panel);
		panel.add(changePannel);
		changePannel.setLayout(new CardLayout(0, 0));

		phonepanel = new JPanel();
		sl_panel.putConstraint(SpringLayout.EAST, changePannel, 348, SpringLayout.WEST, phonepanel);
		changePannel.add(phonepanel, "name_507246894839316");
		sl_panel.putConstraint(SpringLayout.NORTH, phonepanel, 6, SpringLayout.SOUTH, memebrship);
		sl_panel.putConstraint(SpringLayout.WEST, phonepanel, 0, SpringLayout.WEST, memebrship);
		sl_panel.putConstraint(SpringLayout.SOUTH, phonepanel, -6, SpringLayout.NORTH, dispose);
		sl_panel.putConstraint(SpringLayout.EAST, phonepanel, 0, SpringLayout.EAST, phone);
		phonepanel.setBackground(new Color(255, 255, 255, 0));
		SpringLayout sl_phonepanel = new SpringLayout();
		phonepanel.setLayout(sl_phonepanel);
		phonepanel.setVisible(false);
		phonepanel.setOpaque(false);

		JLabel lblNewLabel_1 = new JLabel("\uD560\uC778\uB960 \uC801\uC6A9 :");
		sl_phonepanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 91, SpringLayout.NORTH, phonepanel);
		sl_phonepanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, phonepanel);
		sl_phonepanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -22, SpringLayout.SOUTH, phonepanel);
		lblNewLabel_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		phonepanel.add(lblNewLabel_1);

		JPanel ouput = new JPanel();
		sl_phonepanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -6, SpringLayout.WEST, ouput);
		sl_phonepanel.putConstraint(SpringLayout.NORTH, ouput, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_phonepanel.putConstraint(SpringLayout.WEST, ouput, 100, SpringLayout.WEST, phonepanel);
		sl_phonepanel.putConstraint(SpringLayout.EAST, ouput, -10, SpringLayout.EAST, phonepanel);
		sl_phonepanel.putConstraint(SpringLayout.SOUTH, ouput, -25, SpringLayout.SOUTH, phonepanel);

		ouput.setBackground(Color.ORANGE);
		phonepanel.add(ouput);
		ouput.setLayout(new CardLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		ouput.add(lblNewLabel_2, "name_61052184684373");

		JPanel panel_3 = new JPanel();
		sl_phonepanel.putConstraint(SpringLayout.NORTH, panel_3, 14, SpringLayout.NORTH, phonepanel);
		sl_phonepanel.putConstraint(SpringLayout.SOUTH, panel_3, -27, SpringLayout.NORTH, lblNewLabel_1);
		sl_phonepanel.putConstraint(SpringLayout.EAST, panel_3, -25, SpringLayout.EAST, phonepanel);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, phone);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, memebrship);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, -196, SpringLayout.SOUTH, panel);
		phonepanel.add(panel_3);
		panel_3.setOpaque(false);
		panel_3.setLayout(new GridLayout(0, 3, 10, 0));

		JButton btnNewButton = new JButton("SKT");
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_2.setText("10% ÇÒÀÎ");
				input = 1;
				choice = 1;
			}
		});
		panel_3.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("KT");
		btnNewButton_2.setBackground(new Color(178, 34, 34));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("7% ÇÒÀÎ");
				input = 3;
				choice = 1;
			}
		});
		panel_3.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("LG U+");
		btnNewButton_1.setBackground(new Color(178, 34, 34));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("5% ÇÒÀÎ");
				input = 2;
				choice = 1;
			}
		});
		panel_3.add(btnNewButton_1);

		memberpanel = new JPanel();
		memberpanel.setBackground(Color.WHITE);
		changePannel.add(memberpanel, "name_147043956309760");
		SpringLayout sl_memberpanel = new SpringLayout();
		memberpanel.setLayout(sl_memberpanel);
		memberpanel.setVisible(false);
		memberpanel.setOpaque(false);

		JLabel lblNewLabel_3 = new JLabel("\uBC88\uD638 \uC785\uB825");
		sl_memberpanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, memberpanel);
		sl_memberpanel.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, memberpanel);
		sl_memberpanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -112, SpringLayout.SOUTH, memberpanel);
		sl_memberpanel.putConstraint(SpringLayout.EAST, lblNewLabel_3, -257, SpringLayout.EAST, memberpanel);
		lblNewLabel_3.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		memberpanel.add(lblNewLabel_3);

		JLabel label = new JLabel("\uD560\uC778\uB960 \uC801\uC6A9");
		sl_memberpanel.putConstraint(SpringLayout.NORTH, label, 18, SpringLayout.SOUTH, lblNewLabel_3);
		sl_memberpanel.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblNewLabel_3);
		sl_memberpanel.putConstraint(SpringLayout.SOUTH, label, -54, SpringLayout.SOUTH, memberpanel);
		sl_memberpanel.putConstraint(SpringLayout.EAST, label, -257, SpringLayout.EAST, memberpanel);
		label.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		memberpanel.add(label);

		inputMemberNumber = new JTextField();
		sl_memberpanel.putConstraint(SpringLayout.NORTH, inputMemberNumber, 15, SpringLayout.NORTH, memberpanel);
		sl_memberpanel.putConstraint(SpringLayout.WEST, inputMemberNumber, 97, SpringLayout.WEST, memberpanel);
		sl_memberpanel.putConstraint(SpringLayout.EAST, inputMemberNumber, -22, SpringLayout.EAST, memberpanel);
		memberpanel.add(inputMemberNumber);
		inputMemberNumber.setColumns(10);
		MemberInfoDAO memberInfoDAO = new MemberInfoDAO();
		

		JPanel panel_4 = new JPanel();
		sl_memberpanel.putConstraint(SpringLayout.SOUTH, inputMemberNumber, -13, SpringLayout.NORTH, panel_4);
		sl_memberpanel.putConstraint(SpringLayout.NORTH, panel_4, 0, SpringLayout.NORTH, label);
		sl_memberpanel.putConstraint(SpringLayout.WEST, panel_4, 97, SpringLayout.WEST, memberpanel);
		sl_memberpanel.putConstraint(SpringLayout.SOUTH, panel_4, -54, SpringLayout.SOUTH, memberpanel);
		sl_memberpanel.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, inputMemberNumber);
		panel_4.setBackground(Color.ORANGE);
		memberpanel.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));

		showdiscount = new JLabel("");
		panel_4.add(showdiscount, "name_147293203139413");
		
		JButton btnNewButton_3 = new JButton("\uD655\uC778");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				choice = 2;
				String nember = "1234";
				//memberInfoDAO.selectMoney(member_phone);
				if (inputMemberNumber.getText().equals(nember)) {
					showdiscount.setText("È¸¿ø ÀÌ½Ã³×¿ä?");
					input = 1;
					
				}else {
					showdiscount.setText("È¸¿øÀÌ ¾Æ´Ï½Ã³×¿ä ¤Ð¤Ð");
					input = 2;
				}
			}
		});
		btnNewButton_3.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		sl_memberpanel.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -10, SpringLayout.SOUTH, memberpanel);
		sl_memberpanel.putConstraint(SpringLayout.EAST, btnNewButton_3, -38, SpringLayout.EAST, memberpanel);
		memberpanel.add(btnNewButton_3);

		basicpannel = new JPanel();
		basicpannel.setBackground(new Color(0, 0, 0, 0));
		changePannel.add(basicpannel, "name_148531420944640");
		basicpannel.setLayout(new CardLayout(0, 0));
		basicpannel.setVisible(true);
		basicpannel.setOpaque(false);

		JLabel lblNewLabel_5 = new JLabel("\uD560\uC778\uC744 \uC120\uD0DD\uD558\uC138\uC694");
		lblNewLabel_5.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 40));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		basicpannel.add(lblNewLabel_5, "name_148547396863573");
	}
}
