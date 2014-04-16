package packman;

public abstract class Character {
	
	// I feel a bit bad about this data structure, so let me explain,
	// Both of the booleans let you know direction,
	// So if we're going vertical, the first integer is the index of the direction
	// in the direction that's being gone or something?????
	// and then positionOnOtherAxis is well, that.
	
	boolean verticalDirection;
	boolean positiveDirection;
	boolean nextVertical = verticalDirection;
	boolean nextPositive = positiveDirection;
	Integer columnOrRow;
	Integer positionOnOtherAxis;
	
	Integer speed;

	Character(boolean v, boolean p, Integer c, Integer pa) {
		this.verticalDirection = v;
		this.positiveDirection = p;
		this.columnOrRow = c;
		this.positionOnOtherAxis = pa;
		}
	
	
	Integer getXCoord() {
		if(this.verticalDirection){
			return Constants.gridsize * this.columnOrRow + (Constants.gridsize/2);
			//return Constants.gridsize * this.columnOrRow + (Constants.gridsize/2);
		} else { 
			return this.positionOnOtherAxis;
		} 
	}
	
	Integer getYCoord() {
		if(!this.verticalDirection){
			return Constants.gridsize * this.columnOrRow + (Constants.gridsize/2);
		} else {
			return this.positionOnOtherAxis;
		}
	}
	
	Integer getGridX() {
		if(this.verticalDirection){
			return this.columnOrRow;
		} else {
			return (this.positionOnOtherAxis / Constants.gridsize);
		}
	}
	
	Integer getGridY() {
		if(!this.verticalDirection){
			return this.columnOrRow;
		} else {
			return (this.positionOnOtherAxis / Constants.gridsize);
		}
	}
	Integer dx() {
		Integer x = 0;
		if(!this.verticalDirection) {
			if(this.positiveDirection) {
				x = 1;
			} else {
				x = -1;
			}
		}
		return x;
	}
	Integer dy() {
		Integer y = 0;
		if(this.verticalDirection) {
			if(this.positiveDirection) {
				y = 1;
			} else {
				y = -1;
			}
		}
		return y;
	}
	boolean canGoNextDirection(Map m) {
		Integer y = this.getGridY();
		Integer x = this.getGridX();
		y = ((y + this.dny()) % (m.yLength()-1));
		x = ((x + (m.xLength()-1) + this.dnx()) % (m.xLength()-1));
		return m.board[y][x].traversable();
	}
	Integer dnx() {
		Integer x = 0;
		if(!this.nextVertical) {
			if(this.nextPositive) {
				x += 1;
			} else {
				x += -1;
			}
		}
		return x;
	}
	Integer dny() {
		Integer y = 0;
		if(this.nextVertical) {
			if(this.nextPositive) {
				y += 1;
			} else {
				y += -1;
			}
		}
		return y;
	}
	boolean atIntersection() {
		if(this.positiveDirection) {
			return this.positionOnOtherAxis % Constants.gridsize == Constants.gridsize/2 - 1;
		} else {
			return this.positionOnOtherAxis % Constants.gridsize == Constants.gridsize/2;
		}
	}
	void goForth(Map m) {
		if(this.verticalDirection){
			this.positionOnOtherAxis = this.positionOnOtherAxis + this.dy();		
		} else {
			this.positionOnOtherAxis = ((this.positionOnOtherAxis + this.dx() + (Constants.gridsize*(m.yLength()-1))) % (Constants.gridsize*(m.yLength()-1)));
		}
	}
	boolean canContinue(Map m) {
		Integer y = this.getGridY();
		Integer x = this.getGridX();
		y = ((y + this.dy()) % (m.yLength()-1));
		x = ((x + (m.xLength()-1) + this.dx()) % (m.xLength()-1));
		return m.board[y][x].traversable();
	}
	boolean turning() {
		return this.nextVertical != this.verticalDirection;
	}
	boolean flipping() {
		return !this.turning() && (this.nextPositive != this.positiveDirection);
	}
	void switchDirection() {
		if(this.nextVertical) {
			Integer c = this.getGridX();
			this.positionOnOtherAxis = this.getYCoord();
			this.columnOrRow = c;
		} else {
			Integer c = this.getGridY();
			this.positionOnOtherAxis = this.getXCoord();
			this.columnOrRow = c;
		}
		this.verticalDirection = this.nextVertical;
		this.positiveDirection = this.nextPositive;
	}
	abstract void move(Map m);

}
