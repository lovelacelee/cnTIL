# SASS语法

>Sass语法支持两种格式，scss/sass，两种语法可以互相加载

* SCSS
    * SCSS语法使用.scss的后缀，仅有少量语法的不同，可以直接把scss语法看做CSS的超集
    * 完全兼容CSS语法

    ```SCSS
    @mixin button-base() {
    @include typography(button);
    @include ripple-surface;
    @include ripple-radius-bounded;

    display: inline-flex;
    position: relative;
    height: $button-height;
    border: none;
    vertical-align: middle;

    &:hover { cursor: pointer; }

    &:disabled {
        color: $mdc-button-disabled-ink-color;
        cursor: default;
        pointer-events: none;
    }
    }
    ```

* SASS
    * SASS是缩进语法，使用.sass的后缀文件命名
    * 在SCSS的基础上，省略掉`{}`和`;`的语法
    ```SASS
    @mixin button-base()
    @include typography(button)
    @include ripple-surface
    @include ripple-radius-bounded

    display: inline-flex
    position: relative
    height: $button-height
    border: none
    vertical-align: middle

    &:hover
        cursor: pointer

    &:disabled
        color: $mdc-button-disabled-ink-color
        cursor: default
        pointer-events: none
    ```

