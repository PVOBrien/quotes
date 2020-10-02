/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.* ;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuotesFinder {

    public static void main(String[] args) throws IOException {
        displayQuote();
    }

    public static void displayQuote() throws IOException {
        String backupQuote = "";

        try {
            QuotesFinder quotesFinder = new QuotesFinder(); // creates new Quotesfinder
            List<Quote> quotesList = quotesFinder.createQuoteArray(); // spools up the quoteslist
            backupQuote = randomQuoteProvider(quotesList);
            String firstStep = quotesFinder.returnQuoteFromApi();

            ForismaticQuote quoteToAdd = quotesFinder.singleQuoteOut(firstStep); // get the object
            quoteToAdd.normalizeQuote(quoteToAdd.quoteAuthor, quoteToAdd.quoteText); // make it a more full quote with additional key value pairs filled in.

            quotesList.add(quoteToAdd); // add it to the quoteslist.

            writeItOut("src/main/resources/recentquotes.json", quotesList); // save it back to the file.

        } catch (IOException e) {
              System.out.println("Here's the backup quote " + backupQuote);
              throw e;
        }
    }

    public String returnQuoteFromApi() throws IOException {
        URL url = new URL("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        return input.readLine();
    }

    public ForismaticQuote singleQuoteOut(String jsonString) {
        Gson quote = new Gson();
        return quote.fromJson(jsonString, ForismaticQuote.class);
    }

    public List<Quote> createQuoteArray() throws FileNotFoundException {
        Gson quotes = new Gson();
        FileReader quotesFile = new FileReader("src/main/resources/recentquotes.json");
        Quote[] newList = quotes.fromJson(quotesFile, Quote[].class);
        return new ArrayList<>(Arrays.asList(newList));
    }

    public static String randomQuoteProvider(List<Quote> toRead) {
        int randomQuoteNumber = random(toRead.size());
        String finalQuote = String.format("\"%s\" was said by the author %s.", toRead.get(randomQuoteNumber).text, toRead.get(randomQuoteNumber).author);
        return finalQuote;
    }

    private static int random(int sizeOfRandom){
        return (int) (Math.random() * sizeOfRandom);
    }

    private static void recreateJsonFile(List<Quote> fileToJson) throws IOException {
        Gson gson = new Gson();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter((new FileOutputStream("src/main/resources/recentquotes.json")), "UTF8")); // Cp1252 StandardCharsets.UTF_8
        writer.write(gson.toJson(fileToJson));
    }

    public static void writeItOut(String filepath, List<Quote> allQuotes) throws IOException {
        File jsonFile = new File(filepath);
        jsonFile.createNewFile();
        FileWriter jsonWriter = new FileWriter(filepath);
        Gson gson = new Gson();
        gson.toJson(allQuotes, jsonWriter);
        jsonWriter.close();
    }
}
