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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import projeto.ecommerce.Entity.ClienteEntity;

@RestController
@RequestMapping("/api/cliente/")
public class ClienteController {
    @Autowired
    ClienteService service;
   
    @GetMapping("loadinfo/{codigo}/")
    public ResponseEntity<Cliente> carregar(@PathVariable int codigo){
        try{
            Cliente obj = service.loadInfo(codigo);
            return ResponseEntity.ok(obj);
        }catch(Exception err){
            return (ResponseEntity<Cliente>) ResponseEntity.internalServerError();
        }
    }

    @PostMapping("insert/")
    public ResponseEntity<String> insert(@RequestBody Cliente obj){
        try{
            String msg = service.insert(obj);
            return ResponseEntity.ok(msg); 
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }
    
    @PutMapping("update/")
    public ResponseEntity<String> update(@RequestBody Cliente obj){
        try{
            String msg = service.insert(obj);
            return ResponseEntity.ok(msg); 
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @DeleteMapping("delete/{codigo}")
    public ResponseEntity<String> delete(@PathVariable int codigo){
        try{    
            String msg = service.delete(codigo);
            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }


    @GetMapping("loadinfo/")
    public ResponseEntity<List<ClienteEntity>> listar(){
        try{
            return ResponseEntity.ok(service.listar());
        }catch(Exception err){
            return (ResponseEntity<List<ClienteEntity>>) ResponseEntity.internalServerError();
        }
    }


    @PostMapping("login/")
    public ResponseEntity<Cliente> fazerLogin(@RequestBody Cliente dto){
        try{
            return ResponseEntity.ok(service.fazerLogin(dto));
        }catch(Exception err){
            return (ResponseEntity<Cliente>) ResponseEntity.internalServerError();
        }
    }

}
