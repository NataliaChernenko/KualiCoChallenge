/* Author: Natalia Chernenko
* 
* Programming Challenge for KualiCo
*
* Elevator class: The elevator travels between floors when given the request to do so. 
* After 100 trips, the elevator shuts down for service. 
*
*/

public class Elevator {

	private int maxFloors;
	private int numTrips;

	/* Initializes an Elevator with a maximum number of floor.
	*  The minimum is 1, so there are no basements allowed in this simulation.
	*  This can be further extended at a later time, if the need for basement
	*  travel is required.
	*/
	public Elevator(int maxFloors){
		if (maxFloors >= 1) {
			this.maxFloors = maxFloors;
		}
	}

}
