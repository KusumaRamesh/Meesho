package com.cmt.sample.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmt.sample.Entity.Dispatchers;

@Repository
public interface DispatchersRepository extends JpaRepository<Dispatchers, Integer>{
	@Query("SELECT s FROM Dispatchers s WHERE s.dispatcher_pincode = ?1")
	Dispatchers findByPincode(String dispatcher_pincode);

}
