import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {
//		Check arguments
		char checkerChar = args[0].substring(0).charAt(0);
		if(args[0].length() >1 && (checkerChar == 'a' || checkerChar == 'r' || checkerChar == 'c')){
			System.out.println(Constant.validText2);
			return;
		}
		if(checkerChar!='a' && checkerChar!= 'r' && checkerChar!= 'c' && checkerChar!='?' && checkerChar!='+'){
			System.out.println(Constant.validText);
			return;
		}
		if(args[0].equals("a")) {
			System.out.println(Constant.loadingText);
			try {
				String Students[] = getBufferedReader().readLine().split(", ");
				for(String student : Students) {
					System.out.println(student);
				}
			}
			catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].equals("r")) {
			System.out.println(Constant.loadingText);
			try {
				String Students[] = getBufferedReader().readLine().split(", ");
				int index = new Random().nextInt(Students.length);
				System.out.println(Students[index]);
			}
			catch (Exception e){
				System.out.println(Constant.dataNotFound);
			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains("+")){
			System.out.println(Constant.loadingText);
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter(Constant.textFile, true));
				String line = getBufferedReader().readLine();
				extracted();
				String newLine = line;
				String given = args[0].substring(1);
				newLine+=", ";
				newLine+=given;
				String formatedDate= new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a").format(new Date());
				bufferedWriter.write(newLine + "\nList newLine updated on " +formatedDate);
				bufferedWriter.close();
			}
			catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains("?")) {
			System.out.println(Constant.loadingText);
			try {
				String Students[] = getBufferedReader().readLine().split(", ");
				int idx;
				for( idx = 0; idx<Students.length; idx++) {
					if(Students[idx].trim().equals(args[0].substring(1).trim())) {
						System.out.println(Constant.dataFound);
						break;
					}
				}
				if(idx>=Students.length){
					System.out.println("The word you are searching for "+ "( " + args[0].substring(1).trim() + " )" + " is not found!");
				}
			}
			catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
		else if(args[0].contains("c")) {
			System.out.println(Constant.loadingText);
			try {
				String StudentCharArray[] = getBufferedReader().readLine().split(", ");
				System.out.println(StudentCharArray.length +" word(s) found ");
			}
			catch (Exception e){

			}
			System.out.println(Constant.dataLoaded);
		}
	}

	private static void extracted() throws IOException {
		PrintWriter printWriter = new PrintWriter(new FileWriter(Constant.textFile, false), false);
		printWriter.flush();
		printWriter.close();
	}
	private static BufferedReader getBufferedReader() throws FileNotFoundException {
		return new BufferedReader(
				new InputStreamReader(
						new FileInputStream(Constant.textFile)));
	}
}