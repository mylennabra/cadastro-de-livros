import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Main extends JFrame implements ActionListener{
    
    JComboBox cbAnodePub;
    JButton bConcluir, bSair;
    JLabel lNomeDoLivro, lAutor, lAnodePub, lConcluir;
    JTextField tfNomeDoLivro, tfAutor, tfAnoDePub;

    public Main(){
        //JPanel p = new JPanel();
        setLayout(new FlowLayout()); // Organiza layout 
        setSize(500,500); // Define tamanho do frame
        setVisible(true); // Torna o frame visivel
        setTitle("Livraria dos Sonhos v0.1"); // Definindo título pra janela 
        this.getContentPane().setBackground(Color.white);
        //this.setLayout(null);
        setLocationRelativeTo(null);
        //setResizable(false);
        Container p = getContentPane();


        String[] years = { "", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998" };
        JComboBox<String> cb = new JComboBox<>(years); 
        cb.setMaximumRowCount (6);
        
        
        //cb.setEditable (true);
        
        lNomeDoLivro = new JLabel("Nome do Livro: ");
        lAutor = new JLabel("Autor: ");
        lConcluir = new JLabel("Pronto? ");
        lAnodePub = new JLabel("Ano de Publicacao: ");
        bConcluir = new JButton("Submit");
        bSair = new JButton("Sair");
        tfNomeDoLivro = new JTextField(40);
        tfAutor = new JTextField(30);
        tfAnoDePub = new JTextField(4);
        cbAnodePub = cb;
        
        // int largura = getContentPane().getSize().width;
        // int altura = getContentPane().getSize().height;
		
        final DefaultTableModel modelo = new 
           DefaultTableModel();
        
        // construindo a tabela
        JTable tabela = new JTable(modelo);
        
        // Criando colunas
        modelo.addColumn("Nome");
        modelo.addColumn("Autor");
        modelo.addColumn("Ano");
        
        bConcluir.addActionListener(
          new ActionListener(){
              public void actionPerformed(ActionEvent e){
                String nome = tfNomeDoLivro.getText();
                String idade = tfAutor.getText();
                String ano = (String) cbAnodePub.getSelectedItem();
                
                // Adiciona uma linha
              modelo.addRow(new Object[]{nome, idade, ano});
            }
          }	
        ); 
        
        tabela.setPreferredScrollableViewportSize(new Dimension(350, 50));   
        JScrollPane scrollPane = new JScrollPane(tabela);
        
        // lNomeDoLivro.setBounds(largura - 450, altura - 450, 100, 30);
        // tfNomeDoLivro.setBounds(largura - 450, altura - 420, 420, 30);
        // lAutor.setBounds(largura - 450, altura - 390, 100, 30);
        // tfAutor.setBounds(largura - 450, altura - 360, 420, 30);
        // lAnodePub.setBounds(largura - 450, altura - 330, 200, 30);
        // cbAnodePub.setBounds(largura - 450, altura - 300, 60, 20);
        // bConcluir.setBounds(largura - 110, altura - 40, 100, 30);
        // bSair.setBounds(largura - 212, altura - 40, 100, 30);
        // tabela.setBounds(largura - 450, altura - 200, 60, 20);

        p.add(lNomeDoLivro);
        p.add(tfNomeDoLivro);
        p.add(lAutor);
        p.add(tfAutor);
        p.add(lAnodePub);
        p.add(cbAnodePub);
        p.add(scrollPane);
        p.add(lConcluir);
        p.add(bConcluir);
        p.add(bSair);
    }



    public static void main(String[] args){ 
        Main s = new Main();
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==bSair){ 
            System.exit(0);
        }
        
        // TODO Adicionar depois
        
    }
}
    
