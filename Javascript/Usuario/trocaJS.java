/*class Troca {
    static nTrocas = 0;

    static StatusTroca = {
        SOLICITADA: "SOLICITADA",
                AGUARDANDO_RESPOSTA: "AGUARDANDO_RESPOSTA",
                CONFIRMADA: "CONFIRMADA",
                RECUSADA: "RECUSADA",
                CANCELADA: "CANCELADA",
                AGUARDANDO_ENVIO: "AGUARDANDO_ENVIO",
                EM_PROCESSO: "EM_PROCESSO",
                CONCLUIDA: "CONCLUIDA",
    };

    constructor(usuarioOfertante, usuarioReceptor, livroOfertante, livroReceptor) {
        this.usuarioOfertante = usuarioOfertante;
        this.usuarioReceptor = usuarioReceptor;
        this.livroOfertante = livroOfertante;
        this.livroReceptor = livroReceptor;
        this.statusTroca = Troca.StatusTroca.SOLICITADA;
        Troca.nTrocas++;
    }

    // Getters
    getUsuarioOfertante() {
        return this.usuarioOfertante;
    }

    getUsuarioReceptor() {
        return this.usuarioReceptor;
    }

    getLivroOfertante() {
        return this.livroOfertante;
    }

    getLivroReceptor() {
        return this.livroReceptor;
    }

    getStatusTroca() {
        return this.statusTroca;
    }

    static getnTrocas() {
        return Troca.nTrocas;
    }

    // Métodos para alterar o status da troca
    setStatusSolicitada() {
        this.statusTroca = Troca.StatusTroca.SOLICITADA;
    }

    setStatusConfirmada() {
        this.statusTroca = Troca.StatusTroca.CONFIRMADA;
    }

    setStatusRecusada() {
        this.statusTroca = Troca.StatusTroca.RECUSADA;
    }

    setStatusCancelada() {
        this.statusTroca = Troca.StatusTroca.CANCELADA;
    }

    setStatusAguardandoEnvio() {
        this.statusTroca = Troca.StatusTroca.AGUARDANDO_ENVIO;
    }

    setStatusEmProcesso() {
        this.statusTroca = Troca.StatusTroca.EM_PROCESSO;
    }

    setStatusConcluida() {
        this.statusTroca = Troca.StatusTroca.CONCLUIDA;
    }

    setStatusAguardandoResposta() {
        this.statusTroca = Troca.StatusTroca.AGUARDANDO_RESPOSTA;
    }

    // Método para exibir as informações da troca
    toString() {
        return `Troca {
            usuarioOfertante: ${this.usuarioOfertante},
            usuarioReceptor: ${this.usuarioReceptor},
            livroOfertante: ${this.livroOfertante},
            livroReceptor: ${this.livroReceptor},
            statusTroca: ${this.statusTroca}
        }`;
    }
}

module.exports = Troca;
