package projeto.ecommerce.Carrinho;

public class Carrinho {
    private int idcarrinho;
    private int idproduto;
    private int qtd;
    private float valorTotal;

    public int getIdcarrinho() {
        return idcarrinho;
    }
    public void setIdcarrinho(int idcarrinho) {
        this.idcarrinho = idcarrinho;
    }
    public int getIdproduto() {
        return idproduto;
    }
    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }   
}
