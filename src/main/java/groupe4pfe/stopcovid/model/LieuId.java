package groupe4pfe.stopcovid.model;

import java.io.Serializable;
import java.util.Objects;

public class LieuId implements Serializable{
    private Etablissement etablissement;

    private Long lieu;

    public LieuId(){}

    public LieuId(Etablissement etablissement, Long lieu) {
        this.etablissement = etablissement;
        this.lieu = lieu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LieuId lieuId = (LieuId) o;
        return Objects.equals(etablissement, lieuId.etablissement) &&
                Objects.equals(lieu, lieuId.lieu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(etablissement, lieu);
    }

}
