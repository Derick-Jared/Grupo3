package TDA2024.Recepcion.services.interfaces;


import TDA2024.Recepcion.models.IncidenciaModel;

public interface IIncidenciaService{
    public Iterable<IncidenciaModel> findAll();
    public IncidenciaModel findById(Integer id);
    public IncidenciaModel add (IncidenciaModel incidencia);
    public IncidenciaModel update(IncidenciaModel incidencia);
    public boolean delete (Integer id);
}