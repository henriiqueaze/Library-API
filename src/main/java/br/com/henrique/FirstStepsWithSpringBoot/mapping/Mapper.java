package br.com.henrique.FirstStepsWithSpringBoot.mapping;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static ModelMapper mapper = new ModelMapper();

    public static <O, D> D parseObjects(O origin, Class<D> destiny) {
        return mapper.map(origin, destiny);
    }

    public static <O, D> List<D> parseObjectsList(List<O> origin, Class<D> destiny) {
        ArrayList<D> objectsDestiny = new ArrayList<>();

        for (O o : origin) {
            objectsDestiny.add(mapper.map(o, destiny));
        }

        return objectsDestiny;
    }
}
