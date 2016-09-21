SOURCEPATH:=src
LIBPATH:=lib
TESTPATH:=test
EXAMPLEPATH:=examples
JAVA_SOURCE:=1.6
JAVA_TARGET:=1.6

CLASSPATH=lib/junit.jar:test:src

all: aupUtils jar javadoc tests examples

jar: aupUtils
	jar -cf aupUtils.jar -C $(SOURCEPATH) aup

aupUtils:
	javac -source $(JAVA_SOURCE) -target $(JAVA_TARGET) $(SOURCEPATH)/aup/*.java

javadoc:
	javadoc $(SOURCEPATH)/aup/*.java \
		    -d javadoc

tests: aupUtils
	javac -source $(JAVA_SOURCE) -target $(JAVA_TARGET) -cp $(CLASSPATH) $(TESTPATH)/*.java

examples: aupUtils
	javac -source $(JAVA_SOURCE) -target $(JAVA_TARGET) -cp $(CLASSPATH) $(EXAMPLEPATH)/*.java

clean:
	rm -rf javadoc
	rm -rf $(SOURCEPATH)/aup/*.class
	rm -rf $(EXAMPLEPATH)/*.class
	rm -f aupUtils.jar
	rm -rf $(TESTPATH)/*.class
