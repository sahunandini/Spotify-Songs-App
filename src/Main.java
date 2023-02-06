import java.util.*;

public class Main {

    public static List<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album1 = new Album("Beautiful", "Justin Bieber");
        album1.addSongToAlbum("STAY", 2.22);
        album1.addSongToAlbum("Love Yourself", 4.32);
        album1.addSongToAlbum("Ghost", 3.32);
        album1.addSongToAlbum("I Don't Care", 3.39);
        album1.addSongToAlbum("Believe", 3.42);

        Album album2 = new Album("Permission to Dance", "BTS");
        album2.addSongToAlbum("Dynamite",3.20);
        album2.addSongToAlbum("Life Goes On", 3.28);
        album2.addSongToAlbum("Paradise", 3.31);
        album2.addSongToAlbum("Let Go", 5.00);

        albums.add(album1);
        albums.add(album2);

//        System.out.println(album1.findSong("STAY"));

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlayListFromAlbum("STAY", myPlayList);
        album2.addToPlayListFromAlbum(1, myPlayList);
        album1.addToPlayListFromAlbum(2, myPlayList);
        album1.addToPlayListFromAlbum("I Don't Care", myPlayList);
        album2.addToPlayListFromAlbum(2, myPlayList);
        album2.addToPlayListFromAlbum("Paradise", myPlayList);
        album1.addToPlayListFromAlbum(5, myPlayList);

        play(myPlayList);

    }

    public static void play(LinkedList<Song> playList) {
        ListIterator<Song> itr = playList.listIterator();

        Scanner sc = new Scanner(System.in);

        boolean isForward = false;

        if(playList.size() > 0) {
            System.out.print("Currently playing ");
            System.out.println(itr.next());
            isForward = true;
        }
        else {
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Enter your choice");
        printMenu();

        boolean quit = false;
        while (!quit) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (isForward == false) {
                        itr.next();
                        isForward = true;
                    }
                    if (itr.hasNext()) {
                        System.out.println("Now playing " + itr.next());
                    }
                    else {
                        System.out.println("You have reached the end of the playlist");
                        isForward = false;
                    }
                    break;
                case 2:
                    if(isForward == true) {
                        itr.previous();
                        isForward = false;
                    }
                    if (itr.hasPrevious()) {
                        System.out.println("Now playing " + itr.previous());
                    }
                    else {
                        System.out.println("You are at the start of playlist");
                        isForward = true;
                    }
                    break;
                case 3:
                    if (isForward == true) {
                        if (itr.hasPrevious()) {
                            System.out.println("Now playing " + itr.previous());
                            isForward = false;
                        } else {
                            System.out.println("Song doesn't exist");
                        }
                    }
                    else {
                        if (itr.hasNext()) {
                            System.out.println("Now playing " + itr.next());
                            isForward = true;
                        }
                        else {
                            System.out.println("Song is not present");
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    if (playList.size() > 0) {
                        itr.remove();
                        if(itr.hasNext()) {
                            System.out.println("Now playing " + itr.next());
                        }
                        else {
                            if (itr.hasPrevious()) {
                                System.out.println("Now playing " + itr.previous());
                            }
                        }
                    }
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    public static void printSongs(LinkedList<Song> playList) {
        for (Song song : playList) {
            System.out.println(song);
        }
        return;
    }

    public static void printMenu() {
        System.out.println("1 - Play next song");
        System.out.println("2 - Play previous song");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in playlist");
        System.out.println("7 - Exit");
    }
}