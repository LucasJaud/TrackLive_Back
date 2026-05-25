package com.treacklive.treacklive_api.service;

import com.treacklive.treacklive_api.dto.ProdutoDTO;
import com.treacklive.treacklive_api.entity.Produto;
import com.treacklive.treacklive_api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findByAtivoTrue()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public List<ProdutoDTO> listarPorCategoria(String categoria) {
        return produtoRepository.findByCategoriaAndAtivoTrue(categoria)
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private ProdutoDTO toDTO(Produto p) {
        return new ProdutoDTO(
                p.getId(),
                p.getNome(),
                p.getPreco(),
                p.getPrecoAntigo(),
                p.getCategoria(),
                p.getImagem(),
                p.getBadge(),
                p.getAvaliacao(),
                p.getReviews()
        );
    }
}