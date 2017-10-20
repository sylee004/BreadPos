package BreadPos;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import DB.Bread;

public class Tab extends JPanel{
	Tab(JPanel whitePanel, String kind) {

		Management mg = new Management();
		ArrayList<Bread> whiteBread = mg.breadKind(kind);

		for (int i = 0; i < whiteBread.size(); i++) {
			String name = whiteBread.get(i).getName();
			JButton btnNewButton = new JButton(name, new ImageIcon("./image/Å©·Î¿Í»ó.png"));
			btnNewButton.setFont(new Font("³ª´®¼Õ±Û¾¾ Ææ", Font.PLAIN, 20));
			btnNewButton.setPreferredSize(new Dimension(128, 100));
			whitePanel.add(btnNewButton);
		}
	}
	public static void main(String[] args) {
		new MainGUI();
	}
}
