package packman;

import java.awt.Color;

import javalib.colors.*;
import javalib.worldimages.*;

public abstract class Ghost extends Character {
	String filename;
	Integer timer = 0;
	
	Ghost(boolean v, boolean p, Integer c, Integer pa) {
		super(v, p, c, pa);
	}
	
	void onTick(Map m,Pacman p) {
		this.timer += 1;
		this.randomTurn();
		this.move(m);
		if(intersecting(p)) {
			p.hitGhost(this);
		}
	}
	void move(Map m) {
		if(this.flipping()) {
			this.positiveDirection = this.nextPositive;
		}
		if(this.atIntersection()) {
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
	void randomTurn() {
		if(this.timer % 100 == 0) {
			if(this.timer % 3 == 0) {
				this.nextPositive = true;
			}
			if(this.timer % 7 == 0 || this.timer % 9 == 0) {
				this.nextVertical = true;
			}
		}
	}
	WorldImage render() {
		return new FromFileImage(
				new Posn(this.getXCoord(),this.getYCoord()+Constants.gridsize),
				this.filename);
	}
	boolean intersecting(Pacman p) {
		Integer x = this.getXCoord() - p.getXCoord();
		Integer y = this.getYCoord() - p.getYCoord();
		return ((x*x) + (y*y)) < ((Constants.gridsize / 2) * (Constants.gridsize / 2));
	}

}

class Blinky extends Ghost {
	Blinky(boolean v,boolean p,Integer c,Integer pa) {
		super(v,p,c,pa);
		this.filename = "PacImages/Blinky.png";
	}
}
class Inky extends Ghost {
	Inky(boolean v,boolean p,Integer c,Integer pa) {
		super(v,p,c,pa);
		this.filename = "PacImages/Inky.png";
	}
}
class Pinky extends Ghost {
	Pinky(boolean v,boolean p,Integer c,Integer pa) {
		super(v,p,c,pa);
		this.filename = "PacImages/Pinky.png";
	}
}
class Sue extends Ghost {
	Sue(boolean v,boolean p,Integer c,Integer pa) {
		super(v,p,c,pa);
		this.filename = "PacImages/Sue.png";
	}
}