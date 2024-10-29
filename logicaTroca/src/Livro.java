import java.util.UUID;

public class Livro {
    private String id;
    private String titulo;
    private String autor;
    private CondicaoLivro condicao;
    private GeneroLivro genero;

    public enum CondicaoLivro {
        NOVO, USADO, DANIFICADO
    }
    public enum GeneroLivro {
        FICCAO, NAO_FICCAO, ROMANCE, FANTASIA, TERROR, BIOGRAFIA, AUTO_AJUDA, INFANTIL
    }

    //Construtor
    public Livro(String titulo, String autor, CondicaoLivro condicao, GeneroLivro genero) {
        this.id = UUID.randomUUID().toString(); // Gera um ID automaticamente
        this.titulo = titulo;
        this.autor = autor;
        this.condicao = condicao;
        this.genero = genero;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public CondicaoLivro getCondicao() {
        return condicao;
    }
    public void setCondicao(CondicaoLivro condicao) {
        this.condicao = condicao;
    }
    public GeneroLivro getGenero() {
        return genero;
    }
    public void setGenero(GeneroLivro genero) {
        this.genero = genero;
    }
}
