#!/bin/zsh

TESTPATH=test
SRCPATH=src
LIBPATH=lib

export CLASSPATH=$LIBPATH/junit.jar:$TESTPATH:$SRCPATH

# compile tests
javac $TESTPATH/*.java

# run tests
java org.junit.runner.JUnitCore InputReaderTest