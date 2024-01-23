import java.util.*;

// programmer： Cheng Yang and Grant Rainey

public interface mySplit{//interface for properly splitting lines of the file, includes situation handling for quotes and commas.
	static String[] mySplit(String str){
		String[] storeSplit = new String[12];
		char compare1;
		char compare2 = ',';
		int counter = 0;
		boolean isWithinQuotes = false;


		for(int i = 0; i < storeSplit.length;i++){
			storeSplit[i]="";
		}
		for (int i = 0; i < str.length(); i++){
			compare1 = str.charAt(i);

			if(isWithinQuotes && compare1 == '"')
				isWithinQuotes = false;


			else if(compare1 == '"') {// if two double quotes and in within quotes, store one to split but ignore the other
				isWithinQuotes = true;
			}

			if(compare1 != '\"' && compare1 != ','){
				storeSplit[counter] += str.charAt(i);
			}

			if(isWithinQuotes && str.charAt(i) == ','){//stores comma if within quotes
				storeSplit[counter] += str.charAt(i);
			}
			if(!isWithinQuotes && str.charAt(i) == ','){//"splits" by commas that aren't within quotes
				counter++;
			}

			if(i != str.length() - 1 && str.charAt(i) == '\"' && str.charAt(i + 1) == '\"' )
				storeSplit[counter] += str.charAt(i);

			if(counter >= 12){
				break;
			}
		}
		return storeSplit;

	}
	static void main(String[] args) {//testing for split
		String s1= "s1,TV Show,3%,,";
		s1+="\"João Miguel, Bianca Comparato, Michel Gomes, Rodolfo Valente, Vaneza Oliveira, Rafael Lozano, Viviane Porto, Mel Fronckowiak, Sergio Mamberti, Zezé Motta, Celso Frateschi\"";
		s1+=",Brazil,";
		s1+="\"August 14, 2020\"";
		s1+=",2020,TV-MA,4 Seasons,";
		s1+="\"International TV Shows, TV Dramas, TV Sci-Fi & Fantasy\"";
		s1+=",";
		s1+="\"In a future where the elite inhabit an island paradise far from the crowded slums, you get one chance to join the 3% saved from squalor.\"";
	// 	System.out.println(Arrays.toString(mySplit(s1)));
		for(int i = 0; i< mySplit(s1).length;i++){
			System.out.println(mySplit(s1)[i]);
		}


	}
}