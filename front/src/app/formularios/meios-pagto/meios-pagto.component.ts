import { ValidacoesService } from './../services/validacoes.service';
import { ConfiguracoesPtBrService } from './../services/configuracoes-pt-br.service';
import { CartaoCredito } from './../models/CartaoCredito';
import { TiposMeiosPagtoService } from '../services/tipos-meios-pagto.service';
import { SelectItem } from 'primeng/api';
import { TiposMeiospagto } from './../models/TiposMeiosPagto';
import { ContaBancaria } from './../models/ContaBancaria';
import { Meiopagto } from './../models/MeioPagto';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-meios-pagto',
  templateUrl: './meios-pagto.component.html',
  styleUrls: ['./meios-pagto.component.css']
})
export class MeiosPagtoComponent implements OnInit {
  dataPtBR;
  tiposMeioPgto: TiposMeiospagto[];
  tipoSelecionado: SelectItem;
  tipoSelec: string = "Escolha um tipo...";

  meioPagto: Meiopagto = {
    id: null,
    descricao: null,
    tipo: null
  }
  cartao: CartaoCredito = {
    id: null,
    nomeCartao: null,
    numeroCartao: null,
    validade: null,
  }

  contaBancaria: ContaBancaria = {
    id: null,
    agencia: null,
    conta: null,
    banco: null
  }


  mostraCamposCartao: boolean = true;
  mostraCamposConta: boolean = true;

  constructor(
    private tiposService: TiposMeiosPagtoService,
    private validacaoService: ValidacoesService,
    private ptBR: ConfiguracoesPtBrService) { }

  ngOnInit(): void {
    this.tiposMeioPgto = this.tiposService.tiposMeiosPagto;
    this.dataPtBR = this.ptBR.ptBr
  }

  mostra(ev) {
    switch (ev.value.tipo) {
      case "Cartão de Crédito":
        this.tipoSelec = ev.value.tipo;
        this.mostraCamposCartao = false;
        this.mostraCamposConta = true;
        break;
      case "Débito em Conta":
        this.tipoSelec = ev.value.tipo;
        this.mostraCamposConta = false;
        this.mostraCamposCartao = true;
        break;
      case "Cheque":
        this.tipoSelec = "Cheque";
        this.mostraCamposConta = false;
        this.mostraCamposCartao = true;
        break;

      case "Boleto Bancário":
        this.tipoSelec = "Boleto Bancário";
        this.mostraCamposCartao = true;
        this.mostraCamposConta = true;
        break;

      case "Dinheiro":
        this.tipoSelec = "Dinheiro";
        this.mostraCamposCartao = true;
        this.mostraCamposConta = true;
        break;

      default:
        this.tipoSelec = "Escolha um tipo...";
        this.mostraCamposCartao = true;
        this.mostraCamposConta = true;
    }
  }

  salva() {
    var dataValidade = null;
    if(!this.mostraCamposCartao){
      dataValidade = this.validacaoService.converteDatas(this.cartao.validade);
    }
    const validaDescricaoETipo = this.validacaoService.validarDescricao(this.meioPagto.descricao, this.tipoSelec);
    if (validaDescricaoETipo) {

      const payload = {
        descricao: this.meioPagto.descricao,
        tipo: this.tipoSelec,
        cartao: {
          nomeCartao: this.cartao.nomeCartao,
          numeroCartao: this.cartao.numeroCartao,
          validade: dataValidade
        },
        conta: {
          banco: this.contaBancaria.banco,
          conta: this.contaBancaria.conta,
          agencia: this.contaBancaria.agencia
        }
      }
      console.log(payload);
    } else {

    }

  }

}
