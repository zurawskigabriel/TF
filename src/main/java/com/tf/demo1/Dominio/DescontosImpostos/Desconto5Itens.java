package com.tf.demo1.Dominio.DescontosImpostos;

import org.springframework.stereotype.Component;

@Component
public class Desconto5Itens implements IDesconto {
    public double calculaDesconto(double custoTotal) {
        return 0.05 * custoTotal;
    }
}
