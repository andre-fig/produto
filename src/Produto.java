public class Produto {
    private String codigo;
    private String descricao;
    private Double preco;

    public Produto(String codigo, String descricao, Double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco(){return preco;}

    public void setPreco(Double preco){this.preco = preco;}
}
