/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aq;

/**
 *
 * @author tavin
 */

// Exceção para quando um ingresso já foi vendido
public class IngressoJaVendidoException extends Exception {
    public IngressoJaVendidoException(String message) {
        super(message);
    }
}