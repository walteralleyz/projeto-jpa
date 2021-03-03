package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Movimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterMovimentacaoComConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Movimentacao movimentacao = em.find(Movimentacao.class, 1L);
        em.close();

        System.out.println(movimentacao.getConta().getTitular());
    }
}
