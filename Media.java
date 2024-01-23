// programmer： Cheng Yang and Grant Rainey

public abstract class Media{
	protected String title;
	protected String director;
	protected String cast;
	protected String country;
	protected String releaseYear;
	protected String rating;
	protected String genre;
	protected String description;


	public void setTitle(String value){
		title = value;

	}
	public void setDirector(String value){
		director=value;

	}
	public void setCast(String value){
		cast = value;

	}
	public void setCountry(String value){
		country = value;

	}
	public void setReleaseYear(String value){
		releaseYear = value;

	}
	public void setRating(String value){
		rating = value;

	}

	public void setGenre(String value){
		genre = value;

	}
	public void setDescription(String value){
		description = value;

	}
	public String getTitle(){
		return title;

	}
	public String getDirector(){
		return director;

	}
	public String getCast(){
		return cast;

	}
	public String getCountry(){
		return country;

	}
	public String getReleaseYear(){
		return releaseYear;

	}
	public String getRating(){
		return rating;

	}

	public String getGenre(){
		return genre;

	}
	public String getDescription(){
		return description;

	}

	public Media(String title, String director,String cast, String country, String releaseYear, String rating,String genre,String description){
		setTitle(title);
		setDirector(director);
		setCast(cast);
		setCountry(country);
		setReleaseYear(releaseYear);
		setRating(rating);
		setGenre(genre);
		setDescription(description);
	}
	public String toString(){
		String toReturn = "title: "+title +"\n";
		toReturn += " director: " + director +"\n";
		toReturn += " cast: " + cast +"\n";
		toReturn += " country: " + country+"\n";
		toReturn += " release Year: " + releaseYear+"\n";
		toReturn += " rating: " + rating+"\n";
		toReturn += " genre: " + genre+"\n";
		toReturn += " description: " + description+"\n";
		return toReturn;
	}

}