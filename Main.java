import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Main extends JFrame implements ActionListener{
    
    JComboBox cbAnodePub, cbEditora;
    JButton bConcluir, bSair, bLimpar, bSobre;
    JLabel lTitle, lNomeDoLivro, lAutor, lAnodePub, lEditora, lEstado, lConcluir;
    JTextField tfNomeDoLivro, tfAutor, tfAnoDePub;
    JRadioButton rbNovo, rbSemi;

    Font fonte = new Font("Segoe UI", Font.CENTER_BASELINE, 16);

    public Main(){
        //JPanel p = new JPanel();
        setLayout(new FlowLayout()); // Organiza layout 
        setSize(1000,500); // Define tamanho do frame
        setVisible(true); // Torna o frame visivel
        setTitle("Livraria dos Sonhos v0.1"); // Definindo título pra janela 
        this.getContentPane().setBackground(Color.white);
        this.setLayout(null);
        setLocationRelativeTo(null);
        //setResizable(false);
        Container p = getContentPane();


        String[] years = { "", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", };
        JComboBox<String> cby = new JComboBox<>(years); 
        cby.setMaximumRowCount (6);
        cby.setEditable(true);
        
        String[] editoras = { "", "Editora Rocco", "Saraiva", "Globo Livros", "Harper Collins", "Editora Arqueiro", "FDT", "Panda Books"};
        JComboBox<String> cbe = new JComboBox<>(editoras); 
        cbe.setMaximumRowCount (6);
        cbe.setEditable(true);

        // Criando barra
        JMenuBar mbmenuBar = new JMenuBar();
        // Adicionando itens
        JMenu mArquivoMenu = new JMenu("Info");
        JMenu mSobreMenu = new JMenu("Mais");
        JMenuItem miName = new JMenuItem("Mylenna");
        JMenuItem miVersion = new JMenuItem("V 1.0 - 2022");
        JMenuItem miSobre = new JMenuItem("Clique para saber mais");
        JMenuItem miLimpar = new JMenuItem("Limpar campos");
        
        // Adicionando itens ao frame
        setJMenuBar(mbmenuBar);
        mbmenuBar.add(mArquivoMenu);
        mbmenuBar.add(mSobreMenu);
        
        // Adicionando subitens aos itens da bar
        mArquivoMenu.add(miName);
        mArquivoMenu.addSeparator();
        mArquivoMenu.add(miVersion);
        mSobreMenu.add(miSobre);
        mSobreMenu.add(miLimpar);
            
        
        
        //cb.setEditable (true);
        
        lTitle = new JLabel("--------------------------------------------------------- CADASTRO DE LIVROS ---------------------------------------------------------");
        lTitle.setFont(fonte);
        lNomeDoLivro = new JLabel("Nome do Livro: ");
        lAutor = new JLabel("Autor: ");
        lConcluir = new JLabel("Pronto? ");
        lAnodePub = new JLabel("Ano de Publicacao: ");
        lEditora = new JLabel("Editora: ");
        lEstado = new JLabel("Estado do livro: ");
        bConcluir = new JButton("Submit");
        bSair = new JButton("Sair");
        bLimpar = new JButton("Limpar");
        bSobre = new JButton("Sobre");
        tfNomeDoLivro = new JTextField(40);
        tfAutor = new JTextField(30);
        tfAnoDePub = new JTextField(4);
        cbAnodePub = cby;
        cbEditora = cbe;
        rbNovo = new JRadioButton("Novo", false);
        rbSemi = new JRadioButton("Seminovo", false);

        ButtonGroup E = new ButtonGroup();
                    E.add(rbNovo);
                    E.add(rbSemi);

        
        
        final DefaultTableModel modelo = new 
        DefaultTableModel();
        
        // construindo a tabela
        JTable tabela = new JTable(modelo);
        
        // Criando colunas
        modelo.addColumn("Nome");
        modelo.addColumn("Autor");
        modelo.addColumn("Editora");
        modelo.addColumn("Ano");
        modelo.addColumn("Estado");

        bConcluir.addActionListener(
          new ActionListener(){
            public void actionPerformed(ActionEvent e){
              String nome = tfNomeDoLivro.getText();
              String autor = tfAutor.getText();
              String editora = (String) cbEditora.getSelectedItem();
              String ano = (String) cbAnodePub.getSelectedItem();
              String estado = rbNovo.isSelected() ? rbNovo.getText() : rbSemi.getText();
              
              // Adiciona uma linha
              modelo.addRow(new Object[]{nome, autor, editora, ano, estado});
            }
          }	
        ); 
          
        JScrollPane scrollPane = new JScrollPane(tabela);
        
        int largura = getContentPane().getSize().width;
        int altura = getContentPane().getSize().height;
    
        lTitle.setBounds(largura - 950, altura - 450, 1000, 25);
        lNomeDoLivro.setBounds(largura - 950, altura - 400, 100, 25);
        tfNomeDoLivro.setBounds(largura - 950, altura - 370, 281, 25);
        lEditora.setBounds(largura - 650, altura - 400, 121, 25);
        cbEditora.setBounds(largura - 650, altura - 370, 121, 25);
        lAutor.setBounds(largura - 950, altura - 340, 101, 25);
        tfAutor.setBounds(largura - 950, altura - 310, 281, 25);
        lEstado.setBounds(largura - 950, altura - 280, 121, 25);
        rbNovo.setBounds(largura - 950, altura - 250, 131, 25);
        rbSemi.setBounds(largura - 800, altura - 250, 131, 25);
        lAnodePub.setBounds(largura - 650, altura - 340, 151, 25);
        cbAnodePub.setBounds(largura - 650, altura - 310, 121, 25);
        bConcluir.setBounds(largura - 630, altura - 60, 100, 25);
        bSair.setBounds(largura - 736, altura - 60, 100, 25);
        bLimpar.setBounds(largura - 843, altura - 60, 100, 25);
        bSobre.setBounds(largura - 950, altura - 60, 100, 25);
        scrollPane.setBounds(largura - 450, altura - 400, 421, 300);

        p.add(lTitle);
        p.add(lNomeDoLivro);
        p.add(tfNomeDoLivro);
        p.add(lAutor);
        p.add(tfAutor);
        p.add(lAnodePub);
        p.add(cbAnodePub);
        p.add(lEditora);
        p.add(cbEditora);
        p.add(lEstado);
        p.add(rbNovo);
        p.add(rbSemi);
        p.add(lConcluir);
        p.add(bConcluir);
        p.add(bSair);
        p.add(bLimpar);
        p.add(bSobre);
        p.add(scrollPane);
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
        if (ae.getSource() == bLimpar) {
          tfNomeDoLivro.setText(""); // Para limpar a caixa de texto
          tfAutor.setText("");
          //cbAnodePub.setText("");
          
          
      }
        
        // TODO Adicionar depois
        
    }
}
    
