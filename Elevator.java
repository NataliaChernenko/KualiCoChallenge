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
	private int currentDestination = 1;
	private ArrayList<Integer> destinations;
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
		destinations = new ArrayList<Integer>();
	}

	/* 
	*  Instructs the Elevator to go to a certain floor.
	*/
	public void goToFloor(int floor){
		if (floor > minFloor && floor <= maxFloors){
			this.moving = true;
			if (!destinations.contains(floor)){
				this.destinations.add(floor);
			}
			this.currentDestination = findClosestDest();
			this.numTrips++;
			this.motionSim();
		}
		else {
			throw IllegalArgumentException("invalid floor request");
		}
	}
	
	/*
	* Finds the closest destination
	*/
	private int findClosestDest(){
		int closest = maxFoors;
		while(destinations.hasNext()){
			int diff = absDiff(destinations.next(), currentFloor);
			if(diff < closest){
				closest = diff;
			}
		}
		return closest;
	}
	
	/* returns positive difference in floors */
  	private int absDiff(int a, int b){
    		if(a < b){
      			return b-a;
		} else {
      			return a-b;
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
    		setOccupied(true);
    		goToFloor(floor);
  	}
  	
  	/* 
  	* This method is triggered when the elevator arrives at its destination.
  	*/
  	public void elevatorArrived(){
    		setOccupied(false);
    		moving = false;
    		destinations.remove(Integer.valueOf(currentDestination));
    		if (!destinations.isEmpty()) {
    			goToFloor(destinations(0));
    		}
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
	public boolean isFloorOnTheWay(int floor, boolean goingUp){
		if (currentFloor < currentDestination && goingUp){
			return floor >= currentFloor && floor <= currentDestination;
		}
		else if (!goingUp) {
			return floor <= currentFloor && floor >= currentDestination;
		}
		else {
			return false;
		}
	}
	
	/* 
	* This method simulates the motion of the elevator.
	* It relies on a given rate of motion between floors.
	*/
	private void motionSim(){
		while(this.currentFloor != this.currentDestination){
			if(this.currentFloor < this.currentDestination){
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
		this.elevatorArrived();
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
