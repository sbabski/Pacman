package packman;

import javalib.colors.*;
import javalib.worldimages.*;

public class Pacman extends Character {
	Integer score;
	Integer lives;
	Integer spriteNumber = 0;
	boolean spriteIncreasing = true;
	boolean toggleScary = false;
	
	Pacman(boolean v, boolean p, Integer c, Integer pa, Integer sc, Integer l) {
		super(v, p, c, pa);
		this.score = sc;
		this.lives = l;
	}
	Pacman(Pacman p) {
		super(p.verticalDirection,p.positiveDirection,
				p.columnOrRow,p.positionOnOtherAxis);
		this.nextVertical = p.nextVertical;
		this.nextPositive = p.nextPositive;
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
		this.chomp();
	}
	void chomp() {
		if(this.spriteNumber == 6) {
			this.spriteIncreasing = false;
		}
		if(this.spriteNumber == 0) {
			this.spriteIncreasing = true;
		}
		if(this.spriteIncreasing) {
			this.spriteNumber++;
		} else {
			this.spriteNumber--;
		}
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
	Pacman alternate() {
		return new ScaryPacman(this);
	}
	void hitGhost(Ghost g) {
		this.lives -= 1;
		this.verticalDirection = Constants.startV;
		this.positiveDirection = Constants.startP;
		this.columnOrRow = Constants.startX;
		this.positionOnOtherAxis = Constants.startY;
	}
	WorldImage render() {
		return new FromFileImage(
				new Posn(this.getXCoord(),this.getYCoord()+Constants.gridsize),
				"PacImages/Pacman"+this.spriteNumber.toString()+".png");
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
		if(i < 1) {
			return this.renderLives(1);
		}
		WorldImage image = new FromFileImage(
				new Posn((Constants.mapWidth*Constants.gridsize) - (Constants.gridsize*i), Constants.gridsize / 2),
				"PacImages/Pacman4.png");
		if(i == 1) {
			return image;
		} else {
			return new OverlayImages(this.renderLives(i-1),image);
		}
	}
}
