import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Parser {
    private final String url;

    public Parser() {
        url = "https://gogoanime.llc";
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Parser{" +
                "url='" + url + '\'' +
                '}';
    }

    /**
     * Find and return all search result data for
     * specified title
     *
     * @param title the title to be searched
     * @return the search results
     */
    public String searchAnime(String title) {
        String resultList = null;

        try {
            Document doc = Jsoup.connect("https://gogoanime.llc/search.html?keyword=" + title).get();

            Elements results = doc.select("ul.items");

            resultList = results.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    /**
     * Find and return the video url for specified episode
     *
     * @param title the title to be searched, must be valid
     * @param episodeNumber the specific episode of title, must be valid
     * @return url to video
     */
    public String getEpisode(String title, String episodeNumber) {
        String iframeSrc = null;

        try {
            Document doc = Jsoup.connect("https://gogoanime.llc/" + formatVideoTitle(title) + "-episode-" + episodeNumber).get();

            Element iframe = doc.select("iframe").first();

            if (iframe != null) {
                iframeSrc = "https:" + iframe.attr("src");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return iframeSrc;
    }

    /**
     * Translates the title into url format
     * Inserts '-' characters over spaces
     *
     * @param title the anime title
     * @return anime title in url accepted format
     */
    private String formatVideoTitle(String title) {
        return title.replace(" ", "-");
    }
}
