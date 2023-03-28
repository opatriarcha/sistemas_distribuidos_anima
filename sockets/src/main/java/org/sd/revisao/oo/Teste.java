/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sd.revisao.oo;

/**
 *
 * @author orlando
 */
public class Teste {
    public static void main(String[] args) {
        Fatura fatura = new Fatura("1", "gasosa", 20, 6.00);
        System.out.println(fatura.getTotalFatura());
    }
}
