package projeto.ecommerce.Cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projeto.ecommerce.Entity.ClienteEntity;

@RestController
public class ClienteController {
    @Autowired
    ClienteService service;
   
    @GetMapping("/api/cliente/{codigo}")
    public ResponseEntity<Cliente> carregar(@PathVariable int codigo){
        Cliente obj = service.carregar(codigo);
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/api/cliente")
    public ResponseEntity<String> gravar(@RequestBody Cliente obj){
        String mensagem = service.gravar(obj);
        return ResponseEntity.ok(mensagem); 
    }
    
    
    @PutMapping("/api/cliente")
    public ResponseEntity<String> atualizar(@RequestBody Cliente obj){
        String mensagem = service.gravar(obj);
        return ResponseEntity.ok(mensagem); 
    }

    @DeleteMapping("/api/cliente/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        String menString = service.remover(codigo);
        return ResponseEntity.ok(menString);
    }


    @GetMapping("/api/clientes")
    public ResponseEntity<List<ClienteEntity>> listar(){
        return ResponseEntity.ok(service.listar());
    }


    @PostMapping("/api/cliente/login")
    public ResponseEntity<Cliente> fazerLogin(@RequestBody Cliente dto){
        return ResponseEntity.ok(service.fazerLogin(dto));
    }

}
