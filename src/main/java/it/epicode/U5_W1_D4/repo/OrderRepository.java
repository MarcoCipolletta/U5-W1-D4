package it.epicode.U5_W1_D4.repo;

import it.epicode.U5_W1_D4.entities.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<ClientOrder, Long> {

}