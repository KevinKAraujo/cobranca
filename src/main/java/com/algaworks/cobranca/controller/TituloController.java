package com.algaworks.cobranca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;


@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;

	@RequestMapping("/novo")    /*AQUI DIZEMOS A ONDE VAI CHAMAR NO HTTP(URL)*/
	public String novo() {      /*CRIAMOS UM METODO PARA RETORNAR A PAGINA HTML*/
		return "Index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		//SALVAR NO BANCO DE DADOS
		
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("Index");
		mv.addObject("mensagem","FeedBack salvo com sucesso");
		return mv;
		
	}
	
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos );
		return mv;
	}

}
