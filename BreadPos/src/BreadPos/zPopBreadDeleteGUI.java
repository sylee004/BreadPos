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
import javax.swing.SpringLayout;

public class zPopBreadDeleteGUI {

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
					zPopBreadDeleteGUI window = new zPopBreadDeleteGUI();
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
	public zPopBreadDeleteGUI() {
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

		JPanel panel = new JPanel();
		

		/*
		 * { public void paintComponent(Graphics g) { try { icon = ImageIO.read(new
		 * File("./image/pw.png")); Dimension d = getSize();// 전체화면 g.drawImage(icon, 0,
		 * 0, d.width, d.height, null); setOpaque(false); setBackground(new Color(0, 0,
		 * 0, 0)); super.paintComponent(g); } catch (IOException e) {
		 * e.printStackTrace(); } } };
		 */

		frame.getContentPane().add(panel, "name_742862708218580");
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_1 = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/메뉴삭제.png"));
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
		panel_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ManagementGUI m = new ManagementGUI();
				m.main(null);
				frame.dispose();

			}
		});
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, 434, SpringLayout.WEST, panel);
		panel.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JPanel panel_2 = new JPanel(){
			public void paintComponent(Graphics g) {
				try {
					icon = ImageIO.read(new File("./image/logo.png"));
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
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, -81, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, -168, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -23, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, -22, SpringLayout.EAST, panel_1);
		panel_1.add(panel_2);
	}
}
