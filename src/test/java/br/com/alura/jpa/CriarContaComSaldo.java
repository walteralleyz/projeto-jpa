package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarContaComSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setAgencia(54321);
        conta.setNumero(12345);
        conta.setTitular("Osvaldo");
        conta.setSaldo(100.00f);

        em.persist(conta);
        em.getTransaction().commit();

        em.close();

        EntityManager em2 = emf.createEntityManager();
        conta.setSaldo(250.0f);

        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();

        em2.close();
    }
}
