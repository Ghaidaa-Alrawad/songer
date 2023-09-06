package com.songer.songerWebApp.controller;

import com.songer.songerWebApp.model.Album;
import com.songer.songerWebApp.repositores.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepo albumRepo;
    // ("Midnight", "Band: Set It Off", 15, 43, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS31QEAIPhEdJq4jVskU5hDnqWYc6rhU_S9IQ&usqp=CAU");
    // ("HELP EVER HURT NEVER", "Artist: Fujii Kaze", 11, 46, "https://i.scdn.co/image/ab67616d0000b27322805a1b17e41ae357bd98bc");
    // ("Death of a Bachelor", "Band: Panic! At The Disco", 11, 35, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT68KmyZtBlXUtEONPJBpqUNzOrmddKKJsgKg&usqp=CAU");
    // ("Wish You Were Here", "Pink Floyd", 5, 44, "https://faroutmagazine.co.uk/static/uploads/1/2019/05/%E2%80%98Wish-You-Were-Here%E2%80%99-%E2%80%93-Pink-Floyd-cover-meaning.jpg");


    @GetMapping("/albums")
    public String albums(Model albumM) {
        List<Album> albums = albumRepo.findAll();
        System.out.println(albums.toString());
        albumM.addAttribute("albums",albums);
        return "album.html";
    }

    @PostMapping("/albums/creat-album")
    public RedirectView creatingAlbums(String title, String artist, int songCount, int length, String imgUrl){
        Album newAlbum = new Album(title, artist, songCount, length, imgUrl);
        albumRepo.save(newAlbum);
        return new RedirectView("/albums");
    }
}
