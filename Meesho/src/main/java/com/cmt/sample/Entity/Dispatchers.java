package com.cmt.sample.Entity;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="Dispatchers")
public class Dispatchers {
	@Id
	private int id;
	private String dispatcher_name;
	private String dispatcher_pincode;
	private String dispatcher_phNo;
	
	@CreationTimestamp
	private LocalDateTime data_created_at;
	@UpdateTimestamp
	private LocalDateTime data_updated_at; 
	
	public LocalDateTime getData_updated_at() {
		return data_updated_at;
	}
	public void setData_updated_at(LocalDateTime data_updated_at) {
		this.data_updated_at = data_updated_at;
	}
	public LocalDateTime getData_created_at() {
		return data_created_at;
	}
	public void setData_created_at(LocalDateTime data_created_at) {
		this.data_created_at = data_created_at;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDispatcher_name() {
		return dispatcher_name;
	}
	public void setDispatcher_name(String dispatcher_name) {
		this.dispatcher_name = dispatcher_name;
	}
	public String getDispatcher_pincode() {
		return dispatcher_pincode;
	}
	public void setDispatcher_pincode(String dispatcher_pincode) {
		this.dispatcher_pincode = dispatcher_pincode;
	}
	public String getDispatcher_phNo() {
		return dispatcher_phNo;
	}
	public void setDispatcher_phNo(String dispatcher_phNo) {
		this.dispatcher_phNo = dispatcher_phNo;
	}

}
