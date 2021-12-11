package com.appistock.proyectostock.security;

import com.appistock.proyectostock.entity.Proveedor;
import com.appistock.proyectostock.exceptions.NoDataFoundExceptions;
import com.appistock.proyectostock.repository.ProveedorRepository;
import com.appistock.proyectostock.service.ProveedorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class TokenAuthenticationFilterP extends OncePerRequestFilter {
    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private ProveedorRepository proveedorRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String jwt =getJwtFromRequest(request);
            if (StringUtils.hasText(jwt)&& proveedorService.validateToken(jwt)){
                String email=proveedorService.getEmailFromToken(jwt);
                log.info(email);
                Proveedor proveedor=proveedorRepository.findByemail(email)
                        .orElseThrow(()-> new NoDataFoundExceptions("No existe el usuario"));

                UserProveedorPrincipal principal=UserProveedorPrincipal.create(proveedor);
                UsernamePasswordAuthenticationToken authenticationToken=new
                        UsernamePasswordAuthenticationToken(
                                principal,null,principal.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }

        }catch (Exception e){
            log.error("Error al autenticar al usuario",e);
        }
        filterChain.doFilter(request,response);
    }
    public String getJwtFromRequest(HttpServletRequest request){
        String bearerToken=request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7,bearerToken.length());
        }
        return null;
    }
}
