import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';

interface Pagto {
  nome: string;
}
interface Resp{
  nome:String;
}

@Component({
  selector: 'app-saidas',
  templateUrl: './saidas.component.html',
  styleUrls: ['./saidas.component.css']
})


export class SaidasComponent implements OnInit {
  value: Date;
  ptBr: any;
  meioSelecionado: SelectItem;
  meioPagto: Pagto[];
  responsaveis: Resp[];
  responsavel:SelectItem;
  constructor() { 
    // esses dados virão do banco de dados
    this.meioPagto =[
      {nome:'Itaú Uniclass'},
      {nome:'Extra Card'},
      {nome:'Boleto'},
      {nome:'Débito em conta'}
    ]
    // esses dados virão do banco de dados
    this.responsaveis=[
      {nome:'Ricardo'},
      {nome:'Silene'},
      {nome:'Silvana'}
    ]
  }

  ngOnInit(): void {
    this.ptBr = {
      firstDayOfWeek: 1,
      dayNames: [ "Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado" ],
      dayNamesShort: [ "dom","seg","ter","qua","qui","sex","sáb" ],
      dayNamesMin: [ "D","S","T","Q","Q","S","S" ],
      monthNames: [ "Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro" ],
      monthNamesShort: [ "jan","fev","mar","abr","mai","jun","jul","ago","set","out","nov","dez" ],
      today: 'Hoje',
      clear: 'Limpar'
  }


  }

}
