package pl.coderslab.equipmentrentalbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    Rental findById(Long id);
    List<Rental> findAllByUserId(Long id);
}
