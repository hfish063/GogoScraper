public class ParserMain {
    public static void main(String[] args) {
        Parser p = new Parser();

        // test output for parser methods
        System.out.println(p.searchAnime("86"));
        System.out.println(p.getEpisode("86", "1"));
    }
}
