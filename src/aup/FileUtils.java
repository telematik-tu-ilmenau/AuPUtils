package aup;

import java.awt.HeadlessException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @version 0.01
 *
 */
public class FileUtils {
	/**
	 * this variable sets the title of the dialog shown after calling
	 * getFilePath()
	 */
	private static final String FILEDIALOG_TITLE = "Select filename";

	/**
	 * This method shows a dialog where a file can be selected and returns the
	 * file's path afterwards.
	 *
	 * @return absolute path of a selected file
	 */
	public static String getFilePath() {
		String filepath = "";

		try {
			final JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setDialogTitle(FILEDIALOG_TITLE);
			int returnVal = fileChooser.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File chosenFile = fileChooser.getSelectedFile();
				filepath = chosenFile.getAbsolutePath();
			}
		} catch (HeadlessException hlEx) {
			System.err.println("headless error: " + hlEx.getMessage());
		} catch (SecurityException secEx) {
			System.err.println("security error: " + secEx.getMessage());
		}

		return filepath;
	}

	/**
	*
	* @param values list to fill with numbers
	* @param numberScanner source of numbers
	*
	*/
	private static void fillIntList(List<Integer> values, Scanner numberScanner) throws IllegalStateException, IOException {
		while (numberScanner.hasNext())
			if (numberScanner.hasNextInt())
				values.add(numberScanner.nextInt());
			else
				throw new IOException(
					"file does not only contain numbers and delimiters");
	}

	/**
	*
	* @param tmpMatrix row list
	* @param maxLength maximum row length
	*
	* @return quadratic matrix of ints
	*/
	private static int[][] getIntMatrixFromRowList(List<Integer[]> tmpMatrix, int maxLength) {
		int[][] matrix = new int[tmpMatrix.size()][maxLength];

		if (maxLength > 0 && tmpMatrix.size() > 0)
			for (int i = 0; i < matrix.length; ++i)
				for (int j = 0; j < tmpMatrix.get(i).length; ++j)
					matrix[i][j] = tmpMatrix.get(i)[j];

		return matrix;
	}

	/**
	 * Reads in all integers in a given file. If an error occurs an empty array is
	 * returned.
	 *
	 * @param filename
	 * @return an array of all integers in filename
	 */
	public static int[] readIntArray(String filename) {
		List<Integer> values = new ArrayList<Integer>();
		int[] readValues = null;
		Scanner numberScanner = null;
		
		try {
			numberScanner = new Scanner(new File(filename));
			fillIntList(values, numberScanner);
		} catch (IllegalStateException illStateEx) {
			// exception is only thrown by Scanner in Java 7
			System.err.println("Illegal State error: "
					+ illStateEx.getMessage());
		} catch (IOException e) {
			System.err.println("IO error: " + e.getMessage());
		} finally {
			if (numberScanner != null)
				numberScanner.close();
		}

		readValues = new int[values.size()];
		for (int i = 0; i < values.size(); i++)
			readValues[i] = values.get(i);

		return readValues;
	}

	/**
	 * This method returns an empty matrix in erroneous case or a matrix of integers in
	 * filename either. The only valid delimiter between numbers in a row is a
	 * SPACE.
	 *
	 * @param filename
	 *            file to be read
	 * @return integer matrix
	 */
	public static int[][] readIntMatrix(String filename) {
		File dataFile = new File(filename);
		List<Integer[]> tmpMatrix = new ArrayList<Integer[]>();
		Scanner fileScanner = null;
		Scanner lineScanner = null;
		int maxLength = 0;

		try {
			fileScanner = new Scanner(dataFile);

			while (fileScanner.hasNextLine()) {
				lineScanner = new Scanner(fileScanner.nextLine());
				List<Integer> tmpRow = new ArrayList<Integer>();

				fillIntList(tmpRow, lineScanner);

				Integer[] row = tmpRow.toArray(new Integer[tmpRow.size()]);
				tmpMatrix.add(row);
				
				if (row.length > maxLength)
					maxLength = row.length;
				
				if (lineScanner != null)
					lineScanner.close();
			}

		} catch (IllegalStateException illStateEx) {
			System.err.println("Illegal State error: " + illStateEx.getMessage());
		} catch (FileNotFoundException fileNotFoundEx) {
			System.err.println("IO error: " + fileNotFoundEx.getMessage());
		} catch (IOException ioEx) {
			System.err.println("IO error: " + ioEx.getMessage());
		} finally {
			if (fileScanner != null)
				fileScanner.close();
			if (lineScanner != null)
				lineScanner.close();
		}

		return getIntMatrixFromRowList(tmpMatrix, maxLength);
	}

	/**
	 * Read strings located in a file into a string array. If no string could be
	 * located in file, an empty array is returned.
	 *
	 * @param filename
	 *            file to read in
	 * @return strings in the file
	 */
	public static String[] readStringArray(String filename) {
		List<String> values = new ArrayList<String>();
		String[] readInValues = null;
		Scanner stringScanner = null;

		try {
			stringScanner = new Scanner(new File(filename));
			while (stringScanner.hasNext())
				values.add(stringScanner.next());
		} catch (IllegalStateException illStateEx) {
			System.err.println("Illegal state error: "
					+ illStateEx.getMessage());
		} catch (IOException ioEx) {
			System.err.println("IO error: " + ioEx.getMessage());
		} finally {
			if (stringScanner != null)
				stringScanner.close();
		}

		readInValues = new String[values.size()];
		readInValues = values.toArray(readInValues);

		return readInValues;
	}

} // END CLASS FileUtils
