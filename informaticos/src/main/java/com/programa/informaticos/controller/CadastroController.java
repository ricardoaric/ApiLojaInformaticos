package com.programa.informaticos.controller;
import com.programa.informaticos.model.Cliente;
import com.programa.informaticos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CadastroController {

    private final ClienteRepository clienteRepository;

    @Autowired
    public CadastroController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping("/usuarios/cadastrar")
    public ModelAndView cadastrarUsuario(@RequestParam("nome") String nome, @RequestParam("email") String email, @RequestParam("celular") String celular){
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setCelular(celular);

        clienteRepository.save(cliente);

        ModelAndView modelAndView = new ModelAndView("redirect:/cadastro-sucesso");
        modelAndView.addObject("mensagem", "Usuário cadastrado com sucesso!");
        return modelAndView;
    }
}