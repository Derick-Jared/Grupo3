package envios.envios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import envios.envios.model.EquipajeModel;

@Repository
public interface IEquipajeRepository extends CrudRepository<EquipajeModel,Integer>{
    
    @Query("SELECT e from EquipajeModel e where e.estado != 'ELIM'")
    public List<EquipajeModel> findAllHab();

    @Query("SELECT e from EquipajeModel e where e.detalleEnvio_id = :id and e.estado != 'ELIM'")
    public List<EquipajeModel> findAllByDetalleEnvioId(@Param("id") int id);
}
