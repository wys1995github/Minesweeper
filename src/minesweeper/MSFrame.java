package minesweeper;

import javax.swing.JFrame;

public class MSFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;

	public void launchFrame() {
		this.setTitle("扫雷");
		this.setVisible(true);
		this.setSize(500, 300);
		this.setLocation(100, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		MSFrame ms = new MSFrame();
		ms.launchFrame();
	}
	
}