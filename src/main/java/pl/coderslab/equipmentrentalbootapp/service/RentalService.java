package pl.coderslab.equipmentrentalbootapp.service;

import pl.coderslab.equipmentrentalbootapp.entity.Rental;

import java.util.List;

public interface RentalService {
    Rental findById(Long id);
    List<Rental> findAllByUserId(Long id);
    void saveRental(Rental rental);
}
