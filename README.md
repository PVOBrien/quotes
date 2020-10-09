# quotes
Using GSON to parse json.

## How to run

Via CLI (via linux, as this was working on Linux, but Windows does not play nice):

 - run ./gradlew run --args '<AUTHOR> <AUTHOR (First/Last)>' OR
       ./gradlew run --args '<CONTAINS> <WORD>' OR
       ./gradlew run --args 'web'
    - replace the <> (including the <>) with the suggestion and submit.
    - Doing so will return a quote from:
        - someone with that AUTHOR name from a file of quotes included in the app 
        - a quote that CONTAINS that WORD.
    - The 'web' option will return a quote from an api, and save it to the quotes file.

## Methods
quoteArrayCreator() - Takes in a file in the resource folder of the project, and turns it into an array of quotes. Takes in no arguments/params.

random(int) - takes in an int to know the highest number to be random, and returns that number.

toStringRandomizer(Quote[]) takes in an array of Quote objects, and outputs a random quote by an author.

apiPing() - returns a quote from an api call. Also stores that quote into a json file of other quotes. AND if api call doesn't resolve, it outputs a quote from the JSON file.

## How to run

Run from within intelliJ for test suite.
./gradlew test now runs from a linux setup (but not Windows).
NOTE: running "gradle wrapper" via WSL 2 within the app folder should/might allow the ./gradlew test to run via a Windows setup.

# quotes
Using GSON to parse json.

## Methods

quoteArrayCreator() - hardcoded. Takes in a file in the resource folder of the project, and turns it into an array of quotes. Takes in no arguments/params.

random(int) - takes in an int to know the highest number to be random, and returns that number. This should be a private method.
