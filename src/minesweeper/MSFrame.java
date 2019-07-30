package minesweeper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class MSFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static MSCore mc = new MSCore(12, 16, 10);

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawRect(100, 50, 400, 300);
		for(int i = 100; i < 500; i=i+25) {
			g.drawLine(i, 50, i, 350);
		}
		for(int i = 50; i < 350; i=i+25) {
			g.drawLine(100, i, 500, i);
		}
		Color originColor = g.getColor();
		g.setColor(Color.CYAN);
		for(int i = 101; i < 500; i=i+25) {
			for(int j = 51; j < 350; j=j+25) {
				g.fillRect(i, j, 23, 23);
			}
		}
		g.setColor(originColor);
	}
	
	class MouseMonitor extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			mc.mouseClicked(e);
		}
	}
	
	public void launchFrame() {
		this.setTitle("扫雷");
		this.setVisible(true);
		this.setSize(600, 400);
		this.setLocation(300, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addMouseListener(new MouseMonitor());
	}
	
	public static void main(String[] args) {
		MSFrame ms = new MSFrame();
		ms.launchFrame();
		mc.initMineCell();
		mc.showMineCell();
	}
	
}