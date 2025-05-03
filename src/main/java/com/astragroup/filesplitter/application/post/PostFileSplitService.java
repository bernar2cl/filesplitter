package com.astragroup.filesplitter.application.post;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.*;

@Service
public class PostFileSplitService {

    private final Path uploadDir = Paths.get("uploads");

    public PostFileSplitService() throws IOException {
        Files.createDirectories(uploadDir);
    }

    public void dividirArchivo(MultipartFile archivo, int tamSegmento, String baseName, String extension) throws IOException {
        byte[] buffer = new byte[tamSegmento];
        int contador = 0;

        try (InputStream is = archivo.getInputStream()) {
            int bytesLeidos;
            while ((bytesLeidos = is.read(buffer)) > 0) {
                String nombreFragmento = formatearNombreFragmento(baseName, contador, extension);
                Path fragmento = uploadDir.resolve(nombreFragmento);
                try (OutputStream os = Files.newOutputStream(fragmento)) {
                    os.write(buffer, 0, bytesLeidos);
                }
                contador++;
            }
        }
    }

    public String extraerNombreBase(String nombreArchivo) {
        return nombreArchivo.substring(0, nombreArchivo.lastIndexOf('.'));
    }

    public String extraerExtension(String nombreArchivo) {
        return nombreArchivo.substring(nombreArchivo.lastIndexOf('.')); // incluye el punto
    }

    private String formatearNombreFragmento(String baseName, int indice, String extension) {
        return baseName + "." + indice + extension;
    }
}
