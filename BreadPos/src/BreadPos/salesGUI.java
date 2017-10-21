package BreadPos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.text.GapContent;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class salesGUI {

	public JFrame frame;
	private MyCllickListener myCllickListener;
	private GraphGUI graphGUI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salesGUI window = new salesGUI();
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
	public salesGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 694, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_52956806134008");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel Showgrap = new JPanel(); //Ä«µå ·¹ÀÌ¾Æ¿ô
		Showgrap.setBackground(new Color(211, 211, 211,100));
		Showgrap.setOpaque(false);
		sl_panel.putConstraint(SpringLayout.NORTH, Showgrap, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, Showgrap, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, Showgrap, 380, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, Showgrap, 674, SpringLayout.WEST, panel);
		
		panel.add(Showgrap);
		
		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, Showgrap);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, Showgrap);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 85, SpringLayout.SOUTH, Showgrap);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, Showgrap);
		
		Showgrap.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		Showgrap.add(panel_3, "name_87378178161920");
		GraphGUI graphGUI = new GraphGUI("");
		graphGUI.main(null);
		
		
		JPanel panel_4 = new JPanel();
		Showgrap.add(panel_4, "name_87401273531306");
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 3, 10, 0));
		
		JButton btnNewButton = new JButton("\uADF8\uB798\uD504\uBCF4\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { // ±×·¡ÇÁº¸±â 
				graphGUI.tabbed(panel_2);
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton.setBackground(Color.orange);
			}
		});
		btnNewButton.setForeground(new Color(240, 248, 255));
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uC778\uAE30\uBE75\uC21C\uC704");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_1.setBackground(Color.ORANGE);
			}
		});
		btnNewButton_1.setForeground(new Color(240, 248, 255));
		btnNewButton_1.setBackground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC885\uB8CC");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCllickListener.onClick();
				frame.dispose();
			}
		});
		btnNewButton_2.setForeground(new Color(240, 248, 255));
		btnNewButton_2.setBackground(new Color(128, 0, 0));
		btnNewButton_2.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel_2.add(btnNewButton_2);
	}

	private static void showgrap() {
		// TODO Auto-generated method stub
		GraphGUI graphGUI = new GraphGUI("");
		
		
	}

	public void setOnMyClickListener(MyCllickListener myCllickListener) {
		this.myCllickListener = myCllickListener;
		
	}
}
