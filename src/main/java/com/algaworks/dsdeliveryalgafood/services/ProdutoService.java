package com.algaworks.dsdeliveryalgafood.services;

import com.algaworks.dsdeliveryalgafood.entities.FormaPagamento;
import com.algaworks.dsdeliveryalgafood.entities.Produto;
import com.algaworks.dsdeliveryalgafood.entities.Restaurante;
import com.algaworks.dsdeliveryalgafood.exceptions.EntityNotFoundException;
import com.algaworks.dsdeliveryalgafood.exceptions.RegraDeNegocioException;
import com.algaworks.dsdeliveryalgafood.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final RestauranteService restauranteService;
    private final ProdutoRepository repository;

    @Transactional(readOnly = true)
    public List<Produto> listar(Long restauranteId){
        Restaurante restaurante = restauranteService.buscarPorId(restauranteId);

        return restaurante.getProdutos();
    }

    @Transactional
    public Produto adicionarProdutoEmRestaurante(Long restauranteId, Produto produto){
        Restaurante restaurante = restauranteService.buscarPorId(restauranteId);

        restaurante.adicionarProduto(produto);

        return repository.save(produto);
    }

    @Transactional
    public void removerProdutoEmRestaurante(Long restauranteId, Long produtoId){
        Restaurante restaurante = restauranteService.buscarPorId(restauranteId);
        Produto produto = buscarPorId(produtoId);

        if(!produto.getRestaurante().equals(restaurante)){
            throw new RegraDeNegocioException("Produto não pertence ao restaurante selecionado");
        }

        repository.delete(produto);
    }

    @Transactional(readOnly = true)
    public Produto buscarPorId(Long id){
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Produto com ID " + id + " não encontrado"));

    }
}
