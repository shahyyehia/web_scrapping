package main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsonRun {
    public static void main(String[] args) throws IOException {
        Document doc= Jsoup.connect("https://www.imdb.com/chart/toptv").timeout(6000).get();
        Elements body = doc.select("tbody.lister-list");
        System.out.print("Top ");
        System.out.print(body.select("tr").size());
        System.out.println(" films");
        int counter=1;
        for (Element e : body.select("tr"))
        {
            System.out.print(counter);
            System.out.print("- ");
            String title = e.select("td.titleColumn a").text();
            System.out.println(title);
            System.out.print("Rating: ");
            String rating = e.select("td.ratingColumn strong").text();
            System.out.println(rating);
            counter++;
        }

    }

}
