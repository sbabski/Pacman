package packman;

import java.util.*;
import tester.*;

class Constants {

	// NOTA BENE: If you ever make this an odd number,
	// you'd better fucking know what you're getting into.
	public static Integer gridsize = 30;
	public static Tile[] wall =
		{new Wall(),new Wall(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Wall(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Wall(),new Wall(),new Wall()};
	//No walls
	public static Tile[] zero =
		{new Wall(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Wall()};
	//1
	public static Tile[] one =
		{new Wall(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Wall(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Wall()};
	//3 3 1 3 3
	public static Tile[] two = 
		{new Wall(),new Pellet(),new Wall(),new Wall(),new Wall(),
		new Pellet(),new Wall(),new Wall(),new Wall(),new Pellet(),new Wall(),
		new Pellet(),new Wall(),new Wall(),new Wall(),new Pellet(),
		new Wall(),new Wall(),new Wall(),new Pellet(),new Wall()};
	//two, but pills on sides
	public static Tile[] twoPill = 
		{new Wall(),new Pill(),new Wall(),new Wall(),new Wall(),
		new Pellet(),new Wall(),new Wall(),new Wall(),new Pellet(),new Wall(),
		new Pellet(),new Wall(),new Wall(),new Wall(),new Pellet(),
		new Wall(),new Wall(),new Wall(),new Pill(),new Wall()};
	//3 1 5 1 3
	public static Tile[] three =
		{new Wall(),new Pellet(),new Wall(),new Wall(),new Wall(),
		new Pellet(),new Wall(),new Pellet(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Pellet(),new Wall(),new Pellet(),
		new Wall(),new Wall(),new Wall(),new Pellet(),new Wall()};
	//1 1 1
	public static Tile[] four =
		{new Wall(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Pellet(),new Wall(),new Pellet(),new Pellet(),new Pellet(),new Wall(),
		new Pellet(),new Pellet(),new Pellet(),new Wall(),new Pellet(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Wall()};
	//4 3 1 3 4
	public static Tile[] five =
		{new Wall(),new Wall(),new Wall(),new Wall(),new Wall(),
		new Pellet(),new Wall(),new Wall(),new Wall(),new Path(),new Wall(),
		new Path(),new Wall(),new Wall(),new Wall(),new Pellet(),
		new Wall(),new Wall(),new Wall(),new Wall(), new Wall()};
	// paths on sides
	public static Tile[] six =
		{new Path(),new Path(),new Path(),new Path(),new Wall(),
		new Pellet(),new Wall(),new Path(),new Path(),new Path(),new Path(),
		new Path(),new Path(),new Path(),new Wall(),new Pellet(),
		new Wall(),new Path(),new Path(),new Path(), new Path()};
	//4 1 5 1 4
	public static Tile[] seven =
		{new Wall(),new Wall(),new Wall(),new Wall(),new Wall(),
		new Pellet(),new Wall(),new Path(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Path(),new Wall(),new Pellet(),
		new Wall(),new Wall(),new Wall(),new Wall(), new Wall()};
	//center
	public static Tile[] eight =
		{new Path(),new Path(),new Path(),new Path(),new Path(),
		new Pellet(),new Path(),new Path(),new Wall(),new Path(),new Path(),
		new Path(),new Wall(),new Path(),new Path(),new Pellet(),
		new Path(),new Path(),new Path(),new Path(),new Path()};
	//1 1
	public static Tile[] nine = 
		{new Wall(),new Pill(),new Pellet(),new Pellet(),new Wall(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Wall(),new Pellet(),new Pellet(),new Pill(),new Wall()};
	//2 1 1 5 1 1 2
	public static Tile[] ten = 
		{new Wall(),new Wall(),new Wall(),new Pellet(),new Wall(),
		new Pellet(),new Wall(),new Pellet(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Pellet(),new Wall(),new Pellet(),
		new Wall(),new Pellet(),new Wall(),new Wall(),new Wall()};
	//7 1 7	
	public static Tile[] eleven =
		{new Wall(),new Pellet(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Wall(),new Wall(),new Pellet(),new Wall(),
		new Pellet(),new Wall(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Wall(),new Pellet(),new Wall()};
			
	public static Tile[] a =
		{new Wall(),new Pellet(),new Pellet(),new Pellet(),new Wall(),
		new Pellet(),new Pellet(),new Pellet(),new Wall(),new Pellet(),new Wall(),
		new Pellet(),new Wall(),new Pellet(),new Pellet(),new Pellet(),
		new Wall(),new Pellet(),new Pellet(),new Pellet(),new Wall()};
	public static Tile[] b =
		{new Wall(),new Wall(),new Wall(),new Pellet(),new Wall(),
		new Pellet(),new Wall(),new Pellet(),new Wall(),new Pellet(),new Pellet(),
		new Pellet(),new Wall(),new Pellet(),new Wall(),new Pellet(),
		new Wall(),new Pellet(),new Wall(),new Wall(),new Wall()};
	public static Tile[] c =
		{new Path(),new Path(),new Wall(),new Pellet(),new Wall(),
		new Pellet(),new Wall(),new Pellet(),new Wall(),new Pellet(),new Wall(),
		new Pellet(),new Wall(),new Pellet(),new Wall(),new Pellet(),
		new Wall(),new Pellet(),new Wall(),new Path(),new Path()};
	public static Tile[] d =
		{new Path(),new Path(),new Wall(),new Pellet(),new Pellet(),
		new Pellet(),new Wall(),new Pellet(),new Pellet(),new Pellet(),new Wall(),
		new Pellet(),new Pellet(),new Pellet(),new Wall(),new Pellet(),
		new Pellet(),new Pellet(),new Wall(),new Path(),new Path()};
	public static Tile[] e =
		{new Path(),new Path(),new Wall(),new Pellet(),new Wall(),
		new Wall(),new Wall(),new Pellet(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Pellet(),new Wall(),new Wall(),
		new Wall(),new Pellet(),new Wall(),new Path(),new Path()};
	public static Tile[] f =
		{new Path(),new Path(),new Wall(),new Pellet(),new Pellet(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Pellet(),new Pellet(),new Pellet(),new Pellet(),new Pellet(),
		new Pellet(),new Pellet(),new Wall(),new Path(),new Path()};
	public static Tile[] g =
		{new Wall(),new Wall(),new Wall(),new Pellet(),new Wall(),
		new Pellet(),new Wall(),new Pellet(),new Wall(),new Wall(),new Wall(),
		new Wall(),new Wall(),new Pellet(),new Wall(),new Pellet(),
		new Wall(),new Pellet(),new Wall(),new Wall(),new Wall()};
	public static Tile[] h =
		{new Path(),new Path(),new Path(),new Path(),new Wall(),
		new Pellet(),new Wall(),new Path(),new Wall(),new Path(),new Path(),
		new Path(),new Wall(),new Path(),new Wall(),new Pellet(),
		new Wall(),new Path(),new Path(),new Path(),new Path()};
	
	public static Tile[][] testmap = 
		{Constants.wall,Constants.one,Constants.two,
		Constants.twoPill,Constants.zero,Constants.three,
		Constants.four,Constants.five,Constants.six,
		Constants.seven,Constants.eight,Constants.seven.clone(),
		Constants.six.clone(),Constants.seven.clone(),Constants.one.clone(),
		Constants.two.clone(),Constants.nine,Constants.ten,
		Constants.four.clone(),Constants.eleven,Constants.zero.clone(),
		Constants.wall.clone()};
	public static Tile[][] testmapTwo =
		{Constants.wall,Constants.one,Constants.twoPill,
		Constants.a,Constants.b,Constants.c,
		Constants.d,Constants.e,Constants.f,
		Constants.g,Constants.h};
	public static Integer mapWidth = Constants.testmap[0].length;
}

class ExamplePacman {
	Pacman ex = new Pacman(false,true,1,45,0,true,0,3);
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
	boolean runAnimation = this.w1.bigBang(630,700,.02);
}
