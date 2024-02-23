package Controllers;

public class Nave {
    private String fname;
    private String fclase;

    private String fanlansare;

    public Nave(String fname, String fclase, String fanlansare) {
        this.fname = fname;
        this.fclase = fclase;
        this.fanlansare = fanlansare;
    }

    public String getFname() {
        return fname;
    }

    public String getFclase() {
        return fclase;
    }

    public String getFanlansare() {
        return fanlansare;
    }
}
