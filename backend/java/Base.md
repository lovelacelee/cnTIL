<!-- vscode-markdown-toc -->
* 1. [JDK](#JDK)
* 2. [基础原则](#)
* 3. [知道的就不再记录了](#-1)

<!-- vscode-markdown-toc-config
	numbering=true
	autoSave=true
	/vscode-markdown-toc-config -->
<!-- /vscode-markdown-toc -->

# Hello,World

##  1. <a name='JDK'></a>JDK 
2021年了，写JAVA小DEMO再也不用在Oracle下载安装JDK，配置环境变量，一步一步地费劲

VSCODE随便写个java文件保存，按提示安装微软提供的JAVA开发套件，从Github下载JDK11即可起飞。

##  2. <a name=''></a>基础原则

* **Java代码文件名必须与文件中定义的类名一致**
* **每个Java代码文件中，只能有一个Public类**
* **如果文件中有不只有一个类，文件名必须与public类名一致**
* **如果文件中有不只一个类，且没有public类，文件名可与任何一个类名一致**

>1.每个编译单元都有单一的公共接口，用public类来表现。该接口可以按要求包含众多的支持包访问权限的类。如果在某个编译单元内有一个以上的public类，编译器就会给出出错信息。
>2.public类的名称必须完全与含有该编译单元的文件名相匹配，包括大小写。所以对于Widget而言，文件的名称必须是Widget.java，而不是widget.java或WIDGET.java。如果不匹配，同样将得到编译时错误。
>3.虽然不是很常用，但编译单元内完全不带public类也是可能的。这种情况下，可以随意对文件命名。

所以如下流程会报错：

HelloWorld.java
```java
//HelloWorld
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```
你以为你能像GCC编译后执行？
```bash
javac HelloWorld.java
java HelloWorld.class
```

You'll Get:

```bash
Error: Could not find or load main class .\HelloWorld.class
Caused by: java.lang.ClassNotFoundException: /\HelloWorld/class
```

吓得我赶紧看了下帮助：大哥，不带才爽。

```shell
Usage: java [options] <mainclass> [args...]
           (to execute a class)
   or  java [options] -jar <jarfile> [args...]
           (to execute a jar file)
   or  java [options] -m <module>[/<mainclass>] [args...]
       java [options] --module <module>[/<mainclass>] [args...]
           (to execute the main class in a module)
   or  java [options] <sourcefile> [args]
           (to execute a single source-file program)
```
正确的姿势
```
java HelloWorld
```

##  3. <a name='-1'></a>知道的就不再记录了

* 只通过此路径整理已经忘记的内容
* 测试代码也是只跑回忆