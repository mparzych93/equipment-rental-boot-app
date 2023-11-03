package pl.coderslab.equipmentrentalbootapp.service;

import org.springframework.stereotype.Service;
import pl.coderslab.equipmentrentalbootapp.dto.RentalDto;
import pl.coderslab.equipmentrentalbootapp.dto.RentalDtoConverter;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;
import pl.coderslab.equipmentrentalbootapp.repository.RentalRepository;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {
    RentalRepository rentalRepository;
    RentalDtoConverter rentalDtoConverter;

    public RentalServiceImpl(RentalRepository rentalRepository, RentalDtoConverter rentalDtoConverter) {
        this.rentalRepository = rentalRepository;
        this.rentalDtoConverter = rentalDtoConverter;
    }

    @Override
    public Rental findById(Long id) {
        return rentalRepository.findById(id);
    }

    @Override
    public Rental findByItemId(Long itemId) {
        return rentalRepository.findByItemId(itemId);
    }

    @Override
    public List<Rental> findAllByUserId(Long id) {
        return rentalRepository.findAllByUserId(id);
    }

    @Override
    public List<Rental> findAllExpiredUserRentals(Long userId) {
        return rentalRepository.findAllExpiredUserRentals(userId);
    }

    @Override
    public List<Rental> findAllExpiredRentalsOfMyItems(Long userId) {
        return rentalRepository.findAllExpiredRentalsOfMyItems(userId);
    }

    @Override
    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    @Override
    public void saveRental(Rental rental) {
        rentalRepository.save(rental);
    }

    @Override
    public void deleteRental(Rental rental) {
        rentalRepository.delete(rental);
    }

    @Override
    public RentalDto convert(Rental rental) {
        return rentalDtoConverter.convert(rental);
    }
}
