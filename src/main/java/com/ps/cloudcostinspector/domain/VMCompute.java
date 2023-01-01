package com.ps.cloudcostinspector.domain;

import com.ps.cloudcostinspector.domain.listeners.AuditorAwareImpl;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.*;
import java.io.Serializable;


// https://projectlombok.org/features/all
// https://www.baeldung.com/intro-to-project-lombok

@Entity
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Table(name = "vmcompute")
@EntityListeners(AuditorAwareImpl.class)
public class VMCompute extends ComputeService implements Serializable {

    @NonNull
    @Id
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    @NonNull
    private String cloudVendor;
    @NonNull
    private String name;
    @NonNull
    private String type;
    @NonNull
    private String vcpus;
    @NonNull
    private String memory;
    @NonNull
    private String operatingSystem;

    private boolean ip6support;
    private String networkBandwidth;

    private String family;
    private String instanceStorage;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    private long createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private long modifiedDate;
}
