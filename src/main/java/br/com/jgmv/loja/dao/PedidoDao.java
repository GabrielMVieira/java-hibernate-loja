package br.com.jgmv.loja.dao;

import br.com.jgmv.loja.modelo.Pedido;
import br.com.jgmv.loja.vo.RelatorioVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }

    public BigDecimal buscarPorValorTotal(){
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<RelatorioVo> relatorioDeVendas(){
        String jpql = "SELECT new br.com.jgmv.loja.vo.RelatorioVo (" +
                "produto.nome, " +
                "SUM(itemPedidos.quantidade) as quantidadeTotal, " +
                "MAX(pedido.data)) " +
                "FROM Pedido pedido " +
                "JOIN pedido.itemPedidos itemPedidos " +
                "JOIN itemPedidos.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY quantidadeTotal DESC ";
        return em.createQuery(jpql, RelatorioVo.class)
                .getResultList();
    }

    public Pedido buscarPedidoComCliente(long id) {
        return em.createQuery("SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id", Pedido.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
