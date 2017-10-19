package BreadPos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagementGUI {

	public JFrame frame;
	private MyCllickListener myCllickListener;
	private int choice = 0;

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
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_52178911182620");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211, 100));
		panel_1.setForeground(new Color(0, 0, 0));
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 354, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 465, SpringLayout.WEST, panel);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 26, SpringLayout.SOUTH, panel_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, panel_1);
		panel_1.setLayout(new SpringLayout());
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 3, 10, 10));
		
		//메뉴추가
		JButton addMenu = new JButton("\uBA54\uB274 \uCD94\uAC00");
		addMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //클릭시에 choice 1
				choice = 1;
				addMenu.setBackground(Color.orange);
			}
		});
		addMenu.setFont(new Font("굴림", Font.BOLD, 15));
		addMenu.setForeground(new Color(240, 248, 255));
		addMenu.setBackground(new Color(128, 0, 0));
		panel_2.add(addMenu);
		
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
		panel_2.add(deleMenu);
		
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
		panel_2.add(changeMenu);
		
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
		panel_2.add(changeInfo);
		
		//회원관리
		JButton controllMember = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		controllMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//클릭시에 choice 5
			}
		});
		
		controllMember.setFont(new Font("굴림", Font.BOLD, 15));
		controllMember.setForeground(new Color(240, 248, 255));
		controllMember.setBackground(new Color(128, 0, 0));
		panel_2.add(controllMember);
		
		//종료
		JButton close = new JButton("\uB2EB\uAE30");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//클릭시에 choice 6
				myCllickListener.onClick();
				frame.dispose();
			}
		});
		close.setFont(new Font("굴림", Font.BOLD, 15));
		close.setForeground(new Color(240, 248, 255));
		close.setBackground(new Color(128, 0, 0));
		panel_2.add(close);
	}
	
	public void setOnMyClickListener(MyCllickListener myCllickListener) {
		// TODO Auto-generated method stub
		this.myCllickListener = myCllickListener;
		
	}
}
