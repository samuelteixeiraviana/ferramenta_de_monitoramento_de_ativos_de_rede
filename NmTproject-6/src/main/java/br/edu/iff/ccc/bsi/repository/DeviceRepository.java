package br.edu.iff.ccc.bsi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iff.ccc.bsi.entities.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}
