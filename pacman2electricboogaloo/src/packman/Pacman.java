package packman;

import javalib.colors.*;
import javalib.worldimages.*;

public class Pacman extends Character {
	Integer score;
	Integer lives;
	Integer spriteNumber;
	boolean spriteIncreasing;
	boolean toggleScary = false;
	
	Pacman(boolean v, boolean p, Integer c, Integer pa, Integer sn, boolean si, Integer sc, Integer l) {
		super(v, p, c, pa);
		this.spriteNumber = sn;
		this.spriteIncreasing = si;
		this.score = sc;
		this.lives = l;
	}
	Pacman(Pacman p) {
		super(p.verticalDirection,p.positiveDirection,
				p.columnOrRow,p.positionOnOtherAxis);
		this.spriteNumber = p.spriteNumber;
		this.spriteIncreasing = p.spriteIncreasing;
		this.score = p.score;
		this.lives = p.lives;
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
		y = ((y + this.dny()) % (m.yLength()-1));
		x = ((x + (m.xLength()-1) + this.dnx()) % (m.xLength()-1));
		return m.board[y][x].traversable();
	}
	boolean canContinue(Map m) {
		Integer y = this.getGridY();
		Integer x = this.getGridX();
		y = ((y + this.dy()) % (m.yLength()-1));
		x = ((x + (m.xLength()-1) + this.dx()) % (m.xLength()-1));
		return m.board[y][x].traversable();
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
			if(this.canContinue(m)) {
				this.goForth(m);
			}
		} else {
			this.goForth(m);
		}
	}
	void switchDirection() {
		if(this.nextVertical) {
			Integer c = this.getGridX();
			this.positionOnOtherAxis = this.getYCoord();
			this.columnOrRow = c;
		} else {
			Integer c = this.getGridY();
			this.positionOnOtherAxis = this.getXCoord();
			this.columnOrRow = c;
		}
		this.verticalDirection = this.nextVertical;
		this.positiveDirection = this.nextPositive;
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
	WorldImage renderScore() {
		return new TextImage(
			new Posn(Constants.gridsize,(Constants.gridsize / 2) + 4),
			this.score.toString(),
			20,
			1,
			new White());
	}
	WorldImage renderLives(Integer i) {
		if(i == 1) {
			return new DiskImage(
					new Posn((Constants.mapWidth*Constants.gridsize) - Constants.gridsize, Constants.gridsize / 2),
					Constants.gridsize/3,
					new Yellow());
		}
		return new OverlayImages(
				this.renderLives(i - 1),
				new DiskImage(
						new Posn((Constants.mapWidth*Constants.gridsize) - (Constants.gridsize * i), Constants.gridsize / 2),
						Constants.gridsize/3,
						new Yellow()));
	}
}
