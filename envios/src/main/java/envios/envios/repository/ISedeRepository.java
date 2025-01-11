package envios.envios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import envios.envios.model.SedeModel;

@Repository
public interface ISedeRepository extends CrudRepository<SedeModel,Integer> {

    @Query("SELECT c from SedeModel c where c.estado != 'ELIM'")
    public List<SedeModel> findAllHab();
}