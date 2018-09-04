package com.sbn.rest.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = AmpsTransaction.AMPS_TRANSACTION)
public class AmpsTransaction {

	public static final String AMPS_TRANSACTION = "AMPS_TRANSACTION";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", length = 50)
	private String name;


	@OneToMany(mappedBy="ampsTransaction",cascade=CascadeType.ALL)
	private List<AmpsRequest> ampsRequests;
	
	
	@Column(name = "PRICE", precision=10, scale=2)
	private BigDecimal price;

	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	
	public AmpsTransaction() {
		// TODO Auto-generated constructor stub
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	
	
}
