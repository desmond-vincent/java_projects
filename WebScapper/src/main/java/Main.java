import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

void main() {
    String url = "https://webscraper.io/test-sites/e-commerce/allinone";

    try {
        //Connect and fetch the page
        Document document = Jsoup.connect(url).get();

        //Extract the product info from the page
        Elements products = document.select("div.product-wrapper.card-body");

        IO.println("Total products found: " + products.size());

        IO.println("\n     PRODUCTS:     \n");

        for (Element product : products) {

            String name = product.select("a.title").attr("title");

            String price = product.select("span").text();

            String description = product.select("p.description.card-text").text();

            String link = product.select("a.title").attr("href");

            String image = product.select("img.img-fluid.card-img-top.image.img-responsive").attr("src");

            IO.println("Title: " + name);

            IO.println("Price: " + price);

            IO.println("Description: " + description);

            IO.println("Link: " + link);

            IO.println("Image: " + image);

            IO.println("---");
        }

    } catch (IOException e) {
        throw new RuntimeException(e);
    }


}
