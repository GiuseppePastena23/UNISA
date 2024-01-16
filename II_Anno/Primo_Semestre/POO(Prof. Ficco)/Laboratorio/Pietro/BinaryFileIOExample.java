import java.io.*;

public class BinaryFileIOExample {
	public static void main(String[] args) {
		//DataOutputStream
		try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("binaryFile.dat"))) {
			//Sample data to write to the file
			int intValue = 42;
			double doubleValue = 3.14;
			String stringValue = "Hello, Binary World!";
			
			//Writing primitive data types to the file
			dataOutputStream.writeInt(intValue);
			dataOutputStream.writeDouble(doubleValue);
			dataOutputStream.writeUTF(stringValue);
			
			System.out.println("Data has been written to the file.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//DataInputStream
		try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("binaryFile.dat"))) {
			//Reading primitive data types from the file
			int readIntValue = dataInputStream.readInt();
			double readDoubleValue = dataInputStream.readDouble();
            String readStringValue = dataInputStream.readUTF();
			
			//Displaying the read data
			System.out.println("Read int value: " + readIntValue);
			System.out.println("Read double value: " + readDoubleValue);
			System.out.println("Read string value: " + readStringValue);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}