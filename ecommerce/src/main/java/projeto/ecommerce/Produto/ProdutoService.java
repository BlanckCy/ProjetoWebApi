package projeto.ecommerce.Produto;

import projeto.ecommerce.Entity.ProdutoEntity;
import projeto.ecommerce.Repository.ProdutoRepository;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public String insert(Produto dto){
        ProdutoEntity entity = new ProdutoEntity();
        
        entity.setIdproduto(dto.getIdproduto());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setCategoria(dto.getCategoria());
        entity.setQuantidade(dto.getQuantidade());
        entity.setValor(dto.getValor());
        entity.setUrl(dto.getUrl());
        repository.save(entity);

        return "ok";
    }

    public String update(Produto dto){
        ProdutoEntity entity = new ProdutoEntity();
        
        entity.setIdproduto(dto.getIdproduto());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setValor(dto.getValor());
        entity.setUrl(dto.getUrl());
        repository.save(entity);

        return "ok";
    }

    public String delete(int idproduto){
        ProdutoEntity entity = new ProdutoEntity();

        entity.setIdproduto(idproduto);
        repository.delete(entity);

        return "ok";
    }

    public Produto loadInfo(int idproduto){
        Produto dto = new Produto();

        Optional<ProdutoEntity> retorno = repository.findById(idproduto);
        if(retorno.isPresent()){
            dto.setIdproduto(retorno.get().getIdproduto());
            dto.setNome(retorno.get().getNome());
            dto.setDescricao(retorno.get().getDescricao());
            dto.setValor(retorno.get().getValor());
            dto.setUrl(retorno.get().getUrl());   
        }
        return dto;
    }

    public List<ProdutoEntity> loadInfo(){
        return  repository.findAll();
    }
}
