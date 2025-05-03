package com.astragroup.filesplitter.application.get;

import com.astragroup.filesplitter.application.get.mapper.FileFragmentMapper;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetFileSplitService {

    private final Path uploadDir = Paths.get("uploads");

    public GetFileSplitService() throws IOException {
        Files.createDirectories(uploadDir);
    }

    public ResponseEntity<Resource> descargarFragmento(String nombreFragmento) throws IOException {
        Path archivo = uploadDir.resolve(nombreFragmento);
        Resource recurso = new FileSystemResource(archivo);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(recurso);
    }

    public List<String> listarFragmentosOrdenados(String baseName, String extension) throws IOException {
        return Files.list(uploadDir)
                .filter(path -> esFragmentoDeArchivo(path, baseName, extension))
                .sorted(Comparator.comparingInt(path -> extraerIndice(path.getFileName().toString(), baseName, extension)))
                .map(FileFragmentMapper::toDownloadUrl)
                .collect(Collectors.toList());
    }

    private boolean esFragmentoDeArchivo(Path path, String baseName, String extension) {
        String nombre = path.getFileName().toString();
        return nombre.startsWith(baseName + ".") && nombre.endsWith(extension);
    }

    private int extraerIndice(String nombreArchivo, String baseName, String extension) {
        String sinExtension = nombreArchivo.substring(0, nombreArchivo.lastIndexOf('.'));
        String indiceStr = sinExtension.substring(baseName.length() + 1);
        return Integer.parseInt(indiceStr);
    }
}
