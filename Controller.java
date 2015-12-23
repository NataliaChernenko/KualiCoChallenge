/*
* KualiCo Programming Challenge
*
* Author: Natalia Chernenko
*
* This class controls a set of Elevators.
*/

public class Controller {
  
  private Elevator[] elevators;
  
  /* Creates a Controller for the specified number of elevators
  */
  public Controller(int numElevators, int maxFloors){
    if (numElevators > 0 && maxFloors > 0) {
      elevators = new Elevator[numElevators]
      for(int i = 0; i < numElevators; i++){
        elevators[i] = new Elevator(maxFloors);
      }
    }
    else {
      throw IllegalArgumentException("invalid arguments to Controller constructor")
    }
  }
  
  

}
