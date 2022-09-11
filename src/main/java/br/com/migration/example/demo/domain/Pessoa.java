package br.com.migration.example.demo.domain;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clPessoa")
public class Pessoa {

    @Id
    private ObjectId id;

    @Field(name = "nome")
    private String nome;

    @Field(name = "sobrenome")
    private String sobrenome;

}
