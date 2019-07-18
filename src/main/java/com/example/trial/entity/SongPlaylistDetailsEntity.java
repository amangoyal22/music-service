package com.example.trial.entity;

import com.example.trial.models.SongPlaylistDetailsModel;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "song_playlist_details")
public class SongPlaylistDetailsEntity extends SongPlaylistDetailsModel {
}
