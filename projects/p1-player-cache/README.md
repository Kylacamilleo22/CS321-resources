# Project 1: Player Cache

* Author: Kyla Camille Ocampo
* Class: CS321 Section #4001
* Semester: Spring 2023

## Overview

The program generates a player object from Player class and PlayerGenerator 
class that is serialized, the Cache class is used to store the player objects, 
then the CacheTest class reads and deserialized the file. It displays the outputs
at the end.


## Reflection

At first, I wasn't exactly sure what the CacheTest is supposed to do, 
specifically on using the command line arguments. I didn't figure out 
how to get the inputs from the command line, so that mostly threw me off
and got myself even confused and end up misunderstanding the project. 
As for the Cache class, the issues that I faced were the getObject and
addObject methods, I had to make sure it was working that it's supposed to.
Figuring out the toString method also took a bit of time, I had to make sure
that the numHits, numRefs, and numHitRatio were in the correct format. 
Another problem that I encountered was running the run-tests.sh. I figured out
the problem by reaching out to the professor. It specifically wanted the exact 
string outputs to be the same as the tests. 

I enjoyed working with the Cache class the most. As for the CacheTest class,
I think I started to understand what to do when I figured out how to get the
inputs from the command line, so it went well from there. I found the guidelines
to be a bit difficult to follow, I know this is intentional and prepares us for future
careers, but it took me a quite a while to figure out.

## Compiling and Using

To compile, execute the following command in the main project directory:
```
$ javac *.java
or 
$ javac Cache.java
$ javac CacheTest.java
$ javac Player.java
$ javac PlayerGenerator.java
```

Run the compiled class with the command:
```
$ java PlayerGenerator <number-of-players> <standard-deviation> <debug-level> [<seed>]
$ java CacheTest.java <cache-size> <serialized-data-filename>
```

To use the run-tests.sh:
```
$ run-tests.sh
```

## Results 

We were asked to keep track of the number of hits, references, and hit ratios,
as well as the elapsed time in milisseconds. We output those in the toString methods, 
results will vary depending on the cache size and serialized data. Using the 
run-tests.sh will also generate different outputs.

## Sources used

Tutoring Center and instructor's help.

## Notes

* This README template is using Markdown. Here is some help on using Markdown: 
[markdown cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)


* Markdown can be edited and viewed natively in most IDEs such as Eclipse and VS Code. Just toggle
between the Markdown source and preview tabs.

* To preview your README.md output online, you can copy your file contents to a Markdown editor/previewer
such as [https://stackedit.io/editor](https://stackedit.io/editor).