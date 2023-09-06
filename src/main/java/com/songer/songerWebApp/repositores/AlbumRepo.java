package com.songer.songerWebApp.repositores;

import com.songer.songerWebApp.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

//here the long is the data type for the id in album class
public interface AlbumRepo extends JpaRepository<Album, Long> {

}
