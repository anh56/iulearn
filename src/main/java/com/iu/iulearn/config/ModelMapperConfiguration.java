package com.iu.iulearn.config;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;



@RestController
@Slf4j
public class ModelMapperConfiguration {

        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();}

}
