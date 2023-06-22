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
    private Cliente dto;
    private ClienteEntity obj;
     
     public String insert(Cliente dto){        
        obj.setIdcliente(dto.getIdcliente());
        obj.setEmail(dto.getEmail());
        obj.setNome(dto.getNome());
        repository.save(obj);

        return "ok";
     }

     public Cliente loadInfo(int idcliente){
        Optional<ClienteEntity> retorno = repository.findById(idcliente);
        if(retorno.isPresent()){
            dto.setIdcliente(retorno.get().getIdcliente());
            dto.setNome(retorno.get().getNome());
            dto.setEmail(retorno.get().getEmail());
        }
        return dto;        
     }

    public String delete(int idcliente) {
        obj.setIdcliente(idcliente);
        repository.delete(obj);
        return "ok";
    }

    public List<ClienteEntity> listar() {
        return  repository.findAll();
    }

    public Cliente fazerLogin(Cliente obj){
        Optional<ClienteEntity> retorno = repository.fazerLogin(obj.getEmail(), obj.getSenha());
        if(retorno.isPresent()){
            dto.setIdcliente(retorno.get().getIdcliente());
            dto.setNome(retorno.get().getNome());
            dto.setEmail(retorno.get().getEmail());
        }
        return dto;    
    }
}
