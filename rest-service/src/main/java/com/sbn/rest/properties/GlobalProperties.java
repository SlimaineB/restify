package com.sbn.rest.properties;

import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@Component
/*@PropertySource(value="classpath:global.properties")
@ConfigurationProperties // no prefix, find root level values.
@Validated*/
public class GlobalProperties {


    private int threadPool;
	
    @NotBlank
    private String email;

    //getters and setters

}
