SOURCEPATH=src
LIBPATH=lib
TESTPATH=test
EXAMPLEPATH=examples

# Linux/Unix/OSX
CLASSPATH=lib/junit.jar:test:src
# Windows
# CLASSPATH=lib/junit.jar;test;src

all: aupUtils jar javadoc tests examples json-simple

jar: aupUtils json-simple
	jar -cf aupUtils.jar -C $(SOURCEPATH) aup -C $(SOURCEPATH) org

aupUtils:
	javac $(SOURCEPATH)/aup/*.java

json-simple:
	javac $(SOURCEPATH)/org/json/simple/*.java $(SOURCEPATH)/org/json/simple/parser/*.java

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
	rm -rf $(SOURCEPATH)/org/json/simple/*.class
	rm -rf $(SOURCEPATH)/org/json/simple/parser/*.class
	rm -rf $(EXAMPLEPATH)/*.class
	rm -f aupUtils.jar
	rm -rf $(TESTPATH)/*.class
