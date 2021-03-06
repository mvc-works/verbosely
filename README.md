
Verbosely!
----

> A macro to print function arguments and result verbosely!

### Usage

[![Clojars Project](https://img.shields.io/clojars/v/mvc-works/verbosely.svg)](https://clojars.org/mvc-works/verbosely)

```clojure
[mvc-works/verbosely "0.1.2"]
```

To require the macro(in ClojureScript):

```clojure
(:require-macros [verbosely.core :refer [verbosely! log!]])
```

###### `verbosely!`

For example you have a function called `f`:

```clojure
(defn f [x y] (+ x y))

(f (+ 44 55) (+ 44 66))
```

Change your code to:

```clojure
(verbosely! f (+ 44 55) (+ 44 66))
```

And you get logs like:

```text
Calling: (f (+ 44 55) (+ 44 66))
...With: 99 110
Returns: 209
```

Now `f` runs verbosely!

###### `log!`

```clojure
=> (log! a (+ 1 2))
(log! a (+ 1 2))
a: 1
(+ 1 2): 3
nil
```

### License

MIT
