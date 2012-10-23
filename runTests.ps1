$TESTPATH="test"
$SRCPATH="src"
$LIBPATH="lib"
$CLASSPATH="$LIBPATH\junit.jar;$TESTPATH;$SRCPATH"

# run tests
java -cp $CLASSPATH org.junit.runner.JUnitCore InputReaderTest FileUtilsTest