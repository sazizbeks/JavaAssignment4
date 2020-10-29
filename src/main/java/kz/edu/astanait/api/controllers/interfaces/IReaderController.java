package kz.edu.astanait.api.controllers.interfaces;

import kz.edu.astanait.models.Reader;

public interface IReaderController extends CRUD<Reader>{
    Reader getByIin(String iin);
}
