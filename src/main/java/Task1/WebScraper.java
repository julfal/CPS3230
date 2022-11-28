package Task1;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;

public class WebScraper {

    WebDriver driver;
    ApiHandler rest = new ApiHandler();
    List<String> titles = new ArrayList<>();
    List<String> descriptions = new ArrayList<>();
    List<String> images = new ArrayList<>();
    List<String> links = new ArrayList<>();
    List<Integer> prices = new ArrayList<>();

    public void teardown() {
        driver.close();
    }

    public WebElement DriverSetup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/julfa/webtesting/chromedriver.exe ");
        driver = new ChromeDriver();

        driver.get("https://www.scanmalta.com/shop/catalogsearch/result/?q=laptop");

        return driver.findElement(By.cssSelector(".products.wrapper.product-list-style-04.grid.products-grid"));
    }
    public String gettingData() {

        WebElement elements = DriverSetup();

        // Title
        List<WebElement> titleList = getTitles(elements);
        titleList.forEach(title -> titles.add(title.getText()));
        if (titlesCheck(titles) != "pass"){
            return titlesCheck(titles);
        }

        // Description
        List<WebElement> descList = getDescriptions(elements);
        descList.forEach(desc -> descriptions.add(desc.getText()));
        if (descriptionCheck(descriptions) != "pass"){
            return descriptionCheck(descriptions);
        }

        //Image
        List<WebElement> imageSegments = getImages(elements);
        for (int i = 0; i <= 4; i++){
            images.add(imageSegments .get(i).getAttribute("src"));
        }
        if (imagesCheck(images) != "pass"){
            return imagesCheck(images);
        }

        //link
        List<WebElement> linkSegments = getLinks(elements);
        for (int i = 0; i <= 4; i++){
            links.add(linkSegments.get(i).getAttribute("href"));
        }
        if (linksCheck(links) != "pass"){
            return linksCheck(links);
        }

        //price
        List<WebElement> priceList = getPrices(elements);
        priceList.forEach(price -> prices.add(adjustingPrice(price.getText())));
        if (pricesCheck(prices) != "pass"){
            return pricesCheck(prices);
        }

        return "Passed";

    }

    public void sendingData() throws UnirestException {
        for(int i = 0; i<=4; i++) {
            rest.CreateAlert(rest.CreateJsonObject(titles.get(i), descriptions.get(i), images.get(i), links.get(i), prices.get(i)));
        }
    };

    public List<WebElement> getTitles(WebElement elements) {
        return elements.findElements(By.xpath("(//a[@class='product-item-link'])[position() < 6]"));
    }

    public List<WebElement> getDescriptions(WebElement elements) {
        return elements.findElements(By.xpath("(//span[@class='value'])[position() < 6]"));
    }

    public List<WebElement> getImages(WebElement elements) {
        return elements.findElements(By.cssSelector(".product-image-photo.main-img"));
    }

    public List<WebElement> getLinks(WebElement elements) {
        return elements.findElements(By.cssSelector(".product.photo.product-item-photo"));
    }

    public List<WebElement> getPrices(WebElement elements) {
        return elements.findElements(By.xpath("(//span[@class='special-price'])[position() < 6]"));
    }

    public int adjustingPrice (String word){
        String intString = "";
        if (word.equals("")){
            return 0;
        }
        else {
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                if (Character.isDigit(character)) {
                    intString = addCharToString(intString, character);
                }
            }
            return Integer.parseInt(intString);
        }
    }

    public String addCharToString(String word, char letter) {
        return word + letter;
    }

    public String titlesCheck(List<String> titleList) {
        if (titleList.size() == 0){
            return "No Titles were found";
        }
        if (titleList.size() != 5){
            return "There is not exactly 5 Titles";
        }
        return "pass";
    }

    public String descriptionCheck (List<String> descList) {
        if (descList.size() == 0){
            return "No Descriptions were found";
        }
        if (descList.size() != 5){
            return "There is not exactly 5 Descriptions";
        }
        return "pass";
    }

    public String imagesCheck(List<String> imageList) {
        if (imageList.size() == 0){
            return "No images were found";
        }
        if (imageList.size() != 5){
            return "There is not exactly 5 Images";
        }
        return "pass";
    }

    public String linksCheck(List<String> linkList) {
        if (linkList.size() == 0){
            return "No links were found";
        }
        if (linkList.size() != 5){
            return "There is not exactly 5 Links";
        }
        return "pass";
    }

    public String pricesCheck(List<Integer> priceList) {
        if (priceList.size() == 0){
            return "No prices were found";
        }
        if (priceList.size() != 5){
            return "There is not exactly 5 Prices";
        }
        return "pass";
    }

}

