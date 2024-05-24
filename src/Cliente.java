import java.time.LocalDate;

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
}
