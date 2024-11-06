public class Troca {
    public static int nTrocas;
    private Usuario usuarioOfertante;
    private Usuario usuarioReceptor;
    private Livro livroOfertante;
    private Livro livroReceptor;
    private StatusTroca statusTroca;

    public enum StatusTroca {
        SOLICITADA, //Quando usuario ofertante solicita o livro do usuario receptor.
        AGUARDANDO_RESPOSTA, //Esperando usuario receptor responder
        CONFIRMADA, //Quando usuario receptor aceita a troca,
        RECUSADA, //Quando uma das partes não aceita a troca
        CANCELADA, //Quando uma das partes cancela a troca ou deixa de enviar o livro
        AGUARDANDO_ENVIO, //Quando a troca já foi confirmada e agora as partes precisam enviar o código de envio
        EM_PROCESSO, //Quando ambas as partes enviam o código e os livros estão a caminho
        CONCLUIDA; //Quando ambos os livros chegam aos seus destinos
    }

    //Construtor
    public Troca(Usuario usuarioOfertante, Usuario usuarioReceptor, Livro livroOfertante, Livro livroReceptor) {
        statusTroca = StatusTroca.SOLICITADA; // Inicializa com o status SOLICITADA
        this.usuarioOfertante = usuarioOfertante;
        this.usuarioReceptor = usuarioReceptor;
        this.livroOfertante = livroOfertante;
        this.livroReceptor = livroReceptor;
        nTrocas++;
    }

    // Getters e Setters
    public Usuario getUsuarioOfertante() {
        return usuarioOfertante;
    }
    public void setUsuarioOfertante(Usuario usuarioOfertante) {
        this.usuarioOfertante = usuarioOfertante;
    }
    public Usuario getUsuarioReceptor() {
        return usuarioReceptor;
    }
    public void setUsuarioReceptor(Usuario usuarioReceptor) {
        this.usuarioReceptor = usuarioReceptor;
    }
    public Livro getLivroOfertante() {
        return livroOfertante;
    }
    public void setLivroOfertante(Livro livroOfertante) {
        this.livroOfertante = livroOfertante;
    }
    public Livro getLivroReceptor() {
        return livroReceptor;
    }
    public void setLivroReceptor(Livro livroReceptor) {
        this.livroReceptor = livroReceptor;
    }
    public StatusTroca getStatusTroca() {
        return statusTroca;
    }
    public int getnTrocas() {
        return nTrocas;
    }

    // Métodos para alterar o status da troca
    public void setStatusSolicitada() {
        this.statusTroca = StatusTroca.SOLICITADA;
    }
    public void setStatusConfirmada() {
        this.statusTroca = StatusTroca.CONFIRMADA;
    }
    public void setStatusRecusada() {
        this.statusTroca = StatusTroca.RECUSADA;
    }
    public void setStatusCancelada() {
        this.statusTroca = StatusTroca.CANCELADA;
    }
    public void setStatusAguardandoEnvio() {
        this.statusTroca = StatusTroca.AGUARDANDO_ENVIO;
    }
    public void setStatusEmProcesso() {
        this.statusTroca = StatusTroca.EM_PROCESSO;
    }
    public void setStatusConcluida() {
        this.statusTroca = StatusTroca.CONCLUIDA;
    }
    public void setStatusAguardandoResposta() {
        this.statusTroca = StatusTroca.AGUARDANDO_RESPOSTA;
    }

    @Override
    public String toString() {
        return "Troca{" +
                "usuarioOfertante='" + usuarioOfertante +
                ", usuarioReceptor='" + usuarioReceptor +
                ", livroOfertante=" + livroOfertante +
                ", livroReceptor=" + livroReceptor +
                ", statusTroca=" + statusTroca +
                '}';
    }
}
