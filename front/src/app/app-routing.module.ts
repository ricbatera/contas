import { MeiosPagtoComponent } from './formularios/meios-pagto/meios-pagto.component';
import { TesteComponent } from './formularios/teste/teste.component';
import { ResponsaveisComponent } from './formularios/responsaveis/responsaveis/responsaveis.component';
import { SaidasComponent } from './formularios/saidas/saidas.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path : 'saida', component : SaidasComponent },
  { path : 'responsaveis', component : ResponsaveisComponent },
  { path : 'meiosPagto', component : MeiosPagtoComponent },
  //{ path : 'meiosPagto', component : TesteComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
