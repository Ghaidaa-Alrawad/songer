package com.songer.songerWebApp.controller;

import com.songer.songerWebApp.model.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AlbumController {

    @GetMapping("/albums")
    public String albums(Model albumM){
        Album album1 = new Album("Midnight", "Band: Set It Off", 15, 43, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS31QEAIPhEdJq4jVskU5hDnqWYc6rhU_S9IQ&usqp=CAU");
        Album album2 = new Album("HELP EVER HURT NEVER", "Artist: Fujii Kaze", 11, 46, "https://i.scdn.co/image/ab67616d0000b27322805a1b17e41ae357bd98bc");
        Album album3 = new Album("Death of a Bachelor", "Band: Panic! At The Disco", 11, 35, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT68KmyZtBlXUtEONPJBpqUNzOrmddKKJsgKg&usqp=CAU");
        albumM.addAttribute("albums",new Album[]{album1,album2,album3});
        return "album.html";
    }
}
