package me.shackox.graphql.demographql.service;

import me.shackox.graphql.demographql.domain.Prebook;

import java.util.List;

public interface PrebookService {
    List<Prebook> getAllPrebooks();

    Long countAllPrebooks();

    Prebook getPrebookById(Long id);

    Prebook createPrebook(Prebook prebook);

    Prebook updatePrebook(Long prebookId, Prebook prebook);

    boolean deletePrebook(Long prebookId);
}
