package Catalogo.Catalogo.services;

import java.util.List;

import Catalogo.Catalogo.model.CatalogoModel;

public interface ICatalogoService {
    public CatalogoModel addTabla(CatalogoModel model);
    public CatalogoModel addItem(CatalogoModel model);
    public CatalogoModel getItemById(int id);
    public CatalogoModel getByDescripcionCorta(String desc);
    public int update(CatalogoModel model);
    public List<CatalogoModel> getAllTablas();
    public List<CatalogoModel> getItemsByTabla(int tabla);
    public CatalogoModel getTabla(int tabla);
    public List<CatalogoModel> getAllCatalogo();
    public int getMaxTabla();
    public int getMaxItembyTabla(int tabla);
}
