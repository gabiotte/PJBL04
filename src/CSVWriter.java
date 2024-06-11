import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
    public static void writeAutoresToCSV(String filePath, List<Autor> autores) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Nome,Sobrenome\n");  // Cabeçalho do CSV
            for (Autor autor : autores) {
                writer.append(autor.toString()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeClientesToCSV(String filePath, ArrayList<Cliente> clientes) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("Nome,CPF,Número,Email,Data de Nascimento\n");  // Cabeçalho do CSV
            for (Cliente cliente : clientes) {
                writer.append(cliente.toString()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
