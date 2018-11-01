package template;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static java.lang.System.out; // allow use of out.println() without System


public class ProblemTemplate {
	// CHANGE FILE NAME FOR EACH PROBLEM!
	private static final String inputFileName = "filename00.in";
	private static Scanner scan;

	public static void main(String[] args) {
		try {
			// Set up scanner to get input from file
			scan = new Scanner(new File(inputFileName)); 
			// Read the number of test cases from first line
			int numCases = scan.nextInt();
			// Read any other input variables at top of input file here

			// Move to next line for test cases
			scan.nextLine();
			// Loop through each test case
			for(int caseNum=0; caseNum<numCases; caseNum++) {
				handleTestCase();
			}
			scan.close();
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
	}

	public static void handleTestCase() {
		// Write solution for a single test case below
		String inputLine = scan.nextLine();	// replace with custom input reading
		out.println(inputLine);	// replace with custom input processing and output
	}
}
