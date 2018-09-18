package me.shackox.graphql.demographql.dao;

import me.shackox.graphql.demographql.domain.Prebook;

import java.util.List;

public interface PrebookDao {
    List<Prebook> allPrebooksHeader();

    List<Prebook> allPrebooksWithDetails();

    Long countAllPrebooks();

    Prebook getPrebookById(Long id);

    Long createPrebook(Prebook prebook);

    Prebook updatePrebookHeader(Long prebookId, Prebook prebook);

    Prebook updatePrebookWithItems(Long prebookId, Prebook prebook);

    boolean deletePrebook(Long prebookId);
}
