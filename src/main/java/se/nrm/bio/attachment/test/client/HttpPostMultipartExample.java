package se.nrm.bio.attachment.test.client;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * 2019-10-11 :
 * https://kodejava.org/how-do-i-do-multipart-upload-using-httpclient/
 *
 * @author ingimar
 */
public class HttpPostMultipartExample {

    public static void main(String[] args) {
        System.out.println("START");
        try {
            HttpPostMultipartExample myclient = new HttpPostMultipartExample();
            myclient.uploadFile();
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(HttpPostMultipartExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("END");
    }

    public void uploadFile() throws IOException, URISyntaxException {

//        String endpoint = "http://httpbin.org/post";
        String endpoint = "http://localhost:8080/BioUploadv03/rest/upload";
        String filePath = "/tmp/testbild-svt-666.jpg";
        File file = new File(filePath);
        FileBody fileBody = new FileBody(file, ContentType.DEFAULT_BINARY);

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("file", fileBody);
        HttpEntity entity = builder.build();

        HttpPost request = new HttpPost(endpoint);
        request.setEntity(entity);

//        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpClient client = HttpClientBuilder.create().build();
        try {
            HttpResponse response = client.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println("statuscode "+statusCode);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

