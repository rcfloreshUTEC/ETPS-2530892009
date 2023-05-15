package sv.edu.utec.tareainvestigacion.modelo;

public class Aplicacion {
    private String uID;
    private String App;
    private String Email;
    private String Password;

    @Override
    public String toString() {
        return App;
    }

    public Aplicacion() {
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getApp() {
        return App;
    }

    public void setApp(String app) {
        App = app;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
