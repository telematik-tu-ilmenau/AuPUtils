$TESTPATH="test"
$SRCPATH="src"
$LIBPATH="lib"
$CLASSPATH="$LIBPATH\junit.jar;$LIBPATH\hamcrest-all-1.3.jar;$TESTPATH;$SRCPATH"

# run tests
java -cp $CLASSPATH org.junit.runner.JUnitCore InputReaderTest FileUtilsTest
