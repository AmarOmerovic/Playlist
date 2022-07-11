package com.company;

import java.util.LinkedList;
import java.util.Locale;

public class Album {
    private LinkedList<Song> songListInAlbum;
    private String albumName;

    public Album(String albumName) {
        this.albumName = albumName;
        this.songListInAlbum = new LinkedList<>();
    }

    public String getAlbumName() {
        return albumName;
    }

    public LinkedList<Song> getSongListInAlbum() {
        return songListInAlbum;
    }




    private Song findSong(String songTitle){
        for (int i = 0; i < songListInAlbum.size(); i++){
            if (songListInAlbum.get(i).getTitle().equals(songTitle.toUpperCase(Locale.ROOT))){
                return songListInAlbum.get(i);
            }
        }
        return null;
    }

    public boolean addSongToAlbum(Song song, String songTitle){
        Song newSong = findSong(songTitle);
        if (song != null) {
            if (newSong == null){
                songListInAlbum.add(song);
                return true;
            }
        }
        return false;
    }

    public boolean removeSongFromAlbum(String songTitle){
        Song existingSong = findSong(songTitle);
        if (existingSong != null){
            songListInAlbum.remove(existingSong);
            return true;
        }
        return false;
    }

    public boolean displayAllSongsInAlbum(){
        if (songListInAlbum.isEmpty()){
            System.out.println("\t* No songs available! *");
            return false;
        }else {
            System.out.println("\t* Album *");
            System.out.println("\tName: " + getAlbumName());
            System.out.println();
            System.out.println("\t* Song *");
            for (int i = 0; i < songListInAlbum.size(); i++){
                System.out.println("\t[" + (i+1) + "]");
                System.out.println("\tTitle: " + songListInAlbum.get(i).getTitle());
                System.out.println("\tDuration: " + songListInAlbum.get(i).getDuration() + " minutes");
                System.out.println();
            }
            return true;
        }
    }

    public void displaySongInAlbum(String songTitle, String albumName){
        Song existingSong = findSong(songTitle);
        if (existingSong != null){
            System.out.println("\tAlbum: " + albumName.toUpperCase(Locale.ROOT));
            System.out.println("\tTitle: " + existingSong.getTitle());
            System.out.println("\tDuration: " + existingSong.getDuration() + " minutes");
        }
    }

    public boolean existingSong(String songTitle){
        Song existingSong = findSong(songTitle);
        if (existingSong != null){
            return true;
        }
        return false;
    }



}
