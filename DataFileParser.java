import java.util.*;
import java.io.*;

// programmer： Cheng Yang and Grant Rainey

public class DataFileParser implements mySplit{

	public static ArrayList<Media> get(){
		ArrayList<Media> mediaCollection = new ArrayList<>();
		Scanner scan = null;
		//exception handling for can not open file
		try {
			scan = new Scanner(new FileInputStream("netflix_titles.csv"));


		}
		catch(FileNotFoundException e){
			System.out.println("File was unable to be opened, sorry");
			System.exit(1);
		}
		// read the file and store the value
		while (scan.hasNext()) {
			String thisLine = scan.nextLine();
			String[] result = mySplit.mySplit(thisLine);
			String type = result[1];
			String title = result[2];
			String director = result[3];
			String cast = result[4];
			String country = result[5];
			String release_year = result[7];
			String rating = result[8];
			String duration = result[9];
			String genre = result[10];
			String description = result[11];
			//identify the data type
			if (type.equals("TV Show")) {
				mediaCollection.add(new Series(title, director, cast, country, release_year, rating, duration, genre, description));
			}
			if (type.equals("Movie")) {
				mediaCollection.add(new Movie(title, director, cast, country,  release_year, rating, duration, genre, description));
			}
		}

		//return the arraylist
		return mediaCollection;
			
		
	}

		
		
	
	
}