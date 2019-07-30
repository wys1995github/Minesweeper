package minesweeper;

public class MineCell {

	private int cellX = 0;	//X坐标
	private int cellY = 0;	//Y坐标
	private boolean isMine = false;	//是否死雷
	private boolean isMark = false;	//是否被标记
	private boolean isDig = false;	//是否被挖开
	private int aroundMineCount = 0;	//周围地雷总数
	
	//构造函数
	public MineCell(int cellX, int cellY, boolean isMine, boolean isMark, boolean isDig, int aroundMineCount) {
		this.cellX = cellX;
		this.cellY = cellY;
		this.isMine = isMine;
		this.isMark = isMark;
		this.isDig = isDig;
		this.aroundMineCount = aroundMineCount;
	}
	
	public int getCellX() {
		return cellX;
	}
	public void setCellX(int cellX) {
		this.cellX = cellX;
	}
	public int getCellY() {
		return cellY;
	}
	public void setCellY(int cellY) {
		this.cellY = cellY;
	}
	public boolean isMine() {
		return isMine;
	}
	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}
	public boolean isMark() {
		return isMark;
	}
	public void setMark(boolean isMark) {
		this.isMark = isMark;
	}
	public int getAroundMineCount() {
		return aroundMineCount;
	}
	public void setAroundMineCount(int aroundMineCount) {
		this.aroundMineCount = aroundMineCount;
	}
	public boolean isDig() {
		return isDig;
	}
	public void setDig(boolean isDig) {
		this.isDig = isDig;
	}
}


