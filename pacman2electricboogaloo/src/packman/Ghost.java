package packman;

import java.awt.Color;
import java.util.Random;

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
		this.move(m, p);
		if(intersecting(p)) {
			p.hitGhost(this);
		}
	}
	void move(Map m, Pacman p) {
		if(this.flipping()) {
			this.positiveDirection = this.nextPositive;
		}
		if(this.atIntersection()) {
			Integer n = this.directionsGoable(m);
			if(n == 2) {
				this.followPath(m);
			} else {
				Random r = new Random();
				Integer i = r.nextInt(5);
				if(!(this.canContinue(m))) {
					this.nextVertical = !this.verticalDirection;
					this.nextPositive = (this.otherDirectionPacDist(p) > 0);
					if(i == 3) {
						this.nextPositive = !this.nextPositive;
					}
				} else {
					if(Math.abs(this.thisDirectionPacDist(p)) > 
					Math.abs(this.otherDirectionPacDist(p))) {
						this.nextVertical = !this.verticalDirection;
						if(!this.canGoNextDirection(m)) {
							this.nextPositive = !this.positiveDirection;	
						} else {
							if(n == 4) {
								this.nextPositive = (this.otherDirectionPacDist(p) > 0);
							}
						}
						if(i == 3) {
							this.nextPositive = !this.nextPositive;
						}
					}
				}
			}
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
	Integer otherDirectionPacDist(Pacman p){
		if (this.verticalDirection){
			return this.xPacDist(p);
		} else {
			return this.yPacDist(p);
		}
	}
	Integer thisDirectionPacDist(Pacman p) {
		if(!this.verticalDirection) {
			return this.xPacDist(p);
		} else {
			return this.yPacDist(p);
		}
	}
	Integer xPacDist(Pacman p) {
		return p.getGridX() - this.getGridX();
	}
	Integer yPacDist(Pacman p) {
		return p.getGridY() - this.getGridY();
	}
	void followPath(Map m) {
		if(this.canGoGivenDirection(m, this.dx(), this.dy())) {	
		} else {
			if(this.canGoGivenDirection(m, this.dy(), this.dx())) {
				this.nextVertical = !this.nextVertical;
			} else {
				this.nextPositive = !this.nextPositive;
				this.nextVertical = !this.nextVertical;
			}
		}
	}
	
	Integer directionsGoable(Map m) {
		Integer result = 0;
		if(this.canGoGivenDirection(m,1,0)) {
			result += 1;
		}
		if(this.canGoGivenDirection(m,0,1)) {
			result += 1;
		}
		if(this.canGoGivenDirection(m, -1, 0)) {
			result += 1;
		}
		if(this.canGoGivenDirection(m, 0, -1)) {
			result += 1;
		}
		return result;
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