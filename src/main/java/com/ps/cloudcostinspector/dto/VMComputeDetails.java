package com.ps.cloudcostinspector.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class VMComputeDetails implements Serializable {
    @NonNull private String cloudVendor;
    @NonNull private String name;
    @NonNull private String type;
    @NonNull private String vcpus;
    @NonNull private String memory;
    @NonNull private String operatingSystem;
    private String vmDetails;
}
