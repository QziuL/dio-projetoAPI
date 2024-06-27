package br.qziul.service;

import br.qziul.model.Endereco;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *   Consumo da API do <a href="https://viacep.com.br">ViaCEP</a>
 *   através de Client HTTP, com OpenFeign.
 */
@EnableFeignClients
@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
