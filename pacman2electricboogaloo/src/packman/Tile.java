package packman;

import java.awt.Color;

import javalib.colors.*;
import javalib.worldimages.*;

interface Tile {
	WorldImage render(Posn loc);
	Tile eat(Pacman p);
	boolean traversable();
	boolean isEatable();
}

abstract class Eatable implements Tile {
	public boolean traversable() {
		return true;
	}
	public boolean isEatable() {
		return true;
	}
}

class Pellet extends Eatable {
	public Tile eat(Pacman p) {
		p.score += 10;
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
		p.score += 50;
		p.eatScaryPill();
		return new Path();
	}
	public WorldImage render(Posn loc) {
		return new OverlayImages(
				new RectangleImage(loc,Constants.gridsize,Constants.gridsize,new Black()),
				new DiskImage(loc,Constants.gridsize/4,new White()));
	}
}

class Fruit extends Eatable {
	Integer val;
	String filename;
	Fruit(Integer v,String f) {
		this.val = v;
		this.filename = f;
	}
	public Tile eat(Pacman p) {
		p.score += val;
		return new Path();
	}
	public WorldImage render(Posn loc) {
		return new OverlayImages(
				new RectangleImage(loc,Constants.gridsize,Constants.gridsize,new Black()),
				new FromFileImage(loc,this.filename));
	}
}

class Wall implements Tile {
	public boolean traversable() {
		return false;
	}
	public boolean isEatable() {
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
	public boolean isEatable() {
		return false;
	}
	public Tile eat(Pacman p) {
		return this;
	}
	public WorldImage render (Posn loc) {
		return new RectangleImage(loc,Constants.gridsize,Constants.gridsize,new Black());
	}
}

