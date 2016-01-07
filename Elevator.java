/* Author: Natalia Chernenko
* 
* Programming Challenge for KualiCo
*
* Elevator class: The elevator travels between floors when given the request to do so. 
* After 100 trips, the elevator shuts down for service. 
*
*/

public class Elevator {

	private int maxFloors = 1;
	private int minFloor = 1;
	private int numTrips = 0;
	private int currentFloor = 1;
	private int destination = 1;
	private long msBetweenFloors = 5000;
	private boolean occupied = false;
	private boolean moving = false;
	private boolean inService = true;

	/* Initializes an Elevator with a maximum number of floors.
	*  The minimum is 1, so there are no basements allowed in this simulation.
	*  This can be further extended at a later time, if the need for basement
	*  travel is required.
	*/
	public Elevator(int maxFloors){
		if (maxFloors > 0) {
			this.maxFloors = maxFloors;
		}
	}

	/* 
	*  Instructs the Elevator to go to a certain floor.
	*/
	public void goToFloor(int floor){
		if (floor > minFloor && floor <= maxFloors){
			this.moving = true;
			this.destination = floor;
			this.numTrips++;
			this.motionSim();
		}
		else {
			throw IllegalArgumentException("invalid floor request");
		}
	}
	
	/*
  	* This method simulates a passenger request for a floor from inside an elevator.
        */
  	public void floorRequestInside(int floor){
    		//validate floor
    		if(floor > maxFloors || floor < minFloor){
    			throw IllegalArgumentException("invalid floor request from inside elevator");
    		}
    		this.setOccupied(true);
    		this.goToFloor(floor);
  	}
  	
  	/* 
  	* This method is triggered when the elevator arrives at its destination.
  	*/
  	public void elevatorArrived(){
    		this.setOccupied(false);
    		this.moving = false;
  	}
  
	
	/*
	* Returns whether the elevator is occupied
	*/
	public boolean isOccupied(){
		return this.occupied;
	}
	
	/* Sets whether the elevator is occupied
	*/
	public void setOccupied(boolean occupied){
		this.occupied = occupied;
	}
	
	/* Returns whether the elevator is moving
	*/
	public boolean isMoving(){
		return this.moving;
	}
	
	/* Returns whether the elevator is in service.
	* Currently the elevator is out of service after 100 trips.
	*/
	public boolean isInService(){
		return this.inService;
	}
	
	/* Returns the current floor at which the elevator is located
	*/
	public int currentFloor(){
		return this.currentFloor;
	}
	
	/* Is the floor on the way
	*/
	public boolean isFloorOnTheWay(int floor){
		if (currentFloor < destination){
			return floor >= currentFloor && floor <= destination;
		}
		else{
			return floor <= currentFloor && floor >= destination;
		}
	}
	
	/* 
	* This method simulates the motion of the elevator.
	* It relies on a given rate of motion between floors.
	*/
	private void motionSim(){
		while(this.currentFloor != this.destination){
			if(this.currentFloor < this.destination){
				try {
    					Thread.sleep(msBetweenFloors);
    					this.currentFloor++;
				} catch (InterruptedException e) {
    					e.printStackTrace();
				}	
			} else {
				try{
					Thread.sleep(msBetweenFloors);
					this.currentFloor--;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		this.elevatorArrived(this.destination);
	}
	
	/*
	* Sets the rate of motion between floors in milliseconds.
	* This value must be positive.
	*/
	public void setRate(long rate) {
		if rate < 1 {
			throw IllegalArgumentException("invalid rate of motion for elevator")
		}
		this.msBetweenFloors = rate;
	}
	
	/* Services the elevator.
	*  It will be good for 100 more trips.
	*/
	public void serviceElevator(){
		this.numTrips = 0;
		this.inService = true;
	}
}
