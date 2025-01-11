package envios.envios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import envios.envios.model.EnvioModel;

@Repository
public interface IEnvioRepository extends CrudRepository<EnvioModel,Integer>{
    
    @Query("SELECT c from EnvioModel c where c.estado != 'ELIM'")
    public List<EnvioModel> findAllHab();

    @Query("SELECT c from EnvioModel c where c.estado != 'ELIM' and c.idUsuario = :id")
    public List<EnvioModel> findAllByUserId(@Param("id") int id);
}