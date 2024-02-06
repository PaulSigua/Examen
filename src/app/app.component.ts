import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Recarga } from './domain/cliente';
import { RecargasService } from './services/recargas.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit{
  title = 'recargas';

  recargas: any;

  rec: Recarga = new Recarga();

  constructor(private recargaService: RecargasService) {}

  ngOnInit(): void {
    
  }

  recargar(clienteDes: HTMLInputElement, operadora: HTMLInputElement, monto: HTMLInputElement){
    if(clienteDes == null || operadora == null || monto == null){
      alert('Debe llenar todos los parametros')
    } else {

      const recarga = {
        clienteDes: clienteDes.valueAsNumber,
        operadora: operadora.valueAsNumber,
        monto: operadora.valueAsNumber
      }
      this.rec = recarga;
      this.recargaService.recargar(this.rec).subscribe(data => {
        
      });
    }
  }

}