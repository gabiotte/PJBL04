import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVReader {
    public static ArrayList<Cliente> readClienteFromCSV(String filePath) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Ignora o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Cliente cliente = new Cliente(values[0], values[1], values[2], values[3], LocalDate.parse(values[4], formatter));
                clientes.add(cliente);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public static ArrayList<Autor> readAutoresFromCSV(String filePath) {
        ArrayList<Autor> autores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Ignora o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Autor autor = new Autor(values[0]);
                autores.add(autor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return autores;
    }


    public static ArrayList<Emprestimo> readEmprestimoFromCSV(String filePath) {
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Ignora o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                String[] listCliente = values[0].split(";");
                Cliente cliente = new Cliente(listCliente[0], listCliente[1], listCliente[2], listCliente[3], LocalDate.parse(listCliente[4], formatter));

                String[] listExemplares = values[1].split(";");
                ArrayList<Exemplar> exemplares = new ArrayList<>();
                // listExemplar[0] - primeiro exemplar
                for (String value : listExemplares) {
                    String[] listParam = line.split(";");
                    if (listParam.length == 4) {
                        // Jogo
                        Marca marca = new Marca(listParam[0]);
                        Exemplar exemplar = new Jogo(marca, Integer.parseInt(listParam[1]), listParam[2], Long.parseLong(listParam[3]));
                        exemplares.add(exemplar);
                    } else {
                        // Livro
                        Autor autor = new Autor(listParam[3]);
                        Editora editora = new Editora(listParam[2]);
                        Exemplar exemplar = new Livro(Integer.parseInt(listParam[0]), listParam[1], editora, autor, Long.parseLong(listParam[4]));
                        exemplares.add(exemplar);
                    }
                    Emprestimo emprestimo = new Emprestimo(cliente, exemplares);
                    emprestimos.add(emprestimo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emprestimos;
    }

    public static ArrayList<Editora> readEditoraFromCSV(String filePath) {
        ArrayList<Editora> editoras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Ignora o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Editora editora = new Editora(values[0]);
                editoras.add(editora);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return editoras;
    }

    public static ArrayList<Marca> readMarcaFromCSV(String filePath) {
        ArrayList<Marca> marcas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Ignora o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Marca marca = new Marca(values[0]);
                marcas.add(marca);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return marcas;
    }

    public static ArrayList<Exemplar> readLivroFromCSV(String filePath) {
        ArrayList<Exemplar> livros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Ignora o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // String[] listEditora = values[2].split(";");
                Editora editora = new Editora(values[2]);

                // String[] listAutor = values[3].split((";"));
                Autor autor = new Autor(values[3]);

                Exemplar livro = new Livro(Integer.parseInt(values[0]), values[1], editora, autor,Long.parseLong(values[4]));
                livros.add(livro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return livros;
    }

    public static ArrayList<Exemplar> readJogoFromCSV(String filePath) {
        ArrayList<Exemplar> jogos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Ignora o cabeçalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                //String[] listMarca = values[0].split(";");
                Marca marca = new Marca(values[0]);

                Exemplar jogo = new Jogo(marca, Integer.parseInt(values[1]), values[2],Long.parseLong(values[3]));
                jogos.add(jogo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jogos;
    }
}










