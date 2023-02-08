package br.com.evandroslk.springrestapi.repositories;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
@EntityGraph(
		type = EntityGraphType.FETCH,
		attributePaths = {
				"telefones"
		})
public @interface TelefonesFetch {

}
