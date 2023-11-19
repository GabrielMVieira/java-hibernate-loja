package br.com.jgmv.loja.testes;

import br.com.jgmv.loja.dao.CategoriaDao;
import br.com.jgmv.loja.dao.ClienteDao;
import br.com.jgmv.loja.dao.PedidoDao;
import br.com.jgmv.loja.dao.ProdutoDao;
import br.com.jgmv.loja.modelo.*;
import br.com.jgmv.loja.util.JPAUtil;
import br.com.jgmv.loja.vo.RelatorioVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        Produto produto = produtoDao.buscarPorId(1L);
        Cliente cliente = clienteDao.buscarPorId(1L);

        em.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.adicionaItem(new ItemPedido(20, pedido, produto));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();

        BigDecimal totalVendido = pedidoDao.buscarPorValorTotal();
        System.out.println(" VALOR TOTAL: " + totalVendido);

        List<RelatorioVo> relatorioVoList = pedidoDao.relatorioDeVendas();
        relatorioVoList.forEach(System.out::println);

    }

    private static void popularBancoDeDados() {

        Categoria celulares = new Categoria("CELULARES");
        Categoria processadores = new Categoria("PROCESSADORES");


        // Cria uma entidade transient
        Produto processador = new Produto("Ryzen 5 5500u", "AMD", new BigDecimal(2000), processadores);

        Cliente cliente = new Cliente("José", "489788");

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao pd = new ProdutoDao(em);
        CategoriaDao cd = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();
        cd.cadastrar(processadores);
        pd.cadastrar(processador);
        clienteDao.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();


    }
}
