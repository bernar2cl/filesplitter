package com.astragroup.filesplitter.application.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class PostFileSplitGateway {
    private final PostFileSplitService postFileSplitService;

    public void dividirArchivo(MultipartFile archivo, int tamSegmento, String baseName, String extension) throws IOException {
        postFileSplitService.dividirArchivo(archivo, tamSegmento, baseName, extension);
    }

    public String extraerNombreBase(String nombreArchivo) {
        return postFileSplitService.extraerNombreBase(nombreArchivo);
    }

    public String extraerExtension(String nombreArchivo) {
        return postFileSplitService.extraerExtension(nombreArchivo);
    }
}
