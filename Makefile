SOURCEPATH=src
LIBPATH=lib
TESTPATH=test

# Linux/Unix/OSX
CLASSPATH=lib/junit.jar:test:src
# Windows
#CLASSPATH=lib/junit.jar;test;src

all: jar javadoc tests

jar:
	javac $(SOURCEPATH)/aup/*.java
	jar -cf aupUtils.jar -C $(SOURCEPATH) aup

javadoc:
	javadoc $(SOURCEPATH)/aup/*.java -d javadoc

tests:
	javac -cp $(CLASSPATH) $(TESTPATH)/*.java

clean:
	rm -rf javadoc
	rm -rf $(SOURCEPATH)/aup/*.class
	rm -f aupUtils.jar
	rm -rf $(TESTPATH)/*.class
