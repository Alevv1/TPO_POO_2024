package controller;

import DAO.*;
import DTO.*;

import model.*;
import model.enums.TipoEstado;
import model.enums.TipoRango;
import model.enums.TipoValor;

import java.util.ArrayList;

public class ControllerPeticiones {

    private static ControllerPeticiones instancia;

    private  ArrayList<Peticiones> listaPeticiones;
    private  ArrayList<Resultado> listaResultados;
    public ArrayList<PeticionesDTO> listaPeticionesDTO;
    public ArrayList<ResultadoPeticionDTO> listaResultadosDTO;

    public ArrayList<ResultadoPeticionDTO> getListaResultadosDTO() {
        return listaResultadosDTO;
    }

    //SINGLETON
    public static ControllerPeticiones getInstancia() {
        if (instancia == null)
            instancia = new ControllerPeticiones();
        return instancia;
    }

    //CONSTRUCTOR
    public ControllerPeticiones() {
        listaPeticiones = new ArrayList<Peticiones>();
        listaResultados = new ArrayList<Resultado>();
        listaPeticionesDTO = new ArrayList<PeticionesDTO>();
        listaResultadosDTO = new ArrayList<ResultadoPeticionDTO>();
        ResultadoDAO resultadoDAO = null;
        ResultadoDTODAO resultadoDTODAO = null;
        PeticionesDAO peticionesDAO = null;
        PeticionesDTODAO peticionesDTODAO = null;
        try {
            resultadoDAO = new ResultadoDAO();
            listaResultados = (ArrayList<Resultado>) resultadoDAO.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            resultadoDTODAO = new ResultadoDTODAO();
            listaResultadosDTO = (ArrayList<ResultadoPeticionDTO>) resultadoDTODAO.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            peticionesDAO = new PeticionesDAO();
            listaPeticiones = (ArrayList<Peticiones>) peticionesDAO.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            peticionesDTODAO = new PeticionesDTODAO();
            listaPeticionesDTO = (ArrayList<PeticionesDTO>) peticionesDTODAO.getAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void cerrarController() {
        ResultadoDAO resultadoDAO = null;
        ResultadoDTODAO resultadoDTODAO = null;
        PeticionesDAO peticionesDAO = null;
        PeticionesDTODAO peticionesDTODAO = null;
        try {
            resultadoDAO = new ResultadoDAO();
            resultadoDAO.saveAll(listaResultados);
            resultadoDTODAO = new ResultadoDTODAO();
            resultadoDTODAO.saveAll(listaResultadosDTO);
            peticionesDAO = new PeticionesDAO();
            peticionesDAO.saveAll(listaPeticiones);
            peticionesDTODAO = new PeticionesDTODAO();
            peticionesDTODAO.saveAll(listaPeticionesDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

     //GETTER Y SETTERS
     public ArrayList<Peticiones> getListaPeticiones() {
         return listaPeticiones;
     }
     public ArrayList<PeticionesDTO> getListaPeticionesDTO() {
        return listaPeticionesDTO;
     }


    public ArrayList<Resultado> getListaResultados() {
        return listaResultados;
    }


    //ABM RESULTADOS
    public void altaResultados(ResultadoPeticionDTO resultadoPeticionDTO) {
        Peticiones peticion = null;
        PeticionesDTO peticionDTO = null;
        for (Peticiones peticiones: listaPeticiones)
            if (peticiones.getNroPeticion() == resultadoPeticionDTO.peticion.nroPeticion)
                peticion = peticiones;
        Resultado resultado = new Resultado(resultadoPeticionDTO.ID, resultadoPeticionDTO.valorNumerico, resultadoPeticionDTO.valorBooleano, peticion);
        for (PeticionesDTO peticionesDTO: listaPeticionesDTO)
            if (peticionesDTO.nroPeticion == peticion.getNroPeticion())
                peticionDTO = peticionesDTO;
        peticionDTO.resultadoDTO = resultadoPeticionDTO.ID;
        if (peticionDTO.practicaAsociada.regla.tipoValor.equals(TipoValor.NUMERICO) && peticionDTO.practicaAsociada.regla.tipoRango == TipoRango.mayorA) {
            if (resultadoPeticionDTO.valorNumerico > peticionDTO.practicaAsociada.regla.valorCritico) {
                resultado.setEsValorCritico();
                resultadoPeticionDTO.esValorCritico = true;
            }
        } else if (peticionDTO.practicaAsociada.regla.tipoValor.equals(TipoValor.NUMERICO) && peticionDTO.practicaAsociada.regla.tipoRango == TipoRango.igual) {
            if (resultadoPeticionDTO.valorNumerico == peticionDTO.practicaAsociada.regla.valorCritico) {
                resultado.setEsValorCritico();
                resultadoPeticionDTO.esValorCritico = true;
            }
        } else if (peticionDTO.practicaAsociada.regla.tipoValor.equals(TipoValor.NUMERICO) && peticionDTO.practicaAsociada.regla.tipoRango == TipoRango.menorA) {
            if (resultadoPeticionDTO.valorNumerico < peticionDTO.practicaAsociada.regla.valorCritico) {
                resultado.setEsValorCritico();
                resultadoPeticionDTO.esValorCritico = true;
            }
        } else if (peticionDTO.practicaAsociada.regla.tipoValor.equals(TipoValor.BOOLEAN) && resultadoPeticionDTO.valorBooleano==true) {
                resultado.setEsValorCritico();
                resultadoPeticionDTO.esValorCritico = true;
        }
        if (peticionDTO.practicaAsociada.regla.valorReservado) {
            resultado.setEsValorReservado(true);
            resultadoPeticionDTO.esValorReservado = true;
        }
        listaResultados.add(resultado);
        listaResultadosDTO.add(resultadoPeticionDTO);
        peticion.setResultado(resultado.getID());


        peticionDTO.estado = TipoEstado.Con_Resultados;
        modificacionPeticion(peticionDTO);


    }

    public void bajaResultados(ResultadoPeticionDTO resultadoPeticionDTO) {
        Resultado resuBaja = null;
        for (Resultado resultado: listaResultados)
            if (resultado.getID() == resultadoPeticionDTO.ID) {
                resuBaja = resultado;
            }
        listaResultados.remove(resuBaja);
        listaResultadosDTO.remove(resultadoPeticionDTO);

    }

    public void modificacionResultado(ResultadoPeticionDTO resuMod) {
        Resultado resultadoModificado = null;
        PeticionesDTO peticionDTO = resuMod.peticion;

        for (Resultado resultado: listaResultados)
            if (resultado.getID() == resuMod.ID)
                resultadoModificado = resultado;
        resultadoModificado.setValorNumerico(resuMod.valorNumerico);
        resultadoModificado.setValorBooleano(resuMod.valorBooleano);


         if (peticionDTO.practicaAsociada.regla.tipoValor.equals(TipoValor.NUMERICO) && peticionDTO.practicaAsociada.regla.tipoRango == TipoRango.mayorA) {
                if (resuMod.valorNumerico > peticionDTO.practicaAsociada.regla.valorCritico) {
                    resultadoModificado.setEsValorCritico();
                    resuMod.esValorCritico = true;
                }
            } else if (peticionDTO.practicaAsociada.regla.tipoValor.equals(TipoValor.NUMERICO) && peticionDTO.practicaAsociada.regla.tipoRango == TipoRango.igual) {
                if (resuMod.valorNumerico == peticionDTO.practicaAsociada.regla.valorCritico) {
                    resultadoModificado.setEsValorCritico();
                    resuMod.esValorCritico = true;
                }
            } else if (peticionDTO.practicaAsociada.regla.tipoValor.equals(TipoValor.NUMERICO) && peticionDTO.practicaAsociada.regla.tipoRango == TipoRango.menorA) {
                if (resuMod.valorNumerico < peticionDTO.practicaAsociada.regla.valorCritico) {
                    resultadoModificado.setEsValorCritico();
                    resuMod.esValorCritico = true;
                }
            } else if (peticionDTO.practicaAsociada.regla.tipoValor.equals(TipoValor.BOOLEAN) && resuMod.valorBooleano==true) {
                 resultadoModificado.setEsValorCritico();
                 resuMod.esValorCritico = true;
         }

        if (peticionDTO.practicaAsociada.regla.valorReservado) {
            resultadoModificado.setEsValorReservado(true);
            resuMod.esValorReservado = true;
        }

        for (ResultadoPeticionDTO resultadoPeticionDTO : listaResultadosDTO)
            if (resultadoPeticionDTO.ID==resuMod.ID) {
                resultadoPeticionDTO.valorNumerico = resuMod.valorNumerico;
                resultadoPeticionDTO.valorBooleano = resuMod.valorBooleano;
                resultadoPeticionDTO.esValorCritico = resuMod.esValorCritico;
                resultadoPeticionDTO.esValorReservado = resuMod.esValorReservado;
            }
        for (PeticionesDTO peticion: listaPeticionesDTO)
            if (peticion.nroPeticion == resuMod.peticion.nroPeticion) {
                peticion.resultadoDTO = resuMod.ID;
                modificacionPeticion(peticion);
            }
    }


    //ABM PETICIONES
    public void altaPeticion(PeticionesDTO peticionesDTO) {
        Paciente pacientePeticion = null;
        for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
            if (paciente.getDNI() == peticionesDTO.paciente)
                pacientePeticion = paciente;
        Sucursal sucursalPeticion = null;
        for (Sucursal sucursal: ControllerSucursal.getInstancia().getListaSucursal())
            if (sucursal.getNumero() == peticionesDTO.sucursal)
                sucursalPeticion = sucursal;
        Practicas practicaAsociada = null;
        for (Practicas practica: ControllerUsuarios.getInstancia().getListaPracticas())
            if (practica.getCodigo() == peticionesDTO.practicaAsociada.codigo)
                practicaAsociada = practica;
        Peticiones peticion = new Peticiones(pacientePeticion.getDNI(), sucursalPeticion.getNumero(),practicaAsociada, peticionesDTO.ObraSocial, peticionesDTO.fechaCarga , peticionesDTO.fechaEntrega, peticionesDTO.estado, peticionesDTO.nroPeticion);
        for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
            if (paciente.getDNI() == peticionesDTO.paciente)
                paciente.AgregarPeticion(peticion);
        Paciente pac = null;
        for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
            if (paciente.getDNI() == peticionesDTO.paciente)
                pac = paciente;

        for (Sucursal sucursal: ControllerSucursal.getInstancia().getListaSucursal())
            if (sucursal.getNumero() == peticionesDTO.sucursal) {
                sucursal.agregarPeticion(peticion);
                sucursal.agregarPaciente(pac);
            }
        listaPeticiones.add(peticion);
        listaPeticionesDTO.add(peticionesDTO);
    }

    public void bajaPeticion(PeticionesDTO peticionBaja) {
        Peticiones petBaja = null;
        for (Peticiones peticion: listaPeticiones)
            if (peticion.getNroPeticion() == peticionBaja.nroPeticion)
                petBaja = peticion;

        for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
            if (paciente.getDNI() == peticionBaja.paciente)
                paciente.getListaPeticionesPaciente().remove(petBaja);
        listaPeticiones.remove(petBaja);
        listaPeticionesDTO.remove(peticionBaja);
    }

    public void modificacionPeticion(PeticionesDTO peticionMod) {
        for (PeticionesDTO peticionesDTO: listaPeticionesDTO)
            if (peticionesDTO.nroPeticion==peticionMod.nroPeticion) {
                peticionesDTO.paciente=peticionMod.paciente;
                peticionesDTO.sucursal=peticionMod.sucursal;
                peticionesDTO.estado=peticionMod.estado;
                peticionesDTO.ObraSocial=peticionMod.ObraSocial;
                peticionesDTO.fechaCarga=peticionMod.fechaCarga;
                peticionesDTO.fechaEntrega=peticionMod.fechaEntrega;
                peticionesDTO.practicaAsociada=peticionMod.practicaAsociada;
                peticionesDTO.resultadoDTO = peticionMod.resultadoDTO;
            }
        Resultado resultadoMod = null;
        for (Resultado resultado: listaResultados)
            if (resultado.getID() == peticionMod.resultadoDTO)
                resultadoMod = resultado;

        for (Peticiones peticion: listaPeticiones) {
            if (peticion.getNroPeticion() == peticionMod.nroPeticion) {
                peticion.setObraSocial(peticionMod.ObraSocial);
                peticion.setFechaEntrega(peticionMod.fechaEntrega);
                peticion.setFechaCarga(peticionMod.fechaCarga);
                peticion.setEstado(peticionMod.estado);
                if (resultadoMod != null)
                    peticion.setResultado(resultadoMod.getID());
                for (Paciente paciente: ControllerSucursal.getInstancia().getListaPacientes())
                    if (paciente.getDNI() == peticionMod.paciente)
                        peticion.setPaciente(paciente.getDNI());
                for (Sucursal sucursal: ControllerSucursal.getInstancia().getListaSucursal())
                    if (sucursal.getNumero() == peticionMod.sucursal) {
                        peticion.setSucursal(sucursal.getNumero());
                    }
                for (Practicas practica: ControllerUsuarios.getInstancia().getListaPracticas())
                    if (practica.getCodigo() == peticionMod.practicaAsociada.codigo)
                        peticion.setPracticaAsociada(practica);
                }
            }
        }

    public boolean tieneResultadoValorCritico(PeticionesDTO peticionesDTO) {
        ResultadoPeticionDTO resu = null;
        for (ResultadoPeticionDTO resultadoPeticionDTO : listaResultadosDTO)
            if (peticionesDTO.resultadoDTO == resultadoPeticionDTO.ID)
                resu = resultadoPeticionDTO;
        return (resu.esValorCritico);
    }
    public boolean tieneResultadoValorReservado(PeticionesDTO peticionesDTO) {
        ResultadoPeticionDTO resu = null;
        for (ResultadoPeticionDTO resultadoPeticionDTO : listaResultadosDTO)
            if (peticionesDTO.resultadoDTO == resultadoPeticionDTO.ID)
                resu = resultadoPeticionDTO;
        return (resu.esValorReservado);
    }

}
