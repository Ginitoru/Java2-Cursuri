package lib.dto;

import java.io.Serializable;

public class AdresaDto implements Serializable {

    private final String Strada;

    private final String numar;


    public AdresaDto(String strada, String numar) {
        Strada = strada;
        this.numar = numar;
    }


    public String getStrada() {
        return Strada;
    }

    public String getNumar() {
        return numar;
    }
}
