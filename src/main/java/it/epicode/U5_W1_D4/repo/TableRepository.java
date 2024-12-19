package it.epicode.U5_W1_D4.repo;

import it.epicode.U5_W1_D4.entities.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TableRepository extends JpaRepository<DiningTable, Long> {

}
