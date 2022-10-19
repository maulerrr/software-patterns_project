package task1.services.DB;

public class credentials {
    private String url = "jdbc:postgresql://localhost:5432/SDP";
    private String username = "postgres";
    private String password = "1111";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
