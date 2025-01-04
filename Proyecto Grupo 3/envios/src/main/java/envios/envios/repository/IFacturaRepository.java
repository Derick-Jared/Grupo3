package envios.envios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import envios.envios.model.FacturaModel;
@Repository
public interface IFacturaRepository extends CrudRepository<FacturaModel,Integer>{
    
    @Query("SELECT c from FacturaModel c where c.estado != 'ELIM'")
    public List<FacturaModel> findAllHab();

    @Query("SELECT c from FacturaModel c where c.estado != 'ELIM' and c.idDetalleEnvio = :id")
    public FacturaModel findByDetalle(@Param("id") int id);
}
