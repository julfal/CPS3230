package Task1;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws UnirestException, InterruptedException {


        System.out.println("Press 1 to add 5 alerts");
        System.out.println("Press 2 to delete alerts");

        int choice = menu();

        if (choice == 1) {
            WebScraper webScraper = new WebScraper();
            webScraper.gettingData();
            webScraper.sendingData();
            webScraper.teardown();
        }
        else if (choice == 2) {
            ApiHandler rest = new ApiHandler();
            rest.DeleteAlerts();
        }
        else {
            System.out.println("The option you have inputted is invalid");
        }
    }

    static int menu() {
        Scanner s = new Scanner(System.in);
        System.out.print("choice: ");
        int choice = s.nextInt();
        return choice;
    }


}



