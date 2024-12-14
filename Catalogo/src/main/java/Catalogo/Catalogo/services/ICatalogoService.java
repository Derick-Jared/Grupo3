package Catalogo.Catalogo.services;

import java.util.List;

import Catalogo.Catalogo.model.CatalogoModel;

public interface ICatalogoService {
    public CatalogoModel addTabla(CatalogoModel model);
    public CatalogoModel addItem(CatalogoModel model);
    public CatalogoModel getByDescripcionCorta(String desc);
    public CatalogoModel update(CatalogoModel model);
    public List<CatalogoModel> getTablas();
    public List<CatalogoModel> getItems(int tabla);
}
