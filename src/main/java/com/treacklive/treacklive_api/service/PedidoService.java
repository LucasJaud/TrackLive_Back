package com.treacklive.treacklive_api.service;

import com.treacklive.treacklive_api.dto.PedidoRequestDTO;
import com.treacklive.treacklive_api.dto.PedidoResponseDTO;
import com.treacklive.treacklive_api.entity.ItemPedido;
import com.treacklive.treacklive_api.entity.Pedido;
import com.treacklive.treacklive_api.entity.Produto;
import com.treacklive.treacklive_api.entity.Usuario;
import com.treacklive.treacklive_api.exception.ProdutoNaoEncontradoException;
import com.treacklive.treacklive_api.repository.PedidoRepository;
import com.treacklive.treacklive_api.repository.ProdutoRepository;
import com.treacklive.treacklive_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public PedidoResponseDTO criarPedido(String email, PedidoRequestDTO dto) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus("PENDENTE");

        List<ItemPedido> itens = dto.getItens().stream().map(itemDTO -> {
            Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                    .orElseThrow(() -> new ProdutoNaoEncontradoException(itemDTO.getProdutoId()));

            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setProduto(produto);
            item.setQuantidade(itemDTO.getQuantidade());
            item.setPrecoUnitario(produto.getPreco());
            return item;
        }).toList();

        BigDecimal total = itens.stream()
                .map(i -> i.getPrecoUnitario().multiply(BigDecimal.valueOf(i.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        pedido.setItens(itens);
        pedido.setTotal(total);

        Pedido salvo = pedidoRepository.save(pedido);

        return new PedidoResponseDTO(
                salvo.getId(),
                salvo.getStatus(),
                salvo.getTotal(),
                salvo.getDataPedido(),
                itens.size()
        );
    }
}