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
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JScrollBar;

public class ManagementGUI {

	public JFrame frame;
	private MyCllickListener myCllickListener;
	private int choice;
	private BufferedImage icon;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField InputBreadName;
	private JTextField InputBreadType;
	private JTextField InputBreadPrice;
	private JTextField InputBreadNameChange;
	private JTextField InputChangeBreadPrice;

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

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/background.png"));
					Dimension d = getSize();// ÀüÃ¼È­¸é
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

		JPanel importantPanel = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, importantPanel, 363, SpringLayout.NORTH, panel);
		importantPanel.setForeground(new Color(255, 255, 255, 100));
		importantPanel.setOpaque(false);
		sl_panel.putConstraint(SpringLayout.NORTH, importantPanel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, importantPanel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, importantPanel, 465, SpringLayout.WEST, panel);
		panel.add(importantPanel);

		// ¹Ø¿¡ ¹öÆ°´ã´Â ÆÇ³Ú
		JPanel ButtonPanel = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, ButtonPanel, 17, SpringLayout.SOUTH, importantPanel);
		sl_panel.putConstraint(SpringLayout.WEST, ButtonPanel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, ButtonPanel, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, ButtonPanel, -10, SpringLayout.EAST, panel);
		ButtonPanel.setBackground(new Color(255, 255, 255, 0));
		importantPanel.setLayout(new CardLayout(0, 0));

		// ¸Þ´º»èÁ¦ ÆÇ³Ú
		JPanel deleteMenuPanel = new JPanel();
		deleteMenuPanel.setBackground(new Color(255, 255, 255, 100));
		// deleteMenuPanel.setOpaque(false);
		importantPanel.add(deleteMenuPanel, "name_402558025827266");
		SpringLayout sl_deleteMenuPanel = new SpringLayout();
		deleteMenuPanel.setLayout(sl_deleteMenuPanel);

		JLabel lblNewLabel_5 = new JLabel("<\uBA54\uB274 \uC0AD\uC81C>");
		sl_deleteMenuPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 23, SpringLayout.NORTH, deleteMenuPanel);
		sl_deleteMenuPanel.putConstraint(SpringLayout.EAST, lblNewLabel_5, -161, SpringLayout.EAST, deleteMenuPanel);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		deleteMenuPanel.add(lblNewLabel_5);

		JPanel deletMenucomponents = new JPanel();
		deletMenucomponents.setBackground(new Color(255, 255, 255, 0));
		sl_deleteMenuPanel.putConstraint(SpringLayout.NORTH, deletMenucomponents, 42, SpringLayout.SOUTH,
				lblNewLabel_5);
		sl_deleteMenuPanel.putConstraint(SpringLayout.WEST, deletMenucomponents, -397, SpringLayout.EAST,
				deleteMenuPanel);
		sl_deleteMenuPanel.putConstraint(SpringLayout.SOUTH, deletMenucomponents, 198, SpringLayout.SOUTH,
				lblNewLabel_5);
		sl_deleteMenuPanel.putConstraint(SpringLayout.EAST, deletMenucomponents, -55, SpringLayout.EAST,
				deleteMenuPanel);
		deleteMenuPanel.add(deletMenucomponents);
		SpringLayout sl_deletMenucomponents = new SpringLayout();
		deletMenucomponents.setLayout(sl_deletMenucomponents);

		JButton btnNewButton_1 = new JButton("\uC0AD\uC81C");
		btnNewButton_1.setBackground(new Color(210, 105, 30));
		btnNewButton_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		btnNewButton_1.setForeground(Color.WHITE);
		sl_deleteMenuPanel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 22, SpringLayout.SOUTH,
				deletMenucomponents);
		sl_deleteMenuPanel.putConstraint(SpringLayout.WEST, btnNewButton_1, -106, SpringLayout.EAST, deleteMenuPanel);
		sl_deleteMenuPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 65, SpringLayout.SOUTH,
				deletMenucomponents);

		JLabel lblNewLabel_6 = new JLabel("\uBE75\uC885\uB958 :");
		sl_deletMenucomponents.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH,
				deletMenucomponents);
		sl_deletMenucomponents.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST,
				deletMenucomponents);
		sl_deletMenucomponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -107, SpringLayout.SOUTH,
				deletMenucomponents);
		sl_deletMenucomponents.putConstraint(SpringLayout.EAST, lblNewLabel_6, -251, SpringLayout.EAST,
				deletMenucomponents);
		lblNewLabel_6.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		deletMenucomponents.add(lblNewLabel_6);

		JPanel panel_1 = new JPanel();
		sl_deletMenucomponents.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, deletMenucomponents);
		sl_deletMenucomponents.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.EAST, lblNewLabel_6);
		sl_deletMenucomponents.putConstraint(SpringLayout.SOUTH, panel_1, 49, SpringLayout.NORTH, deletMenucomponents);
		sl_deletMenucomponents.putConstraint(SpringLayout.EAST, panel_1, 251, SpringLayout.EAST, lblNewLabel_6);
		deletMenucomponents.add(panel_1);

		JList list = new JList();
		panel_1.add(list);
		sl_deleteMenuPanel.putConstraint(SpringLayout.EAST, btnNewButton_1, -39, SpringLayout.EAST, deleteMenuPanel);
		deleteMenuPanel.add(btnNewButton_1);

		deleteMenuPanel.setVisible(false);

		// ¸Å´º¼öÁ¤ ÆÐ³Î
		JPanel changeMenuPanel = new JPanel();
		changeMenuPanel.setBackground(new Color(255, 255, 255, 100));
		// changeMenuPanel.setOpaque(false);
		importantPanel.add(changeMenuPanel, "name_400323444407684");
		SpringLayout sl_changeMenuPanel = new SpringLayout();
		changeMenuPanel.setLayout(sl_changeMenuPanel);

		JPanel changeMenuComponents = new JPanel();
		sl_changeMenuPanel.putConstraint(SpringLayout.WEST, changeMenuComponents, 42, SpringLayout.WEST,
				changeMenuPanel);
		sl_changeMenuPanel.putConstraint(SpringLayout.SOUTH, changeMenuComponents, -77, SpringLayout.SOUTH,
				changeMenuPanel);
		sl_changeMenuPanel.putConstraint(SpringLayout.EAST, changeMenuComponents, 407, SpringLayout.WEST,
				changeMenuPanel);
		changeMenuComponents.setBackground(new Color(255, 255, 255, 0));
		changeMenuPanel.add(changeMenuComponents);

		JLabel lblNewLabel_1 = new JLabel("<\uBA54\uB274 \uC218\uC815>");
		sl_changeMenuPanel.putConstraint(SpringLayout.NORTH, changeMenuComponents, 6, SpringLayout.SOUTH,
				lblNewLabel_1);
		sl_changeMenuPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 21, SpringLayout.NORTH, changeMenuPanel);
		sl_changeMenuPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 165, SpringLayout.WEST, changeMenuPanel);
		SpringLayout sl_changeMenuComponents = new SpringLayout();
		changeMenuComponents.setLayout(sl_changeMenuComponents);

		InputBreadNameChange = new JTextField();
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, InputBreadNameChange, 0, SpringLayout.NORTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, InputBreadNameChange, -258, SpringLayout.EAST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, InputBreadNameChange, 52, SpringLayout.NORTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, InputBreadNameChange, 0, SpringLayout.EAST,
				changeMenuComponents);
		changeMenuComponents.add(InputBreadNameChange);
		InputBreadNameChange.setColumns(10);

		JLabel OutputBreadType = new JLabel("\uBE75\uC885\uB958 \uCD9C\uB825");
		OutputBreadType.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		OutputBreadType.setHorizontalAlignment(SwingConstants.CENTER);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, OutputBreadType, 23, SpringLayout.SOUTH,
				InputBreadNameChange);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, OutputBreadType, 0, SpringLayout.WEST,
				InputBreadNameChange);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, OutputBreadType, 75, SpringLayout.SOUTH,
				InputBreadNameChange);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, OutputBreadType, 0, SpringLayout.EAST,
				InputBreadNameChange);
		changeMenuComponents.add(OutputBreadType);

		InputChangeBreadPrice = new JTextField();
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, InputChangeBreadPrice, -52, SpringLayout.SOUTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, InputChangeBreadPrice, 0, SpringLayout.WEST,
				InputBreadNameChange);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, InputChangeBreadPrice, 0, SpringLayout.SOUTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, InputChangeBreadPrice, 0, SpringLayout.EAST,
				InputBreadNameChange);
		changeMenuComponents.add(InputChangeBreadPrice);
		InputChangeBreadPrice.setColumns(10);
		lblNewLabel_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		changeMenuPanel.add(lblNewLabel_1);

		JButton ChangeButton = new JButton("\uC218\uC815");
		ChangeButton.setBackground(new Color(210, 105, 30));
		ChangeButton.setForeground(new Color(255, 255, 255));
		ChangeButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.PLAIN, 20));
		sl_changeMenuPanel.putConstraint(SpringLayout.NORTH, ChangeButton, 16, SpringLayout.SOUTH,
				changeMenuComponents);
		sl_changeMenuPanel.putConstraint(SpringLayout.SOUTH, ChangeButton, 56, SpringLayout.SOUTH,
				changeMenuComponents);

		JLabel lblNewLabel_2 = new JLabel("\uBE75\uC774\uB984 :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, lblNewLabel_2, -107, SpringLayout.WEST,
				InputBreadNameChange);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 52, SpringLayout.NORTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, lblNewLabel_2, -6, SpringLayout.WEST,
				InputBreadNameChange);
		changeMenuComponents.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("\uBE75\uC885\uB958 :");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 23, SpringLayout.SOUTH, lblNewLabel_2);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_2);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, 75, SpringLayout.SOUTH, lblNewLabel_2);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, lblNewLabel_3, -6, SpringLayout.WEST, OutputBreadType);
		changeMenuComponents.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("\uAC00\uACA9 :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		lblNewLabel_4.setEnabled(true);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 0, SpringLayout.NORTH,
				InputChangeBreadPrice);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH,
				InputChangeBreadPrice);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, lblNewLabel_4, -6, SpringLayout.WEST,
				InputChangeBreadPrice);
		changeMenuComponents.add(lblNewLabel_4);
		sl_changeMenuPanel.putConstraint(SpringLayout.EAST, ChangeButton, -30, SpringLayout.EAST, changeMenuPanel);
		changeMenuPanel.add(ChangeButton);
		changeMenuPanel.setVisible(false);// ¸Þ´º¼öÁ¤¾Èº¸ÀÌ°Ô

		// ¸Þ´ºÃß°¡ ÆÐ³Î
		JPanel addMenuPanel = new JPanel();
		// addMenuPanel.setOpaque(false);
		addMenuPanel.setBackground(new Color(255, 255, 255, 100));
		importantPanel.add(addMenuPanel, "name_399229462868927");
		SpringLayout sl_addMenuPanel = new SpringLayout();
		addMenuPanel.setLayout(sl_addMenuPanel);

		JPanel addMenuComponents = new JPanel();
		sl_addMenuPanel.putConstraint(SpringLayout.WEST, addMenuComponents, 25, SpringLayout.WEST, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, addMenuComponents, -81, SpringLayout.SOUTH, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.EAST, addMenuComponents, 414, SpringLayout.WEST, addMenuPanel);
		addMenuComponents.setBackground(new Color(255, 255, 255, 0));
		addMenuComponents.setOpaque(false);
		addMenuPanel.add(addMenuComponents);
		SpringLayout sl_addMenuComponents = new SpringLayout();
		addMenuComponents.setLayout(sl_addMenuComponents);

		InputBreadName = new JTextField();
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, InputBreadName, 0, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, InputBreadName, -270, SpringLayout.EAST,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, InputBreadName, 47, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, InputBreadName, 0, SpringLayout.EAST, addMenuComponents);
		addMenuComponents.add(InputBreadName);
		InputBreadName.setColumns(10);

		InputBreadType = new JTextField();
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, InputBreadType, 34, SpringLayout.SOUTH, InputBreadName);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, InputBreadType, 0, SpringLayout.WEST, InputBreadName);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, InputBreadType, 0, SpringLayout.EAST, addMenuComponents);
		addMenuComponents.add(InputBreadType);
		InputBreadType.setColumns(10);

		InputBreadPrice = new JTextField();
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, InputBreadPrice, -47, SpringLayout.SOUTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, InputBreadPrice, -270, SpringLayout.EAST,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, InputBreadPrice, 0, SpringLayout.SOUTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, InputBreadPrice, 0, SpringLayout.EAST, addMenuComponents);
		addMenuComponents.add(InputBreadPrice);
		InputBreadPrice.setColumns(10);

		JLabel BreadNameLabel = new JLabel("\uBE75\uC774\uB984 :");
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, BreadNameLabel, 0, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, BreadNameLabel, 0, SpringLayout.WEST, addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, BreadNameLabel, -6, SpringLayout.WEST, InputBreadName);
		BreadNameLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		BreadNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMenuComponents.add(BreadNameLabel);

		JLabel BreadTypeLabel = new JLabel("\uBE75\uC885\uB958 :");
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, BreadTypeLabel, 81, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, InputBreadType, 0, SpringLayout.SOUTH, BreadTypeLabel);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, BreadTypeLabel, -276, SpringLayout.EAST,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, BreadNameLabel, -31, SpringLayout.NORTH, BreadTypeLabel);
		BreadTypeLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		BreadTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, BreadTypeLabel, 0, SpringLayout.WEST, BreadNameLabel);
		addMenuComponents.add(BreadTypeLabel);

		JLabel BreadPriceLabel = new JLabel("\uAC00\uACA9 :");
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, BreadTypeLabel, -30, SpringLayout.NORTH,
				BreadPriceLabel);
		BreadPriceLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		BreadPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, BreadPriceLabel, 0, SpringLayout.NORTH, InputBreadPrice);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, BreadPriceLabel, 0, SpringLayout.WEST, BreadNameLabel);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, BreadPriceLabel, 0, SpringLayout.SOUTH, InputBreadPrice);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, BreadPriceLabel, -6, SpringLayout.WEST, InputBreadPrice);
		addMenuComponents.add(BreadPriceLabel);

		JLabel lblNewLabel = new JLabel("<\uBA54\uB274 \uCD94\uAC00>");
		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -307, SpringLayout.SOUTH, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, addMenuComponents, 18, SpringLayout.SOUTH, lblNewLabel);
		sl_addMenuPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 104, SpringLayout.WEST, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -102, SpringLayout.EAST, addMenuPanel);
		lblNewLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMenuPanel.add(lblNewLabel);

		JButton btnNewButton = new JButton("\uCD94\uAC00");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(210, 105, 30));
		btnNewButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, btnNewButton, 20, SpringLayout.SOUTH, addMenuComponents);
		sl_addMenuPanel.putConstraint(SpringLayout.WEST, btnNewButton, -124, SpringLayout.EAST, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, btnNewButton, -25, SpringLayout.SOUTH, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.EAST, btnNewButton, -27, SpringLayout.EAST, addMenuPanel);
		addMenuPanel.add(btnNewButton);
		addMenuPanel.setVisible(false); // ¾Èº¸ÀÌ°Ô ÇÔ

		panel.add(ButtonPanel);

		ButtonPanel.setLayout(new GridLayout(2, 3, 10, 10));

		// ¸Þ´ºÃß°¡
		JButton addMenu = new JButton("\uBA54\uB274 \uCD94\uAC00");
		addMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Å¬¸¯½Ã¿¡ choice 1
				choice = 1;

				System.out.println(choice);

				addMenuPanel.setVisible(true);
				changeMenuPanel.setVisible(false);
				deleteMenuPanel.setVisible(false);

			}
		});
		addMenu.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		addMenu.setForeground(Color.WHITE);
		addMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(addMenu);

		// ¸Þ´º¼öÁ¤
		JButton changeMenu = new JButton("\uBA54\uB274\uC218\uC815");
		changeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Å¬¸¯½Ã¿¡ choice 2
				choice = 2;
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(true);
				deleteMenuPanel.setVisible(false);

			}
		});

		changeMenu.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		changeMenu.setForeground(Color.WHITE);
		changeMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(changeMenu);

		// ¸Þ´º»èÁ¦
		JButton deleMenu = new JButton("\uBA54\uB274\uC0AD\uC81C");
		deleMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Å¬¸¯½Ã¿¡ choice 3
				choice = 3;
				deleteMenuPanel.setVisible(true);
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(false);
			}
		});

		deleMenu.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		deleMenu.setForeground(Color.WHITE);
		deleMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(deleMenu);

		// ÁöÁ¡Á¤º¸º¯°æ
		JButton changeInfo = new JButton("\uC9C0\uC810\uC815\uBCF4\uC218\uC815");
		changeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Å¬¸¯½Ã¿¡ choice 4
				choice = 4;
			}
		});

		changeInfo.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		changeInfo.setForeground(Color.WHITE);
		changeInfo.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(changeInfo);

		// È¸¿ø°ü¸®
		JButton controllMember = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		controllMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Å¬¸¯½Ã¿¡ choice 5
			}
		});

		controllMember.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		controllMember.setForeground(Color.WHITE);
		controllMember.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(controllMember);

		// Á¾·á
		JButton close = new JButton("\uB2EB\uAE30");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Å¬¸¯½Ã¿¡ choice 6
				// myCllickListener.onClick();
				frame.dispose();
			}
		});
		close.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		close.setForeground(Color.WHITE);
		close.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(close);
	}

	public void setOnMyClickListener(MyCllickListener myCllickListener) {
		// TODO Auto-generated method stub
		this.myCllickListener = myCllickListener;

	}
}
