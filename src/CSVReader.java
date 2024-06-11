import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static ArrayList<Cliente> readClienteFromCSV(String filePath) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Ignora o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Cliente cliente = new Cliente(values[0], values[1], values[2], values[3], LocalDate.parse(values[4]));
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
