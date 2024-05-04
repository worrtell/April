package Addreses;

public class Addres {
    private String id;
    private String fullpath;

    Addres(String id, String fullpath) {
        this.id = id;
        this.fullpath = fullpath;
    }

    public String getId() {
        return id;
    }

    public String getFullpath() {
        return fullpath;
    }

    public void setFullpath(String fullpath) {
        this.fullpath = fullpath;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return id + " " + fullpath;
    }
}

