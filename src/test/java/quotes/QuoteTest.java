/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class QuoteTest {

  @Test public void functionalityTestOne() throws FileNotFoundException {
    QuotesFinder heresThing  = new QuotesFinder();
    List<Quote> thingToTest = heresThing.createQuoteArray();
  }

  @Test public void functionalityTestTwo() throws FileNotFoundException {
    QuotesFinder heresThing  = new QuotesFinder();
    List<Quote> quoteArray = heresThing.createQuoteArray();
    String thingToTest = QuotesFinder.randomQuoteProvider(heresThing.createQuoteArray());
  }

  @Test public void apiPingTest() throws IOException {
    QuotesFinder newQuote = new QuotesFinder();
    String theReturn = (newQuote.returnQuoteFromApi());
    assertEquals("This is the first character.", '{', theReturn.charAt(0));
  }

//  @Test public void quoteObjCreatorTest() throws IOException { // I need to strengthen tests. Would like help setting up this on terminal.
//    QuotesFinder testQuote = new QuotesFinder();
//    String theQuote = testQuote.returnQuoteFromApi();
//    Quote formedQuote = testQuote.forismaticQuoteCreator(theQuote);
//  }

//  @Test public void saveTheQuote() throws IOException {
//    QuotesFinder testQuote = new QuotesFinder();
////    String theQuote = testQuote.apiPing();
//    asser quoteFromCommandLine();
//  }
}
