import java.time.LocalDate;
import java.util.ArrayList;

public class Livro extends Exemplar {
    private Editora editora;
    private Autor autor;
    private int temprestimo = 7;
    public Livro(int classind, String titulo, Editora editora, Autor autor, Long codigo) {
        super(codigo,classind, titulo);
        this.editora = editora;
        this.autor = autor;
    }
    public Autor getAutor(){
        return autor;
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
    public void setListaAutores(Autor autor) {
        this.autor = autor;
    }
    public void extenderDevolucao() {
        devolucao = LocalDate.now().plusDays(this.temprestimo);
    }
    public void emprestar() {
        super.emprestar();
        extenderDevolucao();
    }

    public String[] toCSV() {
        StringBuilder autores = new StringBuilder();
        String[] StrEditora = editora.toCSV();
        return new String[]{String.valueOf(codigo), String.valueOf(classind), titulo, devolucao == null ? "" : devolucao.toString(), String.valueOf(status), StrEditora[0], autor.toString(), String.valueOf(temprestimo)};
    }
}
