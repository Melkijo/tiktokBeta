public class Post {
    private String caption;
    private String url;
    private String username;


    public Post(String caption, String url, String username) {
        this.caption = caption;
        this.url = url;
        this.username = username;

    }

    public String getCaption() {
        return caption;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }
}
