import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.tf.demo1.Dominio.Orcamento;
import com.tf.demo1.Dominio.ServicoVendas;

public class VerificarValidadeOrcamento implements Runnable {

    List<Orcamento> orcamentos;
    ServicoVendas servicoVendas;
    @Autowired
    public VerificarValidadeOrcamento (List<Orcamento> orcamentos, ServicoVendas servicoVendas){
        this.servicoVendas = servicoVendas;
        this.orcamentos = orcamentos;
    }
    
    @Override
    public void run() {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for (Orcamento i: orcamentos){
            long validade = 21;
            boolean baixaProcura = false;
            LocalDate dataHoje = LocalDate.now();
            String data = i.getData();
            LocalDate dataOrcamento = LocalDate.parse(data, formatador);
            if (dataOrcamento.getMonthValue() == 1 || dataOrcamento.getMonthValue() == 2) baixaProcura = true;
            long diasDeDiferenca = ChronoUnit.DAYS.between(dataOrcamento, dataHoje);

            if (baixaProcura == true){
                validade = 35;
            }

            if (diasDeDiferenca >= validade){
                servicoVendas.apagaOrcamento(i.getId());
            }
        }
    }
}
