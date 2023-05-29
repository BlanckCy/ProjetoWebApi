package projeto.ecommerce.Produto;

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

import projeto.ecommerce.Entity.ProdutoEntity;

@RestController
@RequestMapping("/api/produto/")
public class ProdutoController {
    @Autowired
    ProdutoService service;

    @PostMapping("insert/")
    public ResponseEntity<String>insert(@RequestBody Produto obj){
        try{
            String msg = service.insert(obj);
            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @PutMapping("update/")
    public ResponseEntity<String>update(@RequestBody Produto obj){
        try{
            String msg = service.update(obj);
            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @DeleteMapping("delete/{codigo}/")
    public ResponseEntity<String>delete(@PathVariable int codigo){
        try{
            String msg = service.delete(codigo);
            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @GetMapping("loadinfo/{codigo}/")
    public ResponseEntity<Produto>loadInfo(@PathVariable int codigo){
        try{
            Produto obj = service.loadInfo(codigo);
            return ResponseEntity.ok(obj);
        }catch(Exception err){
            return (ResponseEntity<Produto>) ResponseEntity.internalServerError();
        }
    }

    @GetMapping("loadinfo/")
    public ResponseEntity<List<ProdutoEntity>> listar(){
        return ResponseEntity.ok(service.loadInfo());
    }
}
