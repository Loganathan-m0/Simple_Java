package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "OUTBOX_EVENT")
public class OutboxEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "aggregate_type")
	private String aggregateType;
	
	@Column(name = "aggregate_id")
	private String aggregateId;
	
	@Column(name = "event_type")
	private String eventType;
	
	@Column(name = "payload")
	private	String payload;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
	@Column(name = "published_date")
	private LocalDateTime PublishedDate;
	
}
