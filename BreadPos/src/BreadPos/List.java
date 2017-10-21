package BreadPos;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import DB.Bread;

public class List extends JPanel {
	public void choice(JPanel choicePanel, ArrayList<Bread> breadList) {
		System.out.println(breadList.size());
		for (int i = 0; i < breadList.size(); i++) {
			JCheckBox checkBox = new JCheckBox("¼±ÅÃ");
			checkBox.setBackground(new Color(255, 255, 255, 150));
			choicePanel.add(checkBox);
		}
	}
}
