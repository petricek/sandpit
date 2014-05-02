package com.example.tutorial;
import com.example.tutorial.VWProtos.VWExample;
import com.example.tutorial.VWProtos.Cache;
import com.example.tutorial.VWProtos.VWExample.VWFeature;
import com.example.tutorial.VWProtos.VWExample.VWLabel;
import com.example.tutorial.VWProtos.VWExample.VWNamespace;

import java.io.*;

/**
 * Created by petricek on 4/26/14.
 * ho
 */
public class TryVWProtos {

    private static VWExample createExample(BufferedReader bufferedReader, PrintStream out)
    {

        VWExample.Builder example = VWProtos.VWExample.newBuilder();
        VWLabel.Builder label = VWProtos.VWExample.VWLabel.newBuilder();
        VWNamespace.Builder namespace = VWProtos.VWExample.VWNamespace.newBuilder();
        VWFeature.Builder feature = VWProtos.VWExample.VWFeature.newBuilder();

        return example
                .setLabel(
                        label
                                .setValue(-1)
                                .setImportance(1)
                                .setBase(0)
                                .setTag("my_tag")
                                .build()
                )
                .addNamespace(
                        namespace.setId('a').addFeature(feature.setName("QUALITY").setValue(0.3f).build()).build()
                )
                .addNamespace(
                        namespace.setId('b').addFeature(feature.setName("QUANTITY").setValue(0.9f).build()).build()
                )
                .build();

    }

    static void Print(Cache cache) {
        for (VWExample example: cache.getExampleList()) {
            System.out.println("Example: " + example.toString());
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage:  TryVWProtos CACHE_FILE");
            System.exit(-1);
        }

        Cache.Builder CacheBuilder = VWProtos.Cache.newBuilder();

        try {
            Cache Cache = VWProtos.Cache.parseFrom(new FileInputStream(args[0]));
            Print(Cache);
        } catch (FileNotFoundException e) {
            System.out.println(args[0] + ": File not found. Not printing.");
        }

            // Read the existing address book.
        try {
            CacheBuilder.mergeFrom(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println(args[0] + ": File not found.  Creating a new file.");
        }
        for(int i = 0; i < 10 ; i++) {
            // Add an address.
            CacheBuilder.addExample(
                    createExample(new BufferedReader(new InputStreamReader(System.in)),
                            System.out)
            );
        }
        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream(args[0]);
        CacheBuilder.build().writeTo(output);
        output.close();
    }


}
