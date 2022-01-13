# [A Tour of Go (google.cn)](https://golang.google.cn/tour/welcome/1)

## Go有哪些环境变量？
```bash
# go help environment
The go command and the tools it invokes consult environment variables
for configuration. If an environment variable is unset, the go command
uses a sensible default setting. To see the effective setting of the
variable <NAME>, run 'go env <NAME>'. To change the default setting,
run 'go env -w <NAME>=<VALUE>'. Defaults changed using 'go env -w'
are recorded in a Go environment configuration file stored in the
per-user configuration directory, as reported by os.UserConfigDir.
The location of the configuration file can be changed by setting
the environment variable GOENV, and 'go env GOENV' prints the
effective location, but 'go env -w' cannot change the default location.
See 'go help env' for details.

General-purpose environment variables:

        GO111MODULE
                Controls whether the go command runs in module-aware mode or GOPATH mode.
                May be "off", "on", or "auto".
                See https://golang.org/ref/mod#mod-commands.
        GCCGO
                The gccgo command to run for 'go build -compiler=gccgo'.
        GOARCH
                The architecture, or processor, for which to compile code.
                Examples are amd64, 386, arm, ppc64.
        GOBIN
                The directory where 'go install' will install a command.
        GOCACHE
                The directory where the go command will store cached
                information for reuse in future builds.
        GOMODCACHE
                The directory where the go command will store downloaded modules.
        GODEBUG
                Enable various debugging facilities. See 'go doc runtime'
                for details.
        GOENV
                The location of the Go environment configuration file.
                Cannot be set using 'go env -w'.
        GOFLAGS
                A space-separated list of -flag=value settings to apply
                to go commands by default, when the given flag is known by
                the current command. Each entry must be a standalone flag.
                Because the entries are space-separated, flag values must
                not contain spaces. Flags listed on the command line
                are applied after this list and therefore override it.
        GOINSECURE
                Comma-separated list of glob patterns (in the syntax of Go's path.Match)
                of module path prefixes that should always be fetched in an insecure
                manner. Only applies to dependencies that are being fetched directly.
                GOINSECURE does not disable checksum database validation. GOPRIVATE or
                GONOSUMDB may be used to achieve that.
        GOOS
                The operating system for which to compile code.
                Examples are linux, darwin, windows, netbsd.
        GOPATH
                For more details see: 'go help gopath'.
        GOPROXY
                URL of Go module proxy. See https://golang.org/ref/mod#environment-variables
                and https://golang.org/ref/mod#module-proxy for details.
        GOPRIVATE, GONOPROXY, GONOSUMDB
                Comma-separated list of glob patterns (in the syntax of Go's path.Match)
                of module path prefixes that should always be fetched directly
                or that should not be compared against the checksum database.
                See https://golang.org/ref/mod#private-modules.
        GOROOT
                The root of the go tree.
        GOSUMDB
                The name of checksum database to use and optionally its public key and
                URL. See https://golang.org/ref/mod#authenticating.
        GOTMPDIR
                The directory where the go command will write
                temporary source files, packages, and binaries.
        GOVCS
                Lists version control commands that may be used with matching servers.
                See 'go help vcs'.

Environment variables for use with cgo:

        AR
                The command to use to manipulate library archives when
                building with the gccgo compiler.
                The default is 'ar'.
        CC
                The command to use to compile C code.
        CGO_ENABLED
                Whether the cgo command is supported. Either 0 or 1.
        CGO_CFLAGS
                Flags that cgo will pass to the compiler when compiling
                C code.
        CGO_CFLAGS_ALLOW
                A regular expression specifying additional flags to allow
                to appear in #cgo CFLAGS source code directives.
                Does not apply to the CGO_CFLAGS environment variable.
        CGO_CFLAGS_DISALLOW
                A regular expression specifying flags that must be disallowed
                from appearing in #cgo CFLAGS source code directives.
                Does not apply to the CGO_CFLAGS environment variable.
        CGO_CPPFLAGS, CGO_CPPFLAGS_ALLOW, CGO_CPPFLAGS_DISALLOW
                Like CGO_CFLAGS, CGO_CFLAGS_ALLOW, and CGO_CFLAGS_DISALLOW,
                but for the C preprocessor.
        CGO_CXXFLAGS, CGO_CXXFLAGS_ALLOW, CGO_CXXFLAGS_DISALLOW
                Like CGO_CFLAGS, CGO_CFLAGS_ALLOW, and CGO_CFLAGS_DISALLOW,
                but for the C++ compiler.
        CGO_FFLAGS, CGO_FFLAGS_ALLOW, CGO_FFLAGS_DISALLOW
                Like CGO_CFLAGS, CGO_CFLAGS_ALLOW, and CGO_CFLAGS_DISALLOW,
                but for the Fortran compiler.
        CGO_LDFLAGS, CGO_LDFLAGS_ALLOW, CGO_LDFLAGS_DISALLOW
                Like CGO_CFLAGS, CGO_CFLAGS_ALLOW, and CGO_CFLAGS_DISALLOW,
                but for the linker.
        CXX
                The command to use to compile C++ code.
        FC
                The command to use to compile Fortran code.
        PKG_CONFIG
                Path to pkg-config tool.

Architecture-specific environment variables:

        GOARM
                For GOARCH=arm, the ARM architecture for which to compile.
                Valid values are 5, 6, 7.
        GO386
                For GOARCH=386, how to implement floating point instructions.
                Valid values are sse2 (default), softfloat.
        GOMIPS
                For GOARCH=mips{,le}, whether to use floating point instructions.
                Valid values are hardfloat (default), softfloat.
        GOMIPS64
                For GOARCH=mips64{,le}, whether to use floating point instructions.
                Valid values are hardfloat (default), softfloat.
        GOPPC64
                For GOARCH=ppc64{,le}, the target ISA (Instruction Set Architecture).
                Valid values are power8 (default), power9.
        GOWASM
                For GOARCH=wasm, comma-separated list of experimental WebAssembly features to use.
                Valid values are satconv, signext.

Special-purpose environment variables:

        GCCGOTOOLDIR
                If set, where to find gccgo tools, such as cgo.
                The default is based on how gccgo was configured.
        GOEXPERIMENT
                Comma-separated list of toolchain experiments to enable or disable.
                The list of available experiments may change arbitrarily over time.
                See src/internal/goexperiment/flags.go for currently valid values.
                Warning: This variable is provided for the development and testing
                of the Go toolchain itself. Use beyond that purpose is unsupported.
        GOROOT_FINAL
                The root of the installed Go tree, when it is
                installed in a location other than where it is built.
                File names in stack traces are rewritten from GOROOT to
                GOROOT_FINAL.
        GO_EXTLINK_ENABLED
                Whether the linker should use external linking mode
                when using -linkmode=auto with code that uses cgo.
                Set to 0 to disable external linking mode, 1 to enable it.
        GIT_ALLOW_PROTOCOL
                Defined by Git. A colon-separated list of schemes that are allowed
                to be used with git fetch/clone. If set, any scheme not explicitly
                mentioned will be considered insecure by 'go get'.
                Because the variable is defined by Git, the default value cannot
                be set using 'go env -w'.

Additional information available from 'go env' but not read from the environment:

        GOEXE
                The executable file name suffix (".exe" on Windows, "" on other systems).
        GOGCCFLAGS
                A space-separated list of arguments supplied to the CC command.
        GOHOSTARCH
                The architecture (GOARCH) of the Go toolchain binaries.
        GOHOSTOS
                The operating system (GOOS) of the Go toolchain binaries.
        GOMOD
                The absolute path to the go.mod of the main module.
                If module-aware mode is enabled, but there is no go.mod, GOMOD will be
                os.DevNull ("/dev/null" on Unix-like systems, "NUL" on Windows).
                If module-aware mode is disabled, GOMOD will be the empty string.
        GOTOOLDIR
                The directory where the go tools (compile, cover, doc, etc...) are installed.
        GOVERSION
                The version of the installed Go tree, as reported by runtime.Version.
```
GOARCH ：cpu架构，386、amd64、arm等，在交叉编译的时候设置，可以编译不同平台的包。
GOOS：平台，linux、windows等，通常和GOARCH搭配使用。

```
Mac下编译Linux, Windows平台的64位可执行程序： 

CGO_ENABLED=0 GOOS=linux GOARCH=amd64 go build test.go  
CGO_ENABLED=0 GOOS=windows GOARCH=amd64 go build test.go

Linux下编译Mac, Windows平台的64位可执行程序：  

CGO_ENABLED=0 GOOS=darwin GOARCH=amd64 go build test.go  
CGO_ENABLED=0 GOOS=windows GOARCH=amd64 go build test.go

Windows下编译Mac, Linux平台的64位可执行程序：  

SET CGO_ENABLED=0  
SET GOOS=darwin  
SET GOARCH=amd64  
go build test.go  

SET CGO_ENABLED=0  
SET GOOS=linux  
SET GOARCH=amd64  

go build test.go
```
**GOCACHE**: 这是go build产生的缓存，这可以加快编译速度，我在GOCACHE打印出来的路径下看到了一个README文件，它解释了GOCACHE。可以使用"go clean -cache"命令清除编译缓存。
```
This directory holds cached build artifacts from the Go build system.
Run "go clean -cache" if the directory is getting too large.
See golang.org to learn more about Go.
```
**GOENV**: 本地的go环境文件存储位置，不可以用"go env -w"设置它。

## 安装GO的开发环境，要配置哪些环境变量
**Go语言环境变量配置**

安装Go语言需要配置的环境变量有GOROOT、GOPATH和Path
GOROOT的变量值即为GO的安装目录
GOPATH的变量值即为存储Go语言项目的路径