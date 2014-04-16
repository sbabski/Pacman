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
	Ghost[] enemies;
	Map map;

	Worldstate(Pacman p, Ghost[] g, Map m){
		this.player = p;
		this.enemies = g;
		this.map = m;
	}
	
	public World onTick() {
		player.onTick(map);
		if(player.toggleScary) {
			player = player.alternate();
		}
		for(Ghost g : enemies) {
			g.onTick(map,player);
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
	public WorldImage renderGhosts(Integer i) {
		WorldImage r = enemies[i-1].render();
		if(i < 1) {
			throw new RuntimeException("HALP");
		}
		if(i == 1) {
			return r;
		} else {
			return new OverlayImages(this.renderGhosts(i - 1),r);
					
		}
	}

	public WorldImage makeImage() {
		return new OverlayImages(map.render(),
				new OverlayImages(this.renderGhosts(this.enemies.length),
						new OverlayImages(player.render(),
								new OverlayImages(player.renderScore(),player.renderLives(player.lives)))));
	}

}
