import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cliente {
    private String nome;
    private String CPF;
    private String numero;
    private String email;
    private LocalDate datanascimento;

    public Cliente(String nome, String CPF, String numero, String email, LocalDate datanascimento) {
        this.nome = nome;
        this.CPF = CPF;
        this.numero = numero;
        this.email = email;
        this.datanascimento = datanascimento;
    }
    public String getNome(){
        return nome;
    }
    public String getCPF(){
        return CPF;
    }
    public String getNumero(){
        return numero;
    }
    public String getEmail(){
        return email;
    }
    public LocalDate getDatanascimento(){
        return datanascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDatanascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String toString() {
        return nome + ";" + CPF + ";" + numero + ";" + email + ";" + datanascimento + "\n";
    }
    public static Cliente fromString(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] parts = str.split(";");
        return new Cliente(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                LocalDate.parse(parts[4], formatter)
        );
    }
}
