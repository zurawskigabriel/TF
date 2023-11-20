package com.tf.demo1.Dominio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ItemPedido {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Setter private Long codProduto;
	@Setter private int quantidade;
	@Setter private double preco;

	@Setter
	@ManyToOne
	@JoinColumn(name = "orcamento_id")
	@JsonBackReference
	private Orcamento orcamento;

	/*
	 * Construtor usado para o endpoint POST /loja/solicitar-orcamento
	 */
	public ItemPedido(Long codProduto, int quantidade, double preco) {
		this.codProduto = codProduto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
}