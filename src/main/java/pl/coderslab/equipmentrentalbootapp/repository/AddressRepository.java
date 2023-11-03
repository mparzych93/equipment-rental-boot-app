package pl.coderslab.equipmentrentalbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.equipmentrentalbootapp.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
