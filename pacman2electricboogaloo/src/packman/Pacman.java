package packman;

public class Pacman extends Character {
	
	Integer spriteNumber;
	boolean spriteIncreasing;
	
	Pacman(boolean v, boolean p, Integer c, Integer pa, Integer sn, boolean si) {
		super(v, p, c, pa);
		this.spriteNumber = sn;
		this.spriteIncreasing = si;
	}

	
	
}
