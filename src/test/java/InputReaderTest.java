import aup.*;

import java.io.FileReader;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.*;
import java.lang.Math.*;
import java.math.BigDecimal;
import java.math.BigInteger;

public class InputReaderTest {

	private String getTestFile(String resourceName) {
		return InputReaderTest.class.getClassLoader().getResource(resourceName).getFile();
	}

	private InputReader getInputReader(String file) {
		FileReader filestream = null;
		try {
			filestream = new FileReader(file);
		} catch (FileNotFoundException notFoundEx) {}
		assert (filestream != null);

		BufferedReader br = new BufferedReader(filestream);

		return new InputReader(br);
	}

	@Test
	public void test_readBigDecimal() {
		InputReader inputReader = getInputReader(getTestFile("readFloatingPoints.txt"));
		
		assertEquals(new BigDecimal("1.0"), inputReader.readBigDecimal());
		assertEquals(new BigDecimal("2.0"), inputReader.readBigDecimal());
		assertEquals(new BigDecimal("3.0"), inputReader.readBigDecimal());
   	}

   	@Test
	public void test_readBigInteger() {
		InputReader inputReader = getInputReader(getTestFile("readIntegers.txt"));
		
		assertEquals(new BigInteger("1"), inputReader.readBigInteger());
		assertEquals(new BigInteger("2"), inputReader.readBigInteger());
		assertEquals(new BigInteger("3"), inputReader.readBigInteger());
   	}

	@Test
	public void test_readInt() {
		InputReader inputReader = getInputReader(getTestFile("readIntegers.txt"));
		
		assertEquals(1, inputReader.readInt());
		assertEquals(2, inputReader.readInt());
		assertEquals(3, inputReader.readInt());
   	}

   	@Test
	public void test_readLong() {
		InputReader inputReader = getInputReader(getTestFile("readIntegers.txt"));
		
		assertEquals(1L, inputReader.readInt());
		assertEquals(2L, inputReader.readInt());
		assertEquals(3L, inputReader.readInt());
   	}

   	@Test
	public void test_readChar() {
		InputReader inputReader = getInputReader(getTestFile("readChar.txt"));
		
		assertEquals('0', inputReader.readChar());
		assertEquals('1', inputReader.readChar());
		assertEquals('2', inputReader.readChar());
   	}

   	@Test
	public void test_readDouble() {
		InputReader inputReader = getInputReader(getTestFile("readFloatingPoints.txt"));
		
		assertTrue(Math.abs(1.0 - inputReader.readDouble()) < 0.001);
		assertTrue(Math.abs(2.0 - inputReader.readDouble()) < 0.001);
		assertTrue(Math.abs(3.0 - inputReader.readDouble()) < 0.001);
   	}

   	@Test
	public void test_readFloat() {
		InputReader inputReader = getInputReader(getTestFile("readFloatingPoints.txt"));
		
		assertTrue(Math.abs(1.0F - inputReader.readFloat()) < 0.001);
		assertTrue(Math.abs(2.0F - inputReader.readFloat()) < 0.001);
		assertTrue(Math.abs(3.0F - inputReader.readFloat()) < 0.001);
   	}

   	@Test
	public void test_readString() {
		InputReader inputReader = getInputReader(getTestFile("readString.txt"));
		
		assertTrue("Test 1 a !".equals(inputReader.readString()));
		assertTrue("Test 2 b !".equals(inputReader.readString()));
		assertTrue("Test 3 c !".equals(inputReader.readString()));
   	}
}