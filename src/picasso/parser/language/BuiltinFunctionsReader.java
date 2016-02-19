package picasso.parser.language;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles reading the built-in functions from a file.
 * 
 * @author Sara Sprenkle
 * 
 */
public class BuiltinFunctionsReader {

	private static List<String> functionsList;
	private static String FUNCTIONS_CONF_FILE = "src/picasso/parser/functions.conf";

	/**
	 * Get the list of built-in functions
	 * 
	 * @return
	 */
	public static List<String> getFunctionsList() {
		if (functionsList == null) {
			readFunctionsFromFile();
		}
		return functionsList;
	}

	private static void readFunctionsFromFile() {
		functionsList = new ArrayList<String>();
		Scanner reader;
		try {
			reader = new Scanner(new File(FUNCTIONS_CONF_FILE));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			return;
		}
		while (reader.hasNextLine()) {
			String function = reader.nextLine();
			function = function.trim();
			functionsList.add(function);
		}
	}

}
