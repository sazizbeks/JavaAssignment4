package kz.edu.astanait.api.controllers.interfaces;

import kz.edu.astanait.models.Reader;

import javax.ws.rs.BadRequestException;

public interface IReaderController extends CRUD<Reader>{
    Reader getByIin(String iin) throws BadRequestException;
}
