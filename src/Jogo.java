import java.time.LocalDate;

public class Jogo extends Exemplar {
    private Marca marca;
    private int temprestimo = 5;

    public Jogo(Marca marca, int classind, String titulo, LocalDate devolucao) {
        super(classind, titulo);
        this.marca = marca;
    }

    public Marca getMarca(){
        return marca;
    }
    public int getTemprestimo(){
        return temprestimo;
    }
    public void setDevolucao() {
        devolucao = LocalDate.now().plusDays(this.temprestimo);
    }
}
