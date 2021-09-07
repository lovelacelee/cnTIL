# Sass混入与包含

@mixin语法 `@mixin name(<arguments...>) { ... }`
@include语法 `@include <name>(<arguments...>)`

@mixin与@include是配套使用的。

**什么是mixin?**

>@mixin是CSS预处理器定义的一种简化代码的方法
>理解为自定义了一段代码，后面使用@include去调用，通过参数引入变量，输出多样化的样式


混入的意义在于定义在样式表可重用的样式，与@extend相比，**@mixin写的代码会有冗余**，要注意：

* 如果代码中涉及到变量，建议使用@mixin来创建相同的代码块
* 如果代码中不需要使用变量，而且一个通用类已在文件中存在，建议使用@extend

```SCSS
@mixin reset-list {
  margin: 0;
  padding: 0;
  list-style: none;
}

@mixin horizontal-list {
  @include reset-list;

  li {
    display: inline-block;
    margin: {
      left: -2px;
      right: 2em;
    }
  }
}

nav ul {
  @include horizontal-list;
}
```

预处理后的css
```css
nav ul {
  margin: 0;
  padding: 0;
  list-style: none;
}
nav ul li {
  display: inline-block;
  margin-left: -2px;
  margin-right: 2em;
}

```

