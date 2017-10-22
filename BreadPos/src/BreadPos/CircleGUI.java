package BreadPos;import javax.swing.*;

import DB.saleDAO;

import java.awt.*;
import java.awt.event.*;

public class CircleGUI extends JFrame {

	
	
	Container contentPane; // �����̳� ����
	int[] data = {0,0,0,0,0}; // ��Ʈ�� �� ����迭
	int[] arcAngle = new int[5]; 

	Color[] color = {Color.getHSBColor(737, 40, 1277), Color.getHSBColor(882, 530, 188), // ���� 
			  Color.getHSBColor(1210, 510, 1111), Color.getHSBColor(1420, 111, 643), Color.getHSBColor(1299, 359, 99)};

	String[] itemName = {"White", "Rye", // �񱳴�� 
			                  "Corn", "Bori", "Mix"};

	JTextField[] tf  = new JTextField[5]; // �ؽ�Ʈ�ʵ�
	ChartPanel chartPanel = new ChartPanel(); // ��Ʈ�г�

	public CircleGUI(){
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		}); // ������
		setTitle("Bread Percentage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane(); // �����̳� ��
		contentPane.add(new InputPanel(), BorderLayout.NORTH);
		contentPane.add(chartPanel, BorderLayout.CENTER);
		setSize(550,350);
		setVisible(true);
		drawChart(); // ��Ʈ �޼ҵ� ȣ��
	}

	void drawChart(){ // ��Ʈ�� �׸���
		int sum=0; // �ʱⰪ 0
		for(int i=0;i<data.length;i++){ // ������ ����ŭ ����
			data[i] = Integer.parseInt(tf[i].getText());
			sum+=data[i];
		}
		if(sum == 0) 
			return;

		for(int i=0;i<data.length;i++){ 
			arcAngle[i] = (int)Math.round((double)data[i]/(double)sum*360);
			chartPanel.repaint(); // ��Ʈ�г��� PAINTȣ��
		}
	}

	class InputPanel extends JPanel{ // �Է��г�
		saleDAO sd = new saleDAO();
		int total_rye = 0;
		int total_white = 0;
		int total_corn = 0;
		int total_bori = 0;
		int total_mix = 0;
		
		public InputPanel(){
			this.setBackground(Color.WHITE); //���
			for (int i = 0; i <=12; i++) {
				int k1 =(int)sd.selectOneByName("rye").get(0).getSales();
				total_rye+=k1;
				int k2 =(int)sd.selectOneByName("white").get(0).getSales();
				total_white+=k2;
				int k3 =(int)sd.selectOneByName("corn").get(0).getSales();
				total_corn+=k3;
				int k4 =(int)sd.selectOneByName("bori").get(0).getSales();
				total_bori+=k4;
				int k5 =(int)sd.selectOneByName("mix").get(0).getSales();
				total_mix+=k5;
			}
			
			String total_rye_st = total_rye+"";
			String total_white_st = total_white+"";
			String total_corn_st = total_corn+"";
			String total_bori_st = total_bori+"";
			String total_mix_st = total_mix+"";
			
			
			tf[0] = new JTextField(total_rye_st, 6);  // �Է� �� , �Է� ĭ�� ũ��
			tf[0].addActionListener(new MyActionListener()); //������
			//add(new JLabel(itemName[0]));
			//add(tf[0]);
			
			tf[1] = new JTextField(total_white_st, 6);  // �Է� �� , �Է� ĭ�� ũ��
			tf[1].addActionListener(new MyActionListener()); //������
			//add(new JLabel(itemName[1]));
			//add(tf[1]);

			tf[2] = new JTextField(total_corn_st, 6);  // �Է� �� , �Է� ĭ�� ũ��
			tf[2].addActionListener(new MyActionListener()); //������
			//add(new JLabel(itemName[2]));
			//add(tf[2]);
			
			tf[3] = new JTextField(total_bori_st, 6);  // �Է� �� , �Է� ĭ�� ũ��
			tf[3].addActionListener(new MyActionListener()); //������
			//add(new JLabel(itemName[3]));
			//add(tf[3]);
			
			tf[4] = new JTextField(total_mix_st, 6);  // �Է� �� , �Է� ĭ�� ũ��
			tf[4].addActionListener(new MyActionListener()); //������
			//add(new JLabel(itemName[4]));
			//add(tf[4]);
			
		}
	}

	class MyActionListener implements ActionListener{ //�׼Ǹ�����
		public void actionPerformed(ActionEvent e){ //�ؽ�Ʈ�ʵ庯ȭ��
			JTextField t = (JTextField)e.getSource();
			int n;

			try{
				n = Integer.parseInt(t.getText());
			}
			catch(NumberFormatException ex){
				t.setText("0");
				return;
			}
			drawChart(); // ȣ��	
		}
	}

	class ChartPanel extends JPanel{ // ��Ʈ ǥ�� �г�

		public void paintComponent(Graphics g){

			super.paintComponent(g);//�θ� ����Ʈȣ��

			int startAngle = 0;

			for(int i=0;i<data.length;i++){
				g.setColor(color[i]);
				g.drawString(itemName[i]+""+Math.round
			   (arcAngle[i]*100/360)+"%", 50+i*100,20);
			}

			for(int i=0;i<data.length;i++){
				g.setColor(color[i]);
				g.fillArc(150,50,200,200,startAngle,arcAngle[i]);
				startAngle = startAngle + arcAngle[i];
			}
		}
	}

	public static void main(String[] args) {
		new CircleGUI();
	}
}


