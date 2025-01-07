import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public class repositories {
   @Repository
public interface IDetalleEnvioRepository extends CrudRepository<DetalleEnvioModel,Integer>{

    @Query("SELECT c from DetalleEnvioModel c where c.estado != 'ELIM'")
    public List<DetalleEnvioModel> findAllHab();
} 
}