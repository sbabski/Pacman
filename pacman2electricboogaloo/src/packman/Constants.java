package packman;

import java.util.*;

class Constants {

	// NOTA BENE: If you ever make this an odd number,
	// you'd better fucking know what you're getting into.
	public static Integer gridsize = 40;
	public static Tile[][] testmap = {
		{new Path(), new Pellet(), new Path()},
		{new Path(), new Pellet(), new Path()},
		{new Pellet(), new Wall(), new Pellet()},
		{new Pill(), new Wall(), new Pill()}
	};
}

class ExamplePacman {
	Pacman ex = new Pacman(false,true,2,45,0,true,0);
    Worldstate w1 = new Worldstate(ex,new ArrayList<Ghost>(),new Map(Constants.testmap));
    
	
	// run the first game	
	boolean runAnimation = this.w1.bigBang(500,700,10);
}
