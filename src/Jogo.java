import java.time.LocalDate;

public class Jogo extends Exemplar {
    private Marca marca;
    private int temprestimo = 5;

    public Jogo(Marca marca, int classind, String titulo) {
        super(classind, titulo);
        this.marca = marca;
    }

    public Marca getMarca(){
        return marca;
    }
    public int getTemprestimo(){
        return temprestimo;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public void extenderDevolucao() {
        devolucao = LocalDate.now().plusDays(this.temprestimo);
    }
    public void emprestar() {
        super.emprestar();
        extenderDevolucao();
    }

    public String toString() {
        return classind + "," + titulo + "," + devolucao + "," + status + "," + marca + "," + temprestimo;
    }
}
