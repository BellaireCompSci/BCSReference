package template;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemTemplate {
	// CHANGE FILE NAME FOR EACH PROBLEM!
	private static final String inputFileName = "filename.in";
	private static Scanner in;

	public static void main(String[] args) throws FileNotFoundException {
		// Set up scanner to get input from file
		in = new Scanner(new File(inputFileName));
		// Read the number of test cases from first line
		int numCases = in.nextInt();
		// Read any other input variables at top of input file here

		// Move to next line for test cases
		in.nextLine();
		// Loop through each test case
		for(int caseNum=0; caseNum<numCases; caseNum++) {
			// Replace this with test case handling
			String currentLine = in.nextLine();
			System.out.println(currentLine);
		}
		in.close();
	}
}
