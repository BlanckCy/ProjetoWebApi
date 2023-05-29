package projeto.ecommerce.Pedido;

public class Pedido {
    private int idpedido;
    private int idcliente;
    private int idcarrinho;
    private float valorTotal;

    public int getIdpedido() {
        return idpedido;
    }
    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }
    public int getIdcliente() {
        return idcliente;
    }
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public int getIdcarrinho() {
        return idcarrinho;
    }
    public void setIdcarrinho(int idcarrinho) {
        this.idcarrinho = idcarrinho;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }    
}
