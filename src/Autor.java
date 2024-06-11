public class Autor {
    private String nome;
    private String sobrenome;

    public String getNome(){
        return nome + ' ' + sobrenome;
    }
    public String toString() {
        return nome + "," + sobrenome;
    }
}
