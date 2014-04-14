package packman;

import javalib.colors.*;
import javalib.worldimages.*;

public class Pacman extends Character {
	Integer score;
	Integer spriteNumber;
	boolean spriteIncreasing;
	boolean toggleScary = false;
	boolean nextVertical = this.verticalDirection;
	boolean nextPositive = this.positiveDirection;
	
	Pacman(boolean v, boolean p, Integer c, Integer pa, Integer sn, boolean si, Integer sc) {
		super(v, p, c, pa);
		this.spriteNumber = sn;
		this.spriteIncreasing = si;
		this.score = sc;
	}
	Pacman(Pacman p) {
		super(p.verticalDirection,p.positiveDirection,
				p.columnOrRow,p.positionOnOtherAxis);
		this.spriteNumber = p.spriteNumber;
		this.spriteIncreasing = p.spriteIncreasing;
		this.score = p.score;
	}
	void eatScaryPill() {
		this.toggleScary = true;
	}
	void onTick(Map m) {
		this.move(m);
	}
	boolean canGoNextDirection(Map m) {
		Integer y = this.getGridY();
		Integer x = this.getGridX();
		y = (y + this.dny()) % (m.yLength()-1);
		x = (x + this.dnx()) % (m.xLength()-1);
		return m.board[y][x].traversable();
	}
	String printIt() {
		if(this.nextVertical == true) {
			return "true";
		} else {
			return "false";
		}
	}
	Integer dx() {
		Integer x = 0;
		if(!this.verticalDirection) {
			if(this.positiveDirection) {
				x = 1;
			} else {
				x = -1;
			}
		}
		return x;
	}
	Integer dy() {
		Integer y = 0;
		if(this.verticalDirection) {
			if(this.positiveDirection) {
				y = 1;
			} else {
				y = -1;
			}
		}
		return y;
	}
	Integer dnx() {
		Integer x = 0;
		if(!this.nextVertical) {
			if(this.nextPositive) {
				x += 1;
			} else {
				x += -1;
			}
		}
		return x;
	}
	Integer dny() {
		Integer y = 0;
		if(this.nextVertical) {
			if(this.nextPositive) {
				y += 1;
			} else {
				y += -1;
			}
		}
		return y;
	}

	void move(Map m) {
		if(this.flipping()) {
			this.positiveDirection = this.nextPositive;
		}
		if(this.atIntersection()) {
			m.board[this.getGridY()][this.getGridX()] = m.board[this.getGridY()][this.getGridX()].eat(this);
			if(this.canGoNextDirection(m) && this.turning()) {
				this.switchDirection();
			} 
		} 
		if(this.verticalDirection){
			this.positionOnOtherAxis = this.positionOnOtherAxis + this.dy();		
		} else {
			this.positionOnOtherAxis = this.positionOnOtherAxis + this.dx();
		}
	}
	boolean turning() {
		return this.nextVertical != this.verticalDirection;
	}
	boolean flipping() {
		return !this.turning() && (this.nextPositive != this.positiveDirection);
	}
	void switchDirection() {
		this.verticalDirection = this.nextVertical;
		this.positiveDirection = this.nextPositive;
		if(this.nextVertical) {
			this.columnOrRow = this.getGridX();
			this.positionOnOtherAxis = this.getXCoord();
			//System.out.println(this.columnOrRow.toString());
		} else {
			this.columnOrRow = this.getGridY();
			this.positionOnOtherAxis = this.getYCoord();
			//System.out.println(this.columnOrRow.toString());
		}
	}
	Pacman alternate() {
		return new ScaryPacman(this);
	}
	WorldImage render() {
		return new DiskImage(
				new Posn(this.getXCoord(),this.getYCoord()+Constants.gridsize),
				Constants.gridsize/3,
				new Yellow());
	}
}
