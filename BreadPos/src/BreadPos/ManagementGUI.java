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
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DB.BreadInfoDAO;
import DB.Member;
import DB.MemberInfoDAO;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ManagementGUI {

	public JFrame frame;
	private MyCllickListener myCllickListener;
	private int choice; // �ؿ� �޴� Ŭ���� �߻��ϴ� ����
	private BufferedImage icon;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField InputBreadName;
	private JTextField InputBreadPrice;
	private JTextField InputChangeBreadPrice;
	private JTextField textField_3;
	private int memberChoice = 0; // ȸ������ ���,����, ���� ����
	private JTextField phoneNumInput;
	private JTextField nameInput;
	private JTextField Input;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	Management mg = new Management();
	String breadName;
	String[] breadType = { "�а���", "����", "������", "ȣ��", "ȥ��", "��Ÿ" };
	String breadTypeChoice;
	int breadPrice;
	String memberName;
	String memberPhoneNumber;
	int memberMoney;
	int check;
	ArrayList<String> breadNameList;
	ArrayList<Member> OuputList = new ArrayList<>(); //���
	String Ouput; //���
	

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
					Dimension d = getSize();// ��üȭ��
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

		// ���̸� ����Ʈ ����
		breadNameList = new ArrayList<>();
		for (int i = 0; i < new BreadInfoDAO().select_bread().size(); i++) {
			breadNameList.add(new BreadInfoDAO().select_bread().get(i).getName());
		}

		JPanel importantPanel = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, importantPanel, 363, SpringLayout.NORTH, panel);
		importantPanel.setForeground(new Color(255, 255, 255, 100));
		importantPanel.setOpaque(false);
		sl_panel.putConstraint(SpringLayout.NORTH, importantPanel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, importantPanel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, importantPanel, 465, SpringLayout.WEST, panel);
		panel.add(importantPanel);

		// �ؿ� ��ư��� �ǳ�
		JPanel ButtonPanel = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, ButtonPanel, 17, SpringLayout.SOUTH, importantPanel);
		sl_panel.putConstraint(SpringLayout.WEST, ButtonPanel, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, ButtonPanel, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, ButtonPanel, -10, SpringLayout.EAST, panel);
		ButtonPanel.setBackground(new Color(255, 255, 255, 0));
		importantPanel.setLayout(new CardLayout(0, 0));

		// ȸ������ �ǳ�
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

		// ȸ������ �ǳ�>>ȸ������ �г�
		JPanel ImportCard = new JPanel();
		ImportCard.setBackground(new Color(255, 255, 255, 100));
		ImportCard.setOpaque(false);
		sl_MemebrManage.putConstraint(SpringLayout.NORTH, ImportCard, 6, SpringLayout.SOUTH, buttonManage);
		sl_MemebrManage.putConstraint(SpringLayout.WEST, ImportCard, 0, SpringLayout.WEST, buttonManage);
		sl_MemebrManage.putConstraint(SpringLayout.SOUTH, ImportCard, 210, SpringLayout.SOUTH, buttonManage);
		sl_MemebrManage.putConstraint(SpringLayout.EAST, ImportCard, 0, SpringLayout.EAST, buttonManage);
		MemebrManage.add(ImportCard);
		ImportCard.setLayout(new CardLayout(0, 0));

		// ����߰�
		JPanel addMember = new JPanel();
		addMember.setBackground(new Color(255, 255, 255, 100));
		// addMember.setOpaque(false);
		ImportCard.add(addMember, "name_8523663693515");
		SpringLayout sl_addMember = new SpringLayout();
		addMember.setLayout(sl_addMember);

		JLabel lblNewLabel_13 = new JLabel("- \uB4F1\uB85D");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		sl_addMember.putConstraint(SpringLayout.NORTH, lblNewLabel_13, 0, SpringLayout.NORTH, addMember);
		sl_addMember.putConstraint(SpringLayout.WEST, lblNewLabel_13, 0, SpringLayout.WEST, addMember);
		addMember.add(lblNewLabel_13);

		phoneNumInput = new JTextField();
		sl_addMember.putConstraint(SpringLayout.NORTH, phoneNumInput, 37, SpringLayout.NORTH, addMember);
		sl_addMember.putConstraint(SpringLayout.WEST, phoneNumInput, -337, SpringLayout.EAST, addMember);
		sl_addMember.putConstraint(SpringLayout.SOUTH, phoneNumInput, 89, SpringLayout.NORTH, addMember);
		sl_addMember.putConstraint(SpringLayout.EAST, phoneNumInput, -10, SpringLayout.EAST, addMember);
		addMember.add(phoneNumInput);
		phoneNumInput.setColumns(10);

		nameInput = new JTextField();
		sl_addMember.putConstraint(SpringLayout.NORTH, nameInput, 16, SpringLayout.SOUTH, phoneNumInput);
		sl_addMember.putConstraint(SpringLayout.EAST, nameInput, -10, SpringLayout.EAST, addMember);
		addMember.add(nameInput);
		nameInput.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("\uBC88\uD638 :");
		sl_addMember.putConstraint(SpringLayout.NORTH, lblNewLabel_14, 6, SpringLayout.SOUTH, lblNewLabel_13);
		sl_addMember.putConstraint(SpringLayout.WEST, lblNewLabel_14, 0, SpringLayout.WEST, addMember);
		sl_addMember.putConstraint(SpringLayout.EAST, lblNewLabel_14, -6, SpringLayout.WEST, phoneNumInput);
		lblNewLabel_14.setFont(new Font("�����ձ۾� ��", Font.BOLD, 28));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		addMember.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("\uC774\uB984 :");
		sl_addMember.putConstraint(SpringLayout.NORTH, lblNewLabel_15, 105, SpringLayout.NORTH, addMember);
		sl_addMember.putConstraint(SpringLayout.SOUTH, lblNewLabel_15, -47, SpringLayout.SOUTH, addMember);
		sl_addMember.putConstraint(SpringLayout.EAST, lblNewLabel_15, -343, SpringLayout.EAST, addMember);
		sl_addMember.putConstraint(SpringLayout.SOUTH, lblNewLabel_14, -16, SpringLayout.NORTH, lblNewLabel_15);
		sl_addMember.putConstraint(SpringLayout.WEST, nameInput, 6, SpringLayout.EAST, lblNewLabel_15);
		lblNewLabel_15.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		sl_addMember.putConstraint(SpringLayout.WEST, lblNewLabel_15, 0, SpringLayout.WEST, addMember);
		addMember.add(lblNewLabel_15);

		JButton btnNewButton_3 = new JButton("\uB4F1\uB85D");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = mg.addMember(phoneNumInput.getText(), nameInput.getText());
			}
		});
		sl_addMember.putConstraint(SpringLayout.SOUTH, nameInput, -10, SpringLayout.NORTH, btnNewButton_3);
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		sl_addMember.putConstraint(SpringLayout.WEST, btnNewButton_3, -84, SpringLayout.EAST, addMember);
		sl_addMember.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -4, SpringLayout.SOUTH, addMember);
		sl_addMember.putConstraint(SpringLayout.EAST, btnNewButton_3, 0, SpringLayout.EAST, addMember);
		btnNewButton_3.setFont(new Font("�����ձ۾� ��", Font.BOLD, 20));
		btnNewButton_3.setBackground(new Color(139, 0, 0));
		addMember.add(btnNewButton_3);
		addMember.setVisible(false);

		// �������
		JPanel changeMember = new JPanel();
		changeMember.setBackground(new Color(255, 255, 255, 100));
		// changeMember.setOpaque(false);
		ImportCard.add(changeMember, "name_8555461592377");
		SpringLayout sl_changeMember = new SpringLayout();
		changeMember.setLayout(sl_changeMember);

		JLabel lblNewLabel_12 = new JLabel("- \uC218\uC815");
		lblNewLabel_12.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		sl_changeMember.putConstraint(SpringLayout.NORTH, lblNewLabel_12, 0, SpringLayout.NORTH, changeMember);
		sl_changeMember.putConstraint(SpringLayout.WEST, lblNewLabel_12, 0, SpringLayout.WEST, changeMember);
		changeMember.add(lblNewLabel_12);

		String[] number = { "��ȣ", "�̸�" };
		// ��ȣ ���ý� �̸� ���
		JComboBox chooseNumberName = new JComboBox(number);
		chooseNumberName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(chooseNumberName)) {
					breadName = chooseNumberName.getSelectedItem().toString();
					
				}
			}
		});
		chooseNumberName.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		sl_changeMember.putConstraint(SpringLayout.NORTH, chooseNumberName, 6, SpringLayout.SOUTH, lblNewLabel_12);
		sl_changeMember.putConstraint(SpringLayout.WEST, chooseNumberName, 10, SpringLayout.WEST, changeMember);
		sl_changeMember.putConstraint(SpringLayout.EAST, chooseNumberName, 84, SpringLayout.WEST, changeMember);
		changeMember.add(chooseNumberName);

		

		Input = new JTextField();
		sl_changeMember.putConstraint(SpringLayout.WEST, Input, 6, SpringLayout.EAST, chooseNumberName);
		sl_changeMember.putConstraint(SpringLayout.EAST, Input, -10, SpringLayout.EAST, changeMember);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, chooseNumberName, 0, SpringLayout.SOUTH, Input);
		sl_changeMember.putConstraint(SpringLayout.NORTH, Input, 36, SpringLayout.NORTH, changeMember);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, Input, 83, SpringLayout.NORTH, changeMember);
		changeMember.add(Input);
		Input.setColumns(10);
		
		// ��ȣ >> �̸� ���
		if (breadName.equals(number[0])) { // breadName = ��ȣ
		
		OuputList = new MemberInfoDAO().selectName(Input.getText());
				
		} else if (breadName.equals(number[1])) { //�̸� >> ��ȣ��� //breadName = �̸�
			OuputList = new MemberInfoDAO().selectPhone(Input.getText());
		}

		
		JLabel OutputResult = new JLabel("\uCD9C\uB825");
		OutputResult.setBackground(new Color(255, 255, 255));
		sl_changeMember.putConstraint(SpringLayout.NORTH, OutputResult, 6, SpringLayout.SOUTH, Input);
		sl_changeMember.putConstraint(SpringLayout.WEST, OutputResult, 10, SpringLayout.WEST, changeMember);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, OutputResult, 47, SpringLayout.SOUTH, Input);
		sl_changeMember.putConstraint(SpringLayout.EAST, OutputResult, 405, SpringLayout.WEST, changeMember);
		OutputResult.setHorizontalAlignment(SwingConstants.CENTER);
		OutputResult.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		changeMember.add(OutputResult);
		for (int i = 0; i < OuputList.size(); i++) {
			if(Input.getText().equals(OuputList.get(i).getMember_phone())) {// ��ȣ >> �̸�
				OutputResult.setText(OuputList.get(i).getMember_name());
			}else if (Input.getText().equals(OuputList.get(i).getMember_name())) {// �̸� >> ��ȣ
				OutputResult.setText(OuputList.get(i).getMember_phone());
			}
		}

		textField_5 = new JTextField();
		sl_changeMember.putConstraint(SpringLayout.NORTH, textField_5, 6, SpringLayout.SOUTH, OutputResult);
		sl_changeMember.putConstraint(SpringLayout.WEST, textField_5, 0, SpringLayout.WEST, Input);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, textField_5, 53, SpringLayout.SOUTH, OutputResult);
		sl_changeMember.putConstraint(SpringLayout.EAST, textField_5, -104, SpringLayout.EAST, changeMember);
		changeMember.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("\uC785\uB825 :");
		sl_changeMember.putConstraint(SpringLayout.NORTH, lblNewLabel_17, 6, SpringLayout.SOUTH, OutputResult);
		sl_changeMember.putConstraint(SpringLayout.WEST, lblNewLabel_17, 0, SpringLayout.WEST, changeMember);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, lblNewLabel_17, -21, SpringLayout.SOUTH, changeMember);
		sl_changeMember.putConstraint(SpringLayout.EAST, lblNewLabel_17, -6, SpringLayout.WEST, textField_5);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		changeMember.add(lblNewLabel_17);

		JButton btnNewButton_5 = new JButton("\uC218\uC815");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(breadName);
			}
		});
		btnNewButton_5.setBackground(new Color(139, 0, 0));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		sl_changeMember.putConstraint(SpringLayout.NORTH, btnNewButton_5, 6, SpringLayout.SOUTH, OutputResult);
		sl_changeMember.putConstraint(SpringLayout.WEST, btnNewButton_5, 6, SpringLayout.EAST, textField_5);
		sl_changeMember.putConstraint(SpringLayout.SOUTH, btnNewButton_5, 0, SpringLayout.SOUTH, textField_5);
		sl_changeMember.putConstraint(SpringLayout.EAST, btnNewButton_5, 0, SpringLayout.EAST, Input);
		changeMember.add(btnNewButton_5);
		changeMember.setVisible(false);

		// �������
		JPanel deleteMember = new JPanel();
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
		lblNewLabel_10.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		deleteMember.add(lblNewLabel_10);

		JComboBox comboBox = new JComboBox(number);
		sl_deleteMember.putConstraint(SpringLayout.NORTH, comboBox, 6, SpringLayout.SOUTH, lblNewLabel_10);
		sl_deleteMember.putConstraint(SpringLayout.WEST, comboBox, 10, SpringLayout.WEST, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, comboBox, 30, SpringLayout.SOUTH, lblNewLabel_10);
		sl_deleteMember.putConstraint(SpringLayout.EAST, comboBox, -333, SpringLayout.EAST, deleteMember);
		deleteMember.add(comboBox);

		textField_6 = new JTextField();
		sl_deleteMember.putConstraint(SpringLayout.NORTH, textField_6, 0, SpringLayout.NORTH, comboBox);
		sl_deleteMember.putConstraint(SpringLayout.WEST, textField_6, 6, SpringLayout.EAST, comboBox);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, textField_6, 81, SpringLayout.NORTH, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.EAST, textField_6, -10, SpringLayout.EAST, deleteMember);
		deleteMember.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("\uCD9C\uB825");
		lblNewLabel_18.setBackground(new Color(255, 255, 255));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		sl_deleteMember.putConstraint(SpringLayout.NORTH, lblNewLabel_18, 8, SpringLayout.SOUTH, textField_6);
		sl_deleteMember.putConstraint(SpringLayout.WEST, lblNewLabel_18, -395, SpringLayout.EAST, textField_6);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, lblNewLabel_18, 53, SpringLayout.SOUTH, textField_6);
		sl_deleteMember.putConstraint(SpringLayout.EAST, lblNewLabel_18, 0, SpringLayout.EAST, textField_6);
		deleteMember.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("\uC785\uB825 :");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		sl_deleteMember.putConstraint(SpringLayout.NORTH, lblNewLabel_19, 6, SpringLayout.SOUTH, lblNewLabel_18);
		sl_deleteMember.putConstraint(SpringLayout.WEST, lblNewLabel_19, 0, SpringLayout.WEST, comboBox);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, lblNewLabel_19, 60, SpringLayout.SOUTH, lblNewLabel_18);
		sl_deleteMember.putConstraint(SpringLayout.EAST, lblNewLabel_19, 0, SpringLayout.EAST, comboBox);
		deleteMember.add(lblNewLabel_19);

		textField_7 = new JTextField();
		sl_deleteMember.putConstraint(SpringLayout.NORTH, textField_7, -62, SpringLayout.SOUTH, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.WEST, textField_7, 6, SpringLayout.EAST, lblNewLabel_19);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, textField_7, -17, SpringLayout.SOUTH, deleteMember);
		sl_deleteMember.putConstraint(SpringLayout.EAST, textField_7, 232, SpringLayout.EAST, lblNewLabel_19);
		deleteMember.add(textField_7);
		textField_7.setColumns(10);

		JButton btnNewButton_4 = new JButton("\uC0AD\uC81C");
		btnNewButton_4.setBackground(new Color(139, 0, 0));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		sl_deleteMember.putConstraint(SpringLayout.NORTH, btnNewButton_4, 6, SpringLayout.SOUTH, lblNewLabel_18);
		sl_deleteMember.putConstraint(SpringLayout.WEST, btnNewButton_4, 13, SpringLayout.EAST, textField_7);
		sl_deleteMember.putConstraint(SpringLayout.SOUTH, btnNewButton_4, 0, SpringLayout.SOUTH, textField_7);
		sl_deleteMember.putConstraint(SpringLayout.EAST, btnNewButton_4, 0, SpringLayout.EAST, textField_6);
		deleteMember.add(btnNewButton_4);
		deleteMember.setVisible(false);

		// ȸ������ ��ư
		// ���� ��ư�� ������ ����� �ǳ� ��Ÿ����
		JButton addMemberButton = new JButton("\uB4F1\uB85D");
		addMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// ��ưŬ���� ��� ���� ��1 ���
				memberChoice = 1;
				deleteMember.setVisible(false);
				changeMember.setVisible(false);
				addMember.setVisible(true);

			}
		});
		addMemberButton.setForeground(new Color(255, 255, 255));
		addMemberButton.setBackground(new Color(139, 0, 0));
		addMemberButton.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		buttonManage.add(addMemberButton);

		JButton changeMemberButton = new JButton("\uC218\uC815");
		changeMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ��ưŬ���� ��� ���� ��2 ����
				memberChoice = 2;
				deleteMember.setVisible(false);
				changeMember.setVisible(true);
				addMember.setVisible(false);

			}
		});
		changeMemberButton.setForeground(new Color(255, 255, 255));
		changeMemberButton.setBackground(new Color(139, 0, 0));
		changeMemberButton.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		buttonManage.add(changeMemberButton);

		JButton deleteMemberButton = new JButton("\uC0AD\uC81C");
		deleteMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// ��ưŬ���� ��� ���� ��3 ����
				memberChoice = 3;
				deleteMember.setVisible(true);
				changeMember.setVisible(false);
				addMember.setVisible(false);

			}
		});
		deleteMemberButton.setForeground(new Color(255, 255, 255));
		deleteMemberButton.setBackground(new Color(139, 0, 0));
		deleteMemberButton.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		buttonManage.add(deleteMemberButton);

		JLabel lblNewLabel_8 = new JLabel("<\uD68C\uC6D0 \uAD00\uB9AC>");
		sl_MemberInfo.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 10, SpringLayout.NORTH, MemberInfo);
		sl_MemberInfo.putConstraint(SpringLayout.WEST, lblNewLabel_8, 164, SpringLayout.WEST, MemberInfo);
		lblNewLabel_8.setFont(new Font("�����ձ۾� ��", Font.BOLD, 28));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		MemberInfo.add(lblNewLabel_8);

		MemberInfo.setVisible(false);

		// �������� ���� �ǳ�
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
		lblNewLabel_7.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		changeInfoComponents.add(lblNewLabel_7);

		JPanel Inputpw = new JPanel();
		sl_changeInfoComponents.putConstraint(SpringLayout.NORTH, Inputpw, 100, SpringLayout.NORTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.WEST, Inputpw, 6, SpringLayout.EAST, lblNewLabel_7);
		sl_changeInfoComponents.putConstraint(SpringLayout.SOUTH, Inputpw, -97, SpringLayout.SOUTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.EAST, Inputpw, 0, SpringLayout.EAST, changeInfoComponents);
		Inputpw.setBackground(new Color(255, 255, 255, 100));
		// Inputpw.setOpaque(false);
		changeInfoComponents.add(Inputpw);
		SpringLayout sl_Inputpw = new SpringLayout();
		Inputpw.setLayout(sl_Inputpw);

		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 255, 255));
		textField_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		// textField_3.setOpaque(false);
		sl_Inputpw.putConstraint(SpringLayout.NORTH, textField_3, 0, SpringLayout.NORTH, Inputpw);
		sl_Inputpw.putConstraint(SpringLayout.WEST, textField_3, 0, SpringLayout.WEST, Inputpw);
		sl_Inputpw.putConstraint(SpringLayout.SOUTH, textField_3, 0, SpringLayout.SOUTH, Inputpw);
		sl_Inputpw.putConstraint(SpringLayout.EAST, textField_3, 296, SpringLayout.WEST, Inputpw);
		Inputpw.add(textField_3);
		textField_3.setColumns(10);

		JLabel OutputId = new JLabel("\uC544\uC774\uB514 \uCD9C\uB825");
		OutputId.setBackground(new Color(0, 0, 0, 100));
		OutputId.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		OutputId.setHorizontalAlignment(SwingConstants.CENTER);
		// lblNewLabel_8.setOpaque(false);
		sl_changeInfoComponents.putConstraint(SpringLayout.NORTH, OutputId, 0, SpringLayout.NORTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.WEST, OutputId, 6, SpringLayout.EAST, lblNewLabel_7);
		sl_changeInfoComponents.putConstraint(SpringLayout.SOUTH, OutputId, 55, SpringLayout.NORTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.EAST, OutputId, 0, SpringLayout.EAST, Inputpw);
		changeInfoComponents.add(OutputId);

		JLabel lblNewLabel_9 = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		lblNewLabel_9.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		// lblNewLabel_9.setOpaque(false);
		sl_changeInfoComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 0, SpringLayout.NORTH, Inputpw);
		sl_changeInfoComponents.putConstraint(SpringLayout.WEST, lblNewLabel_9, 0, SpringLayout.WEST, lblNewLabel_7);
		sl_changeInfoComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_9, 0, SpringLayout.SOUTH, Inputpw);
		sl_changeInfoComponents.putConstraint(SpringLayout.EAST, lblNewLabel_9, 0, SpringLayout.EAST, lblNewLabel_7);
		changeInfoComponents.add(lblNewLabel_9);

		JButton btnNewButton_2 = new JButton("\uC218\uC815");
		btnNewButton_2.setBackground(new Color(210, 105, 30));
		sl_changeInfoComponents.putConstraint(SpringLayout.NORTH, btnNewButton_2, 26, SpringLayout.SOUTH, Inputpw);
		sl_changeInfoComponents.putConstraint(SpringLayout.WEST, btnNewButton_2, -130, SpringLayout.EAST,
				changeInfoComponents);

		btnNewButton_2.setForeground(Color.WHITE);
		// btnNewButton_2.setBorderPainted(false);
		// btnNewButton_2.setFocusPainted(false);
		// btnNewButton_2.setOpaque(false);
		sl_changeInfoComponents.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -29, SpringLayout.SOUTH,
				changeInfoComponents);
		sl_changeInfoComponents.putConstraint(SpringLayout.EAST, btnNewButton_2, -21, SpringLayout.EAST,
				changeInfoComponents);
		btnNewButton_2.setFont(new Font("�����ձ۾� ��", Font.BOLD, 20));
		changeInfoComponents.add(btnNewButton_2);

		JLabel lblNewLabel_11 = new JLabel("<\uC9C0\uC810 \uC815\uBCF4 \uC218\uC815>");
		sl_changeInfoPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_11, 10, SpringLayout.NORTH, changeInfoPanel);
		sl_changeInfoPanel.putConstraint(SpringLayout.EAST, lblNewLabel_11, -144, SpringLayout.EAST, changeInfoPanel);
		lblNewLabel_11.setFont(new Font("�����ձ۾� ��", Font.BOLD, 28));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setOpaque(false);
		changeInfoPanel.add(lblNewLabel_11);

		changeInfoPanel.setVisible(false);

		// �޴����� �ǳ�
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
		lblNewLabel_5.setFont(new Font("�����ձ۾� ��", Font.BOLD, 28));
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
		breadNameComboBox.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		sl_deletMenucomponents.putConstraint(SpringLayout.NORTH, breadNameComboBox, -39, SpringLayout.SOUTH,
				lblNewLabel_6);
		sl_deletMenucomponents.putConstraint(SpringLayout.WEST, breadNameComboBox, 6, SpringLayout.EAST, lblNewLabel_6);
		sl_deletMenucomponents.putConstraint(SpringLayout.SOUTH, breadNameComboBox, 0, SpringLayout.SOUTH,
				lblNewLabel_6);
		sl_deletMenucomponents.putConstraint(SpringLayout.EAST, breadNameComboBox, 241, SpringLayout.EAST,
				lblNewLabel_6);
		deletMenucomponents.add(breadNameComboBox);
		lblNewLabel_6.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
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
			}
		});
		sl_deleteMenuPanel.putConstraint(SpringLayout.WEST, btnNewButton_1, -133, SpringLayout.EAST, deleteMenuPanel);
		btnNewButton_1.setBackground(new Color(210, 105, 30));
		btnNewButton_1.setFont(new Font("�����ձ۾� ��", Font.BOLD, 20));
		btnNewButton_1.setForeground(Color.WHITE);
		sl_deleteMenuPanel.putConstraint(SpringLayout.NORTH, btnNewButton_1, 22, SpringLayout.SOUTH,
				deletMenucomponents);
		sl_deleteMenuPanel.putConstraint(SpringLayout.SOUTH, btnNewButton_1, 65, SpringLayout.SOUTH,
				deletMenucomponents);

		// �����޺�

		sl_deleteMenuPanel.putConstraint(SpringLayout.EAST, btnNewButton_1, -39, SpringLayout.EAST, deleteMenuPanel);
		deleteMenuPanel.add(btnNewButton_1);

		deleteMenuPanel.setVisible(false);

		// �Ŵ����� �г�
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

		JComboBox BreadNameCombo = new JComboBox(breadNameList.toArray());
		BreadNameCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(BreadNameCombo)) {
					breadName = BreadNameCombo.getSelectedItem().toString();
				}
			}
		});

		InputChangeBreadPrice = new JTextField();
		InputChangeBreadPrice.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, InputChangeBreadPrice, 107, SpringLayout.WEST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, InputChangeBreadPrice, -10, SpringLayout.EAST,
				changeMenuComponents);
		changeMenuComponents.add(InputChangeBreadPrice);
		InputChangeBreadPrice.setColumns(10);
		lblNewLabel_1.setFont(new Font("�����ձ۾� ��", Font.BOLD, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		changeMenuPanel.add(lblNewLabel_1);

		JComboBox BreadTypeCombo = new JComboBox(breadType);
		BreadTypeCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource().equals(BreadTypeCombo)) {
					breadTypeChoice = BreadTypeCombo.getSelectedItem().toString();
				}
			}
		});
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, BreadTypeCombo, 107, SpringLayout.WEST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, BreadTypeCombo, -32, SpringLayout.NORTH,
				InputChangeBreadPrice);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, BreadTypeCombo, -157, SpringLayout.EAST,
				changeMenuComponents);
		BreadTypeCombo.setFont(new Font("�����ձ۾� ��", Font.BOLD, 24));
		changeMenuComponents.add(BreadTypeCombo);

		// �޴� ���� ����
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
			}
		});
		sl_changeMenuPanel.putConstraint(SpringLayout.WEST, ChangeButton, -123, SpringLayout.EAST, changeMenuPanel);
		ChangeButton.setBackground(new Color(210, 105, 30));
		ChangeButton.setForeground(new Color(255, 255, 255));
		ChangeButton.setFont(new Font("�����ձ۾� ��", Font.BOLD, 20));
		sl_changeMenuPanel.putConstraint(SpringLayout.NORTH, ChangeButton, 16, SpringLayout.SOUTH,
				changeMenuComponents);
		sl_changeMenuPanel.putConstraint(SpringLayout.SOUTH, ChangeButton, 56, SpringLayout.SOUTH,
				changeMenuComponents);

		JLabel lblNewLabel_4 = new JLabel("\uC218\uC815 \uAC00\uACA9 :");
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, lblNewLabel_4, -6, SpringLayout.WEST,
				InputChangeBreadPrice);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, InputChangeBreadPrice, 0, SpringLayout.NORTH,
				lblNewLabel_4);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, InputChangeBreadPrice, 0, SpringLayout.SOUTH,
				lblNewLabel_4);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 150, SpringLayout.NORTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -14, SpringLayout.SOUTH,
				changeMenuComponents);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		lblNewLabel_4.setEnabled(true);
		changeMenuComponents.add(lblNewLabel_4);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, BreadTypeCombo, 34, SpringLayout.SOUTH,
				BreadNameCombo);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, BreadNameCombo, 107, SpringLayout.WEST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, BreadNameCombo, -109, SpringLayout.EAST,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, BreadNameCombo, 10, SpringLayout.NORTH,
				changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, BreadNameCombo, -169, SpringLayout.SOUTH,
				changeMenuComponents);
		BreadNameCombo.setFont(new Font("�����ձ۾� ��", Font.BOLD, 24));
		changeMenuComponents.add(BreadNameCombo);

		JLabel label = new JLabel("\uC218\uC815 \uD0C0\uC785 :");
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, label, -62, SpringLayout.NORTH, lblNewLabel_4);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, changeMenuComponents);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, label, -32, SpringLayout.NORTH, lblNewLabel_4);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		changeMenuComponents.add(label);

		JLabel lblNewLabel_2 = new JLabel("\uBE75\uC774\uB984 :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		sl_changeMenuComponents.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, BreadNameCombo);
		sl_changeMenuComponents.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_4);
		sl_changeMenuComponents.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, 0, SpringLayout.SOUTH, BreadNameCombo);
		sl_changeMenuComponents.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_4);
		changeMenuComponents.add(lblNewLabel_2);
		sl_changeMenuPanel.putConstraint(SpringLayout.EAST, ChangeButton, -30, SpringLayout.EAST, changeMenuPanel);
		changeMenuPanel.add(ChangeButton);
		changeMenuPanel.setVisible(false);// �޴������Ⱥ��̰�

		// �޴��߰� �г�
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
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, InputBreadName, 47, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, InputBreadName, -10, SpringLayout.EAST,
				addMenuComponents);
		InputBreadName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				breadName = InputBreadName.getText();
			}
		});
		addMenuComponents.add(InputBreadName);
		InputBreadName.setColumns(10);

		InputBreadPrice = new JTextField();
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
		BreadNameLabel.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		BreadNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMenuComponents.add(BreadNameLabel);

		JLabel BreadTypeLabel = new JLabel("\uBE75\uC885\uB958 :");
		sl_addMenuComponents.putConstraint(SpringLayout.NORTH, BreadTypeLabel, 81, SpringLayout.NORTH,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.EAST, BreadTypeLabel, -276, SpringLayout.EAST,
				addMenuComponents);
		sl_addMenuComponents.putConstraint(SpringLayout.SOUTH, BreadNameLabel, -31, SpringLayout.NORTH, BreadTypeLabel);
		BreadTypeLabel.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
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
		BreadPriceLabel.setFont(new Font("�����ձ۾� ��", Font.BOLD, 26));
		BreadPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMenuComponents.add(BreadPriceLabel);

		JLabel lblNewLabel = new JLabel("<\uBA54\uB274 \uCD94\uAC00>");
		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -307, SpringLayout.SOUTH, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.NORTH, addMenuComponents, 18, SpringLayout.SOUTH, lblNewLabel);
		sl_addMenuPanel.putConstraint(SpringLayout.WEST, lblNewLabel, 104, SpringLayout.WEST, addMenuPanel);
		sl_addMenuPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -102, SpringLayout.EAST, addMenuPanel);
		lblNewLabel.setFont(new Font("�����ձ۾� ��", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		addMenuPanel.add(lblNewLabel);

		// ������ ����
		JComboBox comboBox_1 = new JComboBox(breadType);
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
				System.out.println(breadName + " " + breadTypeChoice + " " + breadPrice + count);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(210, 105, 30));
		btnNewButton.setFont(new Font("�����ձ۾� ��", Font.BOLD, 20));
		addMenuPanel.setVisible(false); // �Ⱥ��̰� ��

		panel.add(ButtonPanel);

		ButtonPanel.setLayout(new GridLayout(2, 3, 10, 10));

		// �޴��߰�
		JButton addMenu = new JButton("\uBA54\uB274 \uCD94\uAC00");
		addMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Ŭ���ÿ� choice 1
				choice = 1;

				System.out.println(choice);

				addMenuPanel.setVisible(true);
				changeMenuPanel.setVisible(false);
				deleteMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(false);
				MemberInfo.setVisible(false);

			}
		});
		addMenu.setFont(new Font("�����ձ۾� ��", Font.BOLD, 23));
		addMenu.setForeground(Color.WHITE);
		addMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(addMenu);

		// �޴�����
		JButton changeMenu = new JButton("\uBA54\uB274\uC218\uC815");
		changeMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Ŭ���ÿ� choice 2
				choice = 2;
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(true);
				deleteMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(false);
				MemberInfo.setVisible(false);

			}
		});

		changeMenu.setFont(new Font("�����ձ۾� ��", Font.BOLD, 23));
		changeMenu.setForeground(Color.WHITE);
		changeMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(changeMenu);

		// �޴�����
		JButton deleMenu = new JButton("\uBA54\uB274\uC0AD\uC81C");
		deleMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Ŭ���ÿ� choice 3
				choice = 3;
				deleteMenuPanel.setVisible(true);
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(false);
				MemberInfo.setVisible(false);
			}
		});

		deleMenu.setFont(new Font("�����ձ۾� ��", Font.BOLD, 23));
		deleMenu.setForeground(Color.WHITE);
		deleMenu.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(deleMenu);

		// ������������
		JButton changeInfo = new JButton("\uC9C0\uC810\uC815\uBCF4\uC218\uC815");
		changeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Ŭ���ÿ� choice 4
				choice = 4;

				deleteMenuPanel.setVisible(false);
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(true);
				MemberInfo.setVisible(false);
			}
		});

		changeInfo.setFont(new Font("�����ձ۾� ��", Font.BOLD, 23));
		changeInfo.setForeground(Color.WHITE);
		changeInfo.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(changeInfo);

		// ȸ������
		JButton controllMember = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		controllMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Ŭ���ÿ� choice 5

				deleteMenuPanel.setVisible(false);
				addMenuPanel.setVisible(false);
				changeMenuPanel.setVisible(false);
				changeInfoPanel.setVisible(false);
				MemberInfo.setVisible(true);

			}
		});

		controllMember.setFont(new Font("�����ձ۾� ��", Font.BOLD, 23));
		controllMember.setForeground(Color.WHITE);
		controllMember.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(controllMember);

		// ����
		JButton close = new JButton("\uB2EB\uAE30");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// Ŭ���ÿ� choice 6
				// myCllickListener.onClick();
				frame.dispose();
			}
		});
		close.setFont(new Font("�����ձ۾� ��", Font.BOLD, 23));
		close.setForeground(Color.WHITE);
		close.setBackground(new Color(128, 0, 0));
		ButtonPanel.add(close);
	}

	public void setOnMyClickListener(MyCllickListener myCllickListener) {
		// TODO Auto-generated method stub
		this.myCllickListener = myCllickListener;

	}
}
