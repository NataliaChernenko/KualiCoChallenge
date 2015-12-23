# KualiCoChallenge
Programming challenge for KualiCo

Author: Natalia Chernenko

There are several things that are still incomplete with this code. First, there is no way of knowing when an elevator is occupied or not. This can be resolved with a timer waiting for a request from inside an elevator for another floor. If a passenger does not press any buttons for a specified period of time, then the elevator can be considered unoccupied. Second, without sensors there is no way of knowing the rate of travel for the elevator and whether it is moving or not. The controller I have created can send an elevator to a floor, but it does not know when the elevator has arrived without external data. Therefore, my logic with isOccupied() and isMoving() is incomplete and therefore could not function as is. This can be solved with input from sensors, which would trigger methods such as setCurrentFloor(...), setMoving(...), etc. 

Lastly, there is no specification as to whether the passenger requesting an elevator from the outside has the option of "up" or "down" buttons (which is standard in most elevators) or if they can request to go to a certain floor from the outside (which is how the directions tend to read). Before proceeding any further with this code, these questions would need to be clarified.
