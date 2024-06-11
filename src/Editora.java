public class Editora {
    private String nome;

    public Editora(String nome) {
        this.nome = nome;
    }

    public String[] toCSV() {
        return new String[]{nome};
    }
}
