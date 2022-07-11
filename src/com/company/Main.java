package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static myMusic myMusic = new myMusic();

    public static void main(String[] args) {

        boolean quit = false;
        while (!quit) {
            mainMenu();
            System.out.print("\t- Enter your choice: ");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput) {
                case 0:
                    System.out.println("\n\tQuitting...");
                    quit = true;
                    break;
                case 1:
                    songOptions();
                    break;
                case 2:
                    albumMenu();
                    break;
                case 3:
                    playlistFunction();
                    break;
                default:
                    System.out.println("\n\t* Wrong input! *");
                    break;
            }
        }
    }




    public static void logo(){
        System.out.println("\n\t\t*** MyMusic ***\n");
    }

    public static void mainMenu(){
        logo();
        System.out.println("\t** Main menu **");
        System.out.println("\t0. Quit");
        System.out.println("\t1. Song options");
        System.out.println("\t2. Album options");
        System.out.println("\t3. Playlist\n");
    }




    public static void songOptions(){
        boolean back = false;
        while (!back) {
            logo();
            System.out.println("\t** Song options **");
            System.out.println("\t0. Back");
            System.out.println("\t1. Download a song");
            System.out.println("\t2. Remove a song");
            System.out.println("\t3. Search for a song");
            System.out.println("\t4. All available songs\n");

            System.out.print("\t- Enter your choice: ");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput){
                case 0:
                    System.out.println("\n\tBacking...");
                    back = true;
                    break;
                case 1:
                    downloadSong();
                    break;
                case 2:
                    removeSong();
                    break;
                case 3:
                    searchSong();
                    break;
                case 4:
                    displaySongs();
                    break;
                default:
                    System.out.println("\n\t* Wrong input! *");
                    break;
            }
        }
    }

    public static void downloadSong(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* Download a song *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tSong title: ");
            String songTitle = scanner.nextLine();
            System.out.println("\n\tDownloading...\n");
            if (myMusic.newSong(songTitle)) {
                myMusic.displaySong(songTitle);
                System.out.println("\t* Song downloaded successfully! *");
            } else {
                System.out.println("\t* Song download was unsuccessfully! *");
            }
            System.out.println("\n\t * To go back press \"0\", to download another song press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void removeSong(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* Remove a song *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tSong title: ");
            String songTitle = scanner.nextLine();
            System.out.println("\n\tRemoving...\n");
            myMusic.displaySong(songTitle);
            if (myMusic.removeSong(songTitle)) {
                System.out.println("\t* Song removed successfully! *");
            } else {
                System.out.println("\t* Song was not removed! *");
            }
            System.out.println("\n\t * To go back press \"0\", to remove another song press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void searchSong(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* Search for a song *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tSong title: ");
            String songTitle = scanner.nextLine();
            System.out.println("\n\tSearching...\n");
            if (myMusic.existingSong(songTitle)) {
                myMusic.displaySong(songTitle);
                System.out.println("\t* Song found! *");
            } else {
                System.out.println("\t* Song was not found! *");
            }
            System.out.println("\n\t * To go back press \"0\", to search for another song press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void displaySongs(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* All available songs *");
            System.out.println("\n\tListing...\n");
            myMusic.displayAllSongs();
            System.out.println("\t * To go back press \"0\", to list again press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }




    public static void albumMenu(){
        boolean back = false;
        while (!back) {
            logo();
            System.out.println("\t** Album menu **");
            System.out.println("\t0. Back");
            System.out.println("\t1. Create a new album");
            System.out.println("\t2. Remove an album");
            System.out.println("\t3. Add a song to an album");
            System.out.println("\t4. Move song to another album");
            System.out.println("\t5. Remove a song from an album");
            System.out.println("\t6. Search for a song in an album");
            System.out.println("\t7. Search for an album & list all available songs in it");
            System.out.println("\t8. All available albums\n");


            System.out.print("\t- Enter your choice: ");
            int userInput = scanner.nextInt();
            scanner.nextLine();
            switch (userInput){
                case 0:
                    System.out.println("\n\tBacking...");
                    back = true;
                    break;
                case 1:
                    newAlbum();
                    break;
                case 2:
                    removeAlbum();
                    break;
                case 3:
                    addSongToAlbum();
                    break;
                case 4:
                    moveSong();
                    break;
                case 5:
                    removeSongFromAlbum();
                    break;
                case 6:
                    searchSongInAlbum();
                    break;
                case 7:
                    searchAlbumAndDisplaySongs();
                    break;
                case 8:
                    displayAlbums();
                    break;
                default:
                    System.out.println("\n\t* Wrong input! *");
                    break;
            }
        }
    }


    public static void newAlbum(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* Create a new album *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tAlbum name: ");
            String albumName = scanner.nextLine();
            System.out.println("\n\tCreating...\n");
            if (myMusic.newAlbum(albumName)) {
                myMusic.displayAlbum(albumName);
                System.out.println("\t* Album created successfully! *");
            } else {
                System.out.println("\t* Album was not created! *");
            }
            System.out.println("\n\t * To go back press \"0\", to create another album press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void removeAlbum(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* Remove an album *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tAlbum name: ");
            String albumName = scanner.nextLine();
            System.out.println("\n\tRemoving...\n");
            myMusic.displayAlbum(albumName);
            if (myMusic.removeAlbum(albumName)) {
                System.out.println("\t* Album was removed successfully! *");
            } else {
                System.out.println("\t* Album was not removed! *");
            }
            System.out.println("\n\t * To go back press \"0\", to remove another album press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void addSongToAlbum(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* Add song to an album *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tAlbum name: ");
            String albumName = scanner.nextLine();
            System.out.print("\tSong title: ");
            String songTitle = scanner.nextLine();
            System.out.println("\n\tAdding...\n");
            if (myMusic.addSongToAlbum(albumName, songTitle)) {
                myMusic.displaySongInAlbum(albumName, songTitle);
                System.out.println("\t* Song was added to the album successfully! *");
            } else {
                System.out.println("\t* Song was not added to the album! *");
            }
            System.out.println("\n\t * To go back press \"0\", to add another song to the album press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void moveSong(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* Move a song to another album *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tAlbum name that contains the song: ");
            String fromAlbum = scanner.nextLine();
            System.out.print("\tAlbum name to move the song: ");
            String toAlbum = scanner.nextLine();
            System.out.print("\tSong title: ");
            String songTitle = scanner.nextLine();
            System.out.println("\n\tMoving...\n");
            if (myMusic.moveSongToAnotherAlbum(fromAlbum, toAlbum, songTitle)) {
                System.out.println("\t* Song was moved from the album successfully! *\n");
            } else {
                System.out.println("\t* Song was not moved from the album! *\n");
            }
            System.out.println("\t * To go back press \"0\", to remove another song fom the album press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void removeSongFromAlbum(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* Remove a song from an album *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tAlbum name: ");
            String albumName = scanner.nextLine();
            System.out.print("\tSong title: ");
            String songTitle = scanner.nextLine();
            System.out.println("\n\tRemoving...\n");
            myMusic.displaySongInAlbum(albumName, songTitle);
            if (myMusic.removeSongFromAlbum(albumName, songTitle)) {
                System.out.println("\t* Song was removed from the album successfully! *\n");
            } else {
                System.out.println("\t* Song was not removed from the album! *\n");
            }
            System.out.println("\t * To go back press \"0\", to remove another song fom the album press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void searchSongInAlbum(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* Search for a song in an album *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tAlbum name: ");
            String albumName = scanner.nextLine();
            System.out.print("\tSong title: ");
            String songTitle = scanner.nextLine();
            System.out.println("\n\tSearching...\n");
            if (myMusic.searchSongInAlbum(albumName, songTitle)) {
                myMusic.displaySongInAlbum(albumName, songTitle);
                System.out.println("\t* Song was found! *");
            } else {
                System.out.println("\t* Song was not found! *");
            }
            System.out.println("\n\t * To go back press \"0\", to search for another song press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void searchAlbumAndDisplaySongs(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* All available songs in an album *");
            System.out.println("\n\t* Please fill the information's needed below! *");
            System.out.print("\tAlbum name: ");
            String albumName = scanner.nextLine();
            System.out.println("\n\tSearching...\n");
            if (myMusic.existingAlbum(albumName)) {
                myMusic.displaySongsInAlbum(albumName);
                System.out.println("\t* Album was found! *");
            } else {
                System.out.println("\t* Album was not found! *");
            }
            System.out.println("\n\t * To go back press \"0\", to search for another album press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }

    public static void displayAlbums(){
        boolean back = false;
        while (!back) {
            System.out.println("\n\t* All available albums *");
            System.out.println("\n\tListing...\n");
            myMusic.displayAlbums();
            System.out.println("\t * To go back press \"0\", to list again press any other number! *");
            System.out.print("\t- Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                System.out.println("\n\tBacking...");
                back = true;
            }
        }
    }




    public static void playlistMenu(){
        System.out.println("\t0. Back");
        System.out.println("\t1. Stop playing");
        System.out.println("\t2. Next song");
        System.out.println("\t3. Previous song\n");
    }

    public static void playlistFunction(){
        boolean back = false;
        while (!back) {
            logo();
            System.out.println("\t** Playlist **\n");
            if (myMusic.displayPlaylist()) {
                System.out.println("\t0. Back");
                System.out.println("\t1. Play a song\n");
                System.out.print("\t- Enter your choice: ");
                int userInput = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                switch (userInput) {
                    case 0:
                        System.out.println("\tBacking...");
                        back = true;
                        break;
                    case 1:
                        playSong();
                        break;
                    default:
                        System.out.println("\t* Wrong input! *");
                        break;
                }
            }else {
                System.out.println("\n\t * To go back press \"0\", to list again press any other number! *");
                System.out.print("\t- Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 0) {
                    System.out.println("\n\tBacking...");
                    back = true;
                }
            }
        }
    }

    public static void playSong(){
        System.out.println("\t* To play a song, enter the roleNumber of the song! *");
        System.out.print("\t- Role number: ");
        int roleNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\n\tPlaying...\n");
        if (!myMusic.playSongInPlaylist(roleNumber)) {
            System.out.println("\t * Song is not playing! *");
        } else {
            System.out.println("\t * Song is playing! *\n");
            boolean back = false;
            while (!back) {
                playlistMenu();
                System.out.print("\t- Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice){
                    case 0:
                        System.out.println("\n\tBacking...");
                        back = true;
                        break;
                    case 1:case 2:case 3:
                        if (nextPreviousStopSong(choice, roleNumber)){
                            back = true;
                        }
                        break;
                    default:
                        System.out.println("\n\t* Wrong input! *\n");
                        break;
                }
            }
        }
    }

    public static boolean nextPreviousStopSong(int choice, int roleNumber){
        boolean firstTime = true;
        while (true){
            if (choice == 1){
                System.out.println("\t* To stop a playing song, enter the role number of the song! *");
                System.out.print("\t- Role number: ");
                int stopRoleNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("\n\tStopping...\n");
                if (stopRoleNumber == roleNumber) {
                    if (myMusic.stopSongInPlaylist(roleNumber)) {
                        System.out.println("\t * Song is stopped! *\n");
                        break;
                    }
                } else {
                    System.out.println("\t * Song is not stopped, because it was not playing! *");
                    firstTime = false;
                }
            } else if (choice == 2) {
                choice = myMusic.moveTroughSongs(choice, roleNumber);
                if (choice > 0){
                    roleNumber = choice;
                    choice = 1;
                }
            } else if (choice == 3) {
                choice = myMusic.moveTroughSongs(choice, roleNumber);
                if (choice > 0){
                    roleNumber = choice;
                    choice = 1;
                }
            } else if (choice == 0){
            System.out.println("\n\tBacking...");
            break;
            }else {
                System.out.println("\n\t* Wrong input! *\n");
                firstTime = false;
            }
            if (!firstTime){
                System.out.println();
                playlistMenu();
                System.out.print("\t- Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                firstTime = true;
            }
        }
        return true;
    }
}
