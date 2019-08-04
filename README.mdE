# antsy

Simple ANSI escape code library.

## Install

Add the following to your `project.clj` file:

```clj
[io.logicblocks/antsy "0.0.7"]
```

## Documentation

* [API Docs](http://logicblocks.github.io/antsy)

## Usage

```clojure
(require '[antsy.core :as antsy])

(println (str
           antsy/bold-escape-sequence
           antsy/red-bg-escape-sequence 
           "Important!"
           antsy/reset-escape-sequence))

(println (antsy/bold "Important!"))
(println (antsy/red-fg "Something went wrong..."))

(println (antsy/-> "[Incoming Message]" :bold :green-fg))
```

See the [API Docs](http://logicblocks.github.io/antsy) for a more complete
getting started guide.

## License

Copyright &copy; 2019 LogicBlocks Maintainers

Distributed under the terms of the 
[MIT License](http://opensource.org/licenses/MIT).
