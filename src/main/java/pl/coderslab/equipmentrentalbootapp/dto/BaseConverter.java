package pl.coderslab.equipmentrentalbootapp.dto;

import java.util.Collection;
import java.util.stream.Collectors;

@FunctionalInterface
public interface BaseConverter<F,T> {

    public T convert(F from);

    default public Collection<T> convertAll(Collection<F> fElements){
        Collection<T> convertedElement =
                fElements.stream()
                        .map(element -> convert(element))
                        .collect(Collectors.toList());

        return convertedElement;
    }
}