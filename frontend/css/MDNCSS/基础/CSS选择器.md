# 选择器

>[MDN选择器](https://developer.mozilla.org/zh-CN/docs/Web/CSS/CSS_Selectors)

## 1.基础问题

### 1.1 选择器是什么？
它是元素和其他部分组合起来告诉浏览器哪个HTML元素应当是被选为应用规则中的CSS属性值的方式。选择器所选择的元素，叫做“选择器的对象”。
### 1.2 什么是选择器列表？
多个选择器的样式相同，那么这多个选择器可以被混编到一起，形成选择器列表。选择器之间以`,`分隔开。
```css
h1, .special {
  color: blue;
} 
```
需要注意的是，选择器列表中，如果有某一个选择器语法错误失效，整条列表规则都会失效。

## 2. 选择器分类

### 2.1 元素选择器（HTML元素直接选择）
```css
h1 {}
```
除了所有HTML标签外，还有一个`*`被称为全局选择器，它可以样式化HTML文档中的所有元素。还可以这样用：

想要选中`<article>`元素的任何第一个子元素。
```css
article :first-child {} //正确的写法
article:first-child {} //语法正确，但意义不同，容易与上面的混淆
article *:first-child {} //所以用*来表示从article的子元素中选择第一个
```

### 2.2 类选择器（DOM中指定的class类名选择）
```css
.box {}
```

#### 2.2.1 选择指向特定元素的类
```css
h1.highlight {} //选中h1元素的highlight类
```

#### 2.2.2 多类元素的选择

实际应用中，经常为一个元素定义多个类，如下代码：
```HTML
<div class="notebox">
    This is an informational note.
</div>

<div class="notebox warning">
    This note shows a warning.
</div>

<div class="notebox danger">
    This note shows danger!
</div>
```

如何分别选择DIV并为它们指定不同的样式？**类选择器的拼接**
```css
.notebox {
  border: 4px solid #666;
  padding: .5em;
}

.notebox.warning {
  border-color: orange;
  font-weight: bold;
}

.notebox.danger {
  border-color: red;
  font-weight: bold;
}
```

### 2.3 id选择器（DOM中指定的id名称选择）
```css
#box {}
h1#heading {}
```
ID选择器的用法与类选择器类似，仅是把`.`换成`#`，但是**ID不会在一个元素中存在多个，所以没有多ID元素选择的情况**

### 2.4 标签属性选择器（元素[标签名=标签值]方式来选择）
```css
a[title] { }
a[href="https://example.com"] { }
```

#### 2.4.1 存否、值选择器

允许基于一个元素自身是否存在（例如href）或者基于各式不同的按属性值的匹配，来选取元素。

|选择器	|示例	|描述|
|------|------|----|
|`[attr]`	|`a[title]`	|匹配带有一个名为attr的属性的元素——方括号里的值。|
|`[attr=value]`	|`a[href="https://example.com"]`	|匹配带有一个名为attr的属性的元素，其值正为value——引号中的字符串。|
|`[attr~=value]`	|`p[class~="special"]`	|匹配带有一个名为attr的属性的元素 ，其值正为value，或者匹配带有一个attr属性的元素，其值有一个或者更多，至少有一个和value匹配。注意，在一列中的好几个值，是用空格隔开的。|
|`[attr|=value]`	|`div[lang|="zh"]`	|匹配带有一个名为attr的属性的元素，其值可正为value，或者开始为value，后面紧随着一个连字符。|

```HTML
<ul>
    <li>Item 1</li>
    <li class="a">Item 2</li>
    <li class="a b">Item 3</li>
    <li class="a-b">Item 4</li>
    <li class="ab">Item 5</li>
</ul>
```
```
li[class|="a"] { //选中[2，4]
    color: blue;
}
li[class~="a"] { //选中[2，3]
    color: blue;
}
li[class] { //选中[2，3，4，5]
    font-size: 200%;
}
```


#### 2.4.2 子字符串匹配选择器

让更高级的属性的值的子字符串的匹配变得可行。例如，如果你有box-warning和box-error类，想把开头为“box-”字符串的每个物件都匹配上的话，你可以用[class^="box-"]来把它们两个都选中。


|选择器	|示例|	描述|
|------|---|------|
|`[attr^=value]`	|`li[class^="box-"]`|	匹配带有一个名为attr的属性的元素，其值开头为value子字符串。|
|`[attr$=value]`	|`li[class$="-box"]`|	匹配带有一个名为attr的属性的元素，其值结尾为value子字符串|
|`[attr*=value]	`|`li[class*="box"]`|	匹配带有一个名为attr的属性的元素，其值的字符串中的任何地方，至少出现了一次value子字符串。|

```HTML
<ul>
    <li class="a">Item 1</li>
    <li class="ab">Item 2</li>
    <li class="bca">Item 3</li>
    <li class="bcabc">Item 4</li>
</ul>
```

```css
li[class^="a"] { //选中[1，2]
    font-size: 200%;
}

li[class$="a"] { //选中[1，3]
    background-color: yellow;
}

li[class*="a"] { //选中[1，2，3，4]
    color: red;
}
```

#### 控制大小写敏感
如果你想在大小写不敏感的情况下，匹配属性值的话，你可以在闭合括号之前，使用i值。这个标记告诉浏览器，要以大小写不敏感的方式匹配ASCII字符。

没有了这个标记的话，值会按照文档语言对大小写的处理方式，进行匹配——HTML中是大小写敏感的，默认是大小写敏感的。

```css
li[class^="a" i] { //选中以a或者A开头的类
    color: red;
}
```

### 2.5 伪元素选择器
* 伪元素是选择器的一种
* 伪元素以`::`开头

选择一个元素的某个部分而不是元素自己。例如，::first-line是会选择一个元素（下面的情况中是`<p>`）中的第一行，类似`<span>`包在了第一个被格式化的行外面，然后选择这个`<span>`。
```css
p::first-line { }

//伪类和伪元素合并使用的例子
//选择一个<article>元素里面的第一个<p>元素的第一行。
article p:first-child::first-line { 
  font-size: 120%;
  font-weight: bold;
}
```

#### 2.5.1 特别的伪元素

`::before ::after`和conent属性一同使用，使用CSS将内容插入文档中

一般用法是用来在内容的前、后插入一些醒目的图标、样式等。[更多理解](https://developer.mozilla.org/zh-CN/docs/Learn/CSS/Building_blocks/Selectors/Pseudo-classes_and_pseudo-elements)

#### 2.5.2 有哪些伪元素

|选择器	|描述|
|--|--|
|::after	|匹配出现在原有元素的实际内容之后的一个可样式化元素。|
|::before	|匹配出现在原有元素的实际内容之前的一个可样式化元素。|
|::first-letter	|匹配元素的第一个字母。|
|::first-line	|匹配包含此伪元素的元素的第一行。|
|::grammar-error	|匹配文档中包含了浏览器标记的语法错误的那部分。|
|::selection	|匹配文档中被选择的那部分。|
|::spelling-error	|匹配文档中包含了浏览器标记的拼写错误的那部分。|


### 2.6 伪类选择器 [Pseudo-class]

* 伪类是选择器的一种
* 帮助在标记文本上减少多余的分类
* 伪类以`:`开头
这组选择器包含了[伪类]()，用来样式化一个元素的特定状态。例如:hover伪类会在鼠标指针悬浮到一个元素上的时候选择这个元素：
```css
a:hover { }
```

#### 2.6.1 The Prseudo Class I Got
| 类 | 意义 |
|---|----|
| `:first-child`| 代表父元素的第一个子元素。|
| `:last-child`| 代表父元素的最后一个子元素。|
| `:only-child`|匹配没有任何兄弟元素的元素，等效写法`:first-child:last-child或者:nth-child(1):nth-last-child(1),当然,前者的权重会低一点.` |
| `:invalid`|input/form等元素中标记为invalid的元素 |

#### 2.6.2 用户行为伪类

| 类 | 意义 |
|---|----|
| `:hover`| 只会在用户将指针挪到元素上的时候才会激活，一般就是链接元素。|
| `:focus`| 只会在用户使用键盘控制，选定元素的时候激活。|

#### 2.6.3 MDN伪类列表

|选择器	|描述|
|----|-----|
|:active	|在用户激活（例如点击）元素的时候匹配。|
|:any-link	|匹配一个链接的:link和:visited状态。|
|:blank	|匹配空输入值的`<input>`元素。|
|:checked	|匹配处于选中状态的单选或者复选框。|
|:current (en-US)	|匹配正在展示的元素，或者其上级元素。|
|:default	|匹配一组相似的元素中默认的一个或者更多的UI元素。|
|:dir	|基于其方向性（HTMLdir属性或者CSSdirection属性的值）匹配一个元素。|
|:disabled	|匹配处于关闭状态的用户界面元素|
|:empty	|匹配除了可能存在的空格外，没有子元素的元素。|
|:enabled	|匹配处于开启状态的用户界面元素。|
|:first	|匹配分页媒体的第一页。|
|:first-child	|匹配兄弟元素中的第一个元素。|
|:first-of-type	|匹配兄弟元素中第一个某种类型的元素。|
|:focus	|当一个元素有焦点的时候匹配。|
|:focus-visible	|当元素有焦点，且焦点对用户可见的时候匹配。|
|:focus-within	|匹配有焦点的元素，以及子代元素有焦点的元素。|
|:future (en-US)	|匹配当前元素之后的元素。|
|:hover	|当用户悬浮到一个元素之上的时候匹配。|
|:indeterminate	|匹配未定态值的UI元素，通常为复选框。|
|:in-range	|用一个区间匹配元素，当值处于区间之内时匹配。|
|:invalid	|匹配诸如`<input>`的位于不可用状态的元素。|
|:lang	|基于语言（HTMLlang属性的值）匹配元素。|
|:last-child	|匹配兄弟元素中最末的那个元素。|
|:last-of-type|	匹配兄弟元素中最后一个某种类型的元素。|
|:left	|在分页媒体 (en-US)中，匹配左手边的页。|
|:link	|匹配未曾访问的链接。|
|:local-link (en-US)	|匹配指向和当前文档同一网站页面的链接。|
|:is()	|匹配传入的选择器列表中的任何选择器。|
|:not	|匹配作为值传入自身的选择器未匹配的物件。|
|:nth-child	|匹配一列兄弟元素中的元素——兄弟元素按照an+b形式的式子进行匹配（比如2n+1匹配元素1、3、5、7等。即所有的奇数个）。|
|:nth-of-type	|匹配某种类型的一列兄弟元素（比如，`<p>`元素）——兄弟元素按照an+b形式的式子进行匹配（比如2n+1匹配元素1、3、5、7等。即所有的奇数个）。|
|:nth-last-child|	匹配一列兄弟元素，从后往前倒数。兄弟元素按照an+b形式的式子进行匹配（比如2n+1匹配按照顺序来的最后一个元素，然后往前两个，再往前两个，诸如此类。从后往前数的所有奇数个）。|
|:nth-last-of-type|	匹配某种类型的一列兄弟元素（比如，`<p>`元素），从后往前倒数。兄弟元素按照an+b形式的式子进行匹配（比如2n+1匹配按照顺序来的最后一个元素，然后往前两个，再往前两个，诸如此类。从后往前数的所有奇数个）。|
|:only-child	|匹配没有兄弟元素的元素。|
|:only-of-type	|匹配兄弟元素中某类型仅有的元素。|
|:optional|	匹配不是必填的form元素。|
|:out-of-range	|按区间匹配元素，当值不在区间内的的时候匹配。|
|:past (en-US)	|匹配当前元素之前的元素。|
|:placeholder-shown	|匹配显示占位文字的input元素。|
|:playing (en-US)	|匹配代表音频、视频或者相似的能“播放”或者“暂停”的资源的，且正在“播放”的元素。|
|:paused (en-US)	|匹配代表音频、视频或者相似的能“播放”或者“暂停”的资源的，且正在“暂停”的元素。|
|:read-only	|匹配用户不可更改的元素。|
|:read-write	|匹配用户可更改的元素。|
|:required|	匹配必填的form元素。|
|:right	|在分页媒体 (en-US)中，匹配右手边的页。|
|:root|	匹配文档的根元素。|
|:scope|	匹配任何为参考点元素的的元素。|
|:valid	|匹配诸如`<input>`元素的处于可用状态的元素。|
|:target|	匹配当前URL目标的元素（例如如果它有一个匹配当前URL分段的元素）。|
|:visited|	匹配已访问链接。|

### 2.7 运算符选择器

将上述6种选择器组合起来选择

```css
article > p { }
```
用运算符（>）选择了`<article>`元素的初代子元素。

#### 2.7.1 后代选择器
典型用单个空格（ ）字符——组合两个选择器
#### 2.7.2 子代选择器
子代关系选择器是个大于号（>），只会在选择器选中直接子元素的时候匹配。继承关系上更远的后代则不会匹配。
#### 2.7.3 相邻兄弟选择器
邻接兄弟选择器（+）用来选中恰好处于另一个在继承关系上同级的元素旁边的物件。例如，选中所有紧随`<p>`元素之后的`<img>`元素：

`p + img`

#### 2.7.4 通用兄弟选择器
如果你想选中一个元素的兄弟元素，即使它们不直接相邻，你还是可以使用通用兄弟关系选择器（~）。要选中所有的`<p>`元素后任何地方的`<img>`元素，我们会这样做：

`p ~ img`

