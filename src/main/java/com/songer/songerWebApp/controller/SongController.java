package com.songer.songerWebApp.controller;

import com.songer.songerWebApp.exceptions.AlbumNotFoundException;
import com.songer.songerWebApp.model.Album;
import com.songer.songerWebApp.model.Song;
import com.songer.songerWebApp.repositores.AlbumRepo;
import com.songer.songerWebApp.repositores.SongRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    AlbumRepo albumRepo;

    @Autowired
    SongRepo songRepo;


//    @GetMapping("/songs")
//    public String albums(Model albumM) {
//        List<Album> albums = albumRepo.findAll();
//        albumM.addAttribute("albums", albums);
//        return "album.html";
//    }

    @GetMapping("/songs")
    public String songs(Model songM) {
        List<Song> songs = songRepo.findAll();
        songM.addAttribute("songs", songs);
        return "songs.html";
    }


    @PostMapping("/add-song")
    public RedirectView addSong(String songTitle, int songLength, int songTrackNumber, Long albumId){
        Album album = albumRepo.findById(albumId)
                .orElseThrow(() -> new AlbumNotFoundException("Couldn't find an Album for this song in the database, Sorry! :("));

        Song song = new Song(songTitle, songLength, songTrackNumber, album);
        songRepo.save(song);
        return new RedirectView("/albums");
    }

}
