 package com.cmt.sample.Entity;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="Dispatcher")
public class Dispatchers {
	@Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "sequence_generator")
	//@GenericGenerator(name = "sequence_generator",strategy = "com.cmt.sample.Entity.sequencestringgeneration",
      // parameters = {
//         @Parameter(name = sequencestringgeneration.INCREMENT_PARAM, value = "1"),
//         @Parameter(name = sequencestringgeneration. NUMBER_FORMAT_PARAMETER, value = "%05d")})

	private String id;
	private String dispatcherName;
	private String dispatcherPincode;
	private String dispatcherPhno;
	
	@CreationTimestamp
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime dataCreatedat;
	@UpdateTimestamp
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime dataUpdatedat;
	
	public LocalDateTime getDataUpdatedat() {
		return dataUpdatedat;
	}
	public void setDataUpdatedat(LocalDateTime dataUpdatedat) {
		this.dataUpdatedat = dataUpdatedat;
	}
	public LocalDateTime getDataCreatedat() {
		return dataCreatedat;
	}
	public void setDataCreatedat(LocalDateTime dataCreatedat) {
		this.dataCreatedat = dataCreatedat;
	}
	
	public String getId() {
		return id;
	}
	public String setId(String id) {
		return this.id = id;
	}
	public String getDispatcherName() {
		return dispatcherName;
	}
	public void setDispatcherName(String dispatcherName) {
		this.dispatcherName = dispatcherName;
	}
	public String getDispatcherPincode() {
		return dispatcherPincode;
	}
	public void setDispatcherPincode(String dispatcherPincode) {
		this.dispatcherPincode = dispatcherPincode;
	}
	public String getDispatcherPhno() {
		return dispatcherPhno;
	}
	public void setDispatcherPhno(String dispatcherPhno) {
		this.dispatcherPhno = dispatcherPhno;
	}

}
