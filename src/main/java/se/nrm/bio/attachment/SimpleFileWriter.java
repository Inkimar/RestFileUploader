package se.nrm.bio.attachment;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

public class SimpleFileWriter {
// https://github.com/drewnoakes/metadata-extractor/blob/master/Samples/com/drew/metadata/SampleUsage.java

	public void write(Metadata metadata) {

		Charset utf8 = StandardCharsets.UTF_8;

		StringBuilder builder = new StringBuilder();
		// builder.append("Ingimar");
		for (Directory directory : metadata.getDirectories()) {
			for (Tag tag : directory.getTags()) {
				String tagName = tag.getTagName();
				String description = tag.getDescription();
				builder.append(tag);
				//builder.append(tagName).append(":").append(description);
            }
			
		}

		try (Writer writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream("/home/ingimar/app-ingimar.log"), utf8))) {
			writer.write(builder.toString());
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}

	}

	
}
