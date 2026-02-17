package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name ="user_name")
	private String userName;
	
	@Column(name= "user_email")
	private String userEmail;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_role")
	private String userRole;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "created_date")
	private LocalDateTime createDate;
	
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;
	
	@PrePersist
	protected void onCreate() {
		this.createDate = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedDate = LocalDateTime.now();
	}
}
