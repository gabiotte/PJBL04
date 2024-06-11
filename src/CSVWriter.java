import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    public static void writeClientesToCSV(String filePath, List<Cliente> clientes) {
        try {
            FileWriter writer = new FileWriter(filePath,true);
            for (Cliente cliente : clientes) {
                writer.write(cliente.toString());
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static void writeClientesToCSV(String filePath, List<Cliente> clientes) {
//        try (FileWriter writer = new FileWriter(filePath)) {
//            writer.append("Nome,CPF,Número,Email,Data de Nascimento\n");  // Cabeçalho do CSV
//            for (Cliente cliente : clientes) {
//                writer.append(cliente.toString()).append("\n");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
}
