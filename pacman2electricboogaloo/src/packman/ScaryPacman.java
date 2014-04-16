package packman;

import javalib.colors.*;
import javalib.worldimages.*;

public class ScaryPacman extends Pacman {
	Integer timer = 600;
	
	ScaryPacman(boolean v, boolean p, Integer c, Integer pa, Integer sn, boolean si, Integer sc, Integer l) {
		super(v, p, c, pa,sn,si,sc,l);
	}
	ScaryPacman(Pacman p) {
		super(p.verticalDirection,p.positiveDirection,
				p.columnOrRow,p.positionOnOtherAxis,
				p.spriteNumber,p.spriteIncreasing,p.score,p.lives);
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
	}
	Pacman alternate() {
		return new Pacman(this);
	}
	WorldImage render() {
		return new DiskImage(
				new Posn(this.getXCoord(),this.getYCoord()+Constants.gridsize),
				Constants.gridsize/3,
				new Red());
	}
}

