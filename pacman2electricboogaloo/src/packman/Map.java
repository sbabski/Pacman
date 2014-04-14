package packman;

import javalib.colors.*;
import javalib.worldimages.*;

public class Map {
	Tile[][] board;
	
	Map(Tile[][] b) {
		this.board = b;
	}
	
	Integer xLength() {
		return this.board[0].length;
	}
	Integer yLength() {
		return this.board.length;
	}
	
	WorldImage render() {
		Integer w = Constants.gridsize * board[0].length;
		Integer h = Constants.gridsize * board.length;
		WorldImage result = new RectangleImage(new Posn(w/2,h/2),w,h,new Green());
		for(int i=0;i<board.length;i++) {
			WorldImage rowsult = 
					new RectangleImage(new Posn(w/2,Constants.gridsize/2),w,Constants.gridsize,new Black());
			for(int j=0;j<board[0].length;j++) {
				rowsult = 
					new OverlayImagesXY(rowsult,board[i][j].render(new Posn((j *Constants.gridsize) + Constants.gridsize/2,(i*Constants.gridsize) + (Constants.gridsize*3)/2)), Constants.gridsize * j, 0);
			}
			result = new OverlayImages(result,rowsult);
		}
		return result;
	}
}
