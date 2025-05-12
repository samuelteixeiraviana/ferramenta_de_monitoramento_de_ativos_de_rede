package br.edu.iff.ccc.bsi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.edu.iff.ccc.bsi.entities.Device;
import jakarta.transaction.Transactional;

public interface DeviceRepository extends JpaRepository<Device, Long> {
	
	@Query("select d from Device d where d.name = ?1")
	List<Device> findByName(String name);
	
	@Query("select d from Device d where d.address = ?1")
	List<Device> findByAddress(String address);
	
	@Modifying
	@Transactional
	@Query("delete from Device d where d.address = ?1 ")
	void deleteByAddress(String address);	
}
