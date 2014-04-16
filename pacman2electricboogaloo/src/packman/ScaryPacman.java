package packman;

import javalib.colors.*;
import javalib.worldimages.*;

public class ScaryPacman extends Pacman {
	Integer timer = 600;
	
	ScaryPacman(boolean v, boolean p, Integer c, Integer pa, Integer sc, Integer l) {
		super(v, p, c, pa,sc,l);
	}
	ScaryPacman(Pacman p) {
		super(p.verticalDirection,p.positiveDirection,
				p.columnOrRow,p.positionOnOtherAxis,p.score,p.lives);
		this.nextPositive = p.nextPositive;
		this.nextVertical = p.nextVertical;
	}
	
	void eatScaryPill() {
		this.timer = 600;
	}
	void onTick(Map m) {
		this.timer = this.timer - 1;
		if(this.timer == 0) {
			this.toggleScary = true;
		}
		this.move(m);
		this.chomp();
	}
	Pacman alternate() {
		return new Pacman(this);
	}
	void hitGhost(Ghost g) {
		g.columnOrRow = 8;
		g.positionOnOtherAxis = 315;
		g.verticalDirection = false;
	}
	WorldImage render() {
		return new FromFileImage(
				new Posn(this.getXCoord(),this.getYCoord()+Constants.gridsize),
				"PacImages/Scary"+this.spriteNumber.toString()+".png");
	}
}

