package it.iccs.simeal.sdi.domande.adapter.outbound.persistence.mapper;

import java.util.List;

public interface EntityMapper<E, M> {
	
	M fromEntityToModel(E entity);

    E fromModelToEntity(M model);

    List <M> fromEntitiesToModels(List<E> entityList);
    
    List <E> fromModelsToEntities(List<M> modelList);

}
