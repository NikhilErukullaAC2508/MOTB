
//
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.databind.DeserializationContext;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
//
//import java.io.IOException;
//import java.sql.Blob;
//
//@SuppressWarnings("serial")
//public class BlobDeserializer extends StdDeserializer<Blob> {
//
//    public BlobDeserializer() {
//        this(null);
//    }
//
//    protected BlobDeserializer(Class<?> vc) {
//        super(vc);
//    }
//
//    @Override
//    public Blob deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
//        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
//        // Assuming you have a method to convert a string to Blob, adjust accordingly
//        return convertStringToBlob(node.asText());
//    }
//
//    private Blob convertStringToBlob(String data) {
//        // Implement your logic to convert the string to Blob
//        // This could involve decoding from Base64, reading from a file, etc.
//        // For example, if your data is a Base64 encoded string, you can use the following:
//        /*
//        byte[] bytes = Base64.getDecoder().decode(data);
//        try {
//            return new javax.sql.rowset.serial.SerialBlob(bytes);
//        } catch (SQLException e) {
//            throw new RuntimeException("Error creating Blob", e);
//        }
//        */
//        return null; // Adjust this line based on your implementation
//    }
//}
//
package com.mot.entity;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

@SuppressWarnings("serial")
public class BlobDeserializer extends StdDeserializer<Blob> {

    public BlobDeserializer() {
        this(null);
    }

    protected BlobDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Blob deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        // Assuming the JSON data is a Base64 encoded string representing the Blob
        String data = node.asText();
        return convertStringToBlob(data);
    }

    private Blob convertStringToBlob(String data) throws IOException {
        try {
            byte[] bytes = Base64.getDecoder().decode(data);
            return new javax.sql.rowset.serial.SerialBlob(bytes);
        } catch (SQLException e) {
            throw new RuntimeException("Error converting string to Blob", e);
        }
    }
}

