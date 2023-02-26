package bsuir.labs.dao.database.repository;

import bsuir.labs.core.dtos.InputDTO;
import bsuir.labs.dao.database.entity.SourceAndResultEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IStorageRepository extends CrudRepository<SourceAndResultEntity, InputDTO> {

}
