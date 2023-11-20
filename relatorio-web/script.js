document.addEventListener('DOMContentLoaded', function() {
    fetch('http://localhost:8080/loja/dados-relatorio')
        .then(response => response.json())
        .then(data => {
            const table = document.getElementById('orcamentoTable');
            data.forEach(item => {
                const row = table.insertRow();
                row.insertCell().textContent = item.dataOrcamento;
                row.insertCell().textContent = item.valorBruto.toFixed(2);
                row.insertCell().textContent = item.valorImposto.toFixed(2);
                row.insertCell().textContent = item.desconto.toFixed(2);
                row.insertCell().textContent = item.valorPago.toFixed(2);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
});
