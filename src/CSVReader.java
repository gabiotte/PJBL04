import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Cliente> readClienteFromCSV(String filePath) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // br.readLine();  // Ignora o cabeçalho
            while ((line = br.readLine()) != null) {
                Cliente cliente = Cliente.fromString(line);
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
