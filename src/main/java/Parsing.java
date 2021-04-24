import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.ArrayList;

public class Parsing {
    private Document document;
    private static Elements elements;
    private static ArrayList<Pojo> date = new ArrayList<>();

    private Parsing(){
        try {
            document = Jsoup.connect("https://www.kufar.by/listings").userAgent("Chrome/81.0.4044.138").referrer("http://www.google.com").get();
            elements = document.select("a.kf-sPjH-6085e");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void addDataInArrayList(){
        elements.forEach(el -> date.add(new Pojo(el.attr("href"))));
    }

    public static void show(){
        if (!date.isEmpty()){
            date.forEach(el -> System.out.println(el.getAdLink()));
            return;
        }
        System.out.println("The list is empty");
    }

    public static void start (){
        new Parsing();
        //elements.forEach(el -> System.out.println(el.attr("href")));
        addDataInArrayList();

    }

}
