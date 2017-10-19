package BreadPos;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ManagementGUI {

	public JFrame frame;
	private MyCllickListener myCllickListener;
	private int choice;
	private BufferedImage icon;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementGUI window = new ManagementGUI();
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
	public ManagementGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 491, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/background.png"));
					Dimension d = getSize();// 전체화면
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					setBackground(new Color(0, 0, 0, 0));
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel.setOpaque(false);
		frame.getContentPane().add(panel, "name_52178911182620");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel importantPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/background.png"));
					Dimension d = getSize();// 전체화면
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					setBackground(new Color(0, 0, 0, 0));
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		importantPanel.setBackground(new Color(211, 211, 211, 100));
		importantPanel.setForeground(new Color(0, 0, 0));
		sl_panel.putConstraint(SpringLayout.NORTH, importantPanel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, importantPanel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, importantPanel, 354, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, importantPanel, 465, SpringLayout.WEST, panel);
		panel.add(importantPanel);
		
		JPanel ButtonPanel = new JPanel();
		ButtonPanel.setBackground(new Color(255, 255, 255, 100));
		sl_panel.putConstraint(SpringLayout.NORTH, ButtonPanel, 26, SpringLayout.SOUTH, importantPanel);
		sl_panel.putConstraint(SpringLayout.WEST, ButtonPanel, 0, SpringLayout.WEST, importantPanel);
		sl_panel.putConstraint(SpringLayout.SOUTH, ButtonPanel, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, ButtonPanel, 0, SpringLayout.EAST, importantPanel);
		SpringLayout sl_importantPanel = new SpringLayout();
		importantPanel.setLayout(sl_importantPanel);
		
//		JPanel addMenuPanel = new JPanel();
//		addMenuPanel.setBackground(new Color(211, 211, 211, 0));
//		sl_importantPanel.putConstraint(SpringLayout.NORTH, addMenuPanel, 61, SpringLayout.NORTH, importantPanel);
//		sl_importantPanel.putConstraint(SpringLayout.WEST, addMenuPanel, 36, SpringLayout.WEST, importantPanel);
//		sl_importantPanel.putConstraint(SpringLayout.SOUTH, addMenuPanel, 270, SpringLayout.NORTH, importantPanel);
//		sl_importantPanel.putConstraint(SpringLayout.EAST, addMenuPanel, 414, SpringLayout.WEST, importantPanel);
//		importantPanel.add(addMenuPanel);
//		SpringLayout sl_addMenuPanel = new SpringLayout();
//		addMenuPanel.setLayout(sl_addMenuPanel);
//		
//		textField = new JTextField();
//		sl_addMenuPanel.putConstraint(SpringLayout.WEST, textField, 88, SpringLayout.WEST, addMenuPanel);
//		sl_addMenuPanel.putConstraint(SpringLayout.EAST, textField, 0, SpringLayout.EAST, addMenuPanel);
//		addMenuPanel.add(textField);
//		textField.setColumns(10);
//		
//		textField_1 = new JTextField();
//		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, textField, 30, SpringLayout.SOUTH, textField_1);
//		sl_addMenuPanel.putConstraint(SpringLayout.WEST, textField_1, 88, SpringLayout.WEST, addMenuPanel);
//		sl_addMenuPanel.putConstraint(SpringLayout.EAST, textField_1, 0, SpringLayout.EAST, addMenuPanel);
//		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, textField_1, 0, SpringLayout.NORTH, addMenuPanel);
//		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, textField_1, 50, SpringLayout.NORTH, addMenuPanel);
//		addMenuPanel.add(textField_1);
//		textField_1.setColumns(10);
//		
//		textField_2 = new JTextField();
//		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, textField, -29, SpringLayout.NORTH, textField_2);
//		sl_addMenuPanel.putConstraint(SpringLayout.WEST, textField_2, 0, SpringLayout.WEST, textField);
//		sl_addMenuPanel.putConstraint(SpringLayout.EAST, textField_2, 0, SpringLayout.EAST, addMenuPanel);
//		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, textField_2, -50, SpringLayout.SOUTH, addMenuPanel);
//		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, textField_2, 0, SpringLayout.SOUTH, addMenuPanel);
//		addMenuPanel.add(textField_2);
//		textField_2.setColumns(10);
//		
//		JLabel breadName = new JLabel("\uBE75 \uC774\uB984");
//		breadName.setHorizontalAlignment(SwingConstants.CENTER);
//		breadName.setFont(new Font("나눔손글씨 펜", Font.BOLD, 24));
//		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, breadName, 0, SpringLayout.NORTH, textField_1);
//		sl_addMenuPanel.putConstraint(SpringLayout.WEST, breadName, 0, SpringLayout.WEST, addMenuPanel);
//		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, breadName, 0, SpringLayout.SOUTH, textField_1);
//		sl_addMenuPanel.putConstraint(SpringLayout.EAST, breadName, 86, SpringLayout.WEST, addMenuPanel);
//		addMenuPanel.add(breadName);
//		
//		JLabel breadType = new JLabel("\uBE75 \uC885\uB958");
//		breadType.setHorizontalAlignment(SwingConstants.CENTER);
//		breadType.setFont(new Font("나눔손글씨 펜", Font.BOLD, 24));
//		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, breadType, 0, SpringLayout.NORTH, textField);
//		sl_addMenuPanel.putConstraint(SpringLayout.WEST, breadType, 0, SpringLayout.WEST, addMenuPanel);
//		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, breadType, 0, SpringLayout.SOUTH, textField);
//		sl_addMenuPanel.putConstraint(SpringLayout.EAST, breadType, 86, SpringLayout.WEST, addMenuPanel);
//		addMenuPanel.add(breadType);
//		
//		JLabel breadPrice = new JLabel("\uAC00\uACA9");
//		breadPrice.setHorizontalAlignment(SwingConstants.CENTER);
//		breadPrice.setFont(new Font("나눔손글씨 펜", Font.BOLD, 24));
//		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, breadPrice, 0, SpringLayout.NORTH, textField_2);
//		sl_addMenuPanel.putConstraint(SpringLayout.WEST, breadPrice, 0, SpringLayout.WEST, breadName);
//		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, breadPrice, 0, SpringLayout.SOUTH, textField_2);
//		sl_addMenuPanel.putConstraint(SpringLayout.EAST, breadPrice, -6, SpringLayout.WEST, textField_2);
//		addMenuPanel.add(breadPrice);
//		
//		addMenuPanel.setVisible(false);
		
		panel.add(ButtonPanel);
		
		ButtonPanel.setLayout(new GridLayout(2, 3, 10, 10));
		
		//메뉴추가
		JButton addMenu = new JButton("\uBA54\uB274 \uCD94\uAC00");
		addMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //클릭시에 choice 1
				choice = 1;
				addMenu.setBackground(Color.orange);			
				
				System.out.println(choice);
				
//				addMenuPanel.setVisible(true);
				
			}
		});
		addMenu.setFont(new Font("굴림", Font.BOLD, 15));
		addMenu.setForeground(new Color(240, 248, 255));
		addMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(addMenu);
		
		
		
		//메뉴삭제
		JButton deleMenu = new JButton("\uBA54\uB274\uC0AD\uC81C");
		deleMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//클릭시에 choice 2
				choice = 2;
				addMenu.setBackground(Color.orange);
				
				
			}
		});
		
		deleMenu.setFont(new Font("굴림", Font.BOLD, 15));
		deleMenu.setForeground(new Color(240, 248, 255));
		deleMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(deleMenu);
		
		//메뉴변경
		JButton changeMenu = new JButton("\uBA54\uB274\uC218\uC815");
		changeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//클릭시에 choice 3
				choice = 3;
				addMenu.setBackground(Color.orange);
				
			}
		});
		
		changeMenu.setFont(new Font("굴림", Font.BOLD, 15));
		changeMenu.setForeground(new Color(240, 248, 255));
		changeMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(changeMenu);
		
		//지점정보변경
		JButton changeInfo = new JButton("\uC9C0\uC810\uC815\uBCF4\uC218\uC815");
		changeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//클릭시에 choice 4
				choice = 4;
				addMenu.setBackground(Color.orange);
			}
		});
		
		changeInfo.setFont(new Font("굴림", Font.BOLD, 15));
		changeInfo.setForeground(new Color(240, 248, 255));
		changeInfo.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(changeInfo);
		
		//회원관리
		JButton controllMember = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		controllMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//클릭시에 choice 5
			}
		});
		
		controllMember.setFont(new Font("굴림", Font.BOLD, 15));
		controllMember.setForeground(new Color(240, 248, 255));
		controllMember.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(controllMember);
		
		//종료
		JButton close = new JButton("\uB2EB\uAE30");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//클릭시에 choice 6
				//myCllickListener.onClick();
				frame.dispose();
			}
		});
		close.setFont(new Font("굴림", Font.BOLD, 15));
		close.setForeground(new Color(240, 248, 255));
		close.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(close);
	}
	
	public void setOnMyClickListener(MyCllickListener myCllickListener) {
		// TODO Auto-generated method stub
		this.myCllickListener = myCllickListener;
		
	}
	

	

}

	
	



