package com.sbn.rest.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = AmpsRequest.AMPS_REQUEST)
public class AmpsRequest extends Auditable<AmpsRequest>{

	public static final String AMPS_REQUEST = "AMPS_REQUEST";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", length = 50)
	private String name;
	
	@Column(name = "TYPE", length = 50)
	private String type;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRANSACTION_ID")
	private AmpsTransaction ampsTransaction;
	
	



	
	
}
