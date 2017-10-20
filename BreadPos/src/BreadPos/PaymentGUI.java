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

public class PaymentGUI {

	public JFrame frame;
	private JTable table;
	private MyCllickListener myCllickListener;
	private Management management;
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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 438, 586);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel, 270, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 410, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 261, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 170, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		springLayout.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_2, 6, SpringLayout.EAST, panel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_2, 261, SpringLayout.SOUTH, panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		Vector userColumn = new Vector<>();
		Vector userRow = new Vector<>();
		Vector data = new Vector<>();

		userColumn.add("상품이름");
		userColumn.add("수량");
		userColumn.add("가격");

		userRow.add("소보로빵");
		userRow.add("1");
		userRow.add("1200");

		data.add(userRow);

		table = new JTable();

		scrollPane.setViewportView(table);
		// panel.add(table);
		springLayout.putConstraint(SpringLayout.EAST, panel_2, 240, SpringLayout.EAST, panel_1);
		panel_1.setLayout(new GridLayout(4, 0, 0, 10));

		JButton btnNewButton_1 = new JButton("\uD560\uC778");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DiscountGUI discountGUI = new DiscountGUI();
				discountGUI.main(null);
			}
		});
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\uD604\uAE08");
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("\uCE74\uB4DC");
		panel_1.add(btnNewButton_3);

		JButton btnNewButton = new JButton("\uAE30\uD504\uD2F0\uCF58");
		panel_1.add(btnNewButton);
		frame.getContentPane().add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		JPanel panel_3 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_3, -54, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_3, 0, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_3, 224, SpringLayout.WEST, panel_2);
		panel_3.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 2, 10, 0));

		JButton btnNewButton_5 = new JButton("보류");
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

		JButton btnNewButton_4 = new JButton("결제");
		panel_3.add(btnNewButton_4);

		JPanel panel_4 = new JPanel();
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_4, 10, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_4, 10, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_4, -24, SpringLayout.NORTH, panel_3);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_4, -10, SpringLayout.EAST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_4);
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblNewLabel = new JLabel("\uB0B4\uC5ED");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(139, 69, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("\uAE08\uC561");
		lblNewLabel_2.setBackground(new Color(139, 69, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("\uACB0\uC81C \uAE08\uC561");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("New label"); // 결제금액
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("\uD560\uC778\uAE08\uC561");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel(); // 할인금액
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		DiscountGUI discountGUI = new DiscountGUI();
		//discountGUI.discount();

		panel_4.add(lblNewLabel_7);

		JLabel lblNewLabel_3 = new JLabel("\uCD5C\uC885 \uAE08\uC561");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("New label"); // 최종금액
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_5);
	}

	public void setOnMyClickListener(MyCllickListener myCllickListener) {
		this.myCllickListener = myCllickListener;

	}

	public static void chaingeMsg(int input) {
		Management management = new Management();
		
		lblNewLabel_7.setText(""+input);
		// TODO Auto-generated method stub
		if (input == 1) {
			
			
			
			ArrayList<Integer> moneylist = new ArrayList<>();
			moneylist.add(10000);
			System.out.println(moneylist.get(0));
			int[] money = management.name(moneylist, 10);
			lblNewLabel_7.setText(""+money[1]);
			
		}
	}

}
