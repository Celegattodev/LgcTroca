public class Endereco {
    public static int nEnderecos;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;

    // Construtor
    public Endereco(String rua, String numero, String cidade, String estado, String cep, String pais) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.pais = pais;
        nEnderecos++;
    }

    // Getters e Setters
    public String getRua() {
        return rua;
    }
    public String getNumero() {
        return numero;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getCep() {
        return cep;
    }
    public String getPais() {
        return pais;
    }
    public int getnEnderecos(){
        return nEnderecos;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    // Metodo para editar o endereço
    public void editarEndereco(String novaRua, String novoNumero, String novaCidade, String novoEstado, String novoCep, String novoPais) {
        this.rua = novaRua;
        this.numero = novoNumero;
        this.cidade = novaCidade;
        this.estado = novoEstado;
        this.cep = novoCep;
        this.pais = novoPais;
    }

    // Metodo para exibir o endereço formatado
    public String toString() {
        return "Endereço: " + rua + ", " + numero + ", " + cidade + ", " + estado + ", " + cep + ", " + pais;
    }
}
