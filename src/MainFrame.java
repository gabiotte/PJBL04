import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;

    public MainFrame() {
        // Configurações da janela principal
        setTitle("Menu Principal");
        setSize(400, 300);
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
        cardPanel.add(window1Panel, "Window 1");
        cardPanel.add(window2Panel, "Window 2");
        cardPanel.add(window3Panel, "Window 3");
        cardPanel.add(window4Panel, "Window 4");

        // Configura o layout da janela
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);
    }

    private JPanel createMainMenuPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Abrir Janela 1");
        JButton button2 = new JButton("Abrir Janela 2");
        JButton button3 = new JButton("Abrir Janela 3");
        JButton button4 = new JButton("Abrir Janela 4");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Window 1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Window 2");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Window 3");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Window 4");
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
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bem-vindo à Janela 1", SwingConstants.CENTER);
        JButton backButton = new JButton("Voltar");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Main Menu");
            }
        });

        panel.add(label, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createWindow2Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bem-vindo à Janela 2", SwingConstants.CENTER);
        JButton backButton = new JButton("Voltar");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Main Menu");
            }
        });


        panel.add(label, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createWindow3Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bem-vindo à Janela 3", SwingConstants.CENTER);
        JButton backButton = new JButton("Voltar");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Main Menu");
            }
        });
        panel.add(label, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createWindow4Panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Bem-vindo à Janela 4", SwingConstants.CENTER);
        JButton backButton = new JButton("Voltar");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Main Menu");
            }
        });
        panel.add(label, BorderLayout.CENTER);
        panel.add(backButton, BorderLayout.SOUTH);

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
