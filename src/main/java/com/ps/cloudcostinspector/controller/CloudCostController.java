package com.ps.cloudcostinspector.controller;

import com.ps.cloudcostinspector.domain.VMCompute;
import com.ps.cloudcostinspector.exceptions.DetailsNotFoundException;
import com.ps.cloudcostinspector.service.CloudComputeServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/compute")
@Slf4j
public class CloudCostController {

    @Autowired
    CloudComputeServiceProvider computeService;

    @GetMapping("/virtualmachines")
    Page<VMCompute> listAllVirtualMachines(@ParameterObject Pageable pageable) {
        log.info("Request called");
        return computeService.getVMComputeDetails(pageable);
    }

    @GetMapping("/virtualmachines/{id}")
    VMCompute getVMComputeDetailsById(@PathVariable Long id) throws DetailsNotFoundException {
        return computeService.getVMComputeDetails(id);
    }

    @GetMapping("/virtualmachines/cloud/{vendor}")
    Page<VMCompute> getVMComputeDetailsByVendor(@ParameterObject Pageable pageable, @PathVariable String vendorName)
            throws DetailsNotFoundException {
        return computeService.getVMComputeDetails(pageable, vendorName);
    }


    @PostMapping ("/virtualmachines")
    VMCompute saveVMComputeDetails(@RequestBody VMCompute vmCompute) {
        try {
            log.info("Request called");
            return computeService.getVMComputeDetails(vmCompute.getId());
        } catch (DetailsNotFoundException notFound) {
            //save only when not found
            return computeService.saveVMComputeDetails(vmCompute);
        }

    }
}

