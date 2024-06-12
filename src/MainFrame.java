import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTextField cpfField, exemplarField, titleField, classField, authorField, publisherField, brandField, clientCpfField, clientNameField, clientPhoneField, clientEmailField, clientDobField, loanCodeField;
    private JTextArea exemplarListArea;
    private List<String> exemplarCodes;
    private String clientCPF, selectedType, title, classind, author, publisher, brand, clientName, clientPhone, clientEmail, clientDob, loanCode;

    public MainFrame() {
        // Configurações da janela principal
        setTitle("Menu Principal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa o CardLayout e o painel de cartões
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Cria os painéis
        JPanel mainMenuPanel = createMainMenuPanel();
        JPanel window1Panel = createWindow1Panel();
        JPanel window2Panel = createWindow2Panel();
        JPanel window3Panel = createWindow3Panel();
        JPanel window4Panel = createWindow4Panel();

        // Adiciona os painéis ao cardPanel
        cardPanel.add(mainMenuPanel, "Main Menu");
        cardPanel.add(window1Panel, "Novo Empréstimo");
        cardPanel.add(window2Panel, "Cadastro de Exemplares");
        cardPanel.add(window3Panel, "Cadastro de Clientes");
        cardPanel.add(window4Panel, "Acessar Empréstimos");

        // Configura o layout da janela
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel createMainMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Novo Empréstimo");
        JButton button2 = new JButton("Cadastro de Exemplares");
        JButton button3 = new JButton("Cadastro de Clientes");
        JButton button4 = new JButton("Acessar Empréstimos");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Novo Empréstimo");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Cadastro de Exemplares");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Cadastro de Clientes");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Acessar Empréstimos");
            }
        });

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        return panel;
    }

    private JPanel createWindow1Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JLabel cpfLabel = new JLabel("CPF:");
        cpfField = new JTextField(15);

        JLabel exemplarLabel = new JLabel("Código do Exemplar:");
        exemplarField = new JTextField(15);
        JButton addExemplarButton = new JButton("Adicionar");

        exemplarListArea = new JTextArea(5, 20);
        exemplarListArea.setEditable(false);

        JButton confirmButton = new JButton("Confirmar");
        JButton backButton = new JButton("Voltar");

        exemplarCodes = new ArrayList<>();

        addExemplarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String code = exemplarField.getText();

                if (!code.isEmpty()) {
                    exemplarCodes.add(code);
                    exemplarListArea.append(code + "\n");
                    exemplarField.setText("");
                }
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientCPF = cpfField.getText();

                ArrayList<Emprestimo> emprestimos = CSVReader.readEmprestimoFromCSV("emprestimos.csv");
                ArrayList<Exemplar> exemplares = new ArrayList<>();
                ArrayList<Exemplar> livros = CSVReader.readLivroFromCSV("livros.csv");
                ArrayList<Exemplar> jogos = CSVReader.readJogoFromCSV("jogos.csv");

                for (String codExemplar : exemplarCodes) {
                    for (Exemplar livro : livros) {
                        Long cod = livro.getCodigo();
                        if (cod == Long.parseLong(codExemplar)) {
                            if (!livro.getStatus()) {
                                livro.emprestar();
                                exemplares.add(livro);
                            }
                        }
                    }
                    for(Exemplar jogo : jogos) {
                        Long cod = jogo.getCodigo();
                        if (cod == Long.parseLong(codExemplar)) {
                            if (!jogo.getStatus()) {
                                jogo.emprestar();
                                exemplares.add(jogo);
                            }
                        }
                    }
                }

                ArrayList<Cliente> clientes = CSVReader.readClienteFromCSV("cliente.csv");
                for (Cliente cliente : clientes) {
                    if (Objects.equals(clientCPF, cliente.getCpf())) {
                        Emprestimo emprestimo = new Emprestimo(cliente,exemplares);
                    }
                }

                JOptionPane.showMessageDialog(panel, "Empréstimo registrado com sucesso!");
                cpfField.setText("");
                exemplarField.setText("");
                exemplarListArea.setText("");
                cardLayout.show(cardPanel, "Main Menu");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Main Menu");
            }
        });

        panel.add(cpfLabel);
        panel.add(cpfField);
        panel.add(exemplarLabel);
        panel.add(exemplarField);
        panel.add(addExemplarButton);
        panel.add(new JScrollPane(exemplarListArea));
        panel.add(confirmButton);
        panel.add(backButton);

        return panel;
    }

    private JPanel createWindow2Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 1));

        JRadioButton bookRadioButton = new JRadioButton("Livro");
        JRadioButton gameRadioButton = new JRadioButton("Jogo");
        ButtonGroup group = new ButtonGroup();
        group.add(bookRadioButton);
        group.add(gameRadioButton);

        JLabel titleLabel = new JLabel("Título:");
        titleField = new JTextField(15);

        JLabel classLabel = new JLabel("Classificação Indicativa:");
        classField = new JTextField(15);

        JLabel authorLabel = new JLabel("Autor:");
        authorField = new JTextField(15);
        authorField.setEnabled(false);

        JLabel publisherLabel = new JLabel("Editora:");
        publisherField = new JTextField(15);
        publisherField.setEnabled(false);

        JLabel brandLabel = new JLabel("Marca:");
        brandField = new JTextField(15);
        brandField.setEnabled(false);

        JButton confirmButton = new JButton("OK");
        JButton backButton = new JButton("Voltar");

        bookRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorField.setEnabled(true);
                publisherField.setEnabled(true);
                brandField.setEnabled(false);
                selectedType = "Livro";
            }
        });

        gameRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorField.setEnabled(false);
                publisherField.setEnabled(false);
                brandField.setEnabled(true);
                selectedType = "Jogo";
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                title = titleField.getText();
                classind = classField.getText();

                Long code = new Random().nextLong(10000) + 1;
                if (selectedType.equals("Livro")) {
                    author = authorField.getText();
                    publisher = publisherField.getText();

                    ArrayList<Exemplar> livros = CSVReader.readLivroFromCSV("livros.csv");
                    Editora editora = new Editora(publisher);
                    Autor autor = new Autor(author);
                    Exemplar livro = new Livro(Integer.parseInt(classind),title,editora,autor,code);
                    livros.add(livro);
                    CSVWriter.writeLivrosToCSV("livros.csv", livros);

                } else if (selectedType.equals("Jogo")) {
                    brand = brandField.getText();

                    ArrayList<Exemplar> jogos = CSVReader.readJogoFromCSV("jogos.csv");
                    Marca marca = new Marca(brand);
                    Exemplar jogo = new Jogo(marca,Integer.parseInt(classind),title,code);
                    jogos.add(jogo);
                    CSVWriter.writeJogosToCSV("jogos.csv", jogos);

                }
                JOptionPane.showMessageDialog(panel, "Cadastro realizado!\nCódigo: " + code);
                titleField.setText("");
                classField.setText("");
                authorField.setText("");
                publisherField.setText("");
                brandField.setText("");
                cardLayout.show(cardPanel, "Main Menu");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Main Menu");
            }
        });

        panel.add(bookRadioButton);
        panel.add(gameRadioButton);
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(classLabel);
        panel.add(classField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(publisherLabel);
        panel.add(publisherField);
        panel.add(brandLabel);
        panel.add(brandField);
        panel.add(confirmButton);
        panel.add(backButton);

        return panel;
    }

    private JPanel createWindow3Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(11, 1));

        JLabel cpfLabel = new JLabel("CPF:");
        clientCpfField = new JTextField(15);

        JLabel nameLabel = new JLabel("Nome:");
        clientNameField = new JTextField(15);

        JLabel phoneLabel = new JLabel("Número Celular:");
        clientPhoneField = new JTextField(15);

        JLabel emailLabel = new JLabel("Email:");
        clientEmailField = new JTextField(15);

        JLabel dobLabel = new JLabel("Data de Nascimento:");
        clientDobField = new JTextField(15);

        JButton confirmButton = new JButton("OK");
        JButton backButton = new JButton("Voltar");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clientCPF = clientCpfField.getText();
                clientName = clientNameField.getText();
                clientPhone = clientPhoneField.getText();
                clientEmail = clientEmailField.getText();
                clientDob = clientDobField.getText();

                JOptionPane.showMessageDialog(panel, "Cadastro de cliente realizado com sucesso!");
                clientCpfField.setText("");
                clientNameField.setText("");
                clientPhoneField.setText("");
                clientEmailField.setText("");
                clientDobField.setText("");
                cardLayout.show(cardPanel, "Main Menu");

                ArrayList<Cliente> clientes = CSVReader.readClienteFromCSV("clientes.csv");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                LocalDate clientDobDate = LocalDate.parse(clientDob, formatter);

                clientes.add(new Cliente(clientName, clientCPF, clientPhone, clientEmail, clientDobDate));
                CSVWriter.writeClientesToCSV("clientes.csv", clientes);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Main Menu");
            }
        });

        panel.add(cpfLabel);
        panel.add(clientCpfField);
        panel.add(nameLabel);
        panel.add(clientNameField);
        panel.add(phoneLabel);
        panel.add(clientPhoneField);
        panel.add(emailLabel);
        panel.add(clientEmailField);
        panel.add(dobLabel);
        panel.add(clientDobField);
        panel.add(confirmButton);
        panel.add(backButton);

        return panel;
    }

    private JPanel createWindow4Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        JLabel codeLabel = new JLabel("Código do Exemplar:");
        loanCodeField = new JTextField(15);
        JButton searchButton = new JButton("Buscar Exemplar");
        JButton backButton = new JButton("Voltar");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loanCode = loanCodeField.getText();
                JOptionPane.showMessageDialog(panel, "Exemplar encontrado: " + loanCode);
                loanCodeField.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Main Menu");
            }
        });

        panel.add(codeLabel);
        panel.add(loanCodeField);
        panel.add(searchButton);
        panel.add(backButton);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
