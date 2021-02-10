package br.com.alura.jpa;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

public class TestaRelacionamentoMovimentacaoCategoria {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = em.find(Conta.class, 1L);

        Categoria viagem = new Categoria("Viagem");
        Categoria negocios = new Categoria("Negócios");

        em.getTransaction().begin();

        em.persist(viagem);
        em.persist(negocios);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setConta(conta);
        movimentacao.setValor(new BigDecimal(300.00));
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Viagem para SP");
        movimentacao.setCategorias(Arrays.asList(viagem, negocios));

        em.persist(movimentacao);

        em.getTransaction().commit();
        em.close();
    }
}
