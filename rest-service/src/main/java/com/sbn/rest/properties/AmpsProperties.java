package com.sbn.rest.properties;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Component
@ConfigurationProperties("amps") // prefix amps, find amps.* values
@Validated
public class AmpsProperties {

	@NotBlank
	private String bic;

	/*@Length(max = 4, min = 1)
	private String bics;*/
}
