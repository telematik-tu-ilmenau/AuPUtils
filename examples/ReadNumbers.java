import aup.*;

public class ReadNumbers {
	public static void main(String[] args) {
		System.out.print("Please type an integral number: ");
		int firstNumber = IOUtils.readInt();
		System.out.println("Your number was: " + firstNumber);
	}
}