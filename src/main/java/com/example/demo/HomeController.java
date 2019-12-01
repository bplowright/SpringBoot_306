package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    AlbumRepository albumRepository;
    @RequestMapping("/")
    public String index(Model model){
        //First let's create an Album
        Album album = new Album();
        album.setName("Addi Teacha");
        album.setGenre("Dancehall");
        // Now let's create a song
        Song song = new Song();
        song.setTitle("Dancehall Cya Stall");
        song.setYear(2010);
        //Add the song an empty list
        Set<Song> songs = new HashSet<Song>();
        songs.add(song);
        song = new Song();
        song.setTitle("Like Christmas");
        song.setYear(2011);
        songs.add(song);
        //Add the list of songs to the Album
        album.setSongs(songs);
        //Save the album to the database
        albumRepository.save(album);
        //Grab all the albums from the database and send them to
        //the template
        model.addAttribute("album", albumRepository.findAll());
        return "index";
    }
}
