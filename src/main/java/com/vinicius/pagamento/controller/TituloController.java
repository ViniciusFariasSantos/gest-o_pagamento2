package com.vinicius.pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vinicius.pagamento.model.StatusTotal;
import com.vinicius.pagamento.model.Titulo;
import com.vinicius.pagamento.repository.Tittulos;

import java.util.*;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	private static final String CADASTRO_VIEW = "CadastroTitulo";

	@Autowired
	private Tittulos titulos;

	@RequestMapping("/novo")
	public ModelAndView novo() {

		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		// retornando o obejto titulos para a pagina html
		mv.addObject(new Titulo());
		return mv;

	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {

		// colocando a mensagem Negativa pra funcionar.
		if (errors.hasErrors()) {

			return CADASTRO_VIEW;

		}
		// metodo salvar
		titulos.save(titulo);

		// colocando a mensagem Positiva pra funcionar.
		attributes.addFlashAttribute("mensagem", "Título Salvo com sucesso!");
		return "redirect:/titulos/novo";

	}

	@ModelAttribute("todosStatusTitulo")
	public List<StatusTotal> todosStatusTitulo() {
		// Esta lista é para meu Pedente e recebido, validando eles dois
		return Arrays.asList(StatusTotal.values());

	}

	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Titulo titulo) {
		// Estou indo para meu Model Titulo e pegando meus dados e passando para o
		// usuario
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(titulo);
		return mv;
	}

	@RequestMapping(value = "{codigo}", method = RequestMethod.POST)
	public String excluir(@PathVariable Long codigo) {
		// Estou indo para meu Model Titulo e excluido os dados
		titulos.deleteById(codigo);
		return "redirect:/titulos";
	}

	@RequestMapping
	public ModelAndView Pesquisa() {
		// Aqui estou pesquisando e retornando todos os repositorio do meu banco de
		// dados.
		List<Titulo> todosTitulos = titulos.findAll();

		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;

	}

}
