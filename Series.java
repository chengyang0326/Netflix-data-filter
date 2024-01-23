public class Series extends Media{
	protected String type;
	protected String duration;
//class for type series, includes updated constructor and toString methods

// programmer： Cheng Yang and Grant Rainey
	public void setType(String value){
		type = value;

	}
	public void setDuration(String duration){
		this.duration = duration;
	}
	public String getType(){
		return type;

	}
	public Series(String title, String director, String cast, String country, String releaseYear, String rating, String duration, String genre, String description){
		super(title, director,cast, country, releaseYear, rating, genre, description);
		setType("Series");
		setDuration(duration);
	}
	public String toString(){
		return super.toString()+"\nMedia type: " + type + "\nDuration: " + duration;

	}
}