import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {

    public static void main(String[] args){
        // componente JFrame
        JFrame meuJFrame = new JFrame("Teste - Java Swing");
        meuJFrame.setSize(900,900);

        // componente JPanel
        JPanel meuJPanel = new JPanel();
        meuJPanel.setSize(900, 900);

        // usamos este diseño para centrar los componentes de JPanel
        meuJPanel.setLayout(new GridBagLayout());

        // componente JTextField
        JLabel meuJLabel = new JLabel();
        meuJLabel.setText("Insira aqui seu nome: ");

        // componente JTextArea
        JTextArea meuJTextArea = new JTextArea(1,20);

        // conecta los componentes JLabel y JTextField en JPanel
        meuJPanel.add(meuJLabel);
        meuJPanel.add(meuJTextArea);

        // conectar Jpanel a JFrame
        meuJFrame.add(meuJPanel);

        // hacer visible JFrame
        meuJFrame.setVisible(true);
    }
}