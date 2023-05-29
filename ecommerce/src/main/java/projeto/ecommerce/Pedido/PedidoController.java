package projeto.ecommerce.Pedido;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido/")
public class PedidoController {
    PedidoService service = new PedidoService();

    @PostMapping("insert")
    public ResponseEntity<String>insert(@RequestBody Pedido obj){
        try{
            String msg = "Produto "+ obj.getIdpedido() + " gravado com sucesso!";
            service.insert();

            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @PostMapping("update")
    public ResponseEntity<String>update(@RequestBody Pedido obj){
        try{
            String msg = "Produto "+ obj.getIdpedido() + " atualizado com sucesso!";
            service.update();

            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @PostMapping("delete")
    public ResponseEntity<String>delete(@RequestBody Pedido obj){
        try{
            String msg = "Produto "+ obj.getIdpedido() + " deletado com sucesso!";
            service.delete();

            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @PostMapping("loadinfo")
    public ResponseEntity<Pedido>loadInfo(@RequestBody Pedido obj){
        try{
            obj.setIdpedido(0);
            service.loadInfo();

            return ResponseEntity.ok(obj);
        }catch(Exception err){
            return (ResponseEntity<Pedido>) ResponseEntity.internalServerError();
        }
    }
}
