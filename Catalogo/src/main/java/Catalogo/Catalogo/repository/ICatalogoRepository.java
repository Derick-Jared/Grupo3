package Catalogo.Catalogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Catalogo.Catalogo.model.CatalogoModel;

@Repository
public interface ICatalogoRepository extends CrudRepository <CatalogoModel,Integer> {
    
    @Query("SELECT c FROM CatalogoModel c WHERE c.tabla = 0")
    List<CatalogoModel> findAllTablas();

    @Query("SELECT c FROM CatalogoModel c WHERE c.descripcion_corta = :desc ")
    CatalogoModel findByDescripcionCorta(@Param("desc") String descripcion);

    @Query("SELECT c FROM CatalogoModel c WHERE c.tabla = :tabla")
    List<CatalogoModel> findItemsByTabla(@Param("tabla") int tabla);

}
