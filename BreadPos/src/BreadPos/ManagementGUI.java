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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DB.BreadInfoDAO;
import DB.Member;
import DB.MemberInfoDAO;
import DB.OfficeDAO;

public class ManagementGUI {

	public JFrame frame;
	private MyCllickListener myCllickListener;
	private BufferedImage icon;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField InputBreadName;
	private JTextField InputBreadPrice;
	private JTextField InputChangeBreadPrice;
	private JTextField textField_3;
	private int memberChoice = 0; // È¸¿ø°ü¸® µî·Ï,¼öÁ¤, »èÁ¦ º¯¼ö
	private JTextField phoneNumInput;
	private JTextField nameInput;
	private JTextField Input;
	private JTextField InputChange;
	private JTextField InputValue;
	private static int office_num;
	Management mg = new Management();
	String breadName;
	String[] breadType = { "¹Ð°¡·ç", "º¸¸®", "¿Á¼ö¼ö", "È£¹Ð", "È¥ÇÕ", "±âÅ¸" };
	String breadTypeChoice;
	int breadPrice;
	String memberName;
	String memberPhoneNumber;
	int memberMoney;
	int check;
	ArrayList<String> breadNameList;
	ArrayList<Member> OuputList = new ArrayList<>(); // Ãâ·Â
	String[] OutList;
	String Ouput; // Ãâ·Â


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
		
		JPanel StartPanel = new JPanel();
		StartPanel.setBackground(new Color(255, 255, 255,150));
		importantPanel.add(StartPanel, "name_509594362957614");
		SpringLayout sl_StartPanel = new SpringLayout();
		StartPanel.setLayout(sl_StartPanel);
		StartPanel.setVisible(true);
		
		JLabel label_1 = new JLabel("\uC6D0\uD558\uC2DC\uB294 \uBC84\uD2BC\uC744 \uD074\uB9AD\uD574\uC8FC\uC138\uC694!");
		sl_StartPanel.putConstraint(SpringLayout.NORTH, label_1, 106, SpringLayout.NORTH, StartPanel);
		sl_StartPanel.putConstraint(SpringLayout.EAST, label_1, -86, SpringLayout.EAST, StartPanel);
		label_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 30));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		StartPanel.add(label_1);

		// È¸¿øÁ¤º¸ ÆÇ³Ú
		JPanel MemberInfo = new JPanel();
		MemberInfo.setBackground(new Color(255, 255, 255, 100));
		importantPanel.add(MemberInfo, "name_7775658898278");
		MemberInfo.setOpaque(false);
		SpringLayout sl_MemberInfo = new SpringLayout();
		MemberInfo.setLayout(sl_MemberInfo);

		JPanel MemebrManage = new JPanel();
		MemebrManage.setBackground(new Color(255, 255, 255, 0));
		MemebrManage.setOpaque(false);
		sl_MemberInfo.putConstraint(SpringLayout.NORTH, MemebrManage, -289, SpringLayout.SOUTH, MemberInfo);
		sl_MemberInfo.putConstraint(SpringLayout.WEST, MemebrManage, 10, SpringLayout.WEST, MemberInfo);
		sl_MemberInfo.putConstraint(SpringLayout.SOUTH, MemebrManage, -10, SpringLayout.SOUTH, MemberInfo);
		sl_MemberInfo.putConstraint(SpringLayout.EAST, MemebrManage, 445, SpringLayout.WEST, MemberInfo);
		MemberInfo.add(MemebrManage);
		SpringLayout sl_MemebrManage = new SpringLayout();
		MemebrManage.setLayout(sl_MemebrManage);

		JPanel buttonManage = new JPanel();
		buttonManage.setBackground(new Color(255, 255, 255, 0));
		sl_MemebrManage.putConstraint(SpringLayout.NORTH, buttonManage, 10, SpringLayout.NORTH, MemebrManage);
		sl_MemebrManage.putConstraint(SpringLayout.WEST, buttonManage, 10, SpringLayout.WEST, MemebrManage);
		sl_MemebrManage.putConstraint(SpringLayout.SOUTH, buttonManage, 59, SpringLayout.NORTH, MemebrManage);
		sl_MemebrManage.putConstraint(SpringLayout.EAST, buttonManage, 425, SpringLayout.WEST, MemebrManage);
		MemebrManage.add(buttonManage);
		buttonManage.setLayout(new GridLayout(0, 3, 10, 0));

		// È¸¿øÁ¤º¸ ÆÇ³Ú>>È¸¿ø°ü¸® ÆÐ³Î
		JPanel ImportCard = new JPanel();
		ImportCard.setBackground(new Color(255, 255, 255, 100));
		ImportCard.setOpaque(false);
		sl_MemebrManage.putConstraint(SpringLayout.NORTH, ImportCard, 6, SpringLayout.SOUTH, buttonManage);
		sl_MemebrManage.putConstraint(SpringLayout.WEST, ImportCard, 0, SpringLayout.WEST, buttonManage);
		sl_MemebrManage.putConstraint(SpringLayout.SOUTH, ImportCard, 210, SpringLayout.SOUTH, buttonManage);
		sl_MemebrManage.putConstraint(SpringLayout.EAST, ImportCard, 0, SpringLayout.EAST, buttonManage);
		MemebrManage.add(ImportCard);
		ImportCard.setLayout(new CardLayout(0, 0));

		// ¸â¹öÃß°¡
		JPanel addMember = new JPanel();
		addMember.setOpaque(false);
		addMember.setBackground(new Color(255, 255, 255, 100));
		// addMember.setOpaque(false);
		ImportCard.add(addMember, "name_8523663693515");
		SpringLayout sl_addMember = new SpringLayout();
		addMember.setLayout(sl_addMember);

		JLabel lblNewLabel_13 = new JLabel("- \uB4F1\uB85D");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_addMember.putConstraint(SpringLayout.NORTH, lblNewLabel_13, 0, SpringLayout.NORTH, addMember);
		sl_addMember.putConstraint(SpringLayout.WEST, lblNewLabel_13, 0, SpringLayout.WEST, addMember);
		addMember.add(lblNewLabel_13);

		phoneNumInput = new JTextField();
		phoneNumInput.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_addMember.putConstraint(SpringLayout.NORTH, phoneNumInput, 37, SpringLayout.NORTH, addMember);
		sl_addMember.putConstraint(SpringLayout.WEST, phoneNumInput, -337, SpringLayout.EAST, addMember);
		sl_addMember.putConstraint(SpringLayout.SOUTH, phoneNumInput, 89, SpringLayout.NORTH, addMember);
		sl_addMember.putConstraint(SpringLayout.EAST, phoneNumInput, -10, SpringLayout.EAST, addMember);
		addMember.add(phoneNumInput);
		phoneNumInput.setColumns(10);

		nameInput = new JTextField();
		nameInput.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_addMember.putConstraint(SpringLayout.NORTH, nameInput, 16, SpringLayout.SOUTH, phoneNumInput);
		sl_addMember.putConstraint(SpringLayout.EAST, nameInput, -10, SpringLayout.EAST, addMember);
		addMember.add(nameInput);
		nameInput.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("\uBC88\uD638 :");
		sl_addMember.putConstraint(SpringLayout.NORTH, lblNewLabel_14, 6, SpringLayout.SOUTH, lblNewLabel_13);
		sl_addMember.putConstraint(SpringLayout.WEST, lblNewLabel_14, 0, SpringLayout.WEST, addMember);
		sl_addMember.putConstraint(SpringLayout.EAST, lblNewLabel_14, -6, SpringLayout.WEST, phoneNumInput);
		lblNewLabel_14.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		addMember.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("\uC774\uB984 :");
		sl_addMember.putConstraint(SpringLayout.NORTH, lblNewLabel_15, 105, SpringLayout.NORTH, addMember);
		sl_addMember.putConstraint(SpringLayout.SOUTH, lblNewLabel_15, -47, SpringLayout.SOUTH, addMember);
		sl_addMember.putConstraint(SpringLayout.EAST, lblNewLabel_15, -343, SpringLayout.EAST, addMember);
		sl_addMember.putConstraint(SpringLayout.SOUTH, lblNewLabel_14, -16, SpringLayout.NORTH, lblNewLabel_15);
		sl_addMember.putConstraint(SpringLayout.WEST, nameInput, 6, SpringLayout.EAST, lblNewLabel_15);
		lblNewLabel_15.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		sl_addMember.putConstraint(SpringLayout.WEST, lblNewLabel_15, 0, SpringLayout.WEST, addMember);
		addMember.add(lblNewLabel_15);

		JButton btnNewButton_3 = new JButton("\uB4F1\uB85D");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = mg.addMember(phoneNumInput.getText(), nameInput.getText());
				//È¸¿øµî·ÏÆË¾÷!!
				zPopMemberInputGUI in = new zPopMemberInputGUI();
				in.main(null);
				frame.dispose();
			}
		});
		sl_addMember.putConstraint(SpringLayout.SOUTH, nameInput, -10, SpringLayout.NORTH, btnNewButton_3);
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		sl_addMember.putConstraint(SpringLayout.WEST, btnNewButton_3, -84, SpringLayout.EAST, addMember);
		sl_addMember.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -4, SpringLayout.SOUTH, addMember);
		sl_addMember.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, addMember);
		btnNewButton_3.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		btnNewButton_3.setBackground(new Color(139, 0, 0));
		addMember.add(btnNewButton_3);
		addMember.setVisible(false);

		// ¸â¹ö¼öÁ¤
		JPanel changeMember = new JPanel();
		changeMember.setBackground(new Color(255, 255, 255, 100));
		// changeMember.setOpaque(false);
		ImportCard.add(changeMember, "name_8555461592377");
		SpringLayout sl_changeMember = new SpringLayout();
		changeMember.setOpaque(false);
		changeMember.setLayout(sl_changeMember);

		JLabel lblNewLabel_12 = new JLabel("- \uC218\uC815");
		lblNewLabel_12.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		sl_changeMember.putConstraint(SpringLayout.NORTH, lblNewLabel_12, 0, SpringLayout.NORTH, changeMember);
		sl_changeMember.putConstraint(SpringLayout.WEST, lblNewLabel_12, 0, SpringLayout.WEST, changeMember);
		changeMember.add(lblNewLabel_12);

		String[] number = { "¹øÈ£", "ÀÌ¸§" };
		JLabel OutputResult = new JLabel("\uCD9C\uB825");
		// ¹øÈ£ ¼±ÅÃ½Ã ÀÌ¸§ Ãâ·Â
		JComboBox chooseNumberName = new JComboBox(number);
		chooseNumberName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(chooseNumberName)) {
					breadName = chooseNumberName.getSelectedItem().toString();
				}
			}
		});
		chooseNumberName.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_changeMember.putConstraint(SpringLayout.NORTH, chooseNumberName, 6, SpringLayout.SOUTH, lblNewLabel_12);
		sl_changeMember.putConstraint(SpringLayout.WEST, chooseNumberName, 10, SpringLayout.WEST, changeMember);
		sl_changeMember.putConstraint(SpringLayout.EAST, chooseNumberName, 84, SpringLayout.WEST, changeMember);
		changeMember.add(chooseNumberName);

		Input = new JTextField(); // ¹Ù²Ü °Í Á¶È¸ ÇÏ·Á´Â °ª ÀÔ·Â½Ã
		Input.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_changeMember.putConstraint(SpringLayout.WEST, OutputResult, 0, SpringLayout.WEST, Input);
		Input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (breadName.equals(number[0])) {// breadName = ¹øÈ£
					for (int i = 0; i < new MemberInfoDAO().selectName(Input.getText()).size(); i++) {
						OuputList.add(new MemberInfoDAO().selectName(Input.getText()).get(i));
					}
					for (int j = 0; j < OuputList.size(); j++) {
						System.out.println("ÀÌ¸§ ¸®½ºÆ®" + OuputList.get(j).getMember_name());
						Ouput = OuputList.get(j).getMember_name();
						OutputResult.setText(OuputList.get(j).getMember_name());
					}
				} else if (breadName.equals(number[1])) { // ÀÌ¸§ >> ¹øÈ£Ãâ·Â //breadName = ÀÌ¸§
					for (int i = 0; i < new MemberInfoDAO().selectPhone(Input.getText()).size(); i++) {
						OuputList.add(new MemberInfoDAO().selectPhone(Input.getText()).get(i));
					}
					for (int j = 0; j < OuputList.size(); j++) {
						System.out.println("¹øÈ£ ¸®½ºÆ®" + OuputList.get(j).getMember_phone());
						Ouput = OuputList.get(j).getMember_phone();
						OutputResult.setText(OuputList.get(j).getMember_phone());
					}
				}
			}
		});
		Input.setOpaque(false);
		Input.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		sl_changeMember.putConstraint(SpringLayout.WEST, Input, 6, SpringLayout.EAST, chooseNumberName);
		sl_changeMember.putConstraint(SpringLayout.EAST, Input, -10, SpringLayout.EAST, changeMember);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, chooseNumberName, 0, SpringLayout.SOUTH, Input);
		sl_changeMember.putConstraint(SpringLayout.NORTH, Input, 36, SpringLayout.NORTH, changeMember);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, Input, 83, SpringLayout.NORTH, changeMember);
		changeMember.add(Input);
		Input.setColumns(10);

		OutputResult.setBackground(Color.GRAY);
		sl_changeMember.putConstraint(SpringLayout.NORTH, OutputResult, 6, SpringLayout.SOUTH, Input);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, OutputResult, 47, SpringLayout.SOUTH, Input);
		sl_changeMember.putConstraint(SpringLayout.EAST, OutputResult, 405, SpringLayout.WEST, changeMember);
		OutputResult.setHorizontalAlignment(SwingConstants.CENTER);
		OutputResult.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		changeMember.add(OutputResult);

		InputChange = new JTextField();
		InputChange.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_changeMember.putConstraint(SpringLayout.NORTH, InputChange, 6, SpringLayout.SOUTH, OutputResult);
		sl_changeMember.putConstraint(SpringLayout.WEST, InputChange, 0, SpringLayout.WEST, Input);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, InputChange, -21, SpringLayout.SOUTH, changeMember);
		sl_changeMember.putConstraint(SpringLayout.EAST, InputChange, -104, SpringLayout.EAST, changeMember);
		changeMember.add(InputChange);
		InputChange.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("\uC785\uB825 :");
		sl_changeMember.putConstraint(SpringLayout.NORTH, lblNewLabel_17, 53, SpringLayout.SOUTH, chooseNumberName);
		sl_changeMember.putConstraint(SpringLayout.WEST, lblNewLabel_17, 0, SpringLayout.WEST, changeMember);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, lblNewLabel_17, -21, SpringLayout.SOUTH, changeMember);
		sl_changeMember.putConstraint(SpringLayout.EAST, lblNewLabel_17, -6, SpringLayout.WEST, InputChange);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		changeMember.add(lblNewLabel_17);

		JButton btnNewButton_5 = new JButton("\uC218\uC815");// ¼öÁ¤¹öÆ° Å¬¸¯½Ã
		sl_changeMember.putConstraint(SpringLayout.NORTH, btnNewButton_5, 6, SpringLayout.SOUTH, OutputResult);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, btnNewButton_5, -21, SpringLayout.SOUTH, changeMember);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (breadName.equals(number[0])) { // ¹øÈ£ >> ÀÌ¸§
					for (int j = 0; j < OuputList.size(); j++) {
						if (Input.getText().equals(OuputList.get(j).getMember_phone())) {
							int count = mg.updateMember(Input.getText(), InputChange.getText(), Input.getText(),
									OuputList.get(j).getMember_name());
							
							//È¸¿ø¼öÁ¤ÆË¾÷!!
							zPopMemberUpdateGUI in = new zPopMemberUpdateGUI();
							in.main(null);
							frame.dispose();
							
						}
					}
				} else if (breadName.equals(number[1])) {// ÀÌ¸§ >> ¹øÈ£
					for (int j = 0; j < OuputList.size(); j++) {
						if (Input.getText().equals(OuputList.get(j).getMember_name())) {
							int count = mg.updateMember(InputChange.getText(), Input.getText(),
									OuputList.get(j).getMember_phone(), Input.getText());
						}
					}
				}
			}
		});
		btnNewButton_5.setBackground(new Color(139, 0, 0));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_changeMember.putConstraint(SpringLayout.WEST, btnNewButton_5, 6, SpringLayout.EAST, InputChange);
		sl_changeMember.putConstraint(SpringLayout.EAST, btnNewButton_5, 0, SpringLayout.EAST, Input);
		changeMember.add(btnNewButton_5);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255, 150));
		sl_changeMember.putConstraint(SpringLayout.WEST, panel_1, 6, SpringLayout.EAST, chooseNumberName);
		sl_changeMember.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, changeMember);
		// sl_changeMember.putConstraint(SpringLayout.SOUTH, chooseNumberName, 0,
		// SpringLayout.SOUTH, Input);
		sl_changeMember.putConstraint(SpringLayout.NORTH, panel_1, 36, SpringLayout.NORTH, changeMember);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, panel_1, 83, SpringLayout.NORTH, changeMember);
		changeMember.add(panel_1);
		changeMember.setVisible(false);

		// ¸â¹ö»èÁ¦
		JPanel deleteMember = new JPanel();
		deleteMember.setOpaque(false);
		deleteMember.setBackground(new Color(255, 255, 255, 100));
		// deleteMember.setOpaque(false);
		ImportCard.add(deleteMember, "name_8584683626980");
		SpringLayout sl_deleteMember = new SpringLayout();
		deleteMember.setLayout(sl_deleteMember);

		JLabel lblNewLabel_10 = new JLabel("- \uC0AD\uC81C");
		sl_deleteMember.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 0, SpringLayout.NORTH, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.WEST, lblNewLabel_10, 0, SpringLayout.WEST, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, lblNewLabel_10, 30, SpringLayout.NORTH, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.EAST, lblNewLabel_10, 63, SpringLayout.WEST, deleteMember);
		lblNewLabel_10.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		deleteMember.add(lblNewLabel_10);

		JComboBox comboBox = new JComboBox(number);
		comboBox.addActionListener(new ActionListener() { // ¹øÈ£/ÀÌ¸§ ¿É¼Ç¼±ÅÃ
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(comboBox)) {
					breadName = comboBox.getSelectedItem().toString();
				}
			}
		});
		// comboBox.setModel(new DefaultComboBoxModel(new String[] { "\uBC88\uD638",
		// "\uC774\uB984" }));
		comboBox.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_deleteMember.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.SOUTH, lblNewLabel_10);
		sl_deleteMember.putConstraint(SpringLayout.WEST, comboBox, 10, SpringLayout.WEST, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.EAST, comboBox, -333, SpringLayout.EAST, deleteMember);
		deleteMember.add(comboBox);

		JLabel OuputDelete = new JLabel("\uCD9C\uB825"); // Ãâ·Â ¶óº§

		InputValue = new JTextField(); // »èÁ¦ÇÒ ¹øÈ£ / ÀÌ¸§ ÀÔ·Â
		InputValue.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		InputValue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (breadName.equals(number[0])) {// breadName = ¹øÈ£
					for (int i = 0; i < new MemberInfoDAO().selectName(InputValue.getText()).size(); i++) {
						OuputList.add(new MemberInfoDAO().selectName(InputValue.getText()).get(i));
					}
					// OutList = new String[OuputList.size()];
					for (int j = 0; j < OuputList.size(); j++) {
						System.out.println("ÀÌ¸§ ¸®½ºÆ®" + OuputList.get(j).getMember_name());
						OuputDelete.setText(OuputList.get(j).getMember_name());
					}
				} else if (breadName.equals(number[1])) { // ÀÌ¸§ >> ¹øÈ£Ãâ·Â //breadName = ÀÌ¸§
					for (int i = 0; i < new MemberInfoDAO().selectPhone(InputValue.getText()).size(); i++) {
						OuputList.add(new MemberInfoDAO().selectPhone(InputValue.getText()).get(i));
					}
					// OutList = new String[OuputList.size()];
					for (int j = 0; j < OuputList.size(); j++) {
						System.out.println("¹øÈ£ ¸®½ºÆ®" + OuputList.get(j).getMember_phone());
						OuputDelete.setText(OuputList.get(j).getMember_phone());
					}
				}
			}
		});

		sl_deleteMember.putConstraint(SpringLayout.NORTH, InputValue, 36, SpringLayout.NORTH, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.WEST, InputValue, 6, SpringLayout.EAST, comboBox);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, InputValue, -123, SpringLayout.SOUTH, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.EAST, InputValue, -10, SpringLayout.EAST, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, comboBox, 0, SpringLayout.SOUTH, InputValue);
		deleteMember.add(InputValue);
		InputValue.setColumns(10);

		JButton deleteButton = new JButton("\uC0AD\uC81C");
		sl_deleteMember.putConstraint(SpringLayout.NORTH, deleteButton, 59, SpringLayout.SOUTH, InputValue);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, deleteButton, -17, SpringLayout.SOUTH, deleteMember);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (breadName.equals(number[0])) {// ¹øÈ£ >> ÀÌ¸§
					for (int j = 0; j < OuputList.size(); j++) {
						if (InputValue.getText().equals(OuputList.get(j).getMember_phone())) {
							int count = mg.deleteMember(OuputList.get(j).getMember_name(), InputValue.getText());
						}
					}
				} else if (breadName.equals(number[1])) {// ÀÌ¸§ >> ¹øÈ£
					for (int j = 0; j < OuputList.size(); j++) {
						if (InputValue.getText().equals(OuputList.get(j).getMember_name())) {
							int count = mg.deleteMember(InputValue.getText(), OuputList.get(j).getMember_phone());
						}
					}
				}
				//È¸¿ø»èÁ¦ÆË¾÷!!
				zPopMemberDeleteGUI in = new zPopMemberDeleteGUI();
				in.main(null);
				frame.dispose();
				
			}
		});
		sl_deleteMember.putConstraint(SpringLayout.WEST, deleteButton, 327, SpringLayout.WEST, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.EAST, deleteButton, -10, SpringLayout.EAST, deleteMember);
		deleteButton.setBackground(new Color(139, 0, 0));
		deleteButton.setForeground(new Color(255, 255, 255));
		deleteButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		deleteMember.add(deleteButton);

		OuputDelete.setHorizontalAlignment(SwingConstants.CENTER);
		sl_deleteMember.putConstraint(SpringLayout.NORTH, OuputDelete, 6, SpringLayout.SOUTH, InputValue);
		sl_deleteMember.putConstraint(SpringLayout.WEST, OuputDelete, 0, SpringLayout.WEST, InputValue);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, OuputDelete, 51, SpringLayout.SOUTH, InputValue);
		sl_deleteMember.putConstraint(SpringLayout.EAST, OuputDelete, 0, SpringLayout.EAST, InputValue);
		OuputDelete.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		deleteMember.add(OuputDelete);
		deleteMember.setVisible(false);

		// È¸¿ø°ü¸® ¹öÆ°
		// ¸¸¾à ¹öÆ°À» ´©¸£¸é ½ÇÇàµÉ ÆÇ³Ú ³ªÅ¸³»±â
		JButton addMemberButton = new JButton("\uB4F1\uB85D");
		addMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// ¹öÆ°Å¬¸¯½Ã ¸â¹ö º¯¼ö °ª1 µî·Ï
				deleteMember.setVisible(false);
				changeMember.setVisible(false);
				addMember.setVisible(true);

			}
		});
		addMemberButton.setForeground(new Color(255, 255, 255));
		addMemberButton.setBackground(new Color(139, 0, 0));
		addMemberButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		buttonManage.add(addMemberButton);

		JButton changeMemberButton = new JButton("\uC218\uC815");
		changeMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ¹öÆ°Å¬¸¯½Ã ¸â¹ö º¯¼ö °ª2 ¼öÁ¤
				deleteMember.setVisible(false);
				changeMember.setVisible(true);
				addMember.setVisible(false);

			}
		});
		changeMemberButton.setForeground(new Color(255, 255, 255));
		changeMemberButton.setBackground(new Color(139, 0, 0));
		changeMemberButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		buttonManage.add(changeMemberButton);

		JButton deleteMemberButton = new JButton("\uC0AD\uC81C");
		deleteMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ¹öÆ°Å¬¸¯½Ã ¸â¹ö º¯¼ö °ª3 »èÁ¦
				deleteMember.setVisible(true);
				changeMember.setVisible(false);
				addMember.setVisible(false);

			}
		});
		deleteMemberButton.setForeground(new Color(255, 255, 255));
		deleteMemberButton.setBackground(new Color(139, 0, 0));
		deleteMemberButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		buttonManage.add(deleteMemberButton);

		JLabel lblNewLabel_8 = new JLabel("<\uD68C\uC6D0 \uAD00\uB9AC>");
		sl_MemberInfo.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 10, SpringLayout.NORTH, MemberInfo);
		sl_MemberInfo.putConstraint(SpringLayout.WEST, lblNewLabel_8, 164, SpringLayout.WEST, MemberInfo);
		lblNewLabel_8.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		MemberInfo.add(lblNewLabel_8);
		
		JPanel logopanel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/logo.png"));
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
		sl_MemberInfo.putConstraint(SpringLayout.NORTH, logopanel, 0, SpringLayout.NORTH, lblNewLabel_8);
		sl_MemberInfo.putConstraint(SpringLayout.WEST, logopanel, 133, SpringLayout.WEST, lblNewLabel_8);
		sl_MemberInfo.putConstraint(SpringLayout.SOUTH, logopanel, -6, SpringLayout.NORTH, MemebrManage);
		sl_MemberInfo.putConstraint(SpringLayout.EAST, logopanel, -10, SpringLayout.EAST, MemberInfo);
		MemberInfo.add(logopanel);

		MemberInfo.setVisible(false);

		// ÁöÁ¡Á¤º¸ ¼öÁ¤ ÆÇ³Ú
		JPanel changeInfoPanel = new JPanel();
		changeInfoPanel.setBackground(new Color(255, 255, 255, 100));
		// changeInfoPanel.setOpaque(false);
		importantPanel.add(changeInfoPanel, "name_1524942935296");
		SpringLayout sl_changeInfoPanel = new SpringLayout();
		changeInfoPanel.setLayout(sl_changeInfoPanel);

		JPanel changeInfoComponents = new JPanel();
		changeInfoComponents.setBackground(new Color(255, 255, 255, 0));
		changeInfoComponents.setOpaque(false);
		sl_changeInfoPanel.putConstraint(SpringLayout.NORTH, changeInfoComponents, 67, SpringLayout.NORTH,
				changeInfoPanel);
		sl_changeInfoPanel.putConstraint(SpringLayout.WEST, changeInfoComponents, 29, SpringLayout.WEST,
				changeInfoPanel);
		sl_changeInfoPanel.putConstraint(SpringLayout.SOUTH, changeInfoComponents, -34, SpringLayout.SOUTH,
				changeInfoPanel);
		sl_changeInfoPanel.putConstraint(SpringLayout.EAST, changeInfoComponents, 424, SpringLayout.WEST,
				changeInfoPanel);
		changeInfoPanel.add(changeInfoComponents);
		SpringLayout sl_changeInfoComponents = new SpringLayout();
		changeInfoComponents.setLayout(sl_changeInfoComponents);

		JLabel lblNewLabel_7 = new JLabel("\uC544\uC774\uB514 :");
		lblNewLabel_7.setBackground(Color.WHITE);
		// lblNewLabel_7.setOpaque(false);
		sl_changeInfoComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 0, SpringLayout.NORTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.WEST, lblNewLabel_7, 0, SpringLayout.WEST,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, -197, SpringLayout.SOUTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.EAST, lblNewLabel_7, -302, SpringLayout.EAST,
				changeInfoComponents);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		changeInfoComponents.add(lblNewLabel_7);

		JPanel Inputpw = new JPanel();
		sl_changeInfoComponents.putConstraint(SpringLayout.NORTH, Inputpw, 100, SpringLayout.NORTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.WEST, Inputpw, 6, SpringLayout.EAST, lblNewLabel_7);
		sl_changeInfoComponents.putConstraint(SpringLayout.SOUTH, Inputpw, -103, SpringLayout.SOUTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.EAST, Inputpw, -10, SpringLayout.EAST, changeInfoComponents);
		Inputpw.setBackground(new Color(255, 255, 255, 100));
		// Inputpw.setOpaque(false);
		changeInfoComponents.add(Inputpw);
		SpringLayout sl_Inputpw = new SpringLayout();
		Inputpw.setLayout(sl_Inputpw);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_Inputpw.putConstraint(SpringLayout.SOUTH, textField_3, 0, SpringLayout.SOUTH, Inputpw);
		sl_Inputpw.putConstraint(SpringLayout.EAST, textField_3, 286, SpringLayout.WEST, Inputpw);
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		// textField_3.setOpaque(false);
		sl_Inputpw.putConstraint(SpringLayout.NORTH, textField_3, 0, SpringLayout.NORTH, Inputpw);
		sl_Inputpw.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, Inputpw);
		Inputpw.add(textField_3);
		textField_3.setColumns(10);

		JLabel OutputId = new JLabel("\uC544\uC774\uB514 \uCD9C\uB825");
		String ID = new OfficeDAO().select_office().get(office_num).getOffice_ID();
		OutputId.setText(ID);
		sl_changeInfoComponents.putConstraint(SpringLayout.WEST, OutputId, 6, SpringLayout.EAST, lblNewLabel_7);
		sl_changeInfoComponents.putConstraint(SpringLayout.EAST, OutputId, 0, SpringLayout.EAST, changeInfoComponents);
		OutputId.setBackground(new Color(0, 0, 0, 100));
		OutputId.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		OutputId.setHorizontalAlignment(SwingConstants.CENTER);
		// lblNewLabel_8.setOpaque(false);
		sl_changeInfoComponents.putConstraint(SpringLayout.NORTH, OutputId, 0, SpringLayout.NORTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.SOUTH, OutputId, 55, SpringLayout.NORTH,
				changeInfoComponents);
		changeInfoComponents.add(OutputId);

		JLabel lblNewLabel_9 = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		sl_changeInfoComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 45, SpringLayout.SOUTH, lblNewLabel_7);
		sl_changeInfoComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, -103, SpringLayout.SOUTH, changeInfoComponents);
		lblNewLabel_9.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		sl_changeInfoComponents.putConstraint(SpringLayout.WEST, lblNewLabel_9, 0, SpringLayout.WEST, lblNewLabel_7);
		sl_changeInfoComponents.putConstraint(SpringLayout.EAST, lblNewLabel_9, 0, SpringLayout.EAST, lblNewLabel_7);
		changeInfoComponents.add(lblNewLabel_9);

		JButton btnNewButton_2 = new JButton("\uC218\uC815");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int count = mg.modifyOffice(textField_3.getText(), ID, new OfficeDAO().select_office().get(office_num).getOffice_num());				
				//ÁöÁ¡Á¤º¸¼öÁ¤ÆË¾÷!!
				zPopOfficeUpdateGUI in = new zPopOfficeUpdateGUI();
				in.main(null);
				frame.dispose();
			}
		});
		sl_changeInfoComponents.putConstraint(SpringLayout.NORTH, btnNewButton_2, 32, SpringLayout.SOUTH, Inputpw);
		sl_changeInfoComponents.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -29, SpringLayout.SOUTH, changeInfoComponents);
		btnNewButton_2.setBackground(new Color(210, 105, 30));
		sl_changeInfoComponents.putConstraint(SpringLayout.WEST, btnNewButton_2, -130, SpringLayout.EAST,
				changeInfoComponents);

		btnNewButton_2.setForeground(Color.WHITE);
		sl_changeInfoComponents.putConstraint(SpringLayout.EAST, btnNewButton_2, -21, SpringLayout.EAST,
				changeInfoComponents);
		btnNewButton_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		changeInfoComponents.add(btnNewButton_2);

		JLabel lblNewLabel_11 = new JLabel("<\uC9C0\uC810 \uC815\uBCF4 \uC218\uC815>");
		sl_changeInfoPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 10, SpringLayout.NORTH, changeInfoPanel);
		sl_changeInfoPanel.putConstraint(SpringLayout.EAST, lblNewLabel_11, -144, SpringLayout.EAST, changeInfoPanel);
		lblNewLabel_11.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setOpaque(false);
		changeInfoPanel.add(lblNewLabel_11);

		changeInfoPanel.setVisible(false);

		// »§ÀÌ¸§ ¸®½ºÆ® »ý¼º
		breadNameList = new ArrayList<>();
		for (int i = 0; i < new BreadInfoDAO().select_bread().size(); i++) {
			breadNameList.add(new BreadInfoDAO().select_bread().get(i).getName());
		}
		
		

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
		InputBreadName.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, InputBreadName, 0, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, InputBreadName, 47, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, InputBreadName, -10, SpringLayout.EAST,
				addMenuComponents);
		InputBreadName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				breadName = InputBreadName.getText();
				for (int i = 0; i < breadNameList.size(); i++) {
					if (breadName != breadNameList.get(i)) {
						breadNameList.add(breadName);
					}
				}
			}
		});
		addMenuComponents.add(InputBreadName);
		InputBreadName.setColumns(10);

		InputBreadPrice = new JTextField();
		InputBreadPrice.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		InputBreadPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				breadPrice = Integer.parseInt(InputBreadPrice.getText());
			}
		});
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, InputBreadPrice, -47, SpringLayout.SOUTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, InputBreadPrice, 0, SpringLayout.SOUTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, InputBreadPrice, -10, SpringLayout.EAST,
				addMenuComponents);
		addMenuComponents.add(InputBreadPrice);
		InputBreadPrice.setColumns(10);

		JLabel BreadNameLabel = new JLabel("\uBE75\uC774\uB984 :");
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, BreadNameLabel, 0, SpringLayout.WEST, addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, BreadNameLabel, -276, SpringLayout.EAST,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, InputBreadName, 6, SpringLayout.EAST, BreadNameLabel);
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, BreadNameLabel, 0, SpringLayout.NORTH,
				addMenuComponents);
		BreadNameLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		BreadNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMenuComponents.add(BreadNameLabel);

		JLabel BreadTypeLabel = new JLabel("\uBE75\uC885\uB958 :");
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, BreadTypeLabel, 81, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, BreadTypeLabel, -276, SpringLayout.EAST,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, BreadNameLabel, -31, SpringLayout.NORTH, BreadTypeLabel);
		BreadTypeLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		BreadTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, BreadTypeLabel, 0, SpringLayout.WEST, BreadNameLabel);
		addMenuComponents.add(BreadTypeLabel);

		JLabel BreadPriceLabel = new JLabel("\uAC00\uACA9 :");
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, BreadPriceLabel, 161, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, BreadPriceLabel, 0, SpringLayout.WEST, addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, BreadPriceLabel, 0, SpringLayout.SOUTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, BreadPriceLabel, -276, SpringLayout.EAST,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, InputBreadPrice, 6, SpringLayout.EAST, BreadPriceLabel);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, BreadTypeLabel, -30, SpringLayout.NORTH,
				BreadPriceLabel);
		BreadPriceLabel.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		BreadPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
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

		// »§Á¾·ù ¼±ÅÃ
		JComboBox comboBox_1 = new JComboBox(breadType);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, comboBox_1, -3, SpringLayout.SOUTH, BreadTypeLabel);
		comboBox_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(comboBox_1)) {
					breadTypeChoice = comboBox_1.getSelectedItem().toString();
				}
			}
		});
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, comboBox_1, 34, SpringLayout.SOUTH, InputBreadName);
		sl_addMenuComponents.putConstraint(SpringLayout.WEST, comboBox_1, 6, SpringLayout.EAST, BreadTypeLabel);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, comboBox_1, -10, SpringLayout.EAST, addMenuComponents);
		addMenuComponents.add(comboBox_1);

		JButton btnNewButton = new JButton("\uCD94\uAC00");
		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, btnNewButton, 20, SpringLayout.SOUTH, addMenuComponents);
		sl_addMenuPanel.putConstraint(SpringLayout.WEST, btnNewButton, -126, SpringLayout.EAST, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, btnNewButton, -25, SpringLayout.SOUTH, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.EAST, btnNewButton, -27, SpringLayout.EAST, addMenuPanel);
		addMenuPanel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = mg.plusBread(InputBreadName.getText(), breadTypeChoice, breadPrice);
//				System.out.println(breadName + " " + breadTypeChoice + " " + breadPrice + count);
//				for (int j = 0; j < breadNameList.size(); j++) {
//					if (breadName.equals(breadNameList.get(j))) {
//						breadNameList.add(breadName);
//					}
//				}
				//¸Þ´ºÃß°¡ÆË¾÷!!
				zPopBreadInputGUI up = new zPopBreadInputGUI();
				up.main(null);
				frame.dispose();
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(210, 105, 30));
		btnNewButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		addMenuPanel.setVisible(false); // ¾Èº¸ÀÌ°Ô ÇÔ
		
		

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

		JLabel lblNewLabel_6 = new JLabel("\uBE75\uC774\uB984 :");
		sl_deletMenucomponents.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH,
				deletMenucomponents);
		sl_deletMenucomponents.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST,
				deletMenucomponents);
		sl_deletMenucomponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -107, SpringLayout.SOUTH,
				deletMenucomponents);
		sl_deletMenucomponents.putConstraint(SpringLayout.EAST, lblNewLabel_6, -251, SpringLayout.EAST,
				deletMenucomponents);

		JComboBox breadNameComboBox = new JComboBox(breadNameList.toArray());
		breadNameComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(breadNameComboBox)) {
					breadName = breadNameComboBox.getSelectedItem().toString();
				}
			}
		});
		breadNameComboBox.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_deletMenucomponents.putConstraint(SpringLayout.NORTH, breadNameComboBox, -39, SpringLayout.SOUTH,
				lblNewLabel_6);
		sl_deletMenucomponents.putConstraint(SpringLayout.WEST, breadNameComboBox, 6, SpringLayout.EAST, lblNewLabel_6);
		sl_deletMenucomponents.putConstraint(SpringLayout.SOUTH, breadNameComboBox, 0, SpringLayout.SOUTH,
				lblNewLabel_6);
		sl_deletMenucomponents.putConstraint(SpringLayout.EAST, breadNameComboBox, 241, SpringLayout.EAST,
				lblNewLabel_6);
		deletMenucomponents.add(breadNameComboBox);
		lblNewLabel_6.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		deletMenucomponents.add(lblNewLabel_6);

		JButton btnNewButton_1 = new JButton("\uC0AD\uC81C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < breadNameList.size(); i++) {
					if (breadName.equals(breadNameList.get(i))) {
						int count = mg.deleteBread(breadName);
						System.out.println(breadName + " " + count);
					}
				}
			
			//¸Þ´º»èÁ¦ÆË¾÷!!
			zPopBreadDeleteGUI in = new zPopBreadDeleteGUI();
			in.main(null);
			frame.dispose();
			}
			
		});
		sl_deleteMenuPanel.putConstraint(SpringLayout.WEST, btnNewButton_1, -133, SpringLayout.EAST, deleteMenuPanel);
		btnNewButton_1.setBackground(new Color(210, 105, 30));
		btnNewButton_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		btnNewButton_1.setForeground(Color.WHITE);
		sl_deleteMenuPanel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 22, SpringLayout.SOUTH,
				deletMenucomponents);
		sl_deleteMenuPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 65, SpringLayout.SOUTH,
				deletMenucomponents);

		// »èÁ¦ÄÞº¸

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

		JComboBox BreadNameCombo = new JComboBox(breadNameList.toArray());//breadNameList.toArray()
		BreadNameCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(BreadNameCombo)) {
					breadName = BreadNameCombo.getSelectedItem().toString();
				}
			}
		});

		InputChangeBreadPrice = new JTextField();
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, InputChangeBreadPrice, -21, SpringLayout.SOUTH, changeMenuComponents);
		InputChangeBreadPrice.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, InputChangeBreadPrice, 107, SpringLayout.WEST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, InputChangeBreadPrice, -10, SpringLayout.EAST,
				changeMenuComponents);
		changeMenuComponents.add(InputChangeBreadPrice);
		InputChangeBreadPrice.setColumns(10);
		lblNewLabel_1.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		changeMenuPanel.add(lblNewLabel_1);

		JComboBox BreadTypeCombo = new JComboBox(breadType);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, BreadTypeCombo, -98, SpringLayout.SOUTH, changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, InputChangeBreadPrice, 32, SpringLayout.SOUTH, BreadTypeCombo);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, BreadTypeCombo, 34, SpringLayout.SOUTH, BreadNameCombo);
		BreadTypeCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(BreadTypeCombo)) {
					breadTypeChoice = BreadTypeCombo.getSelectedItem().toString();
				}
			}
		});
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, BreadTypeCombo, 107, SpringLayout.WEST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, BreadTypeCombo, -157, SpringLayout.EAST,
				changeMenuComponents);
		BreadTypeCombo.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 24));
		changeMenuComponents.add(BreadTypeCombo);

		// ¸Þ´º ¼öÁ¤ ¼ö½Ä
		JButton ChangeButton = new JButton("\uC218\uC815");
		ChangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < breadNameList.size(); i++) {
					if (breadName.equals(breadNameList.get(i))) {
						int count = mg.modifyBread(breadName, breadTypeChoice,
								Integer.parseInt(InputChangeBreadPrice.getText()));
						System.out.println(breadName + " " + breadTypeChoice + " "
								+ Integer.parseInt(InputChangeBreadPrice.getText()) + " " + count);
					}
				}
				//¸Þ´º¼öÁ¤ÆË¾÷!!!
				zPopBreadUpdateGUI in = new zPopBreadUpdateGUI();
				in.main(null);
				frame.dispose();
			}
			
		});
		sl_changeMenuPanel.putConstraint(SpringLayout.WEST, ChangeButton, -123, SpringLayout.EAST, changeMenuPanel);
		ChangeButton.setBackground(new Color(210, 105, 30));
		ChangeButton.setForeground(new Color(255, 255, 255));
		ChangeButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 20));
		sl_changeMenuPanel.putConstraint(SpringLayout.NORTH, ChangeButton, 16, SpringLayout.SOUTH,
				changeMenuComponents);
		sl_changeMenuPanel.putConstraint(SpringLayout.SOUTH, ChangeButton, 56, SpringLayout.SOUTH,
				changeMenuComponents);

		JLabel lblNewLabel_4 = new JLabel("\uC218\uC815 \uAC00\uACA9 :");
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -21, SpringLayout.SOUTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, lblNewLabel_4, -6, SpringLayout.WEST, InputChangeBreadPrice);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 150, SpringLayout.NORTH,
				changeMenuComponents);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		lblNewLabel_4.setEnabled(true);
		changeMenuComponents.add(lblNewLabel_4);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, BreadNameCombo, 107, SpringLayout.WEST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, BreadNameCombo, -109, SpringLayout.EAST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, BreadNameCombo, 10, SpringLayout.NORTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, BreadNameCombo, -169, SpringLayout.SOUTH,
				changeMenuComponents);
		BreadNameCombo.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 24));
		changeMenuComponents.add(BreadNameCombo);

		JLabel label = new JLabel("\uC218\uC815 \uD0C0\uC785 :");
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, label, -32, SpringLayout.NORTH, lblNewLabel_4);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		changeMenuComponents.add(label);

		JLabel lblNewLabel_2 = new JLabel("\uBE75\uC774\uB984 :");
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, lblNewLabel_2, -6, SpringLayout.WEST, BreadNameCombo);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, label, 41, SpringLayout.SOUTH, lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 26));
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, BreadNameCombo);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, BreadNameCombo);
		changeMenuComponents.add(lblNewLabel_2);
		sl_changeMenuPanel.putConstraint(SpringLayout.EAST, ChangeButton, -30, SpringLayout.EAST, changeMenuPanel);
		changeMenuPanel.add(ChangeButton);
		changeMenuPanel.setVisible(false);// ¸Þ´º¼öÁ¤¾Èº¸ÀÌ°Ô

		panel.add(ButtonPanel);

		ButtonPanel.setLayout(new GridLayout(2, 3, 10, 10));

		// ¸Þ´ºÃß°¡
		
		JButton addMenu = new JButton(new ImageIcon("./image/ButtonFolder/°ü¸®¸Þ´ºÃß°¡.png"));

		addMenu.setBorderPainted(false);
		addMenu.setFocusPainted(false);
		
		addMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMenuPanel.setVisible(true);
				changeMenuPanel.setVisible(false);
				deleteMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(false);
				MemberInfo.setVisible(false);
				StartPanel.setVisible(false);

			}
		});
		addMenu.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		addMenu.setForeground(Color.WHITE);
		addMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(addMenu);

		// ¸Þ´º¼öÁ¤
		JButton changeMenu = new JButton(new ImageIcon("./image/ButtonFolder/°ü¸®¸Þ´º¼öÁ¤.png"));
		changeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(true);
				deleteMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(false);
				MemberInfo.setVisible(false);
				StartPanel.setVisible(false);

			}
		});

		changeMenu.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		changeMenu.setForeground(Color.WHITE);
		changeMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(changeMenu);

		// ¸Þ´º»èÁ¦
		JButton deleMenu = new JButton(new ImageIcon("./image/ButtonFolder/°ü¸®¸Þ´º»èÁ¦.png"));
		deleMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMenuPanel.setVisible(true);
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(false);
				MemberInfo.setVisible(false);
				StartPanel.setVisible(false);
			}
		});

		deleMenu.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		deleMenu.setForeground(Color.WHITE);
		deleMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(deleMenu);

		// ÁöÁ¡Á¤º¸º¯°æ
		JButton changeInfo = new JButton(new ImageIcon("./image/ButtonFolder/°ü¸®ÁöÁ¡Á¤º¸¼öÁ¤.png"));
		changeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMenuPanel.setVisible(false);
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(true);
				MemberInfo.setVisible(false);
				StartPanel.setVisible(false);
			}
		});

		changeInfo.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		changeInfo.setForeground(Color.WHITE);
		changeInfo.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(changeInfo);

		// È¸¿ø°ü¸®
		JButton controllMember = new JButton(new ImageIcon("./image/ButtonFolder/°ü¸®È¸¿ø°ü¸®.png"));
		controllMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteMenuPanel.setVisible(false);
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(false);
				MemberInfo.setVisible(true);
				StartPanel.setVisible(false);

			}
		});

		controllMember.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.BOLD, 23));
		controllMember.setForeground(Color.WHITE);
		controllMember.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(controllMember);

		// Á¾·á
		JButton close = new JButton(new ImageIcon("./image/ButtonFolder/°ü¸®Á¾·á.png"));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

	public void sendOfficeNum(int office_num) {
		this.office_num = office_num;
	}
}
