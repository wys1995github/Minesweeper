package minesweeper;

public class MSCore {
	
	public void initMineMap(int x, int y) {
		MineCell[][] mc = new MineCell[x][y];
		MineCell mc_temp = new MineCell(0, 0, false, false, false, 0);
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				mc_temp = new MineCell(i, j, false, false, false, 0);
				mc[i][j] = mc_temp;
			}
		}
		
		initMine(2, x, y, mc);
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				mc_temp = mc[i][j];
				mc_temp.setAroundMineCount(0);
			}
		}
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				System.out.println(mc[i][j].getCellX());
				System.out.println(mc[i][j].getCellY());
				System.out.println(mc[i][j].getAroundMineCount());
				System.out.println(mc[i][j].isMark());
				System.out.println(mc[i][j].isMine());
				System.out.println(mc[i][j].isUncertain()?"*":"o");
			}
		}
	}
	
	public void initMine(int mineCount, int cellX, int cellY, MineCell[][] mc) {
		int count_temp = mineCount;
		for(int i = 0; i < count_temp; i++) {
			int mineX = (int)(Math.random()*cellX);
			int mineY = (int)(Math.random()*cellY);
			if(!mc[mineX][mineY].isMine()) {
				mc[mineX][mineY].setMine(true);
			} else {
				count_temp++;
			}
		}
	}
	
	public int aroundMineSum(int x, int y, int cellX, int cellY, MineCell[][] mc) {
		int mineCount = 0;
		
		if(mc[x-1][y-1].isMine()) {
			mineCount++;
		}
		if(mc[x][y-1].isMine()) {
			mineCount++;
		}
		if(mc[x+1][y-1].isMine()) {
			mineCount++;
		}
		if(mc[x-1][y].isMine()) {
			mineCount++;
		}
		if(mc[x+1][y].isMine()) {
			mineCount++;
		}
		if(mc[x-1][y+1].isMine()) {
			mineCount++;
		}
		if(mc[x][y+1].isMine()) {
			mineCount++;
		}
		if(mc[x+1][y+1].isMine()) {
			mineCount++;
		}
		return mineCount;
	}
	
	public static void main(String[] args) {
		MSCore ms = new MSCore();
		ms.initMineMap(3, 2);
	}
}
