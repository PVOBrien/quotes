package quotes;

import java.util.ArrayList;

public class ForismaticQuote extends Quote {

  String quoteAuthor;
  String quoteText;

  public ForismaticQuote(ArrayList<String> tags, String author, String likes, String text) {
    super(tags, author, likes, text);
    this.quoteAuthor = author;
    this.quoteText = text;
  }

  public String toString() {
    return String.format("Here's the Author: %s\nHere's the Quote: %s", quoteAuthor, quoteText);
  }
}
