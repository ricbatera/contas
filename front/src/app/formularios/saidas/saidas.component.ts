import { ConfiguracoesPtBrService } from './../services/configuracoes-pt-br.service';
import { Responsavel } from './../models/Responsavel';
import { Parcela } from './../models/Parcela';
import { Saida } from './../models/Saida';
import { Component, OnInit } from '@angular/core';
import { SelectItem } from 'primeng/api';
import { ResponsaveisService } from '../services/responsaveis.service';


interface Pagto {
  nome: string;
}


@Component({
  selector: 'app-saidas',
  templateUrl: './saidas.component.html',
  styleUrls: ['./saidas.component.css']
})


export class SaidasComponent implements OnInit {
  saida: Saida = {
    id: null,
    descricao: null,
    dataCompra: null,
    parcelada: null,
    qtdeParcelas: null,
    valorTotal: null
  };

  parcela: Parcela = {
    id: null,
    valorUnit: null,
    parcelaNumero: null,
    situacao: "Aberto"
  }
  value: Date;
  ptBr: any;
  meioSelecionado: SelectItem;
  meioPagto: Pagto[];
  responsaveis: Responsavel[];
  responsavel: SelectItem;
  parcelado: boolean;
  pago: boolean


  teste: string
  constructor(
    private service: ResponsaveisService,
    private ptBR: ConfiguracoesPtBrService
    ) {
    // esses dados virão do banco de dados
    this.meioPagto = [
      { nome: 'Itaú Uniclass' },
      { nome: 'Extra Card' },
      { nome: 'Boleto' },
      { nome: 'Débito em conta' }
    ]    
  }

  ngOnInit(): void {
    this.ptBr = this.ptBR.ptBr;

    this.buscarTodosResponsaveis();
  }

  salva() {
    if (this.pago) {
      this.parcela.situacao = "Pago"
    } else {
      this.parcela.situacao = "Aberto"
    }
    console.log(this.saida);
    console.log()
    console.log(this.parcela)
  }
  calculaTotal() {
    this.saida.valorTotal = this.parcela.valorUnit * this.saida.qtdeParcelas;
  }

  buscarTodosResponsaveis(){
    this.service.listar()
        .subscribe(
          response => {            
            this.responsaveis = response;           
          },
          error => {
            console.log(error);
            alert(error.error);
          });
  }

}
