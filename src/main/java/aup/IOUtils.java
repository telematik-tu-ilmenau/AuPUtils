package aup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @version 0.02
 *
 */
public final class IOUtils {
    private IOUtils() {
        
    }

	/**
	 * Get an InputReader for the standard input stream.
	 *
	 * @return InputReader for System.in
	 */
	private static InputReader getInputReader() {
		try {
			int bytesAvailable = System.in.available();
			assert bytesAvailable >= 0 : "System.in bytes available " + bytesAvailable;
		} catch (IOException ioEx) {
			// System.in was maybe closed
			System.err.println("Input error from System.in: "
					+ ioEx.getMessage());
		}
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
		InputReader reader = new InputReader(bufReader);
		return reader;
	}

	/**
	 * This method lets you type in an floating point number of arbitrary size.
	 * If an error occurs BigDecimal.ZERO is returned.
	 *
	 * @return BigInteger typed in
	 */
	public static BigDecimal readBigDecimal() {
		return getInputReader().readBigDecimal();
	}

	/**
	 * This method lets you type in an integral number bigger than
	 * Long.MAX_VALUE or more negative than Long.MIN_VALUE and returns it. If an
	 * error occurs BigInteger.ZERO is returned.
	 *
	 * @return BigInteger typed in
	 */
	public static BigInteger readBigInteger() {
		return getInputReader().readBigInteger();
	}

	/**
	 * This method lets you type in a char and returns it. If an error occurs
	 * Character.UNASSIGNED is returned.
	 *
	 * @return char value formerly read in
	 */
	public static char readChar() {
		return getInputReader().readChar();
	}

	/**
	 * This method lets you type in a floating point number and returns it. If
	 * an error occurs 0.0 is returned.
	 *
	 * @return double typed in
	 */
	public static double readDouble() {
		return getInputReader().readDouble();
	}

	/**
	 * This method lets you type in a floating point number and returns it. If
	 * an error occurs 0.0F is returned.
	 *
	 * @return float typed in
	 */
	public static float readFloat() {
		return getInputReader().readFloat();
	}

	/**
	 * This method lets you type in an integral number and returns it. If an
	 * error occurs 0 is returned.
	 *
	 * @return integer typed in
	 */
	public static int readInt() {
		return getInputReader().readInt();
	}

	/**
	 * This method lets you type in an integral number and returns it. If an
	 * error occurs 0 is returned.
	 *
	 * @return long typed in
	 */
	public static long readLong() {
		return getInputReader().readLong();
	}

	/**
	 * This method lets you type in a string and returns it. If an error occurs
	 * "" is returned.
	 *
	 * @return string typed in
	 */
	public static String readString() {
		return getInputReader().readString();
	}

} // END CLASS IOUtils
