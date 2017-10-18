package BreadPos;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LoginGUI extends JFrame {
    JScrollPane scrollPane;
    ImageIcon icon;
 
    public LoginGUI() {
        icon = new ImageIcon("./image/KakaoTalk_20171018_201408552.jpg");
       
        //��� Panel ������ �������������� ����      
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, null);
                // Approach 2: Scale image to size of component
                // Dimension d = getSize();
                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //�׸��� ǥ���ϰ� ����,�����ϰ� ����
                super.paintComponent(g);
            }
        };
       
       
       
        JButton button = new JButton("��ư");
        background.add(button);
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
    }
 
    public static void main(String[] args) {
        LoginGUI frame = new LoginGUI();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
