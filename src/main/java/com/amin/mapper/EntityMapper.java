package com.amin.mapper;

import java.util.List;

public interface EntityMapper<V, E> {

    E toEntity(V v);

    V toViewModel(E entity);

    List<E> toEntity(List<V> dtoList);

    List<V> toViewModel(List<E> entityList);

}
