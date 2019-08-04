# Getting Started

`antsy` provides a number of methods for including ANSI Select Graphics 
Rendition (SGR) display aspects in strings intended for terminal output. 
These include:

* string escape sequences for most SGR display aspects;
* functions for each SGR display aspect; and
* a render function for applying multiple display aspects at once.

For more details on ANSI SGR display aspects, see the
[ECMA 48 Standard Document](http://www.ecma-international.org/publications/files/ECMA-ST/Ecma-048.pdf)

## Requiring `antsy`

`antsy` can be required with:

```clojure
(require '[antsy.core :as antsy])
``` 

## Using display aspect escape sequences

The `antsy.core` namespace includes escape sequence constants for each supported 
display aspect, with name `<aspect>-escape-sequence` as well as a 
`reset-escape-sequence` constant to reset display to the default. 

Changing the display aspect for a string is a case of concatenating together the 
display aspect escape sequence with the string and then resetting back to the 
default using the reset escape sequence. 

For example, to construct a bold string:

```clojure
(str antsy/bold-escape-sequence "Hello!" antsy/reset-escape-sequence)
; => "[1mHello![0m"
```

or to construct a string with a red background:

```clojure
(str antsy/red-bg-escape-sequence "Hello!" antsy/reset-escape-sequence)
; => "[41mHello![0m"
```

or to construct a string with a blue foreground:

```clojure
(str antsy/blue-fg-escape-sequence "Hello!" antsy/reset-escape-sequence)
; => "[34mHello![0m"
```

Escape sequences can be combined as follows:

```clojure
(str 
  antsy/red-bg-escape-sequence 
  antsy/blue-fg-escape-sequence
  antsy/bold-escape-sequence 
  "Hello!" 
  antsy/reset-escape-sequence)
; => "[34mHello![0m"
```

## Using display aspect functions

To simplify applying and resetting display aspects, functions are also provided
for each display aspect with the name of the aspect which wrap the provided 
text in the relevant escape sequences and reset at the end of the text.

For example, to construct a bold string:

```clojure
(antsy/bold "Hello!")
; => "[1mHello![0m"
```

Many such functions can be applied as follows:

```clojure
(antsy/bold (antsy/blue-fg "Hello!"))
; => "[1m[34mHello![0m[0m"
```

## Using the render function

To simplify applying many display aspects to text, the `render` function allows
a variable number of display aspect names to be provided:

```clojure
(antsy/render "Hello!" :bold :red-bg :blue-fg)
; => "[1m[41m[34mHello![0m"
```

The `render` function is also aliased as `->` since in effect it threads the
text through each of the provided display aspects left to right:

```clojure
(antsy/-> "Hello!" :bold :red-bg :blue-fg)
; => "[1m[41m[34mHello![0m"
```

Details of all supported display aspects can be found in
[Supported Display Aspects](supported-display-aspects.html).