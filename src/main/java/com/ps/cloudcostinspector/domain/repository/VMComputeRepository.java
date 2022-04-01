package com.ps.cloudcostinspector.domain.repository;

import com.ps.cloudcostinspector.domain.VMCompute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VMComputeRepository
        extends JpaRepository<VMCompute, Long> {

    //Native Query - use it only in rare scenarios
    // Spring Data JPA does not currently support dynamic sorting for native queries
    @Query(value = "SELECT * FROM VMCOMPUTE WHERE CLOUD_VENDOR = ?1",
           countQuery = "SELECT count(*) FROM VMCOMPUTE WHERE CLOUD_VENDOR = ?1",
            nativeQuery = true)
    Page<VMCompute> findBYCloudVendor(String cloudVendor, Pageable pageable);

}
