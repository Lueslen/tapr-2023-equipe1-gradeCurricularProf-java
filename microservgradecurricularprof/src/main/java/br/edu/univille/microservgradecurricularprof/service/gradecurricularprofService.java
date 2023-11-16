package br.edu.univille.microservgradecurricularprof.service;
import java.util.List;
import br.edu.univille.microservgradecurricularprof.entity.gradecurricularprof;

public interface gradecurricularprofService {
    public List<gradecurricularprof> getAll();
    public gradecurricularprof getById(String id);
    public gradecurricularprof saveNew(gradecurricularprof gradecurricularprof);
    public gradecurricularprof update(String id, gradecurricularprof gradecurricularprof);
    public gradecurricularprof delete(String id);

}