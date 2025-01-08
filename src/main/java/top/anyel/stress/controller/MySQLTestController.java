package top.anyel.stress.controller;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 08/01/2025
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/mysql")
public class MySQLTestController {


    @GetMapping("/test")
    public String testConnection() {
        return "Conexión a MySQL exitosa!";
    }

}