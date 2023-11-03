package pl.coderslab.equipmentrentalbootapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;

import java.util.Collection;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    Rental findById(Long id);
    Rental findByItemId(Long itemId);
    List<Rental> findAllByUserId(Long id);
    @Query(value = "SELECT * FROM rentals WHERE user_id = ?1 AND DATEDIFF(NOW(), created) > rentals.rental_days",
            nativeQuery = true)
    List<Rental> findAllExpiredUserRentals(Long userId);
    @Query(value = "SELECT * FROM rentals r JOIN items i on r.item_id = i.id WHERE i.user_id = ?1 AND DATEDIFF(NOW(), created) > r.rental_days",
            nativeQuery = true)
    List<Rental> findAllExpiredRentalsOfMyItems(Long userId);
    List<Rental> findAll();
}
