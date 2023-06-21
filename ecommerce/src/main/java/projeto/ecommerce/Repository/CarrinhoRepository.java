package projeto.ecommerce.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projeto.ecommerce.Entity.CarrinhoEntity;


@Repository
public interface CarrinhoRepository extends JpaRepository<CarrinhoEntity, Integer>, 
JpaSpecificationExecutor<CarrinhoEntity> {
    
    @Query(value = "select * from carrinho where idcarrinho=?1", nativeQuery = true)
    Optional<CarrinhoEntity> loadInfo(int idcarrinho);

}
