# Box


>什么是盒子模型？
>完整的 CSS 盒模型应用于块级盒子，内联盒子只使用盒模型中定义的部分内容。模型定义了盒的每个部分 —— margin, border, padding, and content —— 合在一起就可以创建我们在页面上看到的内容。为了增加一些额外的复杂性，有一个标准的和替代（IE）的盒模型。

模型的组成部分：

* Content Box 这个区域是用来显示内容，大小可以通过设置 width 和 height.
* Padding Box 包围在内容区域外部的空白区域； 大小通过 padding 相关属性设置。
* Border Box 边框盒包裹内容和内边距。大小通过 border 相关属性设置。
* Margin Box 这是最外面的区域，是盒子和其他元素之间的空白区域。大小通过 margin 相关属性设置。

在标准模型中，如果你给盒设置 width 和 height，实际设置的是 content box。 padding 和 border 再加上设置的宽高一起决定整个盒子的大小。

替代盒模型与标准模型相反，给盒设置 width 和 height，实际设置的是整个盒子的大小。 

**浏览器默认使用的是标准模型**，如果需要替代模型，使用`box-sizing: border-box;`来实现，如果你希望所有元素都使用替代模式，而且确实很常用，设置 box-sizing 在 <html> 元素上，然后设置所有元素继承该属性

```css
html {
  box-sizing: border-box;
}
*, *::before, *::after {
  box-sizing: inherit;
}
```

MDN的教程分类为BlockBox和InlineBox

* 通过对盒子display 属性的设置，比如 inline 或者 block ，来控制盒子的外部显示类型。
    display属性有哪些？
    * inline
    * block
    * flex
    * inline-flex
    * inline-block
* display 属性可以改变盒子的外部显示类型是块级还是内联，这将会改变它与布局中的其他元素的显示方式。 

## BlockBox 块级盒子

除非特殊指定，诸如标题(`<h1>`等)和段落(`<p>`)默认情况下都是块级的盒子。

* 盒子会在内联的方向上扩展并占据父容器在该方向上的所有可用空间，在绝大数情况下意味着盒子会和父容器一样宽
* 每个盒子都会换行
* width 和 height 属性可以发挥作用
* 内边距（padding）, 外边距（margin） 和 边框（border） 会将其他元素从当前盒子周围“推开”

## InlineBox 内联盒子

用做链接的 `<a> `元素、 `<span>`、 `<em> `以及 `<strong> `都是默认处于 inline 状态的。

* 盒子不会产生换行。
* width 和 height 属性将不起作用。
* 垂直方向的内边距、外边距以及边框会被应用但是不会把其他处于 inline 状态的盒子推开。
* 水平方向的内边距、外边距以及边框会被应用且会把其他处于 inline 状态的盒子推开。

## 外边距、内边距、边框

[外边距](https://developer.mozilla.org/zh-CN/docs/Web/CSS/margin)：

| 属性 | 示例|
|---|------|
|margin-left|10 px;|
|margin-top|2 em;|
|margin-right| 10%;|
|margin-bottom| 2cm; [inherit/initial/unset]|

[内边距](https://developer.mozilla.org/zh-CN/docs/Web/CSS/padding)：

| 属性 | 示例|
|---|------|
|padding-left|10 px;|
|padding-top|2 em;|
|padding-right| 10%;|
|padding-bottom| 2cm; [inherit/initial/unset]|

[边框](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border)：

| 属性 | 示例|
|---|------|
|[border-left](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-left)|border-top: solid;|
|[border-top](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-top)|border-top: 1rem solid;|
|[border-right](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-right)|border-top: dashed red;|
|[border-bottom](https://developer.mozilla.org/zh-CN/docs/Web/CSS/border-bottom)| border-top: 4mm ridge rgb(170, 50, 220, .6);/border-top: thick double #32a1ce;|
|border-width|`<length> `\| thin \| medium \| thick|
|border-style|none \| hidden \| dotted \| dashed \| solid \| double \| groove \| ridge \| inset \| outset|
|border-color|`<rgb()> | <rgba()> | <hsl()> | <hsla()> | <hex-color> | <named-color> | currentcolor | <deprecated-system-color>`|
|border-top-width|`border-top-width: thick;`|
|border-left-width|`border-top-width: 2em;`|
|border-right-width|`border-top-width: 2ex;`|
|border-bottom-width|`border-top-width: 4px;`|
|border-top-style|`border-top-style: dotted; border-top-style: none;`|
|border-left-style|`border-top-style: dashed;`|
|border-right-style|`border-top-style: solid; border-top-style: groove;`|
|border-bottom-style|`border-top-style: inset;`|
|border-top-color|`border-top-color: red;`|
|border-left-color|`border-top-color: #32a1ce;`|
|border-right-color|`border-top-color: rgb(170, 50, 220, .6); border-top-color: hsl(60, 90%, 50%, .8);`|
|border-bottom-color|`border-top-color: transparent;`|




### 外边距折叠

理解外边距的一个关键是外边距折叠的概念。如果你有两个外边距相接的元素，这些外边距将合并为一个外边距，即最大的单个外边距的大小。

在下面的例子中，我们有两个段落。顶部段落的页 margin-bottom为50px。第二段的margin-top 为30px。因为外边距折叠的概念，所以框之间的实际外边距是50px，而不是两个外边距的总和。

```html
<style>
    .one {
        margin-bottom: 50px;
    }
    .two {
        margin-top: 30px;
    }
</style>
<div class="container">
  <p class="one">I am paragraph one.</p>
  <p class="two">I am paragraph two.</p>
</div>
```

### display:inline-block

display有一个特殊的值，它在内联和块之间提供了一个中间状态。这对于以下情况非常有用:您不希望一个项切换到新行，但希望它可以设定宽度和高度，并避免上面看到的重叠。

一个元素使用 `display: inline-block`，实现我们需要的块级的部分效果：

* 设置`width` 和`height` 属性会生效。
* padding, margin, 以及border 会推开其他元素。

但是，它不会跳转到新行，如果显式添加width 和height 属性，它只会变得比其内容更大。


