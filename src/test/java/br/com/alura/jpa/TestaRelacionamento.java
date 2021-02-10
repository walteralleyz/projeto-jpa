package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestaRelacionamento {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = em.find(Conta.class, Long.parseLong("1"));

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setValor(new BigDecimal(200.00));
        movimentacao.setConta(conta);

        em.getTransaction().begin();
        em.persist(movimentacao);
        em.getTransaction().commit();
    }
}
