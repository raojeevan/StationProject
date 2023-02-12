package com.example.LibraryProject.Controller;

import com.example.LibraryProject.Model.Station;
import com.example.LibraryProject.Repository.StationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class stationController {
  @Autowired
  StationRepository stationRepository;

  @GetMapping("/")
  public List<Station> stationList(){
    return stationRepository.findAll();
  }

  @GetMapping("/show")
  public Optional<Station> stationListById(@PathVariable("id") int id){
    return stationRepository.findById(id);
  }

  @PostMapping("/")
  public void stationList(@RequestBody Station station){
     stationRepository.save(station);
  }

  @PutMapping("/{id}/edit")
  public void stationList(@RequestBody Station station,@PathVariable("id") int id){
    stationRepository.save(station);
  }

  @DeleteMapping("/delete")
  public void stationList(@PathVariable("id") int id){
    stationRepository.deleteById(id);
  }

  @GetMapping("/")
  public List<Station> stationListLimited(@RequestParam("limit") int limit){

    return StationRepository.findStationsLimitedTo(limit);
  }

  @GetMapping("/")
  public List<Station> stationListByOrder(
      @RequestParam("sort") String order,@RequestParam("param") String param){

    return StationRepository.findAllOrderBy(order,param);
  }



}
