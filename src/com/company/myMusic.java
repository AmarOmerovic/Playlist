package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Locale;

public class myMusic {
    private LinkedList<Song> songList;
    private LinkedList<Album> albumList;
    private PlayList playList;

    public myMusic(){
        this.songList = new LinkedList<>();
        this.albumList = new LinkedList<>();
        this.playList = new PlayList();
    }


    private Song findSong(String songTitle){
        for (int i = 0; i < songList.size(); i++){
            if (songList.get(i).getTitle().equals(songTitle.toUpperCase(Locale.ROOT))){
                return songList.get(i);
            }
        }
        return null;
    }

    public boolean existingSong(String songTitle){
        Song existingSong = findSong(songTitle);
        if (existingSong != null){
            return true;
        }
        return false;
    }

    public boolean newSong(String songTitle){
        Song existingSong = findSong(songTitle);
        if (existingSong == null && !songTitle.isEmpty()){
            existingSong = new Song(songTitle.toUpperCase(Locale.ROOT));
            if (sortSongs(songList, existingSong) && sortSongs(playList.getSongList(), existingSong)){
                return true;
            }
        }
        return false;
    }

    private boolean sortSongs(LinkedList<Song> sortList, Song existingSong){
        ListIterator<Song> songListIterator = sortList.listIterator();
        while (songListIterator.hasNext()){
            int comparison = songListIterator.next().getTitle().compareTo(existingSong.getTitle());
            if (comparison == 0){
                return false;
            }else if (comparison > 0){
                songListIterator.previous();
                songListIterator.add(existingSong);
                return true;
            }
        }
        songListIterator.add(existingSong);
        return true;
    }

    public boolean removeSong(String songTitle){
        Song existingSong = findSong(songTitle);
        if (existingSong != null){
            songList.remove(existingSong);
            playList.getSongList().remove(existingSong);
            return true;
        }
        return false;
    }

    private boolean songListIsEmpty(){
        if (songList.isEmpty()){
            return false;
        }
        return true;
    }

    public void displaySong(String songTitle){
        Song existingSong = findSong(songTitle);
        if (existingSong != null){
            System.out.println("\tTitle: " + existingSong.getTitle());
            System.out.println("\tDuration: " + existingSong.getDuration() + " minutes");
        }
    }

    public void displayAllSongs(){
        if (!songListIsEmpty()){
            System.out.println("\t* No songs available! *");
        }else {
            for (int i = 0; i < songList.size(); i++){
                System.out.println("\t[" + (i+1) + "] Title: " + songList.get(i).getTitle() + " | Duration: " + songList.get(i).getDuration());
            }
            System.out.println();
        }
    }




    private Album findAlbum(String albumName){
        for (int i = 0; i < albumList.size(); i++){
            if (albumList.get(i).getAlbumName().equals(albumName.toUpperCase(Locale.ROOT))){
                return albumList.get(i);
            }
        }
        return null;
    }

    public boolean newAlbum(String albumName){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum == null  && !albumName.isEmpty()){
            existingAlbum = new Album(albumName.toUpperCase(Locale.ROOT));
            if (sortAlbums(albumList, existingAlbum)){
                return true;
            }
        }
        return false;
    }

    private boolean sortAlbums(LinkedList<Album> sortList, Album existingAlbum){
        ListIterator<Album> albumListIterator = sortList.listIterator();
        while (albumListIterator.hasNext()){
            int comparison = albumListIterator.next().getAlbumName().compareTo(existingAlbum.getAlbumName());
            if (comparison == 0){
                return false;
            }else if (comparison > 0){
                albumListIterator.previous();
                albumListIterator.add(existingAlbum);
                return true;
            }
        }
        albumListIterator.add(existingAlbum);
        return true;
    }

    public boolean removeAlbum(String albumName){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null){
            albumList.remove(existingAlbum);
            return true;
        }
        return false;
    }

    public void displayAlbums(){
        if (albumList.isEmpty()){
            System.out.println("\t* No albums available! *\n");
        }else {
            for (int i = 0; i < albumList.size(); i++) {
                System.out.println("\t[" + (i + 1) + "]");
                System.out.println("\tAlbum name: " + albumList.get(i).getAlbumName());
                System.out.println();
            }
        }
    }

    public void displayAlbum(String albumName){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null){
            System.out.println("\tName: " + existingAlbum.getAlbumName());
        }
    }

    public boolean addSongToAlbum(String albumName, String songTitle){
        Album existingAlbum = findAlbum(albumName);
        Song existingSong = findSong(songTitle);
        if (existingAlbum != null && existingSong != null){
            for (int i = 0; i < albumList.size(); i++){
                for (int j = 0; j < albumList.get(i).getSongListInAlbum().size(); j++){
                    if (albumList.get(i).getSongListInAlbum().contains(existingSong)){
                        return false;
                    }
                }
            }
            return existingAlbum.addSongToAlbum(existingSong, songTitle);
        }
        return false;
    }

    public boolean moveSongToAnotherAlbum(String oldAlbumName, String newAlbumName, String songTitle){
        Album oldAlbum = findAlbum(oldAlbumName);
        Album newAlbum = findAlbum(newAlbumName);
        Song song = findSong(songTitle);
        if (oldAlbum != null && newAlbum != null && song != null){
            if (oldAlbum.getSongListInAlbum().contains(song)){
                if (newAlbum.addSongToAlbum(song, song.getTitle())){
                    oldAlbum.removeSongFromAlbum(song.getTitle());
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeSongFromAlbum(String albumName, String songTitle){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null){
            if (existingAlbum.removeSongFromAlbum(songTitle)){
                return true;
            }
        }
        return false;
    }

    public void displaySongsInAlbum(String albumName){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null){
            existingAlbum.displayAllSongsInAlbum();
        }
    }

    public void displaySongInAlbum(String albumName, String songTitle){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null){
            existingAlbum.displaySongInAlbum(songTitle, albumName);
        }
    }

    public boolean searchSongInAlbum(String albumName, String songTitle){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null){
            if (existingAlbum.existingSong(songTitle)){
                return true;
            }
        }
        return false;
    }

    public boolean existingAlbum(String albumName){
        Album existingAlbum = findAlbum(albumName);
        if (existingAlbum != null){
            return true;
        }
        return false;
    }




    public boolean displayPlaylist(){
        if (playList.displayPlaylist()){
            return true;
        }
        return false;
    }

    public boolean playSongInPlaylist(int roleNumber){
        Song song = playList.playSong(roleNumber);
        if (song != null){
            System.out.println("\t[" + roleNumber + "] Title: " + song.getTitle() + " | Duration: " + song.getDuration());
            return true;
        }
        return false;
    }

    public boolean stopSongInPlaylist(int roleNumber){
        Song song = playList.playSong(roleNumber);
        if (song != null){
            System.out.println("\t[" + roleNumber + "] Title: " + song.getTitle() + " | Duration: " + song.getDuration());
            return true;
        }
        return false;
    }

    public int moveTroughSongs(int choice, int roleNumber){
        return playList.moveTroughSongs(choice,roleNumber);
    }




}
