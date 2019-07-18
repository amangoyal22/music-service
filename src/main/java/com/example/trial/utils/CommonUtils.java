package com.example.trial.utils;

import com.example.trial.bos.SongsDetailsBo;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * The type Common utils.
 */
public final class CommonUtils {

    /**
     * Get uid string.
     *
     * @return the string
     */
    public static String getUid(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * Get date string.
     *
     * @return the string
     */
    public static String getDate(){
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        return formatDate.format(new Date());
    }

    public static SongsDetailsBo getSongsInfo(final String location, final SongsDetailsBo songsDetailsBo) {
        try {
            final InputStream input = new FileInputStream(new File(location));
            final Parser parser = new Mp3Parser();
            final Metadata metadata = new Metadata();
            parser.parse(input, new DefaultHandler(), metadata, new ParseContext());
            input.close();
            songsDetailsBo.setSongName(metadata.get("title"));
            songsDetailsBo.setSongGenre(metadata.get("xmpDM:genre"));
            songsDetailsBo.setSongLength((int)(Double.parseDouble(metadata.get("xmpDM:duration"))/1000));

        } catch (IOException | TikaException | SAXException exp) {
            exp.printStackTrace();
        }
        return songsDetailsBo;
    }


}
