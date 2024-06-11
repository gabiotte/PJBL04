public class Marca {
    private String nome;
    public Marca(String nome) {
        this.nome = nome;
    }
    public String toString() {
        return nome;
    }

    public String[] toCSV() {
        return new String[]{nome};
    }

}
