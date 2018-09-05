import aup.*;

import org.junit.Test;
import static org.junit.Assert.*;

public class FileUtilsTest {

	private String getTestFile(String resourceName) {
		return FileUtilsTest.class.getClassLoader().getResource(resourceName).getFile();
	}

	@Test
	public void test_readIntArray() {
		String filename = "readIntArrayMatrix.txt";
		int[] result = FileUtils.readIntArray(getTestFile(filename));
		for (int i = 0; i < result.length; ++i) {
			assertEquals(i+1, result[i]);
		}
	}

	@Test
	public void test_readIntMatrix() {
		String filename = "readIntArrayMatrix.txt";
		int[][] result = FileUtils.readIntMatrix(getTestFile(filename));
		
		assertEquals(4, result.length);

		for (int row = 0; row < 4; ++row) {
			assertEquals(4, result[row].length);	
		}

		assertEquals(1, result[0][0]);
		
		assertEquals(0, result[1][2]);
		assertEquals(0, result[1][3]);

		assertEquals(9,  result[3][0]);
		assertEquals(10, result[3][1]);
		assertEquals(11, result[3][2]);
		assertEquals(12, result[3][3]);
	}

	@Test
	public void test_readStringArray() {
		String filename = "readStringArray.txt";
		String[] result = FileUtils.readStringArray(getTestFile(filename));
		
		assertEquals(6, result.length);

		assertTrue("Bernd".equals(result[0]));
		assertTrue("Klaus".equals(result[1]));
		assertTrue("Rolf".equals(result[2]));
		assertTrue("Ina".equals(result[3]));
		assertTrue("Lisa".equals(result[4]));
		assertTrue("Julia".equals(result[5]));
	}

}