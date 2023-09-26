package br.com.jgmv.loja.testes;

import br.com.jgmv.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroProduto {

    public static void main(String[] args) {

        Produto celular = new Produto();

        celular.setNome("Iphone 11");
        celular.setDescricao("Aparelho com processador A13");
        celular.setPreco(new BigDecimal(3000));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mercado");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(celular);
        transaction.commit();
        em.close();

    }
}
