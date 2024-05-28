import java.time.LocalDate;
import java.util.ArrayList;

public class Emprestimo {
    private Cliente cliente;
    private ArrayList<Exemplar> exemplares;
    private LocalDate data;
    private float multa = 0;
    public Emprestimo(Cliente cliente, ArrayList<Exemplar> exemplares, LocalDate data) {
        this.cliente = cliente;
        this.exemplares = exemplares;
        this.data = data;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public ArrayList<Exemplar> getExemplares () {
        return exemplares;
    }
    public LocalDate getData() {
        return data;
    }
    public float getMulta() {
        return multa;
    }
    public void setMulta(float multa) {
        this.multa = multa;
    }
}
