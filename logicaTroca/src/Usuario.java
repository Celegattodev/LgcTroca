import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.Scanner;

public class Usuario {
    public static int nUsuarios;
    private final String id;
    private final LocalDateTime dataCadastro;
    private String nome;
    private String senha;
    private String email;
    private Endereco endereco;
    private String telefone;
    private Set<Livro> livros; // conjunto de livros na posse do usuário
    private int quantidadeLivros;
    private int nAlertas;
    private boolean sobAlerta;
    private boolean is_banned;

    // Construtor
    public Usuario(String nome, String senha, String email, Endereco endereco, String telefone) {
        this.id = UUID.randomUUID().toString(); // Gera um ID automaticamente
        this.dataCadastro = LocalDateTime.now(); // Define a data de cadastro como a data e hora atuais
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.livros = new HashSet<>(); // Inicializa o conjunto de livros
        this.quantidadeLivros = 0;
        this.nAlertas = 0;
        this.sobAlerta = false;
        this.is_banned = false;
        nUsuarios++;
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
    public Endereco getEndereco() {
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
    public int getNAlertas() {
        return nAlertas;
    }
    public boolean getSobAlerta() {
        return sobAlerta;
    }
    public boolean getIs_Banned() {
        return is_banned;
    }
    public int getnUsuarios() {
        return nUsuarios;
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
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setNAlertas(int nAlertas) {
        this.nAlertas = nAlertas;
    }
    public void setSobAlerta(boolean sobAlerta) {
        this.sobAlerta = sobAlerta;
    }
    public void setIs_Banned(boolean is_banned) {
        this.is_banned = is_banned;
    }

    // Métodos comuns
    public void addLivro(Livro livro) {
        if (is_banned) {
            System.out.println("Ação não permitida. O usuário está banido.");
            return;
        }
        this.livros.add(livro);
        this.quantidadeLivros++;
    }
    public void removeLivro(Livro livro) {
        if (is_banned) {
            System.out.println("Ação não permitida. O usuário está banido.");
            return;
        }
        this.livros.remove(livro);
        this.quantidadeLivros--;
    }
    public void atualizarInformacoes(String novoNome, String novaSenha, String novoEmail, Endereco novoEndereco, String novoTelefone) {
        if (novoNome != null && !novoNome.isEmpty()) {
            setNome(novoNome);
        }
        if (novaSenha != null && !novaSenha.isEmpty()) {
            setSenha(novaSenha);
        }
        if (novoEmail != null && !novoEmail.isEmpty()) {
            setEmail(novoEmail);
        }
        if (novoEndereco != null) {
            setEndereco(novoEndereco);
        }
        if (novoTelefone != null && !novoTelefone.isEmpty()) {
            setTelefone(novoTelefone);
        }
        System.out.println("Informações atualizadas com sucesso.");
    }

    //VERIFICAÇÕES PRÉ-TROCA
    //True = passou na verificação
    public boolean verificaQtdMinimoLivros(Usuario usuario) {
        if (usuario.getQuantidadeLivros() > 0){
            return true;
        } return false;
    } // Usuário precisa ter pelo menos um livro
    public boolean verificaSobAlerta(Usuario usuario) {
        if (usuario.getSobAlerta() == false) {
            return true;
        } return false;
    }
    public boolean verificaRequisitoTroca(Usuario usuario) {
        if (verificaQtdMinimoLivros(usuario)) {
            return verificaSobAlerta(usuario);
        } return false;
    } //verificaSobAlerta + verificaQtdMinimoLivros

    public void solicitarTroca(Usuario usuarioOfertante, Usuario usuarioReceptor, Livro livroOfertante, Livro livroReceptor) {
        if (is_banned) {
            System.out.println("Ação não permitida. O usuário está banido.");
            return;
        }

        if (!verificaRequisitoTroca(usuarioOfertante)) {
            System.out.println("Troca não pode ser realizada. Usuário Ofertante não possui livros ou está sobre alerta.");
            return;
        }

        if (!verificaRequisitoTroca(usuarioReceptor)) {
            System.out.println("Troca não pode ser realizada. Usuário Receptor não possui livros ou está sobre alerta.");
            return;
        }

        if (!usuarioOfertante.getLivros().contains(livroOfertante)) {
            System.out.println("Troca não pode ser realizada. Usuário Ofertante não tem o livro especificado.");
            return;
        }

        if (!usuarioReceptor.getLivros().contains(livroReceptor)) {
            System.out.println("Troca não pode ser realizada. Usuário Receptor não tem o livro especificado.");
            return;
        }

        // Inicializar a troca e atualizar o status
        Troca troca = new Troca(usuarioOfertante, usuarioReceptor, livroOfertante, livroReceptor);
        troca.setStatusSolicitada();
        troca.setStatusAguardandoResposta();

        // Simular aceitação da troca pelo receptor
        troca.setStatusConfirmada();

        // Remover os livros das coleções atuais
        usuarioOfertante.removeLivro(livroOfertante);
        usuarioReceptor.removeLivro(livroReceptor);

        // Aguardar e validar código de envio
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Código de envio para Usuário Ofertante: ");
            String codEnvio1 = scanner.next();

            System.out.print("Código de envio para Usuário Receptor: ");
            String codEnvio2 = scanner.next();

            // Continuar o processo de troca
            troca.setStatusEmProcesso();
            troca.setStatusConcluida();

            // Adicionar os livros às novas coleções
            usuarioOfertante.addLivro(livroReceptor);
            usuarioReceptor.addLivro(livroOfertante);

            System.out.println("Troca realizada com sucesso!");
        } finally {
            scanner.close();
        }
    }
}