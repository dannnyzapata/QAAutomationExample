package controller;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class endpointController {

    public endpointController (){

    }
    public int getsResponseWebsite (){
        int responseApi = 0;
        responseApi = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1").getStatusCode();
        return responseApi;
    }

    public String getsResponseAsString (){
        String responseAsString;
        Response response = RestAssured.given().when().get("https://jsonplaceholder.typicode.com/posts/1");
        responseAsString = response.asString();
        return responseAsString;
    }

    public boolean verifyResponseIsCorrect (String responseApi, int userId, int id) throws ParseException {
        boolean responseIsCorrect = false;
        JSONParser parser = new JSONParser();
        JSONObject bodyAsJson =  (JSONObject) parser.parse(responseApi);
        int jsonUserId = Integer.parseInt(bodyAsJson.get("userId").toString());
        int jsonId = Integer.parseInt(bodyAsJson.get("id").toString());
        String jsonTitle = bodyAsJson.get("title").toString();
        if (userId == jsonUserId && id == jsonId && !jsonTitle.isEmpty()){
            responseIsCorrect = true;
        }

        return responseIsCorrect;
    }


}
