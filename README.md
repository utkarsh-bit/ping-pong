**Application Execution**

To execute the application run:
**bin/setup**

This will perform following tasks:
1. Compile and build the application.
2. Execute the unit test cases.


**Run Application**

To run application in Interactive Mode : 
1. Go to the project root : ~/ping-pong
2. Execute: **bin/ping_pong**

This will execute the main class to run the application.

**Design Patterns Used**

Following design patterns are used in the application:

1. Singelton - In order to have single instance of services.
2. Builder Pattern - To build the game context for subsequent stages of games (League, Semis, Final).

In order to make sure that the result of the move played by OFFENSIVE player do not get used by DEFENSIVE player, both the moves are executed simultaneously making use of two different threads.
Each thread will calculate the result of move according to the mode(offensive/defensive) of the player which subsequently will be used to access the result of the move.