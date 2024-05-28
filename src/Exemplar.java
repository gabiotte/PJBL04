import java.util.Date;
import java.time.LocalDate;

public abstract class Exemplar {
    protected int classind;
    protected String titulo;
    protected LocalDate devolucao;
    protected  boolean status;
    public Exemplar(int classind, String titulo) {
        this.classind = classind;
        this.titulo = titulo;
        this.devolucao = null;
    }
    public int getClassind() {
        return classind;
    }
    public String getTitulo() {
        return titulo;
    }
    public LocalDate getDevolucao() {
        return devolucao;
    }
    public abstract void setDevolucao();

}
