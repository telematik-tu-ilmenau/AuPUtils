SOURCEFOLDER = src

all: jar javadoc

jar:
	javac $(SOURCEFOLDER)/aup/*.java
	jar -cf aupUtils.jar -C $(SOURCEFOLDER) aup

javadoc:
	javadoc $(SOURCEFOLDER)/aup/*.java -d javadoc

clean:
	rm -rf javadoc
	rm -rf $(SOURCEFOLDER)/aup/*.class
	rm -f aupUtils.jar
