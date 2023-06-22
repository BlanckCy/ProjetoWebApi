package projeto.ecommerce.Pedido;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.ecommerce.Entity.PedidoEntity;
import projeto.ecommerce.Repository.PedidoRepository;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository repository;
    private Pedido dto;
    private PedidoEntity obj;

    public String insert(Pedido dto){
        obj.setIdpedido(dto.getIdpedido());
        obj.setIdcliente(dto.getIdcliente());
        obj.setQtd(dto.getQtd());
        obj.setValorTotal(dto.getValorTotal());

        return "ok";
    }

    public String delete(int idpedido){
        obj.setIdpedido(idpedido);
        repository.delete(obj);

        return "ok";
    }

    public Pedido loadInfo(int idpedido){
        Optional<PedidoEntity> retorno = repository.findById(idpedido);
        if(retorno.isPresent()){
            dto.setIdpedido(retorno.get().getIdpedido());
            dto.setIdcliente(retorno.get().getIdcliente());
            dto.setQtd(retorno.get().getQtd());
            dto.setValorTotal(retorno.get().getValorTotal());
        }

        return dto;
    }
}
