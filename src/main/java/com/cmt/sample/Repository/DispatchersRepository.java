package com.cmt.sample.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cmt.sample.Entity.Dispatchers;

@Repository
public interface DispatchersRepository extends JpaRepository<Dispatchers, String>{

	@Query("SELECT s FROM Dispatchers s WHERE s.dispatcherPincode = ?1")
	Dispatchers findByPincode(String dispatcherPincode);
	@Transactional
	@Modifying
    @Query("DELETE Dispatchers c WHERE c.id = ?1")
	Integer deleteid(String id);
	@Query("SELECT s FROM Dispatchers s WHERE s.id = ?1")
	Dispatchers findByid(String id);

}
