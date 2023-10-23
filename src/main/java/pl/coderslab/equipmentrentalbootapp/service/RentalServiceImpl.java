package pl.coderslab.equipmentrentalbootapp.service;

import org.springframework.stereotype.Service;
import pl.coderslab.equipmentrentalbootapp.entity.Rental;
import pl.coderslab.equipmentrentalbootapp.repository.RentalRepository;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {
    RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Rental findById(Long id) {
        return rentalRepository.findById(id);
    }

    @Override
    public List<Rental> findAllByUserId(Long id) {
        return rentalRepository.findAllByUserId(id);
    }

    @Override
    public void saveRental(Rental rental) {
        rentalRepository.save(rental);
    }
}
