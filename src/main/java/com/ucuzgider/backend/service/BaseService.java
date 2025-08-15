package com.ucuzgider.backend.service;

import com.ucuzgider.backend.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, ID extends Serializable> {

    protected abstract BaseRepository<T, ID> getRepository();

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public List<T> findAll(Specification<T> specification) {
        return getRepository().findAll(specification);
    }

    public Page<T> findAll(Specification<T> specification, Pageable pageable) {
        return getRepository().findAll(specification, pageable);
    }

    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    public T getById(ID id) {
        return getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException("Entity not found with id: " + id));
    }

    @Transactional
    public T save(T entity) {
        return getRepository().save(entity);
    }

    @Transactional
    public List<T> saveAll(List<T> entities) {
        return getRepository().saveAll(entities);
    }

    @Transactional
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    @Transactional
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Transactional
    public void deleteAll(List<T> entities) {
        getRepository().deleteAll(entities);
    }

    public boolean existsById(ID id) {
        return getRepository().existsById(id);
    }

    public long count() {
        return getRepository().count();
    }

    public long count(Specification<T> specification) {
        return getRepository().count(specification);
    }
}