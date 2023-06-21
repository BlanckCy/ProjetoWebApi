package projeto.ecommerce.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projeto.ecommerce.Entity.ClienteEntity;
import projeto.ecommerce.Repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;
     
     public String gravar(Cliente dto){
        ClienteEntity entity = new ClienteEntity();
        
        entity.setIdcliente(dto.getIdcliente());
        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        repository.save(entity);

        return "ok";
     }

     public Cliente carregar(int codigo){
        Cliente dto = new Cliente();
        Optional<ClienteEntity> retorno = repository.findById(codigo);
        if(retorno.isPresent()){
            dto.setIdcliente(retorno.get().getIdcliente());
            dto.setNome(retorno.get().getNome());
            dto.setEmail(retorno.get().getEmail());
        }
        return dto;        
     }

    public String remover(int codigo) {
        ClienteEntity obj = new ClienteEntity();
        obj.setIdcliente(codigo);
        repository.delete(obj);
        return "ok";
    }

    public List<ClienteEntity> listar() {
        return  repository.findAll();
    }

    public Cliente fazerLogin(Cliente obj){
        Cliente dto = new Cliente();
        Optional<ClienteEntity> retorno = repository.fazerLogin(obj.getEmail(), obj.getSenha());
        if(retorno.isPresent()){
            dto.setIdcliente(retorno.get().getIdcliente());
            dto.setNome(retorno.get().getNome());
            dto.setEmail(retorno.get().getEmail());
        }
        return dto;    
    }

}
