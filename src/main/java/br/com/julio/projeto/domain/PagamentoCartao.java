package br.com.julio.projeto.domain;

import br.com.julio.projeto.domain.enums.EstadoPagamento;

public class PagamentoCartao extends Pagamento {


    private static final long serialVersionUID = 1L;
    private Integer numeroDeParcelas;

    public PagamentoCartao ( ){

    
    }

    public PagamentoCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
    
}
