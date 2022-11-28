package Task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;


public class WebScraperTests {

    WebScraper scraper;

    @BeforeEach
    public void setup() {
        scraper = new WebScraper();
    }

    @AfterEach
    public void teardown() { scraper = null; }

    @Test
    public void test() {
        //setup

        //Exercise

        //Verify

        //Teardown
    }

    @Test
    public void testgettingDataReturnsNullforNoValues() {

        WebScraper mockWS = mock(WebScraper.class);
        String test = mockWS.gettingData();
        Assertions.assertEquals(null, test);
    }

    @Test
    public void testReturnsNullforGetTitles() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getTitles(null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getTitles(null));
    }

    @Test
    public void testReturnsNullforGetDescs() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getDescriptions (null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getDescriptions (null));
    }

    @Test
    public void testReturnsNullforGetImages() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getImages(null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getImages(null));
    }

    @Test
    public void testReturnsNullforGetLinks() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getLinks(null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getLinks(null));
    }

    @Test
    public void testReturnsNullforGetPrices() {
        WebScraper mockWS = mock(WebScraper.class);
        when(mockWS.getPrices(null)).thenReturn(null);
        Assertions.assertEquals(null , mockWS.getPrices(null));
    }

    @Test
    public void testReturnsEmptyListforGetTitles() {
        //Exercise
        String test = scraper.titlesCheck(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No Titles were found", test);

    }

    @Test
    public void testReturnsListOf5StringsforGetTitles() {
        //Setup
        List<String> list = Arrays.asList("title1","title2","title3","title4","title5");
        //Exercise
        String test = scraper.titlesCheck(list);
        //Verify
        Assertions.assertEquals("pass", test);
    }

    @Test
    public void testReturnsListOf4StringsforGetTitles() {
        //Setup
        List<String> list = Arrays.asList("title1","title2","title3","title4");
        //Exercise
        String test = scraper.titlesCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Titles", test);
    }

    @Test
    public void testReturnsListOf6StringsforGetTitles() {
        //Setup
        List<String> list = Arrays.asList("title1","title2","title3","title4","title6","title7");
        //Exercise
        String test = scraper.titlesCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Titles", test);
    }

    @Test
    public void testReturnsEmptyListforGetDescriptions() {
        //Exercise
        String test = scraper.descriptionCheck(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No Descriptions were found", test);

    }

    @Test
    public void testReturnsListOf5StringsforGetDescriptions() {
        //Setup
        List<String> list = Arrays.asList("desc1","desc2","desc3","desc4","desc5");
        //Exercise
        String test = scraper.descriptionCheck(list);
        //Verify
        Assertions.assertEquals("pass", test);
    }

    @Test
    public void testReturnsListOf4StringsforGetDescriptions() {
        //Setup
        List<String> list = Arrays.asList("desc1","desc2","desc3","desc4");
        //Exercise
        String test = scraper.descriptionCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Descriptions", test);
    }

    @Test
    public void testReturnsListOf6StringsforGetDescriptions() {
        //Setup
        List<String> list = Arrays.asList("desc1","desc2","desc3","desc4","desc5","desc6");
        //Exercise
        String test = scraper.descriptionCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Descriptions", test);
    }

    @Test
    public void testReturnsEmptyListforGetImages() {
        //Exercise
        String test = scraper.imagesCheck(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No images were found", test);

    }

    @Test
    public void testReturnsListOf5StringsforGetImages() {
        //Setup
        List<String> list = Arrays.asList("image1","image2","image3","image4","image5");
        //Exercise
        String test = scraper.imagesCheck(list);
        //Verify
        Assertions.assertEquals("pass", test);
    }

    @Test
    public void testReturnsListOf4StringsforGetImages() {
        //Setup
        List<String> list = Arrays.asList("image1","image2","image3","image4");
        //Exercise
        String test = scraper.imagesCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Images", test);
    }

    @Test
    public void testReturnsListOf6StringsforGetImages() {
        //Setup
        List<String> list = Arrays.asList("image1","image2","image3","image4","image5","image6");
        //Exercise
        String test = scraper.imagesCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Images", test);
    }

    @Test
    public void testReturnsEmptyListforGetLinks() {
        //Exercise
        String test = scraper.linksCheck(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No links were found", test);

    }

    @Test
    public void testReturnsListOf5StringsforGetLinks() {
        //Setup
        List<String> list = Arrays.asList("link1","link2","link3","link4","link5");
        //Exercise
        String test = scraper.linksCheck(list);
        //Verify
        Assertions.assertEquals("pass", test);
    }

    @Test
    public void testReturnsListOf4StringsforforGetLinks() {
        //Setup
        List<String> list = Arrays.asList("link1","link2","link3","link4");
        //Exercise
        String test = scraper.linksCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Links", test);
    }

    @Test
    public void testReturnsListOf6StringsforGetLinks() {
        //Setup
        List<String> list = Arrays.asList("link1","link2","link3","link4","link5","link6");
        //Exercise
        String test = scraper.linksCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Links", test);
    }

    @Test
    public void testReturnsEmptyListforGetPrices() {
        //Exercise
        String test = scraper.pricesCheck(java.util.Collections.emptyList());
        //Verify
        Assertions.assertEquals("No prices were found", test);

    }

    @Test
    public void testReturnsListOf5StringsforGetPrices() {
        //Setup
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //Exercise
        String test = scraper.pricesCheck(list);
        //Verify
        Assertions.assertEquals("pass", test);
    }

    @Test
    public void testReturnsListOf4StringsforGetPrices() {
        //Setup
        List<Integer> list = Arrays.asList(1,2,3,4);
        //Exercise
        String test = scraper.pricesCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Prices", test);
    }

    @Test
    public void testReturnsListOf6StringsforGetPrices() {
        //Setup
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        //Exercise
        String test = scraper.pricesCheck(list);
        //Verify
        Assertions.assertEquals("There is not exactly 5 Prices", test);
    }

    @Test
    public void testAddCharToStringWithString() {
        //setup;
        String word = "dh1368gb";
        char letter = 'z';

        //Exercise
        String test = scraper.addCharToString(word, letter);

        //Verify
        Assertions.assertEquals("dh1368gbz", test);
    }

    @Test
    public void testAddCharToStringWithEmptyString() {
        //setup;
        String string = "";
        char word = 'h';

        //Exercise
        String test = scraper.addCharToString(string, word);

        //Verify
        Assertions.assertEquals("h", test);
    }

    @Test
    public void testadjustingHavingPriceWithExpectedStringType() {
        //setup
        String string = "€20,549.95";

        //Exercise
        int test = scraper.adjustingPrice(string);

        //Verify
        Assertions.assertEquals(2054995, test);
    }

    @Test
    public void testadjustingPriceWithRandomStringType() {
        //setup
        String string = "hdbw9ib289r48r948";

        //Exercise
        int test = scraper.adjustingPrice(string);

        //Verify
        Assertions.assertEquals(928948948, test);
    }

    @Test
    public void testadjustingPriceWithWithIntegerString() {
        //setup
        String string = "1212";

        //Exercise
        int test = scraper.adjustingPrice(string);

        //Verify
        Assertions.assertEquals(1212, test);
    }

    @Test
    public void testadjustingPriceWithWithEmptyString() {
        //setup
        String string = "";

        //Exercise
        int test = scraper.adjustingPrice(string);

        //Verify
        Assertions.assertEquals(0, test);
    }
}
