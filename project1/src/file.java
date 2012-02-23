import java.io.*;
import java.util.StringTokenizer;

// TODO: Auto-generated Javadoc
/**
 * The Class file.
 */
public class file {

	/**
	 * Readfile.
	 * 
	 * @param a
	 *            the a
	 */
	public static String compare(String line, String last) {
		int i = 0;
		String[] result;

		StringTokenizer token = new StringTokenizer(line, "() ,.!-+=;:?&{}\\");// split
																				// string
																				// tokener
																				// by
																				// different
																				// symbol
		result = new String[token.countTokens()];

		int total = token.countTokens();
		while (token.hasMoreTokens()) // use loop to cauculate the same word!
		{
			result[i++] = token.nextToken();

		}

		if (result[0].equals(last))// check the last word and first word for
									// next line
			System.out.println("\t"+result[0] + " " + last);

		for (int a1 = 0; a1 <= total - 1; a1++) {
			for (int a2 = a1 + 1; a2 <= total - 1; a2++) {
				if (result[a1].equals(result[a2])) {
					System.out.println("\t" + result[a2] + " " + result[a1]);// print
																				// out
																				// the
																				// same
																				// word!!
				}

			}

		}

		last = result[total - 1];
		return last;
	}

	public static void readfile(String argument) {
		String line; // String that holds current file line
		int count = 0; // count the lines initialize it as 0
		String last = null;// initial string last
		// Read first line
		try {

			/*
			 * Sets up a file reader to read the file passed on the command line
			 * one character at a time
			 */
			FileReader input = new FileReader(argument);

			/*
			 * Filter FileReader through a Buffered read to read a line at a
			 * time
			 */
			BufferedReader bufRead = new BufferedReader(input);
			line = bufRead.readLine();
			count++;

			// Read through file one line at time. Print line # and line
			while (line != null) {

				System.out.println("This is a line " + count + ": ");

				last = compare(line, last);// past the value from

				line = bufRead.readLine();

				count++;

			}

			bufRead.close();// close buffer

		} catch (IOException e) {
			// If another exception is generated, print a stack trace
			e.printStackTrace();
		}
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		readfile(args[0]);// call readfile method.

	}// end main
}