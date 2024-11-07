/*const { v4: uuidv4 } = require('uuid');

class Adm {
    static nAdms = 0;

    constructor(nome, senha, email) {
        this.id = uuidv4(); // Gera um ID automaticamente
        this.dataCadastro = new Date(); // Define a data de cadastro como a data e hora atuais
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        Adm.nAdms++;
    }

    // GETTERS
    getId() {
        return this.id;
    }

    getDataCadastro() {
        return this.dataCadastro;
    }

    getNome() {
        return this.nome;
    }

    getSenha() {
        return this.senha;
    }

    getEmail() {
        return this.email;
    }

    static getnAdms() {
        return Adm.nAdms;
    }

    // SETTERS
    setNome(nome) {
        this.nome = nome;
    }

    setSenha(senha) {
        this.senha = senha;
    }

    setEmail(email) {
        this.email = email;
    }

    // MÉTODOS

    // ATRIBUIR ALERTA
    alertarUsuario(usuario, motivo) {
        if (usuario.verificaSobAlerta(usuario)) {
            return;
        }
        usuario.setNAlertas(usuario.getNAlertas() + 1);
        if (usuario.getNAlertas() === 1 || usuario.getNAlertas() === 2) {
            usuario.setSobAlerta(true);
            console.log(`Usuário ${usuario.getNome()} recebeu o ${usuario.getNAlertas()}º alerta. Motivo: ${motivo}`);

            setTimeout(() => {
                    usuario.setSobAlerta(false);
            console.log(`O alerta para o usuário ${usuario.getNome()} expirou.`);
      }, 24 * 60 * 60 * 1000); // 24 horas
        }
        if (usuario.getNAlertas() === 3) {
            this.banirUsuario(usuario, motivo);
        }
    }

    // BANIR CONTA
    banirUsuario(usuario, motivo) {
        if (usuario.getIs_Banned()) {
            console.log("O usuário já está banido.");
            return;
        }
        usuario.setIs_Banned(true);
        usuario.setSobAlerta(true);
        usuario.setNAlertas(3); // Marca que ele já teve o número máximo de alertas

        // Log ou notificação do banimento
        console.log(`Usuário ${usuario.getNome()} foi banido. Motivo: ${motivo}`);
    }

    // RELATÓRIO
    relatorio() {
    const relatorio = `
        Usuários Totais: ${Usuario.nUsuarios}
        Livros Totais: ${Livro.nLivros}
        Trocas Totais: ${Troca.nTrocas}
        // Adicione outros detalhes do relatório conforme necessário
    `;
        return relatorio;
    }

    // ATUALIZAR INFORMAÇÕES
    atualizarInformacoes(novoNome, novaSenha, novoEmail) {
        if (novoNome) this.setNome(novoNome);
        if (novaSenha) this.setSenha(novaSenha);
        if (novoEmail) this.setEmail(novoEmail);
        console.log("Informações atualizadas com sucesso.");
    }
}

module.exports = Adm;
