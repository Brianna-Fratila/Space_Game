//Brianna Fratila
//Student ID: 260718297
import java.util.ArrayList;
import java.util.Scanner;

public class SpaceGame {

	Scanner sc; // a non=static scanner attribute for getting input from the user
	Spaceship player;
	static final int NUM_ARTIFACTS_WIN = 5; //a constant that stores the number of artifacts a ship must find to win
	
	//The SpaceGame constructor
	public SpaceGame(String filename){
		Scanner sc = new Scanner(System.in); //initialize the scanner attribute
		
		Spaceship player = this.player; //Initialize the player Spaceship
		
		ArrayList<Planet> planets = FileIO.loadPlanets(filename); //loads a file containing planets
		
		player.setPlanets(planets); //for every spaceship set the plants
		
		
		player.moveTo(planets.get(0).getName()); //move the player to the planet at index 1 in the arrayList
			
		System.out.println("You must find " + SpaceGame.NUM_ARTIFACTS_WIN + "to win!"); //prints out how many artifacts they must find to win
	}
	
	//The private checkForDestroyed Method
	private int checkForDestroyed(){
		if (player.getCurrentHealth() <= 0){ //if the currentHealth is 0 or below, return 1
			return 1;
		}
		else{
			return 0; //otherwise return a 0
		}
	}
	
	//the private method to check for number of wins
	private int checkForWin(){
		if (player.getNumArtifactsDiscovered() >= SpaceGame.NUM_ARTIFACTS_WIN){ //check if the number of artifacts found is equal to the required amount
			return 1; //if so, return 1
		}
		else{
			return 0; //if not, return 0
		}
	}
	//a public method to play the game
	public void playGame(){
	
		while (checkForDestroyed() == 0 && checkForWin() == 0){ //while the player is alive and they haven't found enough artifacts
			
			String inputCommand = ""; //create a string for input for command
			String inputDestination = ""; //create a string for input for Destination
			inputCommand = sc.nextLine();
			inputDestination = sc.nextLine();
			
			if (inputCommand.equalsIgnoreCase("moveIn")){ //if the input is "moveIn"
				player.moveIn(); //call the moveIn method on the player spaceship
			}
			else if (inputCommand.equalsIgnoreCase("moveOut")){ //if the input is "moveOut"
				player.moveOut(); //call the moveOut method on player spaceship
			}
			else if (inputCommand.equalsIgnoreCase("moveTo")){ //if the input is "moveTo"
				System.out.println("Enter the destination: " + inputDestination); //ask the player to input a destination
				player.moveTo(inputDestination); //move to the destination if it exists
			}
			else{
				System.out.println("Command not recognized: " + inputCommand); //if the input is anything else print this statement
			}	
		}
		if (checkForDestroyed() == 1){ //check if their ship is destroyed
			System.out.println("Your ship was destroyed!");
		}
		if (checkForWin() == 1){ //check if they found enough artifacts
			System.out.println("You have found enough artifacts!");
		}
	}
}
