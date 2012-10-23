$TESTPATH="test"
$SRCPATH="src"
$LIBPATH="lib"
$CLASSPATH="$LIBPATH\junit.jar;$TESTPATH;$SRCPATH"

# compile tests
javac -cp $CLASSPATH $TESTPATH\*.java

# run tests
java -cp $CLASSPATH org.junit.runner.JUnitCore InputReaderTest