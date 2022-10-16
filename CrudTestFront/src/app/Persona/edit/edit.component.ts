import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/Modelo/persona';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  persona:Persona = new Persona();

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
    this.cargar();
  }

  cargar(){
    let id=localStorage.getItem("id")!;
    console.log("Cargando persona con ID: "+id)
    this.service.getPersonaById(+id).subscribe(data=>{
      this.persona=data;
    })
  }

  edit(persona:Persona){
    return this.service.editPersona(persona).subscribe(data=>{
      this.persona=data;
      alert("Se actualizó con éxito")
      this.router.navigate(["list"]);
    });
  }

  cancelar(){
    this.router.navigate(["list"]);
  }

}
