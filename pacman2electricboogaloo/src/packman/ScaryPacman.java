package packman;

public class ScaryPacman extends Pacman {
	Integer score;
	Integer timer = 600;
	Integer spriteNumber;
	boolean spriteIncreasing;
	
	ScaryPacman(boolean v, boolean p, Integer c, Integer pa, Integer sn, boolean si, Integer sc) {
		super(v, p, c, pa,sn,si,sc);
	}
	ScaryPacman(Pacman p) {
		super(p.verticalDirection,p.positiveDirection,
				p.columnOrRow,p.positionOnOtherAxis,
				p.spriteNumber,p.spriteIncreasing,p.score);
	}
}

