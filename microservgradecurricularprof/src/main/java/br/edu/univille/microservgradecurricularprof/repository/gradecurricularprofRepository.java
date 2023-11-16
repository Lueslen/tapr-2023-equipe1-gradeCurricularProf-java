package br.edu.univille.microservgradecurricularprof.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservgradecurricularprof.entity.gradecurricularprof;

@Repository
public interface gradecurricularprofRepository

    extends CrudRepository<gradecurricularprof, String>{
    
}
