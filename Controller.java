/*
* KualiCo Programming Challenge
*
* Author: Natalia Chernenko
*
* This class controls a set of Elevators.
* This simulation assumes that a passenger requests an elevator to their floor from outside the elevator.
* The passenger then selects their destination once they are inside the elevator.
*/

public class Controller {
  
  private Elevator[] elevators;
  private numElevators = 0;
  private maxFloors = 1;
  private minFloors = 1;
  
  /* Creates a Controller for the specified number of elevators
  */
  public Controller(int numElevators, int maxFloors){
    if (numElevators > 0 && maxFloors > 0) {
      this.numElevators = numElevators;
      elevators = new Elevator[numElevators];
      for(int i = 0; i < numElevators; i++){
        elevators[i] = new Elevator(maxFloors);
      }
    }
    else {
      throw IllegalArgumentException("invalid arguments to Controller constructor")
    }
  }
  
  /* 
  * This method sends the closest elevator to a floor.
  * It simulates a passenger requesting an elevator.
  * requestingFloor is the floor at which the elevator is being requested
  * goingUp is the desired direction of travel; equivalent to pushing the "up" or "down" buttons
  */
  public void sendClosestElevator(int requestingFloor, boolean goingUp) {
    int closestElevDistance = maxFloors;
    int closestElevIndex = 0;
    for(int i = 0; i < numElevators; i++){
      //if an unoccupied elevator is already on the floor, it is the first choice
       if(elevators[i].currentFloor() == requestingFloor && 
          !elevators[i].isOccupied() &&
          elevators[i].isInService()){
         elevators[i].setOccupied(true);
         elevators[i].goToFloor(requestingFloor);
         return;
       }
      // if an occupied elevator is about to pass this floor on the way, it is the second choice 
      if(elevators[i].isOccupied() && 
         elevators[i].isMoving() &&
         elevator[i].isFloorOnTheWay(requestingFloor, goingUp)){
          elevators[i].goToFloor(requestingFloor);
          return;
      }
      //otherwise search for the closest elevator
      int diff = floorDiff(elevators[i].currentFloor, requestingFloor);
      if(diff < closestElevDistance){
        closestElevDistance = diff;
        closestElevIndex = i;
      }
    }
    elevators[closestElevIndex].goToFloor(requestingFloor);
  }
  
  /* returns positive difference in floors */
  private int floorDiff(int a, int b){
    if(a < b){
      return b-a;
    } else {
      return a-b;
    }
  }
  

}
