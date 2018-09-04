package com.sbn.rest.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class AmpsRequestForm {

	private Long id;
	@Size(min=2, message="The field [AmpsRequestForm.name] should have at least 2 characters")
	private String name;
	
	@NotNull(message="The field [AmpsRequestForm.type] should not be empty")
	private String type;
	
}
