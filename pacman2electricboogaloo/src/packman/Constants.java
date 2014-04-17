package packman;

import java.util.*;
import tester.*;

class Constants {

	// NOTA BENE: If you ever make this an odd number,
	// you'd better fucking know what you're getting into.
	public static Integer gridsize = 30;
	
	public static Fruit cherry = new Fruit(100,"PacImages/Cherry.png");
	public static Fruit apple = new Fruit(200,"PacImages/Apple.png");
	public static Wall wall = new Wall();
	public static Pellet pell = new Pellet();
	public static Pill pill = new Pill();
	public static Path path = new Path();
	
	public static Tile[] border = {wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall,wall};
	public static Tile[] zero = {wall,pell,pell,pell,pell,pell,cherry,pell,pell,pell,pell,pell,pell,pell,apple,pell,pell,pell,pell,pell,wall};
	public static Tile[] one = {wall,pell,pell,pell,pell,pell,pell,pell,pell,pell,wall,pell,pell,pell,pell,pell,pell,pell,pell,pell,wall};
	public static Tile[] two = {wall,pell,wall,wall,wall,pell,wall,wall,wall,pell,wall,pell,wall,wall,wall,pell,wall,wall,wall,pell,wall};
	public static Tile[] twoPill = {wall,pill,wall,wall,wall,pell,wall,wall,wall,pell,wall,pell,wall,wall,wall,pell,wall,wall,wall,pill,wall};
	public static Tile[] three = {wall,pell,wall,wall,wall,pell,wall,pell,wall,wall,wall,wall,wall,pell,wall,pell,wall,wall,wall,pell,wall};
	public static Tile[] four = {wall,pell,pell,pell,pell,pell,wall,pell,pell,pell,wall,pell,pell,pell,wall,pell,pell,pell,pell,pell,wall};
	public static Tile[] five =	{wall,wall,wall,wall,wall,pell,wall,wall,wall,path,wall,path,wall,wall,wall,pell,wall,wall,wall,wall,wall};
	public static Tile[] six = {path,path,path,path,wall,pell,wall,path,path,path,path,path,path,path,wall,pell,wall,path,path,path,path};
	public static Tile[] seven = {wall,wall,wall,wall,wall,pell,wall,path,wall,wall,wall,wall,wall,path,wall,pell,wall,wall,wall,wall,wall};
	public static Tile[] eight = {path,path,path,path,path,apple,path,path,wall,path,path,path,wall,path,path,cherry,path,path,path,path,path};
	public static Tile[] nine = {wall,pill,pell,pell,wall,pell,pell,pell,pell,pell,pell,pell,pell,pell,pell,pell,wall,pell,pell,pill,wall};
	public static Tile[] ten = {wall,wall,wall,pell,wall,pell,wall,pell,wall,wall,wall,wall,wall,pell,wall,pell,wall,pell,wall,wall,wall};	
	public static Tile[] eleven = {wall,pell,wall,wall,wall,wall,wall,wall,wall,pell,wall,pell,wall,wall,wall,wall,wall,wall,wall,pell,wall};
			
	public static Tile[] a = {wall,pell,pell,pell,wall,pell,pell,pell,wall,pell,wall,pell,wall,pell,pell,pell,wall,pell,pell,pell,wall};
	public static Tile[] b = {wall,wall,wall,pell,wall,pell,wall,cherry,wall,pell,pell,pell,wall,apple,wall,pell,wall,pell,wall,wall,wall};
	public static Tile[] c = {path,path,wall,pell,wall,pell,wall,pell,wall,pell,wall,pell,wall,pell,wall,pell,wall,pell,wall,path,path};
	public static Tile[] d = {path,path,wall,pell,pell,pell,wall,pell,pell,pell,wall,pell,pell,pell,wall,pell,pell,pell,wall,path,path};
	public static Tile[] e = {path,path,wall,pell,wall,wall,wall,pell,wall,wall,wall,wall,wall,pell,wall,wall,wall,pell,wall,path,path};
	public static Tile[] f = {path,path,wall,apple,pell,pell,pell,pell,pell,pell,pell,pell,pell,pell,pell,pell,pell,cherry,wall,path,path};
	public static Tile[] g = {wall,wall,wall,path,wall,pell,wall,path,wall,wall,wall,wall,wall,path,wall,pell,wall,path,wall,wall,wall};
	public static Tile[] h = {path,path,path,path,wall,pell,wall,path,wall,path,path,path,wall,path,wall,pell,wall,path,path,path,path};
	public static Tile[] i = {wall,wall,wall,path,wall,pell,wall,wall,wall,path,wall,path,wall,wall,wall,pell,wall,path,wall,wall,wall};
	public static Tile[] j = {wall,pill,pell,pell,wall,apple,pell,pell,pell,pell,pell,pell,pell,pell,pell,cherry,wall,pell,pell,pill,wall};
	
	public static Tile[] k = {wall,pill,wall,pell,pell,pell,wall,pell,pell,pell,wall,pell,pell,pell,wall,pell,pell,pell,wall,pill,wall};
	public static Tile[] l = {wall,pell,wall,pell,wall,wall,wall,path,wall,pell,wall,pell,wall,path,wall,wall,wall,pell,wall,pell,wall};
	public static Tile[] m = {wall,pell,wall,wall,wall,pell,wall,path,wall,pell,pell,pell,wall,path,wall,pell,wall,wall,wall,pell,wall};
	public static Tile[] n = {wall,cherry,pell,pell,pell,pell,wall,path,wall,wall,wall,wall,wall,path,wall,pell,pell,pell,pell,apple,wall};
	public static Tile[] o = {wall,wall,wall,pell,wall,pell,path,path,path,path,path,path,path,path,path,pell,wall,pell,wall,wall,wall};
	public static Tile[] p = {path,path,wall,pell,wall,pell,wall,path,wall,wall,wall,wall,wall,path,wall,pell,wall,pell,wall,path,path};
	public static Tile[] q = {path,path,wall,pell,pell,pell,wall,path,wall,path,path,path,wall,path,wall,pell,pell,pell,wall,path,path};
	public static Tile[] r = {path,path,wall,pell,wall,wall,wall,path,wall,wall,wall,wall,wall,path,wall,wall,wall,pell,wall,path,path};
	public static Tile[] s = {path,path,wall,apple,path,path,path,path,path,path,path,path,path,path,path,path,path,cherry,wall,path,path};
	public static Tile[] t = {wall,wall,wall,pell,wall,wall,wall,wall,wall,path,wall,path,wall,wall,wall,wall,wall,pell,wall,wall,wall};
	public static Tile[] u = {path,path,path,pell,wall,pell,pell,pell,pell,pell,wall,pell,pell,pell,pell,pell,wall,pell,path,path,path};
	public static Tile[] v = {wall,wall,wall,pell,wall,pell,wall,cherry,wall,wall,wall,wall,wall,apple,wall,pell,wall,pell,wall,wall,wall};
	public static Tile[] w = {wall,pell,pell,pell,pell,pell,wall,pell,pell,pell,pell,pell,pell,pell,wall,pell,pell,pell,pell,pell,wall};
	public static Tile[] x = {wall,pell,wall,pell,pell,pell,pell,pell,pell,pell,wall,pell,pell,pell,pell,pell,pell,pell,wall,pell,wall};
	public static Tile[] y = {wall,pell,wall,pell,wall,wall,wall,pell,wall,wall,wall,wall,wall,pell,wall,wall,wall,pell,wall,pell,wall};
	public static Tile[] z = {path,pell,pell,pell,pell,pell,wall,path,wall,pell,wall,pell,wall,path,wall,pell,pell,pell,pell,pell,path};	

	
	public static Tile[][] levelOne = 
		{Constants.border,Constants.one,Constants.two,Constants.twoPill,Constants.zero,Constants.three,
		Constants.four,Constants.five,Constants.six,Constants.seven,Constants.eight,Constants.seven.clone(),
		Constants.six.clone(),Constants.seven.clone(),Constants.one.clone(),Constants.two.clone(),Constants.nine,Constants.ten,
		Constants.four.clone(),Constants.eleven,Constants.zero.clone(),Constants.border.clone()};
	public static Tile[][] levelTwo =
		{Constants.border,Constants.one,Constants.twoPill,Constants.a,Constants.b,Constants.c,
		Constants.d,Constants.e,Constants.f,Constants.g,Constants.h,Constants.seven,
		Constants.six,Constants.i,Constants.d.clone(),Constants.ten,Constants.j,Constants.two,
		Constants.four,Constants.three,Constants.zero,Constants.border.clone()};
	
	public static Tile[][] levelThree =
		{Constants.border,Constants.zero,Constants.three,Constants.k,Constants.l,Constants.z,
		Constants.m,
		Constants.n,Constants.o,Constants.p,Constants.q,Constants.r,Constants.s,
		Constants.t,Constants.u,Constants.v,Constants.w,Constants.twoPill,Constants.x,
		Constants.y,Constants.zero.clone(),Constants.border.clone()
		};
			
	
	public static Integer mapWidth = Constants.levelOne[0].length;
	public static Integer startX = 16;
	public static Integer startY = 315;
	public static boolean startV = false;
	public static boolean startP = true;
}

class ExamplePacman {
	Pacman p = new Pacman(Constants.startV,Constants.startP,Constants.startX,Constants.startY,0,3);
	Ghost[] g = 
		{new Blinky(true,false,8,255),new Inky(true,false,12,255),new Pinky(true,false,8,375),new Sue(true,false,12,375)};
    Worldstate w1 = new Worldstate(p,g,new Map(Constants.levelThree));	
	
	// run the first game	
	boolean runAnimation = this.w1.bigBang(630,700,.01);
}
