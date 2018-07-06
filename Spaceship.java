//Brianna Fratila
//Student ID: 260718297
import java.util.ArrayList;
public class Spaceship {
	
	private String name; //name of spaceship
	private double currentHealth;
	private double maxHealth;
	private int numArtifactsDiscovered;
	private int numWins;
	private Planet currPlanet;  //where the spaceship is
	private static ArrayList<Planet> planets;
	
	//A constructor
	public Spaceship(String name, double maxHealth, int numWins){
		this.name = name;
		this.maxHealth = maxHealth;
		this.numWins = numWins;
		this.setCurrentHealth(maxHealth); //The current health of a new spaceship is the same as the maximum health
	}
	
	//The toString method
	public String toString(){
		return ("Spaceship: " + name + " Current Health: " + getCurrentHealth() + " Number of Artifacts Discovered: " + numArtifactsDiscovered);
	}
	
	//The setPlanets method
	public void setPlanets(ArrayList<Planet> planets){ //takes the arrayList of planets as input
		Spaceship.planets = new ArrayList<Planet> ();
		//ArrayList<Planet> planetsCopy = new ArrayList<Planet>(); //Make a copy of the input arrayList
		for (int i = 0; i < planets.size(); i++){ //iterate through the planets ArrayList
			Spaceship.planets.add(planets.get(i)); //go through the object planets, retrieve the data stored, and store it in the arrayList planetsCopy
			System.out.println(Spaceship.planets.get(i).toString()); //take the new planetsCopy array and use the toString method of the Planet class to print details of planet
		}
	}
	
	//moveTo Method
	public void moveTo(String nextPlanet){
		// finds the index in the array list of the desired planet and returns it into int index
		int index = Planet.findPlanet(nextPlanet, Spaceship.planets);
		if (index != -1) { //if the index is not equal to -1
			this.currPlanet = Spaceship.planets.get(index); //set the current planet equal to the planet at the index
			System.out.println(" The " + name + " moved to " + nextPlanet);
		} else {
			System.out.println("The " + name + " could not move to " + nextPlanet + " since it was not found!");
		}
	}

	//moveIn method
	public void moveIn(){
		int currIndex = Planet.findPlanet(this.currPlanet.getName(), Spaceship.planets); //set the current index using the findPlanet method
		if (currIndex != -1) { //if the index is not equal to -1 (the planet is present in the arrayList)
			if (currIndex == 0) { //And if the index is equal to 0
				System.out.println("Sorry! The " + name + " could not move in. There is no planet closer in.");
			} else { //And if the index is not equal to 0
				int newIndex = currIndex - 1; //the new index is equal to the current index minus 1
				String newPlanet = Spaceship.planets.get(newIndex).getName(); //the planet you move to is equal to the planet at the index
				this.moveTo(newPlanet);
			}
		} else { //if the index is not equal to -1, the planet cannot be found
			System.out.println("Sorry the current planet cannot be found!");
		}
		
	}
	
	//moveOut method
	public void moveOut(){
		int currIndex = Planet.findPlanet(this.currPlanet.getName(), Spaceship.planets); //set the current index using the findPlanet method
		if (currIndex != -1){ //if the index is not -1
			if (currIndex == Spaceship.planets.size() - 1) { //and if the index is equal to the index of the last planet in the arrayList
				System.out.println("Sorry! The " + name + " could not move out. There is no planet farther out."); //cannot move further out
			} else { //if it's not equal to the index of the last planet in the arrayList
				int newIndex = currIndex + 1; //set the new index equal to the previous index plus 1
				String newPlanet = Spaceship.planets.get(newIndex).getName(); //the planet you move to in the arrayList is the planet at the new index
				this.moveTo(newPlanet); //move out to the new planet
			}
		} else { //if the index is -1
			System.out.println("Sorry the current planet cannot be found!"); //planet wasn't found
		}
		
	}
	
	//increaseWins method
	public void increaseWins(){
		this.numWins++; //increase the number of wins by one
	}
	
	//created some getters and setters for other classes

	public double getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(double currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public int getNumArtifactsDiscovered(){
		return numArtifactsDiscovered;
	}
}

    

