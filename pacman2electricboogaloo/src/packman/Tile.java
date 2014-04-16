package packman;

import javalib.colors.*;
import javalib.worldimages.*;

interface Tile {
	WorldImage render(Posn loc);
	Tile eat(Pacman p);
	boolean traversable();
}

abstract class Eatable implements Tile {
	public boolean traversable() {
		return true;
	}
}

class Pellet extends Eatable {
	public Tile eat(Pacman p) {
		p.score += 100;
		return new Path();
	}
	public WorldImage render(Posn loc) {
		return new OverlayImages(
				new RectangleImage(loc,Constants.gridsize,Constants.gridsize,new Black()),
				new DiskImage(loc,Constants.gridsize/8,new White()));
	}
}

class Pill extends Eatable {
	public Tile eat(Pacman p) {
		p.score += 500;
		p.eatScaryPill();
		return new Path();
	}
	public WorldImage render(Posn loc) {
		return new OverlayImages(
				new RectangleImage(loc,Constants.gridsize,Constants.gridsize,new Black()),
				new DiskImage(loc,Constants.gridsize/4,new White()));
	}
}

class Wall implements Tile {
	public boolean traversable() {
		return false;
	}
	public Tile eat(Pacman p) {
		return this;
	}
	public WorldImage render(Posn loc) {
		return new RectangleImage(loc,Constants.gridsize,Constants.gridsize,new Blue());
	}
}

class Path implements Tile {
	public boolean traversable() {
		return true;
	}
	public Tile eat(Pacman p) {
		return this;
	}
	public WorldImage render (Posn loc) {
		return new RectangleImage(loc,Constants.gridsize,Constants.gridsize,new Black());
	}
}

