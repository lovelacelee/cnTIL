# You may want to visit

* [State of CSS](https://stateofcss.com/) 每年会统计CSS相关的认识率、使用率、满意度的排名

* [Web developer's podcast](https://syntax.fm/) syntax.fm听到了Web Development技术，又练习了English listening skills。
* [CSS Grid](https://cssgrid.io/) Free cource of WesBos [FlexBox](https://flexbox.io/) [CommandLinePowerUser](https://commandlinepoweruser.com/) [Redux](https://learnredux.com/)

* [SASS中文网](https://www.sass.hk/)
* [CSS学习路径](https://fe.rualc.com/note/css.html)
* [MDN CSS](https://developer.mozilla.org/zh-CN/docs/Learn/CSS/Building_blocks)
* [Can I Use](https://caniuse.com/)

## CSS预处理器？

* CSS 本身缺乏编写可重复使用和有组织的代码所需的复杂逻辑和功能。
* CSS 预处理器是一种工具，通过自己的脚本语言扩展默认 CSS 的基本功能。SCSS/SASS LESS均是如此。
* 增强的功能包括：变量，函数，混合，代码嵌套和继承
* 可用于构建可重复使用的代码片段，避免代码重复，编写组织良好且易于阅读的嵌套代码块。
* 浏览器只能识别原生的CSS，无法解释CSS预处理语法。所以SCSS、LESS、Stylus等都要先编译。

### SCSS/SASS [Docs](https://www.sass.hk/docs/) [github](https://github.com/sass/sass) [OfficialSite]()

>SASS-世界上最成熟、最稳定、最强大的专业级CSS扩展语言！

SASS的源文件格式一般是：`.sass`, SCSS与SASS的文档格式相比，多了`{}`和`;`，也就是说SASS文件的编写更简洁，用缩进替换了`{}`的管理层级，编写sass就像是编写yaml配置文件

安装使用很简单，在npm环境下：

```bash
npm install -g sass
sass source/stylesheets/index.scss build/stylesheets/index.css
```

* VSCODE怎么编译SASS：`Easy Sass`插件

    vscode/settings.json
    ```
    
    "easysass.formats": [

        {
            "format": "expanded",
            "extension": ".css"
        },
        {
            "format": "compressed",
            "extension": ".min.css"
        }
    ],
    "easysass.targetDir": "css/"
    ```
    `easysass.targetDir`全局设置时的PWD是vscode打开的目录

* 例子：
    index.scss
    ```scss
    $nav-color: #F90;

    nav {
        $width: 50px;
        width: $width;
        color: $nav-color;
    }
    ```
    vscode中保存直接被easy sass编译生成index.css
    ```css
    nav {
        width: 50px;
        color: #F90;
    }
    ```
    和index.min.css
    ```css
    nav{width:50px;color:#F90}
    ```

### [`{less}`](https://lesscss.org/)

实质上是一个javascript工具，来预处理css生成。可以引入`less.js`来处理代码输出css到浏览器，也可以在开发环节使用Less，然后编译成css文件，直接放在项目中。

* Less使用较Sass简单
* Sass较Less强大
* 变量Less用@，Sass用$


### Stylus [Stylus-Lang](https://stylus-lang.com/)

比SASS更优化？Stay tuned.

介于我在研究的时候<sub>(@202109)</sub>，Stylus还没有完全支持VSCode的自动化编译，对我这个小白来讲不太方便。


## 选择入手

Sass






