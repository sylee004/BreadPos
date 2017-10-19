package BreadPos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class ManagementGUI {

	private JFrame frame;

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
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 3, 10, 10));
		
		JButton btnNewButton_1 = new JButton("\uBA54\uB274 \uCD94\uAC00");
		btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(240, 248, 255));
		btnNewButton_1.setBackground(new Color(128, 0, 0));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("\uBA54\uB274\uC0AD\uC81C");
		btnNewButton_4.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_4.setForeground(new Color(240, 248, 255));
		btnNewButton_4.setBackground(new Color(128, 0, 0));
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("\uBA54\uB274\uC218\uC815");
		btnNewButton_2.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_2.setForeground(new Color(240, 248, 255));
		btnNewButton_2.setBackground(new Color(128, 0, 0));
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("\uC9C0\uC810\uC815\uBCF4\uC218\uC815");
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(240, 248, 255));
		btnNewButton.setBackground(new Color(128, 0, 0));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		btnNewButton_3.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_3.setForeground(new Color(240, 248, 255));
		btnNewButton_3.setBackground(new Color(128, 0, 0));
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("\uB2EB\uAE30");
		btnNewButton_5.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_5.setForeground(new Color(240, 248, 255));
		btnNewButton_5.setBackground(new Color(128, 0, 0));
		panel_2.add(btnNewButton_5);
	}
}
