import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class Parsing {
    private Document document;
    private static Elements elements;
    private static ArrayList<String> linkList = new ArrayList<>();


    private Parsing(){
        try {
            document = Jsoup.connect("https://www.kufar.by/listings").userAgent("Chrome/81.0.4044.138").referrer("http://www.google.com").get();
            elements = document.select("a.kf-sPjH-6085e");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void addDataInArrayList(String url){
        linkList.add(url);
    }

    public static void show(){
        for(String el : linkList){
            System.out.println(el);
        }
    }

    public static void start (){
        new Parsing();
        //elements.forEach(el -> System.out.println(el.attr("href")));
        elements.forEach(el -> addDataInArrayList(el.attr("href")));

    }

}
