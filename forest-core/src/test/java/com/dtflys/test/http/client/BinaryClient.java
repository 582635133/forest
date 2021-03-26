package com.dtflys.test.http.client;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.DataFile;
import com.dtflys.forest.annotation.LogEnabled;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.Var;
import com.dtflys.forest.backend.ContentType;

import java.io.File;

public interface BinaryClient {

    @Post(
            url = "http://localhost:${port}/upload-octet-stream/${filename}",
            contentType = ContentType.APPLICATION_OCTET_STREAM
    )
    @LogEnabled(logResponseContent = true)
    String uploadOctetStreamWithByteArray(@Body byte[] body, @Var("filename") String filename);

    @Post(
            url = "http://localhost:${port}/upload-octet-stream/${file.name}",
            contentType = ContentType.APPLICATION_OCTET_STREAM
    )
    @LogEnabled(logResponseContent = true)
    String uploadOctetStreamWithFile(@Body File file, @Var("filename") String filename);


    @Post(
            url = "http://localhost:${port}/upload-octet-stream/${filename}",
            contentType = ContentType.APPLICATION_OCTET_STREAM
    )
    @LogEnabled(logResponseContent = true)
    String uploadOctetStreamWithDataFile(@DataFile("file") File file, @Var("filename") String filename);

}
