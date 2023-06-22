package projeto.ecommerce.Carrinho;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.ecommerce.Entity.CarrinhoEntity;
import projeto.ecommerce.Repository.CarrinhoRepository;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository repository;
    private Carrinho dto;
    private CarrinhoEntity obj;

    public String insert(Carrinho dto){
        obj.setIdcarrinho(dto.getIdcarrinho());
        obj.setIdproduto(dto.getIdproduto());

        return "ok";
    }

    public String delete(int idcarrinho){
        obj.setIdcarrinho(idcarrinho);
        repository.delete(obj);

        return "ok";
    }

    public Carrinho loadInfo(int idcarrinho){
        Optional<CarrinhoEntity> retorno = repository.findById(idcarrinho);
        if(retorno.isPresent()){
            dto.setIdcarrinho(retorno.get().getIdcarrinho());
            dto.setIdproduto(retorno.get().getIdproduto());
        }

        return dto;
    }
}
