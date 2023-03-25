package sv.edu.utec.ejercicio4guia4;

public class Personas {

    private String PersonaNombre;

    public String getPersonaNombre() {
        return PersonaNombre;
    }

    public void setPersonaNombre(String personaNombre) {
        PersonaNombre = personaNombre;
    }

    private String PersonaEdad;

    public String getPersonaEdad() {
        return PersonaEdad;
    }

    public void setPersonaEdad(String personaEdad) { PersonaEdad = personaEdad;
    }
    private String PersonaDireccion;

    public String getPersonaDireccion() {
        return PersonaDireccion;
    }

    public void setPersonaDireccion(String personaDireccion) {
        PersonaDireccion = personaDireccion;
    }

    public Personas (String personaNombre, String personaEdad, String personaDireccion) {
        this.PersonaNombre=personaNombre;
        this.PersonaEdad=personaEdad;
        this.PersonaDireccion=personaDireccion;
    }
}