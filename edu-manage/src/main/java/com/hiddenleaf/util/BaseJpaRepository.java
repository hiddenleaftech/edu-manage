package com.hiddenleaf.util;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	//public <S extends T> S saveAndRefresh(S entity);
}
