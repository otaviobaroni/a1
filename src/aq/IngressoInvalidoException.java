/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aq;

//Exceção para ingressos inválidos
public class IngressoInvalidoException extends Exception {
    public IngressoInvalidoException(String message) {
        super(message);
    }
}
