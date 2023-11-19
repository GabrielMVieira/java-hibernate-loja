package br.com.jgmv.loja.testes;

import br.com.jgmv.loja.dao.CategoriaDao;
import br.com.jgmv.loja.dao.ClienteDao;
import br.com.jgmv.loja.dao.PedidoDao;
import br.com.jgmv.loja.dao.ProdutoDao;
import br.com.jgmv.loja.modelo.Categoria;
import br.com.jgmv.loja.modelo.Cliente;
import br.com.jgmv.loja.modelo.Pedido;
import br.com.jgmv.loja.modelo.Produto;
import br.com.jgmv.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PeformanceConsulta {

    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedido pedido = pedidoDao.buscarPedidoComCliente(1L);
        System.out.println(pedido.getItemPedidos().size());
    }

    private static void popularBancoDeDados() {
        Categoria categoria = new Categoria("TENIS");
        Categoria categoria2 = new Categoria("CAMISAS");
        Categoria categoria3 = new Categoria("LIVROS");

        Produto produto = new Produto("Air Force 1", "Tenis inspirado no caça", new BigDecimal(800), categoria);
        Produto produto2 = new Produto("Camiseta BAW", "Camisa regata", new BigDecimal(100), categoria2);
        Produto produto3 = new Produto("O Deus que destroi sonhos", "Editora Thomas Nelson", new BigDecimal(20), categoria3);

        Cliente cliente = new Cliente("Debora", "1111");
        Cliente cliente2 = new Cliente("ALlyson", "8888");
        Cliente cliente3 = new Cliente("Graciele", "897");

        EntityManager em = JPAUtil.getEntityManager();

        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(categoria);
        categoriaDao.cadastrar(categoria2);
        categoriaDao.cadastrar(categoria3);

        produtoDao.cadastrar(produto);
        produtoDao.cadastrar(produto2);
        produtoDao.cadastrar(produto3);

        clienteDao.cadastrar(cliente);
        clienteDao.cadastrar(cliente2);
        clienteDao.cadastrar(cliente3);

        em.getTransaction().commit();
        em.close();
    }


}
