package com.post_forms.rest.repository;


public interface Repository<T> {

    T create(T object);

    T read(Integer id);

    T update(T newObject);

    boolean delete(Integer id);
}
