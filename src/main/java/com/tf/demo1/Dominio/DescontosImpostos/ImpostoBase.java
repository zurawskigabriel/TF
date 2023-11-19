package com.tf.demo1.Dominio.DescontosImpostos;

import org.springframework.stereotype.Component;

@Component
public class ImpostoBase implements IImposto {
    public double calculaImposto(double custoTotal){
        return 0.1 * custoTotal;
    }
}
