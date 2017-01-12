import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Atleta {



    private long id;
    private String nombre;
    private String apellidos;


    private String nacionalidad;

    //private Set<Medalla> medallas = new HashSet<>();
    public Atleta() {

    }

    public Atleta(String nombre, String apellidos, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;

        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +

                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }

    //public Set<Medalla> getMedallas() {
        //return medallas;
    //}

    //public void setMedallas(Set<Medalla> medallas) {
       // this.medallas = medallas;
    //}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }



    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
