public class VideoLecture extends ContentItem implements Downloadable {
    private String quality;
    private int durationMinutes;

    public VideoLecture(String title, int publishYear, double baseLicenseFee, String quality, int durationMinutes) {
        super(title, publishYear, baseLicenseFee);
        this.quality = quality;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void download() {
        System.out.println("Downloading video in " + quality + "...");
    }

    @Override
    public int getMaxDownloadsPerDay() {
        return 3;
    }

    @Override
    public double getLicenseCost(int currentYear) {
        int age = currentYear - publishYear;

        if (age <= 1) {
            return baseLicenseFee * 1.5;
        } else if (age <= 3) {
            return baseLicenseFee * 1.2;
        } else {
            return baseLicenseFee;
        }
    }

    public String getQuality() {
        return quality;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public String toString() {
        return "VideoLecture{title='" + title + "', publishYear=" + publishYear + 
               ", quality='" + quality + "', duration=" + durationMinutes + "min}";
    }
}
