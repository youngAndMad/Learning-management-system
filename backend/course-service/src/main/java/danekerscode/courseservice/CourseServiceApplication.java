package danekerscode.courseservice;

import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner runner(
			MinioClient minioClient
	){
	return args -> {
		minioClient.makeBucket(
				MakeBucketArgs
						.builder()
						.bucket("user1")
						.build()
		);
		};
	}
}
