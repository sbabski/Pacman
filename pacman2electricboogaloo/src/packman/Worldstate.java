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
	Integer levelIndex = 0;

	Worldstate(Pacman p, Ghost[] g, Map m){
		this.player = p;
		this.enemies = g;
		this.map = m;
	}
	
	public World onTick() {
		player.onTick(map);
		if(map.levelSwitch) {
			this.switchLevel();
			player.positiveDirection = Constants.startP;
			player.verticalDirection = Constants.startV;
			player.columnOrRow = Constants.startX;
			player.positionOnOtherAxis = Constants.startY;
		}
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
	public void switchLevel() {
		this.levelIndex = ((this.levelIndex + 1) % 3);
		map.board = Constants.boards[this.levelIndex];
	}
	public WorldImage renderGhosts(Integer i) {
		WorldImage r = enemies[i-1].render();
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
	public WorldEnd worldEnds() {
		if(this.player.lives == 0) {
			return new WorldEnd(
					true,new OverlayImages(
							this.makeImage(),
							new OverlayImages(
									new TextImage(
											new Posn(Constants.mapWidth * Constants.gridsize/2,200),
											"GAME OVER",
											40,1,new Red()),
									new TextImage(
											new Posn(Constants.mapWidth * Constants.gridsize/2,400),
											"YOUR SCORE: "+this.player.score.toString(),
											30,1,new Red()))));
		} else {
			return new WorldEnd(false,this.makeImage());
		}
	}

}
