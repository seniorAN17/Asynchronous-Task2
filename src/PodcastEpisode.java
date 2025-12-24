public class PodcastEpisode extends ContentItem implements Downloadable {
    private String hostName;
    private int episodeNumber;

    public PodcastEpisode(String title, int publishYear, double baseLicenseFee, String hostName, int episodeNumber) {
        super(title, publishYear, baseLicenseFee);
        this.hostName = hostName;
        this.episodeNumber = episodeNumber;
    }

    @Override
    public void download() {
        System.out.println("Downloading podcast hosted by " + hostName + "...");
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 10;
    }

    @Override
    public double getLicenseCost(int currentYear) {
        int age = currentYear - publishYear;
        // Podcasts depreciate faster
        if (age <= 1) {
            return baseLicenseFee;
        } else if (age <= 2) {
            return baseLicenseFee * 0.8;
        } else {
            return baseLicenseFee * 0.5;
        }
    }

    public String getHostName() {
        return hostName;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    @Override
    public String toString() {
        return "PodcastEpisode{title='" + title + "', publishYear=" + publishYear + 
               ", host='" + hostName + "', episode=" + episodeNumber + "}";
    }
}
