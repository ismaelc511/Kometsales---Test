package com.prueba.prueba.service;

import com.prueba.prueba.exceptions.ResourceNotFoundException;
import com.prueba.prueba.models.Flower;
import com.prueba.prueba.repository.FlowerRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class FlowerService {

    private FlowerRepository flowerRepository;

    @Autowired
    public FlowerService(FlowerRepository flowerRepository){
        this.flowerRepository = flowerRepository;
    }

    @SneakyThrows
    public Optional<Flower> getFlowerById(Integer id){
        Optional<Flower> flower = flowerRepository.findById(id);
            return  flower;
    }

    public List<Flower> getFlowersByName(String name){
        List<Flower> flowers = flowerRepository.getFlowerByName(name);
        final List<Flower> flowersResponse = new ArrayList<>();
        flowers.stream().forEach(flower -> {
            flower.setId(flower.getId());
            flower.setName(flower.getName());
            flower.setPrice(flower.getPrice());
            log.info(String.valueOf(flower));
            flowersResponse.add(flower);
        });

        return  flowersResponse;
    }

    public List<Flower> getFlowersByPrice(Integer price){
            if(price <= 20){
                final List<Flower> flowersResponse = new ArrayList<>();
                log.info("Se va vacío");
                return flowersResponse;
            }else{
                List<Flower> flowers = flowerRepository.findAll();
                final List<Flower> flowersResponse = new ArrayList<>();
                flowers.stream().forEach(flower -> {
                    if(flower.getPrice() <= 20){
                        flowers.remove(flower.getId());
                    }else{
                        flower.setId(flower.getId());
                        flower.setName(flower.getName());
                        flower.setPrice(flower.getPrice());
                        log.info(String.valueOf(flower));
                        flowersResponse.add(flower);
                    }

                });
                return  flowersResponse;
            }



        }



    public List<Flower> getOrderFlowers(){
        List<Flower> flowers = flowerRepository.findAllByOrderByNameDesc();
        final List<Flower> flowersResponse = new ArrayList<>();
        flowers.stream().forEach(flower -> {
            //flower.setId(flower.getId());
            flower.setName(flower.getName() + "-kometsales");
            flower.setPrice(flower.getPrice());
            log.info(String.valueOf(flower));
            flowersResponse.add(flower);
        });

        return  flowersResponse;
    }

    public Flower register(Flower flower) {
        //flowerRepository.deleteAll();
        flower = flowerRepository.save(flower);
        return flower;

    }

    public void delete(Integer id) throws ResourceNotFoundException {
        if(this.getFlowerById(id) == null)
            throw new ResourceNotFoundException("There is no flower with the ID: " + id);
        flowerRepository.deleteById(id);
    }







}
