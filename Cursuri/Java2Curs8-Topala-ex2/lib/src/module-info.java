module lib {

    requires transitive java.rmi;
    exports lib.service;
    exports lib.event;
    exports lib.model;
}