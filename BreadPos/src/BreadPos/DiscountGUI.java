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
		
		JButton card = new JButton(new ImageIcon("./image/Åë½Å»çÇÒÀÎ.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, card, 19, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, card, -241, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, card, -46, SpringLayout.EAST, panel);
		card.setBorderPainted(false);
		card.setFocusPainted(false);
		card.setOpaque(false);


		card.setBackground(new Color(128, 0, 0));
		card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//¾×¼Ç
				num = 1;
			}
		});
		panel.add(card);
		
		JButton memebrship = new JButton(new ImageIcon("./image/ButtonFolder/¸â¹öÇÒÀÎ.png"));
		sl_panel.putConstraint(SpringLayout.NORTH, memebrship, 19, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, memebrship, -241, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, memebrship, -246, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, card, 39, SpringLayout.EAST, memebrship);
		sl_panel.putConstraint(SpringLayout.WEST, memebrship, 38, SpringLayout.WEST, panel);
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
		panel.add(memebrship);
		
		JButton dispose = new JButton("\uC885\uB8CC");
		sl_panel.putConstraint(SpringLayout.NORTH, dispose, 250, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, dispose, 163, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, dispose, -10, SpringLayout.SOUTH, panel);
		dispose.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		dispose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//Á¾·á
			frame.dispose();
			}
		});
		dispose.setBackground(new Color(128, 0, 0));
		dispose.setForeground(Color.WHITE);
		panel.add(dispose);
		
		JButton discount = new JButton("\uD560\uC778 \uC801\uC6A9");
		sl_panel.putConstraint(SpringLayout.NORTH, discount, 186, SpringLayout.SOUTH, card);
		sl_panel.putConstraint(SpringLayout.SOUTH, discount, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, discount, -46, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, dispose, -6, SpringLayout.WEST, discount);
		discount.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		discount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ÇÒÀÎ·ü Àû¿ë ¼ö½ÄÇÊ¿ä
				PaymentGUI.chaingeMsg(input);
				
				frame.dispose();
			}
		});
		discount.setForeground(new Color(255, 255, 255));
		discount.setBackground(new Color(128, 0, 0));
		
		panel.add(discount);
				
				JPanel changePannel = new JPanel();
				sl_panel.putConstraint(SpringLayout.NORTH, changePannel, 6, SpringLayout.SOUTH, card);
				sl_panel.putConstraint(SpringLayout.WEST, changePannel, 38, SpringLayout.WEST, panel);
				sl_panel.putConstraint(SpringLayout.SOUTH, changePannel, 232, SpringLayout.NORTH, panel);
				panel.add(changePannel);
				changePannel.setLayout(new CardLayout(0, 0));
						
								
						
						JPanel panel_1 = new JPanel();
						sl_panel.putConstraint(SpringLayout.EAST, changePannel, 348, SpringLayout.WEST, panel_1);
						changePannel.add(panel_1, "name_507246894839316");
						sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, memebrship);
						sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, memebrship);
						sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, dispose);
						sl_panel.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, card);
						panel_1.setBackground(new Color(255, 255, 255,20));
						SpringLayout sl_panel_1 = new SpringLayout();
						panel_1.setLayout(sl_panel_1);
						
						JLabel lblNewLabel = new JLabel("\uBC88\uD638 \uC785\uB825 :");
						sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 78, SpringLayout.NORTH, panel_1);
						lblNewLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
						lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
						panel_1.add(lblNewLabel);
						
						JLabel lblNewLabel_1 = new JLabel("\uD560\uC778\uB960 \uC801\uC6A9 :");
						sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, lblNewLabel_1);
						sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, lblNewLabel_1);
						sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel_1);
						sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 118, SpringLayout.NORTH, panel_1);
						sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -10, SpringLayout.SOUTH, panel_1);
						lblNewLabel_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
						lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
						panel_1.add(lblNewLabel_1);
						
						JPanel ouput = new JPanel();
						sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_1, -6, SpringLayout.WEST, ouput);
						sl_panel_1.putConstraint(SpringLayout.NORTH, ouput, 118, SpringLayout.NORTH, panel_1);
						sl_panel_1.putConstraint(SpringLayout.SOUTH, ouput, -10, SpringLayout.SOUTH, panel_1);
						sl_panel_1.putConstraint(SpringLayout.WEST, ouput, 100, SpringLayout.WEST, panel_1);
						sl_panel_1.putConstraint(SpringLayout.EAST, ouput, -10, SpringLayout.EAST, panel_1);
						
						textField = new JTextField();
						sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, textField);
						sl_panel_1.putConstraint(SpringLayout.NORTH, textField, 74, SpringLayout.NORTH, panel_1);
						sl_panel_1.putConstraint(SpringLayout.WEST, textField, 100, SpringLayout.WEST, panel_1);
						sl_panel_1.putConstraint(SpringLayout.SOUTH, textField, -10, SpringLayout.NORTH, ouput);
						sl_panel_1.putConstraint(SpringLayout.EAST, textField, -10, SpringLayout.EAST, panel_1);
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
						panel_1.add(textField);
						textField.setColumns(10);
						
								ouput.setBackground(Color.ORANGE);
								panel_1.add(ouput);
								ouput.setLayout(new CardLayout(0, 0));
								
								JLabel lblNewLabel_2 = new JLabel("");
								ouput.add(lblNewLabel_2, "name_61052184684373");
								
								JPanel panel_3 = new JPanel();
								sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -21, SpringLayout.NORTH, textField);
								sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, -25, SpringLayout.EAST, panel_1);
								sl_panel.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, textField);
								sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, card);
								sl_panel.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, memebrship);
								sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, -196, SpringLayout.SOUTH, panel);
								panel_1.add(panel_3);
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
									}
								});
								panel_3.add(btnNewButton_1);
	}
}
