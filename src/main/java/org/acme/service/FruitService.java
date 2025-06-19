package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.acme.repository.FruitRepository;
import org.acme.repository.entity.FruitEntity;
import org.acme.rest.json.Fruit;

import java.util.List;
import java.util.Objects;

@ApplicationScoped
@Slf4j
public class FruitService {

    @Inject
    FruitRepository fruitRepository;

    public List<Fruit> findAll() {
        return fruitRepository.findAll().stream()
            .map(fruitEntity -> Fruit.builder().id(fruitEntity.getId())
                .description(fruitEntity.getDescription()).name(fruitEntity.getName())
                .build())
            .toList();
    }

    public List<Fruit> findByName(String name) {
        return fruitRepository.findByName(name).stream()
            .map(fruitEntity -> Fruit.builder().id(fruitEntity.getId())
                .description(fruitEntity.getDescription()).name(fruitEntity.getName())
                .build())
            .toList();
    }

    @Transactional
    public void create(Fruit fruit) {
        log.info("create - init");

        try {
            FruitEntity fruitEntity = FruitEntity.builder()
                    .description(fruit.getDescription())
                    .name(fruit.getName())
                    .build();
            fruitRepository.persist(fruitEntity);

            log.info("Entity fruit created with ID: {}", fruitEntity.getId());

        } catch (PersistenceException pe) {
            log.error("Error to create entity: {}", pe.getMessage(), pe);
        }

        log.info("create - end");
    }

    @Transactional
    public void update(Fruit fruit) {
        FruitEntity fruitEntity = fruitRepository.findById(fruit.getId());
        if (Objects.nonNull(fruitEntity)) {
            fruitRepository.update("description = ?1, name = ?2 where id = 3?",
                fruit.getDescription(), fruit.getName(), fruit.getId());
        } else {
            log.error("Error to update entity with id: {}", fruit.getId());
            throw new EntityNotFoundException("Entity not found");
        }
    }
}
