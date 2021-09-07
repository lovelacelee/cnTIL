# 变量

CSS原生语法也有[变量](https://developer.mozilla.org/zh-CN/docs/Web/CSS/Using_CSS_custom_properties)，与Sass变量使用方法有本质区别

* Sass变量会被编译，而CSS变量将直接被包含在输出的CSS文件中
* CSS变量允许不同的元素有不同的值，但Sass变量仅允许变量在编译时一个确定值
* CSS变量申明是申明式的，Sass变量申明是解释式的申明，即是说**CSS原生变量，修改后影响整个CSS文件中引用这个变量的地方，Sass变量在解释编译时只影响修改变量值之后的引用**


原生css的变量定义
```css
element {
    --main-bg-color: green;
}
```

原生css变量的使用

```css
element {
    background-color: var(--main-bg-color)
}
```

## 模块的私有变量定义

```scss
$-private_var: 3 px;
```