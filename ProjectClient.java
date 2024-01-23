import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
// programmer： Cheng Yang and Grant Rainey

public class ProjectClient {
    
    public static void main(String[] args){
        DataFileParser c = new DataFileParser();
        ArrayList<Media> masterList = DataFileParser.get();
        ArrayList<Filter> filterList = new ArrayList<>();

        Scanner scnr = new Scanner(System.in);
        int numMatches = masterList.size();
        //Inside while loop, the program displays options to add, remove, or list filters, and an option to quit
        while(true){
            System.out.println("Current Filters: ");
            System.out.println("----------------");
            for(int i = 0; i < filterList.size(); i++){
                System.out.println(filterList.get(i).toString());
            }
            if(filterList.size() == 0)//sets numMatches to max amount if no filters
                numMatches = masterList.size();

            System.out.println(("(A)dd a new filter \n(R)emove a filter \n(L)ist matching records(" + numMatches + ")\n(Q)uit\n Enter a letter from the above: "));


            String input = "";
            try{//input validation
                input = scnr.nextLine().toLowerCase();
            }
            catch(InputMismatchException e){
                System.out.print("Error: invalid input. Try again: ");
                input = scnr.nextLine().toLowerCase();
            }

            try{
                if(input.charAt(0) == 'r'){//removes filters that match filter type of input
                    System.out.print("Enter the filter you'd like to remove: ");
                    try{
                        input = scnr.nextLine().toLowerCase();

                    }
                    catch(InputMismatchException e){
                        System.out.print("Error: invalid input");
                        input = scnr.nextLine().toLowerCase();
                    }

                    for(int i = 0; i < filterList.size(); i++) {
                        if (filterList.get(i).getFilterType().contains(input)) {
                            filterList.remove(i);
                            System.out.println("Filter removed.");

                        }
                    }

                }
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Error: invalid input.");
            }
            try{
                if(input.charAt(0) == 'a') {//adds filter if input is a
                    System.out.println("Enter the filter you'd like to add(Include a space between your filter type and target field to search for): ");
                    try {
                        input = scnr.nextLine().toLowerCase();

                    } catch (InputMismatchException e){
                        System.out.print("Error: invalid input");
                        input = scnr.nextLine().toLowerCase();
                    }
                    String targetField = "";
                    String[] inputFields = input.split(" ");//splits input fields by spaces to get target and filterType fields
                    if(inputFields.length > 1){
                        for (int i = 1; i < inputFields.length; i++) {


                            if(inputFields[1].contains("year") )
                                inputFields[0] += inputFields[1];

                            if(i == 1)
                                targetField += inputFields[i];
                            else if(i > 1){
                                targetField += " " + inputFields[i];
                            }
                        }

                        Filter e = new Filter(inputFields[0], targetField);
                        filterList.add(e);
                        System.out.println("Filter " + e + " " + " added.");

                    }
                    else{
                        Filter e = new Filter(inputFields[0]);
                        filterList.add(e);
                        System.out.println("Filter " + e + " added.");
                    }
                    System.out.println("Ready to search? type anything ");
                    try{
                        String nextInput = scnr.nextLine();

                    }
                    catch (InputMismatchException e) {
                        System.out.print("Error: invalid input");
                        input = scnr.nextLine().toLowerCase();
                    }
                }
            }
            catch(IndexOutOfBoundsException e){
                System.out.println("Error: invalid input.");
            }
            if(input.toLowerCase() == "l"){
                numMatches = 0;
                for(int i = 0; i < masterList.size(); i++){
                    boolean isMatching = true;
                    for(int j = 0; j < filterList.size(); j++){
                        if(!filterList.get(j).filterMatch(masterList.get(i))){
                            isMatching = false;
                        }
                    }
                    if(isMatching){
                        System.out.println(masterList.get(i));
                        System.out.println("--------\n");
                        numMatches++;
                    }
                }
            }


            numMatches = 0;
            for(int i = 0; i < masterList.size(); i++){//only prints filter and increments numMatches if every filter returns true on filterMatch
                boolean isMatching = true;
                for(int j = 0; j < filterList.size(); j++){
                    if(!filterList.get(j).filterMatch(masterList.get(i))){
                        isMatching = false;
                    }
                }
                if(isMatching){
                    System.out.println(masterList.get(i));
                    System.out.println("--------\n");
                    numMatches++;
                }
            }
            if(input == "q"){
                System.exit(0);
            }



        }



    }
}
