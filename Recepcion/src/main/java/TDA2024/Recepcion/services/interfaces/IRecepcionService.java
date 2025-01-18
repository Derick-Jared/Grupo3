package TDA2024.Recepcion.services.interfaces;

import TDA2024.Recepcion.models.RecepcionModel;

public interface IRecepcionService {
    public Iterable<RecepcionModel> findAll();
    public RecepcionModel findById(Integer id);
    public RecepcionModel add (RecepcionModel model);
    public RecepcionModel update(RecepcionModel model);
    public boolean delete (Integer id);
}
