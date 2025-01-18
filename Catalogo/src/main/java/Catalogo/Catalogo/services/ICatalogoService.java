package Catalogo.Catalogo.services;

import java.util.List;

import Catalogo.Catalogo.model.CatalogoModel;

public interface ICatalogoService {
    public CatalogoModel addItem(CatalogoModel model);
    public CatalogoModel getItemById(int id);
    public CatalogoModel getByDescripcionCorta(String desc);
    public CatalogoModel update(CatalogoModel model);
    public List<CatalogoModel> getAllTablas();
    public List<CatalogoModel> getItemsByTabla(int tabla);
    public List<CatalogoModel> getAllCatalogo();
    public CatalogoModel updateEstado(int id);
    public boolean deleteItem(int id);
}
