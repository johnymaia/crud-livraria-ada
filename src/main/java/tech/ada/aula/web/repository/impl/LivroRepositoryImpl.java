package tech.ada.aula.web.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;
import tech.ada.aula.web.model.dto.LivroDTO;
import tech.ada.aula.web.model.entity.Livro;
import tech.ada.aula.web.repository.LivroRepositoryCustom;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroRepositoryImpl implements LivroRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Livro> buscarPorNomeOuIsbn(String nome, String isbn) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Livro> cq = cb.createQuery(Livro.class);
        Root<Livro> root = cq.from(Livro.class);

        List<Predicate> predicates = new ArrayList<>();

        if (!nome.isEmpty()) {
            predicates.add(cb.like(root.get("nome"), "%" + nome + "%"));
        }

        if (!isbn.isEmpty()) {
            predicates.add(cb.like(root.get("isbn"), "%" + isbn + "%"));
        }

        cq.where(cb.or(predicates.toArray(new Predicate[0])));

        return em.createQuery(cq).getResultList();
    }
}
