package br.com.jgmv.loja.dao;

import br.com.jgmv.loja.modelo.Categoria;
import br.com.jgmv.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {
    private final EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }

    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }

    public void remover(Produto produto) {
        produto = this.em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscarPorId(Long id) {
        return em.find(Produto.class, id);
    }

    public List<Produto> buscaPorTodos() {
        String jpql = "SELECT p FROM Produto p";
        return em.createQuery(jpql, Produto.class).getResultList();

    }

    public List<Produto> buscaPorNome(String nome) {
        String jqpl = "SELECT p FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jqpl, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public List<Produto> buscaPorNomeDaCategoria(String nome) {
        String jqpl = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1";
        return em.createQuery(jqpl, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public BigDecimal buscaPrecoProdutoPorNome(String nome) {
        String jqpl = "SELECT p.preco FROM Produto p WHERE p.nome = ?1";
        return em.createQuery(jqpl,BigDecimal.class)
                .setParameter(1,nome)
                .getSingleResult();
    }

}
