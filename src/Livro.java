import java.time.LocalDate;
import java.util.ArrayList;

public class Livro extends Exemplar {
    private Editora editora;
    private ArrayList<Autor> listaAutores;
    private int temprestimo = 7;
    public Livro(int classind, String titulo, Editora editora, ArrayList<Autor> listaAutores, int temprestimo) {
        super(classind, titulo);
        this.editora = editora;
        this.listaAutores = listaAutores;
        this.temprestimo = temprestimo;
    }
    public ArrayList<Autor> getAutores(){
        return listaAutores;
    }
    public Editora getEditora(){
        return editora;
    }
    public int getTemprestimo(){
        return temprestimo;
    }
    public void setDevolucao() {
        devolucao = LocalDate.now().plusDays(this.temprestimo);
    }
}
