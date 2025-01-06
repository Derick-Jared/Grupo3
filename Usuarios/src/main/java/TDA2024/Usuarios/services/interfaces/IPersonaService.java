package TDA2024.Usuarios.services.interfaces;

import TDA2024.Usuarios.models.PersonaModel;

public interface IPersonaService {
    public Iterable<PersonaModel> findAll();
    public PersonaModel findById(Integer id);
    public PersonaModel add (PersonaModel model);
    public PersonaModel update(PersonaModel model);
    public boolean delete (Integer id);
}
