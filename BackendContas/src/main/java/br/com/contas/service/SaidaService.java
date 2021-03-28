package br.com.contas.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.contas.mapper.SaidaMapper;
import br.com.contas.model.MeioPagamento;
import br.com.contas.model.Parcela;
import br.com.contas.model.Responsavel;
import br.com.contas.model.Saida;
import br.com.contas.repository.MeioPagamentoRepository;
import br.com.contas.repository.ResponsavelRepository;
import br.com.contas.repository.SaidaRepository;
import br.com.contas.request.SaidaRequest;

@Service
public class SaidaService {
	
	@Autowired
	private SaidaMapper mapper;
	@Autowired
	private MeioPagamentoRepository meioRepo;
	@Autowired
	private ResponsavelRepository repo;
	@Autowired
	private SaidaRepository saidaRepo;
	
	public void salvar(SaidaRequest saidaRequest) {
		Saida saida = mapper.dtoRequestToModel(saidaRequest);
//		MeioPagamento meioPagamento = meioRepo.findById(saidaRequest.getIdMeioPagto()).get();
//		int diaVencimento = 0;
//		if(meioPagamento.getCartao() != null) {
//			diaVencimento = meioPagamento.getCartao().getDiaVencimento();
//		}
		saida.setParcelas(criaParcelas(saidaRequest.getQtdeParcelas(), saida.getValorTotal(), saida.getDataVencimento(), saidaRequest.getSituacao()));
		//System.out.println(saida);
		saidaRepo.save(saida);
	}

	public List<Parcela> criaParcelas(int parcelas, Double valor, LocalDate dataVencimento, String situacao) {
		List<Parcela>parcelasGeradas = new ArrayList<>();		
		BigDecimal valorParcela = new BigDecimal(valor).divide(new BigDecimal(parcelas),2, RoundingMode.HALF_EVEN);
		Calendar hoje = Calendar.getInstance();
		Calendar vencimento = converteVencimento(dataVencimento);
		if(vencimento.compareTo(hoje) >= 0) {			
			for (int i = 0; i < parcelas; i++) {
				LocalDate venc = LocalDateTime.ofInstant(vencimento.toInstant(), vencimento.getTimeZone().toZoneId()).toLocalDate();
				String valorParc = valorParcela.toString();
				Parcela parcela = new Parcela();
				parcela.setDataVenvimento(venc);
				parcela.setParcelaNumero(i+1);
				parcela.setValorUnit(Double.parseDouble(valorParc));
				parcela.setSituacao(situacao);
				parcelasGeradas.add(parcela);
				System.out.println(parcela);
				vencimento.set(Calendar.MONTH, (vencimento.get(Calendar.MONTH)+1));
				//System.out.println(vencimento.getTime());
			}
		}		
		return parcelasGeradas;
	}
	
	private Calendar converteVencimento(LocalDate vencimento) {
		String dataVencimento = vencimento.toString();
		String [] arrayVencimento = dataVencimento.split("-");
		String ano = arrayVencimento[0];
		String mes = arrayVencimento[1];
		String dia = arrayVencimento[2];
		Calendar vencimentoCalendar = Calendar.getInstance();
		vencimentoCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dia));
		vencimentoCalendar.set(Calendar.MONTH -1, Integer.parseInt(mes));
		vencimentoCalendar.set(Calendar.YEAR, Integer.parseInt(ano));		
		return vencimentoCalendar;
	}
}
