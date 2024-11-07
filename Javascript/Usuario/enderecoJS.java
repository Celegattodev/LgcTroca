/*class Endereco {
    static nEnderecos = 0;

    constructor(rua, numero, cidade, estado, cep, pais) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pais = pais;
        Endereco.nEnderecos++;
    }

    // Getters e Setters
    getRua() {
        return this.rua;
    }

    setRua(rua) {
        this.rua = rua;
    }

    getNumero() {
        return this.numero;
    }

    setNumero(numero) {
        this.numero = numero;
    }

    getCidade() {
        return this.cidade;
    }

    setCidade(cidade) {
        this.cidade = cidade;
    }

    getEstado() {
        return this.estado;
    }

    setEstado(estado) {
        this.estado = estado;
    }

    getCep() {
        return this.cep;
    }

    setCep(cep) {
        this.cep = cep;
    }

    getPais() {
        return this.pais;
    }

    setPais(pais) {
        this.pais = pais;
    }

    static getnEnderecos() {
        return Endereco.nEnderecos;
    }

    // Método para editar o endereço
    editarEndereco(novaRua, novoNumero, novaCidade, novoEstado, novoCep, novoPais) {
        this.rua = novaRua;
        this.numero = novoNumero;
        this.cidade = novaCidade;
        this.estado = novoEstado;
        this.cep = novoCep;
        this.pais = novoPais;
    }

    // Método para exibir o endereço formatado
    toString() {
        return `Endereço: ${this.rua}, ${this.numero}, ${this.cidade}, ${this.estado}, ${this.cep}, ${this.pais}`;
    }
}

module.exports = Endereco;
