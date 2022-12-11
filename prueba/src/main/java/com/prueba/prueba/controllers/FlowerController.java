package com.prueba.prueba.controllers;


import com.prueba.prueba.exceptions.ResourceNotFoundException;
import com.prueba.prueba.models.Flower;
import com.prueba.prueba.models.FlowerResponse;
import com.prueba.prueba.service.FlowerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.prueba.prueba.models.FlowerListStatic.FLOWERLIST;

@Slf4j
@RestController
@CrossOrigin
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    //GET BY ID
    @RequestMapping(value = "flower/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Flower>> getFlower(@PathVariable Integer id){
        Optional<Flower> flower = flowerService.getFlowerById(id);
        if(flower != null){
            return ResponseEntity.ok(flower);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //Get Flowers by name
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Flower>> getFlowerByName(@RequestParam(value="name") String name){
        List<Flower> flowers;
        flowers = flowerService.getFlowersByName(name);
        log.info(String.valueOf(flowers));
        if(flowers != null){
            return ResponseEntity.ok(flowers);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @RequestMapping(value = "flowers/{price}", method = RequestMethod.GET)
    public ResponseEntity<List<Flower>> getFlowerByPrice(@PathVariable Integer price){
        List<Flower> flowers;
        flowers = flowerService.getFlowersByPrice(price);
        log.info(String.valueOf(flowers));
        if(flowers != null){
            return ResponseEntity.ok(flowers);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    //Get Flowers and Arrange them By Name
    @RequestMapping(value = "flowers/order", method = RequestMethod.GET)
    public ResponseEntity<List<FlowerResponse>> getOrderFlowers(){
        List<FlowerResponse> flowers = flowerService.getOrderFlowers();
        log.info(String.valueOf(flowers));
        if(flowers != null){
            return ResponseEntity.ok(flowers);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    //Register a flower
    @RequestMapping(value = "flowers",  method = RequestMethod.POST)
    public ResponseEntity<Flower> registerFlower(@RequestBody Flower flower) throws Exception {
        flower = flowerService.register(flower);
        return new ResponseEntity(flower, HttpStatus.CREATED);
    }

    //Register various flowers
    @RequestMapping(value = "flowers/list",  method = RequestMethod.POST)
    public ResponseEntity<List<Flower>> registerFlowers(@RequestBody List<Flower> flowers) throws Exception {
        FLOWERLIST.clear();
        flowers.stream().forEach(flower -> {
            flower = flowerService.register(flower);
            FLOWERLIST.add(flower);
            log.info(String.valueOf(FLOWERLIST));
        });
        return new ResponseEntity(FLOWERLIST, HttpStatus.CREATED);
    }

    //DELETE
    @RequestMapping(value = "flowers/{id}", method = RequestMethod.DELETE)
    public void deleteFlower(@PathVariable Integer id) throws ResourceNotFoundException {
        flowerService.delete(id);
    }


}
