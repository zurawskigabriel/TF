package com.tf.demo1.Aplicacao;
import java.util.ArrayList;
import java.util.List;

import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoVendas;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicoRelatorio {

    public class DadosRelatorio {
        String dataOrcamento;
        double valorBruto;
        double valorImposto;
        double desconto;
        double valorPago;

        public DadosRelatorio(String aDataOrcamento, double oValorBruto, double oValorImposto, double oDesconto, double oValorPago){
            dataOrcamento = aDataOrcamento;
            valorBruto = oValorBruto;
            valorImposto = oValorImposto;
            desconto = oDesconto;
            valorPago = oValorPago;
        }

    }

    private ServicoVendas vendas;
    public List<Orcamento> orcamentos;
    List<Orcamento> efetivados;

    @Autowired
    public ServicoRelatorio (ServicoVendas vendas){
        this.vendas = vendas;
        filtraOrcamentos();
    }

    public void filtraOrcamentos(){
        List<Orcamento> normais = vendas.consultaOrcamentos();

        for (Orcamento i: normais){
            if (i.isEfetivado()){
                efetivados.add(i);
            }
        }
    }

    public List<DadosRelatorio> orcamentosDados(List<Orcamento> orcamentosEfetivados){
        List<DadosRelatorio> dadosRelatorios = new ArrayList<DadosRelatorio>();
        for (Orcamento i: orcamentosEfetivados){
            dadosRelatorios.add(new DadosRelatorio(i.getData(), i.getCustoPedido(), i.getCustoPedido(), i.getDesconto(), i.getTotalPagar()));
        }

        return dadosRelatorios;
    }
}
