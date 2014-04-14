package packman;

public abstract class Character {
	
	// I feel a bit bad about this data structure, so let me explain,
	// Both of the booleans let you know direction,
	// So if we're going vertical, the first integer is the index of the direction
	// in the direction that's being gone or something?????
	// and then positionOnOtherAxis is well, that.
	
	boolean verticalDirection;
	boolean positiveDirection;
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
			return this.positionOnOtherAxis / Constants.gridsize;
		}
	}
	
	Integer getGridY() {
		if(!this.verticalDirection){
			return this.columnOrRow;
		} else {
			return this.positionOnOtherAxis / Constants.gridsize;
		}
	}
	
	boolean atIntersection() {
		if(this.positiveDirection) {
			return this.positionOnOtherAxis % Constants.gridsize == Constants.gridsize/2 - 1;
		} else {
			return this.positionOnOtherAxis % Constants.gridsize == Constants.gridsize/2;
		}
	}
	
	abstract void move(Map m);
}
