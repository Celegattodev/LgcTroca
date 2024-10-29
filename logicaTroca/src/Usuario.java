import javax.swing.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Scanner;

public class Usuario {
    private final String id;
    private final LocalDateTime dataCadastro;
    private String nome;
    private String senha;
    private String email;
    private String endereco;
    private String telefone;
    private Set<Livro> livros; // conjunto de livros na posse do usuário
    private int quantidadeLivros;
    private int alertas;

    // Construtor
    public Usuario(String nome, String senha, String email, String endereco, String telefone) {
        this.id = UUID.randomUUID().toString(); // Gera um ID automaticamente
        this.dataCadastro = LocalDateTime.now(); // Define a data de cadastro como a data e hora atuais
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.livros = new HashSet<>(); // Inicializa o conjunto de livros
        this.quantidadeLivros = 0;
        this.alertas = 0;
    }

    // Getters
    public String getId() {
        return id;
    }
    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }
    public String getEmail() {
        return email;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public Set<Livro> getLivros() {
        return livros;
    }
    public int getQuantidadeLivros() {
        return quantidadeLivros;
    }
    public int getAlertas() {
        return alertas;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
        this.quantidadeLivros++;
    }
    public void removeLivro(Livro livro) {
        this.livros.remove(livro);
        this.quantidadeLivros--;
    }

    // Métodos comuns
    public boolean verificaQtdMinimoLivros(Usuario usuario) {
        return usuario.getQuantidadeLivros() > 0;
    } // Usuário precisa ter pelo menos um livro

    public boolean verificaExistenciaAlerta(Usuario usuario) {
        return usuario.getAlertas() == 0;
    } // Usuário não pode ter alerta. (DEVE SER MODIFICADO)

    public boolean verificaRequisitoTroca(Usuario usuario) { // Fazer o TryCatch
        if (verificaQtdMinimoLivros(usuario)) {
            return verificaExistenciaAlerta(usuario);
        }
        return false;
    } //verificaExistenciaAlerta + verificaQtdMinimoLivros

    public void solicitarTroca(Usuario usuarioOfertante, Usuario usuarioReceptor, Livro livroOfertante, Livro livroReceptor) {
        if (verificaRequisitoTroca(usuarioOfertante)) {
            if (verificaRequisitoTroca(usuarioReceptor)) {
                if (usuarioOfertante.getLivros().contains(livroOfertante)) {
                    if (usuarioReceptor.getLivros().contains(livroReceptor)) {
                        Troca troca1 = new Troca(usuarioOfertante, usuarioReceptor, livroOfertante, livroReceptor);

                        troca1.setStatusSolicitada(); //Troca solicitada
                        troca1.setStatusAguardandoResposta();//Aguardando resposta
                        troca1.setStatusConfirmada();//usuarioReceptor aceita
                        // Remover os livros das coleções atuais
                        usuarioOfertante.removeLivro(livroOfertante);
                        usuarioReceptor.removeLivro(livroReceptor);
                        troca1.setStatusAguardandoEnvio();//Aguardando envio do cod
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Código de envio: "); //VERIFICAR CÓDIGO DE ENVIO??
                        String codEnvio = scanner.next();
                        troca1.setStatusEmProcesso();//livros enviados
                        troca1.setStatusConcluida();//livros recebidos
                        // Adicionar os livros às novas coleções
                        usuarioOfertante.addLivro(livroReceptor);
                        usuarioReceptor.addLivro(livroOfertante);

                        System.out.println("Troca realizada com sucesso!");
                    }
                    System.out.println("Troca não pode ser realizada. Usuário Receptor não tem o livro especificado.");
                }
                System.out.println("Troca não pode ser realizada. Usuário Ofertante não tem o livro especificado.");
            }
            System.out.println("Troca não pode ser realizada. Usuário Receptor não possui livros ou está sobre alerta.");
        }
        System.out.println("Troca não pode ser realizada. Usuário Ofertante não possui livros ou está sobre alerta");
    }
}