package projeto.ecommerce.Carrinho;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/carrinho/")
public class CarrinhoController {
    CarrinhoService service = new CarrinhoService();

    @PostMapping("insert/")
    public ResponseEntity<String>insert(@RequestBody Carrinho obj){
        try{
            String msg = service.insert(obj);

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
    public ResponseEntity<Carrinho>loadInfo(@PathVariable int codigo){
        try{            
            Carrinho obj = service.loadInfo(codigo);

            return ResponseEntity.ok(obj);
        }catch(Exception err){
            return (ResponseEntity<Carrinho>) ResponseEntity.internalServerError();
        }
    }
}
