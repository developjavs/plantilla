package com.jace.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.develop.model.BaseEntity;

@NoRepositoryBean
public interface CommonRepository<E extends BaseEntity, ID extends Serializable> extends PagingAndSortingRepository<E, ID>, JpaSpecificationExecutor<E> {

}