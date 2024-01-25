package com.example.exam_jee.Web;

import com.example.exam_jee.entities.CentreVaccination;
import com.example.exam_jee.entities.Citoyen;
import com.example.exam_jee.repositories.CentreVaccinationRepository;
import com.example.exam_jee.repositories.CitoyenRepository;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {
 private CitoyenRepository citoyenRepository;
 private CentreVaccinationRepository centreVaccRepository;
 @GetMapping("/formCitoyen")
 public String formCitoyen(Model model){
  model.addAttribute("citoyen",new Citoyen());
  model.addAttribute("center",centreVaccRepository.findAll());
  return "citoyenform";
 }
 @GetMapping("/formCentreVaccination")
 public String formCentre(Model model) {
  model.addAttribute("CentreVac", new CentreVaccination());

  return "CentreVaccinationform";
 }
 @GetMapping("/")
 public String home(){

  return "home";
 }
 @PostMapping("/Citoyen/save")
 public String saveCitoyen(Model model, @Valid Citoyen citoyen, BindingResult bindingResult){
  if(bindingResult.hasErrors())
   return "citoyenform";
  citoyenRepository.save(citoyen);
  return "redirect:/";
 }
 @PostMapping("/CentreVac/save")
 public String save(Model model, @Valid CentreVaccination centreVaccination, BindingResult bindingResult){
  if(bindingResult.hasErrors())
   return "formCentreVaccination";
  centreVaccRepository.save(centreVaccination);
  return "redirect:/ListCitoyen";
 }
 @GetMapping("/Citoyen/delete")
 public String deleteCitoyen(Long id){
  citoyenRepository.deleteById(id);
  return "redirect:/ListCitoyen";
 }
 @GetMapping("/ListCitoyen")
 public  String ListCitoyen(Model model){
  model.addAttribute("Listcitoyen",citoyenRepository.findAll());
  return "Citoyen";
 }
 @GetMapping(path = "/Citoyen/edit")
 public String editCitoyen(Model model, Long id){
  Citoyen citoyen=citoyenRepository.findById(id).orElse(null);
  if(citoyen==null)
   throw new RuntimeException("Pateint introuvable");
  model.addAttribute("citoyen",citoyen);
  return "editCitoyen";
 }
 @GetMapping("/ListCentreVaccination")
 public String afficherCitoyensParCentre(@RequestParam(name = "centreNom", required = false) String centreNom,
                                         Model model) {
  List<Citoyen> citoyens = new ArrayList<>();

  if (centreNom != null && !centreNom.isEmpty()) {
   CentreVaccination centre = centreVaccRepository.findByNom(centreNom);
   model.addAttribute("centre",centre);
   if (centre != null) {
    citoyens = centre.getCitoyenList();
   }
  }
  model.addAttribute("citoyens", citoyens);
  return "centreVaccination";
 }
}
