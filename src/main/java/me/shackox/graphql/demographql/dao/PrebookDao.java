package me.shackox.graphql.demographql.dao;

import me.shackox.graphql.demographql.domain.Prebook;

import java.util.List;

public interface PrebookDao {
    List<Prebook> getAllPrebooks();

    Long countAllPrebooks();

    Prebook getPrebookById(Long id);

    Long createPrebook(Prebook prebook);

    void updatePrebook(Long prebookId, Prebook prebook);

    boolean deletePrebook(Long prebookId);
}
