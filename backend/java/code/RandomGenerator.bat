javac -cp ./commons-cli-1.4/commons-cli-1.4.jar RandomGenerator.java
REM java -cp ".;./commons-cli-1.4/commons-cli-1.4.jar" RandomGenerator
: 运行时-cp必须引起来
java -cp ".;./commons-cli-1.4/commons-cli-1.4.jar" RandomGenerator --help