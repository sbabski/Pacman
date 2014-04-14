package packman;

import java.util.*;
import java.awt.Color;

import tester.*;
import javalib.funworld.*;
import javalib.colors.*;
import javalib.worldcanvas.*;
import javalib.worldimages.*;
	

public class Worldstate extends World{
	Pacman player;
	ArrayList<Ghost> enemies;
	Map map;

	Worldstate(Pacman p, ArrayList<Ghost> e, Map m){
		this.player = p;
		this.enemies = e;
		this.map = m;
	}
	
	public World onTick() {
		if(player.toggleScary) {
			player.alternate();
		}
		player.onTick(map);
		for(Ghost g : enemies) {
			g.move(map);
		}
		return this;
	}
	public World onKeyEvent(String ke) {
		if(ke.equals("up")) {
			this.player.nextPositive = false;
			this.player.nextVertical = true;
		} else {
			if(ke.equals("down")) {
				this.player.nextPositive = true;
				this.player.nextVertical = true;
			} else {
				this.player.nextVertical = false;
				if(ke.equals("left")) {
					this.player.nextPositive = false;
				} else {
					this.player.nextPositive = true;
				}
			}
		}
		return this;
	}

	public WorldImage makeImage() {
		return new OverlayImages(map.render(),player.render());
	}

}
