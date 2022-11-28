package Task1;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class ApiHandler {

    public void CreateAlert(JSONObject json) throws UnirestException {
        Unirest.setHttpClient(org.apache.http.impl.client.HttpClients.custom()
                .disableRedirectHandling()
                .build());
        HttpResponse<String> response = Unirest.post("https://api.marketalertum.com/Alert")
                .header("Content-Type", "application/json")
                .body(json)
                .asString();

        System.out.println(response.getBody());
    }

    public void DeleteAlerts() throws UnirestException {
        HttpResponse<String> response = Unirest.delete("https://api.marketalertum.com/Alert?userId=fb5ff355-6c1e-4abc-ae0c-7cea88f49a08")
                .asString();
        System.out.println(response.getBody());
    }

    public JSONObject CreateJsonObject(String title, String description, String image, String url, int price) throws UnirestException {
        JSONObject json = new JSONObject();
        json.put("alertType", 6);
        json.put("heading", title);
        json.put("description", description);
        json.put("url", url);
        json.put("imageURL", image);
        json.put("postedBy", "fb5ff355-6c1e-4abc-ae0c-7cea88f49a08");
        json.put("priceInCents", price);

        return json;
    }

}
