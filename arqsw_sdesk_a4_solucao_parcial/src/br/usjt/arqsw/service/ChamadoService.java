package br.usjt.arqsw.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.arqsw.dao.ChamadoDAO;
import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Service
public class ChamadoService {
	ChamadoDAO dao;
	FilaService fService;
	
	@Autowired
	public ChamadoService(ChamadoDAO dao, FilaService fs){
		this.dao = dao;
		this.fService = fs;
	}

	public int novoChamado(Chamado chamado) throws IOException{
		chamado.setDataAbertura(new Date());
		chamado.setDataFechamento(null);
		chamado.setStatus(Chamado.ABERTO);
		Fila fila = fService.carregar(chamado.getFila().getId());
		chamado.setFila(fila);
		return dao.inserirChamado(chamado);
	}
	
	public List<Chamado> listarChamados(Fila fila) throws IOException{
		return dao.listarChamados(fila);
	}

	public List<Chamado> listarChamados() throws IOException{
		// TODO Auto-generated method stub
		return dao.listarChamados();
	}

	public List<Chamado> fecharChamados(Fila fila) throws IOException{
		// TODO Auto-generated method stub
		return dao.listarChamadosAbertos(fila);
	}

	

}
