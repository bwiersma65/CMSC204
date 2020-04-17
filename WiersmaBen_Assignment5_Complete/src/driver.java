import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class driver {

	public static void main(String[] args) throws FileNotFoundException {

		File Daisy = new File("/Users/benwiersma/Desktop/Daisy.txt");
		File DaisyDaisy = new File("/Users/benwiersma/Desktop/DaisyDaisy.txt");
		System.out.print(MorseCodeConverter.convertToEnglish(Daisy));
		System.out.println();
		System.out.print(MorseCodeConverter.convertToEnglish(DaisyDaisy));
	}
}