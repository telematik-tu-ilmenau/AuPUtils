package aup;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @version 0.03
 *
 */
public final class InputReader {
	private InputReader() {

    }

	/**
	*	stream from which data will be read in
	*/
	private BufferedReader inReader;

	/**
	* Stores a BufferedReader for later use
	*
	* @param inRd input reader
	*/
	public InputReader(BufferedReader inRd) {
		assert inRd != null : "invalid BufferedReader " + inRd;
		inReader = inRd;
	}

	/**
	 * This method lets you type in an floating point number of arbitrary size.
	 * If an error occurs BigDecimal.ZERO is returned.
	 *
	 * @return BigInteger typed in
	 */
	public BigDecimal readBigDecimal() {
		BigDecimal readValue = BigDecimal.ZERO;
		String inputString = readString();
		try {
			readValue = new BigDecimal(inputString);
		} catch (NumberFormatException numFormEx) {
			System.err.println("Number conversion error: "
					+ numFormEx.getMessage());
		}
		return readValue;
	}

	/**
	 * This method lets you type in an integral number bigger than
	 * Long.MAX_VALUE or more negative than Long.MIN_VALUE and returns it. If an
	 * error occurs BigInteger.ZERO is returned.
	 *
	 * @return BigInteger typed in
	 */
	public BigInteger readBigInteger() {
		BigInteger readValue = BigInteger.ZERO;
		String inputString = readString();
		try {
			readValue = new BigInteger(inputString);
		} catch (NumberFormatException numFormEx) {
			System.err.println("number conversion error: "
					+ numFormEx.getMessage());
		}
		return readValue;
	}

	/**
	 * This method lets you type in a char and returns it. If an error occurs
	 * Character.UNASSIGNED is returned.
	 *
	 * @return char value formerly read in
	 */
	public char readChar() {
		char readValue = Character.UNASSIGNED;
		try {
			readValue = (char) inReader.read();
		} catch (IOException ioEx) {
			System.err.println("IO error: " + ioEx.getMessage());
		}
		return readValue;
	}

	/**
	 * This method lets you type in a floating point number and returns it. If
	 * an error occurs 0.0 is returned.
	 *
	 * @return double typed in
	 */
	public double readDouble() {
		double readValue = 0.0;
		String inputString = readString();
		try {
			readValue = Double.parseDouble(inputString);
		} catch (NumberFormatException numFormEx) {
			System.err.println("number conversion error: "
					+ numFormEx.getMessage());
		}
		return readValue;
	}

	/**
	 * This method lets you type in a floating point number and returns it. If
	 * an error occurs 0.0F is returned.
	 *
	 * @return float typed in
	 */
	public float readFloat() {
		float readValue = 0.0F;
		String inputString = readString();
		try {
			readValue = Float.parseFloat(inputString);
		} catch (NumberFormatException numFormEx) {
			System.err.println("number conversion error: "
					+ numFormEx.getLocalizedMessage());
		}
		return readValue;
	}

	/**
	 * This method lets you type in an integral number and returns it. If an
	 * error occurs 0 is returned.
	 *
	 * @return integer typed in
	 */
	public int readInt() {
		int readValue = 0;
		String inputString = readString();
		try {
			readValue = Integer.parseInt(inputString);
		} catch (NumberFormatException numFormEx) {
			System.err.println("number conversion error: "
					+ numFormEx.getLocalizedMessage());
		}
		return readValue;
	}

	/**
	 * This method lets you type in an integral number and returns it. If an
	 * error occurs 0 is returned.
	 *
	 * @return long typed in
	 */
	public long readLong() {
		long readValue = 0L;
		String inputString = readString();
		try {
			readValue = Long.parseLong(inputString);
		} catch (NumberFormatException numFormEx) {
			System.err.println("number conversion error: "
					+ numFormEx.getLocalizedMessage());
		}
		return readValue;
	}

	/**
	 * This method lets you type in a string and returns it. If an error occurs
	 * "" is returned.
	 *
	 * @return string typed in
	 */
	public String readString() {
		String readValue = "";
		try {
			readValue = inReader.readLine();
		} catch (IOException ioEx) {
			System.err.println("IO error: " + ioEx.getLocalizedMessage());
		}
		return readValue;
	}

} // END CLASS InputReader