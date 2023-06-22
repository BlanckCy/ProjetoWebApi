package projeto.ecommerce.Pedido;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido/")
public class PedidoController {
    PedidoService service = new PedidoService();

    @PostMapping("insert/")
    public ResponseEntity<String>insert(@RequestBody Pedido obj){
        try{
            String msg = service.insert(obj);

            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @PutMapping("update/")
    public ResponseEntity<String>update(@RequestBody Pedido obj){
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
    public ResponseEntity<Pedido>loadInfo(@PathVariable int codigo){
        try{
            Pedido obj = service.loadInfo(codigo);

            return ResponseEntity.ok(obj);
        }catch(Exception err){
            return (ResponseEntity<Pedido>) ResponseEntity.internalServerError();
        }
    }
}
