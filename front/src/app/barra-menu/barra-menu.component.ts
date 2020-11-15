import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

//icones
import { faUserCircle} from '@fortawesome/free-solid-svg-icons';


@Component({
  selector: 'app-barra-menu',
  templateUrl: './barra-menu.component.html',
  styleUrls: ['./barra-menu.component.css']
})
export class BarraMenuComponent implements OnInit {
  itemsMenuSair: MenuItem[];

  faUserCircle = faUserCircle;

  constructor() { }

  ngOnInit() {
    this.itemsMenuSair = [
      {
        label: 'Editar meus dados',
        icon: 'pi pi-sliders-v'
      },
      {
        label: 'Sair',
        icon: 'pi pi-power-off'
      }      
    ];
  }


}
