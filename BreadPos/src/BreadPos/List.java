package BreadPos;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DB.Product;

public class List extends JPanel {
	
	public void choice(JPanel productPanel, JPanel amountPanel, JPanel pricePanel, ArrayList<Product> breadList) {
		System.out.println(breadList.size()); //Main�� ShowPanel�� �� ����Ʈ
		int total = 0;
		if (breadList.size() != 0) {
			for (int i = 0; i < breadList.size(); i++) {
				JLabel product = new JLabel(breadList.get(i).getPname()); //�����
				product.setFont(new Font("�����ձ۾� ��", Font.PLAIN, 25));
				productPanel.add(product);
				JLabel amount = new JLabel("" + breadList.get(i).getAmount()); //������
				amount.setFont(new Font("�����ձ۾� ��", Font.PLAIN, 25));
				amountPanel.add(amount);
				JLabel price = new JLabel("" + breadList.get(i).getPrice()); //������
				price.setFont(new Font("�����ձ۾� ��", Font.PLAIN, 25));
				pricePanel.add(price);
				total += breadList.get(i).getPrice();
			}
			MainGUI.sendlist(total);
		}
	}

}
