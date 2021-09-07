# Sass语句

Sass语法中，一个sass文件包含很多语句，这些语句最终用于编译CSS。语句申明可以包含块定义，即使用`{`和`}`包含的其他语句块。
Scss语法中，每个语句都以`;`结束，Sass语法中以是换行结束。

## 通用语句

* 变量申明

    语法格式：`$<variable>: <expression>`，与CSS的属性定义有点类似，不同的是Sass变量申明仅能以样式规则或者@规则格式申明，可以申明在任何位置。

    ```css
    $var: value
    ```

* 流控@规则
    ```scss
    @if 
        //语法格式 @if/@else if/@else <expression> { ... }
        $left-value: if($property == right, initial, $value);//三目条件右值
        //条件判断语法
        @if $direction == up {
            border-bottom-color: $color;
        } @else if $direction == right {
            border-left-color: $color;
        } @else if $direction == down {
            border-top-color: $color;
        } @else if $direction == left {
            border-right-color: $color;
        } @else {
            @error "Unknown direction #{$direction}.";
        }
    @each 
        //语法格式 @each <variable> in <expression> { ... }
        $sizes: 40px, 50px, 80px; //列表枚举

        @each $size in $sizes {
            .icon-#{$size} {
                font-size: $size;
                height: $size;
                width: $size;
            }
        }
        //Map枚举
        $icons: ("eye": "\f112", "start": "\f12e", "stop": "\f12f");

        @each $name, $glyph in $icons {
            .icon-#{$name}:before {
                display: inline-block;
                font-family: "Icon Font";
                content: $glyph;
            }
        }
        //解构
        $icons:
            "eye" "\f112" 12px,
            "start" "\f12e" 16px,
            "stop" "\f12f" 10px;

        @each $name, $glyph, $size in $icons {
            .icon-#{$name}:before {
                display: inline-block;
                font-family: "Icon Font";
                content: $glyph;
                font-size: $size;
            }
        }

    @for 
        //语法 @for <variable> from <expression> to <expression> { ... } 
        //语法 @for <variable> from <expression> through <expression> { ... }

        $base-color: #036;

        @for $i from 1 through 3 {
            ul:nth-child(3n + #{$i}) {
                background-color: lighten($base-color, $i * 5%);
            }
        }


    @while
        //语法 @while <expression> { ... }
        //建议少用While，而使用@each 和 @for来替代实现
        @use "sass:math";

        /// Divides `$value` by `$ratio` until it's below `$base`.
        @function scale-below($value, $base, $ratio: 1.618) {
            @while $value > $base {
                $value: math.div($value, $ratio);
            }
            @return $value;
        }

        $normal-font-size: 16px;
        sup {
            font-size: scale-below(20px, 16px);
        }
    ````

* 其他@语法

    ```
    @forward
    @import
    @mixin
    @include
    @function
    @extend
    @error //输入编译时信息 eg:@error "Property #{$property} must be either left or right.";
    @warn  //输入编译时信息
    @debug //输入编译时信息
    @at-root
    ```

