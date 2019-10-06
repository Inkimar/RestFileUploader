package se.nrm.bio.attachment;

import java.io.InputStream;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Metadata;

public class Analysis {

	public static Metadata fetchMetadata(InputStream inputStream)  {

		Metadata metadata = new Metadata();
        try {
			 metadata = ImageMetadataReader.readMetadata(inputStream);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return metadata;
	}

}
