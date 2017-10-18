package BreadPos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MainGUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
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
	public MainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 917, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 594, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 891, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_5 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_5, 531, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_5, 152, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_5, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_5, -156, SpringLayout.EAST, panel_1);
		panel_1.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panel_5);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_6, -142, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_6, 0, SpringLayout.SOUTH, panel_5);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_5.add(btnNewButton_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_6, -10, SpringLayout.EAST, panel_1);
		panel_1.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_6.add(btnNewButton_5);
		
		JPanel panel_7 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_7, -79, SpringLayout.NORTH, panel_5);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_7, 21, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_7, -21, SpringLayout.NORTH, panel_5);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_7, 417, SpringLayout.WEST, panel_1);
		panel_1.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_7.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, textField, 58, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, textField, 128, SpringLayout.WEST, panel_7);
		textField.setText("\uCD1D \uACB0\uC81C \uAE08\uC561 :");
		panel_7.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		sl_panel_7.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.EAST, textField);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, lblNewLabel, 58, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, panel_7);
		panel_7.add(lblNewLabel);
		
		JPanel panel_8 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_8, 40, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_8, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_8, -14, SpringLayout.NORTH, panel_7);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_8, 0, SpringLayout.EAST, panel_7);
		panel_1.add(panel_8);
		panel_8.setLayout(new SpringLayout());
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		JPanel panel_3 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_3, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_3, 86, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_3, 47, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_3, -10, SpringLayout.EAST, panel_2);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_3);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_4, 0, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_3);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_4.add(tabbedPane);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_1, null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_2, null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_3, null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_4, null);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_5, null);
		
		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("New tab", null, tabbedPane_6, null);
	}
}
