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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class LoginGUI {

	private JFrame frame;
	private BufferedImage icon;
	private JTextField IdTxt;
	private JTextField pwTxt;
	private String id = "";
	private String pw = "";
	private int office_num;
	private Management mg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
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
	public LoginGUI() {
		initialize();
		mg = new Management();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 577);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel backgroundPanel = new JPanel() {
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
		springLayout.putConstraint(SpringLayout.NORTH, backgroundPanel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, backgroundPanel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, backgroundPanel, 538, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, backgroundPanel, 434, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(backgroundPanel);
		SpringLayout sl_backgroundPanel = new SpringLayout();
		backgroundPanel.setLayout(sl_backgroundPanel);
		
		JPanel logoPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/logo.png"));
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
		sl_backgroundPanel.putConstraint(SpringLayout.NORTH, logoPanel, -80, SpringLayout.SOUTH, backgroundPanel);
		sl_backgroundPanel.putConstraint(SpringLayout.WEST, logoPanel, -200, SpringLayout.EAST, backgroundPanel);
		sl_backgroundPanel.putConstraint(SpringLayout.SOUTH, logoPanel, -10, SpringLayout.SOUTH, backgroundPanel);
		sl_backgroundPanel.putConstraint(SpringLayout.EAST, logoPanel, -10, SpringLayout.EAST, backgroundPanel);
		backgroundPanel.add(logoPanel);
		
		JPanel LoginPanel = new JPanel();
		sl_backgroundPanel.putConstraint(SpringLayout.NORTH, LoginPanel, 35, SpringLayout.NORTH, backgroundPanel);
		sl_backgroundPanel.putConstraint(SpringLayout.WEST, LoginPanel, 35, SpringLayout.WEST, backgroundPanel);
		sl_backgroundPanel.putConstraint(SpringLayout.SOUTH, LoginPanel, -35, SpringLayout.NORTH, logoPanel);
		sl_backgroundPanel.putConstraint(SpringLayout.EAST, LoginPanel, 399, SpringLayout.WEST, backgroundPanel);
		backgroundPanel.add(LoginPanel);
		LoginPanel.setOpaque(false);
		SpringLayout sl_LoginPanel = new SpringLayout();
		LoginPanel.setLayout(sl_LoginPanel);
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/login.png"));
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
		sl_LoginPanel.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, LoginPanel);
		sl_LoginPanel.putConstraint(SpringLayout.WEST, panel, 80, SpringLayout.WEST, LoginPanel);
		sl_LoginPanel.putConstraint(SpringLayout.SOUTH, panel, 120, SpringLayout.NORTH, LoginPanel);
		sl_LoginPanel.putConstraint(SpringLayout.EAST, panel, -80, SpringLayout.EAST, LoginPanel);
		LoginPanel.add(panel);
		
		JPanel IdPanel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/id.png"));
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
		sl_LoginPanel.putConstraint(SpringLayout.NORTH, IdPanel, 20, SpringLayout.SOUTH, panel);
		sl_LoginPanel.putConstraint(SpringLayout.WEST, IdPanel, 35, SpringLayout.WEST, LoginPanel);
		sl_LoginPanel.putConstraint(SpringLayout.SOUTH, IdPanel, 85, SpringLayout.SOUTH, panel);
		sl_LoginPanel.putConstraint(SpringLayout.EAST, IdPanel, 110, SpringLayout.WEST, LoginPanel);
		LoginPanel.add(IdPanel);
		
		JPanel pwPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/pw.png"));
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
		sl_LoginPanel.putConstraint(SpringLayout.NORTH, pwPanel, 20, SpringLayout.SOUTH, IdPanel);
		sl_LoginPanel.putConstraint(SpringLayout.WEST, pwPanel, 0, SpringLayout.WEST, IdPanel);
		sl_LoginPanel.putConstraint(SpringLayout.SOUTH, pwPanel, 85, SpringLayout.SOUTH, IdPanel);
		sl_LoginPanel.putConstraint(SpringLayout.EAST, pwPanel, 0, SpringLayout.EAST, IdPanel);
		LoginPanel.add(pwPanel);
		
		IdTxt = new JTextField();
		IdTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				id = IdTxt.getText();
			}
		});
		IdTxt.setBackground(new Color(255, 255, 255, 150));
		IdTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		sl_LoginPanel.putConstraint(SpringLayout.NORTH, IdTxt, 15, SpringLayout.NORTH, IdPanel);
		sl_LoginPanel.putConstraint(SpringLayout.WEST, IdTxt, 20, SpringLayout.EAST, IdPanel);
		sl_LoginPanel.putConstraint(SpringLayout.SOUTH, IdTxt, -15, SpringLayout.SOUTH, IdPanel);
		sl_LoginPanel.putConstraint(SpringLayout.EAST, IdTxt, -60, SpringLayout.EAST, LoginPanel);
		LoginPanel.add(IdTxt);
		IdTxt.setColumns(10);
		
		pwTxt = new JPasswordField();
		pwTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				pw = pwTxt.getText();
			}
		});
		pwTxt.setBackground(new Color(255, 255, 255, 150));
		pwTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		sl_LoginPanel.putConstraint(SpringLayout.NORTH, pwTxt, 15, SpringLayout.NORTH, pwPanel);
		sl_LoginPanel.putConstraint(SpringLayout.WEST, pwTxt, 20, SpringLayout.EAST, pwPanel);
		sl_LoginPanel.putConstraint(SpringLayout.SOUTH, pwTxt, -15, SpringLayout.SOUTH, pwPanel);
		sl_LoginPanel.putConstraint(SpringLayout.EAST, pwTxt, -60, SpringLayout.EAST, LoginPanel);
		pwTxt.setColumns(10);
		LoginPanel.add(pwTxt);
		
		JButton loginBtn = new JButton(new ImageIcon("./image/loginBtn01.png"));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				office_num = mg.officeNumIdPw(id, pw);
				if(office_num != 0) {
					MainGUI main = new MainGUI();
					main.main(office_num);
					frame.dispose();
				} else {
					//custom title, warning icon
					JOptionPane.showMessageDialog(frame,
					    "아이디와 비밀번호가 맞지 않습니다.",
					    "로그인 오류",
					    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		loginBtn.setBackground(new Color(255, 255, 255, 100));
		loginBtn.setBorderPainted(false);
		loginBtn.setFocusPainted(false);
		loginBtn.setFont(new Font("서울남산체 M", Font.PLAIN, 16));
		sl_LoginPanel.putConstraint(SpringLayout.NORTH, loginBtn, -65, SpringLayout.SOUTH, LoginPanel);
		sl_LoginPanel.putConstraint(SpringLayout.WEST, loginBtn, -150, SpringLayout.EAST, LoginPanel);
		sl_LoginPanel.putConstraint(SpringLayout.SOUTH, loginBtn, -30, SpringLayout.SOUTH, LoginPanel);
		sl_LoginPanel.putConstraint(SpringLayout.EAST, loginBtn, -50, SpringLayout.EAST, LoginPanel);
		LoginPanel.add(loginBtn);
	}
}
