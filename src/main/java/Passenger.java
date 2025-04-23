public class Passenger {

    private String title;
    private String fname;
    private String lname;

    public Passenger(String title, String fname, String lname) {

        if(!title.equals("Mr") && !title.equals("Mrs") && !title.equals("Ms")) {

            throw new IllegalArgumentException("Invalid passenger title");

        }

        if(fname == null || fname.length()< 3 ){
            throw new IllegalArgumentException("Invalid passenger First Name");
        }
        this.title = title;
        this.fname = fname;
        this.lname = lname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }
}
