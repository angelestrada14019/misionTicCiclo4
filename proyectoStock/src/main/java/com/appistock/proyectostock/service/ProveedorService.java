package com.appistock.proyectostock.service;

import com.appistock.proyectostock.converter.ProveedorConverter;
import com.appistock.proyectostock.dtos.LoginRequestDto;
import com.appistock.proyectostock.dtos.LoginResponseProveedorDto;
import com.appistock.proyectostock.entity.Proveedor;

import com.appistock.proyectostock.exceptions.GeneralServicesExceptions;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.exceptions.ValidateServiceExceptions;
import com.appistock.proyectostock.repository.ProveedorRepository;

import com.appistock.proyectostock.validator.ProveedorValidator;
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
public class ProveedorService {

    @Value("${jwt.contraseniaP}")
    private String jwtSecret;

    private ProveedorConverter proveedorConverter=new ProveedorConverter();

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> findAll() {
        try {
            List<Proveedor> proveedores = proveedorRepository.findAll();
            return proveedores;

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }


    public Proveedor findById(Long id) {
        try {
            Proveedor objProveedor = proveedorRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            return objProveedor;
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
    public Proveedor create(Proveedor proveedor) {
        try {
            Proveedor existeProveedor=proveedorRepository.findByemail(proveedor.getEmail())
                    .orElse(null);
            if (existeProveedor != null){
                throw new ValidateServiceExceptions("El email ya existe");
            }
            ProveedorValidator.validador(proveedor);
            Proveedor objProveedor = proveedorRepository.save(proveedor);
            return objProveedor;
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
    public Proveedor update( Proveedor proveedor) {
        try {
            ProveedorValidator.validador(proveedor);
            Proveedor objProveedor = proveedorRepository.findById(proveedor.getId())
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + proveedor.getId()));
            objProveedor.setDescripcion(proveedor.getDescripcion());
            objProveedor.setCategoriaId(proveedor.getCategoriaId());
            objProveedor.setContrasenia(proveedor.getContrasenia());
            objProveedor.setEmail(proveedor.getEmail());
            objProveedor.setDependenciaId(proveedor.getDependenciaId());
            objProveedor.setImportanciaId(proveedor.getImportanciaId());
            proveedorRepository.save(objProveedor);
            return objProveedor;

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
            Proveedor objProveedor = proveedorRepository.findById(id)
                    .orElseThrow(() -> new NoDataFoundExceptions("no existe el id: " + id));
            proveedorRepository.delete(objProveedor);

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
    public Proveedor signUp(Proveedor proveedor) {
        try {
            Proveedor existeProveedor=proveedorRepository.findByemail(proveedor.getEmail())
                    .orElse(null);
            if (existeProveedor != null){
                throw new ValidateServiceExceptions("El email ya existe");
            }
            ProveedorValidator.validador(proveedor);
            Proveedor objProveedor = proveedorRepository.save(proveedor);
            return objProveedor;
        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }

    }
    public LoginResponseProveedorDto login(LoginRequestDto loginRequestDto){
        try {
               Proveedor proveedor=proveedorRepository.findByemail(loginRequestDto.getEmail())
                       .orElseThrow(()-> new ValidateServiceExceptions("Email o contraseña incorrecta"));
               if (!proveedor.getContrasenia().equals(loginRequestDto.getContrasenia())){
                   throw new  ValidateServiceExceptions("Email o contraseña incorrecta");
               }
               String token =createToken(proveedor);

               return new LoginResponseProveedorDto(proveedorConverter.fromEntity(proveedor),token);

        }catch (ValidateServiceExceptions | NoDataFoundExceptions e){
            log.info(e.getMessage(),e);
            throw e;
        }
        catch (Exception e){
            log.error(e.getMessage(),e);
            throw new GeneralServicesExceptions(e.getMessage(),e);
        }
    }
    public String createToken(Proveedor proveedor){
        Date now=new Date();
        Date expireDate=new Date(now.getTime()+(1000*60*60));//expire en 1 hora
        return Jwts.builder()
                .setSubject(proveedor.getEmail())
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
    public String getEmailFromToken(String jwt){
        try {
            return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwt).getBody().getSubject();

        }catch (Exception e){
            log.error(e.getMessage(),e);
            throw new ValidateServiceExceptions("Token invalido");
        }
    }
}
