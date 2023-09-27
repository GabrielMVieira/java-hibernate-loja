package br.com.jgmv.loja.dao;

import br.com.jgmv.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar (Produto produto){
        em.persist(produto);
    }
}
