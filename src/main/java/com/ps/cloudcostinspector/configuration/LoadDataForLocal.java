package com.ps.cloudcostinspector.configuration;

import com.ps.cloudcostinspector.domain.VMCompute;
import com.ps.cloudcostinspector.domain.repository.VMComputeRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataForLocal {

    private static final Logger LOG = LoggerFactory.getLogger(LoadDataForLocal.class);

    @Bean
    CommandLineRunner initDatabase(VMComputeRepository vmComputeRepository) {
        return args -> {

            VMCompute c1 = new VMCompute(1L,"AWS", "T2", "t2.nano",
                    "1", "0.5GB", "Linux");
            VMCompute c2 = new VMCompute(2L,"AWS", "T2", "t2.micro",
                    "1", "1GB", "Linux");
            VMCompute c3 = new VMCompute(3L,"AWS", "T2", "t2.small",
                    "1", "2GB", "Linux");
            VMCompute c4 = new VMCompute(4L,"AWS", "T2", "t2.medium",
                    "2", "4GB", "Linux");
            VMCompute c5 = new VMCompute(4L,"Azure", "A1", "t2.medium",
                    "2", "4GB", "Linux");
            VMCompute c7 = new VMCompute(4L,"Azure", "D1", "t2.medium",
                    "2", "4GB", "Linux");
            VMCompute c8 = new VMCompute(4L,"Azure", "D2", "t2.medium",
                    "2", "4GB", "Linux");
            LOG.info("Preloading..." + vmComputeRepository.save(c1));
            LOG.info("Preloading..." + vmComputeRepository.save(c2));
            LOG.info("Preloading..." + vmComputeRepository.save(c3));
            LOG.info("Preloading..." + vmComputeRepository.save(c4));
        };
    }
}
