package com.ps.cloudcostinspector.service;

import com.ps.cloudcostinspector.domain.VMCompute;
import com.ps.cloudcostinspector.domain.repository.VMComputeRepository;
import com.ps.cloudcostinspector.exceptions.DetailsNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Generic Interface for Each Cloud Service Provider
 * 
 * @author Ankur.Kumar
 *
 */
@Service
@Slf4j
public class CloudComputeServiceProvider {

    @Autowired
    private VMComputeRepository computeRepository;

    public List<VMCompute> getVMComputeDetails() {

        log.info(computeRepository.findBYCloudVendor("AWS",
                Pageable.ofSize(1)).toString());
        return computeRepository.findAll();
    }

    public VMCompute getVMComputeDetails(Long id) throws DetailsNotFoundException
    {
        return computeRepository.findById(id)
                .orElseThrow(() -> new DetailsNotFoundException("Not Found"));
    }

    public VMCompute saveVMComputeDetails(VMCompute vmCompute) {
        return computeRepository.save(vmCompute);
    }
}

