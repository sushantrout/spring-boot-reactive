package com.tech.mapper;

public interface RMapper <D, E>{
    D toDTO(E e);
    E toEntity(D d);
}
