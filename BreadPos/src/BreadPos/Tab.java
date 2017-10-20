package BreadPos;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DB.Bread;

public class Tab extends JPanel{
	private static Bread list;
	
	public void tabbed(JPanel whitePanel, String kind) {

		Management mg = new Management();
		ArrayList<Bread> breadList = mg.breadKind(kind);

		for (int i = 0; i < breadList.size(); i++) {
			Bread bread = breadList.get(i);
			String name = breadList.get(i).getName();
			JButton menuBtn = new JButton(name, new ImageIcon("./image/Å©·Î¿Í»ó.png"));
			menuBtn.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.PLAIN, 20));
			menuBtn.setPreferredSize(new Dimension(128, 100));
			menuBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					list = bread;
					MainGUI.sendMessage(list);
				}
			});
			whitePanel.add(menuBtn);
			//System.out.println(list.getName());
		}
	}
}
