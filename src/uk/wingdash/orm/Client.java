package uk.wingdash.orm;

public class Client {

    private int ID;
    private String LOCALNAME;
    private int IP;

    public Client(int ID, String LOCALNAME, int IP) {
        this.ID = ID;
        this.LOCALNAME = LOCALNAME;
        this.IP = IP;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLOCALNAME() {
        return LOCALNAME;
    }

    public void setLOCALNAME(String LOCALNAME) {
        this.LOCALNAME = LOCALNAME;
    }

    public int getIP() {
        return IP;
    }

    public void setIP(int IP) {
        this.IP = IP;
    }
}
