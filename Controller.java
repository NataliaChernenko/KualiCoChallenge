/*
* KualiCo Programming Challenge
*
* Author: Natalia Chernenko
*
* This class controls a set of Elevators.
* This simulation assumes that the request a passenger makes from outside the elevator
* also indicates what floor the passenger wants to go to. 
* This is in accordance with the requirement "An elevator request can be made at any floor, to go to any other floor."
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
  
  /* This method send the closest elevator to a floor
  */
  public void sendClosestElevator(int requestingFloor) {
    int closestElevDistance = maxFloors;
    for(int i = 0; i < numElevators; i++){
       if(elevators[i].currentFloor() == requestingFloor && 
          !elevators[i].isOccupied() &&
          elevators[i].isInService()){
         elevators[i].pickUpPassenger();
         break;
       }
      if(elevators[i].isOccupied() && 
         elevators[i].isMoving() &&
         elevator[i].isFloorOnTheWay(requestingFloor)){
           
         }
    }
  }
  

}
