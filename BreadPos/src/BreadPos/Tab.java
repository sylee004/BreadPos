package BreadPos;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import DB.Bread;

public class Tab extends JPanel{
	Tab(JPanel whitePanel, String kind) {

		Management mg = new Management();
		ArrayList<Bread> whiteBread = mg.breadKind(kind);

		for (int i = 0; i < whiteBread.size(); i++) {
			String name = whiteBread.get(i).getName();
			JButton btnNewButton = new JButton(name);
			btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 15));
			whitePanel.add(btnNewButton);
		}
	}
	public static void main(String[] args) {
		new MainGUI();
	}
}
