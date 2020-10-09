package quotes;

import java.util.ArrayList;

public class ForismaticQuote extends Quote{

  String quoteText;
  String quoteAuthor;

  public ForismaticQuote(ArrayList<String> tags, String author, String likes, String text) {
    super(tags, author, likes, text);
  }

//  public ForismaticQuote(String quoteText, String quoteAuthor) {
//    this.text = quoteText;
//    this.author = quoteAuthor;
//  }

  public void normalizeQuote(String toAuthor, String toQuote){
    this.author = toAuthor;
    this.text = toQuote;
  }

  public String toString() {
    return String.format("Here's the Author: %s\nHere's the Quote: %s", this.quoteAuthor, this.quoteText);
  }
}
