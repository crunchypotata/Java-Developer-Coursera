package com.lesson.lab.controller;

import com.lesson.lab.model.Song;

/**
 * The SinglyLinkedPlaylistManager class is responsible for managing a playlist of songs using a Singly linked list structure.
 * It provides methods to add, remove, and navigate through songs in the playlist.
 * This class supports checking for duplicate songs, moving to the next or previous song,
 * and displaying the current playlist.
 */
public class SinglyLinkedPlaylistManager {
    class Node {
        Song song; //Holds the data for each node, which in this case is a Song object.
        Node next; //A reference to the next node in the list, allowing traversal forward.

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }
    private Node head;
    private Node current;

    public SinglyLinkedPlaylistManager() {
        head = null;
        current = null;
    }

    // Method to add a song to the playlist
    public void addFavoriteSong(Song newSong) {
        // TODO 1: check if the song already exists in the playlist
        if (isDuplicate(newSong)) {
            System.out.println("This song already exists");
            return;
        }

        // TODO 2: create a new node for the song
        Node newNode = new Node(newSong);

        // TODO 3: check if the playlist is empty
        //  If empty, set the new node as the head of the list, initialize the current node to the head.
        if (isEmpty()) {
            head = newNode;
            //Why?
            current = head;

        } else {
            // TODO 4: if not empty, find the last node in the list
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        //TODO 5: set the next of the last node to the new node
        //print a confirmation message that the song was added
        System.out.println(newSong.getTitle() + " added to the playlist.");
    }

    private boolean isDuplicate(Song song) {
        Node current = head;
        while (current != null) {
            if (current.song.getTitle().equals(song.getTitle()) && current.song.getArtist().equals(song.getArtist())) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to remove a song from the playlist based on the given index
    public void removeFavoriteSong(int index) {
        // TODO 6: Check if the index is less than 1. If so, print “Invalid index.” and return.
        if (index < 1) {
            System.out.println("Invalid index.");
            return;
        }
        // TODO 7: Check if the playlist is empty (head == null). If so, print “Playlist is empty.” and return.
        if (isEmpty())  {
            System.out.println("Playlist is empty");
            return;
        }
        // TODO 8: If the index is 1, set head to head.next, print the title of the removed song, and return.
        if (index == 1) {
            System.out.println(head.song.getTitle() + " removed from the playlist.");
            head = head.next;
            return;
        }
        // TODO 9: Traverse the playlist using a loop, keeping track of current, previous, and count.
        Node current = head;
        Node previous = null;
        int count = 1;

        while (current != null && count < index ) {
            previous = current;
            current = current.next;
            count++;
        }
        // TODO 10: If current is null after the loop, print “Invalid index.”
        if (current == null) {
            System.out.println("Invalid index.");
        } else {
            // TODO 11: If a valid node is found, adjust previous.next to remove the current node and print the title of the removed song.
            System.out.println(head.song.getTitle() + " removed from the playlist.");
            previous.next = current.next;
        }
    }

    // Method to display all songs with index
    public void displayFavoriteSongs() {
        //TODO 12: check if the playlist is empty by verifying if head == null.
        // if empty, print “Playlist is empty.” and return.
        if (isEmpty()) {
            System.out.println("Playlist is empty");
            return;
        }
        //TODO 13: initialize current to head and index to 1.
        Node current = head;
        int index = 1;

        //TODO 14: use a while loop to iterate through the playlist, printing each song’s index and details.
        while (current != null) {
            System.out.println(index + ". " + current.song.toString());
            current = current.next;

            //TODO 15: inside the loop, increment the index and update current to current.next.
            index++;
        }

    }

    // Method to play the next song in the playlist
    public void playNextFavoriteSong() {
        // TODO 16: check if there is no next song by verifying if current == null or current.next == null.
        // if so, print “No next song in the playlist.”
        if (current == null || current.next == null) {
            System.out.println("No next song in the playlist.");
        } else {
            // TODO 17: if there is a next song, update current to current.next.
            current = current.next;
            // TODO 18: print the details of the now playing song.
            System.out.println("Now playing: " + current.song);
        }
    }

    // Method to play the previous song in the playlist
    public void playPreviousFavoriteSong() {
        // Check if the playlist is empty or if the current song is the head
        // If `current` is `null` or `current` is pointing to `head`, there is no previous song to play.
        // If there is no previous song, print a message to the user
        // Initialize a temporary node `temp` to start from the head of the list
        // Traverse the list to find the node just before `current`
        // This involves iterating through the list until `temp.next` is `current`
        //Set `current` to `temp`, effectively moving back one song
        //Print the song details of the new `current` node
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

