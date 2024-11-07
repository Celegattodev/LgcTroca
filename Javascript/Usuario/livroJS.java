/*const { v4: uuidv4 } = require('uuid'); // Para gerar UUID, precisa instalar com 'npm install uuid'

class Livro {
    static nLivros = 0;

    static CondicaoLivro = {
        NOVO: 'Novo',
                USADO: 'Usado',
                DANIFICADO: 'Danificado'
    };

    static GeneroLivro = {
        FICCAO: 'Ficção',
                NAO_FICCAO: 'Não-Ficção',
                ROMANCE: 'Romance',
                FANTASIA: 'Fantasia',
                TERROR: 'Terror',
                BIOGRAFIA: 'Biografia',
                AUTO_AJUDA: 'Auto-Ajuda',
                INFANTIL: 'Infantil'
    };

    constructor(titulo, autor, condicao, genero) {
        this.id = uuidv4(); // Gera um ID automaticamente
        this.titulo = titulo;
        this.autor = autor;
        this.condicao = condicao;
        this.genero = genero;
        Livro.nLivros++;
    }

    // Getters e Setters
    getTitulo() {
        return this.titulo;
    }

    setTitulo(titulo) {
        this.titulo = titulo;
    }

    getAutor() {
        return this.autor;
    }

    setAutor(autor) {
        this.autor = autor;
    }

    getCondicao() {
        return this.condicao;
    }

    setCondicao(condicao) {
        this.condicao = condicao;
    }

    getGenero() {
        return this.genero;
    }

    setGenero(genero) {
        this.genero = genero;
    }

    static getnLivros() {
        return Livro.nLivros;
    }
}

module.exports = Livro;
