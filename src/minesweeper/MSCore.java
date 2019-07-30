package minesweeper;

public class MSCore {
	
	private int cellX;
	private int cellY;
	private int mineCount;
	private MineCell[][] mc;
	
	public MSCore(int cellX, int cellY, int mineCount) {
		this.cellX = cellX;
		this.cellY = cellY;
		this.mineCount = mineCount;
		this.mc = new MineCell[cellX][cellY];
	}
	
	//初始化扫雷游戏
	public void initMineCell() {
		initXY();
		initMine();
		setAroundMineSum();
	}
	
	//初始化坐标
	private void initXY() {
		MineCell mc_temp = new MineCell(0, 0, false, false, false, 0);
		for(int i = 0; i < cellX; i++) {
			for(int j = 0; j < cellY; j++) {
				mc_temp = new MineCell(i, j, false, false, false, 0);
				mc[i][j] = mc_temp;
			}
		}
	}
	
	//初始化地雷
	private void initMine() {
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
	
	//获取每一格周围的地雷数
	private void setAroundMineSum() {
		for(int x = 0; x < cellX; x++) {
			for(int y = 0; y < cellY; y++) {
				int mineCount = 0;
				if(x-1 >= 0 && y-1 >= 0) {
					if(mc[x-1][y-1].isMine()) {
						mineCount++;
					}
				}
				if(x-1 >= 0) {
					if(mc[x-1][y].isMine()) {
						mineCount++;
					}
				}
				if(x-1 >= 0 && y+1 <= cellY-1) {
					if(mc[x-1][y+1].isMine()) {
						mineCount++;
					}
				}
				if(y-1 >= 0) {
					if(mc[x][y-1].isMine()) {
						mineCount++;
					}
				}
				if(y+1 <= cellY-1) {
					if(mc[x][y+1].isMine()) {
						mineCount++;
					}
				}
				if(y-1 >= 0 && x+1 <= cellX-1) {
					if(mc[x+1][y-1].isMine()) {
						mineCount++;
					}
				}
				if(x+1 <= cellX-1) {
					if(mc[x+1][y].isMine()) {
						mineCount++;
					}
				}
				if(x+1 <= cellX-1 && y+1 <= cellY-1) {
					if(mc[x+1][y+1].isMine()) {
						mineCount++;
					}
				}
				mc[x][y].setAroundMineCount(mineCount);
			}
		}
	}
	
	public void digCell(int digX, int digY){
		if(!mc[digX][digY].isDig()) {
			if(mc[digX][digY].isMine()) {
				System.out.println("踩到地雷了！");
			}else{
				mc[digX][digY].setDig(true);
				mc[digX][digY].setMark(false);
				isWin();
			}
		}
	}
	
	public void markCell(int markX, int markY){
		if(mc[markX][markY].isMark()) {
			mc[markX][markY].setMark(false);
		}else{
			mc[markX][markY].setMark(true);
			isWin();
		}
	}
	
	private void isWin() {
		int markTrueSum = 0;
		int digSum = 0;
		for(int i = 0; i < cellX; i++) {
			for(int j = 0; j < cellY; j++) {
				if(mc[i][j].isDig()) {
					digSum++;
				}
				if(mc[i][j].isMark() && mc[i][j].isMine()) {
					markTrueSum++;
				}
			}
		}
		if(markTrueSum == mineCount || digSum == cellX*cellY-mineCount) {
			System.out.println("恭喜您！");
		}
	}
	
	public void showMineCell() {
		for(int i = 0; i < cellX; i++) {
			for(int j = 0; j < cellY; j++) {
				System.out.print(mc[i][j].getAroundMineCount());
				System.out.print(mc[i][j].isMine());
				System.out.print("\t");
				if(j == cellY-1) {
					System.out.println();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		MSCore msc = new MSCore(8, 12, 25);
		msc.initMineCell();
		msc.showMineCell();
	}
}
