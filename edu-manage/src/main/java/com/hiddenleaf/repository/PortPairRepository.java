package com.hiddenleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hiddenleaf.domain.PortPairMaster;

/**
 * Spring Data  repository for the PortPairMaster entity.
 */

@Repository
public interface PortPairRepository extends JpaRepository<PortPairMaster, String> {

}
