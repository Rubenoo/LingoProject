# Startproject for Workshop
This project is part of the Backend Programming (VKBEP) course of 
HBO-ICT, Software Development of the Hogeschool Utrecht.

## Objectives
* Get a feel for [pair programming](https://en.wikipedia.org/wiki/Pair_programming) 
and [Test-Driven Development](https://en.wikipedia.org/wiki/Test-driven_development)
* Illustrate how to realize a flexible, layered architecture
* Illustrate different test types and test scopes

## Steps
1. Explain general project structure, planned architecture and process
2. Scaffold project structure by making the necessary packages
3. Implement a file-to-file word importer for use with the Lingo Trainer assignment
   according to Inside-Out TDD (start with the domain layer, end with the data and presentation layers)
4. Add integration tests
5. (Test and implement web API for getting a word)
6. (Switch out the file target for a database target)

## Test-Driven Development
We will be working according to a typical Test-Driven workflow.
Tests are the driver for our development. We start from examples
and base our implementation code on those examples.

When working we will adhere to the following schedule as much as possible:
1. *Red*: Write a test and watch it fail
2. *Green*: Write the simplest implementation that works
3. *Refactor*: Refactor the test and the solution

We will keep an eye on the SOLID and FIRST(T) principles while
programming.

## Pair programming
The plan is the work according to pair programming. In pair programming,
we have two roles:
1. A *driver*: this is the person at the keyboard, mostly concerned with realizing ideas as code
2. A *navigator*: this is the person who keeps a critical eye on the written code, 
   both in detail and in a broader sense (requirements, architecture, structure; SOLID / FIRSTT)
   
After each 10 minutes the driver and navigator switch roles.

Mob programming (or: ensemble programming) is pair programming with a larger group.
Often, this means the group as a whole is navigating, while one person is typing.

## Business rules for the word importer
We want to import words that confirm to the following rules:

1. The word exists only of 5, 6 or 7 letters
2. The word does not contain a capital letter (lower-case only)
3. The word does not contain any symbols other than letters
