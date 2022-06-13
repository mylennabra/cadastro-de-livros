import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Main extends JFrame implements ActionListener{
    
    // Declarando variáveis de escolo global
    JComboBox cbAnodePub, cbEditora;
    JButton bConcluir, bSair, bLimpar, bDelet;
    JLabel lTitle, lNomeDoLivro, lAutor, lAnodePub, lEditora, lEstado, lConcluir, lCodigo;
    JTextField tfNomeDoLivro, tfAutor, tfAnoDePub, tfCodigo;
    JRadioButton rbNovo, rbSemi;
    // Declaração do método ButtonGroup() que permite que apenas um radioButton seja selecionado
    ButtonGroup E = new ButtonGroup();

    // Criando barra de menu
    JMenuBar mbmenuBar = new JMenuBar();
    // Declarando itens
    JMenu mArquivoMenu = new JMenu("Info");
    JMenu mSobreMenu = new JMenu("Mais");
    // Declarando subitens
    JMenuItem miName = new JMenuItem("Matheus");
    JMenuItem miName2 = new JMenuItem("Faymer");
    JMenuItem miName3 = new JMenuItem("Mylenna");
    JMenuItem miVersion = new JMenuItem("V 1.0 - 2022");
    JMenuItem miSobre = new JMenuItem("Clique para saber mais");
    JMenuItem miLimpar = new JMenuItem("Limpar campos");

    // "Puxando" modelo padrão de tabelas
    DefaultTableModel modelo = new DefaultTableModel();
    // Criando a tabela com o modelo passado por parâmetro 
    JTable tabela = new JTable(modelo);
    // Criando janela com barra rolagem para o caso de muitas linhas na tabela
    JScrollPane scrollPane = new JScrollPane(tabela);

    // Definindo uma fonte com tamanho diferente do padrão para aplicar no título **
    Font fonte = new Font("Segoe UI", Font.CENTER_BASELINE, 16);

    public Main(){
        // Criando frame (janela)
        setLayout(new FlowLayout()); // Organiza layout 
        setSize(1000,500); // Define tamanho do frame
        setVisible(true); // Torna o frame visivel
        setTitle("Livraria dos Sonhos v0.1"); // Definindo título pra janela 
        this.getContentPane().setBackground(Color.WHITE); // Definindo cor de fundo
        this.setLayout(null); // Deixando sem definição de layout para mais tarde fazer manualmente
        setLocationRelativeTo(null); // Definindo a posição da janela no centro da tela 
        setResizable(false); // Bloqueado maximização e customização de tamanho
        Container p = getContentPane();

        // Criando os ComboBox do Ano de Publicação e seus itens
        String[] years = { "", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", };
        JComboBox<String> cby = new JComboBox<>(years); 
        cby.setMaximumRowCount (6); // Maximo de linhas na lista do popup
        cby.setEditable(true); // Deixando editável para o cliente inserir caso não tenha a opção querida
        // Criando ComboBox das Editoras
        String[] editoras = { "", "Editora Rocco", "Saraiva", "Globo Livros", "Harper Collins", "Editora Arqueiro", "FDT", "Panda Books"};
        JComboBox<String> cbe = new JComboBox<>(editoras); 
        cbe.setMaximumRowCount (6);
        cbe.setEditable(true);

        // Adicionando o menu ao frame
        setJMenuBar(mbmenuBar);
        // Adicionando itens na barra
        mbmenuBar.add(mArquivoMenu);
        mbmenuBar.add(mSobreMenu);
        // Adicionando subitens aos itens da barra
        mArquivoMenu.add(miName);
        mArquivoMenu.add(miName2);
        mArquivoMenu.add(miName3);
        mArquivoMenu.addSeparator();
        mArquivoMenu.add(miVersion);
        mSobreMenu.add(miSobre);
        mSobreMenu.add(miLimpar);
            
        // Criando labels
        lTitle = new JLabel("--------------------------------------------------------- CADASTRO DE LIVROS ---------------------------------------------------------");
        lTitle.setFont(fonte);
        lNomeDoLivro = new JLabel("Nome do Livro: ");
        lAutor = new JLabel("Autor: ");
        lConcluir = new JLabel("Pronto? ");
        lAnodePub = new JLabel("Ano de Publicacao: ");
        lEditora = new JLabel("Editora: ");
        lCodigo = new JLabel("Codigo: ");
        lEstado = new JLabel("Estado do livro: ");

        // Criando Botões
        bConcluir = new JButton("Salvar");
        bSair = new JButton("Sair");
        bLimpar = new JButton("Limpar");
        bDelet = new JButton("Excluir Linha");

        // Criando campos de texto
        tfNomeDoLivro = new JTextField(40);
        tfAutor = new JTextField(4);
        tfCodigo = new JTextField(4);

        // "Puxando" as ComboBox criadas anteriormente e armazenando em outra variável
        cbAnodePub = cby;
        cbEditora = cbe;

        // Criando os RadioButtons
        rbNovo = new JRadioButton("Novo", false);
        rbSemi = new JRadioButton("Seminovo", false);
        // Adicionando RadioButtons ao grupo definido anteriormente
        E.add(rbNovo);
        E.add(rbSemi);

        // Definindo componentes que terão ações "ouvidas" para atribuir funcionalidade a eles
        bConcluir.addActionListener(this);
        bSair.addActionListener(this);
        bLimpar.addActionListener(this);
        bDelet.addActionListener(this);
        miSobre.addActionListener(this);
        miLimpar.addActionListener(this);

        // Pegando modelo de tabela e adicionando colunas 
        modelo.addColumn("Cod");
        modelo.addColumn("Nome");
        modelo.addColumn("Autor");
        modelo.addColumn("Editora");
        modelo.addColumn("Ano");
        modelo.addColumn("Estado");
        
        // Lendo as dimensões da janela e armazenando nas váriaveis
        int largura = getContentPane().getSize().width;
        int altura = getContentPane().getSize().height;
        // Definindo localização nos eixos x e y de cada componente e respectivamente largura e altura
        lTitle.setBounds(largura - 950, altura - 450, 1000, 25);
        lNomeDoLivro.setBounds(largura - 950, altura - 400, 100, 25);
        tfNomeDoLivro.setBounds(largura - 950, altura - 370, 281, 25);
        lEditora.setBounds(largura - 650, altura - 400, 121, 25);
        cbEditora.setBounds(largura - 650, altura - 370, 121, 25);
        lAutor.setBounds(largura - 950, altura - 310, 101, 25);
        tfAutor.setBounds(largura - 950, altura - 280, 281, 25);
        lEstado.setBounds(largura - 950, altura - 220, 121, 25);
        rbNovo.setBounds(largura - 950, altura - 190, 131, 25);
        rbSemi.setBounds(largura - 800, altura - 190, 131, 25);
        lCodigo.setBounds(largura - 650, altura - 220, 151, 25);
        tfCodigo.setBounds(largura - 650, altura - 190, 121, 25);
        lAnodePub.setBounds(largura - 650, altura - 310, 151, 25);
        cbAnodePub.setBounds(largura - 650, altura - 280, 121, 25);
        bConcluir.setBounds(largura - 950, altura - 120, 420, 25);
        bSair.setBounds(largura - 950, altura - 80, 205, 25);
        bLimpar.setBounds(largura - 735, altura - 80, 205, 25);
        bDelet.setBounds(largura - 450, altura - 80, 421, 25);
        scrollPane.setBounds(largura - 450, altura - 400, 421, 300);
        
        // Tornando os componentes visíveis ao adicionar na janela 
        p.add(lTitle);
        p.add(lNomeDoLivro);
        p.add(tfNomeDoLivro);
        p.add(lAutor);
        p.add(tfAutor);
        p.add(lCodigo);
        p.add(tfCodigo);
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
        p.add(bDelet);
        p.add(bLimpar);
        p.add(scrollPane);
        // Usando método revalidate para conferir que os componentes estão em seus lugares
        p.revalidate();
    }

    // Método que será chamado posteriormente para apagar todos os campos
    public void Erase(){
        tfNomeDoLivro.setText(""); // Para limpar a caixa de texto
        tfAutor.setText("");
        tfCodigo.setText("");
        cbEditora.setSelectedIndex(0); // Para limpar a combo_box
        cbAnodePub.setSelectedIndex(0);
        E.clearSelection(); // Para limpar os radios do grupo
    }


    // Classe principal
    public static void main(String[] args){ 
        Main s = new Main();
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    // Sobreescrevendo métodos personalizando os actions listeners
    @Override
    public void actionPerformed(ActionEvent ae) {
        // Se botão Sair for apertado irá fechar a janela
        if(ae.getSource()==bSair){ 
            System.exit(0);
        }
        // Se botão Sobre for apertado irá abrir outra frame com informações importantes
        if(ae.getSource() == miSobre){ 
            //new Sobre();
        }
        // Se botão Limpar for apertado irá chamar o método Erase() e limpará todos os campos
        if (ae.getSource() == bLimpar || ae.getSource() == miLimpar) {
          Erase();
        }
        // Se botão Concluir for apertado irá verificar se há campos vazios e irá adicionar informações na tabela
        if(ae.getSource()==bConcluir){
            if(tfNomeDoLivro.getText().length() > 0 && tfAutor.getText().length() > 0 && cbEditora.getSelectedItem() != "" && cbAnodePub.getSelectedItem() != "" && (rbNovo.isSelected() == true || rbSemi.isSelected() == true) && tfCodigo.getText().length() > 0){
                String cod = tfCodigo.getText();
                String nome = tfNomeDoLivro.getText();
                String autor = tfAutor.getText();
                String editora = (String) cbEditora.getSelectedItem();
                String ano = (String) cbAnodePub.getSelectedItem();
                String estado = rbNovo.isSelected() ? rbNovo.getText() : rbSemi.getText();
                Erase();
              
                // Adicionando linha na tabela
                modelo.addRow(new Object[]{cod, nome, autor, editora, ano, estado});
            }else{
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        // Se botão Delet for apertado irá apagar a linha selecionada
        if (ae.getSource()==bDelet){
            int a = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro desse livro?", "Confirmacao", JOptionPane.YES_NO_OPTION);
            if(a==0){
                if (tabela.getSelectedRow() >= 0){
                    modelo.removeRow(tabela.getSelectedRow());
                    tabela.setModel(modelo);
                }else{
                    JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
                }
            }
        }
    }
}
    
