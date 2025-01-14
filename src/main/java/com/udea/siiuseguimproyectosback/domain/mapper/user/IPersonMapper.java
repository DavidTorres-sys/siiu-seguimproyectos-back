package com.udea.siiuseguimproyectosback.domain.mapper.user;

import com.udea.siiuseguimproyectosback.domain.dto.user.PersonDTO;
import com.udea.siiuseguimproyectosback.domain.entity.user.Person;
import com.udea.siiuseguimproyectosback.domain.mapper.IEntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPersonMapper extends IEntityMapper<PersonDTO, Person> { }
