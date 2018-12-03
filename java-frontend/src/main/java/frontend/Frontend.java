package frontend;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.util.Locale;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class Frontend {

  public static void main(String[] args) {
    port(8080);

    staticFiles.location("/static");

    get(
        "/nodejs",
        (req, res) -> {
          System.out.println("Accessing /nodejs");
          HttpResponse<String> name = Unirest.get("http://nodejs-backend").asString();
          return name.getBody();
        });

    get(
        "/groovy",
        (req, res) -> {
          System.out.println("Accessing /groovy");
          HttpResponse<String> name = Unirest.get("http://groovy-backend").asString();
          return name.getBody();
        });
  }
}
