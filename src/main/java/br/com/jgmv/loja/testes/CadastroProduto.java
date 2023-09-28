package br.com.jgmv.loja.testes;

import br.com.jgmv.loja.dao.CategoriaDao;
import br.com.jgmv.loja.dao.ProdutoDao;
import br.com.jgmv.loja.modelo.Categoria;
import br.com.jgmv.loja.modelo.Produto;
import br.com.jgmv.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.math.BigDecimal;

public class CadastroProduto {

    public static void main(String[] args) {

        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Iphone 12", "Proteção IP68", new BigDecimal(4000),celulares);

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction transaction = em.getTransaction();

        ProdutoDao pd = new ProdutoDao(em);
        CategoriaDao cd = new CategoriaDao(em);

        transaction.begin();
        cd.cadastrar(celulares);
        pd.cadastrar(celular);
        transaction.commit();
        em.close();

    }
}
