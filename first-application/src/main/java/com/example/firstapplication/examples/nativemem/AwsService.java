package com.example.firstapplication.examples.nativemem;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.async.AsyncRequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3CrtAsyncClientBuilder;

import java.net.URI;
import java.nio.file.Paths;

@Slf4j
class AwsService {
    private static final String BUCKET = "temp-bucket";
    private static final String NAME = "object_name.tmp";
    private static final Region REGION = Region.US_EAST_1;
    private static final String FILE_TO_UPLOAD = "/tmp/to_upload.tmp";
    private static final String ACCESS_KEY_ID = "test";
    private static final String SECRET_ACCESS_KEY = "test";

    @SneakyThrows
    void upload() {
        S3CrtAsyncClientBuilder s3CrtAsyncClientBuilder = S3AsyncClient.crtBuilder()
                .endpointOverride(new URI("http://127.0.0.1:4566"))
                .credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create(ACCESS_KEY_ID, SECRET_ACCESS_KEY)))
                .region(REGION);

        try (S3AsyncClient s3Client = s3CrtAsyncClientBuilder.build()) {
            s3Client
                    .putObject(
                            req -> req.bucket(BUCKET).key(NAME),
                            AsyncRequestBody.fromFile(Paths.get(FILE_TO_UPLOAD)))
                    .join();
        }
    }
}
