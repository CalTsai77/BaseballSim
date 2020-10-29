package cschacks;

import cschacks.frontend.FrontEnd;
import cschacks.backend.BackEnd;

public class Main {
    public static void main(String[] args) {
        FrontEnd f = new FrontEnd();
        BackEnd b = new BackEnd();
        f.showField();
        f.showMenu();
    }
}