package br.edu.univille.microservgradecurricularprof.entity;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "gradecurricularprof")

public class gradecurricularprof {
    @Id
    @GeneratedValue

    public String id;

    @PartitionKey

    public String name;

    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
