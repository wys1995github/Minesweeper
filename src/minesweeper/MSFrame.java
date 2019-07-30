package minesweeper;

import java.awt.Graphics;

import javax.swing.JFrame;

public class MSFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	public void launchFrame() {
		this.setTitle("扫雷");
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLocation(300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		MSFrame ms = new MSFrame();
		ms.launchFrame();
	}
	
}