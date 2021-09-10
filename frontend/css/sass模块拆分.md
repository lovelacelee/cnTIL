# sass模块拆分

```css
@import "src/corners"
@use "src/corners"
@forward "src/corners"
@include "src/corners"
```

## @import

sass团队将逐步废弃@import语法，原因：

1、无法知道变量、Mixin、函数具体是在哪里定义，模块多级引用时发生
2、会导致重复的CSS代码，多个scss加载相同的common.scss时发生
3、没有命名空间，无法避免重名
4、没有私有函数的概念
5、extend规则可能会影响一切选择器

## @use

@use的设计是为了取代@import，使CSS、变量、Mixin、函数都可以在不同的样式表中复用。一个样式表文件就是一个模块，其命名空间会基于文件名自动生成，也可以自行定义命名。变量、Mixin、函数会默认在该命名空间下使用。

>具有命名空间的只有变量、Mixin、函数
>被@extend扩展的选择器是不具有命名空间的，占位符选择器也没有命名空间
>应该谨慎使用@extend

```scss
//@use 从其他sass模块中加载mixins functions variables
//@use 可将多个sass模块组合在一起
//@use 加载的其他模块文件命名以_开始
//模块的成员使用，.语法

// src/_corners.scss
$radius: 3px;

@mixin rounded {
    border-radius: $radius;
}
// style.scss

@use "src/corners";

.button {
    @include corners.rounded; //使用corners模块的runded
    padding: 5px + corners.$radius;
}
```
命名空间的使用，当使用`as *`的意义是将引入模块的所有内容处理于全局命名空间
```scss
// 命名空间
@use "src/corners" as c;
@include c.rounded;
// 简化代码，全局命名空间
@use "src/corners" as *;
@include rounded;
// 私有成员，以-开始定义的变量
$-radius: 3px;
```
定义带默认值的可配置模块
```scss
// _library.scss
$black: #000 !default;//!default语法标识变量可被overrided,使用use with语法
$border-radius: 0.25rem !default;
$box-shadow: 0 0.5rem 1rem rgba($black, 0.15) !default;

code {
    border-radius: $border-radius;
    box-shadow: $box-shadow;
}
// style.scss
@use 'library' with (
    $black: #222,
    $border-radius: 0.1rem
);
// use后可以直接跟文件目录名，会自动加载目录下的_index.scss或者_index.sass
// use后可以直接跟原生css模块
// with语句只允许设置被引入模块中已经被定义的默认变量（即使用了!default的变量），只能在引入时被设置一次
```

**`@use 与 @import的区别`**

* 不管使用多少次样式表，@use只会引入和执行一次
* 与全局使用相反，@use是有命名空间的，而且只在当前样式表中生效
* 以`-`或者`_`开头的命名空间被认为是私有的，不会被引入其他样式表

## forward

作用是引入另一个模块的所有变量、mixins和函数，将它们直接作为当前模块的API暴露出去，而不会真的在当前模块增加代码。可以更好地在不同源文件之间拆分代码。

不同于 @use， @forward不会给变量添加命名空间。例如：

```scss
/* bootstrap.scss */
@forward "functions";
@forward "variables";
@forward "mixins";
```
此时生成的bootstrap.css文件中，是不包含"functions"、"variables"、"mixins"代码的，也不能直接在bootstrap.scss文件中使用这些模块。而是需要在另一个文件中 @import或者 `@use "bootstrap"`模块，再去使用这些方法。bootstrap.scss文件类似于一个传输中转站，把上下游的成员变量无缝连接起来。

但是直接写在上游模块中的样式，会被@forward包含进来。

```scss
@forward "functions" show color-yiq;
@forward "functions" hide assert-ascending;
```
使用show和hide可以决定模块中哪些成员对引入后的模块可见。对隐藏的变量，在下游文件中不可以使用，相当于模块私有成员。

**forward as 子句**

```scss
/* material/_index.scss */
@forward "theme" as theme-*;
@forward "func" as func-*;
/* downstream.scss */
@use 'material' as *;
p {
  color: $theme-white;//下游子模块的成员自动带上前缀以区分
}
/* 或者，命名空间从父到子 */
@use 'material';
p {
  height: material.func-pow(4, 3) * 1px;
  color: material.$theme-white;
}
/* 也可以在多合一模块中为theme相关的变量重新定义值 */
@use "material" with ($theme-primary: blue);
/* 这等价于：*/
@use "material/theme" with ($primary: blue);
```