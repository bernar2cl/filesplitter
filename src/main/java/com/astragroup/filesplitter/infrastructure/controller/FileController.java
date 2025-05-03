package com.astragroup.filesplitter.infrastructure.controller;

import com.astragroup.filesplitter.application.get.GetFileSplitGateway;
import com.astragroup.filesplitter.application.post.PostFileSplitGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class FileController {

    private final GetFileSplitGateway getFileSplitGateway;
    private final PostFileSplitGateway postFileSplitGateway;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/procesar")
    public String procesarArchivo(@RequestParam("archivo") MultipartFile archivo,
                                  @RequestParam("tamSegmento") int tamSegmento,
                                  Model model) throws IOException {

        String nombreOriginal = archivo.getOriginalFilename();
        String baseName = postFileSplitGateway.extraerNombreBase(nombreOriginal);
        String extension = postFileSplitGateway.extraerExtension(nombreOriginal);

        postFileSplitGateway.dividirArchivo(archivo, tamSegmento, baseName, extension);

        List<String> fragmentos = getFileSplitGateway.listarFragmentosOrdenados(baseName, extension);
        model.addAttribute("fragmentos", fragmentos);

        return "resultado";
    }

    @GetMapping("/descargar/{nombreFragmento}")
    public ResponseEntity<Resource> descargarArchivo(@PathVariable String nombreFragmento) throws IOException {
        return getFileSplitGateway.descargarFragmento(nombreFragmento);
    }
}