package com.example.testfornota.controller;

import com.example.testfornota.model.CountCharacter;
import com.example.testfornota.service.HandlerStringService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.example.testfornota.constant.Constants.MAX_LENGTH;

@RestController
@RequestMapping("/handler")
@Tag(name = "Обработчик строк")
public class HandlerStringController {

    private final HandlerStringService handlerStringService;

    public HandlerStringController(HandlerStringService handlerStringService) {
        this.handlerStringService = handlerStringService;
    }

    @GetMapping
    @Operation(
            description = "Обработчик строки",
            summary = "Метод выполняет посимвольный анализ строки, возвращая количество вхождений символов в порядке убывания",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Invalid string length",
                            responseCode = "400"
                    ),
            }
    )
    public ResponseEntity<Set<CountCharacter>> handler(
            @Parameter(description = "Входящая строка. Максимальная длина - 256 символов") final String str) {
        if (str.length() > MAX_LENGTH) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(handlerStringService.handlerString(str));
    }
}
