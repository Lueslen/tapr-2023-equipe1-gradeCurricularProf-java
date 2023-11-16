package br.edu.univille.microservgradecurricularprof.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.microservgradecurricularprof.entity.gradecurricularprof;
import br.edu.univille.microservgradecurricularprof.repository.gradecurricularprofRepository;
import br.edu.univille.microservgradecurricularprof.service.gradecurricularprofService;

@Service
public class gradecurricularprofServiceImpl implements gradecurricularprofService{

    @Autowired
    private gradecurricularprofRepository repository;

    @Override
    public List<gradecurricularprof> getAll() {
        var iterador = repository.findAll();
        List<gradecurricularprof> listagradecurricularprof = new ArrayList<>();

        iterador.forEach(listagradecurricularprof::add);
        /*while(iterador.iterator().hasNext()){
            var umItem = iterador.iterator().next();
            listagradecurricularprof.add(umItem);
        }*/

        return listagradecurricularprof;
    }

    @Override
    public gradecurricularprof getById(String id) {
        var gradecurricularprof = repository.findById(id);
        if(gradecurricularprof.isPresent())
            return gradecurricularprof.get();
        return null;
    }

    @Override
    public gradecurricularprof saveNew(gradecurricularprof gradecurricularprof) {
        gradecurricularprof.setId(null);
        return repository.save(gradecurricularprof);
    }

    @Override
    public gradecurricularprof update(String id, gradecurricularprof gradecurricularprof) {
        var buscagradecurricularprofAntigo = repository.findById(id);
        if (buscagradecurricularprofAntigo.isPresent()){
            var gradecurricularprofAntigo = buscagradecurricularprofAntigo.get();

		    //Atualizar cada atributo do objeto antigo 
		    gradecurricularprofAntigo.setName(gradecurricularprof.getName());

		    return repository.save(gradecurricularprofAntigo);
        }
	    return null;
    }

    @Override
    public gradecurricularprof delete(String id) {
        var buscagradecurricularprof = repository.findById(id);
        if (buscagradecurricularprof.isPresent()){
            var gradecurricularprof = buscagradecurricularprof.get();

            repository.delete(gradecurricularprof);

            return gradecurricularprof;
        }
        return null;
    }
}