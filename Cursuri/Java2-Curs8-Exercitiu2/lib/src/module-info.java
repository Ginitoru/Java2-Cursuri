module lib {
    requires java.desktop;
    requires transitive java.rmi;
    exports lib.api;
    exports lib.dto;

}