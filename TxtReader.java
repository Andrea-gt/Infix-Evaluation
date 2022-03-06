import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtReader {
	ArrayList<String> Lines = new ArrayList<String>();
	
	public ArrayList<String> readingFile(String fileName) throws FileNotFoundException{
		
		Scanner scanner  = new Scanner(new File(fileName));
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Lines.add(line);
		}
		return Lines;
	}
}
