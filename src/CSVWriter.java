import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {
    public static void writeClientesToCSV(String filePath, ArrayList<Cliente> clientes) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("CPF,Nome,Telefone,Email,DataNasc\n");
            for (Cliente cliente : clientes) {
                bw.write(String.join(",", cliente.toCSV()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAutoresToCSV(String filePath, ArrayList<Autor> autores) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Nome\n");
            for (Autor autor : autores) {
                bw.write(String.join(",", autor.toCSV()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeEditorasToCSV(String filePath, ArrayList<Editora> editoras) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Nome\n");
            for (Editora editora : editoras) {
                bw.write(String.join(",", editora.toCSV()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeEmprestimosToCSV(String filePath, ArrayList<Emprestimo> emprestimos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Cliente,Exemplares\n");
            for (Emprestimo emprestimo : emprestimos) {
                bw.write(String.join(",", emprestimo.toCSV()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeJogosToCSV(String filePath, ArrayList<Jogo> jogos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Marca,ClassInd,Título\n");
            for (Jogo jogo : jogos) {
                bw.write(String.join(",", jogo.toCSV()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLivrosToCSV(String filePath, ArrayList<Livro> livros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("ClassInd,Título,Editora,Autor\n");
            for (Livro livro : livros) {
                bw.write(String.join(",", livro.toCSV()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeMarcasToCSV(String filePath, ArrayList<Marca> marcas) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("Nome\n");
            for (Marca marca : marcas) {
                bw.write(String.join(",", marca.toCSV()));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
