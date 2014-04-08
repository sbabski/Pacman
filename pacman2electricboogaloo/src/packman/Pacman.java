package packman;

public class Pacman extends Character {
	Integer score;
	Integer spriteNumber;
	boolean spriteIncreasing;
	
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
}
