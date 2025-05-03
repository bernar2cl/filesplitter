package com.astragroup.filesplitter.application.get.mapper;

import java.nio.file.Path;

public class FileFragmentMapper {

    private static final String DOWNLOAD_PREFIX = "/descargar/";

    public static String toDownloadUrl(Path fragmentPath) {
        return DOWNLOAD_PREFIX + fragmentPath.getFileName().toString();
    }
}
