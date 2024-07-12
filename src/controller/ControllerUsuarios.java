package controller;

import DAO.*;
import DTO.PracticasDTO;
import DTO.ReglaDTO;
import DTO.UsuarioDTO;
import model.*;
import model.enums.TipoValor;

import java.util.ArrayList;

public class ControllerUsuarios {
    public ArrayList<PracticasDTO> getListaPracticasDTO() {
        return listaPracticasDTO;
    }

    private static ControllerUsuarios instancia;
    ArrayList<UsuarioSistema> listaUsuarios;
    ArrayList<Practicas> listaPracticas;
    ArrayList<Regla> listaReglas;
    public ArrayList<PracticasDTO> listaPracticasDTO;
    public ArrayList<UsuarioDTO> listaUsuariosDTO;
    public ArrayList<ReglaDTO> listaReglaDTO;
    public ArrayList<UsuarioDTO> getListaUsuariosDTO() {return listaUsuariosDTO; }
    public ArrayList<ReglaDTO> getListaReglaDTO() {return listaReglaDTO;}


    //SINGLETON
    public static ControllerUsuarios getInstancia() {
        if (instancia == null)
            instancia = new ControllerUsuarios();
        return instancia;
    }

    public void setListaUsuarios(ArrayList<UsuarioSistema> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Practicas> getListaPracticas() {
        return listaPracticas;
    }

    public ArrayList<UsuarioSistema> getListaUsuarios() {
        return listaUsuarios;
    }

    public ArrayList<Regla> getListaReglas() {
        return listaReglas;
    }

    //CONSTRUCTOR
    public ControllerUsuarios() {
        listaUsuarios= new ArrayList<UsuarioSistema>();
        listaPracticas= new ArrayList<Practicas>();
        listaReglas  = new ArrayList<Regla>();
        listaPracticasDTO = new ArrayList<PracticasDTO>();
        listaUsuariosDTO = new ArrayList<UsuarioDTO>();
        listaReglaDTO = new ArrayList<ReglaDTO>();
        ReglaDAO reglaDAO = null;
        ReglaDTODAO reglaDTODAO = null;
        PracticasDAO practicasDAO = null;
        PracticasDTODAO practicasDTODAO = null;
        UsuarioSistemaDAO usuarioSistemaDAO = null;
        UsuarioSistemaDTODAO usuarioSistemaDTODAO = null;
        try {
            reglaDAO = new ReglaDAO();
            reglaDTODAO = new ReglaDTODAO();
            listaReglas = (ArrayList<Regla>) reglaDAO.getAll();
            listaReglaDTO = (ArrayList<ReglaDTO>) reglaDTODAO.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            practicasDAO = new PracticasDAO();
            listaPracticas = (ArrayList<Practicas>) practicasDAO.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            practicasDTODAO = new PracticasDTODAO();
            listaPracticasDTO = (ArrayList<PracticasDTO>) practicasDTODAO.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            usuarioSistemaDAO = new UsuarioSistemaDAO();
            listaUsuarios = (ArrayList<UsuarioSistema>) usuarioSistemaDAO.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            usuarioSistemaDTODAO = new UsuarioSistemaDTODAO();
            listaUsuariosDTO = (ArrayList<UsuarioDTO>) usuarioSistemaDTODAO.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void cerrarController() {
        ReglaDAO reglaDAO = null;
        ReglaDTODAO reglaDTODAO = null;
        PracticasDAO practicasDAO = null;
        PracticasDTODAO practicasDTODAO = null;
        UsuarioSistemaDAO usuarioSistemaDAO = null;
        UsuarioSistemaDTODAO usuarioSistemaDTODAO = null;
        try {
            reglaDAO = new ReglaDAO();
            reglaDAO.saveAll(listaReglas);
            reglaDTODAO = new ReglaDTODAO();
            reglaDTODAO.saveAll(listaReglaDTO);
            practicasDAO = new PracticasDAO();
            practicasDAO.saveAll(listaPracticas);
            practicasDTODAO = new PracticasDTODAO();
            practicasDTODAO.saveAll(listaPracticasDTO);
            usuarioSistemaDAO = new UsuarioSistemaDAO();
            usuarioSistemaDAO.saveAll(listaUsuarios);
            usuarioSistemaDTODAO = new UsuarioSistemaDTODAO();
            usuarioSistemaDTODAO.saveAll(listaUsuariosDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //METODOS:

    //ALTA USUARIOS
    public void altaUsuario(UsuarioDTO usuarioDTO) {
        UsuarioSistema usuarioSistema = new UsuarioSistema(usuarioDTO.NroUsuario, usuarioDTO.email, usuarioDTO.password,
                usuarioDTO.nombre, usuarioDTO.domicilio, usuarioDTO.DNI, usuarioDTO.nacimiento, usuarioDTO.rol);
        listaUsuarios.add(usuarioSistema);
        listaUsuariosDTO.add(usuarioDTO);

    }

    //BAJA USUARIOS
    public void bajaUsuario(UsuarioDTO usuarioDTO) {
        UsuarioSistema usuBaja = null;
        for (UsuarioSistema usuario: listaUsuarios)
            if (usuario.getNroUsuario() == usuarioDTO.NroUsuario) {
                usuBaja = usuario;
            }
        listaUsuarios.remove(usuBaja);
        listaUsuariosDTO.remove(usuarioDTO);

    }


    //MODIFICACION USUARIOS
    public void modificacionUsuario(UsuarioDTO usuMod) {
        for (UsuarioDTO usuarioDTO : listaUsuariosDTO)
            if (usuarioDTO.NroUsuario == usuMod.NroUsuario) {
                usuarioDTO.DNI = usuMod.DNI;
                usuarioDTO.email=usuMod.email;
                usuarioDTO.password=usuMod.password;
                usuarioDTO.nombre=usuMod.nombre;
                usuarioDTO.domicilio=usuMod.domicilio;
                usuarioDTO.nacimiento= usuMod.nacimiento;
                usuarioDTO.rol=usuMod.rol;
            }
        for (UsuarioSistema usuario: getListaUsuarios() ) {
            if (usuario.getNroUsuario() == usuMod.NroUsuario) {
                usuario.setDNI(usuMod.DNI);
                usuario.setEmail(usuMod.email);
                usuario.setPassword(usuMod.password);
                usuario.setNombre(usuMod.nombre);
                usuario.setDomicilio(usuMod.domicilio);
                usuario.setNacimiento(usuMod.nacimiento);
                usuario.setRol(usuMod.rol);
            }
        }
    }


    //ALTA PRACTICA
    public void altaPractica(PracticasDTO practicaDTO) {
        Practicas practica = new Practicas(practicaDTO.codigo, practicaDTO.nombrePractica, practicaDTO.grupo, practicaDTO.horasResultado);
        for (Regla regla: listaReglas)
            if (regla.getCodigo() == practicaDTO.regla.codigo)
                practica.setRegla(regla);
        listaPracticas.add(practica);
        listaPracticasDTO.add(practicaDTO);
    }

    //BAJA PRACTICA
    public void bajaPractica(PracticasDTO practicasDTO) { //REGLA DE NEGOCIO
        Practicas practBja= null;
        boolean usado= false;
        for (Practicas practicas: getListaPracticas()) {
            if (practicas.getCodigo() == practicasDTO.codigo)
                practBja=practicas;
        }
        for (Peticiones p : ControllerPeticiones.getInstancia().getListaPeticiones()){
            if (p.getPracticaAsociada().getCodigo() == practicasDTO.codigo) {
                usado = true;
            }
        }
        if(usado){ //INHABILITAR
            listaPracticasDTO.remove(practicasDTO);
        }else {
            listaPracticas.remove(practBja);
            listaPracticasDTO.remove(practicasDTO);

        }
    }


    //MODIF PRACTICA
    public void modificacionPractica(PracticasDTO practicasDTO) {
        for (PracticasDTO practicasDTO1: listaPracticasDTO)
            if (practicasDTO1.codigo==practicasDTO.codigo) {
                practicasDTO1.codigo=practicasDTO.codigo;
                practicasDTO1.grupo=practicasDTO.grupo;
            }
        for (Practicas practica: listaPracticas ) {
            if (practica.getCodigo() == practicasDTO.codigo) {
                practica.setNombrePractica(practicasDTO.nombrePractica);
                practica.setGrupo(practicasDTO.grupo);
            }

        }
    }


    public void altaRegla(ReglaDTO reglaDTO) {
        Regla regla = new Regla(reglaDTO.codigo, reglaDTO.tipoValor, reglaDTO.valorReservado);
        if (regla.getTipoValor() == TipoValor.NUMERICO) {
            regla.setTipoRango(reglaDTO.tipoRango);
            regla.setValorCritico(reglaDTO.valorCritico);
        }
        listaReglas.add(regla);
        listaReglaDTO.add(reglaDTO);
    }

    public void bajaRegla(ReglaDTO reglaDTO) {
        Regla reglaBaja = null;
        for (Regla regla: listaReglas)
            if (regla.getCodigo() == reglaDTO.codigo) {
                reglaBaja = regla;
            }
        listaReglas.remove(reglaBaja);
        listaReglaDTO.remove(reglaDTO);
    }

}
