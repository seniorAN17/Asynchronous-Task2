import java.time.Year;
import java.util.ArrayList;

public class ContentDemo {
    public static void main(String[] args) {
        ArrayList<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Java Basics", 2023, 50.0, "1080p", 45));
        items.add(new VideoLecture("Advanced Design Patterns", 2022, 75.0, "4K", 90));

        items.add(new PodcastEpisode("Tech Talk Daily", 2024, 20.0, "John Smith", 42));
        items.add(new PodcastEpisode("Code & Coffee", 2021, 15.0, "Sarah Johnson", 128));

        int currentYear = Year.now().getValue();
        System.out.println("Current Year: " + currentYear);
        System.out.println("=".repeat(80));
        System.out.println();

        for (ContentItem item : items) {
            System.out.println(item.toString() + " | licenseCost=" + 
                             String.format("$%.2f", item.getLicenseCost(currentYear)));

            if (item instanceof Downloadable) {
                Downloadable downloadable = (Downloadable) item;
                downloadable.download();
                System.out.println("Max downloads per day: " + downloadable.getMaxDownloadsPerDay());
            }
            System.out.println();
        }
    }
}
