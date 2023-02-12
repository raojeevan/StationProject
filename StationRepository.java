package com.example.LibraryProject.Repository;

import com.example.LibraryProject.Model.Station;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface StationRepository extends JpaRepository<Station, Integer> {

  @PersistenceContext
  EntityManager entityManager = null;

 
  public static List<Station> findStationsLimitedTo(int limit) {
    return entityManager.createQuery("SELECT s FROM Station s ORDER BY s.id",
        Station.class).setMaxResults(limit).getResultList();
  }

  static List<Station> findAllOrderBy(String order, String param) {
    return entityManager.createQuery("SELECT * FROM Station ORDER BY "+param+" "+order,
        Station.class).getResultList();
  }
}
