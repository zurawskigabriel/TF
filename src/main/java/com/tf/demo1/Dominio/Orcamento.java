package com.tf.demo1.Dominio;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Orcamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter private String nomeCliente;
    @Setter private double custoPedido;
    @Setter private double custoImposto;
    @Setter private double desconto;
    @Setter private double totalPagar;
    @Setter private boolean efetivado;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL, orphanRemoval = true)
    @Setter private List<ItemPedido> itens;

    @Setter private String data;
}