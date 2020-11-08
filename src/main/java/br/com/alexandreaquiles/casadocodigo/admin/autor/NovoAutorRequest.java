package br.com.alexandreaquiles.casadocodigo.admin.autor;

import br.com.alexandreaquiles.casadocodigo.infra.validation.Unique;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

    @NotBlank
    @JsonProperty
    private String nome;

    @Unique(entity = Autor.class, field = "email", message = "{autor.email.unico}")
    @NotBlank @Email
    @JsonProperty
    private String email;

    @NotBlank @Size(max = 400)
    @JsonProperty
    private String descricao;

    public Autor toEntity() {
        return new Autor(nome, email, descricao);
    }

}
