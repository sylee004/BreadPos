package BreadPos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import DB.Bread;

public class Tab extends JPanel{
	private static Bread list;
	
	public void tabbed(JPanel whitePanel, String kind) {

		Management mg = new Management();
		ArrayList<Bread> breadList = mg.breadKind(kind);

		for (int i = 0; i < breadList.size(); i++) { //»§¹öÆ° »ý¼º
			Bread bread = breadList.get(i);
			String name = breadList.get(i).getName();
			JButton menuBtn = new JButton(name);//, new ImageIcon("./image/´ÞÆØÀÌ»§.png"));
			menuBtn.setBorder(null);
			menuBtn.setFocusPainted(false);
//			menuBtn.setOpaque(false);
			menuBtn.setBackground(new Color(255, 255, 255));
			menuBtn.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.PLAIN, 35));
			menuBtn.setPreferredSize(new Dimension(129, 100));
			menuBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					list = bread;
					
					MainGUI.sendMessage(list);
				
					//new List();
				}
			});
			whitePanel.add(menuBtn);
			//System.out.println(list.getName());
		}
	}
}
