/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guillaumerenaudin.filenametoolong;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

/**
 *
 * @author guillaumerenaudin
 */
public class DeleteDir {

    public static void main(String[] args) throws IOException {

        deleteFile(Paths.get(args[0]));

    }

    public static void deleteFile(Path file) throws IOException {
        if (file != null && Files.exists(file)) {
            if (Files.isDirectory(file)) {

                try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(file.toUri()))) {

                    for (Path childFile : directoryStream) {
                        deleteFile(childFile);
                    }

                } catch (IOException ex) {
                    throw ex;
                }

            }
            Logger.getLogger("DeleteDir").info("delete file "+file);
            Files.delete(file);

        }
    }

}
