package com.tf.demo1.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDeEstoque {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Setter private Long codProduto;
	@Setter private int quantidadeAtual;
	@Setter private int estoqueMinimo;
	@Setter private int estoqueMaximo;
}