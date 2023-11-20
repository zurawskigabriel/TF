import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;

import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoVendas;

public class Agendador {

   
    ServicoVendas servicoVendas;
    List<Orcamento> orcamentos;

    @Autowired
    public Agendador (List<Orcamento> orcamentos, ServicoVendas servicoVendas){
        this.servicoVendas = servicoVendas;
        this.orcamentos = orcamentos;
    }

    public static void agendarVerificacaoOrcamento() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        VerificarValidadeOrcamento tarefa = new VerificarValidadeOrcamento(orcamentos, servicoVendas);

        // Agendar a tarefa para rodar uma vez por dia
        executorService.scheduleAtFixedRate(tarefa, 0, 1, TimeUnit.DAYS);
    }
}
