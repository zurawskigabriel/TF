package com.tf.demo1.Aplicacao.Relatorio;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DadosRelatorio {
    private String dataOrcamento;
    private double valorBruto;
    private double valorImposto;
    private double desconto;
    private double valorPago;
}