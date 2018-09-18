package me.shackox.graphql.demographql.service;

import me.shackox.graphql.demographql.domain.Prebook;

import java.util.List;

public interface PrebookService {
    List<Prebook> allPrebooksHeader();

    List<Prebook> allPrebooksWithDetails();

    Long countAllPrebooks();

    Prebook getPrebookById(Long id);

    Prebook createPrebookHeader(Prebook prebook);

    Prebook createPrebookWithItems(Prebook prebook);

    Prebook updatePrebookHeader(Long prebookId, Prebook prebook);

    Prebook updatePrebookWithItems(Long prebookId, Prebook prebook);

    boolean deletePrebook(Long prebookId);
}
