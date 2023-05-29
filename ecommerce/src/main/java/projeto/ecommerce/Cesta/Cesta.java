package projeto.ecommerce.Cesta;

public class Cesta {
    private int idcarrinho;
    private int idproduto;
    private int qtd;
    private float valorProduto;

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
    public float getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(float valorProduto) {
        this.valorProduto = valorProduto;
    }    
}
