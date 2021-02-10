package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarContaSemSaldo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta contaDoWalter = em.find(Conta.class, Long.parseLong("1"));

        em.getTransaction().begin();

        contaDoWalter.setSaldo(20.0f);

        em.getTransaction().commit();
    }
}
