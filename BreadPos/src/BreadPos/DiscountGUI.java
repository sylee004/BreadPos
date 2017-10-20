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
import java.awt.GridLayout;
import java.awt.CardLayout;

public class DiscountGUI {

	private JFrame frame;
	private BufferedImage icon;
	private JTextField textField;
	private int num = 0;
	private String getInfo;
	public Management manage;
	public int discountPer;
	public int input;
	public String msg;

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
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("image/background.png"));
					Dimension d = getSize();// 전체화면
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
		
		JButton card = new JButton(new ImageIcon("./image/통신사할인.png")); //카드 할인
		sl_panel.putConstraint(SpringLayout.WEST, card, 225, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, card, -241, SpringLayout.SOUTH, panel);
		card.setBorderPainted(false);
		card.setFocusPainted(false);
		card.setOpaque(false);


		card.setBackground(new Color(128, 0, 0));
		card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//액션
				num = 1;
			}
		});
		panel.add(card);
		
		JButton memebrship = new JButton(new ImageIcon("./image/멤버할인.png"));
		sl_panel.putConstraint(SpringLayout.WEST, memebrship, 38, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, memebrship, -241, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, memebrship, -39, SpringLayout.WEST, card);
		sl_panel.putConstraint(SpringLayout.NORTH, card, 0, SpringLayout.NORTH, memebrship);
		memebrship.setFont(new Font("나눔손글씨 펜", Font.BOLD, 20));
		memebrship.setForeground(new Color(255, 255, 255));
		memebrship.setBackground(new Color(255,255, 255, 100));
		memebrship.setBorderPainted(false);
		memebrship.setFocusPainted(false);
		memebrship.setOpaque(false);
		memebrship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//액션
				num = 2;
			}
		});
		panel.add(memebrship);
		
				
		
		JPanel panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.EAST, card, 0, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 38, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -46, SpringLayout.EAST, panel);
		panel_1.setBackground(new Color(255, 255, 255,20));
		panel.add(panel_1);
		
		JButton dispose = new JButton("\uC885\uB8CC");
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, dispose);
		sl_panel.putConstraint(SpringLayout.NORTH, dispose, 250, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, dispose, 163, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, dispose, -10, SpringLayout.SOUTH, panel);
		dispose.setFont(new Font("나눔손글씨 펜", Font.BOLD, 20));
		dispose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//종료
			frame.dispose();
			}
		});
		dispose.setBackground(new Color(128, 0, 0));
		dispose.setForeground(Color.WHITE);
		panel.add(dispose);
		
		JButton discount = new JButton("\uD560\uC778 \uC801\uC6A9");
		sl_panel.putConstraint(SpringLayout.NORTH, discount, 6, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, discount, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, discount, -46, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, dispose, -6, SpringLayout.WEST, discount);
		discount.setFont(new Font("나눔손글씨 펜", Font.BOLD, 20));
		discount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//할인률 적용 수식필요
				PaymentGUI.chaingeMsg(input);
				
				frame.dispose();
			}
		});
		discount.setForeground(new Color(255, 255, 255));
		discount.setBackground(new Color(128, 0, 0));
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\uBC88\uD638 \uC785\uB825");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, 56, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, 94, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD560\uC778\uB960 \uC801\uC6A9");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 17, SpringLayout.SOUTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		panel_1.add(lblNewLabel_1);
		
		JPanel ouput = new JPanel();
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 10) { //번호입력
					getInfo = textField.getText();
					//멤버쉽 OR 카드 할인 적용 !!
					discountPer = manage.discount(num, getInfo);
					ouput.setToolTipText(""+discountPer);
				}
			}
		});
		
		
		sl_panel_1.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField, 6, SpringLayout.EAST, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField, 244, SpringLayout.EAST, lblNewLabel);
		panel_1.add(textField);
		textField.setColumns(10);
		
		

		
	
		ouput.setBackground(Color.ORANGE);
		sl_panel_1.putConstraint(SpringLayout.NORTH, ouput, 0, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, ouput, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, ouput, 0, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, ouput, -10, SpringLayout.EAST, panel_1);
		panel_1.add(ouput);
		ouput.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("");
		ouput.add(lblNewLabel_2, "name_61052184684373");
		
		panel.add(discount);
		
		
		
		
		JPanel panel_4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, memebrship, 0, SpringLayout.NORTH, panel_4);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_4, -300, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_4, 19, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_4, 62, SpringLayout.WEST, panel);
		panel.add(panel_4);
		
		JPanel panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, -196, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, card);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, memebrship);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, card);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNewButton = new JButton("SKT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_2.setText("10% 할인");
				input = 1;
			}
		});
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LG U+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("5% 할인");
			input = 2;
			}
		});
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("KT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("7% 할인");
				input = 3;
			}
		});
		panel_3.add(btnNewButton_2);
	}

	
}
