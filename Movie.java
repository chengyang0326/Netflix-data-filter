// programmer： Cheng Yang and Grant Rainey

public class Movie extends Media{
	protected String type;
	protected String runtime;

	//class for type movie, includes updated constructor and toString methods
	public void setType(String value){
		type = value;

	}
	public void setRuntime(String duration){
		this.runtime = duration;
	}
	public String getType(){
		return type;

	}
	public Movie(String title, String director,String cast, String country, String releaseYear, String rating, String runtime,String genre,String description){
		super(title, director,cast, country, releaseYear, rating, genre, description);
		setType("Movie");
		setRuntime(runtime);
	}
	public String toString(){
		return super.toString()+ "\nMedia type: " + type + "\nRuntime: " + runtime;

	}
}