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

    public String insert(Carrinho dto){
        CarrinhoEntity entity = new CarrinhoEntity();

        entity.setIdcarrinho(dto.getIdcarrinho());
        entity.setIdproduto(dto.getIdproduto());
        entity.setQtd(dto.getQtd());
        entity.setValorTotal(dto.getValorTotal());

        return "ok";
    }

    public String delete(int idcarrinho){
        CarrinhoEntity obj = new CarrinhoEntity();
        obj.setIdcarrinho(idcarrinho);
        repository.delete(obj);

        return "ok";
    }

    public Carrinho loadInfo(int idcarrinho){
        Optional<CarrinhoEntity> retorno = repository.findById(idcarrinho);
        if(retorno.isPresent()){
            dto.setIdcarrinho(retorno.get().getIdcarrinho());
            dto.setIdproduto(retorno.get().getIdproduto());
            dto.setQtd(retorno.get().getQtd());
            dto.setValorTotal(retorno.get().getValorTotal());
        }

        return dto;
    }
}
