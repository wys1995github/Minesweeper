package minesweeper;

public class MineCell {

	private int cellX = 0;	//X坐标
	private int cellY = 0;	//Y坐标
	private boolean isMine = false;	//是否死雷
	private boolean isMark = false;	//是否被标记
	private boolean isUncertain = false;	//是否不确定
	private int aroundMineCount = 0;	//周围地雷总数
	
	public MineCell(int cellX, int cellY, boolean isMine, boolean isMark, boolean isUncertain, int aroundMineCount) {
		this.cellX = cellX;
		this.cellY = cellY;
		this.isMine = isMine;
		this.isMark = isMark;
		this.isUncertain = isUncertain;
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
	public boolean isUncertain() {
		return isUncertain;
	}
	public void setUncertain(boolean isUncertain) {
		this.isUncertain = isUncertain;
	}
	public int getAroundMineCount() {
		return aroundMineCount;
	}
	public void setAroundMineCount(int aroundMineCount) {
		this.aroundMineCount = aroundMineCount;
	}
}


