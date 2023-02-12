package com.example.LibraryProject.Model;

import java.awt.Image;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Station {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  int id;

  String name;

  Image image;

  double pricing;
  
  String address;

}
