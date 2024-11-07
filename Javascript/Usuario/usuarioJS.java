/*const { v4: uuidv4 } = require('uuid'); // Para gerar UUID, precisa instalar com 'npm install uuid'
const readline = require('readline'); // Para ler entradas do console
const rl = readline.createInterface({
    input: process.stdin,
            output: process.stdout
});

class Usuario {
    static nUsuarios =0;

    constructor(nome, senha, email, endereco, telefone) {
        this.id = uuidv4(); // Gera um ID automaticamente
        this.dataCadastro = new Date(); // Define a data de cadastro como a data e hora atuais
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.livros = new Set(); // Conjunto de livros
        this.quantidadeLivros = 0;
        this.nAlertas = 0;
        this.sobAlerta = false;
        this.is_banned = false;
        Usuario.nUsuarios++;
    }

    // Getters
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

    getEndereco() {
        return this.endereco;
    }

    getTelefone() {
        return this.telefone;
    }

    getLivros() {
        return this.livros;
    }

    getQuantidadeLivros() {
        return this.quantidadeLivros;
    }

    getNAlertas() {
        return this.nAlertas;
    }

    getSobAlerta() {
        return this.sobAlerta;
    }

    getIsBanned() {
        return this.is_banned;
    }

    getnUsuarios() {
        return Usuario.nUsuarios;
    }

    // Setters
    setNome(nome) {
        this.nome = nome;
    }

    setSenha(senha) {
        this.senha = senha;
    }

    setEmail(email) {
        this.email = email;
    }

    setEndereco(endereco) {
        this.endereco = endereco;
    }

    setTelefone(telefone) {
        this.telefone = telefone;
    }

    setNAlertas(nAlertas) {
        this.nAlertas = nAlertas;
    }

    setSobAlerta(sobAlerta) {
        this.sobAlerta = sobAlerta;
    }

    setIsBanned(is_banned) {
        this.is_banned = is_banned;
    }

    // Métodos comuns
    addLivro(livro) {
        if (this.is_banned) {
            console.log("Ação não permitida. O usuário está banido.");
            return;
        }
        this.livros.add(livro);
        this.quantidadeLivros++;
    }

    removeLivro(livro) {
        if (this.is_banned) {
            console.log("Ação não permitida. O usuário está banido.");
            return;
        }
        this.livros.delete(livro);
        this.quantidadeLivros--;
    }

    atualizarInformacoes(novoNome, novaSenha, novoEmail, novoEndereco, novoTelefone) {
        if (novoNome) this.setNome(novoNome);
        if (novaSenha) this.setSenha(novaSenha);
        if (novoEmail) this.setEmail(novoEmail);
        if (novoEndereco) this.setEndereco(novoEndereco);
        if (novoTelefone) this.setTelefone(novoTelefone);

        console.log("Informações atualizadas com sucesso.");
    }

    // Verificações
    verificaQtdMinimoLivros(usuario) {
        return usuario.getQuantidadeLivros() > 0;
    }

    verificaSobAlerta(usuario) {
        return !usuario.getSobAlerta();
    }

    verificaRequisitoTroca(usuario) {
        return this.verificaQtdMinimoLivros(usuario) && this.verificaSobAlerta(usuario);
    }

    async solicitarTroca(usuarioOfertante, usuarioReceptor, livroOfertante, livroReceptor) {
        if (this.is_banned) {
            console.log("Ação não permitida. O usuário está banido.");
            return;
        }

        if (!this.verificaRequisitoTroca(usuarioOfertante)) {
            console.log("Troca não pode ser realizada. Usuário Ofertante não possui livros ou está sobre alerta.");
            return;
        }

        if (!this.verificaRequisitoTroca(usuarioReceptor)) {
            console.log("Troca não pode ser realizada. Usuário Receptor não possui livros ou está sobre alerta.");
            return;
        }

        if (!usuarioOfertante.getLivros().has(livroOfertante)) {
            console.log("Troca não pode ser realizada. Usuário Ofertante não tem o livro especificado.");
            return;
        }

        if (!usuarioReceptor.getLivros().has(livroReceptor)) {
            console.log("Troca não pode ser realizada. Usuário Receptor não tem o livro especificado.");
            return;
        }

        // Simular processo de troca
        usuarioOfertante.removeLivro(livroOfertante);
        usuarioReceptor.removeLivro(livroReceptor);

        try {
      const codEnvio1 = await new Promise(resolve = > rl.question("Código de envio para Usuário Ofertante: ", resolve));
      const codEnvio2 = await new Promise(resolve = > rl.question("Código de envio para Usuário Receptor: ", resolve));

            usuarioOfertante.addLivro(livroReceptor);
            usuarioReceptor.addLivro(livroOfertante);

            console.log("Troca realizada com sucesso!");
        } finally {
            rl.close();
        }
    }
}