package BreadPos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class PaymentGUI {

	public JFrame frame;
	private MyCllickListener myCllickListener;
	private static Management management;
	public DiscountGUI discountGUI;
	private static JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentGUI window = new PaymentGUI();
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
	public PaymentGUI() {
		management = new Management();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(222, 184, 135,100));
		frame.setBounds(100, 100, 438, 586);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      SpringLayout springLayout = new SpringLayout();
	      frame.getContentPane().setLayout(springLayout);
		
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 54, SpringLayout.NORTH, frame.getContentPane());
		panel.setBackground(Color.BLACK);
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 410, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 276, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -16, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_1);
		panel_1.setOpaque(false);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 170, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, -16, SpringLayout.SOUTH, frame.getContentPane());
		panel_2.setOpaque(false);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 6, SpringLayout.EAST, panel_1);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_6, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_6, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_6, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_6, 200, SpringLayout.WEST, panel);
		panel.add(panel_6);
		SpringLayout sl_panel_6 = new SpringLayout();
		panel_6.setLayout(sl_panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_7, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_7, 200, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_7, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_7, 300, SpringLayout.WEST, panel);
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(8, 0, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_8, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_8, 0, SpringLayout.EAST, panel_7);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_8, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_8, 100, SpringLayout.EAST, panel_7);
		panel.add(panel_8);
		panel_8.setLayout(new GridLayout(8, 0, 0, 0));
		Vector userColumn = new Vector<>();
		Vector userRow = new Vector<>();
		Vector data = new Vector<>();

		userColumn.add("»óÇ°ÀÌ¸§");
		userColumn.add("¼ö·®");
		userColumn.add("°¡°Ý");

		userRow.add("¼Òº¸·Î»§");
		userRow.add("1");
		userRow.add("1200");

		data.add(userRow);
		// panel.add(table);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, 240, SpringLayout.EAST, panel_1);
		panel_1.setLayout(new GridLayout(4, 0, 0, 10));

		JButton btnNewButton_1 = new JButton("\uD560\uC778");
		btnNewButton_1.setBackground(new Color(128, 0, 0));
		btnNewButton_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DiscountGUI discountGUI = new DiscountGUI();
				discountGUI.main(null);
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uD604\uAE08");
		btnNewButton_2.setBackground(new Color(128, 0, 0));
		btnNewButton_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		btnNewButton_2.setForeground(Color.WHITE);
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\uCE74\uB4DC");
		btnNewButton_3.setBackground(new Color(128, 0, 0));
		btnNewButton_3.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		btnNewButton_3.setForeground(Color.WHITE);
		panel_1.add(btnNewButton_3);

		JButton btnNewButton = new JButton("\uAE30\uD504\uD2F0\uCF58");
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		btnNewButton.setForeground(Color.WHITE);
		panel_1.add(btnNewButton);
		frame.getContentPane().add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JPanel panel_3 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_3, -54, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_3, 224, SpringLayout.WEST, panel_2);
		panel_3.setOpaque(false);
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 10, 0));

		JButton btnNewButton_5 = new JButton("\uC774\uC804");
		btnNewButton_5.setBackground(new Color(139, 69, 19));
		btnNewButton_5.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myCllickListener.onClick();
				frame.dispose();
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton("°áÁ¦");
		btnNewButton_4.setBackground(new Color(139, 69, 19));
		btnNewButton_4.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		panel_3.add(btnNewButton_4);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_4, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_4, -24, SpringLayout.NORTH, panel_3);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_4, -10, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_4);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("\uB0B4\uC5ED");
		lblNewLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(139, 69, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\uAE08\uC561");
		lblNewLabel_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_2.setBackground(new Color(139, 69, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("\uACB0\uC81C \uAE08\uC561");
		lblNewLabel_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("New label"); // °áÁ¦±Ý¾×
		lblNewLabel_4.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("\uD560\uC778\uAE08\uC561");
		lblNewLabel_6.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel(); // ÇÒÀÎ±Ý¾×
		lblNewLabel_7.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		DiscountGUI discountGUI = new DiscountGUI();
		// discountGUI.discount();

		panel_4.add(lblNewLabel_7);

		JLabel lblNewLabel_3 = new JLabel("\uCD5C\uC885 \uAE08\uC561");
		lblNewLabel_3.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("New label"); // ÃÖÁ¾±Ý¾×
		lblNewLabel_5.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_5);
		
		JPanel panel_9 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, panel_9, -6, SpringLayout.NORTH, panel);
		panel_9.setBackground(Color.WHITE);
		springLayout.putConstraint(SpringLayout.NORTH, panel_9, -44, SpringLayout.NORTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_9, 0, SpringLayout.WEST, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_9, 412, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_9);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_9.add(panel_10);
		panel_10.setLayout(new CardLayout(0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("\uC0C1\uD488 \uC774\uB984");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		panel_10.add(lblNewLabel_8, "name_79848936128853");
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_9.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("\uC218\uB7C9");
		lblNewLabel_9.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("\uAC00\uACA9");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 25));
		panel_11.add(lblNewLabel_10);
	}

	public void setOnMyClickListener(MyCllickListener myCllickListener) {
		this.myCllickListener = myCllickListener;

	}

	public static void chaingeMsg(int input) {
		Management management = new Management();

		lblNewLabel_7.setText("" + input);
		// TODO Auto-generated method stub
		if (input == 1) {
			ArrayList<Integer> moneylist = new ArrayList<>();
			moneylist.add(10000);
			int[] money = management.name(moneylist, 10);
			lblNewLabel_7.setText("" + money[1]);
		}else if (input == 2) {
			ArrayList<Integer> moneylist = new ArrayList<>();
			moneylist.add(10000);
			int[] money = management.name(moneylist, 7);
			lblNewLabel_7.setText(""+ money[1]);
		}else {
			ArrayList<Integer> moneylist = new ArrayList<>();
			moneylist.add(10000);
			int[] money = management.name(moneylist, 5);
			lblNewLabel_7.setText(""+money[1]);
		}
	
}

	public static void memberMsg(int input) {
		if (input == 1) {
			ArrayList<Integer> moneylist = new ArrayList<>();
			moneylist.add(10000);
			int[] money = management.name(moneylist, 10);
			lblNewLabel_7.setText("" + money[1]);
		}else if (input == 2) {
			ArrayList<Integer> moneylist = new ArrayList<>();
			moneylist.add(10000);
			int[] money = management.name(moneylist, 5);
			lblNewLabel_7.setText(""+money[1]);
		}
		
	}	
}
