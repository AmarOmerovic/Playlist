package com.company;


import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlayList {
    private LinkedList<Song> songList;

    public PlayList() {
        this.songList = new LinkedList<>();
    }

    public LinkedList<Song> getSongList() {
        return songList;
    }

    private Song findSong(int roleNumber) {
        if (roleNumber > 0 && roleNumber <= songList.size()) {
            for (int i = 0; i < songList.size(); i++) {
                if ((roleNumber - 1) == i) {
                    return songList.get(i);
                }
            }
        }
        return null;
    }

    public boolean displayPlaylist() {
        int count = 0;
        if (songList.isEmpty()) {
            System.out.println("\t* Playlist is empty! *");
            return false;
        } else {
            for (int i = 0; i < songList.size(); i++) {
                count++;
                System.out.println("\t[" + count + "] Title: " + songList.get(i).getTitle() + " | Duration: " + songList.get(i).getDuration());
            }
            System.out.println();
            return true;
        }
    }

    public Song playSong(int roleNumber) {
        Song song = findSong(roleNumber);
        if (song != null) {
            return song;
        }
        return null;
    }

    public int moveTroughSongs(int choice, int roleNumber) {
        Scanner scanner = new Scanner(System.in);
        Song song = findSong(roleNumber);
        if (song == null) {
            return -1;
        } else {
            int help = roleNumber;
            int position = roleNumber;
            boolean firstTimeNextSong = true;
            boolean firstTimePreviousSong = false;
            ListIterator<Song> songListIterator = songList.listIterator(songList.indexOf(song));
            while (songListIterator.hasNext() || songListIterator.hasPrevious()) {
                if (choice == 2) {
                    if (firstTimeNextSong) {
                        songListIterator.next();
                        firstTimeNextSong = false;
                    }
                    if (songListIterator.hasNext()) {
                        System.out.println("\n\tNext...\n");
                        position++;
                        help++;
                        song = songListIterator.next();
                        System.out.println("\t[" + position + "] Title: " + song.getTitle() + " | Duration: " + song.getDuration());
                        System.out.println("\t * Next song is playing! *");
                        firstTimePreviousSong = true;
                    } else {
                        System.out.println("\n\t * You are at the end of the playlist! *");
                        position = songList.size() + 1;
                        firstTimePreviousSong = false;
                    }
                } else if (choice == 3) {
                    if (firstTimePreviousSong) {
                        songListIterator.previous();
                        firstTimePreviousSong = false;
                    }
                    if (songListIterator.hasPrevious()) {
                        System.out.println("\n\tPrevious...\n");
                        position--;
                        help--;
                        song = songListIterator.previous();
                        System.out.println("\t[" + position + "] Title: " + song.getTitle() + " | Duration: " + song.getDuration());
                        System.out.println("\t * Previous song is playing! *");
                        firstTimeNextSong = true;
                    }else {
                        System.out.println("\n\t * You are at the start of the playlist! *");
                        position = 0;
                        firstTimeNextSong = false;
                    }
                } else if (choice == 0) {
                    return 0;
                } else if (choice == 1) {
                    if ((position == 0) || (position == songList.size() + 1)){
                        return help;
                    }else {
                        return position;
                    }
                } else {
                    System.out.println("\n\t* Wrong input! *");
                }
                System.out.println();
                System.out.println("\t0. Back");
                System.out.println("\t1. Stop playing");
                System.out.println("\t2. Next song");
                System.out.println("\t3. Previous song\n");
                System.out.print("\t- Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
            }
        }
        return -1;
    }
}




