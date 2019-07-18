package com.example.trial.entity;

import com.example.trial.models.SongsDetailsModel;
import com.example.trial.models.SongsInfoModel;

import javax.persistence.*;


@SqlResultSetMapping(name = "songInfo",
        classes = {@ConstructorResult(targetClass = SongsInfoModel.class,
                columns = {@ColumnResult(name = "likes", type = Integer.class),
                        @ColumnResult(name = "dislikes", type = Integer.class),
                        @ColumnResult(name = "genre", type = String.class),
                        @ColumnResult(name = "slength", type = Integer.class),
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "id", type = Long.class),
                        @ColumnResult(name = "currentSong", type = byte.class),
                        @ColumnResult(name = "location", type = String.class)})})
@NamedNativeQuery(name = "SongsDetailsEntity.fetchSongDetails",
        query = "select  sui.likes as likes, sui.dislikes as dislikes, "
                + " sd.song_genre as genre, "
                + " sd.song_length as slength, sd.song_name as name, sd.id as id, sui.is_played as currentSong,sd.song_location as location "
                + " FROM songs_details sd, playlist_song_user_info sui "
                + " where sui.restaurant_uid =:restaurantUid and "
                + " sd.id = sui.song_id and "
                + " sd.status = 1 and sui.status = 1 and sui.created_at =:tDate order by (likes-dislikes) desc, currentSong desc, id asc",
        resultSetMapping = "songInfo")
@Entity
@Table(name = "songs_details")
public class SongsDetailsEntity extends SongsDetailsModel {

}
