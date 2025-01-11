package envios.envios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import envios.envios.model.DetalleEnvioModel;

@Repository
public interface IDetalleEnvioRepository extends CrudRepository<DetalleEnvioModel,Integer>{

    @Query("SELECT c from DetalleEnvioModel c where c.estado != 'ELIM'")
    public List<DetalleEnvioModel> findAllHab();
}
