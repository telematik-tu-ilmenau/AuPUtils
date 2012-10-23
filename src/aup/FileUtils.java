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
	 * Reads in all integers in a given file. If an error occurs null is
	 * returned.
	 *
	 * @param filename
	 * @return an array of all integers in filename
	 */
	public static int[] readIntArray(String filename) {
		int[] readValues = null;
		List<Integer> values = new ArrayList<Integer>();
		Scanner numberScanner = null;
		try {
			numberScanner = new Scanner(new File(filename));
			while (numberScanner.hasNext()) {
				if (numberScanner.hasNextInt())
					values.add(numberScanner.nextInt());
				else {
					throw new IOException(
							"file does not only contain numbers and delimiters");
				}
			}
			readValues = new int[values.size()];

			for (int i = 0; i < values.size(); i++)
				readValues[i] = values.get(i);
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

		return readValues;
	}

	/**
	 * This method return null in erroneous case or a matrix of integers in
	 * filename either. The only valid delimiter between numbers in a row is a
	 * SPACE.
	 *
	 * @param filename
	 *            file to be read
	 * @return integer matrix
	 */
	public static int[][] readIntMatrix(String filename) {
		int[][] readValues = null;
		File dataSource = new File(filename);
		List<Integer[]> valueMatrixList = new ArrayList<Integer[]>();
		Scanner lineGetter = null;
		Scanner numberScanner = null;
		int maxLength = 0;

		try {
			lineGetter = new Scanner(dataSource);

			while (lineGetter.hasNextLine()) {
				numberScanner = new Scanner(lineGetter.nextLine());
				List<Integer> rowValues = new ArrayList<Integer>();

				while (numberScanner.hasNext()) {
					if (numberScanner.hasNextInt())
						rowValues.add(numberScanner.nextInt());
					else {
						throw new IOException(
								"a line does not only contain numbers and delimiters");
					}
				}

				Integer[] row = new Integer[rowValues.size()];
				row = rowValues.toArray(row);
				valueMatrixList.add(row);
				if (row.length > maxLength)
					maxLength = row.length;
				if (numberScanner != null)
					numberScanner.close();
			}

			readValues = new int[valueMatrixList.size()][maxLength];

			if (maxLength > 0 && valueMatrixList.size() > 0)
				for (int i = 0; i < readValues.length; ++i)
					for (int j = 0; j < valueMatrixList.get(i).length; ++j)
						readValues[i][j] = valueMatrixList.get(i)[j];

		} catch (IllegalStateException illStateEx) {
			System.err.println("Illegal State error: "
					+ illStateEx.getMessage());
		} catch (FileNotFoundException fileNotFoundEx) {
			System.err.println("IO error: " + fileNotFoundEx.getMessage());
		} catch (IOException ioEx) {
			System.err.println("IO error: " + ioEx.getMessage());
			readValues = null;
		} finally {
			if (lineGetter != null)
				lineGetter.close();
			if (numberScanner != null)
				numberScanner.close();
		}

		return readValues;
	}

	/**
	 * Read strings located in a file into a string array. If no string could be
	 * located in file, null is returned.
	 *
	 * @param filename
	 *            file to read in
	 * @return strings in the file
	 */
	public static String[] readStringArray(String filename) {
		String[] readInValues = null;
		List<String> values = new ArrayList<String>();
		Scanner stringScanner = null;

		try {
			stringScanner = new Scanner(new File(filename));

			while (stringScanner.hasNext()) {
				values.add(stringScanner.next());
			}

			readInValues = new String[values.size()];
			readInValues = values.toArray(readInValues);
		} catch (IllegalStateException illStateEx) {
			System.err.println("Illegal state error: "
					+ illStateEx.getMessage());
		} catch (IOException ioEx) {
			System.err.println("IO error: " + ioEx.getMessage());
		} finally {
			if (stringScanner != null)
				stringScanner.close();
		}

		return readInValues;
	}

} // END CLASS FileUtils
