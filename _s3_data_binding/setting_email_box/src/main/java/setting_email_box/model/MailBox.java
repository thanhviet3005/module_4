package setting_email_box.model;

public class MailBox {
    private String language;
    private int pageSize;
    private boolean spamFilter;
    private String signature;

    public MailBox() {
    }

    public MailBox(String language, int pageSize, boolean spamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public boolean getSpamFilter() {
        return spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
