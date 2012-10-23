package aup;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @version 0.02
 *
 */
public class IOUtils {

	/**
	 * This method lets you type in an floating point number of arbitrary size.
	 * If an error occurs BigDecimal.ZERO is returned.
	 *
	 * @return BigInteger typed in
	 */
	public static BigDecimal readBigDecimal() {
		InputReader reader = new InputReader(System.in);
		return reader.readBigDecimal();
	}

	/**
	 * This method lets you type in an integral number bigger than
	 * Long.MAX_VALUE or more negative than Long.MIN_VALUE and returns it. If an
	 * error occurs BigInteger.ZERO is returned.
	 *
	 * @return BigInteger typed in
	 */
	public static BigInteger readBigInteger() {
		InputReader reader = new InputReader(System.in);
		return reader.readBigInteger();
	}

	/**
	 * This method lets you type in a char and returns it. If an error occurs
	 * Character.UNASSIGNED is returned.
	 *
	 * @return char value formerly read in
	 */
	public static char readChar() {
		InputReader reader = new InputReader(System.in);
		return reader.readChar();
	}

	/**
	 * This method lets you type in a floating point number and returns it. If
	 * an error occurs 0.0 is returned.
	 *
	 * @return double typed in
	 */
	public static double readDouble() {
		InputReader reader = new InputReader(System.in);
		return reader.readDouble();
	}

	/**
	 * This method lets you type in a floating point number and returns it. If
	 * an error occurs 0.0F is returned.
	 *
	 * @return float typed in
	 */
	public static float readFloat() {
		InputReader reader = new InputReader(System.in);
		return reader.readFloat();
	}

	/**
	 * This method lets you type in an integral number and returns it. If an
	 * error occurs 0 is returned.
	 *
	 * @return integer typed in
	 */
	public static int readInt() {
		InputReader reader = new InputReader(System.in);
		return reader.readInt();
	}

	/**
	 * This method lets you type in an integral number and returns it. If an
	 * error occurs 0 is returned.
	 *
	 * @return long typed in
	 */
	public static long readLong() {
		InputReader reader = new InputReader(System.in);
		return reader.readLong();
	}

	/**
	 * This method lets you type in a string and returns it. If an error occurs
	 * "" is returned.
	 *
	 * @return string typed in
	 */
	public static String readString() {
		InputReader reader = new InputReader(System.in);
		return reader.readString();
	}

} // END CLASS IOUtils
