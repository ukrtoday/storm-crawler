[![storm-crawler](http://digitalpebble.com/storm-crawler/img/Logo-small.jpg)](http://digitalpebble.github.io/storm-crawler)
=============

[![Build Status](https://travis-ci.org/DigitalPebble/storm-crawler.svg?branch=master)](https://travis-ci.org/DigitalPebble/storm-crawler)

A collection of resources for building low-latency, scalable web crawlers on [Apache Storm](http://storm.apache.org/) available under [Apache License](http://www.apache.org/licenses/LICENSE-2.0).

## How to use

NOTE: These instructions assume that you have Maven installed.

### As a Maven dependency

You can use the dependencies from Maven Central by adding \: 

```
<dependency>
    <groupId>com.digitalpebble.stormcrawler</groupId>
    <artifactId>storm-crawler-core</artifactId>
    <version>0.8</version>
</dependency>
```

to the POM file of your project. 

### Maven archetype

Alternatively you can also generate a brand new StormCrawler-based project using \: 

`mvn archetype:generate -DarchetypeGroupId=com.digitalpebble.stormcrawler -DarchetypeArtifactId=storm-crawler-archetype -DarchetypeVersion=0.8`

This will not only create a fully formed project containing a POM with the dependency above but also the default resource files, a default CrawlTopology class and a configuration file. You can then compile and run the topology following the instructions below.


### Running in local mode
To get started with storm-crawler, it's recommended that you run the CrawlTopology in local mode.

First, clone the project from github:
 
 ``` sh
 git clone https://github.com/DigitalPebble/storm-crawler
 ```
 
Then :
``` sh
cd core
mvn clean compile exec:java -Dstorm.topology=com.digitalpebble.storm.crawler.CrawlTopology -Dexec.args="-conf crawler-conf.yaml -local"
```
to run the demo CrawlTopology in local mode.

### On a Storm cluster
Alternatively, generate an uberjar:
``` sh
mvn clean package
```

and then submit the topology with `storm jar`:

``` sh
storm jar target/storm-crawler-core-0.9-SNAPSHOT.jar  com.digitalpebble.storm.crawler.CrawlTopology -conf crawler-conf.yaml
```

to run it in distributed mode.

## Getting help

Mailing list : [http://groups.google.com/group/digitalpebble]

Or use the tag [storm-crawler](http://stackoverflow.com/questions/tagged/storm-crawler) on stackoverflow. 

[DigitalPebble Ltd](http://digitalpebble.com) provide commercial support and consulting for Storm-Crawler.

## Thanks

![alt tag](https://www.yourkit.com/images/yklogo.png)

YourKit supports open source projects with its full-featured Java Profiler.
YourKit, LLC is the creator of <a href="https://www.yourkit.com/java/profiler/index.jsp">YourKit Java Profiler</a>
and <a href="https://www.yourkit.com/.net/profiler/index.jsp">YourKit .NET Profiler</a>,
innovative and intelligent tools for profiling Java and .NET applications.
