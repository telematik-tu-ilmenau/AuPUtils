all: jar javadoc

jar:
	javac aup/*.java
	jar -cf aupUtils.jar ./aup/*.java ./aup/*.class

javadoc:
	javadoc aup/*.java -d javadoc

clean:
	rm -rf javadoc
	rm aup/*.class
