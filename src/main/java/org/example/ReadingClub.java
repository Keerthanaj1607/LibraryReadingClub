package org.example;
import java.util.ArrayList;
import java.util.List;


public class ReadingClub {
    private String clubName;
    private List<Reader> members;

    public ReadingClub(String clubName) {
        this.clubName = clubName;
        this.members = new ArrayList<>();
    }

    public void addMember(Reader reader) {
        members.add(reader);
    }

    public List<Reader> getMembers() {
        return members;
    }
}

