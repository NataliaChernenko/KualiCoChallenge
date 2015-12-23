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
	private int numTrips = 0;
	private int currentFloor = 1;
	private boolean occupied = false;

	/* Initializes an Elevator with a maximum number of floor.
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
	public void goToFloor(int destination){
		
	}
	
}
