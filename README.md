# clojart.io

[![Circle CI](https://circleci.com/gh/orchard-labs/clojart.io.png?style=badge)](https://circleci.com/gh/orchard-labs/clojart.io)

An application for making beautiful visualizations of code. Totally
Fucking Orchard.

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

Better yet, run it in http-kit like this:

    lein run

## Compile CSS

    lein garden once

## Tests

Run the tests:

    lein test

## License

Copyright © 2014 Orchard Labs
