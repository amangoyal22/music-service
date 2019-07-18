package com.example.trial.reposervices;

import com.example.trial.bos.SongPlaylistDetailsBo;

import java.util.List;

/**
 * The interface Playlist song details service.
 */
public interface SongPlaylistDetailsService {
    /**
     * Save playlist song.
     *
     * @param songPlaylistDetailsBo the song playlist details bo
     * @return the song playlist details bo
     */
    SongPlaylistDetailsBo savePlaylistSong(SongPlaylistDetailsBo songPlaylistDetailsBo);

    /**
     * Gets songs for playlist.
     *
     * @param playlist the playlist
     * @return the songs for playlist
     */
    List<SongPlaylistDetailsBo> getSongsForPlaylist(Long playlist);

    /**
     * Check song id and playlist id song playlist details bo.
     *
     * @param songId     the song id
     * @param playlistId the playlist id
     * @return the boolean
     */
    boolean checkSongIdAndPlaylistId(String songId, String playlistId);
}
