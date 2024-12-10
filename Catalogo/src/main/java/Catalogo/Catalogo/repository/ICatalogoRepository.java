package Catalogo.Catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Catalogo.Catalogo.model.CatalogoModel;

@Repository
public interface ICatalogoRepository extends CrudRepository <CatalogoModel,Integer> {
    
    @Query("SELECT c FROM catalogo c WHERE c.tabla = '00'")
    List<CatalogoModel> findAllTablas();

    @Query("SELECT c FROM catalogo c WHERE c.descripcionCorta = :desc ")
    CatalogoModel findByDescripcionCorta(@Param("desc") String descripcion);

    @Query("SELECT c FROM catalogo c WHERE c.tabla = :tabla")
    List<CatalogoModel> findItemsByTabla(@Param("tabla") String tabla);

}
