# Sass函数.md

实现px与rem的转化

```scss
@function j($px, $base-font-size: 100px) {
    @if (unitless($px)) {
        @warn "Assuming #{$px} to be in pixels, attempting to convert it into pixels for you";
        @return j($px + 0px); // That may fail.
    }

    @else if (unit($px)==rem) {
        @return $px;
    }

    @return ($px / $base-font-size) * 1rem;
}

.box{
    width:j(200);
    height:j(200);
}
```
编译后的CSS

```css
.box {
    width: 2rem;
    height: 2rem;
}
```

函数和混入都是传入参数然后返回结果，函数更多应用于计算并且返回值，而混合更多的返回一段用参数生成的特定样式代码。

* 当函数包含多条语句，需要调用@return返回结果
* 在自定义函数前增加前缀命名，以区分是自定义函数