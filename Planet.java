//Brianna Fratila
//Student ID: 260718297
import java.util.ArrayList;
public class Planet {
	
	private String name;
	private double chanceOfArtifact;
	private double damage;
	
	//Constructor
	public Planet(String name, double chanceOfArtifact, double damage){
		
		if (chanceOfArtifact < 0.0 || chanceOfArtifact > 1.0 || damage < 0.0){ //if the chance of finding and artifact is not between 0.0 and 1.0 or if the damage is less than zero
			String errorMessage = "ERROR"; //throw an exception
			throw new IllegalArgumentException(errorMessage);
		}
		this.name = name; //set the values for the class attributes using the parameter values
		this.chanceOfArtifact = chanceOfArtifact;
		this.damage = damage;
	}
	
	//A method to return the name of the planet
	public String getName(){
		return this.name; //return the name of the planet
	}
	
	//A toString method
	public String toString(){
		String s = ""; //Create a string
		s = s + " Name: " + name + " Artifact Chance: " + chanceOfArtifact*100 + "%" + " Possible Damage: " + damage;
		return s; //Return the new string
	}
	
	//A findPlanet method
	public static int findPlanet(String specificPlanet, ArrayList<Planet> planet){
		for (int i = 0; i < planet.size(); i++){ //loop through the arrayList
			Planet temp = planet.get(i); //store the element at index i in the arrayList into a string variable
			String tempName = temp.getName(); //set the string equal to the name of the planet object
			if (tempName.equalsIgnoreCase(specificPlanet)) { //check if the tempName is equal to the spcecific planet you are looking for
				return i; //return its index
			}
		}
		return -1; //if it's not found, return -1
	}
}
