package br.com.jgmv.loja.vo;

import java.time.LocalDate;

public class RelatorioVo {

    private String nomeProduto;
    private Long quantidadeVenda;
    private LocalDate ultimaVenda;

    public RelatorioVo(String nomeProduto, Long quantidadeVenda, LocalDate ultimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidadeVenda = quantidadeVenda;
        this.ultimaVenda = ultimaVenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Long getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public LocalDate getUltimaVenda() {
        return ultimaVenda;
    }

    @Override
    public String toString() {
        return "RelatorioVo{" +
                "nomeProduto='" + nomeProduto + '\'' +
                ", quantidadeVenda=" + quantidadeVenda +
                ", ultimaVenda=" + ultimaVenda +
                '}';
    }
}
