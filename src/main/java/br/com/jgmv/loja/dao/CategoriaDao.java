package br.com.jgmv.loja.dao;

import br.com.jgmv.loja.modelo.Categoria;


import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager em; // "final" útil em classes que não devem ser modificadas ou estendidas por outras classes

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }
    public void cadastrar (Categoria categoria){
    public void cadastrar(Categoria categoria) {

        //Associa a entidade ao contexto de persistência (move para o estado managed)
        this.em.persist(categoria);
    }

    public void atualizar (Categoria categoria){
        this.em.merge(categoria);
    }

    public void remover (Categoria categoria){
    public void desanexar(Categoria categoria) {
        if (this.em.contains(categoria)) {
            this.em.detach(categoria);
        }
    }

    public void remover(Categoria categoria) {
        // Marca a entidade para remoção (move para o estado removed)
        categoria = this.em.merge(categoria);
        this.em.remove(categoria);
    }
}
