package com.example.exam_jee.Web;

import com.example.exam_jee.entities.Citoyen;
import com.example.exam_jee.repositories.CitoyenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Access;

@Controller
@AllArgsConstructor
public class CitoyenController {
 private CitoyenRepository citoyenRepository;
 @GetMapping("/formCitoyen")
 public String formPatients(Model model){
  model.addAttribute("citoyen",new Citoyen());
  return "citoyenform";
 }
 @GetMapping("/")
 public String home(){

  return "home";
 }
}
