package hm13002.pdm.fia.ues.sv.consumove;

public class Materia {

    private String codMateria;
    private String nombreMateria;
    private String unidadesVal;

    public Materia(String codMateria, String nombreMateria, String unidadesVal) {
        this.codMateria = codMateria;
        this.nombreMateria = nombreMateria;
        this.unidadesVal = unidadesVal;
    }

    public Materia() {
    }

    public String getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(String codMateria) {
        this.codMateria = codMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getUnidadesVal() {
        return unidadesVal;
    }

    public void setUnidadesVal(String unidadesVal) {
        this.unidadesVal = unidadesVal;
    }

}
