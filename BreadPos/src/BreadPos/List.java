package BreadPos;

import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import DB.Bread;

public class List extends JPanel {
	public void choice(JPanel choicePanel, ArrayList<Bread> breadList) {
		for (int i = 0; i < breadList.size(); i++) {
			JCheckBox checkBox = new JCheckBox("¼±ÅÃ");
			choicePanel.add(checkBox);
		}
	}
}
