package br.com.jgmv.loja.testes;

import br.com.jgmv.loja.dao.CategoriaDao;
import br.com.jgmv.loja.dao.ProdutoDao;
import br.com.jgmv.loja.modelo.Categoria;
import br.com.jgmv.loja.modelo.Produto;
import br.com.jgmv.loja.util.JPAUtil;

import javax.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CadastroProduto {

    public static void main(String[] args) {
        cadastrarProdutos();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao pd = new ProdutoDao(em);

        Produto p = pd.buscarPorId(1l);
        List<Produto> todos = pd.buscaPorNomeDaCategoria("CELULARES");
        todos.forEach(todos1 -> System.out.println(todos1.getNome()));

        BigDecimal precoProduto = pd.buscaPrecoProdutoPorNome("Iphone 13");
        System.out.println("Preçoo do produto: " + precoProduto);
    }

    public static void cadastrarProdutos() {

        Categoria celulares = new Categoria("CELULARES");

        // Cria uma entidade transient
        Produto celular = new Produto("Iphone 13", "Proteção IP68", new BigDecimal(4000), celulares);

        EntityManager em = JPAUtil.getEntityManager();

        ProdutoDao pd = new ProdutoDao(em);
        CategoriaDao cd = new CategoriaDao(em);

        em.getTransaction().begin();
        cd.cadastrar(celulares);
        pd.cadastrar(celular);
        em.getTransaction().commit();
        em.close();


    }
}
