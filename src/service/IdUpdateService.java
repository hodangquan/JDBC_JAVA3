/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author hodangquan
 */
public class IdUpdateService {

    private static Integer id;

    public IdUpdateService() {
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        IdUpdateService.id = id;
    }
}
