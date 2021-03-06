<!-- vscode-markdown-toc -->
* 1. [Java内置类型：](#Java)
* 2. [类型转换](#)
* 3. [字符和字符串](#-1)

<!-- vscode-markdown-toc-config
	numbering=true
	autoSave=true
	/vscode-markdown-toc-config -->
<!-- /vscode-markdown-toc -->

# 数据类型

##  1. <a name='Java'></a>Java内置类型：

>Java是强类型语言， 对于每一种数据都定义了类型，基本数据类型分为数值型，字符型，布尔型。数值型又分为了整型和浮点型。

* 基本数据类型
    * 数值型
        * 整型 【byte, int, short, long】
        * 浮点型【float, double】
            * 浮点数默认是double
    * 字符型【char】
    * 布尔型【boolean】
    * **常量也有类型：采用数据的默认类型**
* 引用数据类型
    * 对象【Object】
    * 数组【Array】
    * 接口【Interface】

基本数据类型解析
```

字符类型,它在内存中占用2个字节,也就是16 bit,因为java本身的字符集不是用ASCII码来存储的,
而是用的16位的Unicode字符集,所以它的字符存储范围也就是'\u0000 -- u\ffff',默认值呢?就是'\u0000'

short:短整型,它在内存中占用的是2个字节,16位,值得取值范围是-32768~32767,也就是-2的15次方到2的15次方减一,
默认值也是0S.

int:整型,在内存中占4个字节,32位,值得取值范围是-2147483648~2147483647,也就是-2的31次方到2的31次方减一,
默认值还是0

float :单精度浮点型, 在内存中占4个字节,32位,主要用来存储小数的,但是有限制,有效小数位只有6~7位,默认是0.0f ,
取值范围是:3.402823e+38 ~ 1.401298e-45（e+38表示是乘以10的38次方,同样,e-45表示  乘以10的负45次方)

double:双精度浮点型,在内存中占8个字节,64位,也是用来存储小数的,默认是0.0,取值范围是1.797693e+308 到
4.9000000e-324（e+308表示是乘以10的308次方,同样,e-324表示乘以10的负324次方)

long:长整型,在内存中占8个字节,64位,值的取值范围是-2的63次方到2的63次方减一,默认值要注意了,因为是长整型,
所以默认是虽说是0,但是准确的说是0L,必须要加上L来表示它是long类型,不加就成了int类型了.

JVM 会在编译时期将 boolean 类型的数据转换为 int，使用 1 来表示 true，0 表示 false。
JVM 支持 boolean 数组，但是是通过读写 byte数组来实现的。

字符类型,它在内存中占用2个字节,也就是16 bit,因为java本身的字符集不是用ASCII码来存储的,
而是用的16位的Unicode字符集,所以它的字符存储范围也就是'\u0000 -- u\ffff',默认值呢?就是'\u0000'
```
引用数据类型解析
```
基本类型和引用类型的关系:
基本类型    二进制位数      包装器类(引用类型)
boolean         1           Boolean
byte            8           Byte
char            16          Character
short           16          Short
int             32          Integer
long            64          Long
float           32          Float
double          64          Double

对于取值范围，在对应的包装器类中有常量已经声明:
基本类型byte 二进制位数：Byte.SIZE最小值：Byte.MIN_VALUE最大值：Byte.MAX_VALUE
基本类型short二进制位数：Short.SIZE最小值：Short.MIN_VALUE最大值：Short.MAX_VALUE
基本类型char二进制位数：Character.SIZE最小值：Character.MIN_VALUE最大值：Character.MAX_VALUE
基本类型double 二进制位数：Double.SIZE最小值：Double.MIN_VALUE最大值：Double.MAX_VALUE

JVM就可以完成基本类型和它们对应包装类之间的自动转换。因此我们在赋值、参数传递以及数学运算的时候
就可以像使用基本类型一样使用它们的包装类，但这并不意味着你可以通过基本类型调用它们的包装类才具有
的方法。


```

* Java基本类型存储在栈中，因此它们的存取速度要快于存储在堆中的对应包装类的实例对象。
所有基本类型（包括void）的包装类都使用了final修饰，因此我们无法继承它们扩展新的类
也无法重写它们的任何方法。而引用数据类型是存储在堆中的。
* 基本类型的优势：数据存储相对简单，运算效率比较高
* 包装类的优势：有的容易，比如集合的元素必须是对象类型，满足了java一切皆是对象的思想
* 声明方式不同，基本类型不适用new关键字，而包装类型需要使用new关键字来在堆中分配存储空间；
* 存储方式及位置不同，基本类型是直接将变量值存储在堆栈中，而包装类型是将对象放在堆中，然后通过引用来使用；
* 初始值不同，基本类型的初始值如int为0，boolean为false，而包装类型的初始值为null
* 使用方式不同，基本类型直接赋值直接使用就好，而包装类型在集合如Collection、Map时会使用到

##  2. <a name=''></a>类型转换

根据类型所占内存大小,小可转大，大转小会失去精度

```
数据类型转换(boolean不参与数据类型的转换):
		    char(16 bit)
			|
byte(1 bit) ->  short(16 bit)  -> int(32 bit)  -> long(64 bit)
			|                |
		     float(32 bit)    double(64 bit)

```

在运算过程中，如果参与运算的两个数类型不一致，那么计算结果为较大类型的整型。例如，short和int计算，结果总是int，原因是short首先自动被转型为int

也可以将结果强制转型，即将大范围的整数转型为小范围的整数。强制转型使用(类型)，例如，将int强制转型为short

这与C语言完全一样。

##  3. <a name='-1'></a>字符和字符串

因为Java在内存中总是使用Unicode表示字符，所以，一个英文字符和一个中文字符都用一个char类型表示，它们都占用两个字节。要显示一个字符的Unicode编码，只需将char类型直接赋值给int类型即可：

```java
char c1 = 'A';
char c2 = '中';
int n1 = 'A'; // 字母“A”的Unicodde编码是65
int n2 = '中'; // 汉字“中”的Unicode编码是20013
// 注意是十六进制:
char c3 = '\u0041'; // 'A'，因为十六进制0041 = 十进制65
char c4 = '\u4e2d'; // '中'，因为十六进制4e2d = 十进制20013
```

字符串

```java
String s = ""; // 空字符串，包含0个字符
String s1 = "A"; // 包含一个字符
String s2 = "ABC"; // 包含3个字符
String s3 = "中文 ABC"; // 包含6个字符，其中有一个空格
```

转义字符与C语言一致

* `\"` 表示字符"
* `\'` 表示字符'
* `\\` 表示字符\
* `\n` 表示换行符
* `\r` 表示回车符
* `\t` 表示Tab
* `\u####` 表示一个Unicode编码的字符

### 字符串连接

Java的字符串连接与Python一样。

```java
public class Main {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "world";
        String s = s1 + " " + s2 + "!";
        System.out.println(s);
    }
}
//比Python更好用的地方在于类型自动连接转换
public class Main {
    public static void main(String[] args) {
        int age = 25;
        String s = "age is " + age;
        System.out.println(s);
    }
}
//多行连接
String s = "first line \n"
         + "second line \n"
         + "end";
String s = """ 
           SELECT * FROM
             users
           WHERE id > 100
           ORDER BY name DESC""";
```

注意：
* 字符串不可变性
* 引用变量的空值null
    引用类型的变量可以指向一个空值null，它表示不存在，即该变量不指向任何对象。例如：
    ```java
    String s1 = null; // s1是null
    String s2; // 没有赋初值值，s2也是null
    String s3 = s1; // s3也是null
    String s4 = ""; // s4指向空字符串，不是null
    ```


## 数组

Java的数组有几个特点：

* 数组所有元素初始化为默认值，整型都是0，浮点型是0.0，布尔型是false；
* 数组一旦创建后，大小就不可改变。
* 数组是引用类型，在使用索引访问数组元素时，如果索引超出范围，运行时将报错
* 可以在定义数组时直接指定初始化的元素，这样就不必写出数组大小，而是由编译器自动推算数组大小。例如：
    ```java
    int[] ns = new int[] { 68, 79, 91, 85, 62 };
    int[] ns = { 68, 79, 91, 85, 62 };//进一步简写
    ```
* 数组定义后与String一样，也具有定义之后的不变性

### 二维数组

```java

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] ns = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 }
        };
        System.out.println(Arrays.deepToString(ns));
    }
}
```

### 三维数组


```java
int[][][] ns = {
    {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    },
    {
        {10, 11},
        {12, 13}
    },
    {
        {14, 15, 16},
        {17, 18}
    }
};
```