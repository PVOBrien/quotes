# quotes
Using GSON to parse json.

## Methods
quoteArrayCreator() - hardcoded. Takes in a file in the resource folder of the project, and turns it into an array of quotes. Takes in no arguments/params.

random(int) - takes in an int to know the highest number to be random, and returns that number.

toStringRandomizer(Quote[]) takes in an array of Quote objects, and outputs a random quote by an author.

apiPing() - returns a quote from an api call. Also stores that quote into a json file of other quotes. AND if api call doesn't resolve, it outputs a quote from the JSON file.

## How to run

Run from within intelliJ for test suite.