package projeto.ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.ecommerce.Entity.PedidoEntity;


@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer>, 
JpaSpecificationExecutor<PedidoEntity> {
    
    @Query(value = "select * from pedido where idpedido=?1", nativeQuery = true)
    Optional<PedidoEntity> loadInfo(int idpedido);

}
