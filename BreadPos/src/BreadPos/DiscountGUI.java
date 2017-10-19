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

public class DiscountGUI {

	private JFrame frame;
	private BufferedImage icon;
	private JTextField textField;
	private int num = 0;
	private String getInfo;
	private Management manage;
	private int discountPer;

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
		
		JButton card = new JButton(new ImageIcon("./image/Åë½Å»çÇÒÀÎ.png")); //Ä«µå ÇÒÀÎ
		card.setBorderPainted(false);
		card.setFocusPainted(false);
		card.setOpaque(false);


		card.setBackground(new Color(128, 0, 0));
		card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//¾×¼Ç
				num = 1;
			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, card, 35, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, card, 225, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, card, -225, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, card, -46, SpringLayout.EAST, panel);
		panel.add(card);
		
		JButton memebrship = new JButton(new ImageIcon("./image/¸â¹öÇÒÀÎ.png")); //¸â¹ö½± ÇÒÀÎ
		memebrship.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		memebrship.setForeground(new Color(255, 255, 255));
		memebrship.setBackground(new Color(255,255, 255, 100));
		memebrship.setBorderPainted(false);
		memebrship.setFocusPainted(false);
		memebrship.setOpaque(false);
		memebrship.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//¾×¼Ç
				num = 2;
			}
		});
		
		sl_panel.putConstraint(SpringLayout.NORTH, memebrship, 35, SpringLayout.NORTH, panel);
		panel.add(memebrship);
		
				
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255,20));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 20, SpringLayout.SOUTH, card);
		sl_panel.putConstraint(SpringLayout.SOUTH, memebrship, -20, SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 38, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 386, SpringLayout.WEST, panel);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/logo.png"));
					Dimension d = getSize();// ÀüÃ¼È­¸é
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		sl_panel.putConstraint(SpringLayout.WEST, memebrship, -148, SpringLayout.EAST, panel_2);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, panel_2);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 235, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, memebrship, 0, SpringLayout.EAST, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 38, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -25, SpringLayout.SOUTH, panel);
		panel.add(panel_2);
		
		JButton dispose = new JButton("\uC885\uB8CC");
		dispose.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		dispose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//Á¾·á
			frame.dispose();
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, dispose, 190, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -4, SpringLayout.WEST, dispose);
		dispose.setBackground(new Color(128, 0, 0));
		dispose.setForeground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, dispose, 6, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, dispose, -25, SpringLayout.SOUTH, panel);
		panel.add(dispose);
		
		JButton discount = new JButton("\uD560\uC778 \uC801\uC6A9");
		discount.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		discount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ÇÒÀÎ·ü Àû¿ë ¼ö½ÄÇÊ¿ä
				PaymentGUI pay = new PaymentGUI();
				pay.main(null);
				frame.dispose();
			}
		});
		sl_panel.putConstraint(SpringLayout.EAST, discount, -46, SpringLayout.EAST, panel);
		discount.setForeground(new Color(255, 255, 255));
		discount.setBackground(new Color(128, 0, 0));
		sl_panel.putConstraint(SpringLayout.NORTH, discount, 6, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, discount, -25, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, dispose, -6, SpringLayout.WEST, discount);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel = new JLabel("\uBC88\uD638 \uC785\uB825");
		lblNewLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, 56, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, 94, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uD560\uC778\uB960 \uC801\uC6A9");
		lblNewLabel_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
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
				if (e.getKeyCode() == 10) { //¹øÈ£ÀÔ·Â
					getInfo = textField.getText();
					//¸â¹ö½± OR Ä«µå ÇÒÀÎ Àû¿ë !!
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
		panel.add(discount);
		
		
		
		
		JPanel panel_4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_4, 19, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_4, -30, SpringLayout.NORTH, memebrship);
		sl_panel.putConstraint(SpringLayout.EAST, panel_4, 62, SpringLayout.WEST, panel);
		panel.add(panel_4);
	}
}
