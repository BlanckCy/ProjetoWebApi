package projeto.ecommerce.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carrinho")
public class CarrinhoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private int idcarrinho;
    private int idproduto;

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
}
