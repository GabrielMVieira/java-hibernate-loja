package br.com.jgmv.loja.testes;

import br.com.jgmv.loja.dao.ProdutoDao;
import br.com.jgmv.loja.modelo.Categoria;
import br.com.jgmv.loja.modelo.Produto;
import br.com.jgmv.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.math.BigDecimal;

public class CadastroProduto {

    public static void main(String[] args) {

        Produto celular = new Produto("Iphone 12", "Proteção IP68", new BigDecimal(4000), Categoria.CELULARES);


        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao pd = new ProdutoDao(em);
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        pd.cadastrar(celular);
        transaction.commit();
        em.close();

    }
}
