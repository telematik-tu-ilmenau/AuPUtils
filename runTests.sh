#!/bin/zsh

TESTPATH=test
SRCPATH=src
LIBPATH=lib

export CLASSPATH=$LIBPATH/junit.jar:$LIBPATH/hamcrest-all-1.3.jar:$TESTPATH:$SRCPATH

java org.junit.runner.JUnitCore InputReaderTest FileUtilsTest
