package packman;

import java.util.*;
import tester.*;

class Constants {

	// NOTA BENE: If you ever make this an odd number,
	// you'd better fucking know what you're getting into.
	public static Integer gridsize = 40;
	public static Tile[][] testmap = {
		{new Path(), new Pellet(), new Pellet(), new Path()},
		{new Path(), new Pellet(), new Pellet(), new Path()},
		{new Pellet(), new Wall(), new Pellet(), new Pellet()},
		{new Pill(), new Wall(), new Wall(), new Pill()},
		{new Path(), new Pellet(), new Pellet(), new Path()}
	};
}

class ExamplePacman {
	Pacman ex = new Pacman(false,true,1,45,0,true,0);
    Worldstate w1 = new Worldstate(ex,new ArrayList<Ghost>(),new Map(Constants.testmap));
    /*
    void test(Tester t) {
    	t.checkExpect(this.ex.dnx(),0);
    	t.checkExpect(this.ex.dny(),1);
    	this.w1.onKeyEvent("up");
    	t.checkExpect(this.ex.dnx(),-1);
    	t.checkExpect(this.ex.dny(),0);
    }
    */
	
	// run the first game	
	boolean runAnimation = this.w1.bigBang(500,700,.1);
}
