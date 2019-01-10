package com.poc.mongo.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -3833372096352743772L;
	
	@Id
    private String id;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }
    

}
