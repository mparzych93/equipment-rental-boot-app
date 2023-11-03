package pl.coderslab.equipmentrentalbootapp.service;

import pl.coderslab.equipmentrentalbootapp.dto.RentalDto;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;

import java.util.Collection;
import java.util.List;

public interface RentalService {
    Rental findById(Long id);
    Rental findByItemId(Long itemId);
    List<Rental> findAllByUserId(Long id);
    List<Rental> findAllExpiredUserRentals(Long userId);
    List<Rental> findAllExpiredRentalsOfMyItems(Long userId);
    List<Rental> findAll();
    void saveRental(Rental rental);
    void deleteRental(Rental rental);
    RentalDto convert(Rental rental);
}
