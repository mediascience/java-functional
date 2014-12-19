Functional Interfaces
=====================

[![Travis-CI Build Status](https://travis-ci.org/mediascience/java-functional.svg)](https://travis-ci.org/mediascience/java-functional)

[![Shippable Build Status](https://api.shippable.com/projects/54937c65d46935d5fbc09d40/badge?branchName=master)](https://app.shippable.com/projects/54937c65d46935d5fbc09d40/builds/latest)

A variety of functional interfaces to augment those
in java.util.function. Features include:

* arity to five
* checked exceptions
* simple currying

## Usage

### Include Dependencies
```xml
<dependency>
    <groupId>com.msiops.footing</groupId>
    <artifactId>footing-functional</artifactId>
    <version>${v.functional}</version>
</dependency>
```
See [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%20%22com.msiops.footing%22%20a%3A%22footing-functional%22) for latest version.


## Versioning

Releases in the 0.x series are the Wild West. Anything can change between
releases--package names, method signatures, behavior, whatever. But if you
like it as it is right now, all the tests pass so just use it at its current
version and have fun.

The next version series will be 1.x. Every release in that series will be
backward compatible with every lower-numbered release in the same series
except possibly in the case of 1) a bug fix or 2) a correction to an
underspecification.

An incompatible change to the interface, behavior, license, or anything else
after the 1.x series is published will result in a new series, such as
2.x.

## Acknowledgements

Media Science International deserves a star on the walk of fame.

## License

Licensed to Media Science International (MSI) under one or more
contributor license agreements. See the NOTICE file distributed with this
work for additional information regarding copyright ownership. MSI
licenses this file to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance with the
License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations
under the License.


