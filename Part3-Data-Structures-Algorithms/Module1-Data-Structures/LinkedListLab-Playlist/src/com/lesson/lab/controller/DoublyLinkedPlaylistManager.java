package com.lesson.lab.controller;

import com.lesson.lab.model.Song;

/**
 * The DoublyLinkedPlaylistManager class manages a playlist of songs using a doubly linked list structure.
 * This class allows for efficient addition, removal, and navigation of songs in the playlist.
 * Each song is represented by a Node, which contains links to both the next and previous songs,
 * enabling traversal in both directions. The class provides methods to add songs to the playlist,
 * remove songs by index, display all songs, and navigate through the playlist. It also maintains
 * the current song being played, allowing users to easily move to the next or previous song in the list.
 */
public class DoublyLinkedPlaylistManager {
    // Node class for doubly linked list
    class Node {
        Song song; //Holds the data for each node, which in this case is a Song object.
        Node next; //A reference to the next node in the list, allowing traversal forward.
        Node previous; // Previous node reference

        Node(Song song) {
            this.song = song;
            this.next = null;
            // Initialize previous to null
            this.previous = null;
        }
    }
    private Node head;
    private Node current;

    public DoublyLinkedPlaylistManager() {
        head = null;
        current = null;
    }

    // Method to add a song to the playlist
    public void addFavoriteSong(Song newSong) {
        if (isDuplicate(newSong)) {
            System.out.println("Song already exists in the playlist.");
            return;
        }
        Node newNode = new Node(newSong);
        if (head == null) {
            head = newNode;
            current = head;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
            //TODO 21: set the previous reference of the new node to the last node
            newNode.previous = last;
        }
        System.out.println(newSong.getTitle() + " added to the playlist.");
    }

    // Method to check if a song is already in the playlist
    private boolean isDuplicate(Song song) {
        Node current = head;
        while (current != null) {
            if (current.song.getTitle().equals(song.getTitle()) && current.song.getArtist().equals(song.getArtist())) {
                return true; // Duplicate found
            }
            current = current.next;
        }
        return false; // No duplicate found
    }

    // Method to remove a song by index
    public void removeFavoriteSong(int index) {
        if (index < 1) {
            System.out.println("Invalid index.");
            return;
        }
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (index == 1) {
            System.out.println(head.song.getTitle() + " removed from the playlist.");
            head = head.next;
            if (head != null) {
                // TODO 22: updates the previous reference of the head with null if the first node is removed.
                head.previous = null;
            }
            return;
        }
        Node current = head;
        int count = 1;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Invalid index.");
        } else {
            System.out.println(current.song.getTitle() + " removed from the playlist.");
            if (current.previous != null) {
                //TODO 23: update the next reference of the previous node to skip over the current node.
                current.previous.next = current.next;
            }
            if (current.next != null) {
                //TODO 24: update the previous reference of the next node to point to the previous node of the current node.
                current.next.previous = current.previous;
            }
        }
    }

    // Method to display all songs with index
    public void displayFavoriteSongs() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        Node current = head;
        int index = 1;
        while (current != null) {
            System.out.println(index + ". " + current.song);
            current = current.next;
            index++;
        }
    }

    // Method to play the next song in the playlist
    public void playNextFavoriteSong() {
        if (current == null || current.next == null) {
            System.out.println("No next song in the playlist.");
        } else {
            current = current.next;
            System.out.println("Now playing: " + current.song);
        }
    }

    // Method to play the previous song in the playlist
    public void playPreviousFavoriteSong() {
        //TODO 25: checks if the current node is null or if current.previous is null
        // If no previous song exists, print a message indicating playlist is empty
        if (current == null || current.previous == null) {
            System.out.println("No next song in the playlist.");
        } else {
                //TODO 26: sets current to current.previous
                //TODO 27: print the song that is now playing
                current = current.previous;
                System.out.println("Now playing: " + current.song);
        }
    }

    // Method to start playing from the first song in the playlist
    public void setCurrentToFirst() {
        current = head;
        if (current != null) {
            System.out.println("Now playing: " + current.song);
        } else {
            System.out.println("Playlist is empty.");
        }
    }
    // Check if playlist is empty
    public boolean isEmpty() {
        return head == null;
    }
}


