public class ParserMain {
    public static void main(String[] args) {
        Parser p = new Parser();

        // test for parser methods
        System.out.println(p.searchAnime("86"));
        System.out.println(p.getEpisode("Vinland saga season 2", "1"));
    }
}
