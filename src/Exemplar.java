import java.time.LocalDate;

public abstract class Exemplar {
    protected int classind;
    protected String titulo;
    protected LocalDate devolucao = null;
    protected boolean status = false;
    public Exemplar(int classind, String titulo) {
        this.classind = classind;
        this.titulo = titulo;
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
    public boolean getStatus() {
        return status;
    }

    public void setClassind(int classind) {
        this.classind = classind;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public abstract void extenderDevolucao();
    public void emprestar() {
        status = true;
    }
    public void devolver() {
        status = false;
        devolucao = null;
    }

    public abstract String[] toCSV();
}
