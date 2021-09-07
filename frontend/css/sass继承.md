# Sass继承

语法： `@extend <selector>`

来看一段弹性布局的写法，继承要以`%`标识类名

```scss
%flex-center {
    display: flex;
    align-items: center;
    justify-content: center;
}
.wrap {
    width:500px;
    height:500px;
    @extend %flex-center;
}

.container {
    width:500px;
    height:500px;
    @extend %flex-center;
}
```

预处理后的css
```css
.container, .wrap {
  display: flex;
  align-items: center;
  justify-content: center;
}

.wrap {
  width: 500px;
  height: 500px;
}

.container {
  width: 500px;
  height: 500px;
}
```

**继承可以实现对其它类的引用，从而达到样式类的复用。**
在写样式的过程中，总会遇到某部分样式写了很多遍，这时候可以将这部分样式作为一个类单独提取出来，作为一个通用样式，然后我们在需要用这个通用样式的地方通过`@extend`引入即可。

**@extend比@mixin写的代码具有更低的冗余性**

## 继承与混入的区别

```scss
//继承
%flex-center {
    display: flex;
    align-items: center;
    justify-content: center;
}
.wrap {
    @extend %flex-center;
}

.container {
    @extend %flex-center;
}

//混合
@mixin flex-center () {
    display: flex;
    align-items: center;
    justify-content: center;
}

.wrap {
    @include flex-center();
}

.container {
    @include flex-center();
}
```
生成的css

```css
//继承
.container, .wrap {
    display: flex;
    align-items: center;
    justify-content: center;
}

//混合
.wrap {
    display: flex;
    align-items: center;
    justify-content: center;
}

.container {
    display: flex;
    align-items: center;
    justify-content: center;
}
```

* 混合不是公用样式类，而是直接复制一份出来
* 继承只是对类添加选择器达到公用的目的

所以继承没有代码冗余，而混合是有的。