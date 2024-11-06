import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Adm {
    private static int nAdms;
    private final String id;
    private final LocalDateTime dataCadastro;
    private String nome;
    private String senha;
    private String email;

    //CONSTRUTOR
    public Adm(String nome, String senha, String email) {
        this.id = UUID.randomUUID().toString(); // Gera um ID automaticamente
        this.dataCadastro = LocalDateTime.now(); // Define a data de cadastro como a data e hora atuais
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        nAdms++;
    }

    //GETTERS
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
    public int getnAdms() {
        return nAdms;
    }
    //SETTERS
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //METODOS

    //ATRIBUIR ALERTA
    public void alertarUsuario(Usuario usuario, String motivo) {
        if (usuario.verificaSobAlerta(usuario)){
            return;
        }
        usuario.setNAlertas(usuario.getNAlertas()+1);
        if (usuario.getNAlertas()==1) {
            usuario.setSobAlerta(true);

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.schedule(() -> {
                usuario.setSobAlerta(false);
                System.out.println("O alerta para o usuário " + usuario.getNome() + " expirou.");
                scheduler.shutdown(); // Encerra o agendador após a execução
            }, 24, TimeUnit.HOURS);

            System.out.println("Usuário " + usuario.getNome() + " recebeu o primeiro alerta. Motivo: " + motivo);
        }
        if (usuario.getNAlertas()==2) {
            usuario.setSobAlerta(true);

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.schedule(() -> {
                usuario.setSobAlerta(false);
                System.out.println("O alerta para o usuário " + usuario.getNome() + " expirou.");
                scheduler.shutdown(); // Encerra o agendador após a execução
            }, 24, TimeUnit.HOURS);

            System.out.println("Usuário " + usuario.getNome() + " recebeu o segundo alerta. Motivo: " + motivo);
        }
        if (usuario.getNAlertas()==3) {
            banirUsuario(usuario, motivo);
        }
    }
    //BANIR CONTA
    public void banirUsuario(Usuario usuario, String motivo) {
        if (usuario.getIs_Banned()) {
            System.out.println("O usuário já está banido.");
            return;
        }
        usuario.setIs_Banned(true);
        usuario.setSobAlerta(true);
        usuario.setNAlertas(3); // Marca que ele já teve o número máximo de alertas

        // Log ou notificação do banimento
        System.out.println("Usuário " + usuario.getNome() + " foi banido. Motivo: " + motivo);
    }
    //RELATORIO
    public String relatorio() {
        String relatorio = "\nUsuários Totais: " + Usuario.nUsuarios +
                "\nLivros Totais: " + Livro.nLivros +
                "\nTrocas Totais: " + Troca.nTrocas;
                //"\nUsuários Cadastrados Este Mês: " + ...
                //"\nLivros Cadastrados Este Mês: " + ...
                //"\nTrocas Realizadas Este Mês: " + ...
                //"\nLivro Mais Cadastrado: " + ...
                //"\nLivro Mais Trocado: " + ...
                //"\nUsuário Com Mais Trocas: " + ...;
        return relatorio;
    }
    //ATUALIZAR INFORMAÇÕES
    public void atualizarInformacoes(String novoNome, String novaSenha, String novoEmail) {
        if (novoNome != null && !novoNome.isEmpty()) {
            setNome(novoNome);
        }
        if (novaSenha != null && !novaSenha.isEmpty()) {
            setSenha(novaSenha);
        }
        if (novoEmail != null && !novoEmail.isEmpty()) {
            setEmail(novoEmail);
        }
        System.out.println("Informações atualizadas com sucesso.");
    }
}
