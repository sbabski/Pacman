package packman;

import java.awt.Color;
import javalib.colors.*;
import javalib.worldimages.*;

public abstract class Ghost extends Character {
	Color color;
	
	Ghost(boolean v, boolean p, Integer c, Integer pa, Color color) {
		super(v, p, c, pa);
		this.color = color;
	}

	void move(Map m) {
		
	}
	WorldImage render() {
		return new RectangleImage(
				new Posn(this.getXCoord(),this.getYCoord()+Constants.gridsize),
				Constants.gridsize/3,
				Constants.gridsize/2,
				color);
	}

}