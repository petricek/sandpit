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

    private static VWExample promptForExample(BufferedReader bufferedReader, PrintStream out)
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
                .build();

    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage:  TryVWProtos CACHE_FILE");
            System.exit(-1);
        }

        Cache.Builder Cache = VWProtos.Cache.newBuilder();

        // Read the existing address book.
        try {
            Cache.mergeFrom(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println(args[0] + ": File not found.  Creating a new file.");
        }
        for(int i = 0; i < 1000000 ; i++) {
            // Add an address.
            Cache.addExample(
                    promptForExample(new BufferedReader(new InputStreamReader(System.in)),
                            System.out)
            );
        }
        // Write the new address book back to disk.
        FileOutputStream output = new FileOutputStream(args[0]);
        Cache.build().writeTo(output);
        output.close();
    }


}
