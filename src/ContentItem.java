public abstract class ContentItem {
    protected String title;
    protected int publishYear;
    protected double baseLicenseFee;

    public ContentItem(String title, int publishYear, double baseLicenseFee) {
        this.title = title;
        this.publishYear = publishYear;
        this.baseLicenseFee = baseLicenseFee;
    }

    public abstract double getLicenseCost(int currentYear);

    public String getTitle() {
        return title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public double getBaseLicenseFee() {
        return baseLicenseFee;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{title='" + title + "', publishYear=" + publishYear + "}";
    }
}
