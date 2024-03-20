/**
 * Sistema Integración Divisional API
 * Proyecto personal de Miguel Guzman. \"Sistema de Integración Divisional\" para la empresa Agricultura en la Dirección General de Enlace y Coordinación (DGEC). Esta API está elaborada solo con fines educativos y de practica personal.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: gzm98.miguel@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { NivelesEscolaridadesEnum } from './nivelesEscolaridadesEnum';
import { EstadosNivelesEscolaridadesEnum } from './estadosNivelesEscolaridadesEnum';


/**
 * Escolaridad de una persona u empleado
 */
export interface Escolaridad { 
    nivel: NivelesEscolaridadesEnum;
    carrera: string;
    estadoNivel: EstadosNivelesEscolaridadesEnum;
    cedulaProfesional: string | null;
}
export namespace Escolaridad {
}

