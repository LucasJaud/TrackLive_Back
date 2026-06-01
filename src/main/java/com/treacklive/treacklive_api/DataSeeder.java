package com.treacklive.treacklive_api;

import com.treacklive.treacklive_api.entity.Produto;
import com.treacklive.treacklive_api.repository.ProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedProdutos(ProdutoRepository repo) {
        return args -> {
            if (repo.count() > 0) return;

            repo.saveAll(List.of(
                    new Produto(null, "Tênis Speed Pro X1", new BigDecimal("349.90"),
                            new BigDecimal("499.90"), "Calçados", "👟", "OFERTA", 5, 128, true),
                    new Produto(null, "Camiseta Dry Fit Performance", new BigDecimal("89.90"),
                            null, "Vestuário", "👕", null, 4, 74, true),
                    new Produto(null, "Bicicleta Speed Carbon 21v", new BigDecimal("2899.90"),
                            new BigDecimal("3499.90"), "Equipamentos", "🚴", "DESTAQUE", 5, 43, true),
                    new Produto(null, "Halteres Emborrachados 10kg", new BigDecimal("159.90"),
                            null, "Equipamentos", "🏋️", null, 4, 91, true),
                    new Produto(null, "Óculos de Natação Pro", new BigDecimal("79.90"),
                            null, "Acessórios", "🥽", null, 4, 56, true),
                    new Produto(null, "Luvas de Boxe Training", new BigDecimal("129.90"),
                            null, "Acessórios", "🥊", "NOVO", 5, 32, true),
                    new Produto(null, "Joelheira de Compressão", new BigDecimal("59.90"),
                            null, "Acessórios", "🦵", null, 4, 88, true),
                    new Produto(null, "Garrafa Térmica 750ml", new BigDecimal("49.90"),
                            null, "Acessórios", "🍶", null, 4, 210, true),
                    new Produto(null, "Smartwatch Sport Track", new BigDecimal("899.90"),
                            new BigDecimal("1199.90"), "Tecnologia", "⌚", "HOT", 5, 67, true)
            ));
        };
    }
}