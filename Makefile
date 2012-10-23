SOURCEPATH = src

all: jar javadoc

jar:
	javac $(SOURCEPATH)/aup/*.java
	jar -cf aupUtils.jar -C $(SOURCEPATH) aup

javadoc:
	javadoc $(SOURCEPATH)/aup/*.java -d javadoc

clean:
	rm -rf javadoc
	rm -rf $(SOURCEPATH)/aup/*.class
	rm -f aupUtils.jar
