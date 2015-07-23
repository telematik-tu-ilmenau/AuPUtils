SOURCEPATH=src
LIBPATH=lib
TESTPATH=test
EXAMPLEPATH=examples

CLASSPATH=lib/junit.jar:test:src

all: aupUtils jar javadoc tests examples

jar: aupUtils
	jar -cf aupUtils.jar -C $(SOURCEPATH) aup

aupUtils:
	javac $(SOURCEPATH)/aup/*.java

javadoc:
	javadoc $(SOURCEPATH)/aup/*.java \
		    -d javadoc

tests: aupUtils
	javac -cp $(CLASSPATH) $(TESTPATH)/*.java

examples: aupUtils
	javac -cp $(CLASSPATH) $(EXAMPLEPATH)/*.java

clean:
	rm -rf javadoc
	rm -rf $(SOURCEPATH)/aup/*.class
	rm -rf $(EXAMPLEPATH)/*.class
	rm -f aupUtils.jar
	rm -rf $(TESTPATH)/*.class
