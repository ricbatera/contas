import { element } from 'protractor';
import { Injectable, ɵbypassSanitizationTrustResourceUrl } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ValidacoesService {

  constructor() { }

  validarDescricao(valor: string, valor2: string){    
    if(valor){
      if(valor.length > 5){
        if(valor2 == 'Escolha um tipo...'){
          alert('Selecione um tipo de Pagamento');
          return false
        }
        return true;
      }else{
        alert('Descrição inválida, digite mais ede 5 letras');
        return false
      }    
    }else{
      alert('Descrição não pode ficar em branco');
      return false;
    }
  }

  converteDatas(valor: Date){
    return `${valor.getFullYear()}-${valor.getMonth()+1}-${valor.getDate()}`;
    //console.log(valor);
  }
}
