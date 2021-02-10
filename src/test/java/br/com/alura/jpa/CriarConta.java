package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarConta {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setAgencia(4321);
        conta.setNumero(1234);
        conta.setTitular("Walter");

        em.persist(conta);
        em.getTransaction().commit();

        em.close();
    }
}
