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
  */
  public void sendClosestElevator(int requestingFloor) {
    int closestElevDistance = maxFloors;
    int closestElevIndex = 0;
    for(int i = 0; i < numElevators; i++){
       if(elevators[i].currentFloor() == requestingFloor && 
          !elevators[i].isOccupied() &&
          elevators[i].isInService()){
         elevators[i].setOccupied(true);
         elevators[i].goToFloor(requestingFloor);
         return;
       }
      if(elevators[i].isOccupied() && 
         elevators[i].isMoving() &&
         elevator[i].isFloorOnTheWay(requestingFloor)){
          elevators[i].goToFloor(requestingFloor);
          return;
      }
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
