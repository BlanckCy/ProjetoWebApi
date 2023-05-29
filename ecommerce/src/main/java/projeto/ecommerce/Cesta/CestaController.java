package projeto.ecommerce.Cesta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cesta/")
public class CestaController {
    CestaService service = new CestaService();

    @PostMapping("insert")
    public ResponseEntity<String>insert(@RequestBody Cesta obj){
        try{
            String msg = "Cesta "+ obj.getIdcarrinho() + " gravado com sucesso!";
            service.insert();

            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @PostMapping("update")
    public ResponseEntity<String>update(@RequestBody Cesta obj){
        try{
            String msg = "Cesta "+ obj.getIdcarrinho() + " atualizado com sucesso!";
            service.update();

            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @PostMapping("delete")
    public ResponseEntity<String>delete(@RequestBody Cesta obj){
        try{
            String msg = "Cesta "+ obj.getIdcarrinho() + " deletado com sucesso!";
            service.delete();

            return ResponseEntity.ok(msg);
        }catch(Exception err){
            return (ResponseEntity<String>) ResponseEntity.internalServerError();
        }
    }

    @PostMapping("loadinfo")
    public ResponseEntity<Cesta>loadInfo(@RequestBody Cesta obj){
        try{            
            obj.setIdcarrinho(1);
            service.loadInfo();

            return ResponseEntity.ok(obj);
        }catch(Exception err){
            return (ResponseEntity<Cesta>) ResponseEntity.internalServerError();
        }
    }
}
