package com.programa.informaticos.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErroController implements iCustomErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Obtenha o código de status do erro
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404"; // Renderize sua página de erro 404
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500"; // Renderize sua página de erro 500
            }
        }

        return "error"; // Renderize sua página de erro padrão
    }

}
