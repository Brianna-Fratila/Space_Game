// Brianna Fratila
//Student ID: 260718297
import java.io.*;
import java.util.ArrayList;


public class FileIO {
	
	//method to create a new spaceship
	public Spaceship loadSpaceship (String filename) { //takes a string filename as input
		Spaceship toReturn; //initialize a new spaceship
		try {
			FileReader fr = new FileReader (filename); //this opens the file
			BufferedReader br = new BufferedReader (fr);
			String name = br.readLine();  
			double maxHealth = Double.parseDouble(br.readLine()); //reads the line and makes it a double
			int numWins = Integer.parseInt(br.readLine()); //reads the line and makes it an int
			br.close(); //close the bufferedReader
			fr.close(); //close the FileReader
			toReturn = new Spaceship (name, maxHealth, numWins); // the new spaceship has a name, maxHealth, and numWinds
		} catch (FileNotFoundException e){ //catch a common exception
			throw new IllegalArgumentException ("Sorry, this file was not found");
		} catch (IOException e){ //catch another common exception
			throw new IllegalArgumentException ("Sorry, there seems to be another error!");
		}
		return toReturn; //return the new spaceship
	}
	
	//method to return an arrayList of planets
	public static ArrayList<Planet> loadPlanets (String filename) { //takes a filename of planets to read
		ArrayList<Planet> planets = new ArrayList<Planet> (); //create a new arrayList
		try {
			FileReader fr = new FileReader (filename); //use FileReader and BufferedReader to read the file
			BufferedReader br = new BufferedReader (fr);
			String check = br.readLine(); 
			while (check != null) { //while the line is not null
				String[] data = check.split(" "); //split the file based on spaces found
				double chance = Double.parseDouble(data[1]); //index 1 will be chance
				double damage = Double.parseDouble(data[2]); //index 2 will be damage
				Planet newPlanet = new Planet (data[0], chance, damage); //create a new planet
				planets.add(newPlanet); //add new planet to the arrayList
				check = br.readLine();
			}
			br.close(); //close buffered reader and fileReader
			fr.close();
		} catch (FileNotFoundException e){ //catch the two exceptions
			throw new IllegalArgumentException("Sorry, this file was not found");
		} catch (IOException e) {
			throw new IllegalArgumentException("Sorry, something went wrong!");

		}
		return planets; //return the planets arrayList
	}
}
