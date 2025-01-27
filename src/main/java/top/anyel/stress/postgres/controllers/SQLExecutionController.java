package top.anyel.stress.postgres.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.anyel.stress.dto.JsonResponseDto;
import top.anyel.stress.postgres.services.SQLExecutionService;

import java.util.HashMap;
import java.util.Map;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 26/01/2025
 */
@RestController
@RequestMapping("/api/v1/postgres/sql")
public class SQLExecutionController {

    @Autowired
    private SQLExecutionService sqlExecutionService;

    /**
     * Endpoint para ejecutar el archivo SQL predeterminado.
     *
     * @return JsonResponseDto con el resultado de la operación.
     */
    @PostMapping("/execute-default")
    public JsonResponseDto executeDefaultSQLFile() {
        try {
            String filePath = "postgresql/northwind.sql";
            sqlExecutionService.executeSQLFromFile(filePath);
            return new JsonResponseDto(true, 200, "Archivo SQL ejecutado con éxito.", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResponseDto(false, 500, "Error al ejecutar el archivo SQL: " + e.getMessage(), null);
        }
    }

    /**
     * Endpoint para ejecutar un archivo SQL específico.
     *
     * @param filePath Ruta del archivo SQL en resources.
     * @return JsonResponseDto con el resultado de la operación.
     */
    @PostMapping("/execute")
    public JsonResponseDto executeSQLFile(@RequestParam("filePath") String filePath) {
        try {
            sqlExecutionService.executeSQLFromFile(filePath);
            Map<String, String> additionalInfo = new HashMap<>();
            additionalInfo.put("filePath", filePath);
            return new JsonResponseDto(true, 200, "Archivo SQL ejecutado con éxito.", additionalInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResponseDto(false, 500, "Error al ejecutar el archivo SQL: " + e.getMessage(), null);
        }
    }
}