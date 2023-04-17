import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    private String url;

    public Parser() {
        url = "https://gogoanime.llc/search.html?keyword=86";
    }

    /**
     * Find and return all search result data for
     * specified title
     *
     * @param keyword the title to be searched
     */
    public void searchAnime(String keyword) {
        try {
            Document doc = Jsoup.connect(url).get();

            //Elements result = doc.select("ul.items");
            Elements result = doc.select("ul.items");

            // iterate through elements and grab <a> tags
            // extract title info from tag
            for(Element item : result) {
                Elements title = item.select("p.name");

                System.out.println(title.text());
            }
//            String text = result.text();
//            System.out.println(text);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
