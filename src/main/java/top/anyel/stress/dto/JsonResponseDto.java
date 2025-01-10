package top.anyel.stress.dto;

/*
 * Author: Anyel EC
 * Github: https://github.com/Anyel-ec
 * Creation date: 09/01/2025
 */
import io.swagger.v3.oas.annotations.media.Schema;
@Schema(description = "Response structure for the entire system")
public record JsonResponseDto(boolean success,
                              int httpCode,
                              String message,
                              Object result) {
}