/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paises;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import net.webservicex.Airport;
import net.webservicex.AirportSoap;
import net.webservicex.GlobalWeather;
import net.webservicex.GlobalWeatherSoap;

/**
 *
 * @author gemor_000
 */
@WebService(serviceName = "paises")
public class paises {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "obtenerCiudades")
    public String [] obtenerCiudades(@WebParam(name = "pais") String pais) {
        String [] respuesta = new String [2]; 
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gwSoap = gw.getGlobalWeatherSoap();
        String Cities = gwSoap.getCitiesByCountry(pais);
        respuesta[0] = Cities;
        Airport a = new Airport();
        AirportSoap as = a.getAirportSoap();
        String aeropuertos = as.getAirportInformationByCountry(pais);
        respuesta[1] = aeropuertos;
        return respuesta;
    }
}
