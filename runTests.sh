#!/bin/zsh

TESTPATH=test
SRCPATH=src
LIBPATH=lib

export CLASSPATH=$LIBPATH/junit.jar:$TESTPATH:$SRCPATH

java org.junit.runner.JUnitCore InputReaderTest FileUtilsTest