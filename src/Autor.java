public class Autor {
    private String nome;

    public Autor(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return nome;
    }

    public String[] toCSV() {
        return new String[]{nome};
    }
}
