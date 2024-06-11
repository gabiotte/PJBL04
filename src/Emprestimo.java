import java.time.LocalDate;
import java.util.ArrayList;
import java.time.temporal.ChronoUnit;


public class Emprestimo {
    private Cliente cliente;
    private ArrayList<Exemplar> exemplares;
    private LocalDate data = LocalDate.now();
    private float multa = 0;
    public Emprestimo(Cliente cliente, ArrayList<Exemplar> exemplares) {
        this.cliente = cliente;
        this.exemplares = exemplares;
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

    public void calcularMulta() {
        for (Exemplar exemplar:exemplares) {
            if (exemplar.devolucao != null) {
                if (exemplar.devolucao.isBefore(LocalDate.now())) {
                    multa = ChronoUnit.DAYS.between(LocalDate.now(), exemplar.devolucao) * 2;
                    continue;
                }
            }
            multa = 0;
        }
    }

    public String toString() {
        return cliente + "," + exemplares + "," + data + "," + multa;
    }

}
