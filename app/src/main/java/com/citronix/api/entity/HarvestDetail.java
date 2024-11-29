package com.citronix.api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "harvest_details")
@Builder
public class HarvestDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "unitQuantityKg is required.")
	@Column(name = "unit_quantity_kg")
	Double unitQuantityKg;

	@ManyToOne
	@JoinColumn(name = "harvest_id", insertable = false, updatable = false)
	Harvest harvest;

	@ManyToOne
	@JoinColumn(name = "tree_id", insertable = false, updatable = false)
	Tree tree;
}
