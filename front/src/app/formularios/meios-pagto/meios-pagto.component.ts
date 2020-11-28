import { ConfiguracoesPtBrService } from './../services/configuracoes-pt-br.service';
import { CartaoCredito } from './../models/CartaoCredito';
import { TiposMeiosPagtoService } from '../services/tipos-meios-pagto.service';
import { SelectItem } from 'primeng/api';
import { TiposMeiospagto } from './../models/TiposMeiosPagto';
import { Meiopagto } from './../models/MeioPagto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-meios-pagto',
  templateUrl: './meios-pagto.component.html',
  styleUrls: ['./meios-pagto.component.css']
})
export class MeiosPagtoComponent implements OnInit {

  meioPagto: Meiopagto = {
    id: null,
    descricao: null
  }
  cartao: CartaoCredito = {
    id: null,
    nomeCartao: null,
    numeroCartao: null,
    validade: null
  }

  dataPtBR;
  tiposMeioPgto: TiposMeiospagto[];
  tipoSelecionado: SelectItem;

  mostraCamposCartao: boolean = true;

  constructor(
    private tiposService: TiposMeiosPagtoService,
    private ptBR: ConfiguracoesPtBrService) { }

  ngOnInit(): void {
    this.tiposMeioPgto = this.tiposService.tiposMeiosPagto;
    this.dataPtBR = this.ptBR.ptBr
  }

  mostra(ev) {
    switch (ev.value.tipo) {
      case "Cartão de Crédito":
        this.mostraCamposCartao = false;
        console.log(this.mostraCamposCartao);
        break;
      default:
        this.mostraCamposCartao = true;
        console.log(this.mostraCamposCartao);
    }
  }

}
