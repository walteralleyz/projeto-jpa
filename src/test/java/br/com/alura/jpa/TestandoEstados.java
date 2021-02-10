package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestandoEstados {
    public static void main(String[] args) {
        // transient -> candidata para virar managed
        Conta conta = new Conta();

        conta.setTitular("Almiro");
        conta.setNumero(1122);
        conta.setAgencia(2211);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // transient <-> managed
        em.persist(conta);

        // managed <-> removed
        em.remove(conta);

        em.getTransaction().commit();
    }
}
