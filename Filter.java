import java.util.ArrayList;
import java.util.Locale;
// programmer： Cheng Yang and Grant Rainey

public class Filter {//class for filter object
    private String target;
    private String filterType;


    public Filter(String type, String targetField) {
        setFilterType(type.toLowerCase());
        setTarget(targetField.toLowerCase());
    }
    public Filter(String type){
        setFilterType(type.toLowerCase());
        setTarget("");
    }
    public void setFilterType(String type){
        filterType = type;
    }
    public void setTarget(String targetField){
        target = targetField;
    }
    public String getTarget(){
        return target;
    }


    public boolean filterMatch(Media targetMedia){//method for returning whether media object (parameter) matches a target
        if(filterType.contains("movie")){
            if(targetMedia instanceof Movie){
                return true;

            }
            if(targetMedia instanceof Series){
                return false;
            }
            else{
                return false;
            }
        }
        else if(this.getFilterType().contains("series") || this.getFilterType().contains("tv Show")  ){
            if(targetMedia instanceof Series){
                return true;
            }
            if(targetMedia instanceof Movie){
                return false;
            }
            else{
                return false;
            }
        }

        else if(filterType.contains("title")){
            if(targetMedia.getTitle().toLowerCase().contains(target)){
                return true;
            }
        }
        else if(filterType.contains("director")){
            if(targetMedia.getDirector().toLowerCase().contains(target)){

                return true;
            }
        }
        else if(filterType.contains("cast")){
            if(targetMedia.getCast().toLowerCase().contains(target)){
                return true;
            }
        }
        else if(filterType.contains("country")){
            if(targetMedia.getCountry().toLowerCase().contains(target)){

                return true;
            }

        }
        else if(filterType.contains("rating")){
            if(targetMedia.getRating().toLowerCase().contains(target)){
                return true;
            }
        }
        else if(filterType.contains("genre")){
            if(targetMedia.getGenre().toLowerCase().contains(target)){
                return true;
            }
        }

        else if(filterType.contains("year") || filterType.contains("release year")) {
            String comparatorString = "";
            String numberString = "";
            for(int i = 0; i < target.length(); i++){//parses target to find where comparator signs are and where numbers are to compare by
                if(target.charAt(i) >= 60 && target.charAt(i) <= 62)
                    comparatorString += target.charAt(i);

                if(target.charAt(i) >= '0' && target.charAt(i) <= '9')
                    numberString += target.charAt(i);
            }
            int numToCompare = Integer.parseInt(numberString);

            if (comparatorString.equals(">=")) {
                if (Integer.parseInt(targetMedia.getReleaseYear()) >= numToCompare) {
                    return true;
                }
            }
            else if (comparatorString.equals("<=")) {
                if (Integer.parseInt(targetMedia.getReleaseYear()) <= numToCompare) {

                    return true;
                }
            } else if (comparatorString.equals("<")) {
                if (Integer.parseInt(targetMedia.getReleaseYear()) < numToCompare) {
                    return true;
                }
            } else if (comparatorString.equals(">")) {
                if (Integer.parseInt(targetMedia.getReleaseYear()) > numToCompare) {
                    return true;
                }
            } else if (comparatorString.equals("=")) {
                if (Integer.parseInt(targetMedia.getReleaseYear()) == numToCompare) {
                    return true;
                }
            }
        }

        else if(filterType.contains("runtime")) {
            String comparatorString = "";
            String numberString = "";
            for(int i = 0; i < target.length(); i++){//parses target to find where comparator signs are and where numbers are to compare by
                if(target.charAt(i) >= 60 && target.charAt(i) <= 62)
                    comparatorString += target.charAt(i);

                if(target.charAt(i) >= '0' && target.charAt(i) <= '9')
                    numberString += target.charAt(i);

            }
            int numToCompare = Integer.parseInt(numberString);
            if(targetMedia instanceof Movie){
                String toCompare[] = ((Movie) targetMedia).runtime.split(" ");
                int intToCompare = Integer.parseInt(toCompare[0]);
                if (comparatorString.equals(">=")) {
                    if (intToCompare >= numToCompare) {
                        return true;
                    }
                }
                else if (comparatorString.equals("<=")) {
                    if (intToCompare <= numToCompare) {
                        return true;
                    }
                } else if (comparatorString.equals("<")) {
                    if (intToCompare < numToCompare) {
                        return true;
                    }
                } else if (comparatorString.equals(">")) {
                    if (intToCompare > numToCompare) {
                        return true;
                    }
                } else if (comparatorString.equals("=")) {
                    if (intToCompare == numToCompare) {
                        return true;
                    }
                }

            }


        }
        else if(filterType.contains("duration")) {
            String comparatorString = "";
            String numberString = "";
            for(int i = 0; i < target.length(); i++){//parses target to find where comparator signs are and where numbers are to compare by
                if(target.charAt(i) >= 60 && target.charAt(i) <= 62)
                    comparatorString += target.charAt(i);

                if(target.charAt(i) >= '0' && target.charAt(i) <= '9')
                    numberString += target.charAt(i);

            }
            int numToCompare = Integer.parseInt(numberString);
            if(targetMedia instanceof Series){
                String toCompare[] = ((Series) targetMedia).duration.split(" ");
                int intToCompare = Integer.parseInt(toCompare[0]);
                if (comparatorString.equals(">=")) {
                    if (intToCompare >= numToCompare) {
                        return true;
                    }
                }
                else if (comparatorString.equals("<=")) {
                    if (intToCompare <= numToCompare) {
                        return true;
                    }
                } else if (comparatorString.equals("<")) {
                    if (intToCompare < numToCompare) {
                        return true;
                    }
                } else if (comparatorString.equals(">")) {
                    if (intToCompare > numToCompare) {
                        return true;
                    }
                } else if (comparatorString.equals("=")) {
                    if (intToCompare == numToCompare) {
                        return true;
                    }
                }

            }
        }
        else{
            if(target.equals("") || target.equals(" ")){//else if statements for if no previous conditions match
                return false;
            }
            else if(targetMedia.title.toLowerCase().contains(target)){
                return true;
            }

            else if(targetMedia.director.toLowerCase().contains(target)){

                return true;
            }

            else if(targetMedia.cast.toLowerCase().contains(target)){

                return true;
            }

            else if(targetMedia.country.toLowerCase().contains(target)){
                return true;
            }

            else if(targetMedia.rating.toLowerCase().contains(target)){
                return true;
            }

            else if(targetMedia.description.toLowerCase().contains(target)){

                return true;
            }
            else{
                return false;
            }
        }
        return false;

    }
    public String toString(){
        String toReturn = filterType + " " + target;

        // return filtertype and target
        return  toReturn;
    }

    public String getFilterType(){

        //return filtertype
        return filterType;
    }
    // public static void main(String[] args){
    //     ArrayList<Media> masterList = DataFileParser.get();
    //     Filter e = new Filter("Movie");
    //     System.out.println(e);
    //     int numMatches = 0;
    //     for(int i = 0; i < masterList.size(); i++){
    //         if(e.filterMatch(masterList.get(i))){
    //             numMatches++;
    //         }
    //     }

    //     System.out.print(numMatches);
    // }
}
