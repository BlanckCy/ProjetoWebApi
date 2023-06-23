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
     
    public String insert(Cliente dto){        
        ClienteEntity obj = new ClienteEntity();
        obj.setIdcliente(dto.getIdcliente());
        obj.setEmail(dto.getEmail());
        obj.setNome(dto.getNome());
        repository.save(obj);

        return "ok";
     }

     public Cliente loadInfo(int idcliente){
        Optional<ClienteEntity> retorno = repository.findById(idcliente);
        Cliente dto = new Cliente();
        if(retorno.isPresent()){
            ClienteEntity clienteEntity = retorno.get();
            dto.setIdcliente(clienteEntity.getIdcliente());
            dto.setNome(clienteEntity.getNome());
            dto.setEmail(clienteEntity.getEmail());
        }
        return dto;        
     }

    public String delete(int idcliente) {
        repository.deleteById(idcliente);
        return "ok";
    }

    public List<ClienteEntity> listar() {
        return  repository.findAll();
    }

    public Cliente fazerLogin(Cliente obj) {
        Optional<ClienteEntity> retorno = repository.fazerLogin(obj.getEmail(), obj.getSenha());
        if (retorno.isPresent()) {
            ClienteEntity clienteEntity = retorno.get();
            obj.setIdcliente(retorno.get().getIdcliente());
            obj.setNome(retorno.get().getNome());
            obj.setEmail(retorno.get().getEmail());
            obj.setIdcliente(retorno.get().getIdcliente());
            obj.setSobrenome(retorno.get().getSobrenome());
            obj.setTelefone(retorno.get().getTelefone());
        }
        return obj;    
    }

}
