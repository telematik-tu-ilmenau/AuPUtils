$TESTPATH="test"
$SRCPATH="src"
$LIBPATH="lib"
$EXAMPLEPATH="examples"
$CLASSPATH="$LIBPATH\junit.jar;$TESTPATH;$SRCPATH;$EXAMPLEPATH"

# run tests
java -cp $CLASSPATH ReadNumbers