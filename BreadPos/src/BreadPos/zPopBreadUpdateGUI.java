package BreadPos;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class zPopBreadUpdateGUI {

	private JFrame frame;
	private BufferedImage icon;
	// private BufferedImage icon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zPopBreadUpdateGUI window = new zPopBreadUpdateGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public zPopBreadUpdateGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/메뉴수정.png"));
					Dimension d = getSize();// 전체화면
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					setBackground(new Color(0, 0, 0, 0));
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		panel.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
			ManagementGUI m = new ManagementGUI();
			m.main(null);
			frame.dispose();
			
			}
		});
		
		/*{
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/pw.png"));
					Dimension d = getSize();// 전체화면
					g.drawImage(icon, 0, 0, d.width, d.height, null);
					setOpaque(false);
					setBackground(new Color(0, 0, 0, 0));
					super.paintComponent(g);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};*/
		
		
		frame.getContentPane().add(panel, "name_742862708218580");
	}
}

