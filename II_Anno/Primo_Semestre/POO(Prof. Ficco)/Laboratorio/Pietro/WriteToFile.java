import java.io.*;
import java.util.Scanner;

public class WriteToFile {
	public static void main(String[] args) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter text (type 'exit' to finish):");
			String line;
			while (!(line = scanner.nextLine()).equalsIgnoreCase("exit")) {
				writer.write(line);
				writer.newLine();
			}
			System.out.println("Text written to output.txt.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}