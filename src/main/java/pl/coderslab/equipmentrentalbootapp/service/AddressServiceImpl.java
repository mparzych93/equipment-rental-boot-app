package pl.coderslab.equipmentrentalbootapp.service;

import org.springframework.stereotype.Service;
import pl.coderslab.equipmentrentalbootapp.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}
