import java.time.LocalDate;
import java.util.ArrayList;

public class Livro extends Exemplar {
    private Editora editora;
    private ArrayList<Autor> listaAutores;
    private int temprestimo = 7;
    public Livro(int classind, String titulo, Editora editora, ArrayList<Autor> listaAutores) {
        super(classind, titulo);
        this.editora = editora;
        this.listaAutores = listaAutores;
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

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    public void setListaAutores(ArrayList<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }
    public void extenderDevolucao() {
        devolucao = LocalDate.now().plusDays(this.temprestimo);
    }
    public void emprestar() {
        super.emprestar();
        extenderDevolucao();
    }
}
