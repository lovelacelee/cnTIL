# Sass内置模块

这些内置模块包括：
sass:math
sass:color
sass:string
sass:list
sass:map
sass:selector
andsass:meta

使用时需要先 @use引用内置模块，才能使用模块中的方法。这些模块被引入的时候需要`加上命名空间`，这样可以大大避免sass内置函数与用户自定义函数及css原生方法的命名冲突。此后，sass新增函数也会更加方便。

```scss
@use "sass:color";
.button {
  $primary-color: #6b717f;
  color: $primary-color;
  border: 1px solid color.scale($primary-color, $lightness: 20%);
}
```
将被编译为

```css
.button {
  color: #6b717f;
  border: 1px solid #878d9a;
}
```