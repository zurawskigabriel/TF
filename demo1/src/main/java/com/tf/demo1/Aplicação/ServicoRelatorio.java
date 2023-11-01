package com.tf.demo1.Aplicação;
import java.util.List;
import com.tf.demo1.Domínio.Orcamento;
import com.tf.demo1.Domínio.ServicoVendas;

public class ServicoRelatorio {
    private ServicoVendas vendas;
    public List<Orcamento> orcamentos;
    List<Orcamento> efetivados;

    public ServicoRelatorio (ServicoVendas vendas){
        this.vendas = vendas;
    }

    public List<Orcamento> filtraOrcamentos(){
        List<Orcamento> normais = vendas.consultaOrcamentos();
        
        for (Orcamento i: efetivados){
            if (i.isEfetivado()){
                efetivados.add(i);
            }
        }
        return efetivados;
    }
}
