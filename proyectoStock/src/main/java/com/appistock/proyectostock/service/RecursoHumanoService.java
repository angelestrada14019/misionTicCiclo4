package com.appistock.proyectostock.service;


import com.appistock.proyectostock.converter.ProveedorConverter;
import com.appistock.proyectostock.converter.RecursoHumanoConverter;
import com.appistock.proyectostock.dtos.LoginRequestDto;
import com.appistock.proyectostock.dtos.LoginResponseProveedorDto;
import com.appistock.proyectostock.dtos.LoginResponseRecursoHumanoDto;
import com.appistock.proyectostock.entity.Proveedor;
import com.appistock.proyectostock.entity.RecursoHumano;
import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.RecursoHumanoRepository;

import com.appistock.proyectostock.validator.RecursoHumanoValidator;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class RecursoHumanoService {

    @Autowired
    private RecursoHumanoRepository recursohumanoRepository;

    @Value("${jwt.contraseniaR}")
    private String jwtSecret;

    private RecursoHumanoConverter recursoHumanoConverter=new RecursoHumanoConverter();

    public List<RecursoHumano> findAll() {
        try {
            List<RecursoHumano> recursoHumanos = recursohumanoRepository.findAll();
            return recursoHumanos;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public RecursoHumano findById(Long id) {
        try {
            RecursoHumano objRecursoHumano = recursohumanoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            return objRecursoHumano;
        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }

    @Transactional
    public RecursoHumano create(RecursoHumano recursoHumano) {
        try {
            RecursoHumano existeProveedor=recursohumanoRepository.findByemail(recursoHumano.getEmail())
                    .orElse(null);
            if (existeProveedor != null){
                throw new ValidateServiceExceptions("El email ya existe");
            }
            RecursoHumanoValidator.validador(recursoHumano);
            RecursoHumano objRecursoHumano = recursohumanoRepository.save(recursoHumano);
            return objRecursoHumano;
        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }

    @Transactional
    public RecursoHumano update( RecursoHumano recursoHumano) {
        try {
            RecursoHumanoValidator.validador(recursoHumano);
            RecursoHumano objRecursoHumano = recursohumanoRepository.findById(recursoHumano.getId())
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + recursoHumano.getId()));
            objRecursoHumano.setApellido(recursoHumano.getApellido());
            objRecursoHumano.setNombre(recursoHumano.getNombre());
            objRecursoHumano.setCargoId(recursoHumano.getCargoId());
            objRecursoHumano.setContrasenia(recursoHumano.getContrasenia());
            objRecursoHumano.setEmail(recursoHumano.getEmail());
            recursohumanoRepository.save(objRecursoHumano);
            return objRecursoHumano;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }
    @Transactional
    public void delete( Long id) {
        try {
            RecursoHumano objRecursoHumano = recursohumanoRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el producto con el id: " + id));
            recursohumanoRepository.delete(objRecursoHumano);

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }
    @Transactional
    public RecursoHumano signUp(RecursoHumano recursoHumano) {
        try {
            RecursoHumano existeProveedor=recursohumanoRepository.findByemail(recursoHumano.getEmail())
                    .orElse(null);
            if (existeProveedor != null){
                throw new ValidateServiceExceptions("El email ya existe");
            }
            RecursoHumanoValidator.validador(recursoHumano);
            RecursoHumano objRecursoHumano = recursohumanoRepository.save(recursoHumano);
            return objRecursoHumano;
        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }
    public LoginResponseRecursoHumanoDto login(LoginRequestDto loginRequestDto){
        try {
            RecursoHumano recursoHumano=recursohumanoRepository.findByemail(loginRequestDto.getEmail())
                    .orElseThrow(()-> new ValidateServiceExceptions("Email o contraseña incorrecta"));
            if (!recursoHumano.getContrasenia().equals(loginRequestDto.getContrasenia())){
                throw new  ValidateServiceExceptions("Email o contraseña incorrecta");
            }
            String token =createToken(recursoHumano);

            return new LoginResponseRecursoHumanoDto(recursoHumanoConverter.fromEntity(recursoHumano),token);

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }
    public String createToken(RecursoHumano recursoHumano){
        Date now=new Date();
        Date expireDate=new Date(now.getTime()+(1000*60*60));//expire en 1 hora
        return Jwts.builder()
                .setSubject(recursoHumano.getEmail())
                .setId(recursoHumano.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512,jwtSecret).compact();

    }
    public Boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        }catch (UnsupportedJwtException e){
            log.error(" jwt en un formato particular de configuracion no coincide con el esperado");
        }catch (MalformedJwtException e){
            log.error("El token no se construyo correctamente y debe rechazarse");
        }catch (SignatureException e){
            log.error("Error al calcular una firma o verificar una firma existente de un jwt");
        }catch (ExpiredJwtException e){
            log.error("jwt debe ser rechazado porque cumplio su fecha de vencimiento");
        }
        return false;
    }
    public String getEmailFromToken(String token){
        try {
            return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();

        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new ValidateServiceExceptions("Token invalido");
        }
    }
}
