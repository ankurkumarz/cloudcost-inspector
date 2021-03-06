package com.ps.cloudcostinspector.controller;

import com.ps.cloudcostinspector.domain.VMCompute;
import com.ps.cloudcostinspector.exceptions.DetailsNotFoundException;
import com.ps.cloudcostinspector.service.CloudComputeServiceProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toList;
@RestController
@RequestMapping("/compute")
@Slf4j
public class CloudCostController {

    @Autowired
    CloudComputeServiceProvider computeService;

    @GetMapping("/virtualmachines")
    List<VMCompute> listAllVirtualMachines() {
        log.info("Request called");
        return computeService.getVMComputeDetails();
    }

    @GetMapping("/virtualmachines/{id}")
    VMCompute getVMComputeDetailsById(@PathVariable Long id) throws DetailsNotFoundException {
        return computeService.getVMComputeDetails(id);
    }

//    @GetMapping("/virtualmachines/cloud/{vendor}")
//    List<VMCompute> getVMComputeDetailsByVendor(@PathVariable String vendorName)
//            throws DetailsNotFoundException {
//        return computeService.getVMComputeDetails()
//                .stream()
//                .filter(VMCompute::getVendor).
//    }


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

