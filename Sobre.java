import javax.swing.*;

public class Sobre extends JFrame{
    JTextField txt;
    public Sobre() {
        setSize(550,100);
        setVisible(true);
        setLocationRelativeTo(null);
        
        txt = new JTextField("     Trabalho finalizado dia 12/06   |   Autores: Mylenna Rodrigues, Matheus Fernando e Faymerson");
        
        add(txt);
    }
}