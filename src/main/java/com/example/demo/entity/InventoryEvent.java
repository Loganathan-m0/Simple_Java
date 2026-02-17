package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "INVENTORY_EVENT")
public class InventoryEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "event_type")
	private String eventType;
	
	@Column(name = "quantity")
	private Integer quantity;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@PrePersist
	protected void onCreate() {
		this.createdDate = LocalDateTime.now();
	}

}
