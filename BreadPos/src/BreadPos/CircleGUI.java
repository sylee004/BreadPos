package BreadPos;import javax.swing.*;

import DB.saleDAO;

import java.awt.*;
import java.awt.event.*;

public class CircleGUI extends JFrame {

	
	
	Container contentPane; // 컨테이너 생성
	int[] data = {0,0,0,0,0}; // 차트의 값 저장배열
	int[] arcAngle = new int[5]; 

	Color[] color = {Color.getHSBColor(737, 40, 1277), Color.getHSBColor(882, 530, 188), // 색상 
			  Color.getHSBColor(1210, 510, 1111), Color.getHSBColor(1420, 111, 643), Color.getHSBColor(1299, 359, 99)};

	String[] itemName = {"White", "Rye", // 비교대상 
			                  "Corn", "Bori", "Mix"};

	JTextField[] tf  = new JTextField[5]; // 텍스트필드
	ChartPanel chartPanel = new ChartPanel(); // 차트패널

	public CircleGUI(){
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		}); // 생성자
		setTitle("Bread Percentage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane(); // 컨테이너 갯
		contentPane.add(new InputPanel(), BorderLayout.NORTH);
		contentPane.add(chartPanel, BorderLayout.CENTER);
		setSize(550,350);
		setVisible(true);
		drawChart(); // 차트 메소드 호출
	}

	void drawChart(){ // 차트를 그린다
		int sum=0; // 초기값 0
		for(int i=0;i<data.length;i++){ // 데이터 값만큼 루프
			data[i] = Integer.parseInt(tf[i].getText());
			sum+=data[i];
		}
		if(sum == 0) 
			return;

		for(int i=0;i<data.length;i++){ 
			arcAngle[i] = (int)Math.round((double)data[i]/(double)sum*360);
			chartPanel.repaint(); // 차트패널의 PAINT호출
		}
	}

	class InputPanel extends JPanel{ // 입력패널
		saleDAO sd = new saleDAO();
		int total_rye = 0;
		int total_white = 0;
		int total_corn = 0;
		int total_bori = 0;
		int total_mix = 0;
		
		public InputPanel(){
			this.setBackground(Color.WHITE); //배경
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
			
			
			tf[0] = new JTextField(total_rye_st, 6);  // 입력 값 , 입력 칸의 크기
			tf[0].addActionListener(new MyActionListener()); //리스너
			//add(new JLabel(itemName[0]));
			//add(tf[0]);
			
			tf[1] = new JTextField(total_white_st, 6);  // 입력 값 , 입력 칸의 크기
			tf[1].addActionListener(new MyActionListener()); //리스너
			//add(new JLabel(itemName[1]));
			//add(tf[1]);

			tf[2] = new JTextField(total_corn_st, 6);  // 입력 값 , 입력 칸의 크기
			tf[2].addActionListener(new MyActionListener()); //리스너
			//add(new JLabel(itemName[2]));
			//add(tf[2]);
			
			tf[3] = new JTextField(total_bori_st, 6);  // 입력 값 , 입력 칸의 크기
			tf[3].addActionListener(new MyActionListener()); //리스너
			//add(new JLabel(itemName[3]));
			//add(tf[3]);
			
			tf[4] = new JTextField(total_mix_st, 6);  // 입력 값 , 입력 칸의 크기
			tf[4].addActionListener(new MyActionListener()); //리스너
			//add(new JLabel(itemName[4]));
			//add(tf[4]);
			
		}
	}

	class MyActionListener implements ActionListener{ //액션리스너
		public void actionPerformed(ActionEvent e){ //텍스트필드변화시
			JTextField t = (JTextField)e.getSource();
			int n;

			try{
				n = Integer.parseInt(t.getText());
			}
			catch(NumberFormatException ex){
				t.setText("0");
				return;
			}
			drawChart(); // 호출	
		}
	}

	class ChartPanel extends JPanel{ // 차트 표시 패널

		public void paintComponent(Graphics g){

			super.paintComponent(g);//부모 패인트호출

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


