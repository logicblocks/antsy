# antsy

[![Clojars Project](https://img.shields.io/clojars/v/io.logicblocks/antsy.svg)](https://clojars.org/io.logicblocks/antsy)
[![Clojars Downloads](https://img.shields.io/clojars/dt/io.logicblocks/antsy.svg)](https://clojars.org/io.logicblocks/antsy)
[![GitHub Contributors](https://img.shields.io/github/contributors-anon/logicblocks/antsy.svg)](https://github.com/logicblocks/antsy/graphs/contributors)

Simple ANSI escape code library.

## Install

Add the following to your `project.clj` file:

```clj
[io.logicblocks/antsy "0.0.15"]
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

## Credits

`antsy` is heavily inspired by [`pretty`](https://github.com/AvisoNovate/pretty)
and [`clansi`](https://github.com/ams-clj/clansi).

## License

Copyright &copy; 2019 LogicBlocks Maintainers

Distributed under the terms of the
[MIT License](http://opensource.org/licenses/MIT).
